#!/usr/bin/env python3
"""Compare SpotBugs results between two checkouts of org.hl7.fhir.core.

Usage: spotbugs_diff.py <base-tree> <head-tree>

Reads <tree>/*/target/spotbugsXml.xml in each tree and matches issues by
(type, instanceHash). The hash is stable across line shifts. Prints a
markdown report of per-module counts, then the new and removed issues.
"""
import sys
# Input is SpotBugs output built locally, not untrusted XML; the stdlib parser does not
# resolve external entities, so defusedxml is not needed.
import xml.etree.ElementTree as ET
from pathlib import Path


def load(tree):
    """Return {module: {(type, instanceHash): issue}} for one tree."""
    root = Path(tree)
    results = {}
    for xml in sorted(root.glob("*/target/spotbugsXml.xml")):
        module = xml.parent.parent.name
        issues = {}
        for bug in ET.parse(xml).getroot().iter("BugInstance"):
            cls = bug.find("Class")
            method = bug.find("Method")
            line = bug.find("SourceLine")  # direct child = primary location
            key = (bug.get("type"), bug.get("instanceHash"))
            issues[key] = {
                "type": bug.get("type"),
                "rank": int(bug.get("rank", "99")),
                "priority": bug.get("priority", ""),
                "class": cls.get("classname") if cls is not None else "?",
                "method": method.get("name") if method is not None else "",
                "line": line.get("start", "") if line is not None else "",
                "source": line.get("sourcepath", "") if line is not None else "",
            }
        results[module] = issues
    return results


def row(module, i):
    loc = i["class"] + ("." + i["method"] if i["method"] else "")
    src = i["source"] + (":" + i["line"] if i["line"] else "")
    return f"| {i['rank']} | {module} | {i['type']} | `{loc}` | {src} |"


def main():
    if len(sys.argv) != 3:
        sys.exit(__doc__)
    base, head = load(sys.argv[1]), load(sys.argv[2])
    if not base or not head:
        sys.exit("No */target/spotbugsXml.xml found in "
                 + (sys.argv[1] if not base else sys.argv[2]))

    modules = sorted(set(base) | set(head))
    new, removed = [], []
    print("| Module | Base | Head | New | Removed |\n|---|---|---|---|---|")
    for m in modules:
        b, h = base.get(m), head.get(m)
        if b is None or h is None:
            side = "base" if b is None else "head"
            print(f"| {m} | {len(b) if b is not None else '—'} | "
                  f"{len(h) if h is not None else '—'} | not analysed on {side} | |")
            continue
        n = [(m, h[k]) for k in h.keys() - b.keys()]
        r = [(m, b[k]) for k in b.keys() - h.keys()]
        new += n
        removed += r
        print(f"| {m} | {len(b)} | {len(h)} | {len(n)} | {len(r)} |")

    for title, items in (("New issues", new), ("Removed issues", removed)):
        print(f"\n## {title} ({len(items)})\n")
        if not items:
            print("None.")
            continue
        print("| Rank | Module | Type | Class.method | Source:line |\n|---|---|---|---|---|")
        for m, i in sorted(items, key=lambda x: (x[1]["rank"], x[0], x[1]["class"])):
            print(row(m, i))

    missing = [m for m in modules if m not in base or m not in head]
    if missing:
        print("\n**Coverage gap:** no results on one side for: " + ", ".join(missing)
              + ". Check the Maven log for that module (build failure or SpotBugs timeout).")


if __name__ == "__main__":
    main()

# FHIR package signing — design and decisions (Nov 2026)

How FHIR NPM packages are signed and checked across the IG Publisher (igpub), org.hl7.fhir.core and FHIRsmith, plus the package-reading hardening done alongside. Status: built and uncommitted at the time of writing (core, igpub, FHIRsmith), except where noted as deferred.

Note that this whole system of signing should be regarded as under development; the community is still developing
tools, policies, and practices to make use of signatures, and given the typically workflow involves running 
on a local machine, it's not clear what signing even achieves. 

The system may be changed and all signatures regenerated at any time in the future.

## Two kinds of signature

| | npm registry signatures | Publisher signatures |
|---|---|---|
| Who signs | the package server (FHIRsmith packages module) | the publisher (IG Publisher pipeline, PackageReleaser, TemplateReleaser) |
| What it proves | the registry served these bytes | the holder of the publisher's key published these bytes |
| Format | npm's own: `dist.signatures`, ECDSA P-256 over `{name}@{version}:{integrity}`, `dist.integrity` sha512 SRI | Sigstore bundle v0.3 partner file, `{package}.tgz.sigstore.json` |
| Keys | `/-/npm/v1/keys` on the server; key file auto-created next to the DB (`npmSigning.keyFile`) | `packageSigningKey` in fhir-settings.json (path to a PEM); never auto-created |
| Checked by | `npm audit signatures` | FHIRsmith crawler; `NpmPackageSigner.verify` in Java (not yet wired into loaders) |

Publisher signatures are **not** npm provenance. npm provenance (`dist.attestations`) needs a Fulcio certificate from a CI OIDC identity and a Rekor transparency-log entry; npm's client rejects anything else, so FHIRsmith publishes publisher signatures as `dist.fhir-signature` (`url`, `status`, `keyid`) instead, with the bundle served at `/packages/-/fhir/v1/signatures/{name}@{version}`.

## Publisher signature format

- Partner file next to the package: `package.tgz` → `package.tgz.sigstore.json`.
- Sigstore bundle v0.3 (`application/vnd.dev.sigstore.bundle.v0.3+json`), DSSE envelope, payload type `application/vnd.in-toto+json`.
- Payload: in-toto Statement v1 with one subject — name `pkg:npm/{name}@{version}` (scope `@` as `%40`), digest `sha512` of the .tgz bytes (hex) — and `predicateType` `http://hl7.org/fhir/package-signature/v1`; predicate holds `tool` and `signedAt` (the signer's claim, not a trusted time).
- Signature: ECDSA P-256 / SHA-256 (DER) over the DSSE PAE: `DSSEv1 {len(type)} {type} {len(body)} {body}`.
- Key id: `SHA256:` + base64(sha256(SubjectPublicKeyInfo DER)), as npm names keys; in `verificationMaterial.publicKey.hint` and each signature's `keyid`. No tlog entries, so general Sigstore tools won't accept the bundle as is.
- A signature is over the bytes: a package that is unpacked and repacked is no longer signed.
- Feeds link signatures with `<fhir:signature>{url}</fhir:signature>` on the item (FeedBuilder, PackageFeedUpdater, PackageReleaser/TemplateReleaser; CRLF preserved).

## Keys and trust

- Signing key: EC P-256 PEM (PKCS#8 or SEC1) at the path in fhir-settings.json `packageSigningKey`. No passphrase (refused by design). The public key is **read from the key file** — openssl writes it in both formats; a file without one (as Java's own encoding produces) is refused, as is one whose public key isn't the private key's. Make keys with `openssl ecparam -name prime256v1 -genkey -noout -out key.pem`.
- A configured key that is missing or unusable stops the build: a signing pipeline must not quietly publish unsigned packages.
- Trust lives in the package registry, ig-registry `package-feeds.json`, per feed: `feeds[].signing = { required, keys: [{ keyid, key, expires }] }` (`key` = base64 SPKI DER). No well-known file on the publishing server.
- **Keys are scoped (review S3).** A feed's key is trusted only for the packages that feed may publish: if the first `package-restrictions` mask matching the package id lists the feed, yes; if no restriction matches, any feed may. Java: `NpmPackageSigner.keysFromRegistry(packageFeeds)`; `SigningKey.forPackages(id, key, masks...)` for an explicit allow-list; `new SigningKey(id, key)` trusts a key for anything. FHIRsmith gets the same effect by checking signatures per feed after its restriction check.

## What verify does (Java `NpmPackageSigner.verify`, FHIRsmith `verifyPackageSignature`)

Java `verify(tgz, bundle, keys)` **does not open the package** (review S1, S2, S6): it is a hash and a signature check over the bytes.

1. Bundle media type, DSSE envelope, in-toto payload type.
2. Statement `_type` is in-toto v1 and `predicateType` is the FHIR package-signature predicate (review S5 — another statement made with the same key, e.g. SLSA provenance, is refused; FHIRsmith checks this too).
3. A subject whose sha512 is the bytes'; its purl gives the name and version.
4. A signature by a listed key that verifies **and** is trusted for that package name.
5. Returns the name and version the signature claims. **The caller compares them with the package it is actually using** — `verify(..., name, version)` does that comparison. Only the loader knows which package.json it will use.

FHIRsmith's verifier takes the name and version from the caller (the feed item / package.json the crawler already checked) and also checks a key's `expires` against the publish time.

Signing: `sign(File, name, version, tool)` doesn't open the package; the publisher's own package, the releasers and withdrawal packages use it. `sign(File, tool)` reads package.json (capped at 1 MB, and within the unpacked-size limit) — used for the other packages in a build's output and by the bulk tool.

## Where signing happens

- IG Publisher build (`PublisherGenerator.signPackages`): every .tgz in the output, after all packages are final; stale signatures removed first.
- `PublicationProcess`: the signature is copied with the package; withdrawal packages are signed too.
- `PackageReleaser`, `TemplateReleaser`: sign at release, add `fhir:signature` to the feed.
- Bulk: `-sign-packages [-key pem] [-dry-run] [-map url=folder] folders` (`PackageSigningUpdater`) signs existing .tgz files in web folders, then updates their package-feed.xml. Run Nov 2026 over the HL7 web folders (≈2,300 packages).

## FHIRsmith

- Registry signatures: `npmSigning` (on by default); stored in `PackageDist`; existing versions backfilled in the background at startup; `/-/npm/v1/keys` is a 404 until the backfill finishes.
- Crawler `crawler.signatures`: `ignore` | `check` (default; failures logged, package stored unless the feed says `signing.required`) | `require` (feeds without keys aren't read; unsigned or badly signed packages refused). Production runs `check`.
- Each signature is stored as fetched in `PackageSignatures`, with the result; packages already held are checked against their stored bytes when their feed first carries a signature.
- HTML package lists show confirmed / rejected / absent; `/packages/feed-check` dry-runs a feed (SSRF-guarded, one at a time; signing info can be supplied as JSON) and reports each item's signature.

## Package-reading hardening (done alongside)

Applies everywhere a package is unpacked: Java `NpmPackage` (tgz into memory, tgz to disk, zip), `NpmPackageVersionConverter`; FHIRsmith crawler, package manager (tx), npm projector. `npm-check` reports these as failed checks instead of refusing.

- **Size:** a package may unpack to at most 1.5 GB (`NpmPackage.DEFAULT_MAX_LOAD_SIZE`, `library/package-limits.js`, crawler `maxUnpackedMB` default 1536). Largest real package: us.nlm.vsac#0.18.0, 1.25 GB unpacked (96 MB as a .tgz).
- **Duplicate names:** refused after normalisation — `\` as `/`, runs of `/` collapsed, `.` segments and leading `/` dropped, Unicode NFC, case ignored (`NpmPackage.entryNameKey`, `library/package-names.js`). Readers disagree on which copy wins (FHIRsmith and Java keep the last, a stop-at-first reader keeps the first), so a package with two package.json files could be two different packages.
- **`..` segments** (with `/` or `\`) refused (`NpmPackage.checkEntryPath`); throws IOException. `Patient-a..b.json` is fine.
- The FHIRsmith package manager now extracts into a temporary folder and renames it into place, so a failed extraction leaves nothing `checkCache` would take for the package.
- **Generators:** `NPMPackageGenerator` (services, r5, r4b, r4) fails the build on a name that is the same file to some systems as one already added (`PackageEntryNames`); an exact repeat is still a warning. Folder-loaded files use `/` on Windows. The publisher already stops a build that generates two outputs differing only by case (`checkMakeFile`).
- Scan, Nov 2026: 2,048 HL7 .tgz in the web folders — clean. Local copy of the registry DB (5,000 versions, capped) — no case or `..` problems; 5 packages with exact duplicate names, mostly with different contents: `vzvz.fhir.mitz#3.8.0`, `vzvz.fhir.aof#0.16.1`, `vzvz.fhir.nl-vzvz-core#0.3.4`, `koppeltaalv2.00#0.14.0-beta.12/13`. VZVZ told. These are now refused by the readers.

## Deferred

- Requiring signed packages and checking signatures in Java clients: loader policy ignore/check/require (S4), verify at download time and store the result (S11), `expires` against a trusted publish time (S10). In FHIRsmith, check whether `expires` is compared with the feed date or with first-seen time (first-seen is the one the signer can't influence).
- Signing-related RELEASE_NOTES entries in core.
- Duplicate-name checks on packages loaded from already-unpacked folders.

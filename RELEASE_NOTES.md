## Validator Changes

* no changes

## Other code changes

* Bundle renderer: render the narrative of each entry with its top heading at h3, so a nested document Bundle no longer pushes the headings of the other entries one level too deep (HL7/fhir-ig-publisher#1404)
* ConceptMap renderer: in maps between StructureDefinitions, link element ids with [x] to the _x_ anchors of the structure tables, and show the element types instead of 'todo' (HL7/fhir-ig-publisher#1405)

## Validator Changes

* Add support for "Obligation Profiles" (see https://chat.fhir.org/#narrow/stream/179177-conformance/topic/Proposed.20new.20Profile.20features)
* Adjust slice min/max checking to ignore type slices (rules are different in this case)
* Properly handle validating mime/type when terminology server is not available

## Other code changes

* Rework Pipelines - more stability and quicker
* Fix bug where elementmodel.Element.copy() didn't clone children. Users of the Element Model (not the normal model) should check all uses of copy. (Only known users are Validator + IG publisher)
* Add nimbus & ZXing to core library dependencies for forthcoming improved SHC/SHL support 

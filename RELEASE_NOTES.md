## Validator Changes

* update FHIRPath implementation for corrections to 'as' (R5 only in validator)
* Critical Security fix: enforce correct paths when unpacking archives (SecurityAdvisory-1082, CVE TBA)

## Other code changes

* Update to latest FHIRPath for older versions 
* Add new ElementModel based parser for StructureMaps
* go-publish related changes
* FTP Client upload and logging improvements
* Refactor base64 handling for Android compatibility

## Security Note

The validator unzips archive files to the local file system when 
it is scanning zip files it has been asked to validate, and when it is
installing packages. These processes are now resistant to the zip-slip
vulnerability.
# Security Policy

## Supported Versions

Only new releases of this project will contain security updates. All clients should use the latest version of this project in their dependencies. There is no process in place to backport security fixes to previous releases. If you require a backport, please [create an issue](../../issues/new/choose) containing an explanation of why the latest version cannot be used.

## Signed Releases

As of version 6.6.0, release assets excluding compressed source code are signed with a `*.asc` signature file for verification. This file is available [here](https://hl7.github.io/assets/keys/public.pgp) and also on the [Ubuntu keyserver](https://keyserver.ubuntu.com/pks/lookup?search=85D1C17CF1152107B272386C8FDFA68281399B5D&fingerprint=on&op=index)

## Reporting Vulnerabilities

Please report all potential security vulnerabilities using the [Report a vulnerability](../../security/advisories/new) button in the [Security](../../security) section of this repository. 

# Developer Notes

## Local Filesystem

The main use of the local file system for the core library (other than the validator - see below) is for the 
[NPM package cache](https://confluence.hl7.org/display/FHIR/FHIR+Package+Cache). The default location and content
is as specified in the FHIR specification, but you can choose where this goes if you want, or provide your own 
NPM package cache manager. However there are other uses of the local file system scattered throughout the code, 
particularly in the test cases.

All access to the local file system runs through the class ManagedFileAccess. You can 
set the static features of this class to completely cut the library off from the 
local filesystem, or provide your own file system accessor, or limit the files accessed
to particular sub-directories. See ManagedFileAccess for details.

Note that libraries that this library depends on still access the filesystem directly. Review
of the use of these libraries is ongoing.

Dependency Notes:
 SQLite: This library uses the SQLite library for database access. SQLite accesses the files directly, 
   but the file is always touched using ManagedFileAccess to ensure that access is not denied before 
   being used 
   
Validator: The validator CLI also accesses local files as specified in the command line parameters, 
and runs in the user context. TODO: we are considering whether to support a command line parameter 
restricting path access to particular directories.

## Network access

The library will access the web to download needed collateral, or to access terminology resources or servers.
All access is by http(s) using the httpok library, and is controlled by the class ManagedWebAccess. You can 
set the static features of this class to completely cut the library off from the  web, or provide your own 
web accessor, or limit the web resources accessed to particular domains or sub-domains. See ManagedWebAccess 
for details.

Note that for legacy reasons, network access can also be prohibited using 
FhirSettings.setProhibitNetworkAccess(), but this is deprecated.

Note that libraries that this library depends on may still access the network directly. Review
of the use of these libraries is ongoing.

Validator: The validator CLI accesses the web to download packages and make use of the
terminology server, which defaults to https://tx.fhir.org.

## Logging 

todo

## Terminology Server Access

todo

## Cryptography 

Other than the https client, the library doesn't have any crypto functions in it. 

TODO: Actually, it does, reading SHCs 


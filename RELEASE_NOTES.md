## Validator Changes

* The terminology ecosystem coordination server (tx-reg) is now independent of the terminology server: by default it is https://ecosystem.hl7.org/tx-reg (configurable as txEcosystem in fhir-settings.json), and the new -ecosystem parameter nominates a different one ('n/a' for none). As before, nominating a terminology server with -tx turns the ecosystem off unless -ecosystem is given too, and -tx n/a turns both off

## Other code changes

* no changes

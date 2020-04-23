import {SnomedVersion} from '../enums/SnomedVersion.js';
import {Locale} from '../enums/Locale.js';

export class CliContext {
    constructor(){
        this.doNative = false;
        this.anyExtensionsAllowed = true;
        this.hintAboutNonMustSupport = false;
        this.recursive = false;
        this.doDebug = false;
        this.assumeValidRestReferences = false;
        this.canDoNative = false;

        this.map = null;
        this.output = null;
        this.txServer = "http://tx.fhir.org";
        this.sv = "current";
        this.txLog = null;
        this.mapLog = null;
        this.lang = null;
        this.fhirpath = null;
        this.snomedCT = SnomedVersion.ES.value;
        this.targetVer = null;

        this.igs = [];
        this.questionnaires = [];
        this.profiles = [];
        this.sources = [];

        this.locale = Locale.ENGLISH.value;

        this.locations = new Map();
    }
}

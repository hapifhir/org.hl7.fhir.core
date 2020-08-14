import {FhirFormat} from '../enums/FhirFormat.js';

export class FileInfo {
    constructor(fileName, fileContent, type){
        this.fileName = fileName;
        this.fileContent = fileContent;
        if (type.includes('json')) {
          this.fileType = FhirFormat.JSON.extension;
        } else if (type.includes('xml')) {
          this.fileType = FhirFormat.XML.extension;
        }
    }
}

import {CliContext} from './CliContext.js';

export class ValidationRequest {
    constructor(){
        this.cliContext = new CliContext();
        this.filesToValidate = [];
    }
}

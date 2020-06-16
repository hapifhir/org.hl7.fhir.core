import {CliContext} from './model/CliContext.js';
import {ValidationRequest} from './model/ValidationRequest.js';
import {FileInfo} from './model/FileInfo.js';
import {FhirFormat} from './enums/FhirFormat.js';
import {IssueSeverity} from './enums/IssueSeverity.js';

/*
  <Constants>
*/

// Icon Constants
const jsonIcon = './assets/json-svgrepo-com.svg';
const xmlIcon = './assets/xml-svgrepo-com.svg';

// HTML classes
const CLASS_LIST_ITEM_PLAIN = "list-group-item";
const CLASS_LIST_ITEM_FATAL = "list-group-item list-group-item-dark";
const CLASS_LIST_ITEM_ERROR = "list-group-item list-group-item-danger";
const CLASS_LIST_ITEM_WARNING = "list-group-item list-group-item-warning";
const CLASS_LIST_ITEM_INFORMATION = "list-group-item list-group-item-info";

// HTML IDs
const ID_FILE_ENTRY_TEMPLATE = '#file_entry_template';
const ID_FILE_ENTRY_NAME = 'file_entry_name_field';
const ID_FILE_ENTRY_ICON = 'file_entry_type_icon';
const ID_FILE_ENTRY_DELETE_BUTTON = 'file_entry_delete_button';
const ID_FILE_ENTRY_FILE_LIST = 'file_entry_file_list';
const ID_FILE_ENTRY_OUTCOME_LIST = 'file_entry_outcome_list';
const ID_FILE_ENTRY_COLLAPSE_SECTION = 'file_entry_collapse_section';

/*
  </Constants>
*/

// Data Fields
const cli = new CliContext();
const filesToValidate = [];

document.getElementById('validate_button').addEventListener("click", validateCurrentFiles);
document.getElementById('files').addEventListener('change', handleFileSelect, false);

// File reading
function handleFileSelect(evt) {
  var files = evt.target.files;
  var output = [];
  for (var i = 0, f; f = files[i]; i++) {
    generateFileEntry(f);
    // Check for proper file type here
    console.log(f.type);
  }
}

function generateFileEntry(file) {
  var fr = new FileReader();
  fr.onload = function(e) {
    // TODO there may be timing issues here
    filesToValidate.push(new FileInfo(file.name, e.target.result, file.type));
    document.getElementById(ID_FILE_ENTRY_FILE_LIST).appendChild(generateNewFileListItemFromTemplate(file, filesToValidate.length - 1));
  };
  fr.readAsText(file);
}

// File List Template Generation

function generateNewFileListItemFromTemplate(file, index) {
  var template = document.querySelector(ID_FILE_ENTRY_TEMPLATE);
  var clone = template.content.cloneNode(true);

  // Add file name
  clone.getElementById(ID_FILE_ENTRY_NAME).textContent = file.name;

  // Add appropriate icon for filetype
  if (file.type.includes(FhirFormat.JSON.extension)) {
    clone.getElementById(ID_FILE_ENTRY_ICON).src = jsonIcon;
  } else if (file.type.includes(FhirFormat.XML.extension)) {
    clone.getElementById(ID_FILE_ENTRY_ICON).src = xmlIcon;
  }

  clone.getElementById(ID_FILE_ENTRY_COLLAPSE_SECTION).setAttribute("id", (ID_FILE_ENTRY_COLLAPSE_SECTION + index));
  clone.getElementById(ID_FILE_ENTRY_NAME).setAttribute("aria-controls", (ID_FILE_ENTRY_COLLAPSE_SECTION + index));
  clone.getElementById(ID_FILE_ENTRY_NAME).setAttribute("data-target", ('#' + ID_FILE_ENTRY_COLLAPSE_SECTION + index));

  // Add delete listener
  clone.getElementById(ID_FILE_ENTRY_DELETE_BUTTON).addEventListener("click", handleDeleteOnFileList);

  return clone;
}

function addIssueToFileEntryList(index, severity, details) {
  var ul = document.getElementById(ID_FILE_ENTRY_FILE_LIST);
  var listItems = ul.children;
  var fileEntry = listItems[index];
  console.log(fileEntry);
  var listOfIssues = fileEntry.querySelector('#' + ID_FILE_ENTRY_OUTCOME_LIST);
  var issueItem = createIssueListItem(severity, details);
  listOfIssues.appendChild(issueItem);
}

function createIssueListItem(severity, details) {
  var newIssue = document.createElement('li');
  switch(severity) {
    case IssueSeverity.FATAL.code:
      newIssue.setAttribute("class", CLASS_LIST_ITEM_FATAL);
      break;
    case IssueSeverity.ERROR.code:
      newIssue.setAttribute("class", CLASS_LIST_ITEM_ERROR);
      break;
    case IssueSeverity.WARNING.code:
      newIssue.setAttribute("class", CLASS_LIST_ITEM_WARNING);
      break;
    case IssueSeverity.INFORMATION.code:
      newIssue.setAttribute("class", CLASS_LIST_ITEM_INFORMATION);
      break;
    default:
      console.error('Passed in bad severity: ' + severity);
  }
  newIssue.innerHTML = details;
  return newIssue;
}

function handleDeleteOnFileList(e) {
  var li = e.target.closest('li');
  var nodes = Array.from( li.closest('ul').children );
  var index = nodes.indexOf( li );
  nodes[index].remove();
  filesToValidate.splice((index - 1), 1);
  console.log('Index -> ' + index);
  console.log(filesToValidate);
}

// Validation
function validateCurrentFiles() {
    sendFilesToValidate(filesToValidate);
}

function sendFilesToValidate(arrayOfFileInfo) {
  var req = new ValidationRequest();
  req.filesToValidate = arrayOfFileInfo;

  var xhr = new XMLHttpRequest();
  xhr.open("POST",  '/validate', true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(JSON.stringify(req));

  xhr.onload = function () {
      const response = '{"outcomes": [{"fileInfo": {"fileName": "account-example.canonical.json", "fileType": "JSON"}, "issues": [{"severity": "Error", "details": "\"null\""}, {"severity": "Error", "details": "Profile http://hl7.org/fhir/StructureDefinition/Account, Element: minimum required = 1, but only found 0"}]}, {"fileInfo": {"fileName": "account-example(example).xml", "fileType": "XML"}, "issues": []}]}';
      var test = xhr.responseText;
      processValidationResponse(JSON.parse(JSON.parse(xhr.responseText)));
  };
}

function processValidationResponse(validationResponse) {
  console.log(validationResponse);
  console.log(validationResponse.length);
  console.log(validationResponse.outcomes);
  console.log(validationResponse.outcomes.length);

  for (var i = 0; i < validationResponse.outcomes.length; i++) {
    console.log(validationResponse.outcomes[i]);
    var fileInfo = validationResponse.outcomes[i].fileInfo;
    var issues = validationResponse.outcomes[i].issues;
    issues.forEach(issue => {
      console.log(issue);
      addIssueToFileEntryList(i, issue.severity, issue.details);
    });
  }

}




// window.onload = function loadCliContext() {
//   var xhr = new XMLHttpRequest();
//   xhr.open("GET", 'http://localhost:8080/currentContext');
//   xhr.send();
//   xhr.onreadystatechange = function() {
//     if (this.readyState == 4 && this.status == 200) {
//       console.log(xhr.responseText);
//     }
//   }
// }

// /*
//   Escape JSON
// */
// var escapeJSON = exports.escapeJSON = function(json) {
//   var escapable = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g;
//   var meta = {    // table of character substitutions
//               '\b': '\\b',
//               '\t': '\\t',
//               '\n': '\\n',
//               '\f': '\\f',
//               '\r': '\\r',
//               '"' : '\\"',
//               '\\': '\\\\'
//             };
//
//   escapable.lastIndex = 0;
//   return escapable.test(json) ? '"' + json.replace(escapable, function (a) {
//       var c = meta[a];
//       return (typeof c === 'string') ? c
//         : '\\u' + ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
//   }) + '"' : '"' + json + '"';
//
// };

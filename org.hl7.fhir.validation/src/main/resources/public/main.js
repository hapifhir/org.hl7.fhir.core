import {CliContext} from './model/CliContext.js';
import {ValidationRequest} from './model/ValidationRequest.js';
import {FileInfo} from './model/FileInfo.js';

// Constants
const jsonIcon = './assets/json-svgrepo-com.svg';
const xmlIcon = './assets/xml-svgrepo-com.svg';

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
    document.getElementById('loaded_file_list').appendChild(generateNewFileListItemFromTemplate(file));
  };
  fr.readAsText(file);
}

// File List Template Generation

function generateNewFileListItemFromTemplate(file) {
  var template = document.querySelector('#loaded_file_entry');
  var clone = template.content.cloneNode(true);

  // Add file name
  clone.getElementById('file_name_field').textContent = file.name;

  // Add appropriate icon for filetype
  if (file.type.includes("json")) {
    clone.getElementById('file_type_icon').src = jsonIcon;
  } else if (file.type.includes("xml")) {
    clone.getElementById('file_type_icon').src = xmlIcon;
  }

  // Add delete listener
  clone.getElementById("delete_button").addEventListener("click", handleDeleteOnFileList);

  return clone;
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
  xhr.open("POST", 'http://localhost:8080/' + 'validate', true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(JSON.stringify(req));

  xhr.onload = function () {
      const response = '{"outcomes": [{"fileInfo": {"fileName": "account-example.canonical.json", "fileType": "JSON"}, "issues": [{"severity": "Error", "details": "\"null\""}, {"severity": "Error", "details": "Profile http://hl7.org/fhir/StructureDefinition/Account, Element: minimum required = 1, but only found 0"}]}, {"fileInfo": {"fileName": "account-example(example).xml", "fileType": "XML"}, "issues": []}]}';
      var test = xhr.responseText;
      processValidationResponse(JSON.parse(JSON.parse(xhr.responseText)));
  };
}

function processValidationResponse(validationResponse) {
  console.log(validationResponse.outcomes[0]);
  console.log(validationResponse.outcomes[1]);
    //console.log(validationResponse);
    //Do something
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

package org.hl7.fhir.dstu2016may.utils;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu2016may.formats.XmlParser;
import org.hl7.fhir.dstu2016may.metamodel.Element;
import org.hl7.fhir.dstu2016may.metamodel.Manager;
import org.hl7.fhir.dstu2016may.metamodel.Manager.FhirFormat;
import org.hl7.fhir.dstu2016may.model.Bundle;
import org.hl7.fhir.dstu2016may.model.StructureMap;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class Transformer {

	private String txServer;
	private String definitions;
	private List<String> folders = new ArrayList<String>();
	private String source;
	private String mapUri;
	private String output;
	private String message;
	private StructureMapUtilities scu;

	public String getTxServer() {
		return txServer;
	}
	public void setTxServer(String txServer) {
		this.txServer = txServer;
	}
	public String getDefinitions() {
		return definitions;
	}
	public void setDefinitions(String definitions) {
		this.definitions = definitions;
	}
	public List<String> getFolders() {
		return folders;
	}

	public void addFolder(String value) {
		folders.add(value);
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}





	public String getMapUri() {
		return mapUri;
	}
	public void setMapUri(String mapUri) {
		this.mapUri = mapUri;
	}
	public boolean process() {
		try {
	    System.out.println("  .. load definitions from "+definitions);
			IWorkerContext context = SimpleWorkerContext.fromPack(definitions);
			scu = new StructureMapUtilities(context, new HashMap<String, StructureMap>(), null);

			for (String folder : folders) {
		    System.out.println("  .. load additional definitions from "+folder);
				((SimpleWorkerContext) context).loadFromFolder(folder);
				loadMaps(folder);
			}
	    System.out.println("  .. load source from "+source);
			Element e = Manager.parse(context, new FileInputStream(source), FhirFormat.XML);

			Bundle bundle = new Bundle();
			StructureMap map = scu.getLibrary().get(mapUri);
			if (map == null)
				throw new Error("Unable to find map "+mapUri+" (Known Maps = "+Utilities.listCanonicalUrls(scu.getLibrary().keySet())+")");
			scu.transform(null, e, map, bundle);
			new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(output), bundle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			return false;
		} 
	}
	
	private void loadMaps(String folder) {
		for (String f : new File(folder).list()) {
			try {
				StructureMap map = scu.parse(TextFile.fileToString(Utilities.path(folder, f)));
				scu.getLibrary().put(map.getUrl(), map);
			} catch (Exception e) {
			}
		}

	}
	public String getMessage() {
		return message;
	}


}
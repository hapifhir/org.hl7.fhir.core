package org.hl7.fhir.r5.utils.formats;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.FloatControl.Type;

import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Resource;

public class ResourceFolderVisitor {

  public interface IResourceObserver {
    public boolean visitResource(String filename, Resource resource);
  }
  
  private IResourceObserver observer;
  private List<String> types = new ArrayList<>();

  public ResourceFolderVisitor(IResourceObserver observer) {
    super();
    this.observer = observer;
  }
  
  public ResourceFolderVisitor(IResourceObserver observer, String... types) {
    super();
    this.observer = observer;
    for (String t : types) {
      this.types.add(t);
    }
  }
  

  public void visit(String folder) {
    visit(new File(folder));
  }
  
  public void visit(File file) {
    for (File f : file.listFiles()) {
      if (f.isDirectory()) {
        visit(f);
      } else if (f.getName().endsWith(".xml")) {
        try {
          Resource res = new XmlParser().parse(new FileInputStream(f));
          if (types.isEmpty() || types.contains(res.fhirType())) {
            if (observer.visitResource(f.getAbsolutePath(), res)) {
              new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f), res); 
            }
          }
        } catch (Exception e) {
        }
      } else if (f.getName().endsWith(".json")) {
        try {
          Resource res = new JsonParser().parse(new FileInputStream(f));
          if (types.isEmpty() || types.contains(res.fhirType())) {
            if (observer.visitResource(f.getAbsolutePath(), res)) {
             new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(f), res);
            }
          }
        } catch (Exception e) {
        }
      }
    }    
  }

  
}

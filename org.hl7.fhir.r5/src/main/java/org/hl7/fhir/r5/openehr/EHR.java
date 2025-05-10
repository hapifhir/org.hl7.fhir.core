package org.hl7.fhir.r5.openehr;


/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.r5.openehr.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * The EHR object is the root object and access point of an EHR for a subject of care.
 */
@DatatypeDef(name="EHR")
public class EHR extends Any implements ICompositeType {

    /**
     * The identifier of the logical EHR management system in which this EHR was created.
     */
    @Child(name = "system_id", type = {HIER_OBJECT_ID.class}, order=0, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The identifier of the logical EHR management system in which this EHR was created", formalDefinition="The identifier of the logical EHR management system in which this EHR was created." )
    protected List<HIER_OBJECT_ID> system_idList;

    /**
     * The unique identifier of this EHR. NOTE: it is strongly recommended that a UUID always be used for this field.
     */
    @Child(name = "ehr_id", type = {HIER_OBJECT_ID.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The unique identifier of this EHR", formalDefinition="The unique identifier of this EHR. NOTE: it is strongly recommended that a UUID always be used for this field." )
    protected HIER_OBJECT_ID ehr_id;

    /**
     * List of contributions causing changes to this EHR. Each contribution contains a list of versions, which may include references to any number of VERSION instances, i.e. items of type VERSIONED_COMPOSITION and VERSIONED_FOLDER.
     */
    @Child(name = "contributions", type = {OBJECT_REF.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="List of contributions causing changes to this EHR", formalDefinition="List of contributions causing changes to this EHR. Each contribution contains a list of versions, which may include references to any number of VERSION instances, i.e. items of type VERSIONED_COMPOSITION and VERSIONED_FOLDER." )
    protected List<OBJECT_REF> contributionsList;

    /**
     * Reference to EHR_STATUS object for this EHR.
     */
    @Child(name = "ehr_status", type = {OBJECT_REF.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to EHR_STATUS object for this EHR", formalDefinition="Reference to EHR_STATUS object for this EHR." )
    protected OBJECT_REF ehr_status;

    /**
     * Reference to EHR_ACCESS object for this EHR.
     */
    @Child(name = "ehr_access", type = {OBJECT_REF.class}, order=4, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to EHR_ACCESS object for this EH", formalDefinition="Reference to EHR_ACCESS object for this EHR." )
    protected OBJECT_REF ehr_access;

    /**
     * Master list of all Versioned Composition references in this EHR.
     */
    @Child(name = "compositions", type = {OBJECT_REF.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Master list of all Versioned Composition references in this EHR", formalDefinition="Master list of all Versioned Composition references in this EHR." )
    protected List<OBJECT_REF> compositionsList;

    /**
     * Optional directory structure for this EHR. If present, this is a reference to the first member of folders.
     */
    @Child(name = "directory", type = {OBJECT_REF.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional directory structure for this EHR. If present, this is a reference to the first member of folders", formalDefinition="Optional directory structure for this EHR. If present, this is a reference to the first member of folders." )
    protected OBJECT_REF directory;

    /**
     * Time of creation of the EHR.
     */
    @Child(name = "time_created", type = {DV_DATE_TIME.class}, order=7, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Time of creation of the EHR", formalDefinition="Time of creation of the EHR." )
    protected DV_DATE_TIME time_created;

    /**
     * Optional additional Folder structures for this EHR. If set, the directory attribute refers to the first member
     */
    @Child(name = "folders", type = {OBJECT_REF.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Optional additional Folder structures for this EHR", formalDefinition="Optional additional Folder structures for this EHR. If set, the directory attribute refers to the first member" )
    protected List<OBJECT_REF> foldersList;

    /**
     * Optional list of tags associated with this EHR. Tag target values can only be within the same EHR.
     */
    @Child(name = "tags", type = {OBJECT_REF.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Optional list of tags associated with this EHR", formalDefinition="Optional list of tags associated with this EHR. Tag target values can only be within the same EHR." )
    protected List<OBJECT_REF> tagsList;

    private static final long serialVersionUID = 1319457127L;

  /**
   * Constructor
   */
    public EHR() {
      super();
    }

  /**
   * Constructor
   */
    public EHR(HIER_OBJECT_ID system_id, HIER_OBJECT_ID ehr_id, OBJECT_REF ehr_status, OBJECT_REF ehr_access, DV_DATE_TIME time_created) {
      super();
      this.addSystem_id(system_id);
      this.setEhr_id(ehr_id);
      this.setEhr_status(ehr_status);
      this.setEhr_access(ehr_access);
      this.setTime_created(time_created);
    }

    /**
     * @return {@link #system_id} (The identifier of the logical EHR management system in which this EHR was created.)
     */
    public List<HIER_OBJECT_ID> getSystem_idList() { 
      if (this.system_idList == null)
        this.system_idList = new ArrayList<HIER_OBJECT_ID>();
      return this.system_idList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EHR setSystem_idList(List<HIER_OBJECT_ID> theSystem_id) { 
      this.system_idList = theSystem_id;
      return this;
    }

    public boolean hasSystem_id() { 
      if (this.system_idList == null)
        return false;
      for (HIER_OBJECT_ID item : this.system_idList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public HIER_OBJECT_ID addSystem_id() { //3a
      HIER_OBJECT_ID t = new HIER_OBJECT_ID();
      if (this.system_idList == null)
        this.system_idList = new ArrayList<HIER_OBJECT_ID>();
      this.system_idList.add(t);
      return t;
    }

    public EHR addSystem_id(HIER_OBJECT_ID t) { //3b
      if (t == null)
        return this;
      if (this.system_idList == null)
        this.system_idList = new ArrayList<HIER_OBJECT_ID>();
      this.system_idList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #system_id}, creating it if it does not already exist {3}
     */
    public HIER_OBJECT_ID getSystem_idFirstRep() { 
      if (getSystem_idList().isEmpty()) {
        addSystem_id();
      }
      return getSystem_idList().get(0);
    }

    /**
     * @return {@link #ehr_id} (The unique identifier of this EHR. NOTE: it is strongly recommended that a UUID always be used for this field.)
     */
    public HIER_OBJECT_ID getEhr_id() { 
      if (this.ehr_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EHR.ehr_id");
        else if (Configuration.doAutoCreate())
          this.ehr_id = new HIER_OBJECT_ID(); // cc
      return this.ehr_id;
    }

    public boolean hasEhr_id() { 
      return this.ehr_id != null && !this.ehr_id.isEmpty();
    }

    /**
     * @param value {@link #ehr_id} (The unique identifier of this EHR. NOTE: it is strongly recommended that a UUID always be used for this field.)
     */
    public EHR setEhr_id(HIER_OBJECT_ID value) { 
      this.ehr_id = value;
      return this;
    }

    /**
     * @return {@link #contributions} (List of contributions causing changes to this EHR. Each contribution contains a list of versions, which may include references to any number of VERSION instances, i.e. items of type VERSIONED_COMPOSITION and VERSIONED_FOLDER.)
     */
    public List<OBJECT_REF> getContributionsList() { 
      if (this.contributionsList == null)
        this.contributionsList = new ArrayList<OBJECT_REF>();
      return this.contributionsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EHR setContributionsList(List<OBJECT_REF> theContributions) { 
      this.contributionsList = theContributions;
      return this;
    }

    public boolean hasContributions() { 
      if (this.contributionsList == null)
        return false;
      for (OBJECT_REF item : this.contributionsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OBJECT_REF addContributions() { //3a
      OBJECT_REF t = new OBJECT_REF();
      if (this.contributionsList == null)
        this.contributionsList = new ArrayList<OBJECT_REF>();
      this.contributionsList.add(t);
      return t;
    }

    public EHR addContributions(OBJECT_REF t) { //3b
      if (t == null)
        return this;
      if (this.contributionsList == null)
        this.contributionsList = new ArrayList<OBJECT_REF>();
      this.contributionsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contributions}, creating it if it does not already exist {3}
     */
    public OBJECT_REF getContributionsFirstRep() { 
      if (getContributionsList().isEmpty()) {
        addContributions();
      }
      return getContributionsList().get(0);
    }

    /**
     * @return {@link #ehr_status} (Reference to EHR_STATUS object for this EHR.)
     */
    public OBJECT_REF getEhr_status() { 
      if (this.ehr_status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EHR.ehr_status");
        else if (Configuration.doAutoCreate())
          this.ehr_status = new OBJECT_REF(); // cc
      return this.ehr_status;
    }

    public boolean hasEhr_status() { 
      return this.ehr_status != null && !this.ehr_status.isEmpty();
    }

    /**
     * @param value {@link #ehr_status} (Reference to EHR_STATUS object for this EHR.)
     */
    public EHR setEhr_status(OBJECT_REF value) { 
      this.ehr_status = value;
      return this;
    }

    /**
     * @return {@link #ehr_access} (Reference to EHR_ACCESS object for this EHR.)
     */
    public OBJECT_REF getEhr_access() { 
      if (this.ehr_access == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EHR.ehr_access");
        else if (Configuration.doAutoCreate())
          this.ehr_access = new OBJECT_REF(); // cc
      return this.ehr_access;
    }

    public boolean hasEhr_access() { 
      return this.ehr_access != null && !this.ehr_access.isEmpty();
    }

    /**
     * @param value {@link #ehr_access} (Reference to EHR_ACCESS object for this EHR.)
     */
    public EHR setEhr_access(OBJECT_REF value) { 
      this.ehr_access = value;
      return this;
    }

    /**
     * @return {@link #compositions} (Master list of all Versioned Composition references in this EHR.)
     */
    public List<OBJECT_REF> getCompositionsList() { 
      if (this.compositionsList == null)
        this.compositionsList = new ArrayList<OBJECT_REF>();
      return this.compositionsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EHR setCompositionsList(List<OBJECT_REF> theCompositions) { 
      this.compositionsList = theCompositions;
      return this;
    }

    public boolean hasCompositions() { 
      if (this.compositionsList == null)
        return false;
      for (OBJECT_REF item : this.compositionsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OBJECT_REF addCompositions() { //3a
      OBJECT_REF t = new OBJECT_REF();
      if (this.compositionsList == null)
        this.compositionsList = new ArrayList<OBJECT_REF>();
      this.compositionsList.add(t);
      return t;
    }

    public EHR addCompositions(OBJECT_REF t) { //3b
      if (t == null)
        return this;
      if (this.compositionsList == null)
        this.compositionsList = new ArrayList<OBJECT_REF>();
      this.compositionsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #compositions}, creating it if it does not already exist {3}
     */
    public OBJECT_REF getCompositionsFirstRep() { 
      if (getCompositionsList().isEmpty()) {
        addCompositions();
      }
      return getCompositionsList().get(0);
    }

    /**
     * @return {@link #directory} (Optional directory structure for this EHR. If present, this is a reference to the first member of folders.)
     */
    public OBJECT_REF getDirectory() { 
      if (this.directory == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EHR.directory");
        else if (Configuration.doAutoCreate())
          this.directory = new OBJECT_REF(); // cc
      return this.directory;
    }

    public boolean hasDirectory() { 
      return this.directory != null && !this.directory.isEmpty();
    }

    /**
     * @param value {@link #directory} (Optional directory structure for this EHR. If present, this is a reference to the first member of folders.)
     */
    public EHR setDirectory(OBJECT_REF value) { 
      this.directory = value;
      return this;
    }

    /**
     * @return {@link #time_created} (Time of creation of the EHR.)
     */
    public DV_DATE_TIME getTime_created() { 
      if (this.time_created == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EHR.time_created");
        else if (Configuration.doAutoCreate())
          this.time_created = new DV_DATE_TIME(); // cc
      return this.time_created;
    }

    public boolean hasTime_created() { 
      return this.time_created != null && !this.time_created.isEmpty();
    }

    /**
     * @param value {@link #time_created} (Time of creation of the EHR.)
     */
    public EHR setTime_created(DV_DATE_TIME value) { 
      this.time_created = value;
      return this;
    }

    /**
     * @return {@link #folders} (Optional additional Folder structures for this EHR. If set, the directory attribute refers to the first member)
     */
    public List<OBJECT_REF> getFoldersList() { 
      if (this.foldersList == null)
        this.foldersList = new ArrayList<OBJECT_REF>();
      return this.foldersList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EHR setFoldersList(List<OBJECT_REF> theFolders) { 
      this.foldersList = theFolders;
      return this;
    }

    public boolean hasFolders() { 
      if (this.foldersList == null)
        return false;
      for (OBJECT_REF item : this.foldersList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OBJECT_REF addFolders() { //3a
      OBJECT_REF t = new OBJECT_REF();
      if (this.foldersList == null)
        this.foldersList = new ArrayList<OBJECT_REF>();
      this.foldersList.add(t);
      return t;
    }

    public EHR addFolders(OBJECT_REF t) { //3b
      if (t == null)
        return this;
      if (this.foldersList == null)
        this.foldersList = new ArrayList<OBJECT_REF>();
      this.foldersList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #folders}, creating it if it does not already exist {3}
     */
    public OBJECT_REF getFoldersFirstRep() { 
      if (getFoldersList().isEmpty()) {
        addFolders();
      }
      return getFoldersList().get(0);
    }

    /**
     * @return {@link #tags} (Optional list of tags associated with this EHR. Tag target values can only be within the same EHR.)
     */
    public List<OBJECT_REF> getTagsList() { 
      if (this.tagsList == null)
        this.tagsList = new ArrayList<OBJECT_REF>();
      return this.tagsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EHR setTagsList(List<OBJECT_REF> theTags) { 
      this.tagsList = theTags;
      return this;
    }

    public boolean hasTags() { 
      if (this.tagsList == null)
        return false;
      for (OBJECT_REF item : this.tagsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OBJECT_REF addTags() { //3a
      OBJECT_REF t = new OBJECT_REF();
      if (this.tagsList == null)
        this.tagsList = new ArrayList<OBJECT_REF>();
      this.tagsList.add(t);
      return t;
    }

    public EHR addTags(OBJECT_REF t) { //3b
      if (t == null)
        return this;
      if (this.tagsList == null)
        this.tagsList = new ArrayList<OBJECT_REF>();
      this.tagsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #tags}, creating it if it does not already exist {3}
     */
    public OBJECT_REF getTagsFirstRep() { 
      if (getTagsList().isEmpty()) {
        addTags();
      }
      return getTagsList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("system_id", "http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID", "The identifier of the logical EHR management system in which this EHR was created.", 0, java.lang.Integer.MAX_VALUE, system_idList));
        children.add(new Property("ehr_id", "http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID", "The unique identifier of this EHR. NOTE: it is strongly recommended that a UUID always be used for this field.", 0, 1, ehr_id));
        children.add(new Property("contributions", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "List of contributions causing changes to this EHR. Each contribution contains a list of versions, which may include references to any number of VERSION instances, i.e. items of type VERSIONED_COMPOSITION and VERSIONED_FOLDER.", 0, java.lang.Integer.MAX_VALUE, contributionsList));
        children.add(new Property("ehr_status", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Reference to EHR_STATUS object for this EHR.", 0, 1, ehr_status));
        children.add(new Property("ehr_access", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Reference to EHR_ACCESS object for this EHR.", 0, 1, ehr_access));
        children.add(new Property("compositions", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Master list of all Versioned Composition references in this EHR.", 0, java.lang.Integer.MAX_VALUE, compositionsList));
        children.add(new Property("directory", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Optional directory structure for this EHR. If present, this is a reference to the first member of folders.", 0, 1, directory));
        children.add(new Property("time_created", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time of creation of the EHR.", 0, 1, time_created));
        children.add(new Property("folders", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Optional additional Folder structures for this EHR. If set, the directory attribute refers to the first member", 0, java.lang.Integer.MAX_VALUE, foldersList));
        children.add(new Property("tags", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Optional list of tags associated with this EHR. Tag target values can only be within the same EHR.", 0, java.lang.Integer.MAX_VALUE, tagsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1129127211: /*system_id*/  return new Property("system_id", "http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID", "The identifier of the logical EHR management system in which this EHR was created.", 0, java.lang.Integer.MAX_VALUE, system_idList);
        case -1303886037: /*ehr_id*/  return new Property("ehr_id", "http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID", "The unique identifier of this EHR. NOTE: it is strongly recommended that a UUID always be used for this field.", 0, 1, ehr_id);
        case -294592925: /*contributions*/  return new Property("contributions", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "List of contributions causing changes to this EHR. Each contribution contains a list of versions, which may include references to any number of VERSION instances, i.e. items of type VERSIONED_COMPOSITION and VERSIONED_FOLDER.", 0, java.lang.Integer.MAX_VALUE, contributionsList);
        case 1263174146: /*ehr_status*/  return new Property("ehr_status", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Reference to EHR_STATUS object for this EHR.", 0, 1, ehr_status);
        case 732194676: /*ehr_access*/  return new Property("ehr_access", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Reference to EHR_ACCESS object for this EHR.", 0, 1, ehr_access);
        case -236835831: /*compositions*/  return new Property("compositions", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Master list of all Versioned Composition references in this EHR.", 0, java.lang.Integer.MAX_VALUE, compositionsList);
        case -962584979: /*directory*/  return new Property("directory", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Optional directory structure for this EHR. If present, this is a reference to the first member of folders.", 0, 1, directory);
        case -630236298: /*time_created*/  return new Property("time_created", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time of creation of the EHR.", 0, 1, time_created);
        case -683249211: /*folders*/  return new Property("folders", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Optional additional Folder structures for this EHR. If set, the directory attribute refers to the first member", 0, java.lang.Integer.MAX_VALUE, foldersList);
        case 3552281: /*tags*/  return new Property("tags", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Optional list of tags associated with this EHR. Tag target values can only be within the same EHR.", 0, java.lang.Integer.MAX_VALUE, tagsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1129127211: /*system_id*/ return this.system_idList == null ? new Base[0] : this.system_idList.toArray(new Base[this.system_idList.size()]); // HIER_OBJECT_ID
        case -1303886037: /*ehr_id*/ return this.ehr_id == null ? new Base[0] : new Base[] {this.ehr_id}; // HIER_OBJECT_ID
        case -294592925: /*contributions*/ return this.contributionsList == null ? new Base[0] : this.contributionsList.toArray(new Base[this.contributionsList.size()]); // OBJECT_REF
        case 1263174146: /*ehr_status*/ return this.ehr_status == null ? new Base[0] : new Base[] {this.ehr_status}; // OBJECT_REF
        case 732194676: /*ehr_access*/ return this.ehr_access == null ? new Base[0] : new Base[] {this.ehr_access}; // OBJECT_REF
        case -236835831: /*compositions*/ return this.compositionsList == null ? new Base[0] : this.compositionsList.toArray(new Base[this.compositionsList.size()]); // OBJECT_REF
        case -962584979: /*directory*/ return this.directory == null ? new Base[0] : new Base[] {this.directory}; // OBJECT_REF
        case -630236298: /*time_created*/ return this.time_created == null ? new Base[0] : new Base[] {this.time_created}; // DV_DATE_TIME
        case -683249211: /*folders*/ return this.foldersList == null ? new Base[0] : this.foldersList.toArray(new Base[this.foldersList.size()]); // OBJECT_REF
        case 3552281: /*tags*/ return this.tagsList == null ? new Base[0] : this.tagsList.toArray(new Base[this.tagsList.size()]); // OBJECT_REF
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1129127211: // system_id
          this.getSystem_idList().add((HIER_OBJECT_ID) value); // HIER_OBJECT_ID
          return value;
        case -1303886037: // ehr_id
          this.ehr_id = (HIER_OBJECT_ID) value; // HIER_OBJECT_ID
          return value;
        case -294592925: // contributions
          this.getContributionsList().add((OBJECT_REF) value); // OBJECT_REF
          return value;
        case 1263174146: // ehr_status
          this.ehr_status = (OBJECT_REF) value; // OBJECT_REF
          return value;
        case 732194676: // ehr_access
          this.ehr_access = (OBJECT_REF) value; // OBJECT_REF
          return value;
        case -236835831: // compositions
          this.getCompositionsList().add((OBJECT_REF) value); // OBJECT_REF
          return value;
        case -962584979: // directory
          this.directory = (OBJECT_REF) value; // OBJECT_REF
          return value;
        case -630236298: // time_created
          this.time_created = (DV_DATE_TIME) value; // DV_DATE_TIME
          return value;
        case -683249211: // folders
          this.getFoldersList().add((OBJECT_REF) value); // OBJECT_REF
          return value;
        case 3552281: // tags
          this.getTagsList().add((OBJECT_REF) value); // OBJECT_REF
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("system_id")) {
          this.getSystem_idList().add((HIER_OBJECT_ID) value); // HIER_OBJECT_ID
        } else if (name.equals("ehr_id")) {
          this.ehr_id = (HIER_OBJECT_ID) value; // HIER_OBJECT_ID
        } else if (name.equals("contributions")) {
          this.getContributionsList().add((OBJECT_REF) value); // OBJECT_REF
        } else if (name.equals("ehr_status")) {
          this.ehr_status = (OBJECT_REF) value; // OBJECT_REF
        } else if (name.equals("ehr_access")) {
          this.ehr_access = (OBJECT_REF) value; // OBJECT_REF
        } else if (name.equals("compositions")) {
          this.getCompositionsList().add((OBJECT_REF) value); // OBJECT_REF
        } else if (name.equals("directory")) {
          this.directory = (OBJECT_REF) value; // OBJECT_REF
        } else if (name.equals("time_created")) {
          this.time_created = (DV_DATE_TIME) value; // DV_DATE_TIME
        } else if (name.equals("folders")) {
          this.getFoldersList().add((OBJECT_REF) value); // OBJECT_REF
        } else if (name.equals("tags")) {
          this.getTagsList().add((OBJECT_REF) value); // OBJECT_REF
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1129127211:  return addSystem_id(); 
        case -1303886037:  return getEhr_id();
        case -294592925:  return addContributions(); 
        case 1263174146:  return getEhr_status();
        case 732194676:  return getEhr_access();
        case -236835831:  return addCompositions(); 
        case -962584979:  return getDirectory();
        case -630236298:  return getTime_created();
        case -683249211:  return addFolders(); 
        case 3552281:  return addTags(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1129127211: /*system_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID"};
        case -1303886037: /*ehr_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/HIER-OBJECT-ID"};
        case -294592925: /*contributions*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case 1263174146: /*ehr_status*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case 732194676: /*ehr_access*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case -236835831: /*compositions*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case -962584979: /*directory*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case -630236298: /*time_created*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME"};
        case -683249211: /*folders*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case 3552281: /*tags*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("system_id")) {
          return addSystem_id();
        }
        else if (name.equals("ehr_id")) {
          this.ehr_id = new HIER_OBJECT_ID();
          return this.ehr_id;
        }
        else if (name.equals("contributions")) {
          return addContributions();
        }
        else if (name.equals("ehr_status")) {
          this.ehr_status = new OBJECT_REF();
          return this.ehr_status;
        }
        else if (name.equals("ehr_access")) {
          this.ehr_access = new OBJECT_REF();
          return this.ehr_access;
        }
        else if (name.equals("compositions")) {
          return addCompositions();
        }
        else if (name.equals("directory")) {
          this.directory = new OBJECT_REF();
          return this.directory;
        }
        else if (name.equals("time_created")) {
          this.time_created = new DV_DATE_TIME();
          return this.time_created;
        }
        else if (name.equals("folders")) {
          return addFolders();
        }
        else if (name.equals("tags")) {
          return addTags();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "EHR";

  }

      public EHR copy() {
        EHR dst = new EHR();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EHR dst) {
        super.copyValues(dst);
        if (system_idList != null) {
          dst.system_idList = new ArrayList<HIER_OBJECT_ID>();
          for (HIER_OBJECT_ID i : system_idList)
            dst.system_idList.add(i.copy());
        };
        dst.ehr_id = ehr_id == null ? null : ehr_id.copy();
        if (contributionsList != null) {
          dst.contributionsList = new ArrayList<OBJECT_REF>();
          for (OBJECT_REF i : contributionsList)
            dst.contributionsList.add(i.copy());
        };
        dst.ehr_status = ehr_status == null ? null : ehr_status.copy();
        dst.ehr_access = ehr_access == null ? null : ehr_access.copy();
        if (compositionsList != null) {
          dst.compositionsList = new ArrayList<OBJECT_REF>();
          for (OBJECT_REF i : compositionsList)
            dst.compositionsList.add(i.copy());
        };
        dst.directory = directory == null ? null : directory.copy();
        dst.time_created = time_created == null ? null : time_created.copy();
        if (foldersList != null) {
          dst.foldersList = new ArrayList<OBJECT_REF>();
          for (OBJECT_REF i : foldersList)
            dst.foldersList.add(i.copy());
        };
        if (tagsList != null) {
          dst.tagsList = new ArrayList<OBJECT_REF>();
          for (OBJECT_REF i : tagsList)
            dst.tagsList.add(i.copy());
        };
      }

      protected EHR typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EHR))
          return false;
        EHR o = (EHR) other_;
        return compareDeep(system_idList, o.system_idList, true) && compareDeep(ehr_id, o.ehr_id, true)
           && compareDeep(contributionsList, o.contributionsList, true) && compareDeep(ehr_status, o.ehr_status, true)
           && compareDeep(ehr_access, o.ehr_access, true) && compareDeep(compositionsList, o.compositionsList, true)
           && compareDeep(directory, o.directory, true) && compareDeep(time_created, o.time_created, true)
           && compareDeep(foldersList, o.foldersList, true) && compareDeep(tagsList, o.tagsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EHR))
          return false;
        EHR o = (EHR) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(system_idList, ehr_id, contributionsList
          , ehr_status, ehr_access, compositionsList, directory, time_created, foldersList
          , tagsList);
      }


}


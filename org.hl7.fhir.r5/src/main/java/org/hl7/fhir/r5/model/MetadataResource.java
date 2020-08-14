package org.hl7.fhir.r5.model;




import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;

/**
 * Common Ancestor declaration for conformance and knowledge artifact resources.
 */
public abstract class MetadataResource extends CanonicalResource {

    private static final long serialVersionUID = 0L;

  /**
   * Constructor
   */
    public MetadataResource() {
      super();
    }

    /**
     * How many allowed for this property by the implementation
     */
    public int getApprovalDateMax() { 
      return 1;
    }
    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public abstract DateType getApprovalDateElement(); 

    public abstract boolean hasApprovalDateElement(); 
    public abstract boolean hasApprovalDate(); 

    /**
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public abstract MetadataResource setApprovalDateElement(DateType value); 
    /**
     * @return The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public abstract Date getApprovalDate(); 
    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public abstract MetadataResource setApprovalDate(Date value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getLastReviewDateMax() { 
      return 1;
    }
    /**
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public abstract DateType getLastReviewDateElement(); 

    public abstract boolean hasLastReviewDateElement(); 
    public abstract boolean hasLastReviewDate(); 

    /**
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public abstract MetadataResource setLastReviewDateElement(DateType value); 
    /**
     * @return The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public abstract Date getLastReviewDate(); 
    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public abstract MetadataResource setLastReviewDate(Date value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getEffectivePeriodMax() { 
      return 1;
    }
    /**
     * @return {@link #effectivePeriod} (The period during which the metadata resource content was or is planned to be in active use.)
     */
    public abstract Period getEffectivePeriod(); 
    public abstract boolean hasEffectivePeriod(); 
    /**
     * @param value {@link #effectivePeriod} (The period during which the metadata resource content was or is planned to be in active use.)
     */
    public abstract MetadataResource setEffectivePeriod(Period value); 

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
          return super.setProperty(name, value);
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
          return super.addChild(name);
      }

  public String fhirType() {
    return "MetadataResource";

  }

      public abstract MetadataResource copy();

      public void copyValues(MetadataResource dst) {
        super.copyValues(dst);
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MetadataResource))
          return false;
        MetadataResource o = (MetadataResource) other_;
        return true;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MetadataResource))
          return false;
        MetadataResource o = (MetadataResource) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty();
      }


}
package org.hl7.fhir.r5.model;


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
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * The Citation Resource enables reference to any knowledge artifact for purposes of identification and attribution. The Citation Resource supports existing reference structures and developing publication practices such as versioning, expressing complex contributorship roles, and referencing computable resources.
 */
@ResourceDef(name="Citation", profile="http://hl7.org/fhir/StructureDefinition/Citation")
public class Citation extends MetadataResource {

    public enum RelatedArtifactTypeExpanded {
        /**
         * Additional documentation for the knowledge resource. This would include additional instructions on usage as well as additional information on clinical context or appropriateness.
         */
        DOCUMENTATION, 
        /**
         * The target artifact is a summary of the justification for the knowledge resource including supporting evidence, relevant guidelines, or other clinically important information. This information is intended to provide a way to make the justification for the knowledge resource available to the consumer of interventions or results produced by the knowledge resource.
         */
        JUSTIFICATION, 
        /**
         * Bibliographic citation for papers, references, or other relevant material for the knowledge resource. This is intended to allow for citation of related material, but that was not necessarily specifically prepared in connection with this knowledge resource.
         */
        CITATION, 
        /**
         * The previous version of the knowledge artifact, used to establish an ordering of versions of an artifact, independent of the status of each version.
         */
        PREDECESSOR, 
        /**
         * The subsequent version of the knowledge artfact, used to establish an ordering of versions of an artifact, independent of the status of each version.
         */
        SUCCESSOR, 
        /**
         * This artifact is derived from the target artifact. This is intended to capture the relationship in which a particular knowledge resource is based on the content of another artifact, but is modified to capture either a different set of overall requirements, or a more specific set of requirements such as those involved in a particular institution or clinical setting. The artifact may be derived from one or more target artifacts.
         */
        DERIVEDFROM, 
        /**
         * This artifact depends on the target artifact. There is a requirement to use the target artifact in the creation or interpretation of this artifact.
         */
        DEPENDSON, 
        /**
         * This artifact is composed of the target artifact. This artifact is constructed with the target artifact as a component. The target artifact is a part of this artifact. (A dataset is composed of data.).
         */
        COMPOSEDOF, 
        /**
         * This artifact is a part of the target artifact. The target artifact is composed of this artifact (and possibly other artifacts).
         */
        PARTOF, 
        /**
         * This artifact amends or changes the target artifact. This artifact adds additional information that is functionally expected to replace information in the target artifact. This artifact replaces a part but not all of the target artifact.
         */
        AMENDS, 
        /**
         * This artifact is amended with or changed by the target artifact. There is information in this artifact that should be functionally replaced with information in the target artifact.
         */
        AMENDEDWITH, 
        /**
         * This artifact adds additional information to the target artifact. The additional information does not replace or change information in the target artifact.
         */
        APPENDS, 
        /**
         * This artifact has additional information in the target artifact.
         */
        APPENDEDWITH, 
        /**
         * This artifact cites the target artifact. This may be a bibliographic citation for papers, references, or other relevant material for the knowledge resource. This is intended to allow for citation of related material, but that was not necessarily specifically prepared in connection with this knowledge resource.
         */
        CITES, 
        /**
         * This artifact is cited by the target artifact.
         */
        CITEDBY, 
        /**
         * This artifact contains comments about the target artifact.
         */
        COMMENTSON, 
        /**
         * This artifact has comments about it in the target artifact.  The type of comments may be expressed in the targetClassifier element such as reply, review, editorial, feedback, solicited, unsolicited, structured, unstructured.
         */
        COMMENTIN, 
        /**
         * This artifact is a container in which the target artifact is contained. A container is a data structure whose instances are collections of other objects. (A database contains the dataset.).
         */
        CONTAINS, 
        /**
         * This artifact is contained in the target artifact. The target artifact is a data structure whose instances are collections of other objects.
         */
        CONTAINEDIN, 
        /**
         * This artifact identifies errors and replacement content for the target artifact.
         */
        CORRECTS, 
        /**
         * This artifact has corrections to it in the target artifact. The target artifact identifies errors and replacement content for this artifact.
         */
        CORRECTIONIN, 
        /**
         * This artifact replaces or supersedes the target artifact. The target artifact may be considered deprecated.
         */
        REPLACES, 
        /**
         * This artifact is replaced with or superseded by the target artifact. This artifact may be considered deprecated.
         */
        REPLACEDWITH, 
        /**
         * This artifact retracts the target artifact. The content that was published in the target artifact should be considered removed from publication and should no longer be considered part of the public record.
         */
        RETRACTS, 
        /**
         * This artifact is retracted by the target artifact. The content that was published in this artifact should be considered removed from publication and should no longer be considered part of the public record.
         */
        RETRACTEDBY, 
        /**
         * This artifact is a signature of the target artifact.
         */
        SIGNS, 
        /**
         * This artifact has characteristics in common with the target artifact. This relationship may be used in systems to “deduplicate” knowledge artifacts from different sources, or in systems to show “similar items”.
         */
        SIMILARTO, 
        /**
         * This artifact provides additional support for the target artifact. The type of support  is not documentation as it does not describe, explain, or instruct regarding the target artifact.
         */
        SUPPORTS, 
        /**
         * The target artifact contains additional information related to the knowledge artifact but is not documentation as the additional information does not describe, explain, or instruct regarding the knowledge artifact content or application. This could include an associated dataset.
         */
        SUPPORTEDWITH, 
        /**
         * This artifact was generated by transforming the target artifact (e.g., format or language conversion). This is intended to capture the relationship in which a particular knowledge resource is based on the content of another artifact, but changes are only apparent in form and there is only one target artifact with the “transforms” relationship type.
         */
        TRANSFORMS, 
        /**
         * This artifact was transformed into the target artifact (e.g., by format or language conversion).
         */
        TRANSFORMEDINTO, 
        /**
         * This artifact was generated by transforming a related artifact (e.g., format or language conversion), noted separately with the “transforms” relationship type. This transformation used the target artifact to inform the transformation. The target artifact may be a conversion script or translation guide.
         */
        TRANSFORMEDWITH, 
        /**
         * This artifact provides additional documentation for the target artifact. This could include additional instructions on usage as well as additional information on clinical context or appropriateness.
         */
        DOCUMENTS, 
        /**
         * The target artifact is a precise description of a concept in this artifact. This may be used when the RelatedArtifact datatype is used in elements contained in this artifact.
         */
        SPECIFICATIONOF, 
        /**
         * This artifact was created with the target artifact. The target artifact is a tool or support material used in the creation of the artifact, and not content that the artifact was derived from.
         */
        CREATEDWITH, 
        /**
         * The related artifact is the citation for this artifact.
         */
        CITEAS, 
        /**
         * A copy of the artifact in a publication with a different artifact identifier.
         */
        REPRINT, 
        /**
         * The original version of record for which the current artifact is a copy.
         */
        REPRINTOF, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static RelatedArtifactTypeExpanded fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("documentation".equals(codeString))
          return DOCUMENTATION;
        if ("justification".equals(codeString))
          return JUSTIFICATION;
        if ("citation".equals(codeString))
          return CITATION;
        if ("predecessor".equals(codeString))
          return PREDECESSOR;
        if ("successor".equals(codeString))
          return SUCCESSOR;
        if ("derived-from".equals(codeString))
          return DERIVEDFROM;
        if ("depends-on".equals(codeString))
          return DEPENDSON;
        if ("composed-of".equals(codeString))
          return COMPOSEDOF;
        if ("part-of".equals(codeString))
          return PARTOF;
        if ("amends".equals(codeString))
          return AMENDS;
        if ("amended-with".equals(codeString))
          return AMENDEDWITH;
        if ("appends".equals(codeString))
          return APPENDS;
        if ("appended-with".equals(codeString))
          return APPENDEDWITH;
        if ("cites".equals(codeString))
          return CITES;
        if ("cited-by".equals(codeString))
          return CITEDBY;
        if ("comments-on".equals(codeString))
          return COMMENTSON;
        if ("comment-in".equals(codeString))
          return COMMENTIN;
        if ("contains".equals(codeString))
          return CONTAINS;
        if ("contained-in".equals(codeString))
          return CONTAINEDIN;
        if ("corrects".equals(codeString))
          return CORRECTS;
        if ("correction-in".equals(codeString))
          return CORRECTIONIN;
        if ("replaces".equals(codeString))
          return REPLACES;
        if ("replaced-with".equals(codeString))
          return REPLACEDWITH;
        if ("retracts".equals(codeString))
          return RETRACTS;
        if ("retracted-by".equals(codeString))
          return RETRACTEDBY;
        if ("signs".equals(codeString))
          return SIGNS;
        if ("similar-to".equals(codeString))
          return SIMILARTO;
        if ("supports".equals(codeString))
          return SUPPORTS;
        if ("supported-with".equals(codeString))
          return SUPPORTEDWITH;
        if ("transforms".equals(codeString))
          return TRANSFORMS;
        if ("transformed-into".equals(codeString))
          return TRANSFORMEDINTO;
        if ("transformed-with".equals(codeString))
          return TRANSFORMEDWITH;
        if ("documents".equals(codeString))
          return DOCUMENTS;
        if ("specification-of".equals(codeString))
          return SPECIFICATIONOF;
        if ("created-with".equals(codeString))
          return CREATEDWITH;
        if ("cite-as".equals(codeString))
          return CITEAS;
        if ("reprint".equals(codeString))
          return REPRINT;
        if ("reprint-of".equals(codeString))
          return REPRINTOF;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown RelatedArtifactTypeExpanded code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DOCUMENTATION: return "documentation";
            case JUSTIFICATION: return "justification";
            case CITATION: return "citation";
            case PREDECESSOR: return "predecessor";
            case SUCCESSOR: return "successor";
            case DERIVEDFROM: return "derived-from";
            case DEPENDSON: return "depends-on";
            case COMPOSEDOF: return "composed-of";
            case PARTOF: return "part-of";
            case AMENDS: return "amends";
            case AMENDEDWITH: return "amended-with";
            case APPENDS: return "appends";
            case APPENDEDWITH: return "appended-with";
            case CITES: return "cites";
            case CITEDBY: return "cited-by";
            case COMMENTSON: return "comments-on";
            case COMMENTIN: return "comment-in";
            case CONTAINS: return "contains";
            case CONTAINEDIN: return "contained-in";
            case CORRECTS: return "corrects";
            case CORRECTIONIN: return "correction-in";
            case REPLACES: return "replaces";
            case REPLACEDWITH: return "replaced-with";
            case RETRACTS: return "retracts";
            case RETRACTEDBY: return "retracted-by";
            case SIGNS: return "signs";
            case SIMILARTO: return "similar-to";
            case SUPPORTS: return "supports";
            case SUPPORTEDWITH: return "supported-with";
            case TRANSFORMS: return "transforms";
            case TRANSFORMEDINTO: return "transformed-into";
            case TRANSFORMEDWITH: return "transformed-with";
            case DOCUMENTS: return "documents";
            case SPECIFICATIONOF: return "specification-of";
            case CREATEDWITH: return "created-with";
            case CITEAS: return "cite-as";
            case REPRINT: return "reprint";
            case REPRINTOF: return "reprint-of";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DOCUMENTATION: return "http://hl7.org/fhir/related-artifact-type";
            case JUSTIFICATION: return "http://hl7.org/fhir/related-artifact-type";
            case CITATION: return "http://hl7.org/fhir/related-artifact-type";
            case PREDECESSOR: return "http://hl7.org/fhir/related-artifact-type";
            case SUCCESSOR: return "http://hl7.org/fhir/related-artifact-type";
            case DERIVEDFROM: return "http://hl7.org/fhir/related-artifact-type";
            case DEPENDSON: return "http://hl7.org/fhir/related-artifact-type";
            case COMPOSEDOF: return "http://hl7.org/fhir/related-artifact-type";
            case PARTOF: return "http://hl7.org/fhir/related-artifact-type";
            case AMENDS: return "http://hl7.org/fhir/related-artifact-type";
            case AMENDEDWITH: return "http://hl7.org/fhir/related-artifact-type";
            case APPENDS: return "http://hl7.org/fhir/related-artifact-type";
            case APPENDEDWITH: return "http://hl7.org/fhir/related-artifact-type";
            case CITES: return "http://hl7.org/fhir/related-artifact-type";
            case CITEDBY: return "http://hl7.org/fhir/related-artifact-type";
            case COMMENTSON: return "http://hl7.org/fhir/related-artifact-type";
            case COMMENTIN: return "http://hl7.org/fhir/related-artifact-type";
            case CONTAINS: return "http://hl7.org/fhir/related-artifact-type";
            case CONTAINEDIN: return "http://hl7.org/fhir/related-artifact-type";
            case CORRECTS: return "http://hl7.org/fhir/related-artifact-type";
            case CORRECTIONIN: return "http://hl7.org/fhir/related-artifact-type";
            case REPLACES: return "http://hl7.org/fhir/related-artifact-type";
            case REPLACEDWITH: return "http://hl7.org/fhir/related-artifact-type";
            case RETRACTS: return "http://hl7.org/fhir/related-artifact-type";
            case RETRACTEDBY: return "http://hl7.org/fhir/related-artifact-type";
            case SIGNS: return "http://hl7.org/fhir/related-artifact-type";
            case SIMILARTO: return "http://hl7.org/fhir/related-artifact-type";
            case SUPPORTS: return "http://hl7.org/fhir/related-artifact-type";
            case SUPPORTEDWITH: return "http://hl7.org/fhir/related-artifact-type";
            case TRANSFORMS: return "http://hl7.org/fhir/related-artifact-type";
            case TRANSFORMEDINTO: return "http://hl7.org/fhir/related-artifact-type";
            case TRANSFORMEDWITH: return "http://hl7.org/fhir/related-artifact-type";
            case DOCUMENTS: return "http://hl7.org/fhir/related-artifact-type";
            case SPECIFICATIONOF: return "http://hl7.org/fhir/related-artifact-type";
            case CREATEDWITH: return "http://hl7.org/fhir/related-artifact-type";
            case CITEAS: return "http://hl7.org/fhir/related-artifact-type";
            case REPRINT: return "http://hl7.org/fhir/related-artifact-type-expanded";
            case REPRINTOF: return "http://hl7.org/fhir/related-artifact-type-expanded";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DOCUMENTATION: return "Additional documentation for the knowledge resource. This would include additional instructions on usage as well as additional information on clinical context or appropriateness.";
            case JUSTIFICATION: return "The target artifact is a summary of the justification for the knowledge resource including supporting evidence, relevant guidelines, or other clinically important information. This information is intended to provide a way to make the justification for the knowledge resource available to the consumer of interventions or results produced by the knowledge resource.";
            case CITATION: return "Bibliographic citation for papers, references, or other relevant material for the knowledge resource. This is intended to allow for citation of related material, but that was not necessarily specifically prepared in connection with this knowledge resource.";
            case PREDECESSOR: return "The previous version of the knowledge artifact, used to establish an ordering of versions of an artifact, independent of the status of each version.";
            case SUCCESSOR: return "The subsequent version of the knowledge artfact, used to establish an ordering of versions of an artifact, independent of the status of each version.";
            case DERIVEDFROM: return "This artifact is derived from the target artifact. This is intended to capture the relationship in which a particular knowledge resource is based on the content of another artifact, but is modified to capture either a different set of overall requirements, or a more specific set of requirements such as those involved in a particular institution or clinical setting. The artifact may be derived from one or more target artifacts.";
            case DEPENDSON: return "This artifact depends on the target artifact. There is a requirement to use the target artifact in the creation or interpretation of this artifact.";
            case COMPOSEDOF: return "This artifact is composed of the target artifact. This artifact is constructed with the target artifact as a component. The target artifact is a part of this artifact. (A dataset is composed of data.).";
            case PARTOF: return "This artifact is a part of the target artifact. The target artifact is composed of this artifact (and possibly other artifacts).";
            case AMENDS: return "This artifact amends or changes the target artifact. This artifact adds additional information that is functionally expected to replace information in the target artifact. This artifact replaces a part but not all of the target artifact.";
            case AMENDEDWITH: return "This artifact is amended with or changed by the target artifact. There is information in this artifact that should be functionally replaced with information in the target artifact.";
            case APPENDS: return "This artifact adds additional information to the target artifact. The additional information does not replace or change information in the target artifact.";
            case APPENDEDWITH: return "This artifact has additional information in the target artifact.";
            case CITES: return "This artifact cites the target artifact. This may be a bibliographic citation for papers, references, or other relevant material for the knowledge resource. This is intended to allow for citation of related material, but that was not necessarily specifically prepared in connection with this knowledge resource.";
            case CITEDBY: return "This artifact is cited by the target artifact.";
            case COMMENTSON: return "This artifact contains comments about the target artifact.";
            case COMMENTIN: return "This artifact has comments about it in the target artifact.  The type of comments may be expressed in the targetClassifier element such as reply, review, editorial, feedback, solicited, unsolicited, structured, unstructured.";
            case CONTAINS: return "This artifact is a container in which the target artifact is contained. A container is a data structure whose instances are collections of other objects. (A database contains the dataset.).";
            case CONTAINEDIN: return "This artifact is contained in the target artifact. The target artifact is a data structure whose instances are collections of other objects.";
            case CORRECTS: return "This artifact identifies errors and replacement content for the target artifact.";
            case CORRECTIONIN: return "This artifact has corrections to it in the target artifact. The target artifact identifies errors and replacement content for this artifact.";
            case REPLACES: return "This artifact replaces or supersedes the target artifact. The target artifact may be considered deprecated.";
            case REPLACEDWITH: return "This artifact is replaced with or superseded by the target artifact. This artifact may be considered deprecated.";
            case RETRACTS: return "This artifact retracts the target artifact. The content that was published in the target artifact should be considered removed from publication and should no longer be considered part of the public record.";
            case RETRACTEDBY: return "This artifact is retracted by the target artifact. The content that was published in this artifact should be considered removed from publication and should no longer be considered part of the public record.";
            case SIGNS: return "This artifact is a signature of the target artifact.";
            case SIMILARTO: return "This artifact has characteristics in common with the target artifact. This relationship may be used in systems to “deduplicate” knowledge artifacts from different sources, or in systems to show “similar items”.";
            case SUPPORTS: return "This artifact provides additional support for the target artifact. The type of support  is not documentation as it does not describe, explain, or instruct regarding the target artifact.";
            case SUPPORTEDWITH: return "The target artifact contains additional information related to the knowledge artifact but is not documentation as the additional information does not describe, explain, or instruct regarding the knowledge artifact content or application. This could include an associated dataset.";
            case TRANSFORMS: return "This artifact was generated by transforming the target artifact (e.g., format or language conversion). This is intended to capture the relationship in which a particular knowledge resource is based on the content of another artifact, but changes are only apparent in form and there is only one target artifact with the “transforms” relationship type.";
            case TRANSFORMEDINTO: return "This artifact was transformed into the target artifact (e.g., by format or language conversion).";
            case TRANSFORMEDWITH: return "This artifact was generated by transforming a related artifact (e.g., format or language conversion), noted separately with the “transforms” relationship type. This transformation used the target artifact to inform the transformation. The target artifact may be a conversion script or translation guide.";
            case DOCUMENTS: return "This artifact provides additional documentation for the target artifact. This could include additional instructions on usage as well as additional information on clinical context or appropriateness.";
            case SPECIFICATIONOF: return "The target artifact is a precise description of a concept in this artifact. This may be used when the RelatedArtifact datatype is used in elements contained in this artifact.";
            case CREATEDWITH: return "This artifact was created with the target artifact. The target artifact is a tool or support material used in the creation of the artifact, and not content that the artifact was derived from.";
            case CITEAS: return "The related artifact is the citation for this artifact.";
            case REPRINT: return "A copy of the artifact in a publication with a different artifact identifier.";
            case REPRINTOF: return "The original version of record for which the current artifact is a copy.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DOCUMENTATION: return "Documentation";
            case JUSTIFICATION: return "Justification";
            case CITATION: return "Citation";
            case PREDECESSOR: return "Predecessor";
            case SUCCESSOR: return "Successor";
            case DERIVEDFROM: return "Derived From";
            case DEPENDSON: return "Depends On";
            case COMPOSEDOF: return "Composed Of";
            case PARTOF: return "Part Of";
            case AMENDS: return "Amends";
            case AMENDEDWITH: return "Amended With";
            case APPENDS: return "Appends";
            case APPENDEDWITH: return "Appended With";
            case CITES: return "Cites";
            case CITEDBY: return "Cited By";
            case COMMENTSON: return "Is Comment On";
            case COMMENTIN: return "Has Comment In";
            case CONTAINS: return "Contains";
            case CONTAINEDIN: return "Contained In";
            case CORRECTS: return "Corrects";
            case CORRECTIONIN: return "Correction In";
            case REPLACES: return "Replaces";
            case REPLACEDWITH: return "Replaced With";
            case RETRACTS: return "Retracts";
            case RETRACTEDBY: return "Retracted By";
            case SIGNS: return "Signs";
            case SIMILARTO: return "Similar To";
            case SUPPORTS: return "Supports";
            case SUPPORTEDWITH: return "Supported With";
            case TRANSFORMS: return "Transforms";
            case TRANSFORMEDINTO: return "Transformed Into";
            case TRANSFORMEDWITH: return "Transformed With";
            case DOCUMENTS: return "Documents";
            case SPECIFICATIONOF: return "Specification Of";
            case CREATEDWITH: return "Created With";
            case CITEAS: return "Cite As";
            case REPRINT: return "Reprint";
            case REPRINTOF: return "Reprint Of";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class RelatedArtifactTypeExpandedEnumFactory implements EnumFactory<RelatedArtifactTypeExpanded> {
    public RelatedArtifactTypeExpanded fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("documentation".equals(codeString))
          return RelatedArtifactTypeExpanded.DOCUMENTATION;
        if ("justification".equals(codeString))
          return RelatedArtifactTypeExpanded.JUSTIFICATION;
        if ("citation".equals(codeString))
          return RelatedArtifactTypeExpanded.CITATION;
        if ("predecessor".equals(codeString))
          return RelatedArtifactTypeExpanded.PREDECESSOR;
        if ("successor".equals(codeString))
          return RelatedArtifactTypeExpanded.SUCCESSOR;
        if ("derived-from".equals(codeString))
          return RelatedArtifactTypeExpanded.DERIVEDFROM;
        if ("depends-on".equals(codeString))
          return RelatedArtifactTypeExpanded.DEPENDSON;
        if ("composed-of".equals(codeString))
          return RelatedArtifactTypeExpanded.COMPOSEDOF;
        if ("part-of".equals(codeString))
          return RelatedArtifactTypeExpanded.PARTOF;
        if ("amends".equals(codeString))
          return RelatedArtifactTypeExpanded.AMENDS;
        if ("amended-with".equals(codeString))
          return RelatedArtifactTypeExpanded.AMENDEDWITH;
        if ("appends".equals(codeString))
          return RelatedArtifactTypeExpanded.APPENDS;
        if ("appended-with".equals(codeString))
          return RelatedArtifactTypeExpanded.APPENDEDWITH;
        if ("cites".equals(codeString))
          return RelatedArtifactTypeExpanded.CITES;
        if ("cited-by".equals(codeString))
          return RelatedArtifactTypeExpanded.CITEDBY;
        if ("comments-on".equals(codeString))
          return RelatedArtifactTypeExpanded.COMMENTSON;
        if ("comment-in".equals(codeString))
          return RelatedArtifactTypeExpanded.COMMENTIN;
        if ("contains".equals(codeString))
          return RelatedArtifactTypeExpanded.CONTAINS;
        if ("contained-in".equals(codeString))
          return RelatedArtifactTypeExpanded.CONTAINEDIN;
        if ("corrects".equals(codeString))
          return RelatedArtifactTypeExpanded.CORRECTS;
        if ("correction-in".equals(codeString))
          return RelatedArtifactTypeExpanded.CORRECTIONIN;
        if ("replaces".equals(codeString))
          return RelatedArtifactTypeExpanded.REPLACES;
        if ("replaced-with".equals(codeString))
          return RelatedArtifactTypeExpanded.REPLACEDWITH;
        if ("retracts".equals(codeString))
          return RelatedArtifactTypeExpanded.RETRACTS;
        if ("retracted-by".equals(codeString))
          return RelatedArtifactTypeExpanded.RETRACTEDBY;
        if ("signs".equals(codeString))
          return RelatedArtifactTypeExpanded.SIGNS;
        if ("similar-to".equals(codeString))
          return RelatedArtifactTypeExpanded.SIMILARTO;
        if ("supports".equals(codeString))
          return RelatedArtifactTypeExpanded.SUPPORTS;
        if ("supported-with".equals(codeString))
          return RelatedArtifactTypeExpanded.SUPPORTEDWITH;
        if ("transforms".equals(codeString))
          return RelatedArtifactTypeExpanded.TRANSFORMS;
        if ("transformed-into".equals(codeString))
          return RelatedArtifactTypeExpanded.TRANSFORMEDINTO;
        if ("transformed-with".equals(codeString))
          return RelatedArtifactTypeExpanded.TRANSFORMEDWITH;
        if ("documents".equals(codeString))
          return RelatedArtifactTypeExpanded.DOCUMENTS;
        if ("specification-of".equals(codeString))
          return RelatedArtifactTypeExpanded.SPECIFICATIONOF;
        if ("created-with".equals(codeString))
          return RelatedArtifactTypeExpanded.CREATEDWITH;
        if ("cite-as".equals(codeString))
          return RelatedArtifactTypeExpanded.CITEAS;
        if ("reprint".equals(codeString))
          return RelatedArtifactTypeExpanded.REPRINT;
        if ("reprint-of".equals(codeString))
          return RelatedArtifactTypeExpanded.REPRINTOF;
        throw new IllegalArgumentException("Unknown RelatedArtifactTypeExpanded code '"+codeString+"'");
        }
        public Enumeration<RelatedArtifactTypeExpanded> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.NULL, code);
        if ("documentation".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.DOCUMENTATION, code);
        if ("justification".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.JUSTIFICATION, code);
        if ("citation".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.CITATION, code);
        if ("predecessor".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.PREDECESSOR, code);
        if ("successor".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.SUCCESSOR, code);
        if ("derived-from".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.DERIVEDFROM, code);
        if ("depends-on".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.DEPENDSON, code);
        if ("composed-of".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.COMPOSEDOF, code);
        if ("part-of".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.PARTOF, code);
        if ("amends".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.AMENDS, code);
        if ("amended-with".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.AMENDEDWITH, code);
        if ("appends".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.APPENDS, code);
        if ("appended-with".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.APPENDEDWITH, code);
        if ("cites".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.CITES, code);
        if ("cited-by".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.CITEDBY, code);
        if ("comments-on".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.COMMENTSON, code);
        if ("comment-in".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.COMMENTIN, code);
        if ("contains".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.CONTAINS, code);
        if ("contained-in".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.CONTAINEDIN, code);
        if ("corrects".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.CORRECTS, code);
        if ("correction-in".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.CORRECTIONIN, code);
        if ("replaces".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.REPLACES, code);
        if ("replaced-with".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.REPLACEDWITH, code);
        if ("retracts".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.RETRACTS, code);
        if ("retracted-by".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.RETRACTEDBY, code);
        if ("signs".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.SIGNS, code);
        if ("similar-to".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.SIMILARTO, code);
        if ("supports".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.SUPPORTS, code);
        if ("supported-with".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.SUPPORTEDWITH, code);
        if ("transforms".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.TRANSFORMS, code);
        if ("transformed-into".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.TRANSFORMEDINTO, code);
        if ("transformed-with".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.TRANSFORMEDWITH, code);
        if ("documents".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.DOCUMENTS, code);
        if ("specification-of".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.SPECIFICATIONOF, code);
        if ("created-with".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.CREATEDWITH, code);
        if ("cite-as".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.CITEAS, code);
        if ("reprint".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.REPRINT, code);
        if ("reprint-of".equals(codeString))
          return new Enumeration<RelatedArtifactTypeExpanded>(this, RelatedArtifactTypeExpanded.REPRINTOF, code);
        throw new FHIRException("Unknown RelatedArtifactTypeExpanded code '"+codeString+"'");
        }
    public String toCode(RelatedArtifactTypeExpanded code) {
       if (code == RelatedArtifactTypeExpanded.NULL)
           return null;
       if (code == RelatedArtifactTypeExpanded.DOCUMENTATION)
        return "documentation";
      if (code == RelatedArtifactTypeExpanded.JUSTIFICATION)
        return "justification";
      if (code == RelatedArtifactTypeExpanded.CITATION)
        return "citation";
      if (code == RelatedArtifactTypeExpanded.PREDECESSOR)
        return "predecessor";
      if (code == RelatedArtifactTypeExpanded.SUCCESSOR)
        return "successor";
      if (code == RelatedArtifactTypeExpanded.DERIVEDFROM)
        return "derived-from";
      if (code == RelatedArtifactTypeExpanded.DEPENDSON)
        return "depends-on";
      if (code == RelatedArtifactTypeExpanded.COMPOSEDOF)
        return "composed-of";
      if (code == RelatedArtifactTypeExpanded.PARTOF)
        return "part-of";
      if (code == RelatedArtifactTypeExpanded.AMENDS)
        return "amends";
      if (code == RelatedArtifactTypeExpanded.AMENDEDWITH)
        return "amended-with";
      if (code == RelatedArtifactTypeExpanded.APPENDS)
        return "appends";
      if (code == RelatedArtifactTypeExpanded.APPENDEDWITH)
        return "appended-with";
      if (code == RelatedArtifactTypeExpanded.CITES)
        return "cites";
      if (code == RelatedArtifactTypeExpanded.CITEDBY)
        return "cited-by";
      if (code == RelatedArtifactTypeExpanded.COMMENTSON)
        return "comments-on";
      if (code == RelatedArtifactTypeExpanded.COMMENTIN)
        return "comment-in";
      if (code == RelatedArtifactTypeExpanded.CONTAINS)
        return "contains";
      if (code == RelatedArtifactTypeExpanded.CONTAINEDIN)
        return "contained-in";
      if (code == RelatedArtifactTypeExpanded.CORRECTS)
        return "corrects";
      if (code == RelatedArtifactTypeExpanded.CORRECTIONIN)
        return "correction-in";
      if (code == RelatedArtifactTypeExpanded.REPLACES)
        return "replaces";
      if (code == RelatedArtifactTypeExpanded.REPLACEDWITH)
        return "replaced-with";
      if (code == RelatedArtifactTypeExpanded.RETRACTS)
        return "retracts";
      if (code == RelatedArtifactTypeExpanded.RETRACTEDBY)
        return "retracted-by";
      if (code == RelatedArtifactTypeExpanded.SIGNS)
        return "signs";
      if (code == RelatedArtifactTypeExpanded.SIMILARTO)
        return "similar-to";
      if (code == RelatedArtifactTypeExpanded.SUPPORTS)
        return "supports";
      if (code == RelatedArtifactTypeExpanded.SUPPORTEDWITH)
        return "supported-with";
      if (code == RelatedArtifactTypeExpanded.TRANSFORMS)
        return "transforms";
      if (code == RelatedArtifactTypeExpanded.TRANSFORMEDINTO)
        return "transformed-into";
      if (code == RelatedArtifactTypeExpanded.TRANSFORMEDWITH)
        return "transformed-with";
      if (code == RelatedArtifactTypeExpanded.DOCUMENTS)
        return "documents";
      if (code == RelatedArtifactTypeExpanded.SPECIFICATIONOF)
        return "specification-of";
      if (code == RelatedArtifactTypeExpanded.CREATEDWITH)
        return "created-with";
      if (code == RelatedArtifactTypeExpanded.CITEAS)
        return "cite-as";
      if (code == RelatedArtifactTypeExpanded.REPRINT)
        return "reprint";
      if (code == RelatedArtifactTypeExpanded.REPRINTOF)
        return "reprint-of";
      return "?";
   }
    public String toSystem(RelatedArtifactTypeExpanded code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class CitationSummaryComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Format for display of the citation summary.
         */
        @Child(name = "style", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Format for display of the citation summary", formalDefinition="Format for display of the citation summary." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-summary-style")
        protected CodeableConcept style;

        /**
         * The human-readable display of the citation summary.
         */
        @Child(name = "text", type = {MarkdownType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The human-readable display of the citation summary", formalDefinition="The human-readable display of the citation summary." )
        protected MarkdownType text;

        private static final long serialVersionUID = 123416446L;

    /**
     * Constructor
     */
      public CitationSummaryComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationSummaryComponent(String text) {
        super();
        this.setText(text);
      }

        /**
         * @return {@link #style} (Format for display of the citation summary.)
         */
        public CodeableConcept getStyle() { 
          if (this.style == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationSummaryComponent.style");
            else if (Configuration.doAutoCreate())
              this.style = new CodeableConcept(); // cc
          return this.style;
        }

        public boolean hasStyle() { 
          return this.style != null && !this.style.isEmpty();
        }

        /**
         * @param value {@link #style} (Format for display of the citation summary.)
         */
        public CitationSummaryComponent setStyle(CodeableConcept value) { 
          this.style = value;
          return this;
        }

        /**
         * @return {@link #text} (The human-readable display of the citation summary.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public MarkdownType getTextElement() { 
          if (this.text == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationSummaryComponent.text");
            else if (Configuration.doAutoCreate())
              this.text = new MarkdownType(); // bb
          return this.text;
        }

        public boolean hasTextElement() { 
          return this.text != null && !this.text.isEmpty();
        }

        public boolean hasText() { 
          return this.text != null && !this.text.isEmpty();
        }

        /**
         * @param value {@link #text} (The human-readable display of the citation summary.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public CitationSummaryComponent setTextElement(MarkdownType value) { 
          this.text = value;
          return this;
        }

        /**
         * @return The human-readable display of the citation summary.
         */
        public String getText() { 
          return this.text == null ? null : this.text.getValue();
        }

        /**
         * @param value The human-readable display of the citation summary.
         */
        public CitationSummaryComponent setText(String value) { 
            if (this.text == null)
              this.text = new MarkdownType();
            this.text.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("style", "CodeableConcept", "Format for display of the citation summary.", 0, 1, style));
          children.add(new Property("text", "markdown", "The human-readable display of the citation summary.", 0, 1, text));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 109780401: /*style*/  return new Property("style", "CodeableConcept", "Format for display of the citation summary.", 0, 1, style);
          case 3556653: /*text*/  return new Property("text", "markdown", "The human-readable display of the citation summary.", 0, 1, text);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 109780401: /*style*/ return this.style == null ? new Base[0] : new Base[] {this.style}; // CodeableConcept
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 109780401: // style
          this.style = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3556653: // text
          this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("style")) {
          this.style = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("text")) {
          this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("style")) {
          this.style = null;
        } else if (name.equals("text")) {
          this.text = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 109780401:  return getStyle();
        case 3556653:  return getTextElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 109780401: /*style*/ return new String[] {"CodeableConcept"};
        case 3556653: /*text*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("style")) {
          this.style = new CodeableConcept();
          return this.style;
        }
        else if (name.equals("text")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.summary.text");
        }
        else
          return super.addChild(name);
      }

      public CitationSummaryComponent copy() {
        CitationSummaryComponent dst = new CitationSummaryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationSummaryComponent dst) {
        super.copyValues(dst);
        dst.style = style == null ? null : style.copy();
        dst.text = text == null ? null : text.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationSummaryComponent))
          return false;
        CitationSummaryComponent o = (CitationSummaryComponent) other_;
        return compareDeep(style, o.style, true) && compareDeep(text, o.text, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationSummaryComponent))
          return false;
        CitationSummaryComponent o = (CitationSummaryComponent) other_;
        return compareValues(text, o.text, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(style, text);
      }

  public String fhirType() {
    return "Citation.summary";

  }

  }

    @Block()
    public static class CitationClassificationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The kind of classifier (e.g. publication type, keyword).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The kind of classifier (e.g. publication type, keyword)", formalDefinition="The kind of classifier (e.g. publication type, keyword)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-classification-type")
        protected CodeableConcept type;

        /**
         * The specific classification value.
         */
        @Child(name = "classifier", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The specific classification value", formalDefinition="The specific classification value." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-artifact-classifier")
        protected List<CodeableConcept> classifier;

        private static final long serialVersionUID = -283121869L;

    /**
     * Constructor
     */
      public CitationClassificationComponent() {
        super();
      }

        /**
         * @return {@link #type} (The kind of classifier (e.g. publication type, keyword).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationClassificationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The kind of classifier (e.g. publication type, keyword).)
         */
        public CitationClassificationComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #classifier} (The specific classification value.)
         */
        public List<CodeableConcept> getClassifier() { 
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          return this.classifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationClassificationComponent setClassifier(List<CodeableConcept> theClassifier) { 
          this.classifier = theClassifier;
          return this;
        }

        public boolean hasClassifier() { 
          if (this.classifier == null)
            return false;
          for (CodeableConcept item : this.classifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addClassifier() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return t;
        }

        public CitationClassificationComponent addClassifier(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #classifier}, creating it if it does not already exist {3}
         */
        public CodeableConcept getClassifierFirstRep() { 
          if (getClassifier().isEmpty()) {
            addClassifier();
          }
          return getClassifier().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The kind of classifier (e.g. publication type, keyword).", 0, 1, type));
          children.add(new Property("classifier", "CodeableConcept", "The specific classification value.", 0, java.lang.Integer.MAX_VALUE, classifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The kind of classifier (e.g. publication type, keyword).", 0, 1, type);
          case -281470431: /*classifier*/  return new Property("classifier", "CodeableConcept", "The specific classification value.", 0, java.lang.Integer.MAX_VALUE, classifier);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -281470431: /*classifier*/ return this.classifier == null ? new Base[0] : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -281470431: // classifier
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("classifier")) {
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("classifier")) {
          this.getClassifier().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -281470431:  return addClassifier(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -281470431: /*classifier*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("classifier")) {
          return addClassifier();
        }
        else
          return super.addChild(name);
      }

      public CitationClassificationComponent copy() {
        CitationClassificationComponent dst = new CitationClassificationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationClassificationComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (classifier != null) {
          dst.classifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : classifier)
            dst.classifier.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationClassificationComponent))
          return false;
        CitationClassificationComponent o = (CitationClassificationComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(classifier, o.classifier, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationClassificationComponent))
          return false;
        CitationClassificationComponent o = (CitationClassificationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, classifier);
      }

  public String fhirType() {
    return "Citation.classification";

  }

  }

    @Block()
    public static class CitationStatusDateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The state or status of the citation record (that will be paired with the period).
         */
        @Child(name = "activity", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Classification of the status", formalDefinition="The state or status of the citation record (that will be paired with the period)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-status-type")
        protected CodeableConcept activity;

        /**
         * Whether the status date is actual (has occurred) or expected (estimated or anticipated).
         */
        @Child(name = "actual", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Either occurred or expected", formalDefinition="Whether the status date is actual (has occurred) or expected (estimated or anticipated)." )
        protected BooleanType actual;

        /**
         * When the status started and/or ended.
         */
        @Child(name = "period", type = {Period.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the status started and/or ended", formalDefinition="When the status started and/or ended." )
        protected Period period;

        private static final long serialVersionUID = 1123586924L;

    /**
     * Constructor
     */
      public CitationStatusDateComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationStatusDateComponent(CodeableConcept activity, Period period) {
        super();
        this.setActivity(activity);
        this.setPeriod(period);
      }

        /**
         * @return {@link #activity} (The state or status of the citation record (that will be paired with the period).)
         */
        public CodeableConcept getActivity() { 
          if (this.activity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationStatusDateComponent.activity");
            else if (Configuration.doAutoCreate())
              this.activity = new CodeableConcept(); // cc
          return this.activity;
        }

        public boolean hasActivity() { 
          return this.activity != null && !this.activity.isEmpty();
        }

        /**
         * @param value {@link #activity} (The state or status of the citation record (that will be paired with the period).)
         */
        public CitationStatusDateComponent setActivity(CodeableConcept value) { 
          this.activity = value;
          return this;
        }

        /**
         * @return {@link #actual} (Whether the status date is actual (has occurred) or expected (estimated or anticipated).). This is the underlying object with id, value and extensions. The accessor "getActual" gives direct access to the value
         */
        public BooleanType getActualElement() { 
          if (this.actual == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationStatusDateComponent.actual");
            else if (Configuration.doAutoCreate())
              this.actual = new BooleanType(); // bb
          return this.actual;
        }

        public boolean hasActualElement() { 
          return this.actual != null && !this.actual.isEmpty();
        }

        public boolean hasActual() { 
          return this.actual != null && !this.actual.isEmpty();
        }

        /**
         * @param value {@link #actual} (Whether the status date is actual (has occurred) or expected (estimated or anticipated).). This is the underlying object with id, value and extensions. The accessor "getActual" gives direct access to the value
         */
        public CitationStatusDateComponent setActualElement(BooleanType value) { 
          this.actual = value;
          return this;
        }

        /**
         * @return Whether the status date is actual (has occurred) or expected (estimated or anticipated).
         */
        public boolean getActual() { 
          return this.actual == null || this.actual.isEmpty() ? false : this.actual.getValue();
        }

        /**
         * @param value Whether the status date is actual (has occurred) or expected (estimated or anticipated).
         */
        public CitationStatusDateComponent setActual(boolean value) { 
            if (this.actual == null)
              this.actual = new BooleanType();
            this.actual.setValue(value);
          return this;
        }

        /**
         * @return {@link #period} (When the status started and/or ended.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationStatusDateComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (When the status started and/or ended.)
         */
        public CitationStatusDateComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("activity", "CodeableConcept", "The state or status of the citation record (that will be paired with the period).", 0, 1, activity));
          children.add(new Property("actual", "boolean", "Whether the status date is actual (has occurred) or expected (estimated or anticipated).", 0, 1, actual));
          children.add(new Property("period", "Period", "When the status started and/or ended.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1655966961: /*activity*/  return new Property("activity", "CodeableConcept", "The state or status of the citation record (that will be paired with the period).", 0, 1, activity);
          case -1422939762: /*actual*/  return new Property("actual", "boolean", "Whether the status date is actual (has occurred) or expected (estimated or anticipated).", 0, 1, actual);
          case -991726143: /*period*/  return new Property("period", "Period", "When the status started and/or ended.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1655966961: /*activity*/ return this.activity == null ? new Base[0] : new Base[] {this.activity}; // CodeableConcept
        case -1422939762: /*actual*/ return this.actual == null ? new Base[0] : new Base[] {this.actual}; // BooleanType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1655966961: // activity
          this.activity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1422939762: // actual
          this.actual = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("activity")) {
          this.activity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actual")) {
          this.actual = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("activity")) {
          this.activity = null;
        } else if (name.equals("actual")) {
          this.actual = null;
        } else if (name.equals("period")) {
          this.period = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1655966961:  return getActivity();
        case -1422939762:  return getActualElement();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1655966961: /*activity*/ return new String[] {"CodeableConcept"};
        case -1422939762: /*actual*/ return new String[] {"boolean"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("activity")) {
          this.activity = new CodeableConcept();
          return this.activity;
        }
        else if (name.equals("actual")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.statusDate.actual");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public CitationStatusDateComponent copy() {
        CitationStatusDateComponent dst = new CitationStatusDateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationStatusDateComponent dst) {
        super.copyValues(dst);
        dst.activity = activity == null ? null : activity.copy();
        dst.actual = actual == null ? null : actual.copy();
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationStatusDateComponent))
          return false;
        CitationStatusDateComponent o = (CitationStatusDateComponent) other_;
        return compareDeep(activity, o.activity, true) && compareDeep(actual, o.actual, true) && compareDeep(period, o.period, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationStatusDateComponent))
          return false;
        CitationStatusDateComponent o = (CitationStatusDateComponent) other_;
        return compareValues(actual, o.actual, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(activity, actual, period
          );
      }

  public String fhirType() {
    return "Citation.statusDate";

  }

  }

    @Block()
    public static class CitationCitedArtifactComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A formal identifier that is used to identify the cited artifact when it is represented in other formats, or referenced in a specification, model, design or an instance.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Unique identifier. May include DOI, PMID, PMCID, etc", formalDefinition="A formal identifier that is used to identify the cited artifact when it is represented in other formats, or referenced in a specification, model, design or an instance." )
        protected List<Identifier> identifier;

        /**
         * A formal identifier that is used to identify things closely related to the cited artifact.
         */
        @Child(name = "relatedIdentifier", type = {Identifier.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Identifier not unique to the cited artifact. May include trial registry identifiers", formalDefinition="A formal identifier that is used to identify things closely related to the cited artifact." )
        protected List<Identifier> relatedIdentifier;

        /**
         * When the cited artifact was accessed.
         */
        @Child(name = "dateAccessed", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="When the cited artifact was accessed", formalDefinition="When the cited artifact was accessed." )
        protected DateTimeType dateAccessed;

        /**
         * The defined version of the cited artifact.
         */
        @Child(name = "version", type = {}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The defined version of the cited artifact", formalDefinition="The defined version of the cited artifact." )
        protected CitationCitedArtifactVersionComponent version;

        /**
         * The status of the cited artifact.
         */
        @Child(name = "currentState", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The status of the cited artifact", formalDefinition="The status of the cited artifact." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/cited-artifact-status-type")
        protected List<CodeableConcept> currentState;

        /**
         * An effective date or period, historical or future, actual or expected, for a status of the cited artifact.
         */
        @Child(name = "statusDate", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="An effective date or period for a status of the cited artifact", formalDefinition="An effective date or period, historical or future, actual or expected, for a status of the cited artifact." )
        protected List<CitationCitedArtifactStatusDateComponent> statusDate;

        /**
         * The title details of the article or artifact.
         */
        @Child(name = "title", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The title details of the article or artifact", formalDefinition="The title details of the article or artifact." )
        protected List<CitationCitedArtifactTitleComponent> title;

        /**
         * The abstract may be used to convey article-contained abstracts, externally-created abstracts, or other descriptive summaries.
         */
        @Child(name = "abstract", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Summary of the article or artifact", formalDefinition="The abstract may be used to convey article-contained abstracts, externally-created abstracts, or other descriptive summaries." )
        protected List<CitationCitedArtifactAbstractComponent> abstract_;

        /**
         * The component of the article or artifact.
         */
        @Child(name = "part", type = {}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The component of the article or artifact", formalDefinition="The component of the article or artifact." )
        protected CitationCitedArtifactPartComponent part;

        /**
         * The artifact related to the cited artifact.
         */
        @Child(name = "relatesTo", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The artifact related to the cited artifact", formalDefinition="The artifact related to the cited artifact." )
        protected List<CitationCitedArtifactRelatesToComponent> relatesTo;

        /**
         * If multiple, used to represent alternative forms of the article that are not separate citations.
         */
        @Child(name = "publicationForm", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="If multiple, used to represent alternative forms of the article that are not separate citations", formalDefinition="If multiple, used to represent alternative forms of the article that are not separate citations." )
        protected List<CitationCitedArtifactPublicationFormComponent> publicationForm;

        /**
         * Used for any URL for the article or artifact cited.
         */
        @Child(name = "webLocation", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Used for any URL for the article or artifact cited", formalDefinition="Used for any URL for the article or artifact cited." )
        protected List<CitationCitedArtifactWebLocationComponent> webLocation;

        /**
         * The assignment to an organizing scheme.
         */
        @Child(name = "classification", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The assignment to an organizing scheme", formalDefinition="The assignment to an organizing scheme." )
        protected List<CitationCitedArtifactClassificationComponent> classification;

        /**
         * This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.
         */
        @Child(name = "contributorship", type = {}, order=14, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Attribution of authors and other contributors", formalDefinition="This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements." )
        protected CitationCitedArtifactContributorshipComponent contributorship;

        /**
         * Any additional information or content for the article or artifact.
         */
        @Child(name = "note", type = {Annotation.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Any additional information or content for the article or artifact", formalDefinition="Any additional information or content for the article or artifact." )
        protected List<Annotation> note;

        private static final long serialVersionUID = -1685890486L;

    /**
     * Constructor
     */
      public CitationCitedArtifactComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (A formal identifier that is used to identify the cited artifact when it is represented in other formats, or referenced in a specification, model, design or an instance.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setIdentifier(List<Identifier> theIdentifier) { 
          this.identifier = theIdentifier;
          return this;
        }

        public boolean hasIdentifier() { 
          if (this.identifier == null)
            return false;
          for (Identifier item : this.identifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Identifier addIdentifier() { //3
          Identifier t = new Identifier();
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addIdentifier(Identifier t) { //3
          if (t == null)
            return this;
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
         */
        public Identifier getIdentifierFirstRep() { 
          if (getIdentifier().isEmpty()) {
            addIdentifier();
          }
          return getIdentifier().get(0);
        }

        /**
         * @return {@link #relatedIdentifier} (A formal identifier that is used to identify things closely related to the cited artifact.)
         */
        public List<Identifier> getRelatedIdentifier() { 
          if (this.relatedIdentifier == null)
            this.relatedIdentifier = new ArrayList<Identifier>();
          return this.relatedIdentifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setRelatedIdentifier(List<Identifier> theRelatedIdentifier) { 
          this.relatedIdentifier = theRelatedIdentifier;
          return this;
        }

        public boolean hasRelatedIdentifier() { 
          if (this.relatedIdentifier == null)
            return false;
          for (Identifier item : this.relatedIdentifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Identifier addRelatedIdentifier() { //3
          Identifier t = new Identifier();
          if (this.relatedIdentifier == null)
            this.relatedIdentifier = new ArrayList<Identifier>();
          this.relatedIdentifier.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addRelatedIdentifier(Identifier t) { //3
          if (t == null)
            return this;
          if (this.relatedIdentifier == null)
            this.relatedIdentifier = new ArrayList<Identifier>();
          this.relatedIdentifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #relatedIdentifier}, creating it if it does not already exist {3}
         */
        public Identifier getRelatedIdentifierFirstRep() { 
          if (getRelatedIdentifier().isEmpty()) {
            addRelatedIdentifier();
          }
          return getRelatedIdentifier().get(0);
        }

        /**
         * @return {@link #dateAccessed} (When the cited artifact was accessed.). This is the underlying object with id, value and extensions. The accessor "getDateAccessed" gives direct access to the value
         */
        public DateTimeType getDateAccessedElement() { 
          if (this.dateAccessed == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactComponent.dateAccessed");
            else if (Configuration.doAutoCreate())
              this.dateAccessed = new DateTimeType(); // bb
          return this.dateAccessed;
        }

        public boolean hasDateAccessedElement() { 
          return this.dateAccessed != null && !this.dateAccessed.isEmpty();
        }

        public boolean hasDateAccessed() { 
          return this.dateAccessed != null && !this.dateAccessed.isEmpty();
        }

        /**
         * @param value {@link #dateAccessed} (When the cited artifact was accessed.). This is the underlying object with id, value and extensions. The accessor "getDateAccessed" gives direct access to the value
         */
        public CitationCitedArtifactComponent setDateAccessedElement(DateTimeType value) { 
          this.dateAccessed = value;
          return this;
        }

        /**
         * @return When the cited artifact was accessed.
         */
        public Date getDateAccessed() { 
          return this.dateAccessed == null ? null : this.dateAccessed.getValue();
        }

        /**
         * @param value When the cited artifact was accessed.
         */
        public CitationCitedArtifactComponent setDateAccessed(Date value) { 
          if (value == null)
            this.dateAccessed = null;
          else {
            if (this.dateAccessed == null)
              this.dateAccessed = new DateTimeType();
            this.dateAccessed.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #version} (The defined version of the cited artifact.)
         */
        public CitationCitedArtifactVersionComponent getVersion() { 
          if (this.version == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactComponent.version");
            else if (Configuration.doAutoCreate())
              this.version = new CitationCitedArtifactVersionComponent(); // cc
          return this.version;
        }

        public boolean hasVersion() { 
          return this.version != null && !this.version.isEmpty();
        }

        /**
         * @param value {@link #version} (The defined version of the cited artifact.)
         */
        public CitationCitedArtifactComponent setVersion(CitationCitedArtifactVersionComponent value) { 
          this.version = value;
          return this;
        }

        /**
         * @return {@link #currentState} (The status of the cited artifact.)
         */
        public List<CodeableConcept> getCurrentState() { 
          if (this.currentState == null)
            this.currentState = new ArrayList<CodeableConcept>();
          return this.currentState;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setCurrentState(List<CodeableConcept> theCurrentState) { 
          this.currentState = theCurrentState;
          return this;
        }

        public boolean hasCurrentState() { 
          if (this.currentState == null)
            return false;
          for (CodeableConcept item : this.currentState)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addCurrentState() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.currentState == null)
            this.currentState = new ArrayList<CodeableConcept>();
          this.currentState.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addCurrentState(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.currentState == null)
            this.currentState = new ArrayList<CodeableConcept>();
          this.currentState.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #currentState}, creating it if it does not already exist {3}
         */
        public CodeableConcept getCurrentStateFirstRep() { 
          if (getCurrentState().isEmpty()) {
            addCurrentState();
          }
          return getCurrentState().get(0);
        }

        /**
         * @return {@link #statusDate} (An effective date or period, historical or future, actual or expected, for a status of the cited artifact.)
         */
        public List<CitationCitedArtifactStatusDateComponent> getStatusDate() { 
          if (this.statusDate == null)
            this.statusDate = new ArrayList<CitationCitedArtifactStatusDateComponent>();
          return this.statusDate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setStatusDate(List<CitationCitedArtifactStatusDateComponent> theStatusDate) { 
          this.statusDate = theStatusDate;
          return this;
        }

        public boolean hasStatusDate() { 
          if (this.statusDate == null)
            return false;
          for (CitationCitedArtifactStatusDateComponent item : this.statusDate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationCitedArtifactStatusDateComponent addStatusDate() { //3
          CitationCitedArtifactStatusDateComponent t = new CitationCitedArtifactStatusDateComponent();
          if (this.statusDate == null)
            this.statusDate = new ArrayList<CitationCitedArtifactStatusDateComponent>();
          this.statusDate.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addStatusDate(CitationCitedArtifactStatusDateComponent t) { //3
          if (t == null)
            return this;
          if (this.statusDate == null)
            this.statusDate = new ArrayList<CitationCitedArtifactStatusDateComponent>();
          this.statusDate.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #statusDate}, creating it if it does not already exist {3}
         */
        public CitationCitedArtifactStatusDateComponent getStatusDateFirstRep() { 
          if (getStatusDate().isEmpty()) {
            addStatusDate();
          }
          return getStatusDate().get(0);
        }

        /**
         * @return {@link #title} (The title details of the article or artifact.)
         */
        public List<CitationCitedArtifactTitleComponent> getTitle() { 
          if (this.title == null)
            this.title = new ArrayList<CitationCitedArtifactTitleComponent>();
          return this.title;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setTitle(List<CitationCitedArtifactTitleComponent> theTitle) { 
          this.title = theTitle;
          return this;
        }

        public boolean hasTitle() { 
          if (this.title == null)
            return false;
          for (CitationCitedArtifactTitleComponent item : this.title)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationCitedArtifactTitleComponent addTitle() { //3
          CitationCitedArtifactTitleComponent t = new CitationCitedArtifactTitleComponent();
          if (this.title == null)
            this.title = new ArrayList<CitationCitedArtifactTitleComponent>();
          this.title.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addTitle(CitationCitedArtifactTitleComponent t) { //3
          if (t == null)
            return this;
          if (this.title == null)
            this.title = new ArrayList<CitationCitedArtifactTitleComponent>();
          this.title.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #title}, creating it if it does not already exist {3}
         */
        public CitationCitedArtifactTitleComponent getTitleFirstRep() { 
          if (getTitle().isEmpty()) {
            addTitle();
          }
          return getTitle().get(0);
        }

        /**
         * @return {@link #abstract_} (The abstract may be used to convey article-contained abstracts, externally-created abstracts, or other descriptive summaries.)
         */
        public List<CitationCitedArtifactAbstractComponent> getAbstract() { 
          if (this.abstract_ == null)
            this.abstract_ = new ArrayList<CitationCitedArtifactAbstractComponent>();
          return this.abstract_;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setAbstract(List<CitationCitedArtifactAbstractComponent> theAbstract) { 
          this.abstract_ = theAbstract;
          return this;
        }

        public boolean hasAbstract() { 
          if (this.abstract_ == null)
            return false;
          for (CitationCitedArtifactAbstractComponent item : this.abstract_)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationCitedArtifactAbstractComponent addAbstract() { //3
          CitationCitedArtifactAbstractComponent t = new CitationCitedArtifactAbstractComponent();
          if (this.abstract_ == null)
            this.abstract_ = new ArrayList<CitationCitedArtifactAbstractComponent>();
          this.abstract_.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addAbstract(CitationCitedArtifactAbstractComponent t) { //3
          if (t == null)
            return this;
          if (this.abstract_ == null)
            this.abstract_ = new ArrayList<CitationCitedArtifactAbstractComponent>();
          this.abstract_.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #abstract_}, creating it if it does not already exist {3}
         */
        public CitationCitedArtifactAbstractComponent getAbstractFirstRep() { 
          if (getAbstract().isEmpty()) {
            addAbstract();
          }
          return getAbstract().get(0);
        }

        /**
         * @return {@link #part} (The component of the article or artifact.)
         */
        public CitationCitedArtifactPartComponent getPart() { 
          if (this.part == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactComponent.part");
            else if (Configuration.doAutoCreate())
              this.part = new CitationCitedArtifactPartComponent(); // cc
          return this.part;
        }

        public boolean hasPart() { 
          return this.part != null && !this.part.isEmpty();
        }

        /**
         * @param value {@link #part} (The component of the article or artifact.)
         */
        public CitationCitedArtifactComponent setPart(CitationCitedArtifactPartComponent value) { 
          this.part = value;
          return this;
        }

        /**
         * @return {@link #relatesTo} (The artifact related to the cited artifact.)
         */
        public List<CitationCitedArtifactRelatesToComponent> getRelatesTo() { 
          if (this.relatesTo == null)
            this.relatesTo = new ArrayList<CitationCitedArtifactRelatesToComponent>();
          return this.relatesTo;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setRelatesTo(List<CitationCitedArtifactRelatesToComponent> theRelatesTo) { 
          this.relatesTo = theRelatesTo;
          return this;
        }

        public boolean hasRelatesTo() { 
          if (this.relatesTo == null)
            return false;
          for (CitationCitedArtifactRelatesToComponent item : this.relatesTo)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationCitedArtifactRelatesToComponent addRelatesTo() { //3
          CitationCitedArtifactRelatesToComponent t = new CitationCitedArtifactRelatesToComponent();
          if (this.relatesTo == null)
            this.relatesTo = new ArrayList<CitationCitedArtifactRelatesToComponent>();
          this.relatesTo.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addRelatesTo(CitationCitedArtifactRelatesToComponent t) { //3
          if (t == null)
            return this;
          if (this.relatesTo == null)
            this.relatesTo = new ArrayList<CitationCitedArtifactRelatesToComponent>();
          this.relatesTo.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #relatesTo}, creating it if it does not already exist {3}
         */
        public CitationCitedArtifactRelatesToComponent getRelatesToFirstRep() { 
          if (getRelatesTo().isEmpty()) {
            addRelatesTo();
          }
          return getRelatesTo().get(0);
        }

        /**
         * @return {@link #publicationForm} (If multiple, used to represent alternative forms of the article that are not separate citations.)
         */
        public List<CitationCitedArtifactPublicationFormComponent> getPublicationForm() { 
          if (this.publicationForm == null)
            this.publicationForm = new ArrayList<CitationCitedArtifactPublicationFormComponent>();
          return this.publicationForm;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setPublicationForm(List<CitationCitedArtifactPublicationFormComponent> thePublicationForm) { 
          this.publicationForm = thePublicationForm;
          return this;
        }

        public boolean hasPublicationForm() { 
          if (this.publicationForm == null)
            return false;
          for (CitationCitedArtifactPublicationFormComponent item : this.publicationForm)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationCitedArtifactPublicationFormComponent addPublicationForm() { //3
          CitationCitedArtifactPublicationFormComponent t = new CitationCitedArtifactPublicationFormComponent();
          if (this.publicationForm == null)
            this.publicationForm = new ArrayList<CitationCitedArtifactPublicationFormComponent>();
          this.publicationForm.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addPublicationForm(CitationCitedArtifactPublicationFormComponent t) { //3
          if (t == null)
            return this;
          if (this.publicationForm == null)
            this.publicationForm = new ArrayList<CitationCitedArtifactPublicationFormComponent>();
          this.publicationForm.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #publicationForm}, creating it if it does not already exist {3}
         */
        public CitationCitedArtifactPublicationFormComponent getPublicationFormFirstRep() { 
          if (getPublicationForm().isEmpty()) {
            addPublicationForm();
          }
          return getPublicationForm().get(0);
        }

        /**
         * @return {@link #webLocation} (Used for any URL for the article or artifact cited.)
         */
        public List<CitationCitedArtifactWebLocationComponent> getWebLocation() { 
          if (this.webLocation == null)
            this.webLocation = new ArrayList<CitationCitedArtifactWebLocationComponent>();
          return this.webLocation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setWebLocation(List<CitationCitedArtifactWebLocationComponent> theWebLocation) { 
          this.webLocation = theWebLocation;
          return this;
        }

        public boolean hasWebLocation() { 
          if (this.webLocation == null)
            return false;
          for (CitationCitedArtifactWebLocationComponent item : this.webLocation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationCitedArtifactWebLocationComponent addWebLocation() { //3
          CitationCitedArtifactWebLocationComponent t = new CitationCitedArtifactWebLocationComponent();
          if (this.webLocation == null)
            this.webLocation = new ArrayList<CitationCitedArtifactWebLocationComponent>();
          this.webLocation.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addWebLocation(CitationCitedArtifactWebLocationComponent t) { //3
          if (t == null)
            return this;
          if (this.webLocation == null)
            this.webLocation = new ArrayList<CitationCitedArtifactWebLocationComponent>();
          this.webLocation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #webLocation}, creating it if it does not already exist {3}
         */
        public CitationCitedArtifactWebLocationComponent getWebLocationFirstRep() { 
          if (getWebLocation().isEmpty()) {
            addWebLocation();
          }
          return getWebLocation().get(0);
        }

        /**
         * @return {@link #classification} (The assignment to an organizing scheme.)
         */
        public List<CitationCitedArtifactClassificationComponent> getClassification() { 
          if (this.classification == null)
            this.classification = new ArrayList<CitationCitedArtifactClassificationComponent>();
          return this.classification;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setClassification(List<CitationCitedArtifactClassificationComponent> theClassification) { 
          this.classification = theClassification;
          return this;
        }

        public boolean hasClassification() { 
          if (this.classification == null)
            return false;
          for (CitationCitedArtifactClassificationComponent item : this.classification)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationCitedArtifactClassificationComponent addClassification() { //3
          CitationCitedArtifactClassificationComponent t = new CitationCitedArtifactClassificationComponent();
          if (this.classification == null)
            this.classification = new ArrayList<CitationCitedArtifactClassificationComponent>();
          this.classification.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addClassification(CitationCitedArtifactClassificationComponent t) { //3
          if (t == null)
            return this;
          if (this.classification == null)
            this.classification = new ArrayList<CitationCitedArtifactClassificationComponent>();
          this.classification.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #classification}, creating it if it does not already exist {3}
         */
        public CitationCitedArtifactClassificationComponent getClassificationFirstRep() { 
          if (getClassification().isEmpty()) {
            addClassification();
          }
          return getClassification().get(0);
        }

        /**
         * @return {@link #contributorship} (This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.)
         */
        public CitationCitedArtifactContributorshipComponent getContributorship() { 
          if (this.contributorship == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactComponent.contributorship");
            else if (Configuration.doAutoCreate())
              this.contributorship = new CitationCitedArtifactContributorshipComponent(); // cc
          return this.contributorship;
        }

        public boolean hasContributorship() { 
          return this.contributorship != null && !this.contributorship.isEmpty();
        }

        /**
         * @param value {@link #contributorship} (This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.)
         */
        public CitationCitedArtifactComponent setContributorship(CitationCitedArtifactContributorshipComponent value) { 
          this.contributorship = value;
          return this;
        }

        /**
         * @return {@link #note} (Any additional information or content for the article or artifact.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactComponent setNote(List<Annotation> theNote) { 
          this.note = theNote;
          return this;
        }

        public boolean hasNote() { 
          if (this.note == null)
            return false;
          for (Annotation item : this.note)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Annotation addNote() { //3
          Annotation t = new Annotation();
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          this.note.add(t);
          return t;
        }

        public CitationCitedArtifactComponent addNote(Annotation t) { //3
          if (t == null)
            return this;
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          this.note.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
         */
        public Annotation getNoteFirstRep() { 
          if (getNote().isEmpty()) {
            addNote();
          }
          return getNote().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify the cited artifact when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("relatedIdentifier", "Identifier", "A formal identifier that is used to identify things closely related to the cited artifact.", 0, java.lang.Integer.MAX_VALUE, relatedIdentifier));
          children.add(new Property("dateAccessed", "dateTime", "When the cited artifact was accessed.", 0, 1, dateAccessed));
          children.add(new Property("version", "", "The defined version of the cited artifact.", 0, 1, version));
          children.add(new Property("currentState", "CodeableConcept", "The status of the cited artifact.", 0, java.lang.Integer.MAX_VALUE, currentState));
          children.add(new Property("statusDate", "", "An effective date or period, historical or future, actual or expected, for a status of the cited artifact.", 0, java.lang.Integer.MAX_VALUE, statusDate));
          children.add(new Property("title", "", "The title details of the article or artifact.", 0, java.lang.Integer.MAX_VALUE, title));
          children.add(new Property("abstract", "", "The abstract may be used to convey article-contained abstracts, externally-created abstracts, or other descriptive summaries.", 0, java.lang.Integer.MAX_VALUE, abstract_));
          children.add(new Property("part", "", "The component of the article or artifact.", 0, 1, part));
          children.add(new Property("relatesTo", "", "The artifact related to the cited artifact.", 0, java.lang.Integer.MAX_VALUE, relatesTo));
          children.add(new Property("publicationForm", "", "If multiple, used to represent alternative forms of the article that are not separate citations.", 0, java.lang.Integer.MAX_VALUE, publicationForm));
          children.add(new Property("webLocation", "", "Used for any URL for the article or artifact cited.", 0, java.lang.Integer.MAX_VALUE, webLocation));
          children.add(new Property("classification", "", "The assignment to an organizing scheme.", 0, java.lang.Integer.MAX_VALUE, classification));
          children.add(new Property("contributorship", "", "This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.", 0, 1, contributorship));
          children.add(new Property("note", "Annotation", "Any additional information or content for the article or artifact.", 0, java.lang.Integer.MAX_VALUE, note));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify the cited artifact when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case -1007604940: /*relatedIdentifier*/  return new Property("relatedIdentifier", "Identifier", "A formal identifier that is used to identify things closely related to the cited artifact.", 0, java.lang.Integer.MAX_VALUE, relatedIdentifier);
          case 540917457: /*dateAccessed*/  return new Property("dateAccessed", "dateTime", "When the cited artifact was accessed.", 0, 1, dateAccessed);
          case 351608024: /*version*/  return new Property("version", "", "The defined version of the cited artifact.", 0, 1, version);
          case 1457822360: /*currentState*/  return new Property("currentState", "CodeableConcept", "The status of the cited artifact.", 0, java.lang.Integer.MAX_VALUE, currentState);
          case 247524032: /*statusDate*/  return new Property("statusDate", "", "An effective date or period, historical or future, actual or expected, for a status of the cited artifact.", 0, java.lang.Integer.MAX_VALUE, statusDate);
          case 110371416: /*title*/  return new Property("title", "", "The title details of the article or artifact.", 0, java.lang.Integer.MAX_VALUE, title);
          case 1732898850: /*abstract*/  return new Property("abstract", "", "The abstract may be used to convey article-contained abstracts, externally-created abstracts, or other descriptive summaries.", 0, java.lang.Integer.MAX_VALUE, abstract_);
          case 3433459: /*part*/  return new Property("part", "", "The component of the article or artifact.", 0, 1, part);
          case -7765931: /*relatesTo*/  return new Property("relatesTo", "", "The artifact related to the cited artifact.", 0, java.lang.Integer.MAX_VALUE, relatesTo);
          case 1470639376: /*publicationForm*/  return new Property("publicationForm", "", "If multiple, used to represent alternative forms of the article that are not separate citations.", 0, java.lang.Integer.MAX_VALUE, publicationForm);
          case -828032215: /*webLocation*/  return new Property("webLocation", "", "Used for any URL for the article or artifact cited.", 0, java.lang.Integer.MAX_VALUE, webLocation);
          case 382350310: /*classification*/  return new Property("classification", "", "The assignment to an organizing scheme.", 0, java.lang.Integer.MAX_VALUE, classification);
          case 538727831: /*contributorship*/  return new Property("contributorship", "", "This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.", 0, 1, contributorship);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Any additional information or content for the article or artifact.", 0, java.lang.Integer.MAX_VALUE, note);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1007604940: /*relatedIdentifier*/ return this.relatedIdentifier == null ? new Base[0] : this.relatedIdentifier.toArray(new Base[this.relatedIdentifier.size()]); // Identifier
        case 540917457: /*dateAccessed*/ return this.dateAccessed == null ? new Base[0] : new Base[] {this.dateAccessed}; // DateTimeType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // CitationCitedArtifactVersionComponent
        case 1457822360: /*currentState*/ return this.currentState == null ? new Base[0] : this.currentState.toArray(new Base[this.currentState.size()]); // CodeableConcept
        case 247524032: /*statusDate*/ return this.statusDate == null ? new Base[0] : this.statusDate.toArray(new Base[this.statusDate.size()]); // CitationCitedArtifactStatusDateComponent
        case 110371416: /*title*/ return this.title == null ? new Base[0] : this.title.toArray(new Base[this.title.size()]); // CitationCitedArtifactTitleComponent
        case 1732898850: /*abstract*/ return this.abstract_ == null ? new Base[0] : this.abstract_.toArray(new Base[this.abstract_.size()]); // CitationCitedArtifactAbstractComponent
        case 3433459: /*part*/ return this.part == null ? new Base[0] : new Base[] {this.part}; // CitationCitedArtifactPartComponent
        case -7765931: /*relatesTo*/ return this.relatesTo == null ? new Base[0] : this.relatesTo.toArray(new Base[this.relatesTo.size()]); // CitationCitedArtifactRelatesToComponent
        case 1470639376: /*publicationForm*/ return this.publicationForm == null ? new Base[0] : this.publicationForm.toArray(new Base[this.publicationForm.size()]); // CitationCitedArtifactPublicationFormComponent
        case -828032215: /*webLocation*/ return this.webLocation == null ? new Base[0] : this.webLocation.toArray(new Base[this.webLocation.size()]); // CitationCitedArtifactWebLocationComponent
        case 382350310: /*classification*/ return this.classification == null ? new Base[0] : this.classification.toArray(new Base[this.classification.size()]); // CitationCitedArtifactClassificationComponent
        case 538727831: /*contributorship*/ return this.contributorship == null ? new Base[0] : new Base[] {this.contributorship}; // CitationCitedArtifactContributorshipComponent
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1007604940: // relatedIdentifier
          this.getRelatedIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 540917457: // dateAccessed
          this.dateAccessed = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 351608024: // version
          this.version = (CitationCitedArtifactVersionComponent) value; // CitationCitedArtifactVersionComponent
          return value;
        case 1457822360: // currentState
          this.getCurrentState().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 247524032: // statusDate
          this.getStatusDate().add((CitationCitedArtifactStatusDateComponent) value); // CitationCitedArtifactStatusDateComponent
          return value;
        case 110371416: // title
          this.getTitle().add((CitationCitedArtifactTitleComponent) value); // CitationCitedArtifactTitleComponent
          return value;
        case 1732898850: // abstract
          this.getAbstract().add((CitationCitedArtifactAbstractComponent) value); // CitationCitedArtifactAbstractComponent
          return value;
        case 3433459: // part
          this.part = (CitationCitedArtifactPartComponent) value; // CitationCitedArtifactPartComponent
          return value;
        case -7765931: // relatesTo
          this.getRelatesTo().add((CitationCitedArtifactRelatesToComponent) value); // CitationCitedArtifactRelatesToComponent
          return value;
        case 1470639376: // publicationForm
          this.getPublicationForm().add((CitationCitedArtifactPublicationFormComponent) value); // CitationCitedArtifactPublicationFormComponent
          return value;
        case -828032215: // webLocation
          this.getWebLocation().add((CitationCitedArtifactWebLocationComponent) value); // CitationCitedArtifactWebLocationComponent
          return value;
        case 382350310: // classification
          this.getClassification().add((CitationCitedArtifactClassificationComponent) value); // CitationCitedArtifactClassificationComponent
          return value;
        case 538727831: // contributorship
          this.contributorship = (CitationCitedArtifactContributorshipComponent) value; // CitationCitedArtifactContributorshipComponent
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("relatedIdentifier")) {
          this.getRelatedIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("dateAccessed")) {
          this.dateAccessed = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("version")) {
          this.version = (CitationCitedArtifactVersionComponent) value; // CitationCitedArtifactVersionComponent
        } else if (name.equals("currentState")) {
          this.getCurrentState().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("statusDate")) {
          this.getStatusDate().add((CitationCitedArtifactStatusDateComponent) value);
        } else if (name.equals("title")) {
          this.getTitle().add((CitationCitedArtifactTitleComponent) value);
        } else if (name.equals("abstract")) {
          this.getAbstract().add((CitationCitedArtifactAbstractComponent) value);
        } else if (name.equals("part")) {
          this.part = (CitationCitedArtifactPartComponent) value; // CitationCitedArtifactPartComponent
        } else if (name.equals("relatesTo")) {
          this.getRelatesTo().add((CitationCitedArtifactRelatesToComponent) value);
        } else if (name.equals("publicationForm")) {
          this.getPublicationForm().add((CitationCitedArtifactPublicationFormComponent) value);
        } else if (name.equals("webLocation")) {
          this.getWebLocation().add((CitationCitedArtifactWebLocationComponent) value);
        } else if (name.equals("classification")) {
          this.getClassification().add((CitationCitedArtifactClassificationComponent) value);
        } else if (name.equals("contributorship")) {
          this.contributorship = (CitationCitedArtifactContributorshipComponent) value; // CitationCitedArtifactContributorshipComponent
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("relatedIdentifier")) {
          this.getRelatedIdentifier().remove(value);
        } else if (name.equals("dateAccessed")) {
          this.dateAccessed = null;
        } else if (name.equals("version")) {
          this.version = (CitationCitedArtifactVersionComponent) value; // CitationCitedArtifactVersionComponent
        } else if (name.equals("currentState")) {
          this.getCurrentState().remove(value);
        } else if (name.equals("statusDate")) {
          this.getStatusDate().remove((CitationCitedArtifactStatusDateComponent) value);
        } else if (name.equals("title")) {
          this.getTitle().remove((CitationCitedArtifactTitleComponent) value);
        } else if (name.equals("abstract")) {
          this.getAbstract().remove((CitationCitedArtifactAbstractComponent) value);
        } else if (name.equals("part")) {
          this.part = (CitationCitedArtifactPartComponent) value; // CitationCitedArtifactPartComponent
        } else if (name.equals("relatesTo")) {
          this.getRelatesTo().remove((CitationCitedArtifactRelatesToComponent) value);
        } else if (name.equals("publicationForm")) {
          this.getPublicationForm().remove((CitationCitedArtifactPublicationFormComponent) value);
        } else if (name.equals("webLocation")) {
          this.getWebLocation().remove((CitationCitedArtifactWebLocationComponent) value);
        } else if (name.equals("classification")) {
          this.getClassification().remove((CitationCitedArtifactClassificationComponent) value);
        } else if (name.equals("contributorship")) {
          this.contributorship = (CitationCitedArtifactContributorshipComponent) value; // CitationCitedArtifactContributorshipComponent
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1007604940:  return addRelatedIdentifier(); 
        case 540917457:  return getDateAccessedElement();
        case 351608024:  return getVersion();
        case 1457822360:  return addCurrentState(); 
        case 247524032:  return addStatusDate(); 
        case 110371416:  return addTitle(); 
        case 1732898850:  return addAbstract(); 
        case 3433459:  return getPart();
        case -7765931:  return addRelatesTo(); 
        case 1470639376:  return addPublicationForm(); 
        case -828032215:  return addWebLocation(); 
        case 382350310:  return addClassification(); 
        case 538727831:  return getContributorship();
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1007604940: /*relatedIdentifier*/ return new String[] {"Identifier"};
        case 540917457: /*dateAccessed*/ return new String[] {"dateTime"};
        case 351608024: /*version*/ return new String[] {};
        case 1457822360: /*currentState*/ return new String[] {"CodeableConcept"};
        case 247524032: /*statusDate*/ return new String[] {};
        case 110371416: /*title*/ return new String[] {};
        case 1732898850: /*abstract*/ return new String[] {};
        case 3433459: /*part*/ return new String[] {};
        case -7765931: /*relatesTo*/ return new String[] {};
        case 1470639376: /*publicationForm*/ return new String[] {};
        case -828032215: /*webLocation*/ return new String[] {};
        case 382350310: /*classification*/ return new String[] {};
        case 538727831: /*contributorship*/ return new String[] {};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("relatedIdentifier")) {
          return addRelatedIdentifier();
        }
        else if (name.equals("dateAccessed")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.dateAccessed");
        }
        else if (name.equals("version")) {
          this.version = new CitationCitedArtifactVersionComponent();
          return this.version;
        }
        else if (name.equals("currentState")) {
          return addCurrentState();
        }
        else if (name.equals("statusDate")) {
          return addStatusDate();
        }
        else if (name.equals("title")) {
          return addTitle();
        }
        else if (name.equals("abstract")) {
          return addAbstract();
        }
        else if (name.equals("part")) {
          this.part = new CitationCitedArtifactPartComponent();
          return this.part;
        }
        else if (name.equals("relatesTo")) {
          return addRelatesTo();
        }
        else if (name.equals("publicationForm")) {
          return addPublicationForm();
        }
        else if (name.equals("webLocation")) {
          return addWebLocation();
        }
        else if (name.equals("classification")) {
          return addClassification();
        }
        else if (name.equals("contributorship")) {
          this.contributorship = new CitationCitedArtifactContributorshipComponent();
          return this.contributorship;
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactComponent copy() {
        CitationCitedArtifactComponent dst = new CitationCitedArtifactComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactComponent dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (relatedIdentifier != null) {
          dst.relatedIdentifier = new ArrayList<Identifier>();
          for (Identifier i : relatedIdentifier)
            dst.relatedIdentifier.add(i.copy());
        };
        dst.dateAccessed = dateAccessed == null ? null : dateAccessed.copy();
        dst.version = version == null ? null : version.copy();
        if (currentState != null) {
          dst.currentState = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : currentState)
            dst.currentState.add(i.copy());
        };
        if (statusDate != null) {
          dst.statusDate = new ArrayList<CitationCitedArtifactStatusDateComponent>();
          for (CitationCitedArtifactStatusDateComponent i : statusDate)
            dst.statusDate.add(i.copy());
        };
        if (title != null) {
          dst.title = new ArrayList<CitationCitedArtifactTitleComponent>();
          for (CitationCitedArtifactTitleComponent i : title)
            dst.title.add(i.copy());
        };
        if (abstract_ != null) {
          dst.abstract_ = new ArrayList<CitationCitedArtifactAbstractComponent>();
          for (CitationCitedArtifactAbstractComponent i : abstract_)
            dst.abstract_.add(i.copy());
        };
        dst.part = part == null ? null : part.copy();
        if (relatesTo != null) {
          dst.relatesTo = new ArrayList<CitationCitedArtifactRelatesToComponent>();
          for (CitationCitedArtifactRelatesToComponent i : relatesTo)
            dst.relatesTo.add(i.copy());
        };
        if (publicationForm != null) {
          dst.publicationForm = new ArrayList<CitationCitedArtifactPublicationFormComponent>();
          for (CitationCitedArtifactPublicationFormComponent i : publicationForm)
            dst.publicationForm.add(i.copy());
        };
        if (webLocation != null) {
          dst.webLocation = new ArrayList<CitationCitedArtifactWebLocationComponent>();
          for (CitationCitedArtifactWebLocationComponent i : webLocation)
            dst.webLocation.add(i.copy());
        };
        if (classification != null) {
          dst.classification = new ArrayList<CitationCitedArtifactClassificationComponent>();
          for (CitationCitedArtifactClassificationComponent i : classification)
            dst.classification.add(i.copy());
        };
        dst.contributorship = contributorship == null ? null : contributorship.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactComponent))
          return false;
        CitationCitedArtifactComponent o = (CitationCitedArtifactComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(relatedIdentifier, o.relatedIdentifier, true)
           && compareDeep(dateAccessed, o.dateAccessed, true) && compareDeep(version, o.version, true) && compareDeep(currentState, o.currentState, true)
           && compareDeep(statusDate, o.statusDate, true) && compareDeep(title, o.title, true) && compareDeep(abstract_, o.abstract_, true)
           && compareDeep(part, o.part, true) && compareDeep(relatesTo, o.relatesTo, true) && compareDeep(publicationForm, o.publicationForm, true)
           && compareDeep(webLocation, o.webLocation, true) && compareDeep(classification, o.classification, true)
           && compareDeep(contributorship, o.contributorship, true) && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactComponent))
          return false;
        CitationCitedArtifactComponent o = (CitationCitedArtifactComponent) other_;
        return compareValues(dateAccessed, o.dateAccessed, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, relatedIdentifier
          , dateAccessed, version, currentState, statusDate, title, abstract_, part, relatesTo
          , publicationForm, webLocation, classification, contributorship, note);
      }

  public String fhirType() {
    return "Citation.citedArtifact";

  }

  }

    @Block()
    public static class CitationCitedArtifactVersionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The version number or other version identifier.
         */
        @Child(name = "value", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The version number or other version identifier", formalDefinition="The version number or other version identifier." )
        protected StringType value;

        /**
         * Citation for the main version of the cited artifact.
         */
        @Child(name = "baseCitation", type = {Citation.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Citation for the main version of the cited artifact", formalDefinition="Citation for the main version of the cited artifact." )
        protected Reference baseCitation;

        private static final long serialVersionUID = 1437090319L;

    /**
     * Constructor
     */
      public CitationCitedArtifactVersionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationCitedArtifactVersionComponent(String value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #value} (The version number or other version identifier.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactVersionComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new StringType(); // bb
          return this.value;
        }

        public boolean hasValueElement() { 
          return this.value != null && !this.value.isEmpty();
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The version number or other version identifier.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public CitationCitedArtifactVersionComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The version number or other version identifier.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The version number or other version identifier.
         */
        public CitationCitedArtifactVersionComponent setValue(String value) { 
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          return this;
        }

        /**
         * @return {@link #baseCitation} (Citation for the main version of the cited artifact.)
         */
        public Reference getBaseCitation() { 
          if (this.baseCitation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactVersionComponent.baseCitation");
            else if (Configuration.doAutoCreate())
              this.baseCitation = new Reference(); // cc
          return this.baseCitation;
        }

        public boolean hasBaseCitation() { 
          return this.baseCitation != null && !this.baseCitation.isEmpty();
        }

        /**
         * @param value {@link #baseCitation} (Citation for the main version of the cited artifact.)
         */
        public CitationCitedArtifactVersionComponent setBaseCitation(Reference value) { 
          this.baseCitation = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("value", "string", "The version number or other version identifier.", 0, 1, value));
          children.add(new Property("baseCitation", "Reference(Citation)", "Citation for the main version of the cited artifact.", 0, 1, baseCitation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 111972721: /*value*/  return new Property("value", "string", "The version number or other version identifier.", 0, 1, value);
          case 1182995672: /*baseCitation*/  return new Property("baseCitation", "Reference(Citation)", "Citation for the main version of the cited artifact.", 0, 1, baseCitation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case 1182995672: /*baseCitation*/ return this.baseCitation == null ? new Base[0] : new Base[] {this.baseCitation}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        case 1182995672: // baseCitation
          this.baseCitation = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("baseCitation")) {
          this.baseCitation = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("value")) {
          this.value = null;
        } else if (name.equals("baseCitation")) {
          this.baseCitation = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721:  return getValueElement();
        case 1182995672:  return getBaseCitation();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"string"};
        case 1182995672: /*baseCitation*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.version.value");
        }
        else if (name.equals("baseCitation")) {
          this.baseCitation = new Reference();
          return this.baseCitation;
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactVersionComponent copy() {
        CitationCitedArtifactVersionComponent dst = new CitationCitedArtifactVersionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactVersionComponent dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
        dst.baseCitation = baseCitation == null ? null : baseCitation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactVersionComponent))
          return false;
        CitationCitedArtifactVersionComponent o = (CitationCitedArtifactVersionComponent) other_;
        return compareDeep(value, o.value, true) && compareDeep(baseCitation, o.baseCitation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactVersionComponent))
          return false;
        CitationCitedArtifactVersionComponent o = (CitationCitedArtifactVersionComponent) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, baseCitation);
      }

  public String fhirType() {
    return "Citation.citedArtifact.version";

  }

  }

    @Block()
    public static class CitationCitedArtifactStatusDateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A definition of the status associated with a date or period.
         */
        @Child(name = "activity", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Classification of the status", formalDefinition="A definition of the status associated with a date or period." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/cited-artifact-status-type")
        protected CodeableConcept activity;

        /**
         * Either occurred or expected.
         */
        @Child(name = "actual", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Either occurred or expected", formalDefinition="Either occurred or expected." )
        protected BooleanType actual;

        /**
         * When the status started and/or ended.
         */
        @Child(name = "period", type = {Period.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the status started and/or ended", formalDefinition="When the status started and/or ended." )
        protected Period period;

        private static final long serialVersionUID = 1123586924L;

    /**
     * Constructor
     */
      public CitationCitedArtifactStatusDateComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationCitedArtifactStatusDateComponent(CodeableConcept activity, Period period) {
        super();
        this.setActivity(activity);
        this.setPeriod(period);
      }

        /**
         * @return {@link #activity} (A definition of the status associated with a date or period.)
         */
        public CodeableConcept getActivity() { 
          if (this.activity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactStatusDateComponent.activity");
            else if (Configuration.doAutoCreate())
              this.activity = new CodeableConcept(); // cc
          return this.activity;
        }

        public boolean hasActivity() { 
          return this.activity != null && !this.activity.isEmpty();
        }

        /**
         * @param value {@link #activity} (A definition of the status associated with a date or period.)
         */
        public CitationCitedArtifactStatusDateComponent setActivity(CodeableConcept value) { 
          this.activity = value;
          return this;
        }

        /**
         * @return {@link #actual} (Either occurred or expected.). This is the underlying object with id, value and extensions. The accessor "getActual" gives direct access to the value
         */
        public BooleanType getActualElement() { 
          if (this.actual == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactStatusDateComponent.actual");
            else if (Configuration.doAutoCreate())
              this.actual = new BooleanType(); // bb
          return this.actual;
        }

        public boolean hasActualElement() { 
          return this.actual != null && !this.actual.isEmpty();
        }

        public boolean hasActual() { 
          return this.actual != null && !this.actual.isEmpty();
        }

        /**
         * @param value {@link #actual} (Either occurred or expected.). This is the underlying object with id, value and extensions. The accessor "getActual" gives direct access to the value
         */
        public CitationCitedArtifactStatusDateComponent setActualElement(BooleanType value) { 
          this.actual = value;
          return this;
        }

        /**
         * @return Either occurred or expected.
         */
        public boolean getActual() { 
          return this.actual == null || this.actual.isEmpty() ? false : this.actual.getValue();
        }

        /**
         * @param value Either occurred or expected.
         */
        public CitationCitedArtifactStatusDateComponent setActual(boolean value) { 
            if (this.actual == null)
              this.actual = new BooleanType();
            this.actual.setValue(value);
          return this;
        }

        /**
         * @return {@link #period} (When the status started and/or ended.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactStatusDateComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (When the status started and/or ended.)
         */
        public CitationCitedArtifactStatusDateComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("activity", "CodeableConcept", "A definition of the status associated with a date or period.", 0, 1, activity));
          children.add(new Property("actual", "boolean", "Either occurred or expected.", 0, 1, actual));
          children.add(new Property("period", "Period", "When the status started and/or ended.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1655966961: /*activity*/  return new Property("activity", "CodeableConcept", "A definition of the status associated with a date or period.", 0, 1, activity);
          case -1422939762: /*actual*/  return new Property("actual", "boolean", "Either occurred or expected.", 0, 1, actual);
          case -991726143: /*period*/  return new Property("period", "Period", "When the status started and/or ended.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1655966961: /*activity*/ return this.activity == null ? new Base[0] : new Base[] {this.activity}; // CodeableConcept
        case -1422939762: /*actual*/ return this.actual == null ? new Base[0] : new Base[] {this.actual}; // BooleanType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1655966961: // activity
          this.activity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1422939762: // actual
          this.actual = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("activity")) {
          this.activity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actual")) {
          this.actual = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("activity")) {
          this.activity = null;
        } else if (name.equals("actual")) {
          this.actual = null;
        } else if (name.equals("period")) {
          this.period = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1655966961:  return getActivity();
        case -1422939762:  return getActualElement();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1655966961: /*activity*/ return new String[] {"CodeableConcept"};
        case -1422939762: /*actual*/ return new String[] {"boolean"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("activity")) {
          this.activity = new CodeableConcept();
          return this.activity;
        }
        else if (name.equals("actual")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.statusDate.actual");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactStatusDateComponent copy() {
        CitationCitedArtifactStatusDateComponent dst = new CitationCitedArtifactStatusDateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactStatusDateComponent dst) {
        super.copyValues(dst);
        dst.activity = activity == null ? null : activity.copy();
        dst.actual = actual == null ? null : actual.copy();
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactStatusDateComponent))
          return false;
        CitationCitedArtifactStatusDateComponent o = (CitationCitedArtifactStatusDateComponent) other_;
        return compareDeep(activity, o.activity, true) && compareDeep(actual, o.actual, true) && compareDeep(period, o.period, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactStatusDateComponent))
          return false;
        CitationCitedArtifactStatusDateComponent o = (CitationCitedArtifactStatusDateComponent) other_;
        return compareValues(actual, o.actual, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(activity, actual, period
          );
      }

  public String fhirType() {
    return "Citation.citedArtifact.statusDate";

  }

  }

    @Block()
    public static class CitationCitedArtifactTitleComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used to express the reason for or classification of the title.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The kind of title", formalDefinition="Used to express the reason for or classification of the title." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/title-type")
        protected List<CodeableConcept> type;

        /**
         * Used to express the specific language of the title.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to express the specific language", formalDefinition="Used to express the specific language of the title." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected CodeableConcept language;

        /**
         * The title of the article or artifact.
         */
        @Child(name = "text", type = {MarkdownType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The title of the article or artifact", formalDefinition="The title of the article or artifact." )
        protected MarkdownType text;

        private static final long serialVersionUID = 1526221998L;

    /**
     * Constructor
     */
      public CitationCitedArtifactTitleComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationCitedArtifactTitleComponent(String text) {
        super();
        this.setText(text);
      }

        /**
         * @return {@link #type} (Used to express the reason for or classification of the title.)
         */
        public List<CodeableConcept> getType() { 
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          return this.type;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactTitleComponent setType(List<CodeableConcept> theType) { 
          this.type = theType;
          return this;
        }

        public boolean hasType() { 
          if (this.type == null)
            return false;
          for (CodeableConcept item : this.type)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addType() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          this.type.add(t);
          return t;
        }

        public CitationCitedArtifactTitleComponent addType(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          this.type.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
         */
        public CodeableConcept getTypeFirstRep() { 
          if (getType().isEmpty()) {
            addType();
          }
          return getType().get(0);
        }

        /**
         * @return {@link #language} (Used to express the specific language of the title.)
         */
        public CodeableConcept getLanguage() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactTitleComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new CodeableConcept(); // cc
          return this.language;
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (Used to express the specific language of the title.)
         */
        public CitationCitedArtifactTitleComponent setLanguage(CodeableConcept value) { 
          this.language = value;
          return this;
        }

        /**
         * @return {@link #text} (The title of the article or artifact.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public MarkdownType getTextElement() { 
          if (this.text == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactTitleComponent.text");
            else if (Configuration.doAutoCreate())
              this.text = new MarkdownType(); // bb
          return this.text;
        }

        public boolean hasTextElement() { 
          return this.text != null && !this.text.isEmpty();
        }

        public boolean hasText() { 
          return this.text != null && !this.text.isEmpty();
        }

        /**
         * @param value {@link #text} (The title of the article or artifact.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public CitationCitedArtifactTitleComponent setTextElement(MarkdownType value) { 
          this.text = value;
          return this;
        }

        /**
         * @return The title of the article or artifact.
         */
        public String getText() { 
          return this.text == null ? null : this.text.getValue();
        }

        /**
         * @param value The title of the article or artifact.
         */
        public CitationCitedArtifactTitleComponent setText(String value) { 
            if (this.text == null)
              this.text = new MarkdownType();
            this.text.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Used to express the reason for or classification of the title.", 0, java.lang.Integer.MAX_VALUE, type));
          children.add(new Property("language", "CodeableConcept", "Used to express the specific language of the title.", 0, 1, language));
          children.add(new Property("text", "markdown", "The title of the article or artifact.", 0, 1, text));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Used to express the reason for or classification of the title.", 0, java.lang.Integer.MAX_VALUE, type);
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "Used to express the specific language of the title.", 0, 1, language);
          case 3556653: /*text*/  return new Property("text", "markdown", "The title of the article or artifact.", 0, 1, text);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CodeableConcept
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1613589672: // language
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3556653: // text
          this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("language")) {
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("text")) {
          this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.getType().remove(value);
        } else if (name.equals("language")) {
          this.language = null;
        } else if (name.equals("text")) {
          this.text = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return addType(); 
        case -1613589672:  return getLanguage();
        case 3556653:  return getTextElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1613589672: /*language*/ return new String[] {"CodeableConcept"};
        case 3556653: /*text*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("language")) {
          this.language = new CodeableConcept();
          return this.language;
        }
        else if (name.equals("text")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.title.text");
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactTitleComponent copy() {
        CitationCitedArtifactTitleComponent dst = new CitationCitedArtifactTitleComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactTitleComponent dst) {
        super.copyValues(dst);
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        dst.language = language == null ? null : language.copy();
        dst.text = text == null ? null : text.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactTitleComponent))
          return false;
        CitationCitedArtifactTitleComponent o = (CitationCitedArtifactTitleComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(language, o.language, true) && compareDeep(text, o.text, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactTitleComponent))
          return false;
        CitationCitedArtifactTitleComponent o = (CitationCitedArtifactTitleComponent) other_;
        return compareValues(text, o.text, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, language, text);
      }

  public String fhirType() {
    return "Citation.citedArtifact.title";

  }

  }

    @Block()
    public static class CitationCitedArtifactAbstractComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used to express the reason for or classification of the abstract.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The kind of abstract", formalDefinition="Used to express the reason for or classification of the abstract." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/cited-artifact-abstract-type")
        protected CodeableConcept type;

        /**
         * Used to express the specific language of the abstract.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to express the specific language", formalDefinition="Used to express the specific language of the abstract." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected CodeableConcept language;

        /**
         * Abstract content.
         */
        @Child(name = "text", type = {MarkdownType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Abstract content", formalDefinition="Abstract content." )
        protected MarkdownType text;

        /**
         * Copyright notice for the abstract.
         */
        @Child(name = "copyright", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Copyright notice for the abstract", formalDefinition="Copyright notice for the abstract." )
        protected MarkdownType copyright;

        private static final long serialVersionUID = -1882363442L;

    /**
     * Constructor
     */
      public CitationCitedArtifactAbstractComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationCitedArtifactAbstractComponent(String text) {
        super();
        this.setText(text);
      }

        /**
         * @return {@link #type} (Used to express the reason for or classification of the abstract.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactAbstractComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Used to express the reason for or classification of the abstract.)
         */
        public CitationCitedArtifactAbstractComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #language} (Used to express the specific language of the abstract.)
         */
        public CodeableConcept getLanguage() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactAbstractComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new CodeableConcept(); // cc
          return this.language;
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (Used to express the specific language of the abstract.)
         */
        public CitationCitedArtifactAbstractComponent setLanguage(CodeableConcept value) { 
          this.language = value;
          return this;
        }

        /**
         * @return {@link #text} (Abstract content.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public MarkdownType getTextElement() { 
          if (this.text == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactAbstractComponent.text");
            else if (Configuration.doAutoCreate())
              this.text = new MarkdownType(); // bb
          return this.text;
        }

        public boolean hasTextElement() { 
          return this.text != null && !this.text.isEmpty();
        }

        public boolean hasText() { 
          return this.text != null && !this.text.isEmpty();
        }

        /**
         * @param value {@link #text} (Abstract content.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public CitationCitedArtifactAbstractComponent setTextElement(MarkdownType value) { 
          this.text = value;
          return this;
        }

        /**
         * @return Abstract content.
         */
        public String getText() { 
          return this.text == null ? null : this.text.getValue();
        }

        /**
         * @param value Abstract content.
         */
        public CitationCitedArtifactAbstractComponent setText(String value) { 
            if (this.text == null)
              this.text = new MarkdownType();
            this.text.setValue(value);
          return this;
        }

        /**
         * @return {@link #copyright} (Copyright notice for the abstract.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
         */
        public MarkdownType getCopyrightElement() { 
          if (this.copyright == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactAbstractComponent.copyright");
            else if (Configuration.doAutoCreate())
              this.copyright = new MarkdownType(); // bb
          return this.copyright;
        }

        public boolean hasCopyrightElement() { 
          return this.copyright != null && !this.copyright.isEmpty();
        }

        public boolean hasCopyright() { 
          return this.copyright != null && !this.copyright.isEmpty();
        }

        /**
         * @param value {@link #copyright} (Copyright notice for the abstract.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
         */
        public CitationCitedArtifactAbstractComponent setCopyrightElement(MarkdownType value) { 
          this.copyright = value;
          return this;
        }

        /**
         * @return Copyright notice for the abstract.
         */
        public String getCopyright() { 
          return this.copyright == null ? null : this.copyright.getValue();
        }

        /**
         * @param value Copyright notice for the abstract.
         */
        public CitationCitedArtifactAbstractComponent setCopyright(String value) { 
          if (Utilities.noString(value))
            this.copyright = null;
          else {
            if (this.copyright == null)
              this.copyright = new MarkdownType();
            this.copyright.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Used to express the reason for or classification of the abstract.", 0, 1, type));
          children.add(new Property("language", "CodeableConcept", "Used to express the specific language of the abstract.", 0, 1, language));
          children.add(new Property("text", "markdown", "Abstract content.", 0, 1, text));
          children.add(new Property("copyright", "markdown", "Copyright notice for the abstract.", 0, 1, copyright));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Used to express the reason for or classification of the abstract.", 0, 1, type);
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "Used to express the specific language of the abstract.", 0, 1, language);
          case 3556653: /*text*/  return new Property("text", "markdown", "Abstract content.", 0, 1, text);
          case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "Copyright notice for the abstract.", 0, 1, copyright);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CodeableConcept
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1613589672: // language
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3556653: // text
          this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("language")) {
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("text")) {
          this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("language")) {
          this.language = null;
        } else if (name.equals("text")) {
          this.text = null;
        } else if (name.equals("copyright")) {
          this.copyright = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1613589672:  return getLanguage();
        case 3556653:  return getTextElement();
        case 1522889671:  return getCopyrightElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1613589672: /*language*/ return new String[] {"CodeableConcept"};
        case 3556653: /*text*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("language")) {
          this.language = new CodeableConcept();
          return this.language;
        }
        else if (name.equals("text")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.abstract.text");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.abstract.copyright");
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactAbstractComponent copy() {
        CitationCitedArtifactAbstractComponent dst = new CitationCitedArtifactAbstractComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactAbstractComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.language = language == null ? null : language.copy();
        dst.text = text == null ? null : text.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactAbstractComponent))
          return false;
        CitationCitedArtifactAbstractComponent o = (CitationCitedArtifactAbstractComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(language, o.language, true) && compareDeep(text, o.text, true)
           && compareDeep(copyright, o.copyright, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactAbstractComponent))
          return false;
        CitationCitedArtifactAbstractComponent o = (CitationCitedArtifactAbstractComponent) other_;
        return compareValues(text, o.text, true) && compareValues(copyright, o.copyright, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, language, text, copyright
          );
      }

  public String fhirType() {
    return "Citation.citedArtifact.abstract";

  }

  }

    @Block()
    public static class CitationCitedArtifactPartComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The kind of component.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The kind of component", formalDefinition="The kind of component." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/cited-artifact-part-type")
        protected CodeableConcept type;

        /**
         * The specification of the component.
         */
        @Child(name = "value", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The specification of the component", formalDefinition="The specification of the component." )
        protected StringType value;

        /**
         * The citation for the full article or artifact.
         */
        @Child(name = "baseCitation", type = {Citation.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The citation for the full article or artifact", formalDefinition="The citation for the full article or artifact." )
        protected Reference baseCitation;

        private static final long serialVersionUID = -765350500L;

    /**
     * Constructor
     */
      public CitationCitedArtifactPartComponent() {
        super();
      }

        /**
         * @return {@link #type} (The kind of component.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPartComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The kind of component.)
         */
        public CitationCitedArtifactPartComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (The specification of the component.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPartComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new StringType(); // bb
          return this.value;
        }

        public boolean hasValueElement() { 
          return this.value != null && !this.value.isEmpty();
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The specification of the component.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public CitationCitedArtifactPartComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The specification of the component.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The specification of the component.
         */
        public CitationCitedArtifactPartComponent setValue(String value) { 
          if (Utilities.noString(value))
            this.value = null;
          else {
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #baseCitation} (The citation for the full article or artifact.)
         */
        public Reference getBaseCitation() { 
          if (this.baseCitation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPartComponent.baseCitation");
            else if (Configuration.doAutoCreate())
              this.baseCitation = new Reference(); // cc
          return this.baseCitation;
        }

        public boolean hasBaseCitation() { 
          return this.baseCitation != null && !this.baseCitation.isEmpty();
        }

        /**
         * @param value {@link #baseCitation} (The citation for the full article or artifact.)
         */
        public CitationCitedArtifactPartComponent setBaseCitation(Reference value) { 
          this.baseCitation = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The kind of component.", 0, 1, type));
          children.add(new Property("value", "string", "The specification of the component.", 0, 1, value));
          children.add(new Property("baseCitation", "Reference(Citation)", "The citation for the full article or artifact.", 0, 1, baseCitation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The kind of component.", 0, 1, type);
          case 111972721: /*value*/  return new Property("value", "string", "The specification of the component.", 0, 1, value);
          case 1182995672: /*baseCitation*/  return new Property("baseCitation", "Reference(Citation)", "The citation for the full article or artifact.", 0, 1, baseCitation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case 1182995672: /*baseCitation*/ return this.baseCitation == null ? new Base[0] : new Base[] {this.baseCitation}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        case 1182995672: // baseCitation
          this.baseCitation = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("baseCitation")) {
          this.baseCitation = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("value")) {
          this.value = null;
        } else if (name.equals("baseCitation")) {
          this.baseCitation = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 111972721:  return getValueElement();
        case 1182995672:  return getBaseCitation();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"string"};
        case 1182995672: /*baseCitation*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.part.value");
        }
        else if (name.equals("baseCitation")) {
          this.baseCitation = new Reference();
          return this.baseCitation;
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactPartComponent copy() {
        CitationCitedArtifactPartComponent dst = new CitationCitedArtifactPartComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactPartComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
        dst.baseCitation = baseCitation == null ? null : baseCitation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactPartComponent))
          return false;
        CitationCitedArtifactPartComponent o = (CitationCitedArtifactPartComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true) && compareDeep(baseCitation, o.baseCitation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactPartComponent))
          return false;
        CitationCitedArtifactPartComponent o = (CitationCitedArtifactPartComponent) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value, baseCitation
          );
      }

  public String fhirType() {
    return "Citation.citedArtifact.part";

  }

  }

    @Block()
    public static class CitationCitedArtifactRelatesToComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of relationship to the related artifact.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="documentation | justification | citation | predecessor | successor | derived-from | depends-on | composed-of | part-of | amends | amended-with | appends | appended-with | cites | cited-by | comments-on | comment-in | contains | contained-in | corrects | correction-in | replaces | replaced-with | retracts | retracted-by | signs | similar-to | supports | supported-with | transforms | transformed-into | transformed-with | documents | specification-of | created-with | cite-as | reprint | reprint-of", formalDefinition="The type of relationship to the related artifact." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/related-artifact-type-all")
        protected Enumeration<RelatedArtifactTypeExpanded> type;

        /**
         * Provides additional classifiers of the related artifact.
         */
        @Child(name = "classifier", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Additional classifiers", formalDefinition="Provides additional classifiers of the related artifact." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-artifact-classifier")
        protected List<CodeableConcept> classifier;

        /**
         * A short label that can be used to reference the related artifact from elsewhere in the containing artifact, such as a footnote index.
         */
        @Child(name = "label", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Short label", formalDefinition="A short label that can be used to reference the related artifact from elsewhere in the containing artifact, such as a footnote index." )
        protected StringType label;

        /**
         * A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.
         */
        @Child(name = "display", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Brief description of the related artifact", formalDefinition="A brief description of the document or knowledge resource being referenced, suitable for display to a consumer." )
        protected StringType display;

        /**
         * A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.
         */
        @Child(name = "citation", type = {MarkdownType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Bibliographic citation for the artifact", formalDefinition="A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format." )
        protected MarkdownType citation;

        /**
         * The document being referenced, represented as an attachment. Do not use this element if using the resource element to provide the canonical to the related artifact.
         */
        @Child(name = "document", type = {Attachment.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What document is being referenced", formalDefinition="The document being referenced, represented as an attachment. Do not use this element if using the resource element to provide the canonical to the related artifact." )
        protected Attachment document;

        /**
         * The related artifact, such as a library, value set, profile, or other knowledge resource.
         */
        @Child(name = "resource", type = {CanonicalType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What artifact is being referenced", formalDefinition="The related artifact, such as a library, value set, profile, or other knowledge resource." )
        protected CanonicalType resource;

        /**
         * The related artifact, if the artifact is not a canonical resource, or a resource reference to a canonical resource.
         */
        @Child(name = "resourceReference", type = {Reference.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What artifact, if not a conformance resource", formalDefinition="The related artifact, if the artifact is not a canonical resource, or a resource reference to a canonical resource." )
        protected Reference resourceReference;

        private static final long serialVersionUID = 1537406923L;

    /**
     * Constructor
     */
      public CitationCitedArtifactRelatesToComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationCitedArtifactRelatesToComponent(RelatedArtifactTypeExpanded type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (The type of relationship to the related artifact.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<RelatedArtifactTypeExpanded> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactRelatesToComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<RelatedArtifactTypeExpanded>(new RelatedArtifactTypeExpandedEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of relationship to the related artifact.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public CitationCitedArtifactRelatesToComponent setTypeElement(Enumeration<RelatedArtifactTypeExpanded> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of relationship to the related artifact.
         */
        public RelatedArtifactTypeExpanded getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of relationship to the related artifact.
         */
        public CitationCitedArtifactRelatesToComponent setType(RelatedArtifactTypeExpanded value) { 
            if (this.type == null)
              this.type = new Enumeration<RelatedArtifactTypeExpanded>(new RelatedArtifactTypeExpandedEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #classifier} (Provides additional classifiers of the related artifact.)
         */
        public List<CodeableConcept> getClassifier() { 
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          return this.classifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactRelatesToComponent setClassifier(List<CodeableConcept> theClassifier) { 
          this.classifier = theClassifier;
          return this;
        }

        public boolean hasClassifier() { 
          if (this.classifier == null)
            return false;
          for (CodeableConcept item : this.classifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addClassifier() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return t;
        }

        public CitationCitedArtifactRelatesToComponent addClassifier(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #classifier}, creating it if it does not already exist {3}
         */
        public CodeableConcept getClassifierFirstRep() { 
          if (getClassifier().isEmpty()) {
            addClassifier();
          }
          return getClassifier().get(0);
        }

        /**
         * @return {@link #label} (A short label that can be used to reference the related artifact from elsewhere in the containing artifact, such as a footnote index.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public StringType getLabelElement() { 
          if (this.label == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactRelatesToComponent.label");
            else if (Configuration.doAutoCreate())
              this.label = new StringType(); // bb
          return this.label;
        }

        public boolean hasLabelElement() { 
          return this.label != null && !this.label.isEmpty();
        }

        public boolean hasLabel() { 
          return this.label != null && !this.label.isEmpty();
        }

        /**
         * @param value {@link #label} (A short label that can be used to reference the related artifact from elsewhere in the containing artifact, such as a footnote index.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public CitationCitedArtifactRelatesToComponent setLabelElement(StringType value) { 
          this.label = value;
          return this;
        }

        /**
         * @return A short label that can be used to reference the related artifact from elsewhere in the containing artifact, such as a footnote index.
         */
        public String getLabel() { 
          return this.label == null ? null : this.label.getValue();
        }

        /**
         * @param value A short label that can be used to reference the related artifact from elsewhere in the containing artifact, such as a footnote index.
         */
        public CitationCitedArtifactRelatesToComponent setLabel(String value) { 
          if (Utilities.noString(value))
            this.label = null;
          else {
            if (this.label == null)
              this.label = new StringType();
            this.label.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #display} (A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
         */
        public StringType getDisplayElement() { 
          if (this.display == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactRelatesToComponent.display");
            else if (Configuration.doAutoCreate())
              this.display = new StringType(); // bb
          return this.display;
        }

        public boolean hasDisplayElement() { 
          return this.display != null && !this.display.isEmpty();
        }

        public boolean hasDisplay() { 
          return this.display != null && !this.display.isEmpty();
        }

        /**
         * @param value {@link #display} (A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
         */
        public CitationCitedArtifactRelatesToComponent setDisplayElement(StringType value) { 
          this.display = value;
          return this;
        }

        /**
         * @return A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.
         */
        public String getDisplay() { 
          return this.display == null ? null : this.display.getValue();
        }

        /**
         * @param value A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.
         */
        public CitationCitedArtifactRelatesToComponent setDisplay(String value) { 
          if (Utilities.noString(value))
            this.display = null;
          else {
            if (this.display == null)
              this.display = new StringType();
            this.display.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #citation} (A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.). This is the underlying object with id, value and extensions. The accessor "getCitation" gives direct access to the value
         */
        public MarkdownType getCitationElement() { 
          if (this.citation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactRelatesToComponent.citation");
            else if (Configuration.doAutoCreate())
              this.citation = new MarkdownType(); // bb
          return this.citation;
        }

        public boolean hasCitationElement() { 
          return this.citation != null && !this.citation.isEmpty();
        }

        public boolean hasCitation() { 
          return this.citation != null && !this.citation.isEmpty();
        }

        /**
         * @param value {@link #citation} (A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.). This is the underlying object with id, value and extensions. The accessor "getCitation" gives direct access to the value
         */
        public CitationCitedArtifactRelatesToComponent setCitationElement(MarkdownType value) { 
          this.citation = value;
          return this;
        }

        /**
         * @return A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.
         */
        public String getCitation() { 
          return this.citation == null ? null : this.citation.getValue();
        }

        /**
         * @param value A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.
         */
        public CitationCitedArtifactRelatesToComponent setCitation(String value) { 
          if (Utilities.noString(value))
            this.citation = null;
          else {
            if (this.citation == null)
              this.citation = new MarkdownType();
            this.citation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #document} (The document being referenced, represented as an attachment. Do not use this element if using the resource element to provide the canonical to the related artifact.)
         */
        public Attachment getDocument() { 
          if (this.document == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactRelatesToComponent.document");
            else if (Configuration.doAutoCreate())
              this.document = new Attachment(); // cc
          return this.document;
        }

        public boolean hasDocument() { 
          return this.document != null && !this.document.isEmpty();
        }

        /**
         * @param value {@link #document} (The document being referenced, represented as an attachment. Do not use this element if using the resource element to provide the canonical to the related artifact.)
         */
        public CitationCitedArtifactRelatesToComponent setDocument(Attachment value) { 
          this.document = value;
          return this;
        }

        /**
         * @return {@link #resource} (The related artifact, such as a library, value set, profile, or other knowledge resource.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public CanonicalType getResourceElement() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactRelatesToComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new CanonicalType(); // bb
          return this.resource;
        }

        public boolean hasResourceElement() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (The related artifact, such as a library, value set, profile, or other knowledge resource.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public CitationCitedArtifactRelatesToComponent setResourceElement(CanonicalType value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return The related artifact, such as a library, value set, profile, or other knowledge resource.
         */
        public String getResource() { 
          return this.resource == null ? null : this.resource.getValue();
        }

        /**
         * @param value The related artifact, such as a library, value set, profile, or other knowledge resource.
         */
        public CitationCitedArtifactRelatesToComponent setResource(String value) { 
          if (Utilities.noString(value))
            this.resource = null;
          else {
            if (this.resource == null)
              this.resource = new CanonicalType();
            this.resource.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #resourceReference} (The related artifact, if the artifact is not a canonical resource, or a resource reference to a canonical resource.)
         */
        public Reference getResourceReference() { 
          if (this.resourceReference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactRelatesToComponent.resourceReference");
            else if (Configuration.doAutoCreate())
              this.resourceReference = new Reference(); // cc
          return this.resourceReference;
        }

        public boolean hasResourceReference() { 
          return this.resourceReference != null && !this.resourceReference.isEmpty();
        }

        /**
         * @param value {@link #resourceReference} (The related artifact, if the artifact is not a canonical resource, or a resource reference to a canonical resource.)
         */
        public CitationCitedArtifactRelatesToComponent setResourceReference(Reference value) { 
          this.resourceReference = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "The type of relationship to the related artifact.", 0, 1, type));
          children.add(new Property("classifier", "CodeableConcept", "Provides additional classifiers of the related artifact.", 0, java.lang.Integer.MAX_VALUE, classifier));
          children.add(new Property("label", "string", "A short label that can be used to reference the related artifact from elsewhere in the containing artifact, such as a footnote index.", 0, 1, label));
          children.add(new Property("display", "string", "A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.", 0, 1, display));
          children.add(new Property("citation", "markdown", "A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.", 0, 1, citation));
          children.add(new Property("document", "Attachment", "The document being referenced, represented as an attachment. Do not use this element if using the resource element to provide the canonical to the related artifact.", 0, 1, document));
          children.add(new Property("resource", "canonical", "The related artifact, such as a library, value set, profile, or other knowledge resource.", 0, 1, resource));
          children.add(new Property("resourceReference", "Reference", "The related artifact, if the artifact is not a canonical resource, or a resource reference to a canonical resource.", 0, 1, resourceReference));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "The type of relationship to the related artifact.", 0, 1, type);
          case -281470431: /*classifier*/  return new Property("classifier", "CodeableConcept", "Provides additional classifiers of the related artifact.", 0, java.lang.Integer.MAX_VALUE, classifier);
          case 102727412: /*label*/  return new Property("label", "string", "A short label that can be used to reference the related artifact from elsewhere in the containing artifact, such as a footnote index.", 0, 1, label);
          case 1671764162: /*display*/  return new Property("display", "string", "A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.", 0, 1, display);
          case -1442706713: /*citation*/  return new Property("citation", "markdown", "A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.", 0, 1, citation);
          case 861720859: /*document*/  return new Property("document", "Attachment", "The document being referenced, represented as an attachment. Do not use this element if using the resource element to provide the canonical to the related artifact.", 0, 1, document);
          case -341064690: /*resource*/  return new Property("resource", "canonical", "The related artifact, such as a library, value set, profile, or other knowledge resource.", 0, 1, resource);
          case -610120995: /*resourceReference*/  return new Property("resourceReference", "Reference", "The related artifact, if the artifact is not a canonical resource, or a resource reference to a canonical resource.", 0, 1, resourceReference);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<RelatedArtifactTypeExpanded>
        case -281470431: /*classifier*/ return this.classifier == null ? new Base[0] : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case 1671764162: /*display*/ return this.display == null ? new Base[0] : new Base[] {this.display}; // StringType
        case -1442706713: /*citation*/ return this.citation == null ? new Base[0] : new Base[] {this.citation}; // MarkdownType
        case 861720859: /*document*/ return this.document == null ? new Base[0] : new Base[] {this.document}; // Attachment
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // CanonicalType
        case -610120995: /*resourceReference*/ return this.resourceReference == null ? new Base[0] : new Base[] {this.resourceReference}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new RelatedArtifactTypeExpandedEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<RelatedArtifactTypeExpanded>
          return value;
        case -281470431: // classifier
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 102727412: // label
          this.label = TypeConvertor.castToString(value); // StringType
          return value;
        case 1671764162: // display
          this.display = TypeConvertor.castToString(value); // StringType
          return value;
        case -1442706713: // citation
          this.citation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 861720859: // document
          this.document = TypeConvertor.castToAttachment(value); // Attachment
          return value;
        case -341064690: // resource
          this.resource = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -610120995: // resourceReference
          this.resourceReference = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new RelatedArtifactTypeExpandedEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<RelatedArtifactTypeExpanded>
        } else if (name.equals("classifier")) {
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("label")) {
          this.label = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("display")) {
          this.display = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("citation")) {
          this.citation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("document")) {
          this.document = TypeConvertor.castToAttachment(value); // Attachment
        } else if (name.equals("resource")) {
          this.resource = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("resourceReference")) {
          this.resourceReference = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new RelatedArtifactTypeExpandedEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<RelatedArtifactTypeExpanded>
        } else if (name.equals("classifier")) {
          this.getClassifier().remove(value);
        } else if (name.equals("label")) {
          this.label = null;
        } else if (name.equals("display")) {
          this.display = null;
        } else if (name.equals("citation")) {
          this.citation = null;
        } else if (name.equals("document")) {
          this.document = null;
        } else if (name.equals("resource")) {
          this.resource = null;
        } else if (name.equals("resourceReference")) {
          this.resourceReference = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case -281470431:  return addClassifier(); 
        case 102727412:  return getLabelElement();
        case 1671764162:  return getDisplayElement();
        case -1442706713:  return getCitationElement();
        case 861720859:  return getDocument();
        case -341064690:  return getResourceElement();
        case -610120995:  return getResourceReference();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case -281470431: /*classifier*/ return new String[] {"CodeableConcept"};
        case 102727412: /*label*/ return new String[] {"string"};
        case 1671764162: /*display*/ return new String[] {"string"};
        case -1442706713: /*citation*/ return new String[] {"markdown"};
        case 861720859: /*document*/ return new String[] {"Attachment"};
        case -341064690: /*resource*/ return new String[] {"canonical"};
        case -610120995: /*resourceReference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.relatesTo.type");
        }
        else if (name.equals("classifier")) {
          return addClassifier();
        }
        else if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.relatesTo.label");
        }
        else if (name.equals("display")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.relatesTo.display");
        }
        else if (name.equals("citation")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.relatesTo.citation");
        }
        else if (name.equals("document")) {
          this.document = new Attachment();
          return this.document;
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.relatesTo.resource");
        }
        else if (name.equals("resourceReference")) {
          this.resourceReference = new Reference();
          return this.resourceReference;
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactRelatesToComponent copy() {
        CitationCitedArtifactRelatesToComponent dst = new CitationCitedArtifactRelatesToComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactRelatesToComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (classifier != null) {
          dst.classifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : classifier)
            dst.classifier.add(i.copy());
        };
        dst.label = label == null ? null : label.copy();
        dst.display = display == null ? null : display.copy();
        dst.citation = citation == null ? null : citation.copy();
        dst.document = document == null ? null : document.copy();
        dst.resource = resource == null ? null : resource.copy();
        dst.resourceReference = resourceReference == null ? null : resourceReference.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactRelatesToComponent))
          return false;
        CitationCitedArtifactRelatesToComponent o = (CitationCitedArtifactRelatesToComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(classifier, o.classifier, true) && compareDeep(label, o.label, true)
           && compareDeep(display, o.display, true) && compareDeep(citation, o.citation, true) && compareDeep(document, o.document, true)
           && compareDeep(resource, o.resource, true) && compareDeep(resourceReference, o.resourceReference, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactRelatesToComponent))
          return false;
        CitationCitedArtifactRelatesToComponent o = (CitationCitedArtifactRelatesToComponent) other_;
        return compareValues(type, o.type, true) && compareValues(label, o.label, true) && compareValues(display, o.display, true)
           && compareValues(citation, o.citation, true) && compareValues(resource, o.resource, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, classifier, label
          , display, citation, document, resource, resourceReference);
      }

  public String fhirType() {
    return "Citation.citedArtifact.relatesTo";

  }

  }

    @Block()
    public static class CitationCitedArtifactPublicationFormComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The collection the cited article or artifact is published in.
         */
        @Child(name = "publishedIn", type = {}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The collection the cited article or artifact is published in", formalDefinition="The collection the cited article or artifact is published in." )
        protected CitationCitedArtifactPublicationFormPublishedInComponent publishedIn;

        /**
         * Describes the form of the medium cited. Common codes are "Internet" or "Print". The CitedMedium value set has 6 codes. The codes internet, print, and offline-digital-storage are the common codes for a typical publication form, though internet and print are more common for study citations. Three additional codes (each appending one of the primary codes with "-without-issue" are used for situations when a study is published both within an issue (of a periodical release as commonly done for journals) AND is published separately from the issue (as commonly done with early online publication), to represent specific identification of the publication form not associated with the issue.
         */
        @Child(name = "citedMedium", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Internet or Print", formalDefinition="Describes the form of the medium cited. Common codes are \"Internet\" or \"Print\". The CitedMedium value set has 6 codes. The codes internet, print, and offline-digital-storage are the common codes for a typical publication form, though internet and print are more common for study citations. Three additional codes (each appending one of the primary codes with \"-without-issue\" are used for situations when a study is published both within an issue (of a periodical release as commonly done for journals) AND is published separately from the issue (as commonly done with early online publication), to represent specific identification of the publication form not associated with the issue." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/cited-medium")
        protected CodeableConcept citedMedium;

        /**
         * Volume number of journal or other collection in which the article is published.
         */
        @Child(name = "volume", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Volume number of journal or other collection in which the article is published", formalDefinition="Volume number of journal or other collection in which the article is published." )
        protected StringType volume;

        /**
         * Issue, part or supplement of journal or other collection in which the article is published.
         */
        @Child(name = "issue", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Issue, part or supplement of journal or other collection in which the article is published", formalDefinition="Issue, part or supplement of journal or other collection in which the article is published." )
        protected StringType issue;

        /**
         * The date the article was added to the database, or the date the article was released.
         */
        @Child(name = "articleDate", type = {DateTimeType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The date the article was added to the database, or the date the article was released", formalDefinition="The date the article was added to the database, or the date the article was released." )
        protected DateTimeType articleDate;

        /**
         * Text representation of the date on which the issue of the cited artifact was published.
         */
        @Child(name = "publicationDateText", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Text representation of the date on which the issue of the cited artifact was published", formalDefinition="Text representation of the date on which the issue of the cited artifact was published." )
        protected StringType publicationDateText;

        /**
         * Spring, Summer, Fall/Autumn, Winter.
         */
        @Child(name = "publicationDateSeason", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Season in which the cited artifact was published", formalDefinition="Spring, Summer, Fall/Autumn, Winter." )
        protected StringType publicationDateSeason;

        /**
         * The date the article was last revised or updated in the database.
         */
        @Child(name = "lastRevisionDate", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The date the article was last revised or updated in the database", formalDefinition="The date the article was last revised or updated in the database." )
        protected DateTimeType lastRevisionDate;

        /**
         * The language or languages in which this form of the article is published.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Language(s) in which this form of the article is published", formalDefinition="The language or languages in which this form of the article is published." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected List<CodeableConcept> language;

        /**
         * Entry number or identifier for inclusion in a database.
         */
        @Child(name = "accessionNumber", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Entry number or identifier for inclusion in a database", formalDefinition="Entry number or identifier for inclusion in a database." )
        protected StringType accessionNumber;

        /**
         * Used for full display of pagination.
         */
        @Child(name = "pageString", type = {StringType.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for full display of pagination", formalDefinition="Used for full display of pagination." )
        protected StringType pageString;

        /**
         * Used for isolated representation of first page.
         */
        @Child(name = "firstPage", type = {StringType.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for isolated representation of first page", formalDefinition="Used for isolated representation of first page." )
        protected StringType firstPage;

        /**
         * Used for isolated representation of last page.
         */
        @Child(name = "lastPage", type = {StringType.class}, order=13, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for isolated representation of last page", formalDefinition="Used for isolated representation of last page." )
        protected StringType lastPage;

        /**
         * Actual or approximate number of pages or screens. Distinct from reporting the page numbers.
         */
        @Child(name = "pageCount", type = {StringType.class}, order=14, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Number of pages or screens", formalDefinition="Actual or approximate number of pages or screens. Distinct from reporting the page numbers." )
        protected StringType pageCount;

        /**
         * Copyright notice for the full article or artifact.
         */
        @Child(name = "copyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Copyright notice for the full article or artifact", formalDefinition="Copyright notice for the full article or artifact." )
        protected MarkdownType copyright;

        private static final long serialVersionUID = 1791622597L;

    /**
     * Constructor
     */
      public CitationCitedArtifactPublicationFormComponent() {
        super();
      }

        /**
         * @return {@link #publishedIn} (The collection the cited article or artifact is published in.)
         */
        public CitationCitedArtifactPublicationFormPublishedInComponent getPublishedIn() { 
          if (this.publishedIn == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.publishedIn");
            else if (Configuration.doAutoCreate())
              this.publishedIn = new CitationCitedArtifactPublicationFormPublishedInComponent(); // cc
          return this.publishedIn;
        }

        public boolean hasPublishedIn() { 
          return this.publishedIn != null && !this.publishedIn.isEmpty();
        }

        /**
         * @param value {@link #publishedIn} (The collection the cited article or artifact is published in.)
         */
        public CitationCitedArtifactPublicationFormComponent setPublishedIn(CitationCitedArtifactPublicationFormPublishedInComponent value) { 
          this.publishedIn = value;
          return this;
        }

        /**
         * @return {@link #citedMedium} (Describes the form of the medium cited. Common codes are "Internet" or "Print". The CitedMedium value set has 6 codes. The codes internet, print, and offline-digital-storage are the common codes for a typical publication form, though internet and print are more common for study citations. Three additional codes (each appending one of the primary codes with "-without-issue" are used for situations when a study is published both within an issue (of a periodical release as commonly done for journals) AND is published separately from the issue (as commonly done with early online publication), to represent specific identification of the publication form not associated with the issue.)
         */
        public CodeableConcept getCitedMedium() { 
          if (this.citedMedium == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.citedMedium");
            else if (Configuration.doAutoCreate())
              this.citedMedium = new CodeableConcept(); // cc
          return this.citedMedium;
        }

        public boolean hasCitedMedium() { 
          return this.citedMedium != null && !this.citedMedium.isEmpty();
        }

        /**
         * @param value {@link #citedMedium} (Describes the form of the medium cited. Common codes are "Internet" or "Print". The CitedMedium value set has 6 codes. The codes internet, print, and offline-digital-storage are the common codes for a typical publication form, though internet and print are more common for study citations. Three additional codes (each appending one of the primary codes with "-without-issue" are used for situations when a study is published both within an issue (of a periodical release as commonly done for journals) AND is published separately from the issue (as commonly done with early online publication), to represent specific identification of the publication form not associated with the issue.)
         */
        public CitationCitedArtifactPublicationFormComponent setCitedMedium(CodeableConcept value) { 
          this.citedMedium = value;
          return this;
        }

        /**
         * @return {@link #volume} (Volume number of journal or other collection in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getVolume" gives direct access to the value
         */
        public StringType getVolumeElement() { 
          if (this.volume == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.volume");
            else if (Configuration.doAutoCreate())
              this.volume = new StringType(); // bb
          return this.volume;
        }

        public boolean hasVolumeElement() { 
          return this.volume != null && !this.volume.isEmpty();
        }

        public boolean hasVolume() { 
          return this.volume != null && !this.volume.isEmpty();
        }

        /**
         * @param value {@link #volume} (Volume number of journal or other collection in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getVolume" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setVolumeElement(StringType value) { 
          this.volume = value;
          return this;
        }

        /**
         * @return Volume number of journal or other collection in which the article is published.
         */
        public String getVolume() { 
          return this.volume == null ? null : this.volume.getValue();
        }

        /**
         * @param value Volume number of journal or other collection in which the article is published.
         */
        public CitationCitedArtifactPublicationFormComponent setVolume(String value) { 
          if (Utilities.noString(value))
            this.volume = null;
          else {
            if (this.volume == null)
              this.volume = new StringType();
            this.volume.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #issue} (Issue, part or supplement of journal or other collection in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getIssue" gives direct access to the value
         */
        public StringType getIssueElement() { 
          if (this.issue == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.issue");
            else if (Configuration.doAutoCreate())
              this.issue = new StringType(); // bb
          return this.issue;
        }

        public boolean hasIssueElement() { 
          return this.issue != null && !this.issue.isEmpty();
        }

        public boolean hasIssue() { 
          return this.issue != null && !this.issue.isEmpty();
        }

        /**
         * @param value {@link #issue} (Issue, part or supplement of journal or other collection in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getIssue" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setIssueElement(StringType value) { 
          this.issue = value;
          return this;
        }

        /**
         * @return Issue, part or supplement of journal or other collection in which the article is published.
         */
        public String getIssue() { 
          return this.issue == null ? null : this.issue.getValue();
        }

        /**
         * @param value Issue, part or supplement of journal or other collection in which the article is published.
         */
        public CitationCitedArtifactPublicationFormComponent setIssue(String value) { 
          if (Utilities.noString(value))
            this.issue = null;
          else {
            if (this.issue == null)
              this.issue = new StringType();
            this.issue.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #articleDate} (The date the article was added to the database, or the date the article was released.). This is the underlying object with id, value and extensions. The accessor "getArticleDate" gives direct access to the value
         */
        public DateTimeType getArticleDateElement() { 
          if (this.articleDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.articleDate");
            else if (Configuration.doAutoCreate())
              this.articleDate = new DateTimeType(); // bb
          return this.articleDate;
        }

        public boolean hasArticleDateElement() { 
          return this.articleDate != null && !this.articleDate.isEmpty();
        }

        public boolean hasArticleDate() { 
          return this.articleDate != null && !this.articleDate.isEmpty();
        }

        /**
         * @param value {@link #articleDate} (The date the article was added to the database, or the date the article was released.). This is the underlying object with id, value and extensions. The accessor "getArticleDate" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setArticleDateElement(DateTimeType value) { 
          this.articleDate = value;
          return this;
        }

        /**
         * @return The date the article was added to the database, or the date the article was released.
         */
        public Date getArticleDate() { 
          return this.articleDate == null ? null : this.articleDate.getValue();
        }

        /**
         * @param value The date the article was added to the database, or the date the article was released.
         */
        public CitationCitedArtifactPublicationFormComponent setArticleDate(Date value) { 
          if (value == null)
            this.articleDate = null;
          else {
            if (this.articleDate == null)
              this.articleDate = new DateTimeType();
            this.articleDate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #publicationDateText} (Text representation of the date on which the issue of the cited artifact was published.). This is the underlying object with id, value and extensions. The accessor "getPublicationDateText" gives direct access to the value
         */
        public StringType getPublicationDateTextElement() { 
          if (this.publicationDateText == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.publicationDateText");
            else if (Configuration.doAutoCreate())
              this.publicationDateText = new StringType(); // bb
          return this.publicationDateText;
        }

        public boolean hasPublicationDateTextElement() { 
          return this.publicationDateText != null && !this.publicationDateText.isEmpty();
        }

        public boolean hasPublicationDateText() { 
          return this.publicationDateText != null && !this.publicationDateText.isEmpty();
        }

        /**
         * @param value {@link #publicationDateText} (Text representation of the date on which the issue of the cited artifact was published.). This is the underlying object with id, value and extensions. The accessor "getPublicationDateText" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setPublicationDateTextElement(StringType value) { 
          this.publicationDateText = value;
          return this;
        }

        /**
         * @return Text representation of the date on which the issue of the cited artifact was published.
         */
        public String getPublicationDateText() { 
          return this.publicationDateText == null ? null : this.publicationDateText.getValue();
        }

        /**
         * @param value Text representation of the date on which the issue of the cited artifact was published.
         */
        public CitationCitedArtifactPublicationFormComponent setPublicationDateText(String value) { 
          if (Utilities.noString(value))
            this.publicationDateText = null;
          else {
            if (this.publicationDateText == null)
              this.publicationDateText = new StringType();
            this.publicationDateText.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #publicationDateSeason} (Spring, Summer, Fall/Autumn, Winter.). This is the underlying object with id, value and extensions. The accessor "getPublicationDateSeason" gives direct access to the value
         */
        public StringType getPublicationDateSeasonElement() { 
          if (this.publicationDateSeason == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.publicationDateSeason");
            else if (Configuration.doAutoCreate())
              this.publicationDateSeason = new StringType(); // bb
          return this.publicationDateSeason;
        }

        public boolean hasPublicationDateSeasonElement() { 
          return this.publicationDateSeason != null && !this.publicationDateSeason.isEmpty();
        }

        public boolean hasPublicationDateSeason() { 
          return this.publicationDateSeason != null && !this.publicationDateSeason.isEmpty();
        }

        /**
         * @param value {@link #publicationDateSeason} (Spring, Summer, Fall/Autumn, Winter.). This is the underlying object with id, value and extensions. The accessor "getPublicationDateSeason" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setPublicationDateSeasonElement(StringType value) { 
          this.publicationDateSeason = value;
          return this;
        }

        /**
         * @return Spring, Summer, Fall/Autumn, Winter.
         */
        public String getPublicationDateSeason() { 
          return this.publicationDateSeason == null ? null : this.publicationDateSeason.getValue();
        }

        /**
         * @param value Spring, Summer, Fall/Autumn, Winter.
         */
        public CitationCitedArtifactPublicationFormComponent setPublicationDateSeason(String value) { 
          if (Utilities.noString(value))
            this.publicationDateSeason = null;
          else {
            if (this.publicationDateSeason == null)
              this.publicationDateSeason = new StringType();
            this.publicationDateSeason.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #lastRevisionDate} (The date the article was last revised or updated in the database.). This is the underlying object with id, value and extensions. The accessor "getLastRevisionDate" gives direct access to the value
         */
        public DateTimeType getLastRevisionDateElement() { 
          if (this.lastRevisionDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.lastRevisionDate");
            else if (Configuration.doAutoCreate())
              this.lastRevisionDate = new DateTimeType(); // bb
          return this.lastRevisionDate;
        }

        public boolean hasLastRevisionDateElement() { 
          return this.lastRevisionDate != null && !this.lastRevisionDate.isEmpty();
        }

        public boolean hasLastRevisionDate() { 
          return this.lastRevisionDate != null && !this.lastRevisionDate.isEmpty();
        }

        /**
         * @param value {@link #lastRevisionDate} (The date the article was last revised or updated in the database.). This is the underlying object with id, value and extensions. The accessor "getLastRevisionDate" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setLastRevisionDateElement(DateTimeType value) { 
          this.lastRevisionDate = value;
          return this;
        }

        /**
         * @return The date the article was last revised or updated in the database.
         */
        public Date getLastRevisionDate() { 
          return this.lastRevisionDate == null ? null : this.lastRevisionDate.getValue();
        }

        /**
         * @param value The date the article was last revised or updated in the database.
         */
        public CitationCitedArtifactPublicationFormComponent setLastRevisionDate(Date value) { 
          if (value == null)
            this.lastRevisionDate = null;
          else {
            if (this.lastRevisionDate == null)
              this.lastRevisionDate = new DateTimeType();
            this.lastRevisionDate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #language} (The language or languages in which this form of the article is published.)
         */
        public List<CodeableConcept> getLanguage() { 
          if (this.language == null)
            this.language = new ArrayList<CodeableConcept>();
          return this.language;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactPublicationFormComponent setLanguage(List<CodeableConcept> theLanguage) { 
          this.language = theLanguage;
          return this;
        }

        public boolean hasLanguage() { 
          if (this.language == null)
            return false;
          for (CodeableConcept item : this.language)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addLanguage() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.language == null)
            this.language = new ArrayList<CodeableConcept>();
          this.language.add(t);
          return t;
        }

        public CitationCitedArtifactPublicationFormComponent addLanguage(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.language == null)
            this.language = new ArrayList<CodeableConcept>();
          this.language.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #language}, creating it if it does not already exist {3}
         */
        public CodeableConcept getLanguageFirstRep() { 
          if (getLanguage().isEmpty()) {
            addLanguage();
          }
          return getLanguage().get(0);
        }

        /**
         * @return {@link #accessionNumber} (Entry number or identifier for inclusion in a database.). This is the underlying object with id, value and extensions. The accessor "getAccessionNumber" gives direct access to the value
         */
        public StringType getAccessionNumberElement() { 
          if (this.accessionNumber == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.accessionNumber");
            else if (Configuration.doAutoCreate())
              this.accessionNumber = new StringType(); // bb
          return this.accessionNumber;
        }

        public boolean hasAccessionNumberElement() { 
          return this.accessionNumber != null && !this.accessionNumber.isEmpty();
        }

        public boolean hasAccessionNumber() { 
          return this.accessionNumber != null && !this.accessionNumber.isEmpty();
        }

        /**
         * @param value {@link #accessionNumber} (Entry number or identifier for inclusion in a database.). This is the underlying object with id, value and extensions. The accessor "getAccessionNumber" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setAccessionNumberElement(StringType value) { 
          this.accessionNumber = value;
          return this;
        }

        /**
         * @return Entry number or identifier for inclusion in a database.
         */
        public String getAccessionNumber() { 
          return this.accessionNumber == null ? null : this.accessionNumber.getValue();
        }

        /**
         * @param value Entry number or identifier for inclusion in a database.
         */
        public CitationCitedArtifactPublicationFormComponent setAccessionNumber(String value) { 
          if (Utilities.noString(value))
            this.accessionNumber = null;
          else {
            if (this.accessionNumber == null)
              this.accessionNumber = new StringType();
            this.accessionNumber.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #pageString} (Used for full display of pagination.). This is the underlying object with id, value and extensions. The accessor "getPageString" gives direct access to the value
         */
        public StringType getPageStringElement() { 
          if (this.pageString == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.pageString");
            else if (Configuration.doAutoCreate())
              this.pageString = new StringType(); // bb
          return this.pageString;
        }

        public boolean hasPageStringElement() { 
          return this.pageString != null && !this.pageString.isEmpty();
        }

        public boolean hasPageString() { 
          return this.pageString != null && !this.pageString.isEmpty();
        }

        /**
         * @param value {@link #pageString} (Used for full display of pagination.). This is the underlying object with id, value and extensions. The accessor "getPageString" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setPageStringElement(StringType value) { 
          this.pageString = value;
          return this;
        }

        /**
         * @return Used for full display of pagination.
         */
        public String getPageString() { 
          return this.pageString == null ? null : this.pageString.getValue();
        }

        /**
         * @param value Used for full display of pagination.
         */
        public CitationCitedArtifactPublicationFormComponent setPageString(String value) { 
          if (Utilities.noString(value))
            this.pageString = null;
          else {
            if (this.pageString == null)
              this.pageString = new StringType();
            this.pageString.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #firstPage} (Used for isolated representation of first page.). This is the underlying object with id, value and extensions. The accessor "getFirstPage" gives direct access to the value
         */
        public StringType getFirstPageElement() { 
          if (this.firstPage == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.firstPage");
            else if (Configuration.doAutoCreate())
              this.firstPage = new StringType(); // bb
          return this.firstPage;
        }

        public boolean hasFirstPageElement() { 
          return this.firstPage != null && !this.firstPage.isEmpty();
        }

        public boolean hasFirstPage() { 
          return this.firstPage != null && !this.firstPage.isEmpty();
        }

        /**
         * @param value {@link #firstPage} (Used for isolated representation of first page.). This is the underlying object with id, value and extensions. The accessor "getFirstPage" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setFirstPageElement(StringType value) { 
          this.firstPage = value;
          return this;
        }

        /**
         * @return Used for isolated representation of first page.
         */
        public String getFirstPage() { 
          return this.firstPage == null ? null : this.firstPage.getValue();
        }

        /**
         * @param value Used for isolated representation of first page.
         */
        public CitationCitedArtifactPublicationFormComponent setFirstPage(String value) { 
          if (Utilities.noString(value))
            this.firstPage = null;
          else {
            if (this.firstPage == null)
              this.firstPage = new StringType();
            this.firstPage.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #lastPage} (Used for isolated representation of last page.). This is the underlying object with id, value and extensions. The accessor "getLastPage" gives direct access to the value
         */
        public StringType getLastPageElement() { 
          if (this.lastPage == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.lastPage");
            else if (Configuration.doAutoCreate())
              this.lastPage = new StringType(); // bb
          return this.lastPage;
        }

        public boolean hasLastPageElement() { 
          return this.lastPage != null && !this.lastPage.isEmpty();
        }

        public boolean hasLastPage() { 
          return this.lastPage != null && !this.lastPage.isEmpty();
        }

        /**
         * @param value {@link #lastPage} (Used for isolated representation of last page.). This is the underlying object with id, value and extensions. The accessor "getLastPage" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setLastPageElement(StringType value) { 
          this.lastPage = value;
          return this;
        }

        /**
         * @return Used for isolated representation of last page.
         */
        public String getLastPage() { 
          return this.lastPage == null ? null : this.lastPage.getValue();
        }

        /**
         * @param value Used for isolated representation of last page.
         */
        public CitationCitedArtifactPublicationFormComponent setLastPage(String value) { 
          if (Utilities.noString(value))
            this.lastPage = null;
          else {
            if (this.lastPage == null)
              this.lastPage = new StringType();
            this.lastPage.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #pageCount} (Actual or approximate number of pages or screens. Distinct from reporting the page numbers.). This is the underlying object with id, value and extensions. The accessor "getPageCount" gives direct access to the value
         */
        public StringType getPageCountElement() { 
          if (this.pageCount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.pageCount");
            else if (Configuration.doAutoCreate())
              this.pageCount = new StringType(); // bb
          return this.pageCount;
        }

        public boolean hasPageCountElement() { 
          return this.pageCount != null && !this.pageCount.isEmpty();
        }

        public boolean hasPageCount() { 
          return this.pageCount != null && !this.pageCount.isEmpty();
        }

        /**
         * @param value {@link #pageCount} (Actual or approximate number of pages or screens. Distinct from reporting the page numbers.). This is the underlying object with id, value and extensions. The accessor "getPageCount" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setPageCountElement(StringType value) { 
          this.pageCount = value;
          return this;
        }

        /**
         * @return Actual or approximate number of pages or screens. Distinct from reporting the page numbers.
         */
        public String getPageCount() { 
          return this.pageCount == null ? null : this.pageCount.getValue();
        }

        /**
         * @param value Actual or approximate number of pages or screens. Distinct from reporting the page numbers.
         */
        public CitationCitedArtifactPublicationFormComponent setPageCount(String value) { 
          if (Utilities.noString(value))
            this.pageCount = null;
          else {
            if (this.pageCount == null)
              this.pageCount = new StringType();
            this.pageCount.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #copyright} (Copyright notice for the full article or artifact.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
         */
        public MarkdownType getCopyrightElement() { 
          if (this.copyright == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.copyright");
            else if (Configuration.doAutoCreate())
              this.copyright = new MarkdownType(); // bb
          return this.copyright;
        }

        public boolean hasCopyrightElement() { 
          return this.copyright != null && !this.copyright.isEmpty();
        }

        public boolean hasCopyright() { 
          return this.copyright != null && !this.copyright.isEmpty();
        }

        /**
         * @param value {@link #copyright} (Copyright notice for the full article or artifact.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormComponent setCopyrightElement(MarkdownType value) { 
          this.copyright = value;
          return this;
        }

        /**
         * @return Copyright notice for the full article or artifact.
         */
        public String getCopyright() { 
          return this.copyright == null ? null : this.copyright.getValue();
        }

        /**
         * @param value Copyright notice for the full article or artifact.
         */
        public CitationCitedArtifactPublicationFormComponent setCopyright(String value) { 
          if (Utilities.noString(value))
            this.copyright = null;
          else {
            if (this.copyright == null)
              this.copyright = new MarkdownType();
            this.copyright.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("publishedIn", "", "The collection the cited article or artifact is published in.", 0, 1, publishedIn));
          children.add(new Property("citedMedium", "CodeableConcept", "Describes the form of the medium cited. Common codes are \"Internet\" or \"Print\". The CitedMedium value set has 6 codes. The codes internet, print, and offline-digital-storage are the common codes for a typical publication form, though internet and print are more common for study citations. Three additional codes (each appending one of the primary codes with \"-without-issue\" are used for situations when a study is published both within an issue (of a periodical release as commonly done for journals) AND is published separately from the issue (as commonly done with early online publication), to represent specific identification of the publication form not associated with the issue.", 0, 1, citedMedium));
          children.add(new Property("volume", "string", "Volume number of journal or other collection in which the article is published.", 0, 1, volume));
          children.add(new Property("issue", "string", "Issue, part or supplement of journal or other collection in which the article is published.", 0, 1, issue));
          children.add(new Property("articleDate", "dateTime", "The date the article was added to the database, or the date the article was released.", 0, 1, articleDate));
          children.add(new Property("publicationDateText", "string", "Text representation of the date on which the issue of the cited artifact was published.", 0, 1, publicationDateText));
          children.add(new Property("publicationDateSeason", "string", "Spring, Summer, Fall/Autumn, Winter.", 0, 1, publicationDateSeason));
          children.add(new Property("lastRevisionDate", "dateTime", "The date the article was last revised or updated in the database.", 0, 1, lastRevisionDate));
          children.add(new Property("language", "CodeableConcept", "The language or languages in which this form of the article is published.", 0, java.lang.Integer.MAX_VALUE, language));
          children.add(new Property("accessionNumber", "string", "Entry number or identifier for inclusion in a database.", 0, 1, accessionNumber));
          children.add(new Property("pageString", "string", "Used for full display of pagination.", 0, 1, pageString));
          children.add(new Property("firstPage", "string", "Used for isolated representation of first page.", 0, 1, firstPage));
          children.add(new Property("lastPage", "string", "Used for isolated representation of last page.", 0, 1, lastPage));
          children.add(new Property("pageCount", "string", "Actual or approximate number of pages or screens. Distinct from reporting the page numbers.", 0, 1, pageCount));
          children.add(new Property("copyright", "markdown", "Copyright notice for the full article or artifact.", 0, 1, copyright));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -614144077: /*publishedIn*/  return new Property("publishedIn", "", "The collection the cited article or artifact is published in.", 0, 1, publishedIn);
          case 612116418: /*citedMedium*/  return new Property("citedMedium", "CodeableConcept", "Describes the form of the medium cited. Common codes are \"Internet\" or \"Print\". The CitedMedium value set has 6 codes. The codes internet, print, and offline-digital-storage are the common codes for a typical publication form, though internet and print are more common for study citations. Three additional codes (each appending one of the primary codes with \"-without-issue\" are used for situations when a study is published both within an issue (of a periodical release as commonly done for journals) AND is published separately from the issue (as commonly done with early online publication), to represent specific identification of the publication form not associated with the issue.", 0, 1, citedMedium);
          case -810883302: /*volume*/  return new Property("volume", "string", "Volume number of journal or other collection in which the article is published.", 0, 1, volume);
          case 100509913: /*issue*/  return new Property("issue", "string", "Issue, part or supplement of journal or other collection in which the article is published.", 0, 1, issue);
          case 817743300: /*articleDate*/  return new Property("articleDate", "dateTime", "The date the article was added to the database, or the date the article was released.", 0, 1, articleDate);
          case 225590343: /*publicationDateText*/  return new Property("publicationDateText", "string", "Text representation of the date on which the issue of the cited artifact was published.", 0, 1, publicationDateText);
          case 2014643069: /*publicationDateSeason*/  return new Property("publicationDateSeason", "string", "Spring, Summer, Fall/Autumn, Winter.", 0, 1, publicationDateSeason);
          case 2129161183: /*lastRevisionDate*/  return new Property("lastRevisionDate", "dateTime", "The date the article was last revised or updated in the database.", 0, 1, lastRevisionDate);
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "The language or languages in which this form of the article is published.", 0, java.lang.Integer.MAX_VALUE, language);
          case 1807963277: /*accessionNumber*/  return new Property("accessionNumber", "string", "Entry number or identifier for inclusion in a database.", 0, 1, accessionNumber);
          case 1287145344: /*pageString*/  return new Property("pageString", "string", "Used for full display of pagination.", 0, 1, pageString);
          case 132895071: /*firstPage*/  return new Property("firstPage", "string", "Used for isolated representation of first page.", 0, 1, firstPage);
          case -1459540411: /*lastPage*/  return new Property("lastPage", "string", "Used for isolated representation of last page.", 0, 1, lastPage);
          case 857882560: /*pageCount*/  return new Property("pageCount", "string", "Actual or approximate number of pages or screens. Distinct from reporting the page numbers.", 0, 1, pageCount);
          case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "Copyright notice for the full article or artifact.", 0, 1, copyright);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -614144077: /*publishedIn*/ return this.publishedIn == null ? new Base[0] : new Base[] {this.publishedIn}; // CitationCitedArtifactPublicationFormPublishedInComponent
        case 612116418: /*citedMedium*/ return this.citedMedium == null ? new Base[0] : new Base[] {this.citedMedium}; // CodeableConcept
        case -810883302: /*volume*/ return this.volume == null ? new Base[0] : new Base[] {this.volume}; // StringType
        case 100509913: /*issue*/ return this.issue == null ? new Base[0] : new Base[] {this.issue}; // StringType
        case 817743300: /*articleDate*/ return this.articleDate == null ? new Base[0] : new Base[] {this.articleDate}; // DateTimeType
        case 225590343: /*publicationDateText*/ return this.publicationDateText == null ? new Base[0] : new Base[] {this.publicationDateText}; // StringType
        case 2014643069: /*publicationDateSeason*/ return this.publicationDateSeason == null ? new Base[0] : new Base[] {this.publicationDateSeason}; // StringType
        case 2129161183: /*lastRevisionDate*/ return this.lastRevisionDate == null ? new Base[0] : new Base[] {this.lastRevisionDate}; // DateTimeType
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : this.language.toArray(new Base[this.language.size()]); // CodeableConcept
        case 1807963277: /*accessionNumber*/ return this.accessionNumber == null ? new Base[0] : new Base[] {this.accessionNumber}; // StringType
        case 1287145344: /*pageString*/ return this.pageString == null ? new Base[0] : new Base[] {this.pageString}; // StringType
        case 132895071: /*firstPage*/ return this.firstPage == null ? new Base[0] : new Base[] {this.firstPage}; // StringType
        case -1459540411: /*lastPage*/ return this.lastPage == null ? new Base[0] : new Base[] {this.lastPage}; // StringType
        case 857882560: /*pageCount*/ return this.pageCount == null ? new Base[0] : new Base[] {this.pageCount}; // StringType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -614144077: // publishedIn
          this.publishedIn = (CitationCitedArtifactPublicationFormPublishedInComponent) value; // CitationCitedArtifactPublicationFormPublishedInComponent
          return value;
        case 612116418: // citedMedium
          this.citedMedium = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -810883302: // volume
          this.volume = TypeConvertor.castToString(value); // StringType
          return value;
        case 100509913: // issue
          this.issue = TypeConvertor.castToString(value); // StringType
          return value;
        case 817743300: // articleDate
          this.articleDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 225590343: // publicationDateText
          this.publicationDateText = TypeConvertor.castToString(value); // StringType
          return value;
        case 2014643069: // publicationDateSeason
          this.publicationDateSeason = TypeConvertor.castToString(value); // StringType
          return value;
        case 2129161183: // lastRevisionDate
          this.lastRevisionDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1613589672: // language
          this.getLanguage().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1807963277: // accessionNumber
          this.accessionNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case 1287145344: // pageString
          this.pageString = TypeConvertor.castToString(value); // StringType
          return value;
        case 132895071: // firstPage
          this.firstPage = TypeConvertor.castToString(value); // StringType
          return value;
        case -1459540411: // lastPage
          this.lastPage = TypeConvertor.castToString(value); // StringType
          return value;
        case 857882560: // pageCount
          this.pageCount = TypeConvertor.castToString(value); // StringType
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("publishedIn")) {
          this.publishedIn = (CitationCitedArtifactPublicationFormPublishedInComponent) value; // CitationCitedArtifactPublicationFormPublishedInComponent
        } else if (name.equals("citedMedium")) {
          this.citedMedium = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("volume")) {
          this.volume = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("issue")) {
          this.issue = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("articleDate")) {
          this.articleDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("publicationDateText")) {
          this.publicationDateText = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("publicationDateSeason")) {
          this.publicationDateSeason = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("lastRevisionDate")) {
          this.lastRevisionDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("language")) {
          this.getLanguage().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("accessionNumber")) {
          this.accessionNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("pageString")) {
          this.pageString = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("firstPage")) {
          this.firstPage = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("lastPage")) {
          this.lastPage = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("pageCount")) {
          this.pageCount = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("publishedIn")) {
          this.publishedIn = (CitationCitedArtifactPublicationFormPublishedInComponent) value; // CitationCitedArtifactPublicationFormPublishedInComponent
        } else if (name.equals("citedMedium")) {
          this.citedMedium = null;
        } else if (name.equals("volume")) {
          this.volume = null;
        } else if (name.equals("issue")) {
          this.issue = null;
        } else if (name.equals("articleDate")) {
          this.articleDate = null;
        } else if (name.equals("publicationDateText")) {
          this.publicationDateText = null;
        } else if (name.equals("publicationDateSeason")) {
          this.publicationDateSeason = null;
        } else if (name.equals("lastRevisionDate")) {
          this.lastRevisionDate = null;
        } else if (name.equals("language")) {
          this.getLanguage().remove(value);
        } else if (name.equals("accessionNumber")) {
          this.accessionNumber = null;
        } else if (name.equals("pageString")) {
          this.pageString = null;
        } else if (name.equals("firstPage")) {
          this.firstPage = null;
        } else if (name.equals("lastPage")) {
          this.lastPage = null;
        } else if (name.equals("pageCount")) {
          this.pageCount = null;
        } else if (name.equals("copyright")) {
          this.copyright = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -614144077:  return getPublishedIn();
        case 612116418:  return getCitedMedium();
        case -810883302:  return getVolumeElement();
        case 100509913:  return getIssueElement();
        case 817743300:  return getArticleDateElement();
        case 225590343:  return getPublicationDateTextElement();
        case 2014643069:  return getPublicationDateSeasonElement();
        case 2129161183:  return getLastRevisionDateElement();
        case -1613589672:  return addLanguage(); 
        case 1807963277:  return getAccessionNumberElement();
        case 1287145344:  return getPageStringElement();
        case 132895071:  return getFirstPageElement();
        case -1459540411:  return getLastPageElement();
        case 857882560:  return getPageCountElement();
        case 1522889671:  return getCopyrightElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -614144077: /*publishedIn*/ return new String[] {};
        case 612116418: /*citedMedium*/ return new String[] {"CodeableConcept"};
        case -810883302: /*volume*/ return new String[] {"string"};
        case 100509913: /*issue*/ return new String[] {"string"};
        case 817743300: /*articleDate*/ return new String[] {"dateTime"};
        case 225590343: /*publicationDateText*/ return new String[] {"string"};
        case 2014643069: /*publicationDateSeason*/ return new String[] {"string"};
        case 2129161183: /*lastRevisionDate*/ return new String[] {"dateTime"};
        case -1613589672: /*language*/ return new String[] {"CodeableConcept"};
        case 1807963277: /*accessionNumber*/ return new String[] {"string"};
        case 1287145344: /*pageString*/ return new String[] {"string"};
        case 132895071: /*firstPage*/ return new String[] {"string"};
        case -1459540411: /*lastPage*/ return new String[] {"string"};
        case 857882560: /*pageCount*/ return new String[] {"string"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("publishedIn")) {
          this.publishedIn = new CitationCitedArtifactPublicationFormPublishedInComponent();
          return this.publishedIn;
        }
        else if (name.equals("citedMedium")) {
          this.citedMedium = new CodeableConcept();
          return this.citedMedium;
        }
        else if (name.equals("volume")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.volume");
        }
        else if (name.equals("issue")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.issue");
        }
        else if (name.equals("articleDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.articleDate");
        }
        else if (name.equals("publicationDateText")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.publicationDateText");
        }
        else if (name.equals("publicationDateSeason")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.publicationDateSeason");
        }
        else if (name.equals("lastRevisionDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.lastRevisionDate");
        }
        else if (name.equals("language")) {
          return addLanguage();
        }
        else if (name.equals("accessionNumber")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.accessionNumber");
        }
        else if (name.equals("pageString")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.pageString");
        }
        else if (name.equals("firstPage")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.firstPage");
        }
        else if (name.equals("lastPage")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.lastPage");
        }
        else if (name.equals("pageCount")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.pageCount");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.copyright");
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactPublicationFormComponent copy() {
        CitationCitedArtifactPublicationFormComponent dst = new CitationCitedArtifactPublicationFormComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactPublicationFormComponent dst) {
        super.copyValues(dst);
        dst.publishedIn = publishedIn == null ? null : publishedIn.copy();
        dst.citedMedium = citedMedium == null ? null : citedMedium.copy();
        dst.volume = volume == null ? null : volume.copy();
        dst.issue = issue == null ? null : issue.copy();
        dst.articleDate = articleDate == null ? null : articleDate.copy();
        dst.publicationDateText = publicationDateText == null ? null : publicationDateText.copy();
        dst.publicationDateSeason = publicationDateSeason == null ? null : publicationDateSeason.copy();
        dst.lastRevisionDate = lastRevisionDate == null ? null : lastRevisionDate.copy();
        if (language != null) {
          dst.language = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : language)
            dst.language.add(i.copy());
        };
        dst.accessionNumber = accessionNumber == null ? null : accessionNumber.copy();
        dst.pageString = pageString == null ? null : pageString.copy();
        dst.firstPage = firstPage == null ? null : firstPage.copy();
        dst.lastPage = lastPage == null ? null : lastPage.copy();
        dst.pageCount = pageCount == null ? null : pageCount.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactPublicationFormComponent))
          return false;
        CitationCitedArtifactPublicationFormComponent o = (CitationCitedArtifactPublicationFormComponent) other_;
        return compareDeep(publishedIn, o.publishedIn, true) && compareDeep(citedMedium, o.citedMedium, true)
           && compareDeep(volume, o.volume, true) && compareDeep(issue, o.issue, true) && compareDeep(articleDate, o.articleDate, true)
           && compareDeep(publicationDateText, o.publicationDateText, true) && compareDeep(publicationDateSeason, o.publicationDateSeason, true)
           && compareDeep(lastRevisionDate, o.lastRevisionDate, true) && compareDeep(language, o.language, true)
           && compareDeep(accessionNumber, o.accessionNumber, true) && compareDeep(pageString, o.pageString, true)
           && compareDeep(firstPage, o.firstPage, true) && compareDeep(lastPage, o.lastPage, true) && compareDeep(pageCount, o.pageCount, true)
           && compareDeep(copyright, o.copyright, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactPublicationFormComponent))
          return false;
        CitationCitedArtifactPublicationFormComponent o = (CitationCitedArtifactPublicationFormComponent) other_;
        return compareValues(volume, o.volume, true) && compareValues(issue, o.issue, true) && compareValues(articleDate, o.articleDate, true)
           && compareValues(publicationDateText, o.publicationDateText, true) && compareValues(publicationDateSeason, o.publicationDateSeason, true)
           && compareValues(lastRevisionDate, o.lastRevisionDate, true) && compareValues(accessionNumber, o.accessionNumber, true)
           && compareValues(pageString, o.pageString, true) && compareValues(firstPage, o.firstPage, true) && compareValues(lastPage, o.lastPage, true)
           && compareValues(pageCount, o.pageCount, true) && compareValues(copyright, o.copyright, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(publishedIn, citedMedium, volume
          , issue, articleDate, publicationDateText, publicationDateSeason, lastRevisionDate
          , language, accessionNumber, pageString, firstPage, lastPage, pageCount, copyright
          );
      }

  public String fhirType() {
    return "Citation.citedArtifact.publicationForm";

  }

  }

    @Block()
    public static class CitationCitedArtifactPublicationFormPublishedInComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Kind of container (e.g. Periodical, database, or book).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Kind of container (e.g. Periodical, database, or book)", formalDefinition="Kind of container (e.g. Periodical, database, or book)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/published-in-type")
        protected CodeableConcept type;

        /**
         * Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers include ISBN.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers include ISBN", formalDefinition="Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers include ISBN." )
        protected List<Identifier> identifier;

        /**
         * Name of the database or title of the book or journal.
         */
        @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of the database or title of the book or journal", formalDefinition="Name of the database or title of the book or journal." )
        protected StringType title;

        /**
         * Name of or resource describing the publisher.
         */
        @Child(name = "publisher", type = {Organization.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of or resource describing the publisher", formalDefinition="Name of or resource describing the publisher." )
        protected Reference publisher;

        /**
         * Geographic location of the publisher.
         */
        @Child(name = "publisherLocation", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Geographic location of the publisher", formalDefinition="Geographic location of the publisher." )
        protected StringType publisherLocation;

        private static final long serialVersionUID = 1440066953L;

    /**
     * Constructor
     */
      public CitationCitedArtifactPublicationFormPublishedInComponent() {
        super();
      }

        /**
         * @return {@link #type} (Kind of container (e.g. Periodical, database, or book).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormPublishedInComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Kind of container (e.g. Periodical, database, or book).)
         */
        public CitationCitedArtifactPublicationFormPublishedInComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #identifier} (Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers include ISBN.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactPublicationFormPublishedInComponent setIdentifier(List<Identifier> theIdentifier) { 
          this.identifier = theIdentifier;
          return this;
        }

        public boolean hasIdentifier() { 
          if (this.identifier == null)
            return false;
          for (Identifier item : this.identifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Identifier addIdentifier() { //3
          Identifier t = new Identifier();
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return t;
        }

        public CitationCitedArtifactPublicationFormPublishedInComponent addIdentifier(Identifier t) { //3
          if (t == null)
            return this;
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
         */
        public Identifier getIdentifierFirstRep() { 
          if (getIdentifier().isEmpty()) {
            addIdentifier();
          }
          return getIdentifier().get(0);
        }

        /**
         * @return {@link #title} (Name of the database or title of the book or journal.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormPublishedInComponent.title");
            else if (Configuration.doAutoCreate())
              this.title = new StringType(); // bb
          return this.title;
        }

        public boolean hasTitleElement() { 
          return this.title != null && !this.title.isEmpty();
        }

        public boolean hasTitle() { 
          return this.title != null && !this.title.isEmpty();
        }

        /**
         * @param value {@link #title} (Name of the database or title of the book or journal.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormPublishedInComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return Name of the database or title of the book or journal.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value Name of the database or title of the book or journal.
         */
        public CitationCitedArtifactPublicationFormPublishedInComponent setTitle(String value) { 
          if (Utilities.noString(value))
            this.title = null;
          else {
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #publisher} (Name of or resource describing the publisher.)
         */
        public Reference getPublisher() { 
          if (this.publisher == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormPublishedInComponent.publisher");
            else if (Configuration.doAutoCreate())
              this.publisher = new Reference(); // cc
          return this.publisher;
        }

        public boolean hasPublisher() { 
          return this.publisher != null && !this.publisher.isEmpty();
        }

        /**
         * @param value {@link #publisher} (Name of or resource describing the publisher.)
         */
        public CitationCitedArtifactPublicationFormPublishedInComponent setPublisher(Reference value) { 
          this.publisher = value;
          return this;
        }

        /**
         * @return {@link #publisherLocation} (Geographic location of the publisher.). This is the underlying object with id, value and extensions. The accessor "getPublisherLocation" gives direct access to the value
         */
        public StringType getPublisherLocationElement() { 
          if (this.publisherLocation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormPublishedInComponent.publisherLocation");
            else if (Configuration.doAutoCreate())
              this.publisherLocation = new StringType(); // bb
          return this.publisherLocation;
        }

        public boolean hasPublisherLocationElement() { 
          return this.publisherLocation != null && !this.publisherLocation.isEmpty();
        }

        public boolean hasPublisherLocation() { 
          return this.publisherLocation != null && !this.publisherLocation.isEmpty();
        }

        /**
         * @param value {@link #publisherLocation} (Geographic location of the publisher.). This is the underlying object with id, value and extensions. The accessor "getPublisherLocation" gives direct access to the value
         */
        public CitationCitedArtifactPublicationFormPublishedInComponent setPublisherLocationElement(StringType value) { 
          this.publisherLocation = value;
          return this;
        }

        /**
         * @return Geographic location of the publisher.
         */
        public String getPublisherLocation() { 
          return this.publisherLocation == null ? null : this.publisherLocation.getValue();
        }

        /**
         * @param value Geographic location of the publisher.
         */
        public CitationCitedArtifactPublicationFormPublishedInComponent setPublisherLocation(String value) { 
          if (Utilities.noString(value))
            this.publisherLocation = null;
          else {
            if (this.publisherLocation == null)
              this.publisherLocation = new StringType();
            this.publisherLocation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Kind of container (e.g. Periodical, database, or book).", 0, 1, type));
          children.add(new Property("identifier", "Identifier", "Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers include ISBN.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("title", "string", "Name of the database or title of the book or journal.", 0, 1, title));
          children.add(new Property("publisher", "Reference(Organization)", "Name of or resource describing the publisher.", 0, 1, publisher));
          children.add(new Property("publisherLocation", "string", "Geographic location of the publisher.", 0, 1, publisherLocation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Kind of container (e.g. Periodical, database, or book).", 0, 1, type);
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers include ISBN.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case 110371416: /*title*/  return new Property("title", "string", "Name of the database or title of the book or journal.", 0, 1, title);
          case 1447404028: /*publisher*/  return new Property("publisher", "Reference(Organization)", "Name of or resource describing the publisher.", 0, 1, publisher);
          case -1281627695: /*publisherLocation*/  return new Property("publisherLocation", "string", "Geographic location of the publisher.", 0, 1, publisherLocation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // Reference
        case -1281627695: /*publisherLocation*/ return this.publisherLocation == null ? new Base[0] : new Base[] {this.publisherLocation}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1281627695: // publisherLocation
          this.publisherLocation = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("publisherLocation")) {
          this.publisherLocation = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("title")) {
          this.title = null;
        } else if (name.equals("publisher")) {
          this.publisher = null;
        } else if (name.equals("publisherLocation")) {
          this.publisherLocation = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1618432855:  return addIdentifier(); 
        case 110371416:  return getTitleElement();
        case 1447404028:  return getPublisher();
        case -1281627695:  return getPublisherLocationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 110371416: /*title*/ return new String[] {"string"};
        case 1447404028: /*publisher*/ return new String[] {"Reference"};
        case -1281627695: /*publisherLocation*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.publishedIn.title");
        }
        else if (name.equals("publisher")) {
          this.publisher = new Reference();
          return this.publisher;
        }
        else if (name.equals("publisherLocation")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.publicationForm.publishedIn.publisherLocation");
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactPublicationFormPublishedInComponent copy() {
        CitationCitedArtifactPublicationFormPublishedInComponent dst = new CitationCitedArtifactPublicationFormPublishedInComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactPublicationFormPublishedInComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.title = title == null ? null : title.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        dst.publisherLocation = publisherLocation == null ? null : publisherLocation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactPublicationFormPublishedInComponent))
          return false;
        CitationCitedArtifactPublicationFormPublishedInComponent o = (CitationCitedArtifactPublicationFormPublishedInComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(identifier, o.identifier, true) && compareDeep(title, o.title, true)
           && compareDeep(publisher, o.publisher, true) && compareDeep(publisherLocation, o.publisherLocation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactPublicationFormPublishedInComponent))
          return false;
        CitationCitedArtifactPublicationFormPublishedInComponent o = (CitationCitedArtifactPublicationFormPublishedInComponent) other_;
        return compareValues(title, o.title, true) && compareValues(publisherLocation, o.publisherLocation, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, identifier, title
          , publisher, publisherLocation);
      }

  public String fhirType() {
    return "Citation.citedArtifact.publicationForm.publishedIn";

  }

  }

    @Block()
    public static class CitationCitedArtifactWebLocationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A characterization of the object expected at the web location.
         */
        @Child(name = "classifier", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Code the reason for different URLs, e.g. abstract and full-text", formalDefinition="A characterization of the object expected at the web location." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/artifact-url-classifier")
        protected List<CodeableConcept> classifier;

        /**
         * The specific URL.
         */
        @Child(name = "url", type = {UriType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The specific URL", formalDefinition="The specific URL." )
        protected UriType url;

        private static final long serialVersionUID = -1300703403L;

    /**
     * Constructor
     */
      public CitationCitedArtifactWebLocationComponent() {
        super();
      }

        /**
         * @return {@link #classifier} (A characterization of the object expected at the web location.)
         */
        public List<CodeableConcept> getClassifier() { 
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          return this.classifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactWebLocationComponent setClassifier(List<CodeableConcept> theClassifier) { 
          this.classifier = theClassifier;
          return this;
        }

        public boolean hasClassifier() { 
          if (this.classifier == null)
            return false;
          for (CodeableConcept item : this.classifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addClassifier() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return t;
        }

        public CitationCitedArtifactWebLocationComponent addClassifier(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #classifier}, creating it if it does not already exist {3}
         */
        public CodeableConcept getClassifierFirstRep() { 
          if (getClassifier().isEmpty()) {
            addClassifier();
          }
          return getClassifier().get(0);
        }

        /**
         * @return {@link #url} (The specific URL.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UriType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactWebLocationComponent.url");
            else if (Configuration.doAutoCreate())
              this.url = new UriType(); // bb
          return this.url;
        }

        public boolean hasUrlElement() { 
          return this.url != null && !this.url.isEmpty();
        }

        public boolean hasUrl() { 
          return this.url != null && !this.url.isEmpty();
        }

        /**
         * @param value {@link #url} (The specific URL.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public CitationCitedArtifactWebLocationComponent setUrlElement(UriType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return The specific URL.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value The specific URL.
         */
        public CitationCitedArtifactWebLocationComponent setUrl(String value) { 
          if (Utilities.noString(value))
            this.url = null;
          else {
            if (this.url == null)
              this.url = new UriType();
            this.url.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("classifier", "CodeableConcept", "A characterization of the object expected at the web location.", 0, java.lang.Integer.MAX_VALUE, classifier));
          children.add(new Property("url", "uri", "The specific URL.", 0, 1, url));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -281470431: /*classifier*/  return new Property("classifier", "CodeableConcept", "A characterization of the object expected at the web location.", 0, java.lang.Integer.MAX_VALUE, classifier);
          case 116079: /*url*/  return new Property("url", "uri", "The specific URL.", 0, 1, url);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -281470431: /*classifier*/ return this.classifier == null ? new Base[0] : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -281470431: // classifier
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("classifier")) {
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("classifier")) {
          this.getClassifier().remove(value);
        } else if (name.equals("url")) {
          this.url = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -281470431:  return addClassifier(); 
        case 116079:  return getUrlElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -281470431: /*classifier*/ return new String[] {"CodeableConcept"};
        case 116079: /*url*/ return new String[] {"uri"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("classifier")) {
          return addClassifier();
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.webLocation.url");
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactWebLocationComponent copy() {
        CitationCitedArtifactWebLocationComponent dst = new CitationCitedArtifactWebLocationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactWebLocationComponent dst) {
        super.copyValues(dst);
        if (classifier != null) {
          dst.classifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : classifier)
            dst.classifier.add(i.copy());
        };
        dst.url = url == null ? null : url.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactWebLocationComponent))
          return false;
        CitationCitedArtifactWebLocationComponent o = (CitationCitedArtifactWebLocationComponent) other_;
        return compareDeep(classifier, o.classifier, true) && compareDeep(url, o.url, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactWebLocationComponent))
          return false;
        CitationCitedArtifactWebLocationComponent o = (CitationCitedArtifactWebLocationComponent) other_;
        return compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(classifier, url);
      }

  public String fhirType() {
    return "Citation.citedArtifact.webLocation";

  }

  }

    @Block()
    public static class CitationCitedArtifactClassificationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The kind of classifier (e.g. publication type, keyword).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The kind of classifier (e.g. publication type, keyword)", formalDefinition="The kind of classifier (e.g. publication type, keyword)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/cited-artifact-classification-type")
        protected CodeableConcept type;

        /**
         * The specific classification value.
         */
        @Child(name = "classifier", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The specific classification value", formalDefinition="The specific classification value." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-artifact-classifier")
        protected List<CodeableConcept> classifier;

        /**
         * Complex or externally created classification.
         */
        @Child(name = "artifactAssessment", type = {ArtifactAssessment.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Complex or externally created classification", formalDefinition="Complex or externally created classification." )
        protected List<Reference> artifactAssessment;

        private static final long serialVersionUID = 394554928L;

    /**
     * Constructor
     */
      public CitationCitedArtifactClassificationComponent() {
        super();
      }

        /**
         * @return {@link #type} (The kind of classifier (e.g. publication type, keyword).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactClassificationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The kind of classifier (e.g. publication type, keyword).)
         */
        public CitationCitedArtifactClassificationComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #classifier} (The specific classification value.)
         */
        public List<CodeableConcept> getClassifier() { 
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          return this.classifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactClassificationComponent setClassifier(List<CodeableConcept> theClassifier) { 
          this.classifier = theClassifier;
          return this;
        }

        public boolean hasClassifier() { 
          if (this.classifier == null)
            return false;
          for (CodeableConcept item : this.classifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addClassifier() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return t;
        }

        public CitationCitedArtifactClassificationComponent addClassifier(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #classifier}, creating it if it does not already exist {3}
         */
        public CodeableConcept getClassifierFirstRep() { 
          if (getClassifier().isEmpty()) {
            addClassifier();
          }
          return getClassifier().get(0);
        }

        /**
         * @return {@link #artifactAssessment} (Complex or externally created classification.)
         */
        public List<Reference> getArtifactAssessment() { 
          if (this.artifactAssessment == null)
            this.artifactAssessment = new ArrayList<Reference>();
          return this.artifactAssessment;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactClassificationComponent setArtifactAssessment(List<Reference> theArtifactAssessment) { 
          this.artifactAssessment = theArtifactAssessment;
          return this;
        }

        public boolean hasArtifactAssessment() { 
          if (this.artifactAssessment == null)
            return false;
          for (Reference item : this.artifactAssessment)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addArtifactAssessment() { //3
          Reference t = new Reference();
          if (this.artifactAssessment == null)
            this.artifactAssessment = new ArrayList<Reference>();
          this.artifactAssessment.add(t);
          return t;
        }

        public CitationCitedArtifactClassificationComponent addArtifactAssessment(Reference t) { //3
          if (t == null)
            return this;
          if (this.artifactAssessment == null)
            this.artifactAssessment = new ArrayList<Reference>();
          this.artifactAssessment.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #artifactAssessment}, creating it if it does not already exist {3}
         */
        public Reference getArtifactAssessmentFirstRep() { 
          if (getArtifactAssessment().isEmpty()) {
            addArtifactAssessment();
          }
          return getArtifactAssessment().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The kind of classifier (e.g. publication type, keyword).", 0, 1, type));
          children.add(new Property("classifier", "CodeableConcept", "The specific classification value.", 0, java.lang.Integer.MAX_VALUE, classifier));
          children.add(new Property("artifactAssessment", "Reference(ArtifactAssessment)", "Complex or externally created classification.", 0, java.lang.Integer.MAX_VALUE, artifactAssessment));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The kind of classifier (e.g. publication type, keyword).", 0, 1, type);
          case -281470431: /*classifier*/  return new Property("classifier", "CodeableConcept", "The specific classification value.", 0, java.lang.Integer.MAX_VALUE, classifier);
          case 1014987316: /*artifactAssessment*/  return new Property("artifactAssessment", "Reference(ArtifactAssessment)", "Complex or externally created classification.", 0, java.lang.Integer.MAX_VALUE, artifactAssessment);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -281470431: /*classifier*/ return this.classifier == null ? new Base[0] : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
        case 1014987316: /*artifactAssessment*/ return this.artifactAssessment == null ? new Base[0] : this.artifactAssessment.toArray(new Base[this.artifactAssessment.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -281470431: // classifier
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1014987316: // artifactAssessment
          this.getArtifactAssessment().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("classifier")) {
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("artifactAssessment")) {
          this.getArtifactAssessment().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("classifier")) {
          this.getClassifier().remove(value);
        } else if (name.equals("artifactAssessment")) {
          this.getArtifactAssessment().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -281470431:  return addClassifier(); 
        case 1014987316:  return addArtifactAssessment(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -281470431: /*classifier*/ return new String[] {"CodeableConcept"};
        case 1014987316: /*artifactAssessment*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("classifier")) {
          return addClassifier();
        }
        else if (name.equals("artifactAssessment")) {
          return addArtifactAssessment();
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactClassificationComponent copy() {
        CitationCitedArtifactClassificationComponent dst = new CitationCitedArtifactClassificationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactClassificationComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (classifier != null) {
          dst.classifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : classifier)
            dst.classifier.add(i.copy());
        };
        if (artifactAssessment != null) {
          dst.artifactAssessment = new ArrayList<Reference>();
          for (Reference i : artifactAssessment)
            dst.artifactAssessment.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactClassificationComponent))
          return false;
        CitationCitedArtifactClassificationComponent o = (CitationCitedArtifactClassificationComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(classifier, o.classifier, true) && compareDeep(artifactAssessment, o.artifactAssessment, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactClassificationComponent))
          return false;
        CitationCitedArtifactClassificationComponent o = (CitationCitedArtifactClassificationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, classifier, artifactAssessment
          );
      }

  public String fhirType() {
    return "Citation.citedArtifact.classification";

  }

  }

    @Block()
    public static class CitationCitedArtifactContributorshipComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates if the list includes all authors and/or contributors.
         */
        @Child(name = "complete", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates if the list includes all authors and/or contributors", formalDefinition="Indicates if the list includes all authors and/or contributors." )
        protected BooleanType complete;

        /**
         * An individual entity named as a contributor, for example in the author list or contributor list.
         */
        @Child(name = "entry", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="An individual entity named as a contributor", formalDefinition="An individual entity named as a contributor, for example in the author list or contributor list." )
        protected List<CitationCitedArtifactContributorshipEntryComponent> entry;

        /**
         * Used to record a display of the author/contributor list without separate data element for each list member.
         */
        @Child(name = "summary", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Used to record a display of the author/contributor list without separate data element for each list member", formalDefinition="Used to record a display of the author/contributor list without separate data element for each list member." )
        protected List<ContributorshipSummaryComponent> summary;

        private static final long serialVersionUID = 662810405L;

    /**
     * Constructor
     */
      public CitationCitedArtifactContributorshipComponent() {
        super();
      }

        /**
         * @return {@link #complete} (Indicates if the list includes all authors and/or contributors.). This is the underlying object with id, value and extensions. The accessor "getComplete" gives direct access to the value
         */
        public BooleanType getCompleteElement() { 
          if (this.complete == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipComponent.complete");
            else if (Configuration.doAutoCreate())
              this.complete = new BooleanType(); // bb
          return this.complete;
        }

        public boolean hasCompleteElement() { 
          return this.complete != null && !this.complete.isEmpty();
        }

        public boolean hasComplete() { 
          return this.complete != null && !this.complete.isEmpty();
        }

        /**
         * @param value {@link #complete} (Indicates if the list includes all authors and/or contributors.). This is the underlying object with id, value and extensions. The accessor "getComplete" gives direct access to the value
         */
        public CitationCitedArtifactContributorshipComponent setCompleteElement(BooleanType value) { 
          this.complete = value;
          return this;
        }

        /**
         * @return Indicates if the list includes all authors and/or contributors.
         */
        public boolean getComplete() { 
          return this.complete == null || this.complete.isEmpty() ? false : this.complete.getValue();
        }

        /**
         * @param value Indicates if the list includes all authors and/or contributors.
         */
        public CitationCitedArtifactContributorshipComponent setComplete(boolean value) { 
            if (this.complete == null)
              this.complete = new BooleanType();
            this.complete.setValue(value);
          return this;
        }

        /**
         * @return {@link #entry} (An individual entity named as a contributor, for example in the author list or contributor list.)
         */
        public List<CitationCitedArtifactContributorshipEntryComponent> getEntry() { 
          if (this.entry == null)
            this.entry = new ArrayList<CitationCitedArtifactContributorshipEntryComponent>();
          return this.entry;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactContributorshipComponent setEntry(List<CitationCitedArtifactContributorshipEntryComponent> theEntry) { 
          this.entry = theEntry;
          return this;
        }

        public boolean hasEntry() { 
          if (this.entry == null)
            return false;
          for (CitationCitedArtifactContributorshipEntryComponent item : this.entry)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationCitedArtifactContributorshipEntryComponent addEntry() { //3
          CitationCitedArtifactContributorshipEntryComponent t = new CitationCitedArtifactContributorshipEntryComponent();
          if (this.entry == null)
            this.entry = new ArrayList<CitationCitedArtifactContributorshipEntryComponent>();
          this.entry.add(t);
          return t;
        }

        public CitationCitedArtifactContributorshipComponent addEntry(CitationCitedArtifactContributorshipEntryComponent t) { //3
          if (t == null)
            return this;
          if (this.entry == null)
            this.entry = new ArrayList<CitationCitedArtifactContributorshipEntryComponent>();
          this.entry.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #entry}, creating it if it does not already exist {3}
         */
        public CitationCitedArtifactContributorshipEntryComponent getEntryFirstRep() { 
          if (getEntry().isEmpty()) {
            addEntry();
          }
          return getEntry().get(0);
        }

        /**
         * @return {@link #summary} (Used to record a display of the author/contributor list without separate data element for each list member.)
         */
        public List<ContributorshipSummaryComponent> getSummary() { 
          if (this.summary == null)
            this.summary = new ArrayList<ContributorshipSummaryComponent>();
          return this.summary;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactContributorshipComponent setSummary(List<ContributorshipSummaryComponent> theSummary) { 
          this.summary = theSummary;
          return this;
        }

        public boolean hasSummary() { 
          if (this.summary == null)
            return false;
          for (ContributorshipSummaryComponent item : this.summary)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ContributorshipSummaryComponent addSummary() { //3
          ContributorshipSummaryComponent t = new ContributorshipSummaryComponent();
          if (this.summary == null)
            this.summary = new ArrayList<ContributorshipSummaryComponent>();
          this.summary.add(t);
          return t;
        }

        public CitationCitedArtifactContributorshipComponent addSummary(ContributorshipSummaryComponent t) { //3
          if (t == null)
            return this;
          if (this.summary == null)
            this.summary = new ArrayList<ContributorshipSummaryComponent>();
          this.summary.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #summary}, creating it if it does not already exist {3}
         */
        public ContributorshipSummaryComponent getSummaryFirstRep() { 
          if (getSummary().isEmpty()) {
            addSummary();
          }
          return getSummary().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("complete", "boolean", "Indicates if the list includes all authors and/or contributors.", 0, 1, complete));
          children.add(new Property("entry", "", "An individual entity named as a contributor, for example in the author list or contributor list.", 0, java.lang.Integer.MAX_VALUE, entry));
          children.add(new Property("summary", "", "Used to record a display of the author/contributor list without separate data element for each list member.", 0, java.lang.Integer.MAX_VALUE, summary));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -599445191: /*complete*/  return new Property("complete", "boolean", "Indicates if the list includes all authors and/or contributors.", 0, 1, complete);
          case 96667762: /*entry*/  return new Property("entry", "", "An individual entity named as a contributor, for example in the author list or contributor list.", 0, java.lang.Integer.MAX_VALUE, entry);
          case -1857640538: /*summary*/  return new Property("summary", "", "Used to record a display of the author/contributor list without separate data element for each list member.", 0, java.lang.Integer.MAX_VALUE, summary);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -599445191: /*complete*/ return this.complete == null ? new Base[0] : new Base[] {this.complete}; // BooleanType
        case 96667762: /*entry*/ return this.entry == null ? new Base[0] : this.entry.toArray(new Base[this.entry.size()]); // CitationCitedArtifactContributorshipEntryComponent
        case -1857640538: /*summary*/ return this.summary == null ? new Base[0] : this.summary.toArray(new Base[this.summary.size()]); // ContributorshipSummaryComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -599445191: // complete
          this.complete = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 96667762: // entry
          this.getEntry().add((CitationCitedArtifactContributorshipEntryComponent) value); // CitationCitedArtifactContributorshipEntryComponent
          return value;
        case -1857640538: // summary
          this.getSummary().add((ContributorshipSummaryComponent) value); // ContributorshipSummaryComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("complete")) {
          this.complete = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("entry")) {
          this.getEntry().add((CitationCitedArtifactContributorshipEntryComponent) value);
        } else if (name.equals("summary")) {
          this.getSummary().add((ContributorshipSummaryComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("complete")) {
          this.complete = null;
        } else if (name.equals("entry")) {
          this.getEntry().remove((CitationCitedArtifactContributorshipEntryComponent) value);
        } else if (name.equals("summary")) {
          this.getSummary().remove((ContributorshipSummaryComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -599445191:  return getCompleteElement();
        case 96667762:  return addEntry(); 
        case -1857640538:  return addSummary(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -599445191: /*complete*/ return new String[] {"boolean"};
        case 96667762: /*entry*/ return new String[] {};
        case -1857640538: /*summary*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("complete")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.contributorship.complete");
        }
        else if (name.equals("entry")) {
          return addEntry();
        }
        else if (name.equals("summary")) {
          return addSummary();
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactContributorshipComponent copy() {
        CitationCitedArtifactContributorshipComponent dst = new CitationCitedArtifactContributorshipComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactContributorshipComponent dst) {
        super.copyValues(dst);
        dst.complete = complete == null ? null : complete.copy();
        if (entry != null) {
          dst.entry = new ArrayList<CitationCitedArtifactContributorshipEntryComponent>();
          for (CitationCitedArtifactContributorshipEntryComponent i : entry)
            dst.entry.add(i.copy());
        };
        if (summary != null) {
          dst.summary = new ArrayList<ContributorshipSummaryComponent>();
          for (ContributorshipSummaryComponent i : summary)
            dst.summary.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactContributorshipComponent))
          return false;
        CitationCitedArtifactContributorshipComponent o = (CitationCitedArtifactContributorshipComponent) other_;
        return compareDeep(complete, o.complete, true) && compareDeep(entry, o.entry, true) && compareDeep(summary, o.summary, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactContributorshipComponent))
          return false;
        CitationCitedArtifactContributorshipComponent o = (CitationCitedArtifactContributorshipComponent) other_;
        return compareValues(complete, o.complete, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(complete, entry, summary
          );
      }

  public String fhirType() {
    return "Citation.citedArtifact.contributorship";

  }

  }

    @Block()
    public static class CitationCitedArtifactContributorshipEntryComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The identity of the individual contributor.
         */
        @Child(name = "contributor", type = {Practitioner.class, Organization.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The identity of the individual contributor", formalDefinition="The identity of the individual contributor." )
        protected Reference contributor;

        /**
         * For citation styles that use initials.
         */
        @Child(name = "forenameInitials", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="For citation styles that use initials", formalDefinition="For citation styles that use initials." )
        protected StringType forenameInitials;

        /**
         * Organization affiliated with the contributor.
         */
        @Child(name = "affiliation", type = {Organization.class, PractitionerRole.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Organizational affiliation", formalDefinition="Organization affiliated with the contributor." )
        protected List<Reference> affiliation;

        /**
         * This element identifies the specific nature of an individual’s contribution with respect to the cited work.
         */
        @Child(name = "contributionType", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The specific contribution", formalDefinition="This element identifies the specific nature of an individual’s contribution with respect to the cited work." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/artifact-contribution-type")
        protected List<CodeableConcept> contributionType;

        /**
         * The role of the contributor (e.g. author, editor, reviewer, funder).
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The role of the contributor (e.g. author, editor, reviewer, funder)", formalDefinition="The role of the contributor (e.g. author, editor, reviewer, funder)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/contributor-role")
        protected CodeableConcept role;

        /**
         * Contributions with accounting for time or number.
         */
        @Child(name = "contributionInstance", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Contributions with accounting for time or number", formalDefinition="Contributions with accounting for time or number." )
        protected List<CitationCitedArtifactContributorshipEntryContributionInstanceComponent> contributionInstance;

        /**
         * Whether the contributor is the corresponding contributor for the role.
         */
        @Child(name = "correspondingContact", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the contributor is the corresponding contributor for the role", formalDefinition="Whether the contributor is the corresponding contributor for the role." )
        protected BooleanType correspondingContact;

        /**
         * Provides a numerical ranking to represent the degree of contributorship relative to other contributors, such as 1 for first author and 2 for second author.
         */
        @Child(name = "rankingOrder", type = {PositiveIntType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Ranked order of contribution", formalDefinition="Provides a numerical ranking to represent the degree of contributorship relative to other contributors, such as 1 for first author and 2 for second author." )
        protected PositiveIntType rankingOrder;

        private static final long serialVersionUID = 1654594857L;

    /**
     * Constructor
     */
      public CitationCitedArtifactContributorshipEntryComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationCitedArtifactContributorshipEntryComponent(Reference contributor) {
        super();
        this.setContributor(contributor);
      }

        /**
         * @return {@link #contributor} (The identity of the individual contributor.)
         */
        public Reference getContributor() { 
          if (this.contributor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.contributor");
            else if (Configuration.doAutoCreate())
              this.contributor = new Reference(); // cc
          return this.contributor;
        }

        public boolean hasContributor() { 
          return this.contributor != null && !this.contributor.isEmpty();
        }

        /**
         * @param value {@link #contributor} (The identity of the individual contributor.)
         */
        public CitationCitedArtifactContributorshipEntryComponent setContributor(Reference value) { 
          this.contributor = value;
          return this;
        }

        /**
         * @return {@link #forenameInitials} (For citation styles that use initials.). This is the underlying object with id, value and extensions. The accessor "getForenameInitials" gives direct access to the value
         */
        public StringType getForenameInitialsElement() { 
          if (this.forenameInitials == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.forenameInitials");
            else if (Configuration.doAutoCreate())
              this.forenameInitials = new StringType(); // bb
          return this.forenameInitials;
        }

        public boolean hasForenameInitialsElement() { 
          return this.forenameInitials != null && !this.forenameInitials.isEmpty();
        }

        public boolean hasForenameInitials() { 
          return this.forenameInitials != null && !this.forenameInitials.isEmpty();
        }

        /**
         * @param value {@link #forenameInitials} (For citation styles that use initials.). This is the underlying object with id, value and extensions. The accessor "getForenameInitials" gives direct access to the value
         */
        public CitationCitedArtifactContributorshipEntryComponent setForenameInitialsElement(StringType value) { 
          this.forenameInitials = value;
          return this;
        }

        /**
         * @return For citation styles that use initials.
         */
        public String getForenameInitials() { 
          return this.forenameInitials == null ? null : this.forenameInitials.getValue();
        }

        /**
         * @param value For citation styles that use initials.
         */
        public CitationCitedArtifactContributorshipEntryComponent setForenameInitials(String value) { 
          if (Utilities.noString(value))
            this.forenameInitials = null;
          else {
            if (this.forenameInitials == null)
              this.forenameInitials = new StringType();
            this.forenameInitials.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #affiliation} (Organization affiliated with the contributor.)
         */
        public List<Reference> getAffiliation() { 
          if (this.affiliation == null)
            this.affiliation = new ArrayList<Reference>();
          return this.affiliation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactContributorshipEntryComponent setAffiliation(List<Reference> theAffiliation) { 
          this.affiliation = theAffiliation;
          return this;
        }

        public boolean hasAffiliation() { 
          if (this.affiliation == null)
            return false;
          for (Reference item : this.affiliation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addAffiliation() { //3
          Reference t = new Reference();
          if (this.affiliation == null)
            this.affiliation = new ArrayList<Reference>();
          this.affiliation.add(t);
          return t;
        }

        public CitationCitedArtifactContributorshipEntryComponent addAffiliation(Reference t) { //3
          if (t == null)
            return this;
          if (this.affiliation == null)
            this.affiliation = new ArrayList<Reference>();
          this.affiliation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #affiliation}, creating it if it does not already exist {3}
         */
        public Reference getAffiliationFirstRep() { 
          if (getAffiliation().isEmpty()) {
            addAffiliation();
          }
          return getAffiliation().get(0);
        }

        /**
         * @return {@link #contributionType} (This element identifies the specific nature of an individual’s contribution with respect to the cited work.)
         */
        public List<CodeableConcept> getContributionType() { 
          if (this.contributionType == null)
            this.contributionType = new ArrayList<CodeableConcept>();
          return this.contributionType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactContributorshipEntryComponent setContributionType(List<CodeableConcept> theContributionType) { 
          this.contributionType = theContributionType;
          return this;
        }

        public boolean hasContributionType() { 
          if (this.contributionType == null)
            return false;
          for (CodeableConcept item : this.contributionType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addContributionType() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.contributionType == null)
            this.contributionType = new ArrayList<CodeableConcept>();
          this.contributionType.add(t);
          return t;
        }

        public CitationCitedArtifactContributorshipEntryComponent addContributionType(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.contributionType == null)
            this.contributionType = new ArrayList<CodeableConcept>();
          this.contributionType.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #contributionType}, creating it if it does not already exist {3}
         */
        public CodeableConcept getContributionTypeFirstRep() { 
          if (getContributionType().isEmpty()) {
            addContributionType();
          }
          return getContributionType().get(0);
        }

        /**
         * @return {@link #role} (The role of the contributor (e.g. author, editor, reviewer, funder).)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (The role of the contributor (e.g. author, editor, reviewer, funder).)
         */
        public CitationCitedArtifactContributorshipEntryComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #contributionInstance} (Contributions with accounting for time or number.)
         */
        public List<CitationCitedArtifactContributorshipEntryContributionInstanceComponent> getContributionInstance() { 
          if (this.contributionInstance == null)
            this.contributionInstance = new ArrayList<CitationCitedArtifactContributorshipEntryContributionInstanceComponent>();
          return this.contributionInstance;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationCitedArtifactContributorshipEntryComponent setContributionInstance(List<CitationCitedArtifactContributorshipEntryContributionInstanceComponent> theContributionInstance) { 
          this.contributionInstance = theContributionInstance;
          return this;
        }

        public boolean hasContributionInstance() { 
          if (this.contributionInstance == null)
            return false;
          for (CitationCitedArtifactContributorshipEntryContributionInstanceComponent item : this.contributionInstance)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationCitedArtifactContributorshipEntryContributionInstanceComponent addContributionInstance() { //3
          CitationCitedArtifactContributorshipEntryContributionInstanceComponent t = new CitationCitedArtifactContributorshipEntryContributionInstanceComponent();
          if (this.contributionInstance == null)
            this.contributionInstance = new ArrayList<CitationCitedArtifactContributorshipEntryContributionInstanceComponent>();
          this.contributionInstance.add(t);
          return t;
        }

        public CitationCitedArtifactContributorshipEntryComponent addContributionInstance(CitationCitedArtifactContributorshipEntryContributionInstanceComponent t) { //3
          if (t == null)
            return this;
          if (this.contributionInstance == null)
            this.contributionInstance = new ArrayList<CitationCitedArtifactContributorshipEntryContributionInstanceComponent>();
          this.contributionInstance.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #contributionInstance}, creating it if it does not already exist {3}
         */
        public CitationCitedArtifactContributorshipEntryContributionInstanceComponent getContributionInstanceFirstRep() { 
          if (getContributionInstance().isEmpty()) {
            addContributionInstance();
          }
          return getContributionInstance().get(0);
        }

        /**
         * @return {@link #correspondingContact} (Whether the contributor is the corresponding contributor for the role.). This is the underlying object with id, value and extensions. The accessor "getCorrespondingContact" gives direct access to the value
         */
        public BooleanType getCorrespondingContactElement() { 
          if (this.correspondingContact == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.correspondingContact");
            else if (Configuration.doAutoCreate())
              this.correspondingContact = new BooleanType(); // bb
          return this.correspondingContact;
        }

        public boolean hasCorrespondingContactElement() { 
          return this.correspondingContact != null && !this.correspondingContact.isEmpty();
        }

        public boolean hasCorrespondingContact() { 
          return this.correspondingContact != null && !this.correspondingContact.isEmpty();
        }

        /**
         * @param value {@link #correspondingContact} (Whether the contributor is the corresponding contributor for the role.). This is the underlying object with id, value and extensions. The accessor "getCorrespondingContact" gives direct access to the value
         */
        public CitationCitedArtifactContributorshipEntryComponent setCorrespondingContactElement(BooleanType value) { 
          this.correspondingContact = value;
          return this;
        }

        /**
         * @return Whether the contributor is the corresponding contributor for the role.
         */
        public boolean getCorrespondingContact() { 
          return this.correspondingContact == null || this.correspondingContact.isEmpty() ? false : this.correspondingContact.getValue();
        }

        /**
         * @param value Whether the contributor is the corresponding contributor for the role.
         */
        public CitationCitedArtifactContributorshipEntryComponent setCorrespondingContact(boolean value) { 
            if (this.correspondingContact == null)
              this.correspondingContact = new BooleanType();
            this.correspondingContact.setValue(value);
          return this;
        }

        /**
         * @return {@link #rankingOrder} (Provides a numerical ranking to represent the degree of contributorship relative to other contributors, such as 1 for first author and 2 for second author.). This is the underlying object with id, value and extensions. The accessor "getRankingOrder" gives direct access to the value
         */
        public PositiveIntType getRankingOrderElement() { 
          if (this.rankingOrder == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.rankingOrder");
            else if (Configuration.doAutoCreate())
              this.rankingOrder = new PositiveIntType(); // bb
          return this.rankingOrder;
        }

        public boolean hasRankingOrderElement() { 
          return this.rankingOrder != null && !this.rankingOrder.isEmpty();
        }

        public boolean hasRankingOrder() { 
          return this.rankingOrder != null && !this.rankingOrder.isEmpty();
        }

        /**
         * @param value {@link #rankingOrder} (Provides a numerical ranking to represent the degree of contributorship relative to other contributors, such as 1 for first author and 2 for second author.). This is the underlying object with id, value and extensions. The accessor "getRankingOrder" gives direct access to the value
         */
        public CitationCitedArtifactContributorshipEntryComponent setRankingOrderElement(PositiveIntType value) { 
          this.rankingOrder = value;
          return this;
        }

        /**
         * @return Provides a numerical ranking to represent the degree of contributorship relative to other contributors, such as 1 for first author and 2 for second author.
         */
        public int getRankingOrder() { 
          return this.rankingOrder == null || this.rankingOrder.isEmpty() ? 0 : this.rankingOrder.getValue();
        }

        /**
         * @param value Provides a numerical ranking to represent the degree of contributorship relative to other contributors, such as 1 for first author and 2 for second author.
         */
        public CitationCitedArtifactContributorshipEntryComponent setRankingOrder(int value) { 
            if (this.rankingOrder == null)
              this.rankingOrder = new PositiveIntType();
            this.rankingOrder.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("contributor", "Reference(Practitioner|Organization)", "The identity of the individual contributor.", 0, 1, contributor));
          children.add(new Property("forenameInitials", "string", "For citation styles that use initials.", 0, 1, forenameInitials));
          children.add(new Property("affiliation", "Reference(Organization|PractitionerRole)", "Organization affiliated with the contributor.", 0, java.lang.Integer.MAX_VALUE, affiliation));
          children.add(new Property("contributionType", "CodeableConcept", "This element identifies the specific nature of an individual’s contribution with respect to the cited work.", 0, java.lang.Integer.MAX_VALUE, contributionType));
          children.add(new Property("role", "CodeableConcept", "The role of the contributor (e.g. author, editor, reviewer, funder).", 0, 1, role));
          children.add(new Property("contributionInstance", "", "Contributions with accounting for time or number.", 0, java.lang.Integer.MAX_VALUE, contributionInstance));
          children.add(new Property("correspondingContact", "boolean", "Whether the contributor is the corresponding contributor for the role.", 0, 1, correspondingContact));
          children.add(new Property("rankingOrder", "positiveInt", "Provides a numerical ranking to represent the degree of contributorship relative to other contributors, such as 1 for first author and 2 for second author.", 0, 1, rankingOrder));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1895276325: /*contributor*/  return new Property("contributor", "Reference(Practitioner|Organization)", "The identity of the individual contributor.", 0, 1, contributor);
          case -740521962: /*forenameInitials*/  return new Property("forenameInitials", "string", "For citation styles that use initials.", 0, 1, forenameInitials);
          case 2019918576: /*affiliation*/  return new Property("affiliation", "Reference(Organization|PractitionerRole)", "Organization affiliated with the contributor.", 0, java.lang.Integer.MAX_VALUE, affiliation);
          case -1600446614: /*contributionType*/  return new Property("contributionType", "CodeableConcept", "This element identifies the specific nature of an individual’s contribution with respect to the cited work.", 0, java.lang.Integer.MAX_VALUE, contributionType);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "The role of the contributor (e.g. author, editor, reviewer, funder).", 0, 1, role);
          case -547910459: /*contributionInstance*/  return new Property("contributionInstance", "", "Contributions with accounting for time or number.", 0, java.lang.Integer.MAX_VALUE, contributionInstance);
          case -1816008851: /*correspondingContact*/  return new Property("correspondingContact", "boolean", "Whether the contributor is the corresponding contributor for the role.", 0, 1, correspondingContact);
          case -762905416: /*rankingOrder*/  return new Property("rankingOrder", "positiveInt", "Provides a numerical ranking to represent the degree of contributorship relative to other contributors, such as 1 for first author and 2 for second author.", 0, 1, rankingOrder);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1895276325: /*contributor*/ return this.contributor == null ? new Base[0] : new Base[] {this.contributor}; // Reference
        case -740521962: /*forenameInitials*/ return this.forenameInitials == null ? new Base[0] : new Base[] {this.forenameInitials}; // StringType
        case 2019918576: /*affiliation*/ return this.affiliation == null ? new Base[0] : this.affiliation.toArray(new Base[this.affiliation.size()]); // Reference
        case -1600446614: /*contributionType*/ return this.contributionType == null ? new Base[0] : this.contributionType.toArray(new Base[this.contributionType.size()]); // CodeableConcept
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case -547910459: /*contributionInstance*/ return this.contributionInstance == null ? new Base[0] : this.contributionInstance.toArray(new Base[this.contributionInstance.size()]); // CitationCitedArtifactContributorshipEntryContributionInstanceComponent
        case -1816008851: /*correspondingContact*/ return this.correspondingContact == null ? new Base[0] : new Base[] {this.correspondingContact}; // BooleanType
        case -762905416: /*rankingOrder*/ return this.rankingOrder == null ? new Base[0] : new Base[] {this.rankingOrder}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1895276325: // contributor
          this.contributor = TypeConvertor.castToReference(value); // Reference
          return value;
        case -740521962: // forenameInitials
          this.forenameInitials = TypeConvertor.castToString(value); // StringType
          return value;
        case 2019918576: // affiliation
          this.getAffiliation().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1600446614: // contributionType
          this.getContributionType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -547910459: // contributionInstance
          this.getContributionInstance().add((CitationCitedArtifactContributorshipEntryContributionInstanceComponent) value); // CitationCitedArtifactContributorshipEntryContributionInstanceComponent
          return value;
        case -1816008851: // correspondingContact
          this.correspondingContact = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -762905416: // rankingOrder
          this.rankingOrder = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("contributor")) {
          this.contributor = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("forenameInitials")) {
          this.forenameInitials = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("affiliation")) {
          this.getAffiliation().add(TypeConvertor.castToReference(value));
        } else if (name.equals("contributionType")) {
          this.getContributionType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("contributionInstance")) {
          this.getContributionInstance().add((CitationCitedArtifactContributorshipEntryContributionInstanceComponent) value);
        } else if (name.equals("correspondingContact")) {
          this.correspondingContact = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("rankingOrder")) {
          this.rankingOrder = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("contributor")) {
          this.contributor = null;
        } else if (name.equals("forenameInitials")) {
          this.forenameInitials = null;
        } else if (name.equals("affiliation")) {
          this.getAffiliation().remove(value);
        } else if (name.equals("contributionType")) {
          this.getContributionType().remove(value);
        } else if (name.equals("role")) {
          this.role = null;
        } else if (name.equals("contributionInstance")) {
          this.getContributionInstance().remove((CitationCitedArtifactContributorshipEntryContributionInstanceComponent) value);
        } else if (name.equals("correspondingContact")) {
          this.correspondingContact = null;
        } else if (name.equals("rankingOrder")) {
          this.rankingOrder = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1895276325:  return getContributor();
        case -740521962:  return getForenameInitialsElement();
        case 2019918576:  return addAffiliation(); 
        case -1600446614:  return addContributionType(); 
        case 3506294:  return getRole();
        case -547910459:  return addContributionInstance(); 
        case -1816008851:  return getCorrespondingContactElement();
        case -762905416:  return getRankingOrderElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1895276325: /*contributor*/ return new String[] {"Reference"};
        case -740521962: /*forenameInitials*/ return new String[] {"string"};
        case 2019918576: /*affiliation*/ return new String[] {"Reference"};
        case -1600446614: /*contributionType*/ return new String[] {"CodeableConcept"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case -547910459: /*contributionInstance*/ return new String[] {};
        case -1816008851: /*correspondingContact*/ return new String[] {"boolean"};
        case -762905416: /*rankingOrder*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("contributor")) {
          this.contributor = new Reference();
          return this.contributor;
        }
        else if (name.equals("forenameInitials")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.contributorship.entry.forenameInitials");
        }
        else if (name.equals("affiliation")) {
          return addAffiliation();
        }
        else if (name.equals("contributionType")) {
          return addContributionType();
        }
        else if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("contributionInstance")) {
          return addContributionInstance();
        }
        else if (name.equals("correspondingContact")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.contributorship.entry.correspondingContact");
        }
        else if (name.equals("rankingOrder")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.contributorship.entry.rankingOrder");
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactContributorshipEntryComponent copy() {
        CitationCitedArtifactContributorshipEntryComponent dst = new CitationCitedArtifactContributorshipEntryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactContributorshipEntryComponent dst) {
        super.copyValues(dst);
        dst.contributor = contributor == null ? null : contributor.copy();
        dst.forenameInitials = forenameInitials == null ? null : forenameInitials.copy();
        if (affiliation != null) {
          dst.affiliation = new ArrayList<Reference>();
          for (Reference i : affiliation)
            dst.affiliation.add(i.copy());
        };
        if (contributionType != null) {
          dst.contributionType = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : contributionType)
            dst.contributionType.add(i.copy());
        };
        dst.role = role == null ? null : role.copy();
        if (contributionInstance != null) {
          dst.contributionInstance = new ArrayList<CitationCitedArtifactContributorshipEntryContributionInstanceComponent>();
          for (CitationCitedArtifactContributorshipEntryContributionInstanceComponent i : contributionInstance)
            dst.contributionInstance.add(i.copy());
        };
        dst.correspondingContact = correspondingContact == null ? null : correspondingContact.copy();
        dst.rankingOrder = rankingOrder == null ? null : rankingOrder.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactContributorshipEntryComponent))
          return false;
        CitationCitedArtifactContributorshipEntryComponent o = (CitationCitedArtifactContributorshipEntryComponent) other_;
        return compareDeep(contributor, o.contributor, true) && compareDeep(forenameInitials, o.forenameInitials, true)
           && compareDeep(affiliation, o.affiliation, true) && compareDeep(contributionType, o.contributionType, true)
           && compareDeep(role, o.role, true) && compareDeep(contributionInstance, o.contributionInstance, true)
           && compareDeep(correspondingContact, o.correspondingContact, true) && compareDeep(rankingOrder, o.rankingOrder, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactContributorshipEntryComponent))
          return false;
        CitationCitedArtifactContributorshipEntryComponent o = (CitationCitedArtifactContributorshipEntryComponent) other_;
        return compareValues(forenameInitials, o.forenameInitials, true) && compareValues(correspondingContact, o.correspondingContact, true)
           && compareValues(rankingOrder, o.rankingOrder, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(contributor, forenameInitials
          , affiliation, contributionType, role, contributionInstance, correspondingContact
          , rankingOrder);
      }

  public String fhirType() {
    return "Citation.citedArtifact.contributorship.entry";

  }

  }

    @Block()
    public static class CitationCitedArtifactContributorshipEntryContributionInstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The specific contribution.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The specific contribution", formalDefinition="The specific contribution." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/artifact-contribution-instance-type")
        protected CodeableConcept type;

        /**
         * The time that the contribution was made.
         */
        @Child(name = "time", type = {DateTimeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The time that the contribution was made", formalDefinition="The time that the contribution was made." )
        protected DateTimeType time;

        private static final long serialVersionUID = -196837729L;

    /**
     * Constructor
     */
      public CitationCitedArtifactContributorshipEntryContributionInstanceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationCitedArtifactContributorshipEntryContributionInstanceComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (The specific contribution.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryContributionInstanceComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The specific contribution.)
         */
        public CitationCitedArtifactContributorshipEntryContributionInstanceComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #time} (The time that the contribution was made.). This is the underlying object with id, value and extensions. The accessor "getTime" gives direct access to the value
         */
        public DateTimeType getTimeElement() { 
          if (this.time == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryContributionInstanceComponent.time");
            else if (Configuration.doAutoCreate())
              this.time = new DateTimeType(); // bb
          return this.time;
        }

        public boolean hasTimeElement() { 
          return this.time != null && !this.time.isEmpty();
        }

        public boolean hasTime() { 
          return this.time != null && !this.time.isEmpty();
        }

        /**
         * @param value {@link #time} (The time that the contribution was made.). This is the underlying object with id, value and extensions. The accessor "getTime" gives direct access to the value
         */
        public CitationCitedArtifactContributorshipEntryContributionInstanceComponent setTimeElement(DateTimeType value) { 
          this.time = value;
          return this;
        }

        /**
         * @return The time that the contribution was made.
         */
        public Date getTime() { 
          return this.time == null ? null : this.time.getValue();
        }

        /**
         * @param value The time that the contribution was made.
         */
        public CitationCitedArtifactContributorshipEntryContributionInstanceComponent setTime(Date value) { 
          if (value == null)
            this.time = null;
          else {
            if (this.time == null)
              this.time = new DateTimeType();
            this.time.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The specific contribution.", 0, 1, type));
          children.add(new Property("time", "dateTime", "The time that the contribution was made.", 0, 1, time));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The specific contribution.", 0, 1, type);
          case 3560141: /*time*/  return new Property("time", "dateTime", "The time that the contribution was made.", 0, 1, time);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 3560141: /*time*/ return this.time == null ? new Base[0] : new Base[] {this.time}; // DateTimeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3560141: // time
          this.time = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("time")) {
          this.time = TypeConvertor.castToDateTime(value); // DateTimeType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("time")) {
          this.time = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 3560141:  return getTimeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 3560141: /*time*/ return new String[] {"dateTime"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("time")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.contributorship.entry.contributionInstance.time");
        }
        else
          return super.addChild(name);
      }

      public CitationCitedArtifactContributorshipEntryContributionInstanceComponent copy() {
        CitationCitedArtifactContributorshipEntryContributionInstanceComponent dst = new CitationCitedArtifactContributorshipEntryContributionInstanceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationCitedArtifactContributorshipEntryContributionInstanceComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.time = time == null ? null : time.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactContributorshipEntryContributionInstanceComponent))
          return false;
        CitationCitedArtifactContributorshipEntryContributionInstanceComponent o = (CitationCitedArtifactContributorshipEntryContributionInstanceComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(time, o.time, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationCitedArtifactContributorshipEntryContributionInstanceComponent))
          return false;
        CitationCitedArtifactContributorshipEntryContributionInstanceComponent o = (CitationCitedArtifactContributorshipEntryContributionInstanceComponent) other_;
        return compareValues(time, o.time, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, time);
      }

  public String fhirType() {
    return "Citation.citedArtifact.contributorship.entry.contributionInstance";

  }

  }

    @Block()
    public static class ContributorshipSummaryComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used most commonly to express an author list or a contributorship statement.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Such as author list, contributorship statement, funding statement, acknowledgements statement, or conflicts of interest statement", formalDefinition="Used most commonly to express an author list or a contributorship statement." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/contributor-summary-type")
        protected CodeableConcept type;

        /**
         * The format for the display string, such as author last name with first letter capitalized followed by forename initials.
         */
        @Child(name = "style", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The format for the display string", formalDefinition="The format for the display string, such as author last name with first letter capitalized followed by forename initials." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/contributor-summary-style")
        protected CodeableConcept style;

        /**
         * Used to code the producer or rule for creating the display string.
         */
        @Child(name = "source", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to code the producer or rule for creating the display string", formalDefinition="Used to code the producer or rule for creating the display string." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/contributor-summary-source")
        protected CodeableConcept source;

        /**
         * The display string for the author list, contributor list, or contributorship statement.
         */
        @Child(name = "value", type = {MarkdownType.class}, order=4, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The display string for the author list, contributor list, or contributorship statement", formalDefinition="The display string for the author list, contributor list, or contributorship statement." )
        protected MarkdownType value;

        private static final long serialVersionUID = 1353383781L;

    /**
     * Constructor
     */
      public ContributorshipSummaryComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ContributorshipSummaryComponent(String value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #type} (Used most commonly to express an author list or a contributorship statement.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ContributorshipSummaryComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Used most commonly to express an author list or a contributorship statement.)
         */
        public ContributorshipSummaryComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #style} (The format for the display string, such as author last name with first letter capitalized followed by forename initials.)
         */
        public CodeableConcept getStyle() { 
          if (this.style == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ContributorshipSummaryComponent.style");
            else if (Configuration.doAutoCreate())
              this.style = new CodeableConcept(); // cc
          return this.style;
        }

        public boolean hasStyle() { 
          return this.style != null && !this.style.isEmpty();
        }

        /**
         * @param value {@link #style} (The format for the display string, such as author last name with first letter capitalized followed by forename initials.)
         */
        public ContributorshipSummaryComponent setStyle(CodeableConcept value) { 
          this.style = value;
          return this;
        }

        /**
         * @return {@link #source} (Used to code the producer or rule for creating the display string.)
         */
        public CodeableConcept getSource() { 
          if (this.source == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ContributorshipSummaryComponent.source");
            else if (Configuration.doAutoCreate())
              this.source = new CodeableConcept(); // cc
          return this.source;
        }

        public boolean hasSource() { 
          return this.source != null && !this.source.isEmpty();
        }

        /**
         * @param value {@link #source} (Used to code the producer or rule for creating the display string.)
         */
        public ContributorshipSummaryComponent setSource(CodeableConcept value) { 
          this.source = value;
          return this;
        }

        /**
         * @return {@link #value} (The display string for the author list, contributor list, or contributorship statement.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public MarkdownType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ContributorshipSummaryComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new MarkdownType(); // bb
          return this.value;
        }

        public boolean hasValueElement() { 
          return this.value != null && !this.value.isEmpty();
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The display string for the author list, contributor list, or contributorship statement.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public ContributorshipSummaryComponent setValueElement(MarkdownType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The display string for the author list, contributor list, or contributorship statement.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The display string for the author list, contributor list, or contributorship statement.
         */
        public ContributorshipSummaryComponent setValue(String value) { 
            if (this.value == null)
              this.value = new MarkdownType();
            this.value.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Used most commonly to express an author list or a contributorship statement.", 0, 1, type));
          children.add(new Property("style", "CodeableConcept", "The format for the display string, such as author last name with first letter capitalized followed by forename initials.", 0, 1, style));
          children.add(new Property("source", "CodeableConcept", "Used to code the producer or rule for creating the display string.", 0, 1, source));
          children.add(new Property("value", "markdown", "The display string for the author list, contributor list, or contributorship statement.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Used most commonly to express an author list or a contributorship statement.", 0, 1, type);
          case 109780401: /*style*/  return new Property("style", "CodeableConcept", "The format for the display string, such as author last name with first letter capitalized followed by forename initials.", 0, 1, style);
          case -896505829: /*source*/  return new Property("source", "CodeableConcept", "Used to code the producer or rule for creating the display string.", 0, 1, source);
          case 111972721: /*value*/  return new Property("value", "markdown", "The display string for the author list, contributor list, or contributorship statement.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 109780401: /*style*/ return this.style == null ? new Base[0] : new Base[] {this.style}; // CodeableConcept
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 109780401: // style
          this.style = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -896505829: // source
          this.source = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("style")) {
          this.style = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("source")) {
          this.source = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("style")) {
          this.style = null;
        } else if (name.equals("source")) {
          this.source = null;
        } else if (name.equals("value")) {
          this.value = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 109780401:  return getStyle();
        case -896505829:  return getSource();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 109780401: /*style*/ return new String[] {"CodeableConcept"};
        case -896505829: /*source*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("style")) {
          this.style = new CodeableConcept();
          return this.style;
        }
        else if (name.equals("source")) {
          this.source = new CodeableConcept();
          return this.source;
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.citedArtifact.contributorship.summary.value");
        }
        else
          return super.addChild(name);
      }

      public ContributorshipSummaryComponent copy() {
        ContributorshipSummaryComponent dst = new ContributorshipSummaryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ContributorshipSummaryComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.style = style == null ? null : style.copy();
        dst.source = source == null ? null : source.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ContributorshipSummaryComponent))
          return false;
        ContributorshipSummaryComponent o = (ContributorshipSummaryComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(style, o.style, true) && compareDeep(source, o.source, true)
           && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ContributorshipSummaryComponent))
          return false;
        ContributorshipSummaryComponent o = (ContributorshipSummaryComponent) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, style, source, value
          );
      }

  public String fhirType() {
    return "Citation.citedArtifact.contributorship.summary";

  }

  }

    /**
     * An absolute URI that is used to identify this citation record when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this citation record, represented as a globally unique URI", formalDefinition="An absolute URI that is used to identify this citation record when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this citation record when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Identifier for the citation record itself", formalDefinition="A formal identifier that is used to identify this citation record when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the citation record when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation record author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the citation record", formalDefinition="The identifier that is used to identify this version of the citation record when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation record author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * A natural language name identifying the citation record. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this citation record (computer friendly)", formalDefinition="A natural language name identifying the citation record. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the citation record.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this citation record (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the citation record." )
    protected StringType title;

    /**
     * The status of this summary. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this summary. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this citation record is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this citation record is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date (and optionally time) when the citation record was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation record changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date (and optionally time) when the citation record was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation record changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual that published the citation record.
     */
    @Child(name = "publisher", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The publisher of the citation record, not the publisher of the article or artifact being cited", formalDefinition="The name of the organization or individual that published the citation record." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher of the citation record", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the citation from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the citation", formalDefinition="A free text natural language description of the citation from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation record instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the citation record content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation record instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the citation record is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for citation record (if applicable)", formalDefinition="A legal or geographic region in which the citation record is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this citation is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this citation is defined", formalDefinition="Explanation of why this citation is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * Use and/or publishing restrictions for the citation record, not for the cited artifact.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions for the citation record, not for the cited artifact", formalDefinition="Use and/or publishing restrictions for the citation record, not for the cited artifact." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s) for the ciation record, not for the cited artifact", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the citation record was approved by publisher", formalDefinition="The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the citation record was last reviewed by the publisher", formalDefinition="The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the citation record content was or is planned to be in active use.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=19, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the citation record is expected to be used", formalDefinition="The period during which the citation record content was or is planned to be in active use." )
    protected Period effectivePeriod;

    /**
     * Who authored or created the citation record.
     */
    @Child(name = "author", type = {ContactDetail.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who authored the citation record", formalDefinition="Who authored or created the citation record." )
    protected List<ContactDetail> author;

    /**
     * Who edited or revised the citation record.
     */
    @Child(name = "editor", type = {ContactDetail.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who edited the citation record", formalDefinition="Who edited or revised the citation record." )
    protected List<ContactDetail> editor;

    /**
     * Who reviewed the citation record.
     */
    @Child(name = "reviewer", type = {ContactDetail.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who reviewed the citation record", formalDefinition="Who reviewed the citation record." )
    protected List<ContactDetail> reviewer;

    /**
     * Who endorsed the citation record.
     */
    @Child(name = "endorser", type = {ContactDetail.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who endorsed the citation record", formalDefinition="Who endorsed the citation record." )
    protected List<ContactDetail> endorser;

    /**
     * A human-readable display of key concepts to represent the citation.
     */
    @Child(name = "summary", type = {}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A human-readable display of key concepts to represent the citation", formalDefinition="A human-readable display of key concepts to represent the citation." )
    protected List<CitationSummaryComponent> summary;

    /**
     * The assignment to an organizing scheme.
     */
    @Child(name = "classification", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The assignment to an organizing scheme", formalDefinition="The assignment to an organizing scheme." )
    protected List<CitationClassificationComponent> classification;

    /**
     * Used for general notes and annotations not coded elsewhere.
     */
    @Child(name = "note", type = {Annotation.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for general notes and annotations not coded elsewhere", formalDefinition="Used for general notes and annotations not coded elsewhere." )
    protected List<Annotation> note;

    /**
     * The status of the citation record.
     */
    @Child(name = "currentState", type = {CodeableConcept.class}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The status of the citation record", formalDefinition="The status of the citation record." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-status-type")
    protected List<CodeableConcept> currentState;

    /**
     * The state or status of the citation record paired with an effective date or period for that state.
     */
    @Child(name = "statusDate", type = {}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="An effective date or period for a status of the citation record", formalDefinition="The state or status of the citation record paired with an effective date or period for that state." )
    protected List<CitationStatusDateComponent> statusDate;

    /**
     * Artifact related to the citation record.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=29, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Artifact related to the citation record", formalDefinition="Artifact related to the citation record." )
    protected List<RelatedArtifact> relatedArtifact;

    /**
     * The article or artifact being described.
     */
    @Child(name = "citedArtifact", type = {}, order=30, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The article or artifact being described", formalDefinition="The article or artifact being described." )
    protected CitationCitedArtifactComponent citedArtifact;

    private static final long serialVersionUID = 717016163L;

  /**
   * Constructor
   */
    public Citation() {
      super();
    }

  /**
   * Constructor
   */
    public Citation(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this citation record when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.url");
        else if (Configuration.doAutoCreate())
          this.url = new UriType(); // bb
      return this.url;
    }

    public boolean hasUrlElement() { 
      return this.url != null && !this.url.isEmpty();
    }

    public boolean hasUrl() { 
      return this.url != null && !this.url.isEmpty();
    }

    /**
     * @param value {@link #url} (An absolute URI that is used to identify this citation record when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Citation setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this citation record when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this citation record when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    public Citation setUrl(String value) { 
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this citation record when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public Citation addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #version} (The identifier that is used to identify this version of the citation record when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation record author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.version");
        else if (Configuration.doAutoCreate())
          this.version = new StringType(); // bb
      return this.version;
    }

    public boolean hasVersionElement() { 
      return this.version != null && !this.version.isEmpty();
    }

    public boolean hasVersion() { 
      return this.version != null && !this.version.isEmpty();
    }

    /**
     * @param value {@link #version} (The identifier that is used to identify this version of the citation record when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation record author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Citation setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the citation record when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation record author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the citation record when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation record author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public Citation setVersion(String value) { 
      if (Utilities.noString(value))
        this.version = null;
      else {
        if (this.version == null)
          this.version = new StringType();
        this.version.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public DataType getVersionAlgorithm() { 
      return this.versionAlgorithm;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public StringType getVersionAlgorithmStringType() throws FHIRException { 
      if (this.versionAlgorithm == null)
        this.versionAlgorithm = new StringType();
      if (!(this.versionAlgorithm instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.versionAlgorithm.getClass().getName()+" was encountered");
      return (StringType) this.versionAlgorithm;
    }

    public boolean hasVersionAlgorithmStringType() {
        return this.versionAlgorithm instanceof StringType;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public Coding getVersionAlgorithmCoding() throws FHIRException { 
      if (this.versionAlgorithm == null)
        this.versionAlgorithm = new Coding();
      if (!(this.versionAlgorithm instanceof Coding))
        throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.versionAlgorithm.getClass().getName()+" was encountered");
      return (Coding) this.versionAlgorithm;
    }

    public boolean hasVersionAlgorithmCoding() {
        return this.versionAlgorithm instanceof Coding;
    }

    public boolean hasVersionAlgorithm() { 
      return this.versionAlgorithm != null && !this.versionAlgorithm.isEmpty();
    }

    /**
     * @param value {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public Citation setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new FHIRException("Not the right type for Citation.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the citation record. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.name");
        else if (Configuration.doAutoCreate())
          this.name = new StringType(); // bb
      return this.name;
    }

    public boolean hasNameElement() { 
      return this.name != null && !this.name.isEmpty();
    }

    public boolean hasName() { 
      return this.name != null && !this.name.isEmpty();
    }

    /**
     * @param value {@link #name} (A natural language name identifying the citation record. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public Citation setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the citation record. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the citation record. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public Citation setName(String value) { 
      if (Utilities.noString(value))
        this.name = null;
      else {
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the citation record.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.title");
        else if (Configuration.doAutoCreate())
          this.title = new StringType(); // bb
      return this.title;
    }

    public boolean hasTitleElement() { 
      return this.title != null && !this.title.isEmpty();
    }

    public boolean hasTitle() { 
      return this.title != null && !this.title.isEmpty();
    }

    /**
     * @param value {@link #title} (A short, descriptive, user-friendly title for the citation record.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public Citation setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the citation record.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the citation record.
     */
    public Citation setTitle(String value) { 
      if (Utilities.noString(value))
        this.title = null;
      else {
        if (this.title == null)
          this.title = new StringType();
        this.title.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #status} (The status of this summary. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of this summary. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Citation setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this summary. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this summary. Enables tracking the life-cycle of the content.
     */
    public Citation setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this citation record is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.experimental");
        else if (Configuration.doAutoCreate())
          this.experimental = new BooleanType(); // bb
      return this.experimental;
    }

    public boolean hasExperimentalElement() { 
      return this.experimental != null && !this.experimental.isEmpty();
    }

    public boolean hasExperimental() { 
      return this.experimental != null && !this.experimental.isEmpty();
    }

    /**
     * @param value {@link #experimental} (A Boolean value to indicate that this citation record is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public Citation setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this citation record is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this citation record is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public Citation setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date (and optionally time) when the citation record was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation record changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateTimeType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (The date (and optionally time) when the citation record was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation record changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public Citation setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date (and optionally time) when the citation record was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation record changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date (and optionally time) when the citation record was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation record changes.
     */
    public Citation setDate(Date value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #publisher} (The name of the organization or individual that published the citation record.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.publisher");
        else if (Configuration.doAutoCreate())
          this.publisher = new StringType(); // bb
      return this.publisher;
    }

    public boolean hasPublisherElement() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    public boolean hasPublisher() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    /**
     * @param value {@link #publisher} (The name of the organization or individual that published the citation record.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public Citation setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual that published the citation record.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual that published the citation record.
     */
    public Citation setPublisher(String value) { 
      if (Utilities.noString(value))
        this.publisher = null;
      else {
        if (this.publisher == null)
          this.publisher = new StringType();
        this.publisher.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setContact(List<ContactDetail> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (ContactDetail item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addContact() { //3
      ContactDetail t = new ContactDetail();
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return t;
    }

    public Citation addContact(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #description} (A free text natural language description of the citation from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.description");
        else if (Configuration.doAutoCreate())
          this.description = new MarkdownType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (A free text natural language description of the citation from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Citation setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the citation from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the citation from a consumer's perspective.
     */
    public Citation setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation record instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setUseContext(List<UsageContext> theUseContext) { 
      this.useContext = theUseContext;
      return this;
    }

    public boolean hasUseContext() { 
      if (this.useContext == null)
        return false;
      for (UsageContext item : this.useContext)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public UsageContext addUseContext() { //3
      UsageContext t = new UsageContext();
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return t;
    }

    public Citation addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {3}
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the citation record is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setJurisdiction(List<CodeableConcept> theJurisdiction) { 
      this.jurisdiction = theJurisdiction;
      return this;
    }

    public boolean hasJurisdiction() { 
      if (this.jurisdiction == null)
        return false;
      for (CodeableConcept item : this.jurisdiction)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addJurisdiction() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return t;
    }

    public Citation addJurisdiction(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {3}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      if (getJurisdiction().isEmpty()) {
        addJurisdiction();
      }
      return getJurisdiction().get(0);
    }

    /**
     * @return {@link #purpose} (Explanation of why this citation is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.purpose");
        else if (Configuration.doAutoCreate())
          this.purpose = new MarkdownType(); // bb
      return this.purpose;
    }

    public boolean hasPurposeElement() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    public boolean hasPurpose() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    /**
     * @param value {@link #purpose} (Explanation of why this citation is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public Citation setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this citation is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this citation is needed and why it has been designed as it has.
     */
    public Citation setPurpose(String value) { 
      if (Utilities.noString(value))
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new MarkdownType();
        this.purpose.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (Use and/or publishing restrictions for the citation record, not for the cited artifact.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.copyright");
        else if (Configuration.doAutoCreate())
          this.copyright = new MarkdownType(); // bb
      return this.copyright;
    }

    public boolean hasCopyrightElement() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    public boolean hasCopyright() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    /**
     * @param value {@link #copyright} (Use and/or publishing restrictions for the citation record, not for the cited artifact.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public Citation setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return Use and/or publishing restrictions for the citation record, not for the cited artifact.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value Use and/or publishing restrictions for the citation record, not for the cited artifact.
     */
    public Citation setCopyright(String value) { 
      if (Utilities.noString(value))
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      if (this.copyrightLabel == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.copyrightLabel");
        else if (Configuration.doAutoCreate())
          this.copyrightLabel = new StringType(); // bb
      return this.copyrightLabel;
    }

    public boolean hasCopyrightLabelElement() { 
      return this.copyrightLabel != null && !this.copyrightLabel.isEmpty();
    }

    public boolean hasCopyrightLabel() { 
      return this.copyrightLabel != null && !this.copyrightLabel.isEmpty();
    }

    /**
     * @param value {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public Citation setCopyrightLabelElement(StringType value) { 
      this.copyrightLabel = value;
      return this;
    }

    /**
     * @return A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public String getCopyrightLabel() { 
      return this.copyrightLabel == null ? null : this.copyrightLabel.getValue();
    }

    /**
     * @param value A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public Citation setCopyrightLabel(String value) { 
      if (Utilities.noString(value))
        this.copyrightLabel = null;
      else {
        if (this.copyrightLabel == null)
          this.copyrightLabel = new StringType();
        this.copyrightLabel.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.approvalDate");
        else if (Configuration.doAutoCreate())
          this.approvalDate = new DateType(); // bb
      return this.approvalDate;
    }

    public boolean hasApprovalDateElement() { 
      return this.approvalDate != null && !this.approvalDate.isEmpty();
    }

    public boolean hasApprovalDate() { 
      return this.approvalDate != null && !this.approvalDate.isEmpty();
    }

    /**
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public Citation setApprovalDateElement(DateType value) { 
      this.approvalDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate() { 
      return this.approvalDate == null ? null : this.approvalDate.getValue();
    }

    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Citation setApprovalDate(Date value) { 
      if (value == null)
        this.approvalDate = null;
      else {
        if (this.approvalDate == null)
          this.approvalDate = new DateType();
        this.approvalDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      if (this.lastReviewDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.lastReviewDate");
        else if (Configuration.doAutoCreate())
          this.lastReviewDate = new DateType(); // bb
      return this.lastReviewDate;
    }

    public boolean hasLastReviewDateElement() { 
      return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
    }

    public boolean hasLastReviewDate() { 
      return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
    }

    /**
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public Citation setLastReviewDateElement(DateType value) { 
      this.lastReviewDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public Date getLastReviewDate() { 
      return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
    }

    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public Citation setLastReviewDate(Date value) { 
      if (value == null)
        this.lastReviewDate = null;
      else {
        if (this.lastReviewDate == null)
          this.lastReviewDate = new DateType();
        this.lastReviewDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #effectivePeriod} (The period during which the citation record content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the citation record content was or is planned to be in active use.)
     */
    public Citation setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #author} (Who authored or created the citation record.)
     */
    public List<ContactDetail> getAuthor() { 
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      return this.author;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setAuthor(List<ContactDetail> theAuthor) { 
      this.author = theAuthor;
      return this;
    }

    public boolean hasAuthor() { 
      if (this.author == null)
        return false;
      for (ContactDetail item : this.author)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addAuthor() { //3
      ContactDetail t = new ContactDetail();
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      this.author.add(t);
      return t;
    }

    public Citation addAuthor(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      this.author.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {3}
     */
    public ContactDetail getAuthorFirstRep() { 
      if (getAuthor().isEmpty()) {
        addAuthor();
      }
      return getAuthor().get(0);
    }

    /**
     * @return {@link #editor} (Who edited or revised the citation record.)
     */
    public List<ContactDetail> getEditor() { 
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      return this.editor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setEditor(List<ContactDetail> theEditor) { 
      this.editor = theEditor;
      return this;
    }

    public boolean hasEditor() { 
      if (this.editor == null)
        return false;
      for (ContactDetail item : this.editor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addEditor() { //3
      ContactDetail t = new ContactDetail();
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      this.editor.add(t);
      return t;
    }

    public Citation addEditor(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      this.editor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #editor}, creating it if it does not already exist {3}
     */
    public ContactDetail getEditorFirstRep() { 
      if (getEditor().isEmpty()) {
        addEditor();
      }
      return getEditor().get(0);
    }

    /**
     * @return {@link #reviewer} (Who reviewed the citation record.)
     */
    public List<ContactDetail> getReviewer() { 
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      return this.reviewer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setReviewer(List<ContactDetail> theReviewer) { 
      this.reviewer = theReviewer;
      return this;
    }

    public boolean hasReviewer() { 
      if (this.reviewer == null)
        return false;
      for (ContactDetail item : this.reviewer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addReviewer() { //3
      ContactDetail t = new ContactDetail();
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      this.reviewer.add(t);
      return t;
    }

    public Citation addReviewer(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      this.reviewer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reviewer}, creating it if it does not already exist {3}
     */
    public ContactDetail getReviewerFirstRep() { 
      if (getReviewer().isEmpty()) {
        addReviewer();
      }
      return getReviewer().get(0);
    }

    /**
     * @return {@link #endorser} (Who endorsed the citation record.)
     */
    public List<ContactDetail> getEndorser() { 
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      return this.endorser;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setEndorser(List<ContactDetail> theEndorser) { 
      this.endorser = theEndorser;
      return this;
    }

    public boolean hasEndorser() { 
      if (this.endorser == null)
        return false;
      for (ContactDetail item : this.endorser)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addEndorser() { //3
      ContactDetail t = new ContactDetail();
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      this.endorser.add(t);
      return t;
    }

    public Citation addEndorser(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      this.endorser.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #endorser}, creating it if it does not already exist {3}
     */
    public ContactDetail getEndorserFirstRep() { 
      if (getEndorser().isEmpty()) {
        addEndorser();
      }
      return getEndorser().get(0);
    }

    /**
     * @return {@link #summary} (A human-readable display of key concepts to represent the citation.)
     */
    public List<CitationSummaryComponent> getSummary() { 
      if (this.summary == null)
        this.summary = new ArrayList<CitationSummaryComponent>();
      return this.summary;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setSummary(List<CitationSummaryComponent> theSummary) { 
      this.summary = theSummary;
      return this;
    }

    public boolean hasSummary() { 
      if (this.summary == null)
        return false;
      for (CitationSummaryComponent item : this.summary)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationSummaryComponent addSummary() { //3
      CitationSummaryComponent t = new CitationSummaryComponent();
      if (this.summary == null)
        this.summary = new ArrayList<CitationSummaryComponent>();
      this.summary.add(t);
      return t;
    }

    public Citation addSummary(CitationSummaryComponent t) { //3
      if (t == null)
        return this;
      if (this.summary == null)
        this.summary = new ArrayList<CitationSummaryComponent>();
      this.summary.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #summary}, creating it if it does not already exist {3}
     */
    public CitationSummaryComponent getSummaryFirstRep() { 
      if (getSummary().isEmpty()) {
        addSummary();
      }
      return getSummary().get(0);
    }

    /**
     * @return {@link #classification} (The assignment to an organizing scheme.)
     */
    public List<CitationClassificationComponent> getClassification() { 
      if (this.classification == null)
        this.classification = new ArrayList<CitationClassificationComponent>();
      return this.classification;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setClassification(List<CitationClassificationComponent> theClassification) { 
      this.classification = theClassification;
      return this;
    }

    public boolean hasClassification() { 
      if (this.classification == null)
        return false;
      for (CitationClassificationComponent item : this.classification)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationClassificationComponent addClassification() { //3
      CitationClassificationComponent t = new CitationClassificationComponent();
      if (this.classification == null)
        this.classification = new ArrayList<CitationClassificationComponent>();
      this.classification.add(t);
      return t;
    }

    public Citation addClassification(CitationClassificationComponent t) { //3
      if (t == null)
        return this;
      if (this.classification == null)
        this.classification = new ArrayList<CitationClassificationComponent>();
      this.classification.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #classification}, creating it if it does not already exist {3}
     */
    public CitationClassificationComponent getClassificationFirstRep() { 
      if (getClassification().isEmpty()) {
        addClassification();
      }
      return getClassification().get(0);
    }

    /**
     * @return {@link #note} (Used for general notes and annotations not coded elsewhere.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public Citation addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    /**
     * @return {@link #currentState} (The status of the citation record.)
     */
    public List<CodeableConcept> getCurrentState() { 
      if (this.currentState == null)
        this.currentState = new ArrayList<CodeableConcept>();
      return this.currentState;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setCurrentState(List<CodeableConcept> theCurrentState) { 
      this.currentState = theCurrentState;
      return this;
    }

    public boolean hasCurrentState() { 
      if (this.currentState == null)
        return false;
      for (CodeableConcept item : this.currentState)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCurrentState() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.currentState == null)
        this.currentState = new ArrayList<CodeableConcept>();
      this.currentState.add(t);
      return t;
    }

    public Citation addCurrentState(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.currentState == null)
        this.currentState = new ArrayList<CodeableConcept>();
      this.currentState.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #currentState}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCurrentStateFirstRep() { 
      if (getCurrentState().isEmpty()) {
        addCurrentState();
      }
      return getCurrentState().get(0);
    }

    /**
     * @return {@link #statusDate} (The state or status of the citation record paired with an effective date or period for that state.)
     */
    public List<CitationStatusDateComponent> getStatusDate() { 
      if (this.statusDate == null)
        this.statusDate = new ArrayList<CitationStatusDateComponent>();
      return this.statusDate;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setStatusDate(List<CitationStatusDateComponent> theStatusDate) { 
      this.statusDate = theStatusDate;
      return this;
    }

    public boolean hasStatusDate() { 
      if (this.statusDate == null)
        return false;
      for (CitationStatusDateComponent item : this.statusDate)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationStatusDateComponent addStatusDate() { //3
      CitationStatusDateComponent t = new CitationStatusDateComponent();
      if (this.statusDate == null)
        this.statusDate = new ArrayList<CitationStatusDateComponent>();
      this.statusDate.add(t);
      return t;
    }

    public Citation addStatusDate(CitationStatusDateComponent t) { //3
      if (t == null)
        return this;
      if (this.statusDate == null)
        this.statusDate = new ArrayList<CitationStatusDateComponent>();
      this.statusDate.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #statusDate}, creating it if it does not already exist {3}
     */
    public CitationStatusDateComponent getStatusDateFirstRep() { 
      if (getStatusDate().isEmpty()) {
        addStatusDate();
      }
      return getStatusDate().get(0);
    }

    /**
     * @return {@link #relatedArtifact} (Artifact related to the citation record.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      return this.relatedArtifact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
      this.relatedArtifact = theRelatedArtifact;
      return this;
    }

    public boolean hasRelatedArtifact() { 
      if (this.relatedArtifact == null)
        return false;
      for (RelatedArtifact item : this.relatedArtifact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RelatedArtifact addRelatedArtifact() { //3
      RelatedArtifact t = new RelatedArtifact();
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return t;
    }

    public Citation addRelatedArtifact(RelatedArtifact t) { //3
      if (t == null)
        return this;
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {3}
     */
    public RelatedArtifact getRelatedArtifactFirstRep() { 
      if (getRelatedArtifact().isEmpty()) {
        addRelatedArtifact();
      }
      return getRelatedArtifact().get(0);
    }

    /**
     * @return {@link #citedArtifact} (The article or artifact being described.)
     */
    public CitationCitedArtifactComponent getCitedArtifact() { 
      if (this.citedArtifact == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.citedArtifact");
        else if (Configuration.doAutoCreate())
          this.citedArtifact = new CitationCitedArtifactComponent(); // cc
      return this.citedArtifact;
    }

    public boolean hasCitedArtifact() { 
      return this.citedArtifact != null && !this.citedArtifact.isEmpty();
    }

    /**
     * @param value {@link #citedArtifact} (The article or artifact being described.)
     */
    public Citation setCitedArtifact(CitationCitedArtifactComponent value) { 
      this.citedArtifact = value;
      return this;
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getTopicMax() { 
      return 0;
    }
    /**
     * @return {@link #topic} (Descriptive topics related to the content of the citation. Topics provide a high-level categorization as well as keywords for the citation that can be useful for filtering and searching.)
     */
    public List<CodeableConcept> getTopic() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setTopic(List<CodeableConcept> theTopic) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"topic\""); 
    }
    public boolean hasTopic() { 
      return false;
    }

    public CodeableConcept addTopic() { //3
      throw new Error("The resource type \"Citation\" does not implement the property \"topic\""); 
    }
    public Citation addTopic(CodeableConcept t) { //3
      throw new Error("The resource type \"Citation\" does not implement the property \"topic\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {2}
     */
    public CodeableConcept getTopicFirstRep() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"topic\""); 
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this citation record when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this citation record when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the citation record when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation record author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "A natural language name identifying the citation record. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the citation record.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this citation record is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date (and optionally time) when the citation record was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation record changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual that published the citation record.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the citation from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation record instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the citation record is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this citation is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "Use and/or publishing restrictions for the citation record, not for the cited artifact.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the citation record content was or is planned to be in active use.", 0, 1, effectivePeriod));
        children.add(new Property("author", "ContactDetail", "Who authored or created the citation record.", 0, java.lang.Integer.MAX_VALUE, author));
        children.add(new Property("editor", "ContactDetail", "Who edited or revised the citation record.", 0, java.lang.Integer.MAX_VALUE, editor));
        children.add(new Property("reviewer", "ContactDetail", "Who reviewed the citation record.", 0, java.lang.Integer.MAX_VALUE, reviewer));
        children.add(new Property("endorser", "ContactDetail", "Who endorsed the citation record.", 0, java.lang.Integer.MAX_VALUE, endorser));
        children.add(new Property("summary", "", "A human-readable display of key concepts to represent the citation.", 0, java.lang.Integer.MAX_VALUE, summary));
        children.add(new Property("classification", "", "The assignment to an organizing scheme.", 0, java.lang.Integer.MAX_VALUE, classification));
        children.add(new Property("note", "Annotation", "Used for general notes and annotations not coded elsewhere.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("currentState", "CodeableConcept", "The status of the citation record.", 0, java.lang.Integer.MAX_VALUE, currentState));
        children.add(new Property("statusDate", "", "The state or status of the citation record paired with an effective date or period for that state.", 0, java.lang.Integer.MAX_VALUE, statusDate));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Artifact related to the citation record.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("citedArtifact", "", "The article or artifact being described.", 0, 1, citedArtifact));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this citation record when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this citation record when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the citation record when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation record author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the citation record. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the citation record.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this citation record is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date (and optionally time) when the citation record was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation record changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual that published the citation record.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the citation from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation record instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the citation record is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this citation is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "Use and/or publishing restrictions for the citation record, not for the cited artifact.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the citation record content was or is planned to be in active use.", 0, 1, effectivePeriod);
        case -1406328437: /*author*/  return new Property("author", "ContactDetail", "Who authored or created the citation record.", 0, java.lang.Integer.MAX_VALUE, author);
        case -1307827859: /*editor*/  return new Property("editor", "ContactDetail", "Who edited or revised the citation record.", 0, java.lang.Integer.MAX_VALUE, editor);
        case -261190139: /*reviewer*/  return new Property("reviewer", "ContactDetail", "Who reviewed the citation record.", 0, java.lang.Integer.MAX_VALUE, reviewer);
        case 1740277666: /*endorser*/  return new Property("endorser", "ContactDetail", "Who endorsed the citation record.", 0, java.lang.Integer.MAX_VALUE, endorser);
        case -1857640538: /*summary*/  return new Property("summary", "", "A human-readable display of key concepts to represent the citation.", 0, java.lang.Integer.MAX_VALUE, summary);
        case 382350310: /*classification*/  return new Property("classification", "", "The assignment to an organizing scheme.", 0, java.lang.Integer.MAX_VALUE, classification);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Used for general notes and annotations not coded elsewhere.", 0, java.lang.Integer.MAX_VALUE, note);
        case 1457822360: /*currentState*/  return new Property("currentState", "CodeableConcept", "The status of the citation record.", 0, java.lang.Integer.MAX_VALUE, currentState);
        case 247524032: /*statusDate*/  return new Property("statusDate", "", "The state or status of the citation record paired with an effective date or period for that state.", 0, java.lang.Integer.MAX_VALUE, statusDate);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Artifact related to the citation record.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case -495272225: /*citedArtifact*/  return new Property("citedArtifact", "", "The article or artifact being described.", 0, 1, citedArtifact);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 1508158071: /*versionAlgorithm*/ return this.versionAlgorithm == null ? new Base[0] : new Base[] {this.versionAlgorithm}; // DataType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 765157229: /*copyrightLabel*/ return this.copyrightLabel == null ? new Base[0] : new Base[] {this.copyrightLabel}; // StringType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // ContactDetail
        case -1307827859: /*editor*/ return this.editor == null ? new Base[0] : this.editor.toArray(new Base[this.editor.size()]); // ContactDetail
        case -261190139: /*reviewer*/ return this.reviewer == null ? new Base[0] : this.reviewer.toArray(new Base[this.reviewer.size()]); // ContactDetail
        case 1740277666: /*endorser*/ return this.endorser == null ? new Base[0] : this.endorser.toArray(new Base[this.endorser.size()]); // ContactDetail
        case -1857640538: /*summary*/ return this.summary == null ? new Base[0] : this.summary.toArray(new Base[this.summary.size()]); // CitationSummaryComponent
        case 382350310: /*classification*/ return this.classification == null ? new Base[0] : this.classification.toArray(new Base[this.classification.size()]); // CitationClassificationComponent
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1457822360: /*currentState*/ return this.currentState == null ? new Base[0] : this.currentState.toArray(new Base[this.currentState.size()]); // CodeableConcept
        case 247524032: /*statusDate*/ return this.statusDate == null ? new Base[0] : this.statusDate.toArray(new Base[this.statusDate.size()]); // CitationStatusDateComponent
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case -495272225: /*citedArtifact*/ return this.citedArtifact == null ? new Base[0] : new Base[] {this.citedArtifact}; // CitationCitedArtifactComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 1508158071: // versionAlgorithm
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -404562712: // experimental
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToString(value); // StringType
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case -507075711: // jurisdiction
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -220463842: // purpose
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 765157229: // copyrightLabel
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
          return value;
        case 223539345: // approvalDate
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1687512484: // lastReviewDate
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -403934648: // effectivePeriod
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -1406328437: // author
          this.getAuthor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1307827859: // editor
          this.getEditor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -261190139: // reviewer
          this.getReviewer().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case 1740277666: // endorser
          this.getEndorser().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1857640538: // summary
          this.getSummary().add((CitationSummaryComponent) value); // CitationSummaryComponent
          return value;
        case 382350310: // classification
          this.getClassification().add((CitationClassificationComponent) value); // CitationClassificationComponent
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 1457822360: // currentState
          this.getCurrentState().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 247524032: // statusDate
          this.getStatusDate().add((CitationStatusDateComponent) value); // CitationStatusDateComponent
          return value;
        case 666807069: // relatedArtifact
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case -495272225: // citedArtifact
          this.citedArtifact = (CitationCitedArtifactComponent) value; // CitationCitedArtifactComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("versionAlgorithm[x]")) {
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyrightLabel")) {
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("approvalDate")) {
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("author")) {
          this.getAuthor().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("editor")) {
          this.getEditor().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("reviewer")) {
          this.getReviewer().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("endorser")) {
          this.getEndorser().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("summary")) {
          this.getSummary().add((CitationSummaryComponent) value);
        } else if (name.equals("classification")) {
          this.getClassification().add((CitationClassificationComponent) value);
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("currentState")) {
          this.getCurrentState().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("statusDate")) {
          this.getStatusDate().add((CitationStatusDateComponent) value);
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("citedArtifact")) {
          this.citedArtifact = (CitationCitedArtifactComponent) value; // CitationCitedArtifactComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = null;
        } else if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("version")) {
          this.version = null;
        } else if (name.equals("versionAlgorithm[x]")) {
          this.versionAlgorithm = null;
        } else if (name.equals("name")) {
          this.name = null;
        } else if (name.equals("title")) {
          this.title = null;
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = null;
        } else if (name.equals("date")) {
          this.date = null;
        } else if (name.equals("publisher")) {
          this.publisher = null;
        } else if (name.equals("contact")) {
          this.getContact().remove(value);
        } else if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("useContext")) {
          this.getUseContext().remove(value);
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().remove(value);
        } else if (name.equals("purpose")) {
          this.purpose = null;
        } else if (name.equals("copyright")) {
          this.copyright = null;
        } else if (name.equals("copyrightLabel")) {
          this.copyrightLabel = null;
        } else if (name.equals("approvalDate")) {
          this.approvalDate = null;
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = null;
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = null;
        } else if (name.equals("author")) {
          this.getAuthor().remove(value);
        } else if (name.equals("editor")) {
          this.getEditor().remove(value);
        } else if (name.equals("reviewer")) {
          this.getReviewer().remove(value);
        } else if (name.equals("endorser")) {
          this.getEndorser().remove(value);
        } else if (name.equals("summary")) {
          this.getSummary().remove((CitationSummaryComponent) value);
        } else if (name.equals("classification")) {
          this.getClassification().remove((CitationClassificationComponent) value);
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else if (name.equals("currentState")) {
          this.getCurrentState().remove(value);
        } else if (name.equals("statusDate")) {
          this.getStatusDate().remove((CitationStatusDateComponent) value);
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().remove(value);
        } else if (name.equals("citedArtifact")) {
          this.citedArtifact = (CitationCitedArtifactComponent) value; // CitationCitedArtifactComponent
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case -115699031:  return getVersionAlgorithm();
        case 1508158071:  return getVersionAlgorithm();
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 765157229:  return getCopyrightLabelElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case -1406328437:  return addAuthor(); 
        case -1307827859:  return addEditor(); 
        case -261190139:  return addReviewer(); 
        case 1740277666:  return addEndorser(); 
        case -1857640538:  return addSummary(); 
        case 382350310:  return addClassification(); 
        case 3387378:  return addNote(); 
        case 1457822360:  return addCurrentState(); 
        case 247524032:  return addStatusDate(); 
        case 666807069:  return addRelatedArtifact(); 
        case -495272225:  return getCitedArtifact();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 1508158071: /*versionAlgorithm*/ return new String[] {"string", "Coding"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 765157229: /*copyrightLabel*/ return new String[] {"string"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case -1406328437: /*author*/ return new String[] {"ContactDetail"};
        case -1307827859: /*editor*/ return new String[] {"ContactDetail"};
        case -261190139: /*reviewer*/ return new String[] {"ContactDetail"};
        case 1740277666: /*endorser*/ return new String[] {"ContactDetail"};
        case -1857640538: /*summary*/ return new String[] {};
        case 382350310: /*classification*/ return new String[] {};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 1457822360: /*currentState*/ return new String[] {"CodeableConcept"};
        case 247524032: /*statusDate*/ return new String[] {};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case -495272225: /*citedArtifact*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.version");
        }
        else if (name.equals("versionAlgorithmString")) {
          this.versionAlgorithm = new StringType();
          return this.versionAlgorithm;
        }
        else if (name.equals("versionAlgorithmCoding")) {
          this.versionAlgorithm = new Coding();
          return this.versionAlgorithm;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.copyright");
        }
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.copyrightLabel");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Citation.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("author")) {
          return addAuthor();
        }
        else if (name.equals("editor")) {
          return addEditor();
        }
        else if (name.equals("reviewer")) {
          return addReviewer();
        }
        else if (name.equals("endorser")) {
          return addEndorser();
        }
        else if (name.equals("summary")) {
          return addSummary();
        }
        else if (name.equals("classification")) {
          return addClassification();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("currentState")) {
          return addCurrentState();
        }
        else if (name.equals("statusDate")) {
          return addStatusDate();
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else if (name.equals("citedArtifact")) {
          this.citedArtifact = new CitationCitedArtifactComponent();
          return this.citedArtifact;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Citation";

  }

      public Citation copy() {
        Citation dst = new Citation();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Citation dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.versionAlgorithm = versionAlgorithm == null ? null : versionAlgorithm.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
        dst.status = status == null ? null : status.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        dst.date = date == null ? null : date.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactDetail>();
          for (ContactDetail i : contact)
            dst.contact.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        if (jurisdiction != null) {
          dst.jurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : jurisdiction)
            dst.jurisdiction.add(i.copy());
        };
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.copyrightLabel = copyrightLabel == null ? null : copyrightLabel.copy();
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        if (author != null) {
          dst.author = new ArrayList<ContactDetail>();
          for (ContactDetail i : author)
            dst.author.add(i.copy());
        };
        if (editor != null) {
          dst.editor = new ArrayList<ContactDetail>();
          for (ContactDetail i : editor)
            dst.editor.add(i.copy());
        };
        if (reviewer != null) {
          dst.reviewer = new ArrayList<ContactDetail>();
          for (ContactDetail i : reviewer)
            dst.reviewer.add(i.copy());
        };
        if (endorser != null) {
          dst.endorser = new ArrayList<ContactDetail>();
          for (ContactDetail i : endorser)
            dst.endorser.add(i.copy());
        };
        if (summary != null) {
          dst.summary = new ArrayList<CitationSummaryComponent>();
          for (CitationSummaryComponent i : summary)
            dst.summary.add(i.copy());
        };
        if (classification != null) {
          dst.classification = new ArrayList<CitationClassificationComponent>();
          for (CitationClassificationComponent i : classification)
            dst.classification.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (currentState != null) {
          dst.currentState = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : currentState)
            dst.currentState.add(i.copy());
        };
        if (statusDate != null) {
          dst.statusDate = new ArrayList<CitationStatusDateComponent>();
          for (CitationStatusDateComponent i : statusDate)
            dst.statusDate.add(i.copy());
        };
        if (relatedArtifact != null) {
          dst.relatedArtifact = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : relatedArtifact)
            dst.relatedArtifact.add(i.copy());
        };
        dst.citedArtifact = citedArtifact == null ? null : citedArtifact.copy();
      }

      protected Citation typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Citation))
          return false;
        Citation o = (Citation) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true)
           && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true) && compareDeep(copyrightLabel, o.copyrightLabel, true)
           && compareDeep(approvalDate, o.approvalDate, true) && compareDeep(lastReviewDate, o.lastReviewDate, true)
           && compareDeep(effectivePeriod, o.effectivePeriod, true) && compareDeep(author, o.author, true)
           && compareDeep(editor, o.editor, true) && compareDeep(reviewer, o.reviewer, true) && compareDeep(endorser, o.endorser, true)
           && compareDeep(summary, o.summary, true) && compareDeep(classification, o.classification, true)
           && compareDeep(note, o.note, true) && compareDeep(currentState, o.currentState, true) && compareDeep(statusDate, o.statusDate, true)
           && compareDeep(relatedArtifact, o.relatedArtifact, true) && compareDeep(citedArtifact, o.citedArtifact, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Citation))
          return false;
        Citation o = (Citation) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(copyrightLabel, o.copyrightLabel, true)
           && compareValues(approvalDate, o.approvalDate, true) && compareValues(lastReviewDate, o.lastReviewDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, status, experimental, date, publisher, contact
          , description, useContext, jurisdiction, purpose, copyright, copyrightLabel, approvalDate
          , lastReviewDate, effectivePeriod, author, editor, reviewer, endorser, summary
          , classification, note, currentState, statusDate, relatedArtifact, citedArtifact
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Citation;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition
* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition
* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [Library](library.html): A quantity- or range-valued use context assigned to the library
* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire
* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition\r\n* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition\r\n* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide\r\n* [Library](library.html): A quantity- or range-valued use context assigned to the library\r\n* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script\r\n* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set\r\n", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition
* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition
* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [Library](library.html): A quantity- or range-valued use context assigned to the library
* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire
* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition
* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition
* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [Library](library.html): A use context type and quantity- or range-based value assigned to the library
* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition\r\n* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition\r\n* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide\r\n* [Library](library.html): A use context type and quantity- or range-based value assigned to the library\r\n* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script\r\n* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition
* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition
* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [Library](library.html): A use context type and quantity- or range-based value assigned to the library
* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition
* [Citation](citation.html): A use context type and value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition
* [Evidence](evidence.html): A use context type and value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [Library](library.html): A use context type and value assigned to the library
* [Measure](measure.html): A use context type and value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and value assigned to the test script
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition\r\n* [Citation](citation.html): A use context type and value assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context type and value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition\r\n* [Evidence](evidence.html): A use context type and value assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide\r\n* [Library](library.html): A use context type and value assigned to the library\r\n* [Measure](measure.html): A use context type and value assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context type and value assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context type and value assigned to the test script\r\n* [ValueSet](valueset.html): A use context type and value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition
* [Citation](citation.html): A use context type and value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition
* [Evidence](evidence.html): A use context type and value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [Library](library.html): A use context type and value assigned to the library
* [Measure](measure.html): A use context type and value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and value assigned to the test script
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition
* [Citation](citation.html): A type of use context assigned to the citation
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition
* [Evidence](evidence.html): A type of use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [Library](library.html): A type of use context assigned to the library
* [Measure](measure.html): A type of use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire
* [Requirements](requirements.html): A type of use context assigned to the requirements
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [TestScript](testscript.html): A type of use context assigned to the test script
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition\r\n* [Citation](citation.html): A type of use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A type of use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition\r\n* [Evidence](evidence.html): A type of use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide\r\n* [Library](library.html): A type of use context assigned to the library\r\n* [Measure](measure.html): A type of use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A type of use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A type of use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A type of use context assigned to the test script\r\n* [ValueSet](valueset.html): A type of use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition
* [Citation](citation.html): A type of use context assigned to the citation
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition
* [Evidence](evidence.html): A type of use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [Library](library.html): A type of use context assigned to the library
* [Measure](measure.html): A type of use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire
* [Requirements](requirements.html): A type of use context assigned to the requirements
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [TestScript](testscript.html): A type of use context assigned to the test script
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition
* [Citation](citation.html): A use context assigned to the citation
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context assigned to the event definition
* [Evidence](evidence.html): A use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [Library](library.html): A use context assigned to the library
* [Measure](measure.html): A use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire
* [Requirements](requirements.html): A use context assigned to the requirements
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [TestScript](testscript.html): A use context assigned to the test script
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition\r\n* [Citation](citation.html): A use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context assigned to the event definition\r\n* [Evidence](evidence.html): A use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide\r\n* [Library](library.html): A use context assigned to the library\r\n* [Measure](measure.html): A use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context assigned to the test script\r\n* [ValueSet](valueset.html): A use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition
* [Citation](citation.html): A use context assigned to the citation
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context assigned to the event definition
* [Evidence](evidence.html): A use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [Library](library.html): A use context assigned to the library
* [Measure](measure.html): A use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire
* [Requirements](requirements.html): A use context assigned to the requirements
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [TestScript](testscript.html): A use context assigned to the test script
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The activity definition publication date
* [ActorDefinition](actordefinition.html): The Actor Definition publication date
* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date
* [Citation](citation.html): The citation publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [ConditionDefinition](conditiondefinition.html): The condition definition publication date
* [EventDefinition](eventdefinition.html): The event definition publication date
* [Evidence](evidence.html): The evidence publication date
* [EvidenceVariable](evidencevariable.html): The evidence variable publication date
* [ExampleScenario](examplescenario.html): The example scenario publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [Library](library.html): The library publication date
* [Measure](measure.html): The measure publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [PlanDefinition](plandefinition.html): The plan definition publication date
* [Questionnaire](questionnaire.html): The questionnaire publication date
* [Requirements](requirements.html): The requirements publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [SubscriptionTopic](subscriptiontopic.html): Date status first applied
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [TestScript](testscript.html): The test script publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The activity definition publication date\r\n* [ActorDefinition](actordefinition.html): The Actor Definition publication date\r\n* [CapabilityStatement](capabilitystatement.html): The capability statement publication date\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date\r\n* [Citation](citation.html): The citation publication date\r\n* [CodeSystem](codesystem.html): The code system publication date\r\n* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date\r\n* [ConceptMap](conceptmap.html): The concept map publication date\r\n* [ConditionDefinition](conditiondefinition.html): The condition definition publication date\r\n* [EventDefinition](eventdefinition.html): The event definition publication date\r\n* [Evidence](evidence.html): The evidence publication date\r\n* [EvidenceVariable](evidencevariable.html): The evidence variable publication date\r\n* [ExampleScenario](examplescenario.html): The example scenario publication date\r\n* [GraphDefinition](graphdefinition.html): The graph definition publication date\r\n* [ImplementationGuide](implementationguide.html): The implementation guide publication date\r\n* [Library](library.html): The library publication date\r\n* [Measure](measure.html): The measure publication date\r\n* [MessageDefinition](messagedefinition.html): The message definition publication date\r\n* [NamingSystem](namingsystem.html): The naming system publication date\r\n* [OperationDefinition](operationdefinition.html): The operation definition publication date\r\n* [PlanDefinition](plandefinition.html): The plan definition publication date\r\n* [Questionnaire](questionnaire.html): The questionnaire publication date\r\n* [Requirements](requirements.html): The requirements publication date\r\n* [SearchParameter](searchparameter.html): The search parameter publication date\r\n* [StructureDefinition](structuredefinition.html): The structure definition publication date\r\n* [StructureMap](structuremap.html): The structure map publication date\r\n* [SubscriptionTopic](subscriptiontopic.html): Date status first applied\r\n* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date\r\n* [TestScript](testscript.html): The test script publication date\r\n* [ValueSet](valueset.html): The value set publication date\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The activity definition publication date
* [ActorDefinition](actordefinition.html): The Actor Definition publication date
* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date
* [Citation](citation.html): The citation publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [ConditionDefinition](conditiondefinition.html): The condition definition publication date
* [EventDefinition](eventdefinition.html): The event definition publication date
* [Evidence](evidence.html): The evidence publication date
* [EvidenceVariable](evidencevariable.html): The evidence variable publication date
* [ExampleScenario](examplescenario.html): The example scenario publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [Library](library.html): The library publication date
* [Measure](measure.html): The measure publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [PlanDefinition](plandefinition.html): The plan definition publication date
* [Questionnaire](questionnaire.html): The questionnaire publication date
* [Requirements](requirements.html): The requirements publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [SubscriptionTopic](subscriptiontopic.html): Date status first applied
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [TestScript](testscript.html): The test script publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The description of the activity definition
* [ActorDefinition](actordefinition.html): The description of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition
* [Citation](citation.html): The description of the citation
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [ConditionDefinition](conditiondefinition.html): The description of the condition definition
* [EventDefinition](eventdefinition.html): The description of the event definition
* [Evidence](evidence.html): The description of the evidence
* [EvidenceVariable](evidencevariable.html): The description of the evidence variable
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [Library](library.html): The description of the library
* [Measure](measure.html): The description of the measure
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [PlanDefinition](plandefinition.html): The description of the plan definition
* [Questionnaire](questionnaire.html): The description of the questionnaire
* [Requirements](requirements.html): The description of the requirements
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [TestScript](testscript.html): The description of the test script
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The description of the activity definition\r\n* [ActorDefinition](actordefinition.html): The description of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The description of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition\r\n* [Citation](citation.html): The description of the citation\r\n* [CodeSystem](codesystem.html): The description of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition\r\n* [ConceptMap](conceptmap.html): The description of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The description of the condition definition\r\n* [EventDefinition](eventdefinition.html): The description of the event definition\r\n* [Evidence](evidence.html): The description of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The description of the evidence variable\r\n* [GraphDefinition](graphdefinition.html): The description of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The description of the implementation guide\r\n* [Library](library.html): The description of the library\r\n* [Measure](measure.html): The description of the measure\r\n* [MessageDefinition](messagedefinition.html): The description of the message definition\r\n* [NamingSystem](namingsystem.html): The description of the naming system\r\n* [OperationDefinition](operationdefinition.html): The description of the operation definition\r\n* [PlanDefinition](plandefinition.html): The description of the plan definition\r\n* [Questionnaire](questionnaire.html): The description of the questionnaire\r\n* [Requirements](requirements.html): The description of the requirements\r\n* [SearchParameter](searchparameter.html): The description of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The description of the structure definition\r\n* [StructureMap](structuremap.html): The description of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities\r\n* [TestScript](testscript.html): The description of the test script\r\n* [ValueSet](valueset.html): The description of the value set\r\n", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The description of the activity definition
* [ActorDefinition](actordefinition.html): The description of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition
* [Citation](citation.html): The description of the citation
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [ConditionDefinition](conditiondefinition.html): The description of the condition definition
* [EventDefinition](eventdefinition.html): The description of the event definition
* [Evidence](evidence.html): The description of the evidence
* [EvidenceVariable](evidencevariable.html): The description of the evidence variable
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [Library](library.html): The description of the library
* [Measure](measure.html): The description of the measure
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [PlanDefinition](plandefinition.html): The description of the plan definition
* [Questionnaire](questionnaire.html): The description of the questionnaire
* [Requirements](requirements.html): The description of the requirements
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [TestScript](testscript.html): The description of the test script
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition
* [Citation](citation.html): External identifier for the citation
* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition
* [EventDefinition](eventdefinition.html): External identifier for the event definition
* [Evidence](evidence.html): External identifier for the evidence
* [EvidenceReport](evidencereport.html): External identifier for the evidence report
* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable
* [ExampleScenario](examplescenario.html): External identifier for the example scenario
* [GraphDefinition](graphdefinition.html): External identifier for the graph definition
* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [OperationDefinition](operationdefinition.html): External identifier for the search parameter
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SearchParameter](searchparameter.html): External identifier for the search parameter
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestPlan](testplan.html): An identifier for the test plan
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition\r\n* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition\r\n* [Citation](citation.html): External identifier for the citation\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition\r\n* [EventDefinition](eventdefinition.html): External identifier for the event definition\r\n* [Evidence](evidence.html): External identifier for the evidence\r\n* [EvidenceReport](evidencereport.html): External identifier for the evidence report\r\n* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable\r\n* [ExampleScenario](examplescenario.html): External identifier for the example scenario\r\n* [GraphDefinition](graphdefinition.html): External identifier for the graph definition\r\n* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide\r\n* [Library](library.html): External identifier for the library\r\n* [Measure](measure.html): External identifier for the measure\r\n* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition\r\n* [OperationDefinition](operationdefinition.html): External identifier for the search parameter\r\n* [PlanDefinition](plandefinition.html): External identifier for the plan definition\r\n* [Questionnaire](questionnaire.html): External identifier for the questionnaire\r\n* [Requirements](requirements.html): External identifier for the requirements\r\n* [SearchParameter](searchparameter.html): External identifier for the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [TestPlan](testplan.html): An identifier for the test plan\r\n* [TestScript](testscript.html): External identifier for the test script\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition
* [Citation](citation.html): External identifier for the citation
* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition
* [EventDefinition](eventdefinition.html): External identifier for the event definition
* [Evidence](evidence.html): External identifier for the evidence
* [EvidenceReport](evidencereport.html): External identifier for the evidence report
* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable
* [ExampleScenario](examplescenario.html): External identifier for the example scenario
* [GraphDefinition](graphdefinition.html): External identifier for the graph definition
* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [OperationDefinition](operationdefinition.html): External identifier for the search parameter
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SearchParameter](searchparameter.html): External identifier for the search parameter
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestPlan](testplan.html): An identifier for the test plan
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition
* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition
* [Citation](citation.html): Intended jurisdiction for the citation
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition
* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition
* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [Library](library.html): Intended jurisdiction for the library
* [Measure](measure.html): Intended jurisdiction for the measure
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition
* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire
* [Requirements](requirements.html): Intended jurisdiction for the requirements
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [TestScript](testscript.html): Intended jurisdiction for the test script
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name="jurisdiction", path="ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition\r\n* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition\r\n* [Citation](citation.html): Intended jurisdiction for the citation\r\n* [CodeSystem](codesystem.html): Intended jurisdiction for the code system\r\n* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition\r\n* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition\r\n* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario\r\n* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition\r\n* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide\r\n* [Library](library.html): Intended jurisdiction for the library\r\n* [Measure](measure.html): Intended jurisdiction for the measure\r\n* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition\r\n* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system\r\n* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition\r\n* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition\r\n* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire\r\n* [Requirements](requirements.html): Intended jurisdiction for the requirements\r\n* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter\r\n* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition\r\n* [StructureMap](structuremap.html): Intended jurisdiction for the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities\r\n* [TestScript](testscript.html): Intended jurisdiction for the test script\r\n* [ValueSet](valueset.html): Intended jurisdiction for the value set\r\n", type="token" )
  public static final String SP_JURISDICTION = "jurisdiction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition
* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition
* [Citation](citation.html): Intended jurisdiction for the citation
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition
* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition
* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [Library](library.html): Intended jurisdiction for the library
* [Measure](measure.html): Intended jurisdiction for the measure
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition
* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire
* [Requirements](requirements.html): Intended jurisdiction for the requirements
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [TestScript](testscript.html): Intended jurisdiction for the test script
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_JURISDICTION);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition
* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [Citation](citation.html): Computationally friendly name of the citation
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition
* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition
* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable
* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [Library](library.html): Computationally friendly name of the library
* [Measure](measure.html): Computationally friendly name of the measure
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition
* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire
* [Requirements](requirements.html): Computationally friendly name of the requirements
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [TestScript](testscript.html): Computationally friendly name of the test script
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition\r\n* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement\r\n* [Citation](citation.html): Computationally friendly name of the citation\r\n* [CodeSystem](codesystem.html): Computationally friendly name of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition\r\n* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition\r\n* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition\r\n* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable\r\n* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario\r\n* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide\r\n* [Library](library.html): Computationally friendly name of the library\r\n* [Measure](measure.html): Computationally friendly name of the measure\r\n* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition\r\n* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system\r\n* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition\r\n* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition\r\n* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire\r\n* [Requirements](requirements.html): Computationally friendly name of the requirements\r\n* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition\r\n* [StructureMap](structuremap.html): Computationally friendly name of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities\r\n* [TestScript](testscript.html): Computationally friendly name of the test script\r\n* [ValueSet](valueset.html): Computationally friendly name of the value set\r\n", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition
* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [Citation](citation.html): Computationally friendly name of the citation
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition
* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition
* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable
* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [Library](library.html): Computationally friendly name of the library
* [Measure](measure.html): Computationally friendly name of the measure
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition
* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire
* [Requirements](requirements.html): Computationally friendly name of the requirements
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [TestScript](testscript.html): Computationally friendly name of the test script
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition
* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition
* [Citation](citation.html): Name of the publisher of the citation
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition
* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition
* [Evidence](evidence.html): Name of the publisher of the evidence
* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report
* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable
* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [Library](library.html): Name of the publisher of the library
* [Measure](measure.html): Name of the publisher of the measure
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition
* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire
* [Requirements](requirements.html): Name of the publisher of the requirements
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [TestScript](testscript.html): Name of the publisher of the test script
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition\r\n* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition\r\n* [Citation](citation.html): Name of the publisher of the citation\r\n* [CodeSystem](codesystem.html): Name of the publisher of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition\r\n* [ConceptMap](conceptmap.html): Name of the publisher of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition\r\n* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition\r\n* [Evidence](evidence.html): Name of the publisher of the evidence\r\n* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable\r\n* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario\r\n* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide\r\n* [Library](library.html): Name of the publisher of the library\r\n* [Measure](measure.html): Name of the publisher of the measure\r\n* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition\r\n* [NamingSystem](namingsystem.html): Name of the publisher of the naming system\r\n* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition\r\n* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition\r\n* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire\r\n* [Requirements](requirements.html): Name of the publisher of the requirements\r\n* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition\r\n* [StructureMap](structuremap.html): Name of the publisher of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities\r\n* [TestScript](testscript.html): Name of the publisher of the test script\r\n* [ValueSet](valueset.html): Name of the publisher of the value set\r\n", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition
* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition
* [Citation](citation.html): Name of the publisher of the citation
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition
* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition
* [Evidence](evidence.html): Name of the publisher of the evidence
* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report
* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable
* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [Library](library.html): Name of the publisher of the library
* [Measure](measure.html): Name of the publisher of the measure
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition
* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire
* [Requirements](requirements.html): Name of the publisher of the requirements
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [TestScript](testscript.html): Name of the publisher of the test script
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The current status of the activity definition
* [ActorDefinition](actordefinition.html): The current status of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition
* [Citation](citation.html): The current status of the citation
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition
* [EventDefinition](eventdefinition.html): The current status of the event definition
* [Evidence](evidence.html): The current status of the evidence
* [EvidenceReport](evidencereport.html): The current status of the evidence report
* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable
* [ExampleScenario](examplescenario.html): The current status of the example scenario
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [Library](library.html): The current status of the library
* [Measure](measure.html): The current status of the measure
* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [PlanDefinition](plandefinition.html): The current status of the plan definition
* [Questionnaire](questionnaire.html): The current status of the questionnaire
* [Requirements](requirements.html): The current status of the requirements
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [TestPlan](testplan.html): The current status of the test plan
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The current status of the activity definition\r\n* [ActorDefinition](actordefinition.html): The current status of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition\r\n* [Citation](citation.html): The current status of the citation\r\n* [CodeSystem](codesystem.html): The current status of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition\r\n* [ConceptMap](conceptmap.html): The current status of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition\r\n* [EventDefinition](eventdefinition.html): The current status of the event definition\r\n* [Evidence](evidence.html): The current status of the evidence\r\n* [EvidenceReport](evidencereport.html): The current status of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The current status of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The current status of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The current status of the implementation guide\r\n* [Library](library.html): The current status of the library\r\n* [Measure](measure.html): The current status of the measure\r\n* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error\r\n* [MessageDefinition](messagedefinition.html): The current status of the message definition\r\n* [NamingSystem](namingsystem.html): The current status of the naming system\r\n* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown\r\n* [OperationDefinition](operationdefinition.html): The current status of the operation definition\r\n* [PlanDefinition](plandefinition.html): The current status of the plan definition\r\n* [Questionnaire](questionnaire.html): The current status of the questionnaire\r\n* [Requirements](requirements.html): The current status of the requirements\r\n* [SearchParameter](searchparameter.html): The current status of the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown\r\n* [StructureDefinition](structuredefinition.html): The current status of the structure definition\r\n* [StructureMap](structuremap.html): The current status of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown\r\n* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities\r\n* [TestPlan](testplan.html): The current status of the test plan\r\n* [TestScript](testscript.html): The current status of the test script\r\n* [ValueSet](valueset.html): The current status of the value set\r\n", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The current status of the activity definition
* [ActorDefinition](actordefinition.html): The current status of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition
* [Citation](citation.html): The current status of the citation
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition
* [EventDefinition](eventdefinition.html): The current status of the event definition
* [Evidence](evidence.html): The current status of the evidence
* [EvidenceReport](evidencereport.html): The current status of the evidence report
* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable
* [ExampleScenario](examplescenario.html): The current status of the example scenario
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [Library](library.html): The current status of the library
* [Measure](measure.html): The current status of the measure
* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [PlanDefinition](plandefinition.html): The current status of the plan definition
* [Questionnaire](questionnaire.html): The current status of the questionnaire
* [Requirements](requirements.html): The current status of the requirements
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [TestPlan](testplan.html): The current status of the test plan
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition
* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition
* [Citation](citation.html): The human-friendly name of the citation
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition
* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition
* [Evidence](evidence.html): The human-friendly name of the evidence
* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [Library](library.html): The human-friendly name of the library
* [Measure](measure.html): The human-friendly name of the measure
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition
* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire
* [Requirements](requirements.html): The human-friendly name of the requirements
* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [TestScript](testscript.html): The human-friendly name of the test script
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition\r\n* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition\r\n* [Citation](citation.html): The human-friendly name of the citation\r\n* [CodeSystem](codesystem.html): The human-friendly name of the code system\r\n* [ConceptMap](conceptmap.html): The human-friendly name of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition\r\n* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition\r\n* [Evidence](evidence.html): The human-friendly name of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable\r\n* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide\r\n* [Library](library.html): The human-friendly name of the library\r\n* [Measure](measure.html): The human-friendly name of the measure\r\n* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition\r\n* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition\r\n* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition\r\n* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition\r\n* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire\r\n* [Requirements](requirements.html): The human-friendly name of the requirements\r\n* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition\r\n* [StructureMap](structuremap.html): The human-friendly name of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities\r\n* [TestScript](testscript.html): The human-friendly name of the test script\r\n* [ValueSet](valueset.html): The human-friendly name of the value set\r\n", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition
* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition
* [Citation](citation.html): The human-friendly name of the citation
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition
* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition
* [Evidence](evidence.html): The human-friendly name of the evidence
* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [Library](library.html): The human-friendly name of the library
* [Measure](measure.html): The human-friendly name of the measure
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition
* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire
* [Requirements](requirements.html): The human-friendly name of the requirements
* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [TestScript](testscript.html): The human-friendly name of the test script
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition
* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition
* [Citation](citation.html): The uri that identifies the citation
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition
* [EventDefinition](eventdefinition.html): The uri that identifies the event definition
* [Evidence](evidence.html): The uri that identifies the evidence
* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report
* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable
* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [Library](library.html): The uri that identifies the library
* [Measure](measure.html): The uri that identifies the measure
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition
* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire
* [Requirements](requirements.html): The uri that identifies the requirements
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [TestPlan](testplan.html): The uri that identifies the test plan
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition\r\n* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition\r\n* [Citation](citation.html): The uri that identifies the citation\r\n* [CodeSystem](codesystem.html): The uri that identifies the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition\r\n* [ConceptMap](conceptmap.html): The URI that identifies the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition\r\n* [EventDefinition](eventdefinition.html): The uri that identifies the event definition\r\n* [Evidence](evidence.html): The uri that identifies the evidence\r\n* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable\r\n* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario\r\n* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition\r\n* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide\r\n* [Library](library.html): The uri that identifies the library\r\n* [Measure](measure.html): The uri that identifies the measure\r\n* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition\r\n* [NamingSystem](namingsystem.html): The uri that identifies the naming system\r\n* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition\r\n* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition\r\n* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition\r\n* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire\r\n* [Requirements](requirements.html): The uri that identifies the requirements\r\n* [SearchParameter](searchparameter.html): The uri that identifies the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition\r\n* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition\r\n* [StructureMap](structuremap.html): The uri that identifies the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities\r\n* [TestPlan](testplan.html): The uri that identifies the test plan\r\n* [TestScript](testscript.html): The uri that identifies the test script\r\n* [ValueSet](valueset.html): The uri that identifies the value set\r\n", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition
* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition
* [Citation](citation.html): The uri that identifies the citation
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition
* [EventDefinition](eventdefinition.html): The uri that identifies the event definition
* [Evidence](evidence.html): The uri that identifies the evidence
* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report
* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable
* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [Library](library.html): The uri that identifies the library
* [Measure](measure.html): The uri that identifies the measure
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition
* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire
* [Requirements](requirements.html): The uri that identifies the requirements
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [TestPlan](testplan.html): The uri that identifies the test plan
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The business version of the activity definition
* [ActorDefinition](actordefinition.html): The business version of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition
* [Citation](citation.html): The business version of the citation
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition
* [EventDefinition](eventdefinition.html): The business version of the event definition
* [Evidence](evidence.html): The business version of the evidence
* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable
* [ExampleScenario](examplescenario.html): The business version of the example scenario
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [Library](library.html): The business version of the library
* [Measure](measure.html): The business version of the measure
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [PlanDefinition](plandefinition.html): The business version of the plan definition
* [Questionnaire](questionnaire.html): The business version of the questionnaire
* [Requirements](requirements.html): The business version of the requirements
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [TestScript](testscript.html): The business version of the test script
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The business version of the activity definition\r\n* [ActorDefinition](actordefinition.html): The business version of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition\r\n* [Citation](citation.html): The business version of the citation\r\n* [CodeSystem](codesystem.html): The business version of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition\r\n* [ConceptMap](conceptmap.html): The business version of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition\r\n* [EventDefinition](eventdefinition.html): The business version of the event definition\r\n* [Evidence](evidence.html): The business version of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The business version of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The business version of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The business version of the implementation guide\r\n* [Library](library.html): The business version of the library\r\n* [Measure](measure.html): The business version of the measure\r\n* [MessageDefinition](messagedefinition.html): The business version of the message definition\r\n* [NamingSystem](namingsystem.html): The business version of the naming system\r\n* [OperationDefinition](operationdefinition.html): The business version of the operation definition\r\n* [PlanDefinition](plandefinition.html): The business version of the plan definition\r\n* [Questionnaire](questionnaire.html): The business version of the questionnaire\r\n* [Requirements](requirements.html): The business version of the requirements\r\n* [SearchParameter](searchparameter.html): The business version of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The business version of the structure definition\r\n* [StructureMap](structuremap.html): The business version of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities\r\n* [TestScript](testscript.html): The business version of the test script\r\n* [ValueSet](valueset.html): The business version of the value set\r\n", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The business version of the activity definition
* [ActorDefinition](actordefinition.html): The business version of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition
* [Citation](citation.html): The business version of the citation
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition
* [EventDefinition](eventdefinition.html): The business version of the event definition
* [Evidence](evidence.html): The business version of the evidence
* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable
* [ExampleScenario](examplescenario.html): The business version of the example scenario
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [Library](library.html): The business version of the library
* [Measure](measure.html): The business version of the measure
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [PlanDefinition](plandefinition.html): The business version of the plan definition
* [Questionnaire](questionnaire.html): The business version of the questionnaire
* [Requirements](requirements.html): The business version of the requirements
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [TestScript](testscript.html): The business version of the test script
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);

 /**
   * Search parameter: <b>classification-type</b>
   * <p>
   * Description: <b>A type of classification assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Citation.classification.type)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="classification-type", path="(Citation.classification.type)", description="A type of classification assigned to the citation", type="token" )
  public static final String SP_CLASSIFICATION_TYPE = "classification-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>classification-type</b>
   * <p>
   * Description: <b>A type of classification assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Citation.classification.type)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CLASSIFICATION_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CLASSIFICATION_TYPE);

 /**
   * Search parameter: <b>classification</b>
   * <p>
   * Description: <b>A classification type and value assigned to the citation</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Citation.classification</b><br>
   * </p>
   */
  @SearchParamDefinition(name="classification", path="Citation.classification", description="A classification type and value assigned to the citation", type="composite", compositeOf={"classification-type", "classifier"} )
  public static final String SP_CLASSIFICATION = "classification";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>classification</b>
   * <p>
   * Description: <b>A classification type and value assigned to the citation</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Citation.classification</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CLASSIFICATION = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CLASSIFICATION);

 /**
   * Search parameter: <b>classifier</b>
   * <p>
   * Description: <b>A classifier assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Citation.classification.classifier)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="classifier", path="(Citation.classification.classifier)", description="A classifier assigned to the citation", type="token" )
  public static final String SP_CLASSIFIER = "classifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>classifier</b>
   * <p>
   * Description: <b>A classifier assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Citation.classification.classifier)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CLASSIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CLASSIFIER);

 /**
   * Search parameter: <b>effective</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use
* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use
* [Citation](citation.html): The time during which the citation is intended to be in use
* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use
* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use
* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use
* [Library](library.html): The time during which the library is intended to be in use
* [Measure](measure.html): The time during which the measure is intended to be in use
* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use
* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use
* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use
* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod</b><br>
   * </p>
   */
  @SearchParamDefinition(name="effective", path="ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use\r\n* [Citation](citation.html): The time during which the citation is intended to be in use\r\n* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use\r\n* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use\r\n* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use\r\n* [Library](library.html): The time during which the library is intended to be in use\r\n* [Measure](measure.html): The time during which the measure is intended to be in use\r\n* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use\r\n* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use\r\n* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use\r\n* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use\r\n", type="date" )
  public static final String SP_EFFECTIVE = "effective";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>effective</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use
* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use
* [Citation](citation.html): The time during which the citation is intended to be in use
* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use
* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use
* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use
* [Library](library.html): The time during which the library is intended to be in use
* [Measure](measure.html): The time during which the measure is intended to be in use
* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use
* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use
* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use
* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EFFECTIVE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EFFECTIVE);


}


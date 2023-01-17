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

// Generated on Tue, Dec 13, 2022 17:53+1100 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * RelatedArtifact Type: Related artifacts such as additional documentation, justification, or bibliographic references.
 */
@DatatypeDef(name="RelatedArtifact")
public class RelatedArtifact extends DataType implements ICompositeType {

    public enum RelatedArtifactType {
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
         * added to help the parsers with the generic types
         */
        NULL;
        public static RelatedArtifactType fromCode(String codeString) throws FHIRException {
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
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown RelatedArtifactType code '"+codeString+"'");
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
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class RelatedArtifactTypeEnumFactory implements EnumFactory<RelatedArtifactType> {
    public RelatedArtifactType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("documentation".equals(codeString))
          return RelatedArtifactType.DOCUMENTATION;
        if ("justification".equals(codeString))
          return RelatedArtifactType.JUSTIFICATION;
        if ("citation".equals(codeString))
          return RelatedArtifactType.CITATION;
        if ("predecessor".equals(codeString))
          return RelatedArtifactType.PREDECESSOR;
        if ("successor".equals(codeString))
          return RelatedArtifactType.SUCCESSOR;
        if ("derived-from".equals(codeString))
          return RelatedArtifactType.DERIVEDFROM;
        if ("depends-on".equals(codeString))
          return RelatedArtifactType.DEPENDSON;
        if ("composed-of".equals(codeString))
          return RelatedArtifactType.COMPOSEDOF;
        if ("part-of".equals(codeString))
          return RelatedArtifactType.PARTOF;
        if ("amends".equals(codeString))
          return RelatedArtifactType.AMENDS;
        if ("amended-with".equals(codeString))
          return RelatedArtifactType.AMENDEDWITH;
        if ("appends".equals(codeString))
          return RelatedArtifactType.APPENDS;
        if ("appended-with".equals(codeString))
          return RelatedArtifactType.APPENDEDWITH;
        if ("cites".equals(codeString))
          return RelatedArtifactType.CITES;
        if ("cited-by".equals(codeString))
          return RelatedArtifactType.CITEDBY;
        if ("comments-on".equals(codeString))
          return RelatedArtifactType.COMMENTSON;
        if ("comment-in".equals(codeString))
          return RelatedArtifactType.COMMENTIN;
        if ("contains".equals(codeString))
          return RelatedArtifactType.CONTAINS;
        if ("contained-in".equals(codeString))
          return RelatedArtifactType.CONTAINEDIN;
        if ("corrects".equals(codeString))
          return RelatedArtifactType.CORRECTS;
        if ("correction-in".equals(codeString))
          return RelatedArtifactType.CORRECTIONIN;
        if ("replaces".equals(codeString))
          return RelatedArtifactType.REPLACES;
        if ("replaced-with".equals(codeString))
          return RelatedArtifactType.REPLACEDWITH;
        if ("retracts".equals(codeString))
          return RelatedArtifactType.RETRACTS;
        if ("retracted-by".equals(codeString))
          return RelatedArtifactType.RETRACTEDBY;
        if ("signs".equals(codeString))
          return RelatedArtifactType.SIGNS;
        if ("similar-to".equals(codeString))
          return RelatedArtifactType.SIMILARTO;
        if ("supports".equals(codeString))
          return RelatedArtifactType.SUPPORTS;
        if ("supported-with".equals(codeString))
          return RelatedArtifactType.SUPPORTEDWITH;
        if ("transforms".equals(codeString))
          return RelatedArtifactType.TRANSFORMS;
        if ("transformed-into".equals(codeString))
          return RelatedArtifactType.TRANSFORMEDINTO;
        if ("transformed-with".equals(codeString))
          return RelatedArtifactType.TRANSFORMEDWITH;
        if ("documents".equals(codeString))
          return RelatedArtifactType.DOCUMENTS;
        if ("specification-of".equals(codeString))
          return RelatedArtifactType.SPECIFICATIONOF;
        if ("created-with".equals(codeString))
          return RelatedArtifactType.CREATEDWITH;
        if ("cite-as".equals(codeString))
          return RelatedArtifactType.CITEAS;
        throw new IllegalArgumentException("Unknown RelatedArtifactType code '"+codeString+"'");
        }
        public Enumeration<RelatedArtifactType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.NULL, code);
        if ("documentation".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.DOCUMENTATION, code);
        if ("justification".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.JUSTIFICATION, code);
        if ("citation".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.CITATION, code);
        if ("predecessor".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.PREDECESSOR, code);
        if ("successor".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.SUCCESSOR, code);
        if ("derived-from".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.DERIVEDFROM, code);
        if ("depends-on".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.DEPENDSON, code);
        if ("composed-of".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.COMPOSEDOF, code);
        if ("part-of".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.PARTOF, code);
        if ("amends".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.AMENDS, code);
        if ("amended-with".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.AMENDEDWITH, code);
        if ("appends".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.APPENDS, code);
        if ("appended-with".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.APPENDEDWITH, code);
        if ("cites".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.CITES, code);
        if ("cited-by".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.CITEDBY, code);
        if ("comments-on".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.COMMENTSON, code);
        if ("comment-in".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.COMMENTIN, code);
        if ("contains".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.CONTAINS, code);
        if ("contained-in".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.CONTAINEDIN, code);
        if ("corrects".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.CORRECTS, code);
        if ("correction-in".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.CORRECTIONIN, code);
        if ("replaces".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.REPLACES, code);
        if ("replaced-with".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.REPLACEDWITH, code);
        if ("retracts".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.RETRACTS, code);
        if ("retracted-by".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.RETRACTEDBY, code);
        if ("signs".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.SIGNS, code);
        if ("similar-to".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.SIMILARTO, code);
        if ("supports".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.SUPPORTS, code);
        if ("supported-with".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.SUPPORTEDWITH, code);
        if ("transforms".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.TRANSFORMS, code);
        if ("transformed-into".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.TRANSFORMEDINTO, code);
        if ("transformed-with".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.TRANSFORMEDWITH, code);
        if ("documents".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.DOCUMENTS, code);
        if ("specification-of".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.SPECIFICATIONOF, code);
        if ("created-with".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.CREATEDWITH, code);
        if ("cite-as".equals(codeString))
          return new Enumeration<RelatedArtifactType>(this, RelatedArtifactType.CITEAS, code);
        throw new FHIRException("Unknown RelatedArtifactType code '"+codeString+"'");
        }
    public String toCode(RelatedArtifactType code) {
      if (code == RelatedArtifactType.DOCUMENTATION)
        return "documentation";
      if (code == RelatedArtifactType.JUSTIFICATION)
        return "justification";
      if (code == RelatedArtifactType.CITATION)
        return "citation";
      if (code == RelatedArtifactType.PREDECESSOR)
        return "predecessor";
      if (code == RelatedArtifactType.SUCCESSOR)
        return "successor";
      if (code == RelatedArtifactType.DERIVEDFROM)
        return "derived-from";
      if (code == RelatedArtifactType.DEPENDSON)
        return "depends-on";
      if (code == RelatedArtifactType.COMPOSEDOF)
        return "composed-of";
      if (code == RelatedArtifactType.PARTOF)
        return "part-of";
      if (code == RelatedArtifactType.AMENDS)
        return "amends";
      if (code == RelatedArtifactType.AMENDEDWITH)
        return "amended-with";
      if (code == RelatedArtifactType.APPENDS)
        return "appends";
      if (code == RelatedArtifactType.APPENDEDWITH)
        return "appended-with";
      if (code == RelatedArtifactType.CITES)
        return "cites";
      if (code == RelatedArtifactType.CITEDBY)
        return "cited-by";
      if (code == RelatedArtifactType.COMMENTSON)
        return "comments-on";
      if (code == RelatedArtifactType.COMMENTIN)
        return "comment-in";
      if (code == RelatedArtifactType.CONTAINS)
        return "contains";
      if (code == RelatedArtifactType.CONTAINEDIN)
        return "contained-in";
      if (code == RelatedArtifactType.CORRECTS)
        return "corrects";
      if (code == RelatedArtifactType.CORRECTIONIN)
        return "correction-in";
      if (code == RelatedArtifactType.REPLACES)
        return "replaces";
      if (code == RelatedArtifactType.REPLACEDWITH)
        return "replaced-with";
      if (code == RelatedArtifactType.RETRACTS)
        return "retracts";
      if (code == RelatedArtifactType.RETRACTEDBY)
        return "retracted-by";
      if (code == RelatedArtifactType.SIGNS)
        return "signs";
      if (code == RelatedArtifactType.SIMILARTO)
        return "similar-to";
      if (code == RelatedArtifactType.SUPPORTS)
        return "supports";
      if (code == RelatedArtifactType.SUPPORTEDWITH)
        return "supported-with";
      if (code == RelatedArtifactType.TRANSFORMS)
        return "transforms";
      if (code == RelatedArtifactType.TRANSFORMEDINTO)
        return "transformed-into";
      if (code == RelatedArtifactType.TRANSFORMEDWITH)
        return "transformed-with";
      if (code == RelatedArtifactType.DOCUMENTS)
        return "documents";
      if (code == RelatedArtifactType.SPECIFICATIONOF)
        return "specification-of";
      if (code == RelatedArtifactType.CREATEDWITH)
        return "created-with";
      if (code == RelatedArtifactType.CITEAS)
        return "cite-as";
      return "?";
      }
    public String toSystem(RelatedArtifactType code) {
      return code.getSystem();
      }
    }

    /**
     * The type of relationship to the related artifact.
     */
    @Child(name = "type", type = {CodeType.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="documentation | justification | citation | predecessor | successor | derived-from | depends-on | composed-of | part-of | amends | amended-with | appends | appended-with | cites | cited-by | comments-on | comment-in | contains | contained-in | corrects | correction-in | replaces | replaced-with | retracts | retracted-by | signs | similar-to | supports | supported-with | transforms | transformed-into | transformed-with | documents | specification-of | created-with | cite-as", formalDefinition="The type of relationship to the related artifact." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/related-artifact-type")
    protected Enumeration<RelatedArtifactType> type;

    /**
     * Provides additional classifiers of the related artifact.
     */
    @Child(name = "classifier", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional classifiers", formalDefinition="Provides additional classifiers of the related artifact." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-artifact-classifier")
    protected List<CodeableConcept> classifier;

    /**
     * A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.
     */
    @Child(name = "label", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Short label", formalDefinition="A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index." )
    protected StringType label;

    /**
     * A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.
     */
    @Child(name = "display", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Brief description of the related artifact", formalDefinition="A brief description of the document or knowledge resource being referenced, suitable for display to a consumer." )
    protected StringType display;

    /**
     * A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.
     */
    @Child(name = "citation", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Bibliographic citation for the artifact", formalDefinition="A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format." )
    protected MarkdownType citation;

    /**
     * The document being referenced, represented as an attachment. This is exclusive with the resource element.
     */
    @Child(name = "document", type = {Attachment.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What document is being referenced", formalDefinition="The document being referenced, represented as an attachment. This is exclusive with the resource element." )
    protected Attachment document;

    /**
     * The related artifact, such as a library, value set, profile, or other knowledge resource.
     */
    @Child(name = "resource", type = {CanonicalType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What artifact is being referenced", formalDefinition="The related artifact, such as a library, value set, profile, or other knowledge resource." )
    protected CanonicalType resource;

    /**
     * The related artifact, if the artifact is not a canonical resource, or a resource reference to a canonical resource.
     */
    @Child(name = "resourceReference", type = {Reference.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What artifact, if not a conformance resource", formalDefinition="The related artifact, if the artifact is not a canonical resource, or a resource reference to a canonical resource." )
    protected Reference resourceReference;

    /**
     * The publication status of the artifact being referred to.
     */
    @Child(name = "publicationStatus", type = {CodeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The publication status of the artifact being referred to." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> publicationStatus;

    /**
     * The date of publication of the artifact being referred to.
     */
    @Child(name = "publicationDate", type = {DateType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date of publication of the artifact being referred to", formalDefinition="The date of publication of the artifact being referred to." )
    protected DateType publicationDate;

    private static final long serialVersionUID = 556640693L;

  /**
   * Constructor
   */
    public RelatedArtifact() {
      super();
    }

  /**
   * Constructor
   */
    public RelatedArtifact(RelatedArtifactType type) {
      super();
      this.setType(type);
    }

    /**
     * @return {@link #type} (The type of relationship to the related artifact.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<RelatedArtifactType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<RelatedArtifactType>(new RelatedArtifactTypeEnumFactory()); // bb
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
    public RelatedArtifact setTypeElement(Enumeration<RelatedArtifactType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return The type of relationship to the related artifact.
     */
    public RelatedArtifactType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value The type of relationship to the related artifact.
     */
    public RelatedArtifact setType(RelatedArtifactType value) { 
        if (this.type == null)
          this.type = new Enumeration<RelatedArtifactType>(new RelatedArtifactTypeEnumFactory());
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
    public RelatedArtifact setClassifier(List<CodeableConcept> theClassifier) { 
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

    public RelatedArtifact addClassifier(CodeableConcept t) { //3
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
     * @return {@link #label} (A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
     */
    public StringType getLabelElement() { 
      if (this.label == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.label");
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
     * @param value {@link #label} (A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
     */
    public RelatedArtifact setLabelElement(StringType value) { 
      this.label = value;
      return this;
    }

    /**
     * @return A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.
     */
    public String getLabel() { 
      return this.label == null ? null : this.label.getValue();
    }

    /**
     * @param value A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.
     */
    public RelatedArtifact setLabel(String value) { 
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
          throw new Error("Attempt to auto-create RelatedArtifact.display");
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
    public RelatedArtifact setDisplayElement(StringType value) { 
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
    public RelatedArtifact setDisplay(String value) { 
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
          throw new Error("Attempt to auto-create RelatedArtifact.citation");
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
    public RelatedArtifact setCitationElement(MarkdownType value) { 
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
    public RelatedArtifact setCitation(String value) { 
      if (value == null)
        this.citation = null;
      else {
        if (this.citation == null)
          this.citation = new MarkdownType();
        this.citation.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #document} (The document being referenced, represented as an attachment. This is exclusive with the resource element.)
     */
    public Attachment getDocument() { 
      if (this.document == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.document");
        else if (Configuration.doAutoCreate())
          this.document = new Attachment(); // cc
      return this.document;
    }

    public boolean hasDocument() { 
      return this.document != null && !this.document.isEmpty();
    }

    /**
     * @param value {@link #document} (The document being referenced, represented as an attachment. This is exclusive with the resource element.)
     */
    public RelatedArtifact setDocument(Attachment value) { 
      this.document = value;
      return this;
    }

    /**
     * @return {@link #resource} (The related artifact, such as a library, value set, profile, or other knowledge resource.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
     */
    public CanonicalType getResourceElement() { 
      if (this.resource == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.resource");
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
    public RelatedArtifact setResourceElement(CanonicalType value) { 
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
    public RelatedArtifact setResource(String value) { 
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
          throw new Error("Attempt to auto-create RelatedArtifact.resourceReference");
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
    public RelatedArtifact setResourceReference(Reference value) { 
      this.resourceReference = value;
      return this;
    }

    /**
     * @return {@link #publicationStatus} (The publication status of the artifact being referred to.). This is the underlying object with id, value and extensions. The accessor "getPublicationStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getPublicationStatusElement() { 
      if (this.publicationStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.publicationStatus");
        else if (Configuration.doAutoCreate())
          this.publicationStatus = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
      return this.publicationStatus;
    }

    public boolean hasPublicationStatusElement() { 
      return this.publicationStatus != null && !this.publicationStatus.isEmpty();
    }

    public boolean hasPublicationStatus() { 
      return this.publicationStatus != null && !this.publicationStatus.isEmpty();
    }

    /**
     * @param value {@link #publicationStatus} (The publication status of the artifact being referred to.). This is the underlying object with id, value and extensions. The accessor "getPublicationStatus" gives direct access to the value
     */
    public RelatedArtifact setPublicationStatusElement(Enumeration<PublicationStatus> value) { 
      this.publicationStatus = value;
      return this;
    }

    /**
     * @return The publication status of the artifact being referred to.
     */
    public PublicationStatus getPublicationStatus() { 
      return this.publicationStatus == null ? null : this.publicationStatus.getValue();
    }

    /**
     * @param value The publication status of the artifact being referred to.
     */
    public RelatedArtifact setPublicationStatus(PublicationStatus value) { 
      if (value == null)
        this.publicationStatus = null;
      else {
        if (this.publicationStatus == null)
          this.publicationStatus = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.publicationStatus.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #publicationDate} (The date of publication of the artifact being referred to.). This is the underlying object with id, value and extensions. The accessor "getPublicationDate" gives direct access to the value
     */
    public DateType getPublicationDateElement() { 
      if (this.publicationDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RelatedArtifact.publicationDate");
        else if (Configuration.doAutoCreate())
          this.publicationDate = new DateType(); // bb
      return this.publicationDate;
    }

    public boolean hasPublicationDateElement() { 
      return this.publicationDate != null && !this.publicationDate.isEmpty();
    }

    public boolean hasPublicationDate() { 
      return this.publicationDate != null && !this.publicationDate.isEmpty();
    }

    /**
     * @param value {@link #publicationDate} (The date of publication of the artifact being referred to.). This is the underlying object with id, value and extensions. The accessor "getPublicationDate" gives direct access to the value
     */
    public RelatedArtifact setPublicationDateElement(DateType value) { 
      this.publicationDate = value;
      return this;
    }

    /**
     * @return The date of publication of the artifact being referred to.
     */
    public Date getPublicationDate() { 
      return this.publicationDate == null ? null : this.publicationDate.getValue();
    }

    /**
     * @param value The date of publication of the artifact being referred to.
     */
    public RelatedArtifact setPublicationDate(Date value) { 
      if (value == null)
        this.publicationDate = null;
      else {
        if (this.publicationDate == null)
          this.publicationDate = new DateType();
        this.publicationDate.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("type", "code", "The type of relationship to the related artifact.", 0, 1, type));
        children.add(new Property("classifier", "CodeableConcept", "Provides additional classifiers of the related artifact.", 0, java.lang.Integer.MAX_VALUE, classifier));
        children.add(new Property("label", "string", "A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.", 0, 1, label));
        children.add(new Property("display", "string", "A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.", 0, 1, display));
        children.add(new Property("citation", "markdown", "A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.", 0, 1, citation));
        children.add(new Property("document", "Attachment", "The document being referenced, represented as an attachment. This is exclusive with the resource element.", 0, 1, document));
        children.add(new Property("resource", "canonical(Any)", "The related artifact, such as a library, value set, profile, or other knowledge resource.", 0, 1, resource));
        children.add(new Property("resourceReference", "Reference(Any)", "The related artifact, if the artifact is not a canonical resource, or a resource reference to a canonical resource.", 0, 1, resourceReference));
        children.add(new Property("publicationStatus", "code", "The publication status of the artifact being referred to.", 0, 1, publicationStatus));
        children.add(new Property("publicationDate", "date", "The date of publication of the artifact being referred to.", 0, 1, publicationDate));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3575610: /*type*/  return new Property("type", "code", "The type of relationship to the related artifact.", 0, 1, type);
        case -281470431: /*classifier*/  return new Property("classifier", "CodeableConcept", "Provides additional classifiers of the related artifact.", 0, java.lang.Integer.MAX_VALUE, classifier);
        case 102727412: /*label*/  return new Property("label", "string", "A short label that can be used to reference the citation from elsewhere in the containing artifact, such as a footnote index.", 0, 1, label);
        case 1671764162: /*display*/  return new Property("display", "string", "A brief description of the document or knowledge resource being referenced, suitable for display to a consumer.", 0, 1, display);
        case -1442706713: /*citation*/  return new Property("citation", "markdown", "A bibliographic citation for the related artifact. This text SHOULD be formatted according to an accepted citation format.", 0, 1, citation);
        case 861720859: /*document*/  return new Property("document", "Attachment", "The document being referenced, represented as an attachment. This is exclusive with the resource element.", 0, 1, document);
        case -341064690: /*resource*/  return new Property("resource", "canonical(Any)", "The related artifact, such as a library, value set, profile, or other knowledge resource.", 0, 1, resource);
        case -610120995: /*resourceReference*/  return new Property("resourceReference", "Reference(Any)", "The related artifact, if the artifact is not a canonical resource, or a resource reference to a canonical resource.", 0, 1, resourceReference);
        case 616500542: /*publicationStatus*/  return new Property("publicationStatus", "code", "The publication status of the artifact being referred to.", 0, 1, publicationStatus);
        case 1470566394: /*publicationDate*/  return new Property("publicationDate", "date", "The date of publication of the artifact being referred to.", 0, 1, publicationDate);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<RelatedArtifactType>
        case -281470431: /*classifier*/ return this.classifier == null ? new Base[0] : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case 1671764162: /*display*/ return this.display == null ? new Base[0] : new Base[] {this.display}; // StringType
        case -1442706713: /*citation*/ return this.citation == null ? new Base[0] : new Base[] {this.citation}; // MarkdownType
        case 861720859: /*document*/ return this.document == null ? new Base[0] : new Base[] {this.document}; // Attachment
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // CanonicalType
        case -610120995: /*resourceReference*/ return this.resourceReference == null ? new Base[0] : new Base[] {this.resourceReference}; // Reference
        case 616500542: /*publicationStatus*/ return this.publicationStatus == null ? new Base[0] : new Base[] {this.publicationStatus}; // Enumeration<PublicationStatus>
        case 1470566394: /*publicationDate*/ return this.publicationDate == null ? new Base[0] : new Base[] {this.publicationDate}; // DateType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new RelatedArtifactTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<RelatedArtifactType>
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
        case 616500542: // publicationStatus
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.publicationStatus = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case 1470566394: // publicationDate
          this.publicationDate = TypeConvertor.castToDate(value); // DateType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new RelatedArtifactTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<RelatedArtifactType>
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
        } else if (name.equals("publicationStatus")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.publicationStatus = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("publicationDate")) {
          this.publicationDate = TypeConvertor.castToDate(value); // DateType
        } else
          return super.setProperty(name, value);
        return value;
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
        case 616500542:  return getPublicationStatusElement();
        case 1470566394:  return getPublicationDateElement();
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
        case 616500542: /*publicationStatus*/ return new String[] {"code"};
        case 1470566394: /*publicationDate*/ return new String[] {"date"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.type");
        }
        else if (name.equals("classifier")) {
          return addClassifier();
        }
        else if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.label");
        }
        else if (name.equals("display")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.display");
        }
        else if (name.equals("citation")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.citation");
        }
        else if (name.equals("document")) {
          this.document = new Attachment();
          return this.document;
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.resource");
        }
        else if (name.equals("resourceReference")) {
          this.resourceReference = new Reference();
          return this.resourceReference;
        }
        else if (name.equals("publicationStatus")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.publicationStatus");
        }
        else if (name.equals("publicationDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type RelatedArtifact.publicationDate");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "RelatedArtifact";

  }

      public RelatedArtifact copy() {
        RelatedArtifact dst = new RelatedArtifact();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RelatedArtifact dst) {
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
        dst.publicationStatus = publicationStatus == null ? null : publicationStatus.copy();
        dst.publicationDate = publicationDate == null ? null : publicationDate.copy();
      }

      protected RelatedArtifact typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RelatedArtifact))
          return false;
        RelatedArtifact o = (RelatedArtifact) other_;
        return compareDeep(type, o.type, true) && compareDeep(classifier, o.classifier, true) && compareDeep(label, o.label, true)
           && compareDeep(display, o.display, true) && compareDeep(citation, o.citation, true) && compareDeep(document, o.document, true)
           && compareDeep(resource, o.resource, true) && compareDeep(resourceReference, o.resourceReference, true)
           && compareDeep(publicationStatus, o.publicationStatus, true) && compareDeep(publicationDate, o.publicationDate, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RelatedArtifact))
          return false;
        RelatedArtifact o = (RelatedArtifact) other_;
        return compareValues(type, o.type, true) && compareValues(label, o.label, true) && compareValues(display, o.display, true)
           && compareValues(citation, o.citation, true) && compareValues(resource, o.resource, true) && compareValues(publicationStatus, o.publicationStatus, true)
           && compareValues(publicationDate, o.publicationDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, classifier, label
          , display, citation, document, resource, resourceReference, publicationStatus, publicationDate
          );
      }


}

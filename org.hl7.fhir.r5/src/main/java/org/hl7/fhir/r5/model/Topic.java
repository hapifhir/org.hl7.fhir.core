package org.hl7.fhir.r5.model;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

// Generated on Thu, Dec 13, 2018 14:07+1100 for FHIR v4.0.0
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;

import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;
/**
 * Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.
 */
@ResourceDef(name="Topic", profile="http://hl7.org/fhir/StructureDefinition/Topic")
public class Topic extends DomainResource {

    public enum FHIRType {
        /**
         * A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.
         */
        ACCOUNT, 
        /**
         * This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.
         */
        ACTIVITYDEFINITION, 
        /**
         * A pharmaceutical product described in terms of its composition and dose form.
         */
        ADMINISTRABLEPRODUCTDEFINITION, 
        /**
         * An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject.  The unintended effects may require additional monitoring, treatment or hospitalization or may result in death.  The AdverseEvent resource also extends to potential or avoided events that could have had such effects.
         */
        ADVERSEEVENT, 
        /**
         * Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.
         */
        ALLERGYINTOLERANCE, 
        /**
         * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).
         */
        APPOINTMENT, 
        /**
         * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
         */
        APPOINTMENTRESPONSE, 
        /**
         * A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.
         */
        AUDITEVENT, 
        /**
         * Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.
         */
        BASIC, 
        /**
         * A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.
         */
        BINARY, 
        /**
         * A material substance originating from a biological entity intended to be transplanted or infused
into another (possibly the same) biological entity.
         */
        BIOLOGICALLYDERIVEDPRODUCT, 
        /**
         * Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.
         */
        BODYSTRUCTURE, 
        /**
         * A container for a collection of resources.
         */
        BUNDLE, 
        /**
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT, 
        /**
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT2, 
        /**
         * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.
         */
        CAREPLAN, 
        /**
         * The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.
         */
        CARETEAM, 
        /**
         * Catalog entries are wrappers that contextualize items included in a catalog.
         */
        CATALOGENTRY, 
        /**
         * The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.
         */
        CHARGEITEM, 
        /**
         * The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.
         */
        CHARGEITEMDEFINITION, 
        /**
         * A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.
         */
        CLAIM, 
        /**
         * This resource provides the adjudication details from the processing of a Claim resource.
         */
        CLAIMRESPONSE, 
        /**
         * A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called "ClinicalImpression" rather than "ClinicalAssessment" to avoid confusion with the recording of assessment tools such as Apgar score.
         */
        CLINICALIMPRESSION, 
        /**
         * A single item of clinical particulars - an indication, contraindication, interaction etc. for a medicinal product.
         */
        CLINICALUSEISSUE, 
        /**
         * The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.
         */
        CODESYSTEM, 
        /**
         * An occurrence of information being transmitted; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.
         */
        COMMUNICATION, 
        /**
         * A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.
         */
        COMMUNICATIONREQUEST, 
        /**
         * A compartment definition that defines how resources are accessed on a server.
         */
        COMPARTMENTDEFINITION, 
        /**
         * A set of healthcare-related information that is assembled together into a single logical package that provides a single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to who is making the statement. A Composition defines the structure and narrative content necessary for a document. However, a Composition alone does not constitute a document. Rather, the Composition must be the first entry in a Bundle where Bundle.type=document, and any other resources referenced from Composition must be included as subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).
         */
        COMPOSITION, 
        /**
         * A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.
         */
        CONCEPTMAP, 
        /**
         * A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.
         */
        CONDITION, 
        /**
         * A definition of a condition and information relevant to managing it.
         */
        CONDITIONDEFINITION, 
        /**
         * A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.
         */
        CONSENT, 
        /**
         * Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.
         */
        CONTRACT, 
        /**
         * Financial instrument which may be used to reimburse or pay for health care products and services. Includes both insurance and self-payment.
         */
        COVERAGE, 
        /**
         * The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is valid and in-force and optionally to provide the insurance details of the policy.
         */
        COVERAGEELIGIBILITYREQUEST, 
        /**
         * This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.
         */
        COVERAGEELIGIBILITYRESPONSE, 
        /**
         * Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, etc.
         */
        DETECTEDISSUE, 
        /**
         * A type of a manufactured item that is used in the provision of healthcare without being substantially changed through that activity. The device may be a medical or non-medical device.
         */
        DEVICE, 
        /**
         * The characteristics, operational status and capabilities of a medical-related component of a medical device.
         */
        DEVICEDEFINITION, 
        /**
         * Describes a measurement, calculation or setting capability of a medical device.
         */
        DEVICEMETRIC, 
        /**
         * Represents a request for a patient to employ a medical device. The device may be an implantable device, or an external assistive device, such as a walker.
         */
        DEVICEREQUEST, 
        /**
         * A record of a device being used by a patient where the record is the result of a report from the patient or another clinician.
         */
        DEVICEUSESTATEMENT, 
        /**
         * The findings and interpretation of diagnostic  tests performed on patients, groups of patients, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting and provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports.
         */
        DIAGNOSTICREPORT, 
        /**
         * A collection of documents compiled for a purpose together with metadata that applies to the collection.
         */
        DOCUMENTMANIFEST, 
        /**
         * A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this "document" encompasses *any* seralized object with a mime-type, so includes formal patient centric documents (CDA), clniical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.
         */
        DOCUMENTREFERENCE, 
        /**
         * A resource that includes narrative, extensions, and contained resources.
         */
        DOMAINRESOURCE, 
        /**
         * An interaction between a patient and healthcare provider(s) for the purpose of providing healthcare service(s) or assessing the health status of a patient.
         */
        ENCOUNTER, 
        /**
         * The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b or a REST endpoint for another FHIR server. This may include any security context information.
         */
        ENDPOINT, 
        /**
         * This resource provides the insurance enrollment details to the insurer regarding a specified coverage.
         */
        ENROLLMENTREQUEST, 
        /**
         * This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.
         */
        ENROLLMENTRESPONSE, 
        /**
         * An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.
         */
        EPISODEOFCARE, 
        /**
         * The EventDefinition resource provides a reusable description of when a particular event can occur.
         */
        EVENTDEFINITION, 
        /**
         * This represents statistics, certainty, both the intended and actual population, and evidence variables.
         */
        EVIDENCE, 
        /**
         * The EvidenceVariable resource describes a "PICO" element that knowledge (evidence, assertion, recommendation) is about.
         */
        EVIDENCEVARIABLE, 
        /**
         * Example of workflow instance.
         */
        EXAMPLESCENARIO, 
        /**
         * This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.
         */
        EXPLANATIONOFBENEFIT, 
        /**
         * Significant health conditions for a person related to the patient relevant in the context of care for the patient.
         */
        FAMILYMEMBERHISTORY, 
        /**
         * Prospective warnings of potential issues when providing care to the patient.
         */
        FLAG, 
        /**
         * Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.
         */
        GOAL, 
        /**
         * A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.
         */
        GRAPHDEFINITION, 
        /**
         * Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.
         */
        GROUP, 
        /**
         * A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.
         */
        GUIDANCERESPONSE, 
        /**
         * The details of a healthcare service available at a location.
         */
        HEALTHCARESERVICE, 
        /**
         * Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.
         */
        IMAGINGSTUDY, 
        /**
         * Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.
         */
        IMMUNIZATION, 
        /**
         * Describes a comparison of an immunization event against published recommendations to determine if the administration is "valid" in relation to those  recommendations.
         */
        IMMUNIZATIONEVALUATION, 
        /**
         * A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.
         */
        IMMUNIZATIONRECOMMENDATION, 
        /**
         * A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.
         */
        IMPLEMENTATIONGUIDE, 
        /**
         * An ingredient of a manufactured item or pharmaceutical product.
         */
        INGREDIENT, 
        /**
         * Details of a Health Insurance product/plan provided by an organization.
         */
        INSURANCEPLAN, 
        /**
         * Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.
         */
        INVOICE, 
        /**
         * The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.
         */
        LIBRARY, 
        /**
         * Identifies two or more records (resource instances) that refer to the same real-world "occurrence".
         */
        LINKAGE, 
        /**
         * A list is a curated collection of resources.
         */
        LIST, 
        /**
         * Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.
         */
        LOCATION, 
        /**
         * The manufactured item as contained in the packaged medicinal product.
         */
        MANUFACTUREDITEMDEFINITION, 
        /**
         * The Measure resource provides the definition of a quality measure.
         */
        MEASURE, 
        /**
         * The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.
         */
        MEASUREREPORT, 
        /**
         * This resource is primarily used for the identification and definition of a medication for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.
         */
        MEDICATION, 
        /**
         * Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.
         */
        MEDICATIONADMINISTRATION, 
        /**
         * Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.
         */
        MEDICATIONDISPENSE, 
        /**
         * Information about a medication that is used to support knowledge.
         */
        MEDICATIONKNOWLEDGE, 
        /**
         * An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called "MedicationRequest" rather than "MedicationPrescription" or "MedicationOrder" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.
         */
        MEDICATIONREQUEST, 
        /**
         * A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. 

The primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.
         */
        MEDICATIONUSAGE, 
        /**
         * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use).
         */
        MEDICINALPRODUCTDEFINITION, 
        /**
         * Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.
         */
        MESSAGEDEFINITION, 
        /**
         * The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.
         */
        MESSAGEHEADER, 
        /**
         * Raw data describing a biological sequence.
         */
        MOLECULARSEQUENCE, 
        /**
         * A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a "System" used within the Identifier and Coding data types.
         */
        NAMINGSYSTEM, 
        /**
         * A record of food or fluid that is being consumed by a patient.   A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.
         */
        NUTRITIONINTAKE, 
        /**
         * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.
         */
        NUTRITIONORDER, 
        /**
         * Measurements and simple assertions made about a patient, device or other subject.
         */
        OBSERVATION, 
        /**
         * Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.
         */
        OBSERVATIONDEFINITION, 
        /**
         * A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).
         */
        OPERATIONDEFINITION, 
        /**
         * A collection of error, warning, or information messages that result from a system action.
         */
        OPERATIONOUTCOME, 
        /**
         * A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.
         */
        ORGANIZATION, 
        /**
         * Defines an affiliation/assotiation/relationship between 2 distinct oganizations, that is not a part-of relationship/sub-division relationship.
         */
        ORGANIZATIONAFFILIATION, 
        /**
         * A medicinal product in a container or package.
         */
        PACKAGEDPRODUCTDEFINITION, 
        /**
         * This resource is a non-persisted resource used to pass information into and back from an [operation](operations.html). It has no other use, and there is no RESTful endpoint associated with it.
         */
        PARAMETERS, 
        /**
         * Demographics and other administrative information about an individual or animal receiving care or other health-related services.
         */
        PATIENT, 
        /**
         * This resource provides the status of the payment for goods and services rendered, and the request and response resource references.
         */
        PAYMENTNOTICE, 
        /**
         * This resource provides the details including amount of a payment and allocates the payment items being paid.
         */
        PAYMENTRECONCILIATION, 
        /**
         * Demographics and administrative information about a person independent of a specific health-related context.
         */
        PERSON, 
        /**
         * This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical artifacts such as clinical decision support rules, order sets and protocols.
         */
        PLANDEFINITION, 
        /**
         * A person who is directly or indirectly involved in the provisioning of healthcare.
         */
        PRACTITIONER, 
        /**
         * A specific set of Roles/Locations/specialties/services that a practitioner may perform at an organization for a period of time.
         */
        PRACTITIONERROLE, 
        /**
         * An action that is or was performed on or for a patient. This can be a physical intervention like an operation, or less invasive like long term services, counseling, or hypnotherapy.
         */
        PROCEDURE, 
        /**
         * Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.
         */
        PROVENANCE, 
        /**
         * A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.
         */
        QUESTIONNAIRE, 
        /**
         * A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.
         */
        QUESTIONNAIRERESPONSE, 
        /**
         * The regulatory authorization of a medicinal product.
         */
        REGULATEDAUTHORIZATION, 
        /**
         * Information about a person that is involved in the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.
         */
        RELATEDPERSON, 
        /**
         * A group of related requests that can be used to capture intended activities that have inter-dependencies such as "give this medication after that one".
         */
        REQUESTGROUP, 
        /**
         * A process where a researcher or organization plans and then executes a series of steps intended to increase the field of healthcare-related knowledge.  This includes studies of safety, efficacy, comparative effectiveness and other information about medications, devices, therapies and other interventional and investigative techniques.  A ResearchStudy involves the gathering of information about human or animal subjects.
         */
        RESEARCHSTUDY, 
        /**
         * A physical entity which is the primary unit of operational and/or administrative interest in a study.
         */
        RESEARCHSUBJECT, 
        /**
         * This is the base resource type for everything.
         */
        RESOURCE, 
        /**
         * An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.
         */
        RISKASSESSMENT, 
        /**
         * A container for slots of time that may be available for booking appointments.
         */
        SCHEDULE, 
        /**
         * A search parameter that defines a named search item that can be used to search/filter on a resource.
         */
        SEARCHPARAMETER, 
        /**
         * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
         */
        SERVICEREQUEST, 
        /**
         * A slot of time on a schedule that may be available for booking appointments.
         */
        SLOT, 
        /**
         * A sample to be used for analysis.
         */
        SPECIMEN, 
        /**
         * A kind of specimen with associated set of requirements.
         */
        SPECIMENDEFINITION, 
        /**
         * A definition of a FHIR structure. This resource is used to describe the underlying resources, data types defined in FHIR, and also for describing extensions and constraints on resources and data types.
         */
        STRUCTUREDEFINITION, 
        /**
         * A Map of relationships between 2 structures that can be used to transform data.
         */
        STRUCTUREMAP, 
        /**
         * The subscription resource describes a particular client's request to be notified about a Topic.
         */
        SUBSCRIPTION, 
        /**
         * A homogeneous material with a definite composition.
         */
        SUBSTANCE, 
        /**
         * The detailed description of a substance, typically at a level beyond what is used for prescribing.
         */
        SUBSTANCEDEFINITION, 
        /**
         * Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.
         */
        SUBSTANCENUCLEICACID, 
        /**
         * Todo.
         */
        SUBSTANCEPOLYMER, 
        /**
         * A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.
         */
        SUBSTANCEPROTEIN, 
        /**
         * Todo.
         */
        SUBSTANCEREFERENCEINFORMATION, 
        /**
         * Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.
         */
        SUBSTANCESOURCEMATERIAL, 
        /**
         * Record of delivery of what is supplied.
         */
        SUPPLYDELIVERY, 
        /**
         * A record of a request for a medication, substance or device used in the healthcare setting.
         */
        SUPPLYREQUEST, 
        /**
         * A task to be performed.
         */
        TASK, 
        /**
         * A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        TERMINOLOGYCAPABILITIES, 
        /**
         * A summary of information based on the results of executing a TestScript.
         */
        TESTREPORT, 
        /**
         * A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.
         */
        TESTSCRIPT, 
        /**
         * Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.
         */
        TOPIC, 
        /**
         * A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).
         */
        VALUESET, 
        /**
         * Describes validation requirements, source(s), status and dates for one or more elements.
         */
        VERIFICATIONRESULT, 
        /**
         * An authorization for the provision of glasses and/or contact lenses to a patient.
         */
        VISIONPRESCRIPTION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static FHIRType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Account".equals(codeString))
          return ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return ACTIVITYDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return APPOINTMENTRESPONSE;
        if ("AuditEvent".equals(codeString))
          return AUDITEVENT;
        if ("Basic".equals(codeString))
          return BASIC;
        if ("Binary".equals(codeString))
          return BINARY;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return BODYSTRUCTURE;
        if ("Bundle".equals(codeString))
          return BUNDLE;
        if ("CapabilityStatement".equals(codeString))
          return CAPABILITYSTATEMENT;
        if ("CapabilityStatement2".equals(codeString))
          return CAPABILITYSTATEMENT2;
        if ("CarePlan".equals(codeString))
          return CAREPLAN;
        if ("CareTeam".equals(codeString))
          return CARETEAM;
        if ("CatalogEntry".equals(codeString))
          return CATALOGENTRY;
        if ("ChargeItem".equals(codeString))
          return CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return CHARGEITEMDEFINITION;
        if ("Claim".equals(codeString))
          return CLAIM;
        if ("ClaimResponse".equals(codeString))
          return CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return CLINICALIMPRESSION;
        if ("ClinicalUseIssue".equals(codeString))
          return CLINICALUSEISSUE;
        if ("CodeSystem".equals(codeString))
          return CODESYSTEM;
        if ("Communication".equals(codeString))
          return COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return CONCEPTMAP;
        if ("Condition".equals(codeString))
          return CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return CONSENT;
        if ("Contract".equals(codeString))
          return CONTRACT;
        if ("Coverage".equals(codeString))
          return COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return DETECTEDISSUE;
        if ("Device".equals(codeString))
          return DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return DEVICEDEFINITION;
        if ("DeviceMetric".equals(codeString))
          return DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return DEVICEREQUEST;
        if ("DeviceUseStatement".equals(codeString))
          return DEVICEUSESTATEMENT;
        if ("DiagnosticReport".equals(codeString))
          return DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return DOCUMENTREFERENCE;
        if ("DomainResource".equals(codeString))
          return DOMAINRESOURCE;
        if ("Encounter".equals(codeString))
          return ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return EVIDENCE;
        if ("EvidenceVariable".equals(codeString))
          return EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return FLAG;
        if ("Goal".equals(codeString))
          return GOAL;
        if ("GraphDefinition".equals(codeString))
          return GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return GROUP;
        if ("GuidanceResponse".equals(codeString))
          return GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return HEALTHCARESERVICE;
        if ("ImagingStudy".equals(codeString))
          return IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return INSURANCEPLAN;
        if ("Invoice".equals(codeString))
          return INVOICE;
        if ("Library".equals(codeString))
          return LIBRARY;
        if ("Linkage".equals(codeString))
          return LINKAGE;
        if ("List".equals(codeString))
          return LIST;
        if ("Location".equals(codeString))
          return LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return MEASURE;
        if ("MeasureReport".equals(codeString))
          return MEASUREREPORT;
        if ("Medication".equals(codeString))
          return MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return MESSAGEHEADER;
        if ("MolecularSequence".equals(codeString))
          return MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return NUTRITIONORDER;
        if ("Observation".equals(codeString))
          return OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return PACKAGEDPRODUCTDEFINITION;
        if ("Parameters".equals(codeString))
          return PARAMETERS;
        if ("Patient".equals(codeString))
          return PATIENT;
        if ("PaymentNotice".equals(codeString))
          return PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return PAYMENTRECONCILIATION;
        if ("Person".equals(codeString))
          return PERSON;
        if ("PlanDefinition".equals(codeString))
          return PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return PROCEDURE;
        if ("Provenance".equals(codeString))
          return PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return RELATEDPERSON;
        if ("RequestGroup".equals(codeString))
          return REQUESTGROUP;
        if ("ResearchStudy".equals(codeString))
          return RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return RESEARCHSUBJECT;
        if ("Resource".equals(codeString))
          return RESOURCE;
        if ("RiskAssessment".equals(codeString))
          return RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return SLOT;
        if ("Specimen".equals(codeString))
          return SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return SUBSCRIPTION;
        if ("Substance".equals(codeString))
          return SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return TESTREPORT;
        if ("TestScript".equals(codeString))
          return TESTSCRIPT;
        if ("Topic".equals(codeString))
          return TOPIC;
        if ("ValueSet".equals(codeString))
          return VALUESET;
        if ("VerificationResult".equals(codeString))
          return VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return VISIONPRESCRIPTION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown FHIRType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAPABILITYSTATEMENT2: return "CapabilityStatement2";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CATALOGENTRY: return "CatalogEntry";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEISSUE: return "ClinicalUseIssue";
            case CODESYSTEM: return "CodeSystem";
            case COMMUNICATION: return "Communication";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case COMPARTMENTDEFINITION: return "CompartmentDefinition";
            case COMPOSITION: return "Composition";
            case CONCEPTMAP: return "ConceptMap";
            case CONDITION: return "Condition";
            case CONDITIONDEFINITION: return "ConditionDefinition";
            case CONSENT: return "Consent";
            case CONTRACT: return "Contract";
            case COVERAGE: return "Coverage";
            case COVERAGEELIGIBILITYREQUEST: return "CoverageEligibilityRequest";
            case COVERAGEELIGIBILITYRESPONSE: return "CoverageEligibilityResponse";
            case DETECTEDISSUE: return "DetectedIssue";
            case DEVICE: return "Device";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSESTATEMENT: return "DeviceUseStatement";
            case DIAGNOSTICREPORT: return "DiagnosticReport";
            case DOCUMENTMANIFEST: return "DocumentManifest";
            case DOCUMENTREFERENCE: return "DocumentReference";
            case DOMAINRESOURCE: return "DomainResource";
            case ENCOUNTER: return "Encounter";
            case ENDPOINT: return "Endpoint";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case ENROLLMENTRESPONSE: return "EnrollmentResponse";
            case EPISODEOFCARE: return "EpisodeOfCare";
            case EVENTDEFINITION: return "EventDefinition";
            case EVIDENCE: return "Evidence";
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
            case INVOICE: return "Invoice";
            case LIBRARY: return "Library";
            case LINKAGE: return "Linkage";
            case LIST: return "List";
            case LOCATION: return "Location";
            case MANUFACTUREDITEMDEFINITION: return "ManufacturedItemDefinition";
            case MEASURE: return "Measure";
            case MEASUREREPORT: return "MeasureReport";
            case MEDICATION: return "Medication";
            case MEDICATIONADMINISTRATION: return "MedicationAdministration";
            case MEDICATIONDISPENSE: return "MedicationDispense";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case MEDICATIONUSAGE: return "MedicationUsage";
            case MEDICINALPRODUCTDEFINITION: return "MedicinalProductDefinition";
            case MESSAGEDEFINITION: return "MessageDefinition";
            case MESSAGEHEADER: return "MessageHeader";
            case MOLECULARSEQUENCE: return "MolecularSequence";
            case NAMINGSYSTEM: return "NamingSystem";
            case NUTRITIONINTAKE: return "NutritionIntake";
            case NUTRITIONORDER: return "NutritionOrder";
            case OBSERVATION: return "Observation";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case OPERATIONDEFINITION: return "OperationDefinition";
            case OPERATIONOUTCOME: return "OperationOutcome";
            case ORGANIZATION: return "Organization";
            case ORGANIZATIONAFFILIATION: return "OrganizationAffiliation";
            case PACKAGEDPRODUCTDEFINITION: return "PackagedProductDefinition";
            case PARAMETERS: return "Parameters";
            case PATIENT: return "Patient";
            case PAYMENTNOTICE: return "PaymentNotice";
            case PAYMENTRECONCILIATION: return "PaymentReconciliation";
            case PERSON: return "Person";
            case PLANDEFINITION: return "PlanDefinition";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case PROCEDURE: return "Procedure";
            case PROVENANCE: return "Provenance";
            case QUESTIONNAIRE: return "Questionnaire";
            case QUESTIONNAIRERESPONSE: return "QuestionnaireResponse";
            case REGULATEDAUTHORIZATION: return "RegulatedAuthorization";
            case RELATEDPERSON: return "RelatedPerson";
            case REQUESTGROUP: return "RequestGroup";
            case RESEARCHSTUDY: return "ResearchStudy";
            case RESEARCHSUBJECT: return "ResearchSubject";
            case RESOURCE: return "Resource";
            case RISKASSESSMENT: return "RiskAssessment";
            case SCHEDULE: return "Schedule";
            case SEARCHPARAMETER: return "SearchParameter";
            case SERVICEREQUEST: return "ServiceRequest";
            case SLOT: return "Slot";
            case SPECIMEN: return "Specimen";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case STRUCTUREDEFINITION: return "StructureDefinition";
            case STRUCTUREMAP: return "StructureMap";
            case SUBSCRIPTION: return "Subscription";
            case SUBSTANCE: return "Substance";
            case SUBSTANCEDEFINITION: return "SubstanceDefinition";
            case SUBSTANCENUCLEICACID: return "SubstanceNucleicAcid";
            case SUBSTANCEPOLYMER: return "SubstancePolymer";
            case SUBSTANCEPROTEIN: return "SubstanceProtein";
            case SUBSTANCEREFERENCEINFORMATION: return "SubstanceReferenceInformation";
            case SUBSTANCESOURCEMATERIAL: return "SubstanceSourceMaterial";
            case SUPPLYDELIVERY: return "SupplyDelivery";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case TERMINOLOGYCAPABILITIES: return "TerminologyCapabilities";
            case TESTREPORT: return "TestReport";
            case TESTSCRIPT: return "TestScript";
            case TOPIC: return "Topic";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACCOUNT: return "http://hl7.org/fhir/resource-types";
            case ACTIVITYDEFINITION: return "http://hl7.org/fhir/resource-types";
            case ADMINISTRABLEPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case ADVERSEEVENT: return "http://hl7.org/fhir/resource-types";
            case ALLERGYINTOLERANCE: return "http://hl7.org/fhir/resource-types";
            case APPOINTMENT: return "http://hl7.org/fhir/resource-types";
            case APPOINTMENTRESPONSE: return "http://hl7.org/fhir/resource-types";
            case AUDITEVENT: return "http://hl7.org/fhir/resource-types";
            case BASIC: return "http://hl7.org/fhir/resource-types";
            case BINARY: return "http://hl7.org/fhir/resource-types";
            case BIOLOGICALLYDERIVEDPRODUCT: return "http://hl7.org/fhir/resource-types";
            case BODYSTRUCTURE: return "http://hl7.org/fhir/resource-types";
            case BUNDLE: return "http://hl7.org/fhir/resource-types";
            case CAPABILITYSTATEMENT: return "http://hl7.org/fhir/resource-types";
            case CAPABILITYSTATEMENT2: return "http://hl7.org/fhir/resource-types";
            case CAREPLAN: return "http://hl7.org/fhir/resource-types";
            case CARETEAM: return "http://hl7.org/fhir/resource-types";
            case CATALOGENTRY: return "http://hl7.org/fhir/resource-types";
            case CHARGEITEM: return "http://hl7.org/fhir/resource-types";
            case CHARGEITEMDEFINITION: return "http://hl7.org/fhir/resource-types";
            case CLAIM: return "http://hl7.org/fhir/resource-types";
            case CLAIMRESPONSE: return "http://hl7.org/fhir/resource-types";
            case CLINICALIMPRESSION: return "http://hl7.org/fhir/resource-types";
            case CLINICALUSEISSUE: return "http://hl7.org/fhir/resource-types";
            case CODESYSTEM: return "http://hl7.org/fhir/resource-types";
            case COMMUNICATION: return "http://hl7.org/fhir/resource-types";
            case COMMUNICATIONREQUEST: return "http://hl7.org/fhir/resource-types";
            case COMPARTMENTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case COMPOSITION: return "http://hl7.org/fhir/resource-types";
            case CONCEPTMAP: return "http://hl7.org/fhir/resource-types";
            case CONDITION: return "http://hl7.org/fhir/resource-types";
            case CONDITIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case CONSENT: return "http://hl7.org/fhir/resource-types";
            case CONTRACT: return "http://hl7.org/fhir/resource-types";
            case COVERAGE: return "http://hl7.org/fhir/resource-types";
            case COVERAGEELIGIBILITYREQUEST: return "http://hl7.org/fhir/resource-types";
            case COVERAGEELIGIBILITYRESPONSE: return "http://hl7.org/fhir/resource-types";
            case DETECTEDISSUE: return "http://hl7.org/fhir/resource-types";
            case DEVICE: return "http://hl7.org/fhir/resource-types";
            case DEVICEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case DEVICEMETRIC: return "http://hl7.org/fhir/resource-types";
            case DEVICEREQUEST: return "http://hl7.org/fhir/resource-types";
            case DEVICEUSESTATEMENT: return "http://hl7.org/fhir/resource-types";
            case DIAGNOSTICREPORT: return "http://hl7.org/fhir/resource-types";
            case DOCUMENTMANIFEST: return "http://hl7.org/fhir/resource-types";
            case DOCUMENTREFERENCE: return "http://hl7.org/fhir/resource-types";
            case DOMAINRESOURCE: return "http://hl7.org/fhir/resource-types";
            case ENCOUNTER: return "http://hl7.org/fhir/resource-types";
            case ENDPOINT: return "http://hl7.org/fhir/resource-types";
            case ENROLLMENTREQUEST: return "http://hl7.org/fhir/resource-types";
            case ENROLLMENTRESPONSE: return "http://hl7.org/fhir/resource-types";
            case EPISODEOFCARE: return "http://hl7.org/fhir/resource-types";
            case EVENTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case EVIDENCE: return "http://hl7.org/fhir/resource-types";
            case EVIDENCEVARIABLE: return "http://hl7.org/fhir/resource-types";
            case EXAMPLESCENARIO: return "http://hl7.org/fhir/resource-types";
            case EXPLANATIONOFBENEFIT: return "http://hl7.org/fhir/resource-types";
            case FAMILYMEMBERHISTORY: return "http://hl7.org/fhir/resource-types";
            case FLAG: return "http://hl7.org/fhir/resource-types";
            case GOAL: return "http://hl7.org/fhir/resource-types";
            case GRAPHDEFINITION: return "http://hl7.org/fhir/resource-types";
            case GROUP: return "http://hl7.org/fhir/resource-types";
            case GUIDANCERESPONSE: return "http://hl7.org/fhir/resource-types";
            case HEALTHCARESERVICE: return "http://hl7.org/fhir/resource-types";
            case IMAGINGSTUDY: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATION: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATIONEVALUATION: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATIONRECOMMENDATION: return "http://hl7.org/fhir/resource-types";
            case IMPLEMENTATIONGUIDE: return "http://hl7.org/fhir/resource-types";
            case INGREDIENT: return "http://hl7.org/fhir/resource-types";
            case INSURANCEPLAN: return "http://hl7.org/fhir/resource-types";
            case INVOICE: return "http://hl7.org/fhir/resource-types";
            case LIBRARY: return "http://hl7.org/fhir/resource-types";
            case LINKAGE: return "http://hl7.org/fhir/resource-types";
            case LIST: return "http://hl7.org/fhir/resource-types";
            case LOCATION: return "http://hl7.org/fhir/resource-types";
            case MANUFACTUREDITEMDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MEASURE: return "http://hl7.org/fhir/resource-types";
            case MEASUREREPORT: return "http://hl7.org/fhir/resource-types";
            case MEDICATION: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONADMINISTRATION: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONDISPENSE: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONKNOWLEDGE: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONREQUEST: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONUSAGE: return "http://hl7.org/fhir/resource-types";
            case MEDICINALPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MESSAGEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MESSAGEHEADER: return "http://hl7.org/fhir/resource-types";
            case MOLECULARSEQUENCE: return "http://hl7.org/fhir/resource-types";
            case NAMINGSYSTEM: return "http://hl7.org/fhir/resource-types";
            case NUTRITIONINTAKE: return "http://hl7.org/fhir/resource-types";
            case NUTRITIONORDER: return "http://hl7.org/fhir/resource-types";
            case OBSERVATION: return "http://hl7.org/fhir/resource-types";
            case OBSERVATIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case OPERATIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case OPERATIONOUTCOME: return "http://hl7.org/fhir/resource-types";
            case ORGANIZATION: return "http://hl7.org/fhir/resource-types";
            case ORGANIZATIONAFFILIATION: return "http://hl7.org/fhir/resource-types";
            case PACKAGEDPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case PARAMETERS: return "http://hl7.org/fhir/resource-types";
            case PATIENT: return "http://hl7.org/fhir/resource-types";
            case PAYMENTNOTICE: return "http://hl7.org/fhir/resource-types";
            case PAYMENTRECONCILIATION: return "http://hl7.org/fhir/resource-types";
            case PERSON: return "http://hl7.org/fhir/resource-types";
            case PLANDEFINITION: return "http://hl7.org/fhir/resource-types";
            case PRACTITIONER: return "http://hl7.org/fhir/resource-types";
            case PRACTITIONERROLE: return "http://hl7.org/fhir/resource-types";
            case PROCEDURE: return "http://hl7.org/fhir/resource-types";
            case PROVENANCE: return "http://hl7.org/fhir/resource-types";
            case QUESTIONNAIRE: return "http://hl7.org/fhir/resource-types";
            case QUESTIONNAIRERESPONSE: return "http://hl7.org/fhir/resource-types";
            case REGULATEDAUTHORIZATION: return "http://hl7.org/fhir/resource-types";
            case RELATEDPERSON: return "http://hl7.org/fhir/resource-types";
            case REQUESTGROUP: return "http://hl7.org/fhir/resource-types";
            case RESEARCHSTUDY: return "http://hl7.org/fhir/resource-types";
            case RESEARCHSUBJECT: return "http://hl7.org/fhir/resource-types";
            case RESOURCE: return "http://hl7.org/fhir/resource-types";
            case RISKASSESSMENT: return "http://hl7.org/fhir/resource-types";
            case SCHEDULE: return "http://hl7.org/fhir/resource-types";
            case SEARCHPARAMETER: return "http://hl7.org/fhir/resource-types";
            case SERVICEREQUEST: return "http://hl7.org/fhir/resource-types";
            case SLOT: return "http://hl7.org/fhir/resource-types";
            case SPECIMEN: return "http://hl7.org/fhir/resource-types";
            case SPECIMENDEFINITION: return "http://hl7.org/fhir/resource-types";
            case STRUCTUREDEFINITION: return "http://hl7.org/fhir/resource-types";
            case STRUCTUREMAP: return "http://hl7.org/fhir/resource-types";
            case SUBSCRIPTION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCE: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCENUCLEICACID: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEPOLYMER: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEPROTEIN: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEREFERENCEINFORMATION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCESOURCEMATERIAL: return "http://hl7.org/fhir/resource-types";
            case SUPPLYDELIVERY: return "http://hl7.org/fhir/resource-types";
            case SUPPLYREQUEST: return "http://hl7.org/fhir/resource-types";
            case TASK: return "http://hl7.org/fhir/resource-types";
            case TERMINOLOGYCAPABILITIES: return "http://hl7.org/fhir/resource-types";
            case TESTREPORT: return "http://hl7.org/fhir/resource-types";
            case TESTSCRIPT: return "http://hl7.org/fhir/resource-types";
            case TOPIC: return "http://hl7.org/fhir/resource-types";
            case VALUESET: return "http://hl7.org/fhir/resource-types";
            case VERIFICATIONRESULT: return "http://hl7.org/fhir/resource-types";
            case VISIONPRESCRIPTION: return "http://hl7.org/fhir/resource-types";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACCOUNT: return "A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.";
            case ACTIVITYDEFINITION: return "This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.";
            case ADMINISTRABLEPRODUCTDEFINITION: return "A pharmaceutical product described in terms of its composition and dose form.";
            case ADVERSEEVENT: return "An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject.  The unintended effects may require additional monitoring, treatment or hospitalization or may result in death.  The AdverseEvent resource also extends to potential or avoided events that could have had such effects.";
            case ALLERGYINTOLERANCE: return "Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.";
            case APPOINTMENT: return "A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).";
            case APPOINTMENTRESPONSE: return "A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.";
            case AUDITEVENT: return "A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.";
            case BASIC: return "Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.";
            case BINARY: return "A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.";
            case BIOLOGICALLYDERIVEDPRODUCT: return "A material substance originating from a biological entity intended to be transplanted or infused\ninto another (possibly the same) biological entity.";
            case BODYSTRUCTURE: return "Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.";
            case BUNDLE: return "A container for a collection of resources.";
            case CAPABILITYSTATEMENT: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAPABILITYSTATEMENT2: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAREPLAN: return "Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.";
            case CARETEAM: return "The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.";
            case CATALOGENTRY: return "Catalog entries are wrappers that contextualize items included in a catalog.";
            case CHARGEITEM: return "The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.";
            case CHARGEITEMDEFINITION: return "The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.";
            case CLAIM: return "A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.";
            case CLAIMRESPONSE: return "This resource provides the adjudication details from the processing of a Claim resource.";
            case CLINICALIMPRESSION: return "A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called \"ClinicalImpression\" rather than \"ClinicalAssessment\" to avoid confusion with the recording of assessment tools such as Apgar score.";
            case CLINICALUSEISSUE: return "A single item of clinical particulars - an indication, contraindication, interaction etc. for a medicinal product.";
            case CODESYSTEM: return "The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.";
            case COMMUNICATION: return "An occurrence of information being transmitted; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.";
            case COMMUNICATIONREQUEST: return "A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.";
            case COMPARTMENTDEFINITION: return "A compartment definition that defines how resources are accessed on a server.";
            case COMPOSITION: return "A set of healthcare-related information that is assembled together into a single logical package that provides a single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to who is making the statement. A Composition defines the structure and narrative content necessary for a document. However, a Composition alone does not constitute a document. Rather, the Composition must be the first entry in a Bundle where Bundle.type=document, and any other resources referenced from Composition must be included as subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).";
            case CONCEPTMAP: return "A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.";
            case CONDITION: return "A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.";
            case CONDITIONDEFINITION: return "A definition of a condition and information relevant to managing it.";
            case CONSENT: return "A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.";
            case CONTRACT: return "Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.";
            case COVERAGE: return "Financial instrument which may be used to reimburse or pay for health care products and services. Includes both insurance and self-payment.";
            case COVERAGEELIGIBILITYREQUEST: return "The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is valid and in-force and optionally to provide the insurance details of the policy.";
            case COVERAGEELIGIBILITYRESPONSE: return "This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.";
            case DETECTEDISSUE: return "Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, etc.";
            case DEVICE: return "A type of a manufactured item that is used in the provision of healthcare without being substantially changed through that activity. The device may be a medical or non-medical device.";
            case DEVICEDEFINITION: return "The characteristics, operational status and capabilities of a medical-related component of a medical device.";
            case DEVICEMETRIC: return "Describes a measurement, calculation or setting capability of a medical device.";
            case DEVICEREQUEST: return "Represents a request for a patient to employ a medical device. The device may be an implantable device, or an external assistive device, such as a walker.";
            case DEVICEUSESTATEMENT: return "A record of a device being used by a patient where the record is the result of a report from the patient or another clinician.";
            case DIAGNOSTICREPORT: return "The findings and interpretation of diagnostic  tests performed on patients, groups of patients, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting and provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports.";
            case DOCUMENTMANIFEST: return "A collection of documents compiled for a purpose together with metadata that applies to the collection.";
            case DOCUMENTREFERENCE: return "A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this \"document\" encompasses *any* seralized object with a mime-type, so includes formal patient centric documents (CDA), clniical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.";
            case DOMAINRESOURCE: return "A resource that includes narrative, extensions, and contained resources.";
            case ENCOUNTER: return "An interaction between a patient and healthcare provider(s) for the purpose of providing healthcare service(s) or assessing the health status of a patient.";
            case ENDPOINT: return "The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b or a REST endpoint for another FHIR server. This may include any security context information.";
            case ENROLLMENTREQUEST: return "This resource provides the insurance enrollment details to the insurer regarding a specified coverage.";
            case ENROLLMENTRESPONSE: return "This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.";
            case EPISODEOFCARE: return "An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.";
            case EVENTDEFINITION: return "The EventDefinition resource provides a reusable description of when a particular event can occur.";
            case EVIDENCE: return "This represents statistics, certainty, both the intended and actual population, and evidence variables.";
            case EVIDENCEVARIABLE: return "The EvidenceVariable resource describes a \"PICO\" element that knowledge (evidence, assertion, recommendation) is about.";
            case EXAMPLESCENARIO: return "Example of workflow instance.";
            case EXPLANATIONOFBENEFIT: return "This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.";
            case FAMILYMEMBERHISTORY: return "Significant health conditions for a person related to the patient relevant in the context of care for the patient.";
            case FLAG: return "Prospective warnings of potential issues when providing care to the patient.";
            case GOAL: return "Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.";
            case GRAPHDEFINITION: return "A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.";
            case GROUP: return "Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.";
            case GUIDANCERESPONSE: return "A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.";
            case HEALTHCARESERVICE: return "The details of a healthcare service available at a location.";
            case IMAGINGSTUDY: return "Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.";
            case IMMUNIZATION: return "Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.";
            case IMMUNIZATIONEVALUATION: return "Describes a comparison of an immunization event against published recommendations to determine if the administration is \"valid\" in relation to those  recommendations.";
            case IMMUNIZATIONRECOMMENDATION: return "A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.";
            case IMPLEMENTATIONGUIDE: return "A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.";
            case INGREDIENT: return "An ingredient of a manufactured item or pharmaceutical product.";
            case INSURANCEPLAN: return "Details of a Health Insurance product/plan provided by an organization.";
            case INVOICE: return "Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.";
            case LIBRARY: return "The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.";
            case LINKAGE: return "Identifies two or more records (resource instances) that refer to the same real-world \"occurrence\".";
            case LIST: return "A list is a curated collection of resources.";
            case LOCATION: return "Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.";
            case MANUFACTUREDITEMDEFINITION: return "The manufactured item as contained in the packaged medicinal product.";
            case MEASURE: return "The Measure resource provides the definition of a quality measure.";
            case MEASUREREPORT: return "The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.";
            case MEDICATION: return "This resource is primarily used for the identification and definition of a medication for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.";
            case MEDICATIONADMINISTRATION: return "Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.";
            case MEDICATIONDISPENSE: return "Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.";
            case MEDICATIONKNOWLEDGE: return "Information about a medication that is used to support knowledge.";
            case MEDICATIONREQUEST: return "An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called \"MedicationRequest\" rather than \"MedicationPrescription\" or \"MedicationOrder\" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.";
            case MEDICATIONUSAGE: return "A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. \n\nThe primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.";
            case MEDICINALPRODUCTDEFINITION: return "Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use).";
            case MESSAGEDEFINITION: return "Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.";
            case MESSAGEHEADER: return "The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.";
            case MOLECULARSEQUENCE: return "Raw data describing a biological sequence.";
            case NAMINGSYSTEM: return "A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a \"System\" used within the Identifier and Coding data types.";
            case NUTRITIONINTAKE: return "A record of food or fluid that is being consumed by a patient.   A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.";
            case NUTRITIONORDER: return "A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.";
            case OBSERVATION: return "Measurements and simple assertions made about a patient, device or other subject.";
            case OBSERVATIONDEFINITION: return "Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.";
            case OPERATIONDEFINITION: return "A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).";
            case OPERATIONOUTCOME: return "A collection of error, warning, or information messages that result from a system action.";
            case ORGANIZATION: return "A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.";
            case ORGANIZATIONAFFILIATION: return "Defines an affiliation/assotiation/relationship between 2 distinct oganizations, that is not a part-of relationship/sub-division relationship.";
            case PACKAGEDPRODUCTDEFINITION: return "A medicinal product in a container or package.";
            case PARAMETERS: return "This resource is a non-persisted resource used to pass information into and back from an [operation](operations.html). It has no other use, and there is no RESTful endpoint associated with it.";
            case PATIENT: return "Demographics and other administrative information about an individual or animal receiving care or other health-related services.";
            case PAYMENTNOTICE: return "This resource provides the status of the payment for goods and services rendered, and the request and response resource references.";
            case PAYMENTRECONCILIATION: return "This resource provides the details including amount of a payment and allocates the payment items being paid.";
            case PERSON: return "Demographics and administrative information about a person independent of a specific health-related context.";
            case PLANDEFINITION: return "This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical artifacts such as clinical decision support rules, order sets and protocols.";
            case PRACTITIONER: return "A person who is directly or indirectly involved in the provisioning of healthcare.";
            case PRACTITIONERROLE: return "A specific set of Roles/Locations/specialties/services that a practitioner may perform at an organization for a period of time.";
            case PROCEDURE: return "An action that is or was performed on or for a patient. This can be a physical intervention like an operation, or less invasive like long term services, counseling, or hypnotherapy.";
            case PROVENANCE: return "Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.";
            case QUESTIONNAIRE: return "A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.";
            case QUESTIONNAIRERESPONSE: return "A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.";
            case REGULATEDAUTHORIZATION: return "The regulatory authorization of a medicinal product.";
            case RELATEDPERSON: return "Information about a person that is involved in the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.";
            case REQUESTGROUP: return "A group of related requests that can be used to capture intended activities that have inter-dependencies such as \"give this medication after that one\".";
            case RESEARCHSTUDY: return "A process where a researcher or organization plans and then executes a series of steps intended to increase the field of healthcare-related knowledge.  This includes studies of safety, efficacy, comparative effectiveness and other information about medications, devices, therapies and other interventional and investigative techniques.  A ResearchStudy involves the gathering of information about human or animal subjects.";
            case RESEARCHSUBJECT: return "A physical entity which is the primary unit of operational and/or administrative interest in a study.";
            case RESOURCE: return "This is the base resource type for everything.";
            case RISKASSESSMENT: return "An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.";
            case SCHEDULE: return "A container for slots of time that may be available for booking appointments.";
            case SEARCHPARAMETER: return "A search parameter that defines a named search item that can be used to search/filter on a resource.";
            case SERVICEREQUEST: return "A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.";
            case SLOT: return "A slot of time on a schedule that may be available for booking appointments.";
            case SPECIMEN: return "A sample to be used for analysis.";
            case SPECIMENDEFINITION: return "A kind of specimen with associated set of requirements.";
            case STRUCTUREDEFINITION: return "A definition of a FHIR structure. This resource is used to describe the underlying resources, data types defined in FHIR, and also for describing extensions and constraints on resources and data types.";
            case STRUCTUREMAP: return "A Map of relationships between 2 structures that can be used to transform data.";
            case SUBSCRIPTION: return "The subscription resource describes a particular client's request to be notified about a Topic.";
            case SUBSTANCE: return "A homogeneous material with a definite composition.";
            case SUBSTANCEDEFINITION: return "The detailed description of a substance, typically at a level beyond what is used for prescribing.";
            case SUBSTANCENUCLEICACID: return "Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.";
            case SUBSTANCEPOLYMER: return "Todo.";
            case SUBSTANCEPROTEIN: return "A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.";
            case SUBSTANCEREFERENCEINFORMATION: return "Todo.";
            case SUBSTANCESOURCEMATERIAL: return "Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.";
            case SUPPLYDELIVERY: return "Record of delivery of what is supplied.";
            case SUPPLYREQUEST: return "A record of a request for a medication, substance or device used in the healthcare setting.";
            case TASK: return "A task to be performed.";
            case TERMINOLOGYCAPABILITIES: return "A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case TESTREPORT: return "A summary of information based on the results of executing a TestScript.";
            case TESTSCRIPT: return "A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.";
            case TOPIC: return "Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.";
            case VALUESET: return "A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).";
            case VERIFICATIONRESULT: return "Describes validation requirements, source(s), status and dates for one or more elements.";
            case VISIONPRESCRIPTION: return "An authorization for the provision of glasses and/or contact lenses to a patient.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAPABILITYSTATEMENT2: return "CapabilityStatement2";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CATALOGENTRY: return "CatalogEntry";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEISSUE: return "ClinicalUseIssue";
            case CODESYSTEM: return "CodeSystem";
            case COMMUNICATION: return "Communication";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case COMPARTMENTDEFINITION: return "CompartmentDefinition";
            case COMPOSITION: return "Composition";
            case CONCEPTMAP: return "ConceptMap";
            case CONDITION: return "Condition";
            case CONDITIONDEFINITION: return "ConditionDefinition";
            case CONSENT: return "Consent";
            case CONTRACT: return "Contract";
            case COVERAGE: return "Coverage";
            case COVERAGEELIGIBILITYREQUEST: return "CoverageEligibilityRequest";
            case COVERAGEELIGIBILITYRESPONSE: return "CoverageEligibilityResponse";
            case DETECTEDISSUE: return "DetectedIssue";
            case DEVICE: return "Device";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSESTATEMENT: return "DeviceUseStatement";
            case DIAGNOSTICREPORT: return "DiagnosticReport";
            case DOCUMENTMANIFEST: return "DocumentManifest";
            case DOCUMENTREFERENCE: return "DocumentReference";
            case DOMAINRESOURCE: return "DomainResource";
            case ENCOUNTER: return "Encounter";
            case ENDPOINT: return "Endpoint";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case ENROLLMENTRESPONSE: return "EnrollmentResponse";
            case EPISODEOFCARE: return "EpisodeOfCare";
            case EVENTDEFINITION: return "EventDefinition";
            case EVIDENCE: return "Evidence";
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
            case INVOICE: return "Invoice";
            case LIBRARY: return "Library";
            case LINKAGE: return "Linkage";
            case LIST: return "List";
            case LOCATION: return "Location";
            case MANUFACTUREDITEMDEFINITION: return "ManufacturedItemDefinition";
            case MEASURE: return "Measure";
            case MEASUREREPORT: return "MeasureReport";
            case MEDICATION: return "Medication";
            case MEDICATIONADMINISTRATION: return "MedicationAdministration";
            case MEDICATIONDISPENSE: return "MedicationDispense";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case MEDICATIONUSAGE: return "MedicationUsage";
            case MEDICINALPRODUCTDEFINITION: return "MedicinalProductDefinition";
            case MESSAGEDEFINITION: return "MessageDefinition";
            case MESSAGEHEADER: return "MessageHeader";
            case MOLECULARSEQUENCE: return "MolecularSequence";
            case NAMINGSYSTEM: return "NamingSystem";
            case NUTRITIONINTAKE: return "NutritionIntake";
            case NUTRITIONORDER: return "NutritionOrder";
            case OBSERVATION: return "Observation";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case OPERATIONDEFINITION: return "OperationDefinition";
            case OPERATIONOUTCOME: return "OperationOutcome";
            case ORGANIZATION: return "Organization";
            case ORGANIZATIONAFFILIATION: return "OrganizationAffiliation";
            case PACKAGEDPRODUCTDEFINITION: return "PackagedProductDefinition";
            case PARAMETERS: return "Parameters";
            case PATIENT: return "Patient";
            case PAYMENTNOTICE: return "PaymentNotice";
            case PAYMENTRECONCILIATION: return "PaymentReconciliation";
            case PERSON: return "Person";
            case PLANDEFINITION: return "PlanDefinition";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case PROCEDURE: return "Procedure";
            case PROVENANCE: return "Provenance";
            case QUESTIONNAIRE: return "Questionnaire";
            case QUESTIONNAIRERESPONSE: return "QuestionnaireResponse";
            case REGULATEDAUTHORIZATION: return "RegulatedAuthorization";
            case RELATEDPERSON: return "RelatedPerson";
            case REQUESTGROUP: return "RequestGroup";
            case RESEARCHSTUDY: return "ResearchStudy";
            case RESEARCHSUBJECT: return "ResearchSubject";
            case RESOURCE: return "Resource";
            case RISKASSESSMENT: return "RiskAssessment";
            case SCHEDULE: return "Schedule";
            case SEARCHPARAMETER: return "SearchParameter";
            case SERVICEREQUEST: return "ServiceRequest";
            case SLOT: return "Slot";
            case SPECIMEN: return "Specimen";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case STRUCTUREDEFINITION: return "StructureDefinition";
            case STRUCTUREMAP: return "StructureMap";
            case SUBSCRIPTION: return "Subscription";
            case SUBSTANCE: return "Substance";
            case SUBSTANCEDEFINITION: return "SubstanceDefinition";
            case SUBSTANCENUCLEICACID: return "SubstanceNucleicAcid";
            case SUBSTANCEPOLYMER: return "SubstancePolymer";
            case SUBSTANCEPROTEIN: return "SubstanceProtein";
            case SUBSTANCEREFERENCEINFORMATION: return "SubstanceReferenceInformation";
            case SUBSTANCESOURCEMATERIAL: return "SubstanceSourceMaterial";
            case SUPPLYDELIVERY: return "SupplyDelivery";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case TERMINOLOGYCAPABILITIES: return "TerminologyCapabilities";
            case TESTREPORT: return "TestReport";
            case TESTSCRIPT: return "TestScript";
            case TOPIC: return "Topic";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            default: return "?";
          }
        }
    }

  public static class FHIRTypeEnumFactory implements EnumFactory<FHIRType> {
    public FHIRType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Account".equals(codeString))
          return FHIRType.ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return FHIRType.ACTIVITYDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return FHIRType.ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return FHIRType.ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return FHIRType.ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return FHIRType.APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return FHIRType.APPOINTMENTRESPONSE;
        if ("AuditEvent".equals(codeString))
          return FHIRType.AUDITEVENT;
        if ("Basic".equals(codeString))
          return FHIRType.BASIC;
        if ("Binary".equals(codeString))
          return FHIRType.BINARY;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return FHIRType.BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return FHIRType.BODYSTRUCTURE;
        if ("Bundle".equals(codeString))
          return FHIRType.BUNDLE;
        if ("CapabilityStatement".equals(codeString))
          return FHIRType.CAPABILITYSTATEMENT;
        if ("CapabilityStatement2".equals(codeString))
          return FHIRType.CAPABILITYSTATEMENT2;
        if ("CarePlan".equals(codeString))
          return FHIRType.CAREPLAN;
        if ("CareTeam".equals(codeString))
          return FHIRType.CARETEAM;
        if ("CatalogEntry".equals(codeString))
          return FHIRType.CATALOGENTRY;
        if ("ChargeItem".equals(codeString))
          return FHIRType.CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return FHIRType.CHARGEITEMDEFINITION;
        if ("Claim".equals(codeString))
          return FHIRType.CLAIM;
        if ("ClaimResponse".equals(codeString))
          return FHIRType.CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return FHIRType.CLINICALIMPRESSION;
        if ("ClinicalUseIssue".equals(codeString))
          return FHIRType.CLINICALUSEISSUE;
        if ("CodeSystem".equals(codeString))
          return FHIRType.CODESYSTEM;
        if ("Communication".equals(codeString))
          return FHIRType.COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return FHIRType.COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return FHIRType.COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return FHIRType.COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return FHIRType.CONCEPTMAP;
        if ("Condition".equals(codeString))
          return FHIRType.CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return FHIRType.CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return FHIRType.CONSENT;
        if ("Contract".equals(codeString))
          return FHIRType.CONTRACT;
        if ("Coverage".equals(codeString))
          return FHIRType.COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return FHIRType.COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return FHIRType.COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return FHIRType.DETECTEDISSUE;
        if ("Device".equals(codeString))
          return FHIRType.DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return FHIRType.DEVICEDEFINITION;
        if ("DeviceMetric".equals(codeString))
          return FHIRType.DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return FHIRType.DEVICEREQUEST;
        if ("DeviceUseStatement".equals(codeString))
          return FHIRType.DEVICEUSESTATEMENT;
        if ("DiagnosticReport".equals(codeString))
          return FHIRType.DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return FHIRType.DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return FHIRType.DOCUMENTREFERENCE;
        if ("DomainResource".equals(codeString))
          return FHIRType.DOMAINRESOURCE;
        if ("Encounter".equals(codeString))
          return FHIRType.ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return FHIRType.ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return FHIRType.ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return FHIRType.ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return FHIRType.EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return FHIRType.EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return FHIRType.EVIDENCE;
        if ("EvidenceVariable".equals(codeString))
          return FHIRType.EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return FHIRType.EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return FHIRType.EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return FHIRType.FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return FHIRType.FLAG;
        if ("Goal".equals(codeString))
          return FHIRType.GOAL;
        if ("GraphDefinition".equals(codeString))
          return FHIRType.GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return FHIRType.GROUP;
        if ("GuidanceResponse".equals(codeString))
          return FHIRType.GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return FHIRType.HEALTHCARESERVICE;
        if ("ImagingStudy".equals(codeString))
          return FHIRType.IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return FHIRType.IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return FHIRType.IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return FHIRType.IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return FHIRType.IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return FHIRType.INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return FHIRType.INSURANCEPLAN;
        if ("Invoice".equals(codeString))
          return FHIRType.INVOICE;
        if ("Library".equals(codeString))
          return FHIRType.LIBRARY;
        if ("Linkage".equals(codeString))
          return FHIRType.LINKAGE;
        if ("List".equals(codeString))
          return FHIRType.LIST;
        if ("Location".equals(codeString))
          return FHIRType.LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return FHIRType.MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return FHIRType.MEASURE;
        if ("MeasureReport".equals(codeString))
          return FHIRType.MEASUREREPORT;
        if ("Medication".equals(codeString))
          return FHIRType.MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return FHIRType.MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return FHIRType.MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return FHIRType.MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return FHIRType.MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return FHIRType.MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return FHIRType.MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return FHIRType.MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return FHIRType.MESSAGEHEADER;
        if ("MolecularSequence".equals(codeString))
          return FHIRType.MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return FHIRType.NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return FHIRType.NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return FHIRType.NUTRITIONORDER;
        if ("Observation".equals(codeString))
          return FHIRType.OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return FHIRType.OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return FHIRType.OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return FHIRType.OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return FHIRType.ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return FHIRType.ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return FHIRType.PACKAGEDPRODUCTDEFINITION;
        if ("Parameters".equals(codeString))
          return FHIRType.PARAMETERS;
        if ("Patient".equals(codeString))
          return FHIRType.PATIENT;
        if ("PaymentNotice".equals(codeString))
          return FHIRType.PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return FHIRType.PAYMENTRECONCILIATION;
        if ("Person".equals(codeString))
          return FHIRType.PERSON;
        if ("PlanDefinition".equals(codeString))
          return FHIRType.PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return FHIRType.PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return FHIRType.PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return FHIRType.PROCEDURE;
        if ("Provenance".equals(codeString))
          return FHIRType.PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return FHIRType.QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return FHIRType.QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return FHIRType.REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return FHIRType.RELATEDPERSON;
        if ("RequestGroup".equals(codeString))
          return FHIRType.REQUESTGROUP;
        if ("ResearchStudy".equals(codeString))
          return FHIRType.RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return FHIRType.RESEARCHSUBJECT;
        if ("Resource".equals(codeString))
          return FHIRType.RESOURCE;
        if ("RiskAssessment".equals(codeString))
          return FHIRType.RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return FHIRType.SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return FHIRType.SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return FHIRType.SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return FHIRType.SLOT;
        if ("Specimen".equals(codeString))
          return FHIRType.SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return FHIRType.SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return FHIRType.STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return FHIRType.STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return FHIRType.SUBSCRIPTION;
        if ("Substance".equals(codeString))
          return FHIRType.SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return FHIRType.SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return FHIRType.SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return FHIRType.SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return FHIRType.SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return FHIRType.SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return FHIRType.SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return FHIRType.SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return FHIRType.SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return FHIRType.TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return FHIRType.TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return FHIRType.TESTREPORT;
        if ("TestScript".equals(codeString))
          return FHIRType.TESTSCRIPT;
        if ("Topic".equals(codeString))
          return FHIRType.TOPIC;
        if ("ValueSet".equals(codeString))
          return FHIRType.VALUESET;
        if ("VerificationResult".equals(codeString))
          return FHIRType.VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return FHIRType.VISIONPRESCRIPTION;
        throw new IllegalArgumentException("Unknown FHIRType code '"+codeString+"'");
        }
        public Enumeration<FHIRType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FHIRType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("Account".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ACCOUNT);
        if ("ActivityDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ACTIVITYDEFINITION);
        if ("AdministrableProductDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ADMINISTRABLEPRODUCTDEFINITION);
        if ("AdverseEvent".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ADVERSEEVENT);
        if ("AllergyIntolerance".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ALLERGYINTOLERANCE);
        if ("Appointment".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.APPOINTMENT);
        if ("AppointmentResponse".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.APPOINTMENTRESPONSE);
        if ("AuditEvent".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.AUDITEVENT);
        if ("Basic".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.BASIC);
        if ("Binary".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.BINARY);
        if ("BiologicallyDerivedProduct".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.BIOLOGICALLYDERIVEDPRODUCT);
        if ("BodyStructure".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.BODYSTRUCTURE);
        if ("Bundle".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.BUNDLE);
        if ("CapabilityStatement".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CAPABILITYSTATEMENT);
        if ("CapabilityStatement2".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CAPABILITYSTATEMENT2);
        if ("CarePlan".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CAREPLAN);
        if ("CareTeam".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CARETEAM);
        if ("CatalogEntry".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CATALOGENTRY);
        if ("ChargeItem".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CHARGEITEM);
        if ("ChargeItemDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CHARGEITEMDEFINITION);
        if ("Claim".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CLAIM);
        if ("ClaimResponse".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CLAIMRESPONSE);
        if ("ClinicalImpression".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CLINICALIMPRESSION);
        if ("ClinicalUseIssue".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CLINICALUSEISSUE);
        if ("CodeSystem".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CODESYSTEM);
        if ("Communication".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.COMMUNICATION);
        if ("CommunicationRequest".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.COMMUNICATIONREQUEST);
        if ("CompartmentDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.COMPARTMENTDEFINITION);
        if ("Composition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.COMPOSITION);
        if ("ConceptMap".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CONCEPTMAP);
        if ("Condition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CONDITION);
        if ("ConditionDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CONDITIONDEFINITION);
        if ("Consent".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CONSENT);
        if ("Contract".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.CONTRACT);
        if ("Coverage".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.COVERAGE);
        if ("CoverageEligibilityRequest".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.COVERAGEELIGIBILITYREQUEST);
        if ("CoverageEligibilityResponse".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.COVERAGEELIGIBILITYRESPONSE);
        if ("DetectedIssue".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.DETECTEDISSUE);
        if ("Device".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.DEVICE);
        if ("DeviceDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.DEVICEDEFINITION);
        if ("DeviceMetric".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.DEVICEMETRIC);
        if ("DeviceRequest".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.DEVICEREQUEST);
        if ("DeviceUseStatement".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.DEVICEUSESTATEMENT);
        if ("DiagnosticReport".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.DIAGNOSTICREPORT);
        if ("DocumentManifest".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.DOCUMENTMANIFEST);
        if ("DocumentReference".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.DOCUMENTREFERENCE);
        if ("DomainResource".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.DOMAINRESOURCE);
        if ("Encounter".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ENCOUNTER);
        if ("Endpoint".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ENDPOINT);
        if ("EnrollmentRequest".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ENROLLMENTREQUEST);
        if ("EnrollmentResponse".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ENROLLMENTRESPONSE);
        if ("EpisodeOfCare".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.EPISODEOFCARE);
        if ("EventDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.EVENTDEFINITION);
        if ("Evidence".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.EVIDENCE);
        if ("EvidenceVariable".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.EVIDENCEVARIABLE);
        if ("ExampleScenario".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.EXAMPLESCENARIO);
        if ("ExplanationOfBenefit".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.EXPLANATIONOFBENEFIT);
        if ("FamilyMemberHistory".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.FAMILYMEMBERHISTORY);
        if ("Flag".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.FLAG);
        if ("Goal".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.GOAL);
        if ("GraphDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.GRAPHDEFINITION);
        if ("Group".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.GROUP);
        if ("GuidanceResponse".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.GUIDANCERESPONSE);
        if ("HealthcareService".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.HEALTHCARESERVICE);
        if ("ImagingStudy".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.IMAGINGSTUDY);
        if ("Immunization".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.IMMUNIZATION);
        if ("ImmunizationEvaluation".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.IMMUNIZATIONEVALUATION);
        if ("ImmunizationRecommendation".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.IMMUNIZATIONRECOMMENDATION);
        if ("ImplementationGuide".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.IMPLEMENTATIONGUIDE);
        if ("Ingredient".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.INGREDIENT);
        if ("InsurancePlan".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.INSURANCEPLAN);
        if ("Invoice".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.INVOICE);
        if ("Library".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.LIBRARY);
        if ("Linkage".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.LINKAGE);
        if ("List".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.LIST);
        if ("Location".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.LOCATION);
        if ("ManufacturedItemDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MANUFACTUREDITEMDEFINITION);
        if ("Measure".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MEASURE);
        if ("MeasureReport".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MEASUREREPORT);
        if ("Medication".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MEDICATION);
        if ("MedicationAdministration".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MEDICATIONADMINISTRATION);
        if ("MedicationDispense".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MEDICATIONDISPENSE);
        if ("MedicationKnowledge".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MEDICATIONKNOWLEDGE);
        if ("MedicationRequest".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MEDICATIONREQUEST);
        if ("MedicationUsage".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MEDICATIONUSAGE);
        if ("MedicinalProductDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MEDICINALPRODUCTDEFINITION);
        if ("MessageDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MESSAGEDEFINITION);
        if ("MessageHeader".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MESSAGEHEADER);
        if ("MolecularSequence".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.MOLECULARSEQUENCE);
        if ("NamingSystem".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.NAMINGSYSTEM);
        if ("NutritionIntake".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.NUTRITIONINTAKE);
        if ("NutritionOrder".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.NUTRITIONORDER);
        if ("Observation".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.OBSERVATION);
        if ("ObservationDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.OBSERVATIONDEFINITION);
        if ("OperationDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.OPERATIONDEFINITION);
        if ("OperationOutcome".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.OPERATIONOUTCOME);
        if ("Organization".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ORGANIZATION);
        if ("OrganizationAffiliation".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.ORGANIZATIONAFFILIATION);
        if ("PackagedProductDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PACKAGEDPRODUCTDEFINITION);
        if ("Parameters".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PARAMETERS);
        if ("Patient".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PATIENT);
        if ("PaymentNotice".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PAYMENTNOTICE);
        if ("PaymentReconciliation".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PAYMENTRECONCILIATION);
        if ("Person".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PERSON);
        if ("PlanDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PLANDEFINITION);
        if ("Practitioner".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PRACTITIONER);
        if ("PractitionerRole".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PRACTITIONERROLE);
        if ("Procedure".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PROCEDURE);
        if ("Provenance".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.PROVENANCE);
        if ("Questionnaire".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.QUESTIONNAIRE);
        if ("QuestionnaireResponse".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.QUESTIONNAIRERESPONSE);
        if ("RegulatedAuthorization".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.REGULATEDAUTHORIZATION);
        if ("RelatedPerson".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.RELATEDPERSON);
        if ("RequestGroup".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.REQUESTGROUP);
        if ("ResearchStudy".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.RESEARCHSTUDY);
        if ("ResearchSubject".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.RESEARCHSUBJECT);
        if ("Resource".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.RESOURCE);
        if ("RiskAssessment".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.RISKASSESSMENT);
        if ("Schedule".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SCHEDULE);
        if ("SearchParameter".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SEARCHPARAMETER);
        if ("ServiceRequest".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SERVICEREQUEST);
        if ("Slot".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SLOT);
        if ("Specimen".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SPECIMEN);
        if ("SpecimenDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SPECIMENDEFINITION);
        if ("StructureDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.STRUCTUREDEFINITION);
        if ("StructureMap".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.STRUCTUREMAP);
        if ("Subscription".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SUBSCRIPTION);
        if ("Substance".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SUBSTANCE);
        if ("SubstanceDefinition".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SUBSTANCEDEFINITION);
        if ("SubstanceNucleicAcid".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SUBSTANCENUCLEICACID);
        if ("SubstancePolymer".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SUBSTANCEPOLYMER);
        if ("SubstanceProtein".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SUBSTANCEPROTEIN);
        if ("SubstanceReferenceInformation".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SUBSTANCEREFERENCEINFORMATION);
        if ("SubstanceSourceMaterial".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SUBSTANCESOURCEMATERIAL);
        if ("SupplyDelivery".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SUPPLYDELIVERY);
        if ("SupplyRequest".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.SUPPLYREQUEST);
        if ("Task".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.TASK);
        if ("TerminologyCapabilities".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.TERMINOLOGYCAPABILITIES);
        if ("TestReport".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.TESTREPORT);
        if ("TestScript".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.TESTSCRIPT);
        if ("Topic".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.TOPIC);
        if ("ValueSet".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.VALUESET);
        if ("VerificationResult".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.VERIFICATIONRESULT);
        if ("VisionPrescription".equals(codeString))
          return new Enumeration<FHIRType>(this, FHIRType.VISIONPRESCRIPTION);
        throw new FHIRException("Unknown FHIRType code '"+codeString+"'");
        }
    public String toCode(FHIRType code) {
      if (code == FHIRType.ACCOUNT)
        return "Account";
      if (code == FHIRType.ACTIVITYDEFINITION)
        return "ActivityDefinition";
      if (code == FHIRType.ADMINISTRABLEPRODUCTDEFINITION)
        return "AdministrableProductDefinition";
      if (code == FHIRType.ADVERSEEVENT)
        return "AdverseEvent";
      if (code == FHIRType.ALLERGYINTOLERANCE)
        return "AllergyIntolerance";
      if (code == FHIRType.APPOINTMENT)
        return "Appointment";
      if (code == FHIRType.APPOINTMENTRESPONSE)
        return "AppointmentResponse";
      if (code == FHIRType.AUDITEVENT)
        return "AuditEvent";
      if (code == FHIRType.BASIC)
        return "Basic";
      if (code == FHIRType.BINARY)
        return "Binary";
      if (code == FHIRType.BIOLOGICALLYDERIVEDPRODUCT)
        return "BiologicallyDerivedProduct";
      if (code == FHIRType.BODYSTRUCTURE)
        return "BodyStructure";
      if (code == FHIRType.BUNDLE)
        return "Bundle";
      if (code == FHIRType.CAPABILITYSTATEMENT)
        return "CapabilityStatement";
      if (code == FHIRType.CAPABILITYSTATEMENT2)
        return "CapabilityStatement2";
      if (code == FHIRType.CAREPLAN)
        return "CarePlan";
      if (code == FHIRType.CARETEAM)
        return "CareTeam";
      if (code == FHIRType.CATALOGENTRY)
        return "CatalogEntry";
      if (code == FHIRType.CHARGEITEM)
        return "ChargeItem";
      if (code == FHIRType.CHARGEITEMDEFINITION)
        return "ChargeItemDefinition";
      if (code == FHIRType.CLAIM)
        return "Claim";
      if (code == FHIRType.CLAIMRESPONSE)
        return "ClaimResponse";
      if (code == FHIRType.CLINICALIMPRESSION)
        return "ClinicalImpression";
      if (code == FHIRType.CLINICALUSEISSUE)
        return "ClinicalUseIssue";
      if (code == FHIRType.CODESYSTEM)
        return "CodeSystem";
      if (code == FHIRType.COMMUNICATION)
        return "Communication";
      if (code == FHIRType.COMMUNICATIONREQUEST)
        return "CommunicationRequest";
      if (code == FHIRType.COMPARTMENTDEFINITION)
        return "CompartmentDefinition";
      if (code == FHIRType.COMPOSITION)
        return "Composition";
      if (code == FHIRType.CONCEPTMAP)
        return "ConceptMap";
      if (code == FHIRType.CONDITION)
        return "Condition";
      if (code == FHIRType.CONDITIONDEFINITION)
        return "ConditionDefinition";
      if (code == FHIRType.CONSENT)
        return "Consent";
      if (code == FHIRType.CONTRACT)
        return "Contract";
      if (code == FHIRType.COVERAGE)
        return "Coverage";
      if (code == FHIRType.COVERAGEELIGIBILITYREQUEST)
        return "CoverageEligibilityRequest";
      if (code == FHIRType.COVERAGEELIGIBILITYRESPONSE)
        return "CoverageEligibilityResponse";
      if (code == FHIRType.DETECTEDISSUE)
        return "DetectedIssue";
      if (code == FHIRType.DEVICE)
        return "Device";
      if (code == FHIRType.DEVICEDEFINITION)
        return "DeviceDefinition";
      if (code == FHIRType.DEVICEMETRIC)
        return "DeviceMetric";
      if (code == FHIRType.DEVICEREQUEST)
        return "DeviceRequest";
      if (code == FHIRType.DEVICEUSESTATEMENT)
        return "DeviceUseStatement";
      if (code == FHIRType.DIAGNOSTICREPORT)
        return "DiagnosticReport";
      if (code == FHIRType.DOCUMENTMANIFEST)
        return "DocumentManifest";
      if (code == FHIRType.DOCUMENTREFERENCE)
        return "DocumentReference";
      if (code == FHIRType.DOMAINRESOURCE)
        return "DomainResource";
      if (code == FHIRType.ENCOUNTER)
        return "Encounter";
      if (code == FHIRType.ENDPOINT)
        return "Endpoint";
      if (code == FHIRType.ENROLLMENTREQUEST)
        return "EnrollmentRequest";
      if (code == FHIRType.ENROLLMENTRESPONSE)
        return "EnrollmentResponse";
      if (code == FHIRType.EPISODEOFCARE)
        return "EpisodeOfCare";
      if (code == FHIRType.EVENTDEFINITION)
        return "EventDefinition";
      if (code == FHIRType.EVIDENCE)
        return "Evidence";
      if (code == FHIRType.EVIDENCEVARIABLE)
        return "EvidenceVariable";
      if (code == FHIRType.EXAMPLESCENARIO)
        return "ExampleScenario";
      if (code == FHIRType.EXPLANATIONOFBENEFIT)
        return "ExplanationOfBenefit";
      if (code == FHIRType.FAMILYMEMBERHISTORY)
        return "FamilyMemberHistory";
      if (code == FHIRType.FLAG)
        return "Flag";
      if (code == FHIRType.GOAL)
        return "Goal";
      if (code == FHIRType.GRAPHDEFINITION)
        return "GraphDefinition";
      if (code == FHIRType.GROUP)
        return "Group";
      if (code == FHIRType.GUIDANCERESPONSE)
        return "GuidanceResponse";
      if (code == FHIRType.HEALTHCARESERVICE)
        return "HealthcareService";
      if (code == FHIRType.IMAGINGSTUDY)
        return "ImagingStudy";
      if (code == FHIRType.IMMUNIZATION)
        return "Immunization";
      if (code == FHIRType.IMMUNIZATIONEVALUATION)
        return "ImmunizationEvaluation";
      if (code == FHIRType.IMMUNIZATIONRECOMMENDATION)
        return "ImmunizationRecommendation";
      if (code == FHIRType.IMPLEMENTATIONGUIDE)
        return "ImplementationGuide";
      if (code == FHIRType.INGREDIENT)
        return "Ingredient";
      if (code == FHIRType.INSURANCEPLAN)
        return "InsurancePlan";
      if (code == FHIRType.INVOICE)
        return "Invoice";
      if (code == FHIRType.LIBRARY)
        return "Library";
      if (code == FHIRType.LINKAGE)
        return "Linkage";
      if (code == FHIRType.LIST)
        return "List";
      if (code == FHIRType.LOCATION)
        return "Location";
      if (code == FHIRType.MANUFACTUREDITEMDEFINITION)
        return "ManufacturedItemDefinition";
      if (code == FHIRType.MEASURE)
        return "Measure";
      if (code == FHIRType.MEASUREREPORT)
        return "MeasureReport";
      if (code == FHIRType.MEDICATION)
        return "Medication";
      if (code == FHIRType.MEDICATIONADMINISTRATION)
        return "MedicationAdministration";
      if (code == FHIRType.MEDICATIONDISPENSE)
        return "MedicationDispense";
      if (code == FHIRType.MEDICATIONKNOWLEDGE)
        return "MedicationKnowledge";
      if (code == FHIRType.MEDICATIONREQUEST)
        return "MedicationRequest";
      if (code == FHIRType.MEDICATIONUSAGE)
        return "MedicationUsage";
      if (code == FHIRType.MEDICINALPRODUCTDEFINITION)
        return "MedicinalProductDefinition";
      if (code == FHIRType.MESSAGEDEFINITION)
        return "MessageDefinition";
      if (code == FHIRType.MESSAGEHEADER)
        return "MessageHeader";
      if (code == FHIRType.MOLECULARSEQUENCE)
        return "MolecularSequence";
      if (code == FHIRType.NAMINGSYSTEM)
        return "NamingSystem";
      if (code == FHIRType.NUTRITIONINTAKE)
        return "NutritionIntake";
      if (code == FHIRType.NUTRITIONORDER)
        return "NutritionOrder";
      if (code == FHIRType.OBSERVATION)
        return "Observation";
      if (code == FHIRType.OBSERVATIONDEFINITION)
        return "ObservationDefinition";
      if (code == FHIRType.OPERATIONDEFINITION)
        return "OperationDefinition";
      if (code == FHIRType.OPERATIONOUTCOME)
        return "OperationOutcome";
      if (code == FHIRType.ORGANIZATION)
        return "Organization";
      if (code == FHIRType.ORGANIZATIONAFFILIATION)
        return "OrganizationAffiliation";
      if (code == FHIRType.PACKAGEDPRODUCTDEFINITION)
        return "PackagedProductDefinition";
      if (code == FHIRType.PARAMETERS)
        return "Parameters";
      if (code == FHIRType.PATIENT)
        return "Patient";
      if (code == FHIRType.PAYMENTNOTICE)
        return "PaymentNotice";
      if (code == FHIRType.PAYMENTRECONCILIATION)
        return "PaymentReconciliation";
      if (code == FHIRType.PERSON)
        return "Person";
      if (code == FHIRType.PLANDEFINITION)
        return "PlanDefinition";
      if (code == FHIRType.PRACTITIONER)
        return "Practitioner";
      if (code == FHIRType.PRACTITIONERROLE)
        return "PractitionerRole";
      if (code == FHIRType.PROCEDURE)
        return "Procedure";
      if (code == FHIRType.PROVENANCE)
        return "Provenance";
      if (code == FHIRType.QUESTIONNAIRE)
        return "Questionnaire";
      if (code == FHIRType.QUESTIONNAIRERESPONSE)
        return "QuestionnaireResponse";
      if (code == FHIRType.REGULATEDAUTHORIZATION)
        return "RegulatedAuthorization";
      if (code == FHIRType.RELATEDPERSON)
        return "RelatedPerson";
      if (code == FHIRType.REQUESTGROUP)
        return "RequestGroup";
      if (code == FHIRType.RESEARCHSTUDY)
        return "ResearchStudy";
      if (code == FHIRType.RESEARCHSUBJECT)
        return "ResearchSubject";
      if (code == FHIRType.RESOURCE)
        return "Resource";
      if (code == FHIRType.RISKASSESSMENT)
        return "RiskAssessment";
      if (code == FHIRType.SCHEDULE)
        return "Schedule";
      if (code == FHIRType.SEARCHPARAMETER)
        return "SearchParameter";
      if (code == FHIRType.SERVICEREQUEST)
        return "ServiceRequest";
      if (code == FHIRType.SLOT)
        return "Slot";
      if (code == FHIRType.SPECIMEN)
        return "Specimen";
      if (code == FHIRType.SPECIMENDEFINITION)
        return "SpecimenDefinition";
      if (code == FHIRType.STRUCTUREDEFINITION)
        return "StructureDefinition";
      if (code == FHIRType.STRUCTUREMAP)
        return "StructureMap";
      if (code == FHIRType.SUBSCRIPTION)
        return "Subscription";
      if (code == FHIRType.SUBSTANCE)
        return "Substance";
      if (code == FHIRType.SUBSTANCEDEFINITION)
        return "SubstanceDefinition";
      if (code == FHIRType.SUBSTANCENUCLEICACID)
        return "SubstanceNucleicAcid";
      if (code == FHIRType.SUBSTANCEPOLYMER)
        return "SubstancePolymer";
      if (code == FHIRType.SUBSTANCEPROTEIN)
        return "SubstanceProtein";
      if (code == FHIRType.SUBSTANCEREFERENCEINFORMATION)
        return "SubstanceReferenceInformation";
      if (code == FHIRType.SUBSTANCESOURCEMATERIAL)
        return "SubstanceSourceMaterial";
      if (code == FHIRType.SUPPLYDELIVERY)
        return "SupplyDelivery";
      if (code == FHIRType.SUPPLYREQUEST)
        return "SupplyRequest";
      if (code == FHIRType.TASK)
        return "Task";
      if (code == FHIRType.TERMINOLOGYCAPABILITIES)
        return "TerminologyCapabilities";
      if (code == FHIRType.TESTREPORT)
        return "TestReport";
      if (code == FHIRType.TESTSCRIPT)
        return "TestScript";
      if (code == FHIRType.TOPIC)
        return "Topic";
      if (code == FHIRType.VALUESET)
        return "ValueSet";
      if (code == FHIRType.VERIFICATIONRESULT)
        return "VerificationResult";
      if (code == FHIRType.VISIONPRESCRIPTION)
        return "VisionPrescription";
      return "?";
      }
    public String toSystem(FHIRType code) {
      return code.getSystem();
      }
    }

    public enum MethodCode {
        /**
         * null
         */
        CREATE, 
        /**
         * null
         */
        UPDATE, 
        /**
         * null
         */
        DELETE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static MethodCode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("create".equals(codeString))
          return CREATE;
        if ("update".equals(codeString))
          return UPDATE;
        if ("delete".equals(codeString))
          return DELETE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown MethodCode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CREATE: return "create";
            case UPDATE: return "update";
            case DELETE: return "delete";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CREATE: return "http://hl7.org/fhir/restful-interaction";
            case UPDATE: return "http://hl7.org/fhir/restful-interaction";
            case DELETE: return "http://hl7.org/fhir/restful-interaction";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CREATE: return "";
            case UPDATE: return "";
            case DELETE: return "";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CREATE: return "create";
            case UPDATE: return "update";
            case DELETE: return "delete";
            default: return "?";
          }
        }
    }

  public static class MethodCodeEnumFactory implements EnumFactory<MethodCode> {
    public MethodCode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("create".equals(codeString))
          return MethodCode.CREATE;
        if ("update".equals(codeString))
          return MethodCode.UPDATE;
        if ("delete".equals(codeString))
          return MethodCode.DELETE;
        throw new IllegalArgumentException("Unknown MethodCode code '"+codeString+"'");
        }
        public Enumeration<MethodCode> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MethodCode>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("create".equals(codeString))
          return new Enumeration<MethodCode>(this, MethodCode.CREATE);
        if ("update".equals(codeString))
          return new Enumeration<MethodCode>(this, MethodCode.UPDATE);
        if ("delete".equals(codeString))
          return new Enumeration<MethodCode>(this, MethodCode.DELETE);
        throw new FHIRException("Unknown MethodCode code '"+codeString+"'");
        }
    public String toCode(MethodCode code) {
      if (code == MethodCode.CREATE)
        return "create";
      if (code == MethodCode.UPDATE)
        return "update";
      if (code == MethodCode.DELETE)
        return "delete";
      return "?";
      }
    public String toSystem(MethodCode code) {
      return code.getSystem();
      }
    }

    public enum TopicFilterByMatchType {
        /**
         * Used to match a value according to FHIR Search rules (e.g., Patient/123, Encounter/2002).
         */
        EQUAL, 
        /**
         * The key value in the topic stream is an active members of the reference set identified by the concept provided as the filter value.
         */
        IN, 
        /**
         * The key value in the topic stream is NOT an active members of the reference set identified by the concept provided as the filter value.
         */
        NOTIN, 
        /**
         * The key value is subsumes the value in the filter value.
         */
        ABOVE, 
        /**
         * The key value is subsumed by the value in the filter value.
         */
        BELOW, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static TopicFilterByMatchType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("=".equals(codeString))
          return EQUAL;
        if ("in".equals(codeString))
          return IN;
        if ("not-in".equals(codeString))
          return NOTIN;
        if ("above".equals(codeString))
          return ABOVE;
        if ("below".equals(codeString))
          return BELOW;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown TopicFilterByMatchType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EQUAL: return "=";
            case IN: return "in";
            case NOTIN: return "not-in";
            case ABOVE: return "above";
            case BELOW: return "below";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EQUAL: return "http://hl7.org/fhir/topic-match-operator";
            case IN: return "http://hl7.org/fhir/topic-match-operator";
            case NOTIN: return "http://hl7.org/fhir/topic-match-operator";
            case ABOVE: return "http://hl7.org/fhir/topic-match-operator";
            case BELOW: return "http://hl7.org/fhir/topic-match-operator";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EQUAL: return "Used to match a value according to FHIR Search rules (e.g., Patient/123, Encounter/2002).";
            case IN: return "The key value in the topic stream is an active members of the reference set identified by the concept provided as the filter value.";
            case NOTIN: return "The key value in the topic stream is NOT an active members of the reference set identified by the concept provided as the filter value.";
            case ABOVE: return "The key value is subsumes the value in the filter value.";
            case BELOW: return "The key value is subsumed by the value in the filter value.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EQUAL: return "=";
            case IN: return "in";
            case NOTIN: return "not-in";
            case ABOVE: return "above";
            case BELOW: return "below";
            default: return "?";
          }
        }
    }

  public static class TopicFilterByMatchTypeEnumFactory implements EnumFactory<TopicFilterByMatchType> {
    public TopicFilterByMatchType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("=".equals(codeString))
          return TopicFilterByMatchType.EQUAL;
        if ("in".equals(codeString))
          return TopicFilterByMatchType.IN;
        if ("not-in".equals(codeString))
          return TopicFilterByMatchType.NOTIN;
        if ("above".equals(codeString))
          return TopicFilterByMatchType.ABOVE;
        if ("below".equals(codeString))
          return TopicFilterByMatchType.BELOW;
        throw new IllegalArgumentException("Unknown TopicFilterByMatchType code '"+codeString+"'");
        }
        public Enumeration<TopicFilterByMatchType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<TopicFilterByMatchType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("=".equals(codeString))
          return new Enumeration<TopicFilterByMatchType>(this, TopicFilterByMatchType.EQUAL);
        if ("in".equals(codeString))
          return new Enumeration<TopicFilterByMatchType>(this, TopicFilterByMatchType.IN);
        if ("not-in".equals(codeString))
          return new Enumeration<TopicFilterByMatchType>(this, TopicFilterByMatchType.NOTIN);
        if ("above".equals(codeString))
          return new Enumeration<TopicFilterByMatchType>(this, TopicFilterByMatchType.ABOVE);
        if ("below".equals(codeString))
          return new Enumeration<TopicFilterByMatchType>(this, TopicFilterByMatchType.BELOW);
        throw new FHIRException("Unknown TopicFilterByMatchType code '"+codeString+"'");
        }
    public String toCode(TopicFilterByMatchType code) {
      if (code == TopicFilterByMatchType.EQUAL)
        return "=";
      if (code == TopicFilterByMatchType.IN)
        return "in";
      if (code == TopicFilterByMatchType.NOTIN)
        return "not-in";
      if (code == TopicFilterByMatchType.ABOVE)
        return "above";
      if (code == TopicFilterByMatchType.BELOW)
        return "below";
      return "?";
      }
    public String toSystem(TopicFilterByMatchType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class TopicResourceTriggerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The human readable description of what triggers inclusion into this topic -  for example, "Beginning of a clinical encounter".
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Text representation of the trigger", formalDefinition="The human readable description of what triggers inclusion into this topic -  for example, \"Beginning of a clinical encounter\"." )
        protected StringType description;

        /**
         * The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.
         */
        @Child(name = "resourceType", type = {CodeType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Candidate types for this topic", formalDefinition="The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/resource-types")
        protected List<Enumeration<FHIRType>> resourceType;

        /**
         * The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.
         */
        @Child(name = "methodCriteria", type = {CodeType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="create | update | delete", formalDefinition="The REST interaction based rules that the server should use to determine when to trigger a notification for this topic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/interaction-trigger")
        protected List<Enumeration<MethodCode>> methodCriteria;

        /**
         * The FHIR query based rules that the server should use to determine when to trigger a notification for this topic.
         */
        @Child(name = "queryCriteria", type = {}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Query based trigger rule", formalDefinition="The FHIR query based rules that the server should use to determine when to trigger a notification for this topic." )
        protected TopicResourceTriggerQueryCriteriaComponent queryCriteria;

        /**
         * The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.
         */
        @Child(name = "fhirPathCriteria", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="FHIRPath based trigger rule", formalDefinition="The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic." )
        protected StringType fhirPathCriteria;

        private static final long serialVersionUID = 191150436L;

    /**
     * Constructor
     */
      public TopicResourceTriggerComponent() {
        super();
      }

        /**
         * @return {@link #description} (The human readable description of what triggers inclusion into this topic -  for example, "Beginning of a clinical encounter".). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerComponent.description");
            else if (Configuration.doAutoCreate())
              this.description = new StringType(); // bb
          return this.description;
        }

        public boolean hasDescriptionElement() { 
          return this.description != null && !this.description.isEmpty();
        }

        public boolean hasDescription() { 
          return this.description != null && !this.description.isEmpty();
        }

        /**
         * @param value {@link #description} (The human readable description of what triggers inclusion into this topic -  for example, "Beginning of a clinical encounter".). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TopicResourceTriggerComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return The human readable description of what triggers inclusion into this topic -  for example, "Beginning of a clinical encounter".
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value The human readable description of what triggers inclusion into this topic -  for example, "Beginning of a clinical encounter".
         */
        public TopicResourceTriggerComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #resourceType} (The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.)
         */
        public List<Enumeration<FHIRType>> getResourceType() { 
          if (this.resourceType == null)
            this.resourceType = new ArrayList<Enumeration<FHIRType>>();
          return this.resourceType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TopicResourceTriggerComponent setResourceType(List<Enumeration<FHIRType>> theResourceType) { 
          this.resourceType = theResourceType;
          return this;
        }

        public boolean hasResourceType() { 
          if (this.resourceType == null)
            return false;
          for (Enumeration<FHIRType> item : this.resourceType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #resourceType} (The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.)
         */
        public Enumeration<FHIRType> addResourceTypeElement() {//2 
          Enumeration<FHIRType> t = new Enumeration<FHIRType>(new FHIRTypeEnumFactory());
          if (this.resourceType == null)
            this.resourceType = new ArrayList<Enumeration<FHIRType>>();
          this.resourceType.add(t);
          return t;
        }

        /**
         * @param value {@link #resourceType} (The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.)
         */
        public TopicResourceTriggerComponent addResourceType(FHIRType value) { //1
          Enumeration<FHIRType> t = new Enumeration<FHIRType>(new FHIRTypeEnumFactory());
          t.setValue(value);
          if (this.resourceType == null)
            this.resourceType = new ArrayList<Enumeration<FHIRType>>();
          this.resourceType.add(t);
          return this;
        }

        /**
         * @param value {@link #resourceType} (The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.)
         */
        public boolean hasResourceType(FHIRType value) { 
          if (this.resourceType == null)
            return false;
          for (Enumeration<FHIRType> v : this.resourceType)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #methodCriteria} (The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public List<Enumeration<MethodCode>> getMethodCriteria() { 
          if (this.methodCriteria == null)
            this.methodCriteria = new ArrayList<Enumeration<MethodCode>>();
          return this.methodCriteria;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TopicResourceTriggerComponent setMethodCriteria(List<Enumeration<MethodCode>> theMethodCriteria) { 
          this.methodCriteria = theMethodCriteria;
          return this;
        }

        public boolean hasMethodCriteria() { 
          if (this.methodCriteria == null)
            return false;
          for (Enumeration<MethodCode> item : this.methodCriteria)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #methodCriteria} (The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public Enumeration<MethodCode> addMethodCriteriaElement() {//2 
          Enumeration<MethodCode> t = new Enumeration<MethodCode>(new MethodCodeEnumFactory());
          if (this.methodCriteria == null)
            this.methodCriteria = new ArrayList<Enumeration<MethodCode>>();
          this.methodCriteria.add(t);
          return t;
        }

        /**
         * @param value {@link #methodCriteria} (The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public TopicResourceTriggerComponent addMethodCriteria(MethodCode value) { //1
          Enumeration<MethodCode> t = new Enumeration<MethodCode>(new MethodCodeEnumFactory());
          t.setValue(value);
          if (this.methodCriteria == null)
            this.methodCriteria = new ArrayList<Enumeration<MethodCode>>();
          this.methodCriteria.add(t);
          return this;
        }

        /**
         * @param value {@link #methodCriteria} (The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public boolean hasMethodCriteria(MethodCode value) { 
          if (this.methodCriteria == null)
            return false;
          for (Enumeration<MethodCode> v : this.methodCriteria)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #queryCriteria} (The FHIR query based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public TopicResourceTriggerQueryCriteriaComponent getQueryCriteria() { 
          if (this.queryCriteria == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerComponent.queryCriteria");
            else if (Configuration.doAutoCreate())
              this.queryCriteria = new TopicResourceTriggerQueryCriteriaComponent(); // cc
          return this.queryCriteria;
        }

        public boolean hasQueryCriteria() { 
          return this.queryCriteria != null && !this.queryCriteria.isEmpty();
        }

        /**
         * @param value {@link #queryCriteria} (The FHIR query based rules that the server should use to determine when to trigger a notification for this topic.)
         */
        public TopicResourceTriggerComponent setQueryCriteria(TopicResourceTriggerQueryCriteriaComponent value) { 
          this.queryCriteria = value;
          return this;
        }

        /**
         * @return {@link #fhirPathCriteria} (The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.). This is the underlying object with id, value and extensions. The accessor "getFhirPathCriteria" gives direct access to the value
         */
        public StringType getFhirPathCriteriaElement() { 
          if (this.fhirPathCriteria == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerComponent.fhirPathCriteria");
            else if (Configuration.doAutoCreate())
              this.fhirPathCriteria = new StringType(); // bb
          return this.fhirPathCriteria;
        }

        public boolean hasFhirPathCriteriaElement() { 
          return this.fhirPathCriteria != null && !this.fhirPathCriteria.isEmpty();
        }

        public boolean hasFhirPathCriteria() { 
          return this.fhirPathCriteria != null && !this.fhirPathCriteria.isEmpty();
        }

        /**
         * @param value {@link #fhirPathCriteria} (The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.). This is the underlying object with id, value and extensions. The accessor "getFhirPathCriteria" gives direct access to the value
         */
        public TopicResourceTriggerComponent setFhirPathCriteriaElement(StringType value) { 
          this.fhirPathCriteria = value;
          return this;
        }

        /**
         * @return The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.
         */
        public String getFhirPathCriteria() { 
          return this.fhirPathCriteria == null ? null : this.fhirPathCriteria.getValue();
        }

        /**
         * @param value The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.
         */
        public TopicResourceTriggerComponent setFhirPathCriteria(String value) { 
          if (Utilities.noString(value))
            this.fhirPathCriteria = null;
          else {
            if (this.fhirPathCriteria == null)
              this.fhirPathCriteria = new StringType();
            this.fhirPathCriteria.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "string", "The human readable description of what triggers inclusion into this topic -  for example, \"Beginning of a clinical encounter\".", 0, 1, description));
          children.add(new Property("resourceType", "code", "The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.", 0, java.lang.Integer.MAX_VALUE, resourceType));
          children.add(new Property("methodCriteria", "code", "The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.", 0, java.lang.Integer.MAX_VALUE, methodCriteria));
          children.add(new Property("queryCriteria", "", "The FHIR query based rules that the server should use to determine when to trigger a notification for this topic.", 0, 1, queryCriteria));
          children.add(new Property("fhirPathCriteria", "string", "The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.", 0, 1, fhirPathCriteria));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "The human readable description of what triggers inclusion into this topic -  for example, \"Beginning of a clinical encounter\".", 0, 1, description);
          case -384364440: /*resourceType*/  return new Property("resourceType", "code", "The list of resource types that are candidates for this topic.  For example, the Encounter resource is updated in an 'admission' topic.", 0, java.lang.Integer.MAX_VALUE, resourceType);
          case -1924160672: /*methodCriteria*/  return new Property("methodCriteria", "code", "The REST interaction based rules that the server should use to determine when to trigger a notification for this topic.", 0, java.lang.Integer.MAX_VALUE, methodCriteria);
          case -545123257: /*queryCriteria*/  return new Property("queryCriteria", "", "The FHIR query based rules that the server should use to determine when to trigger a notification for this topic.", 0, 1, queryCriteria);
          case 1929785263: /*fhirPathCriteria*/  return new Property("fhirPathCriteria", "string", "The FHIRPath based rules that the server should use to determine when to trigger a notification for this topic.", 0, 1, fhirPathCriteria);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -384364440: /*resourceType*/ return this.resourceType == null ? new Base[0] : this.resourceType.toArray(new Base[this.resourceType.size()]); // Enumeration<FHIRType>
        case -1924160672: /*methodCriteria*/ return this.methodCriteria == null ? new Base[0] : this.methodCriteria.toArray(new Base[this.methodCriteria.size()]); // Enumeration<MethodCode>
        case -545123257: /*queryCriteria*/ return this.queryCriteria == null ? new Base[0] : new Base[] {this.queryCriteria}; // TopicResourceTriggerQueryCriteriaComponent
        case 1929785263: /*fhirPathCriteria*/ return this.fhirPathCriteria == null ? new Base[0] : new Base[] {this.fhirPathCriteria}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = castToString(value); // StringType
          return value;
        case -384364440: // resourceType
          value = new FHIRTypeEnumFactory().fromType(castToCode(value));
          this.getResourceType().add((Enumeration) value); // Enumeration<FHIRType>
          return value;
        case -1924160672: // methodCriteria
          value = new MethodCodeEnumFactory().fromType(castToCode(value));
          this.getMethodCriteria().add((Enumeration) value); // Enumeration<MethodCode>
          return value;
        case -545123257: // queryCriteria
          this.queryCriteria = (TopicResourceTriggerQueryCriteriaComponent) value; // TopicResourceTriggerQueryCriteriaComponent
          return value;
        case 1929785263: // fhirPathCriteria
          this.fhirPathCriteria = castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = castToString(value); // StringType
        } else if (name.equals("resourceType")) {
          value = new FHIRTypeEnumFactory().fromType(castToCode(value));
          this.getResourceType().add((Enumeration) value);
        } else if (name.equals("methodCriteria")) {
          value = new MethodCodeEnumFactory().fromType(castToCode(value));
          this.getMethodCriteria().add((Enumeration) value);
        } else if (name.equals("queryCriteria")) {
          this.queryCriteria = (TopicResourceTriggerQueryCriteriaComponent) value; // TopicResourceTriggerQueryCriteriaComponent
        } else if (name.equals("fhirPathCriteria")) {
          this.fhirPathCriteria = castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case -384364440:  return addResourceTypeElement();
        case -1924160672:  return addMethodCriteriaElement();
        case -545123257:  return getQueryCriteria();
        case 1929785263:  return getFhirPathCriteriaElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case -384364440: /*resourceType*/ return new String[] {"code"};
        case -1924160672: /*methodCriteria*/ return new String[] {"code"};
        case -545123257: /*queryCriteria*/ return new String[] {};
        case 1929785263: /*fhirPathCriteria*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.description");
        }
        else if (name.equals("resourceType")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.resourceType");
        }
        else if (name.equals("methodCriteria")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.methodCriteria");
        }
        else if (name.equals("queryCriteria")) {
          this.queryCriteria = new TopicResourceTriggerQueryCriteriaComponent();
          return this.queryCriteria;
        }
        else if (name.equals("fhirPathCriteria")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.fhirPathCriteria");
        }
        else
          return super.addChild(name);
      }

      public TopicResourceTriggerComponent copy() {
        TopicResourceTriggerComponent dst = new TopicResourceTriggerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TopicResourceTriggerComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (resourceType != null) {
          dst.resourceType = new ArrayList<Enumeration<FHIRType>>();
          for (Enumeration<FHIRType> i : resourceType)
            dst.resourceType.add(i.copy());
        };
        if (methodCriteria != null) {
          dst.methodCriteria = new ArrayList<Enumeration<MethodCode>>();
          for (Enumeration<MethodCode> i : methodCriteria)
            dst.methodCriteria.add(i.copy());
        };
        dst.queryCriteria = queryCriteria == null ? null : queryCriteria.copy();
        dst.fhirPathCriteria = fhirPathCriteria == null ? null : fhirPathCriteria.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TopicResourceTriggerComponent))
          return false;
        TopicResourceTriggerComponent o = (TopicResourceTriggerComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(resourceType, o.resourceType, true)
           && compareDeep(methodCriteria, o.methodCriteria, true) && compareDeep(queryCriteria, o.queryCriteria, true)
           && compareDeep(fhirPathCriteria, o.fhirPathCriteria, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TopicResourceTriggerComponent))
          return false;
        TopicResourceTriggerComponent o = (TopicResourceTriggerComponent) other_;
        return compareValues(description, o.description, true) && compareValues(resourceType, o.resourceType, true)
           && compareValues(methodCriteria, o.methodCriteria, true) && compareValues(fhirPathCriteria, o.fhirPathCriteria, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, resourceType
          , methodCriteria, queryCriteria, fhirPathCriteria);
      }

  public String fhirType() {
    return "Topic.resourceTrigger";

  }

  }

    @Block()
    public static class TopicResourceTriggerQueryCriteriaComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The FHIR query based rules are applied to the previous resource state.
         */
        @Child(name = "previous", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Rule applied to previous resource state", formalDefinition="The FHIR query based rules are applied to the previous resource state." )
        protected StringType previous;

        /**
         * The FHIR query based rules are applied to the current resource state.
         */
        @Child(name = "current", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Rule applied to current resource state", formalDefinition="The FHIR query based rules are applied to the current resource state." )
        protected StringType current;

        /**
         * If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.
         */
        @Child(name = "requireBoth", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Both must be true flag", formalDefinition="If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true." )
        protected BooleanType requireBoth;

        private static final long serialVersionUID = -1611265114L;

    /**
     * Constructor
     */
      public TopicResourceTriggerQueryCriteriaComponent() {
        super();
      }

        /**
         * @return {@link #previous} (The FHIR query based rules are applied to the previous resource state.). This is the underlying object with id, value and extensions. The accessor "getPrevious" gives direct access to the value
         */
        public StringType getPreviousElement() { 
          if (this.previous == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerQueryCriteriaComponent.previous");
            else if (Configuration.doAutoCreate())
              this.previous = new StringType(); // bb
          return this.previous;
        }

        public boolean hasPreviousElement() { 
          return this.previous != null && !this.previous.isEmpty();
        }

        public boolean hasPrevious() { 
          return this.previous != null && !this.previous.isEmpty();
        }

        /**
         * @param value {@link #previous} (The FHIR query based rules are applied to the previous resource state.). This is the underlying object with id, value and extensions. The accessor "getPrevious" gives direct access to the value
         */
        public TopicResourceTriggerQueryCriteriaComponent setPreviousElement(StringType value) { 
          this.previous = value;
          return this;
        }

        /**
         * @return The FHIR query based rules are applied to the previous resource state.
         */
        public String getPrevious() { 
          return this.previous == null ? null : this.previous.getValue();
        }

        /**
         * @param value The FHIR query based rules are applied to the previous resource state.
         */
        public TopicResourceTriggerQueryCriteriaComponent setPrevious(String value) { 
          if (Utilities.noString(value))
            this.previous = null;
          else {
            if (this.previous == null)
              this.previous = new StringType();
            this.previous.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #current} (The FHIR query based rules are applied to the current resource state.). This is the underlying object with id, value and extensions. The accessor "getCurrent" gives direct access to the value
         */
        public StringType getCurrentElement() { 
          if (this.current == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerQueryCriteriaComponent.current");
            else if (Configuration.doAutoCreate())
              this.current = new StringType(); // bb
          return this.current;
        }

        public boolean hasCurrentElement() { 
          return this.current != null && !this.current.isEmpty();
        }

        public boolean hasCurrent() { 
          return this.current != null && !this.current.isEmpty();
        }

        /**
         * @param value {@link #current} (The FHIR query based rules are applied to the current resource state.). This is the underlying object with id, value and extensions. The accessor "getCurrent" gives direct access to the value
         */
        public TopicResourceTriggerQueryCriteriaComponent setCurrentElement(StringType value) { 
          this.current = value;
          return this;
        }

        /**
         * @return The FHIR query based rules are applied to the current resource state.
         */
        public String getCurrent() { 
          return this.current == null ? null : this.current.getValue();
        }

        /**
         * @param value The FHIR query based rules are applied to the current resource state.
         */
        public TopicResourceTriggerQueryCriteriaComponent setCurrent(String value) { 
          if (Utilities.noString(value))
            this.current = null;
          else {
            if (this.current == null)
              this.current = new StringType();
            this.current.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #requireBoth} (If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.). This is the underlying object with id, value and extensions. The accessor "getRequireBoth" gives direct access to the value
         */
        public BooleanType getRequireBothElement() { 
          if (this.requireBoth == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicResourceTriggerQueryCriteriaComponent.requireBoth");
            else if (Configuration.doAutoCreate())
              this.requireBoth = new BooleanType(); // bb
          return this.requireBoth;
        }

        public boolean hasRequireBothElement() { 
          return this.requireBoth != null && !this.requireBoth.isEmpty();
        }

        public boolean hasRequireBoth() { 
          return this.requireBoth != null && !this.requireBoth.isEmpty();
        }

        /**
         * @param value {@link #requireBoth} (If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.). This is the underlying object with id, value and extensions. The accessor "getRequireBoth" gives direct access to the value
         */
        public TopicResourceTriggerQueryCriteriaComponent setRequireBothElement(BooleanType value) { 
          this.requireBoth = value;
          return this;
        }

        /**
         * @return If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.
         */
        public boolean getRequireBoth() { 
          return this.requireBoth == null || this.requireBoth.isEmpty() ? false : this.requireBoth.getValue();
        }

        /**
         * @param value If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.
         */
        public TopicResourceTriggerQueryCriteriaComponent setRequireBoth(boolean value) { 
            if (this.requireBoth == null)
              this.requireBoth = new BooleanType();
            this.requireBoth.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("previous", "string", "The FHIR query based rules are applied to the previous resource state.", 0, 1, previous));
          children.add(new Property("current", "string", "The FHIR query based rules are applied to the current resource state.", 0, 1, current));
          children.add(new Property("requireBoth", "boolean", "If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.", 0, 1, requireBoth));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1273775369: /*previous*/  return new Property("previous", "string", "The FHIR query based rules are applied to the previous resource state.", 0, 1, previous);
          case 1126940025: /*current*/  return new Property("current", "string", "The FHIR query based rules are applied to the current resource state.", 0, 1, current);
          case 362116742: /*requireBoth*/  return new Property("requireBoth", "boolean", "If set to true, both current and previous criteria must evaluate true to  trigger a notification for this topic.  Otherwise a notification for this topic will be triggered if either one evaluates to true.", 0, 1, requireBoth);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1273775369: /*previous*/ return this.previous == null ? new Base[0] : new Base[] {this.previous}; // StringType
        case 1126940025: /*current*/ return this.current == null ? new Base[0] : new Base[] {this.current}; // StringType
        case 362116742: /*requireBoth*/ return this.requireBoth == null ? new Base[0] : new Base[] {this.requireBoth}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1273775369: // previous
          this.previous = castToString(value); // StringType
          return value;
        case 1126940025: // current
          this.current = castToString(value); // StringType
          return value;
        case 362116742: // requireBoth
          this.requireBoth = castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("previous")) {
          this.previous = castToString(value); // StringType
        } else if (name.equals("current")) {
          this.current = castToString(value); // StringType
        } else if (name.equals("requireBoth")) {
          this.requireBoth = castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1273775369:  return getPreviousElement();
        case 1126940025:  return getCurrentElement();
        case 362116742:  return getRequireBothElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1273775369: /*previous*/ return new String[] {"string"};
        case 1126940025: /*current*/ return new String[] {"string"};
        case 362116742: /*requireBoth*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("previous")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.previous");
        }
        else if (name.equals("current")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.current");
        }
        else if (name.equals("requireBoth")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.requireBoth");
        }
        else
          return super.addChild(name);
      }

      public TopicResourceTriggerQueryCriteriaComponent copy() {
        TopicResourceTriggerQueryCriteriaComponent dst = new TopicResourceTriggerQueryCriteriaComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TopicResourceTriggerQueryCriteriaComponent dst) {
        super.copyValues(dst);
        dst.previous = previous == null ? null : previous.copy();
        dst.current = current == null ? null : current.copy();
        dst.requireBoth = requireBoth == null ? null : requireBoth.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TopicResourceTriggerQueryCriteriaComponent))
          return false;
        TopicResourceTriggerQueryCriteriaComponent o = (TopicResourceTriggerQueryCriteriaComponent) other_;
        return compareDeep(previous, o.previous, true) && compareDeep(current, o.current, true) && compareDeep(requireBoth, o.requireBoth, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TopicResourceTriggerQueryCriteriaComponent))
          return false;
        TopicResourceTriggerQueryCriteriaComponent o = (TopicResourceTriggerQueryCriteriaComponent) other_;
        return compareValues(previous, o.previous, true) && compareValues(current, o.current, true) && compareValues(requireBoth, o.requireBoth, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(previous, current, requireBoth
          );
      }

  public String fhirType() {
    return "Topic.resourceTrigger.queryCriteria";

  }

  }

    @Block()
    public static class TopicCanFilterByComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A search parameter (like "patient") which is a label for the filter.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Search parameter that serves as filter key", formalDefinition="A search parameter (like \"patient\") which is a label for the filter." )
        protected StringType name;

        /**
         * Allowable operators to apply when determining matches (Search Modifiers).
         */
        @Child(name = "matchType", type = {CodeType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="= | in | not-in | above | below", formalDefinition="Allowable operators to apply when determining matches (Search Modifiers)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/topic-match-operator")
        protected List<Enumeration<TopicFilterByMatchType>> matchType;

        /**
         * Description of how this filter parameter is intended to be used.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Description of this filter parameter", formalDefinition="Description of how this filter parameter is intended to be used." )
        protected MarkdownType documentation;

        private static final long serialVersionUID = -9356414L;

    /**
     * Constructor
     */
      public TopicCanFilterByComponent() {
        super();
      }

        /**
         * @return {@link #name} (A search parameter (like "patient") which is a label for the filter.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicCanFilterByComponent.name");
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
         * @param value {@link #name} (A search parameter (like "patient") which is a label for the filter.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public TopicCanFilterByComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return A search parameter (like "patient") which is a label for the filter.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value A search parameter (like "patient") which is a label for the filter.
         */
        public TopicCanFilterByComponent setName(String value) { 
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
         * @return {@link #matchType} (Allowable operators to apply when determining matches (Search Modifiers).)
         */
        public List<Enumeration<TopicFilterByMatchType>> getMatchType() { 
          if (this.matchType == null)
            this.matchType = new ArrayList<Enumeration<TopicFilterByMatchType>>();
          return this.matchType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TopicCanFilterByComponent setMatchType(List<Enumeration<TopicFilterByMatchType>> theMatchType) { 
          this.matchType = theMatchType;
          return this;
        }

        public boolean hasMatchType() { 
          if (this.matchType == null)
            return false;
          for (Enumeration<TopicFilterByMatchType> item : this.matchType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #matchType} (Allowable operators to apply when determining matches (Search Modifiers).)
         */
        public Enumeration<TopicFilterByMatchType> addMatchTypeElement() {//2 
          Enumeration<TopicFilterByMatchType> t = new Enumeration<TopicFilterByMatchType>(new TopicFilterByMatchTypeEnumFactory());
          if (this.matchType == null)
            this.matchType = new ArrayList<Enumeration<TopicFilterByMatchType>>();
          this.matchType.add(t);
          return t;
        }

        /**
         * @param value {@link #matchType} (Allowable operators to apply when determining matches (Search Modifiers).)
         */
        public TopicCanFilterByComponent addMatchType(TopicFilterByMatchType value) { //1
          Enumeration<TopicFilterByMatchType> t = new Enumeration<TopicFilterByMatchType>(new TopicFilterByMatchTypeEnumFactory());
          t.setValue(value);
          if (this.matchType == null)
            this.matchType = new ArrayList<Enumeration<TopicFilterByMatchType>>();
          this.matchType.add(t);
          return this;
        }

        /**
         * @param value {@link #matchType} (Allowable operators to apply when determining matches (Search Modifiers).)
         */
        public boolean hasMatchType(TopicFilterByMatchType value) { 
          if (this.matchType == null)
            return false;
          for (Enumeration<TopicFilterByMatchType> v : this.matchType)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #documentation} (Description of how this filter parameter is intended to be used.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TopicCanFilterByComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Description of how this filter parameter is intended to be used.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public TopicCanFilterByComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Description of how this filter parameter is intended to be used.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Description of how this filter parameter is intended to be used.
         */
        public TopicCanFilterByComponent setDocumentation(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "A search parameter (like \"patient\") which is a label for the filter.", 0, 1, name));
          children.add(new Property("matchType", "code", "Allowable operators to apply when determining matches (Search Modifiers).", 0, java.lang.Integer.MAX_VALUE, matchType));
          children.add(new Property("documentation", "markdown", "Description of how this filter parameter is intended to be used.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "A search parameter (like \"patient\") which is a label for the filter.", 0, 1, name);
          case 614036127: /*matchType*/  return new Property("matchType", "code", "Allowable operators to apply when determining matches (Search Modifiers).", 0, java.lang.Integer.MAX_VALUE, matchType);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Description of how this filter parameter is intended to be used.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 614036127: /*matchType*/ return this.matchType == null ? new Base[0] : this.matchType.toArray(new Base[this.matchType.size()]); // Enumeration<TopicFilterByMatchType>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = castToString(value); // StringType
          return value;
        case 614036127: // matchType
          value = new TopicFilterByMatchTypeEnumFactory().fromType(castToCode(value));
          this.getMatchType().add((Enumeration) value); // Enumeration<TopicFilterByMatchType>
          return value;
        case 1587405498: // documentation
          this.documentation = castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = castToString(value); // StringType
        } else if (name.equals("matchType")) {
          value = new TopicFilterByMatchTypeEnumFactory().fromType(castToCode(value));
          this.getMatchType().add((Enumeration) value);
        } else if (name.equals("documentation")) {
          this.documentation = castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 614036127:  return addMatchTypeElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 614036127: /*matchType*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.name");
        }
        else if (name.equals("matchType")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.matchType");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.documentation");
        }
        else
          return super.addChild(name);
      }

      public TopicCanFilterByComponent copy() {
        TopicCanFilterByComponent dst = new TopicCanFilterByComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TopicCanFilterByComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        if (matchType != null) {
          dst.matchType = new ArrayList<Enumeration<TopicFilterByMatchType>>();
          for (Enumeration<TopicFilterByMatchType> i : matchType)
            dst.matchType.add(i.copy());
        };
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TopicCanFilterByComponent))
          return false;
        TopicCanFilterByComponent o = (TopicCanFilterByComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(matchType, o.matchType, true) && compareDeep(documentation, o.documentation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TopicCanFilterByComponent))
          return false;
        TopicCanFilterByComponent o = (TopicCanFilterByComponent) other_;
        return compareValues(name, o.name, true) && compareValues(matchType, o.matchType, true) && compareValues(documentation, o.documentation, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, matchType, documentation
          );
      }

  public String fhirType() {
    return "Topic.canFilterBy";

  }

  }

    /**
     * An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Logical canonical URL to reference this Topic (globally unique)", formalDefinition="An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions)." )
    protected UriType url;

    /**
     * Business identifiers assigned to this Topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business Identifier for Topic", formalDefinition="Business identifiers assigned to this Topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the Topic", formalDefinition="The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable." )
    protected StringType version;

    /**
     * A short, descriptive, user-friendly title for the Topic, for example, "admission".
     */
    @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this Topic (Human friendly)", formalDefinition="A short, descriptive, user-friendly title for the Topic, for example, \"admission\"." )
    protected StringType title;

    /**
     * The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.
     */
    @Child(name = "derivedFromCanonical", type = {CanonicalType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Based on FHIR protocol or definition", formalDefinition="The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic." )
    protected List<CanonicalType> derivedFromCanonical;

    /**
     * The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.
     */
    @Child(name = "derivedFromUri", type = {UriType.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Based on external protocol or definition", formalDefinition="The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition." )
    protected List<UriType> derivedFromUri;

    /**
     * The current state of the Topic.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The current state of the Topic." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=7, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="If for testing purposes, not real usage", formalDefinition="A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date status first applied", formalDefinition="For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal." )
    protected DateTimeType date;

    /**
     * Helps establish the "authority/credibility" of the Topic.  May also allow for contact.
     */
    @Child(name = "publisher", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The name of the individual or organization that published the Topic", formalDefinition="Helps establish the \"authority/credibility\" of the Topic.  May also allow for contact." )
    protected Reference publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the Topic from the consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the Topic", formalDefinition="A free text natural language description of the Topic from the consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Content intends to support these contexts", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions." )
    protected List<UsageContext> useContext;

    /**
     * A jurisdiction in which the Topic is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for Topic (if applicable)", formalDefinition="A jurisdiction in which the Topic is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explains why this Topic is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this Topic is defined", formalDefinition="Explains why this Topic is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic." )
    protected MarkdownType copyright;

    /**
     * The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When Topic approved by publisher", formalDefinition="The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Last review date for the Topic", formalDefinition="The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the Topic content was or is planned to be effective.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The effective date range for the Topic", formalDefinition="The period during which the Topic content was or is planned to be effective." )
    protected Period effectivePeriod;

    /**
     * The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression.
     */
    @Child(name = "resourceTrigger", type = {}, order=19, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Criteria for including a resource update in the topic", formalDefinition="The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression." )
    protected TopicResourceTriggerComponent resourceTrigger;

    /**
     * List of properties by which messages on the topic can be filtered.
     */
    @Child(name = "canFilterBy", type = {}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Properties by which the topic can be filtered", formalDefinition="List of properties by which messages on the topic can be filtered." )
    protected List<TopicCanFilterByComponent> canFilterBy;

    private static final long serialVersionUID = -1683916811L;

  /**
   * Constructor
   */
    public Topic() {
      super();
    }

  /**
   * Constructor
   */
    public Topic(Enumeration<PublicationStatus> status) {
      super();
      this.status = status;
    }

    /**
     * @return {@link #url} (An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.url");
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
     * @param value {@link #url} (An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Topic setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).
     */
    public Topic setUrl(String value) { 
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
     * @return {@link #identifier} (Business identifiers assigned to this Topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Topic setIdentifier(List<Identifier> theIdentifier) { 
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

    public Topic addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #version} (The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Topic setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public Topic setVersion(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the Topic, for example, "admission".). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the Topic, for example, "admission".). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public Topic setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the Topic, for example, "admission".
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the Topic, for example, "admission".
     */
    public Topic setTitle(String value) { 
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
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.)
     */
    public List<CanonicalType> getDerivedFromCanonical() { 
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      return this.derivedFromCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Topic setDerivedFromCanonical(List<CanonicalType> theDerivedFromCanonical) { 
      this.derivedFromCanonical = theDerivedFromCanonical;
      return this;
    }

    public boolean hasDerivedFromCanonical() { 
      if (this.derivedFromCanonical == null)
        return false;
      for (CanonicalType item : this.derivedFromCanonical)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.)
     */
    public CanonicalType addDerivedFromCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      this.derivedFromCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.)
     */
    public Topic addDerivedFromCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      this.derivedFromCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.)
     */
    public boolean hasDerivedFromCanonical(String value) { 
      if (this.derivedFromCanonical == null)
        return false;
      for (CanonicalType v : this.derivedFromCanonical)
        if (v.getValue().equals(value)) // canonical(Topic)
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.)
     */
    public List<UriType> getDerivedFromUri() { 
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      return this.derivedFromUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Topic setDerivedFromUri(List<UriType> theDerivedFromUri) { 
      this.derivedFromUri = theDerivedFromUri;
      return this;
    }

    public boolean hasDerivedFromUri() { 
      if (this.derivedFromUri == null)
        return false;
      for (UriType item : this.derivedFromUri)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.)
     */
    public UriType addDerivedFromUriElement() {//2 
      UriType t = new UriType();
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      this.derivedFromUri.add(t);
      return t;
    }

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.)
     */
    public Topic addDerivedFromUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      this.derivedFromUri.add(t);
      return this;
    }

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.)
     */
    public boolean hasDerivedFromUri(String value) { 
      if (this.derivedFromUri == null)
        return false;
      for (UriType v : this.derivedFromUri)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #status} (The current state of the Topic.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.status");
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
     * @param value {@link #status} (The current state of the Topic.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Topic setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the Topic.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the Topic.
     */
    public Topic setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.experimental");
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
     * @param value {@link #experimental} (A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public Topic setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public Topic setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.date");
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
     * @param value {@link #date} (For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public Topic setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    public Topic setDate(Date value) { 
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
     * @return {@link #publisher} (Helps establish the "authority/credibility" of the Topic.  May also allow for contact.)
     */
    public Reference getPublisher() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.publisher");
        else if (Configuration.doAutoCreate())
          this.publisher = new Reference(); // cc
      return this.publisher;
    }

    public boolean hasPublisher() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    /**
     * @param value {@link #publisher} (Helps establish the "authority/credibility" of the Topic.  May also allow for contact.)
     */
    public Topic setPublisher(Reference value) { 
      this.publisher = value;
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
    public Topic setContact(List<ContactDetail> theContact) { 
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

    public Topic addContact(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist
     */
    public ContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #description} (A free text natural language description of the Topic from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.description");
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
     * @param value {@link #description} (A free text natural language description of the Topic from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Topic setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the Topic from the consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the Topic from the consumer's perspective.
     */
    public Topic setDescription(String value) { 
      if (value == null)
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Topic setUseContext(List<UsageContext> theUseContext) { 
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

    public Topic addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #jurisdiction} (A jurisdiction in which the Topic is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Topic setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public Topic addJurisdiction(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      if (getJurisdiction().isEmpty()) {
        addJurisdiction();
      }
      return getJurisdiction().get(0);
    }

    /**
     * @return {@link #purpose} (Explains why this Topic is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.purpose");
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
     * @param value {@link #purpose} (Explains why this Topic is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public Topic setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explains why this Topic is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explains why this Topic is needed and why it has been designed as it has.
     */
    public Topic setPurpose(String value) { 
      if (value == null)
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new MarkdownType();
        this.purpose.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public Topic setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.
     */
    public Topic setCopyright(String value) { 
      if (value == null)
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.approvalDate");
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
     * @param value {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public Topic setApprovalDateElement(DateType value) { 
      this.approvalDate = value;
      return this;
    }

    /**
     * @return The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate() { 
      return this.approvalDate == null ? null : this.approvalDate.getValue();
    }

    /**
     * @param value The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Topic setApprovalDate(Date value) { 
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
     * @return {@link #lastReviewDate} (The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      if (this.lastReviewDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.lastReviewDate");
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
     * @param value {@link #lastReviewDate} (The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public Topic setLastReviewDateElement(DateType value) { 
      this.lastReviewDate = value;
      return this;
    }

    /**
     * @return The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    public Date getLastReviewDate() { 
      return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
    }

    /**
     * @param value The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    public Topic setLastReviewDate(Date value) { 
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
     * @return {@link #effectivePeriod} (The period during which the Topic content was or is planned to be effective.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the Topic content was or is planned to be effective.)
     */
    public Topic setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #resourceTrigger} (The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression.)
     */
    public TopicResourceTriggerComponent getResourceTrigger() { 
      if (this.resourceTrigger == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Topic.resourceTrigger");
        else if (Configuration.doAutoCreate())
          this.resourceTrigger = new TopicResourceTriggerComponent(); // cc
      return this.resourceTrigger;
    }

    public boolean hasResourceTrigger() { 
      return this.resourceTrigger != null && !this.resourceTrigger.isEmpty();
    }

    /**
     * @param value {@link #resourceTrigger} (The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression.)
     */
    public Topic setResourceTrigger(TopicResourceTriggerComponent value) { 
      this.resourceTrigger = value;
      return this;
    }

    /**
     * @return {@link #canFilterBy} (List of properties by which messages on the topic can be filtered.)
     */
    public List<TopicCanFilterByComponent> getCanFilterBy() { 
      if (this.canFilterBy == null)
        this.canFilterBy = new ArrayList<TopicCanFilterByComponent>();
      return this.canFilterBy;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Topic setCanFilterBy(List<TopicCanFilterByComponent> theCanFilterBy) { 
      this.canFilterBy = theCanFilterBy;
      return this;
    }

    public boolean hasCanFilterBy() { 
      if (this.canFilterBy == null)
        return false;
      for (TopicCanFilterByComponent item : this.canFilterBy)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TopicCanFilterByComponent addCanFilterBy() { //3
      TopicCanFilterByComponent t = new TopicCanFilterByComponent();
      if (this.canFilterBy == null)
        this.canFilterBy = new ArrayList<TopicCanFilterByComponent>();
      this.canFilterBy.add(t);
      return t;
    }

    public Topic addCanFilterBy(TopicCanFilterByComponent t) { //3
      if (t == null)
        return this;
      if (this.canFilterBy == null)
        this.canFilterBy = new ArrayList<TopicCanFilterByComponent>();
      this.canFilterBy.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #canFilterBy}, creating it if it does not already exist
     */
    public TopicCanFilterByComponent getCanFilterByFirstRep() { 
      if (getCanFilterBy().isEmpty()) {
        addCanFilterBy();
      }
      return getCanFilterBy().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this Topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.", 0, 1, version));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the Topic, for example, \"admission\".", 0, 1, title));
        children.add(new Property("derivedFromCanonical", "canonical(Topic)", "The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.", 0, java.lang.Integer.MAX_VALUE, derivedFromCanonical));
        children.add(new Property("derivedFromUri", "uri", "The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromUri));
        children.add(new Property("status", "code", "The current state of the Topic.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.", 0, 1, date));
        children.add(new Property("publisher", "Reference(Practitioner|PractitionerRole|Organization)", "Helps establish the \"authority/credibility\" of the Topic.  May also allow for contact.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the Topic from the consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A jurisdiction in which the Topic is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explains why this Topic is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.", 0, 1, copyright));
        children.add(new Property("approvalDate", "date", "The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the Topic content was or is planned to be effective.", 0, 1, effectivePeriod));
        children.add(new Property("resourceTrigger", "", "The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression.", 0, 1, resourceTrigger));
        children.add(new Property("canFilterBy", "", "List of properties by which messages on the topic can be filtered.", 0, java.lang.Integer.MAX_VALUE, canFilterBy));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URL that is used to identify this Topic when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this Topic is (or will be) published. The URL SHOULD include the major version of the Topic. For more information see [Technical and Business Versions](resource.html#versions).", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this Topic by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the Topic when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the Topic author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.", 0, 1, version);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the Topic, for example, \"admission\".", 0, 1, title);
        case -978133683: /*derivedFromCanonical*/  return new Property("derivedFromCanonical", "canonical(Topic)", "The canonical URL pointing to another FHIR-defined Topic that is adhered to in whole or in part by this Topic.", 0, java.lang.Integer.MAX_VALUE, derivedFromCanonical);
        case -1076333435: /*derivedFromUri*/  return new Property("derivedFromUri", "uri", "The URL pointing to an externally-defined subscription topic or other definition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromUri);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the Topic.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A flag to indicate that this Topic is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "Reference(Practitioner|PractitionerRole|Organization)", "Helps establish the \"authority/credibility\" of the Topic.  May also allow for contact.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the Topic from the consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A jurisdiction in which the Topic is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explains why this Topic is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the Topic and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Topic.", 0, 1, copyright);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the Topic content was or is planned to be effective.", 0, 1, effectivePeriod);
        case -424927798: /*resourceTrigger*/  return new Property("resourceTrigger", "", "The criteria for including updates to a nominated resource in the topic.  Thie criteria may be just a human readable description and/or a full FHIR search string or FHIRPath expression.", 0, 1, resourceTrigger);
        case -1299519009: /*canFilterBy*/  return new Property("canFilterBy", "", "List of properties by which messages on the topic can be filtered.", 0, java.lang.Integer.MAX_VALUE, canFilterBy);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -978133683: /*derivedFromCanonical*/ return this.derivedFromCanonical == null ? new Base[0] : this.derivedFromCanonical.toArray(new Base[this.derivedFromCanonical.size()]); // CanonicalType
        case -1076333435: /*derivedFromUri*/ return this.derivedFromUri == null ? new Base[0] : this.derivedFromUri.toArray(new Base[this.derivedFromUri.size()]); // UriType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // Reference
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case -424927798: /*resourceTrigger*/ return this.resourceTrigger == null ? new Base[0] : new Base[] {this.resourceTrigger}; // TopicResourceTriggerComponent
        case -1299519009: /*canFilterBy*/ return this.canFilterBy == null ? new Base[0] : this.canFilterBy.toArray(new Base[this.canFilterBy.size()]); // TopicCanFilterByComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = castToUri(value); // UriType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(castToIdentifier(value)); // Identifier
          return value;
        case 351608024: // version
          this.version = castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = castToString(value); // StringType
          return value;
        case -978133683: // derivedFromCanonical
          this.getDerivedFromCanonical().add(castToCanonical(value)); // CanonicalType
          return value;
        case -1076333435: // derivedFromUri
          this.getDerivedFromUri().add(castToUri(value)); // UriType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -404562712: // experimental
          this.experimental = castToBoolean(value); // BooleanType
          return value;
        case 3076014: // date
          this.date = castToDateTime(value); // DateTimeType
          return value;
        case 1447404028: // publisher
          this.publisher = castToReference(value); // Reference
          return value;
        case 951526432: // contact
          this.getContact().add(castToContactDetail(value)); // ContactDetail
          return value;
        case -1724546052: // description
          this.description = castToMarkdown(value); // MarkdownType
          return value;
        case -669707736: // useContext
          this.getUseContext().add(castToUsageContext(value)); // UsageContext
          return value;
        case -507075711: // jurisdiction
          this.getJurisdiction().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -220463842: // purpose
          this.purpose = castToMarkdown(value); // MarkdownType
          return value;
        case 1522889671: // copyright
          this.copyright = castToMarkdown(value); // MarkdownType
          return value;
        case 223539345: // approvalDate
          this.approvalDate = castToDate(value); // DateType
          return value;
        case -1687512484: // lastReviewDate
          this.lastReviewDate = castToDate(value); // DateType
          return value;
        case -403934648: // effectivePeriod
          this.effectivePeriod = castToPeriod(value); // Period
          return value;
        case -424927798: // resourceTrigger
          this.resourceTrigger = (TopicResourceTriggerComponent) value; // TopicResourceTriggerComponent
          return value;
        case -1299519009: // canFilterBy
          this.getCanFilterBy().add((TopicCanFilterByComponent) value); // TopicCanFilterByComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = castToUri(value); // UriType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(castToIdentifier(value));
        } else if (name.equals("version")) {
          this.version = castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = castToString(value); // StringType
        } else if (name.equals("derivedFromCanonical")) {
          this.getDerivedFromCanonical().add(castToCanonical(value));
        } else if (name.equals("derivedFromUri")) {
          this.getDerivedFromUri().add(castToUri(value));
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = castToBoolean(value); // BooleanType
        } else if (name.equals("date")) {
          this.date = castToDateTime(value); // DateTimeType
        } else if (name.equals("publisher")) {
          this.publisher = castToReference(value); // Reference
        } else if (name.equals("contact")) {
          this.getContact().add(castToContactDetail(value));
        } else if (name.equals("description")) {
          this.description = castToMarkdown(value); // MarkdownType
        } else if (name.equals("useContext")) {
          this.getUseContext().add(castToUsageContext(value));
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.purpose = castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyright")) {
          this.copyright = castToMarkdown(value); // MarkdownType
        } else if (name.equals("approvalDate")) {
          this.approvalDate = castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = castToDate(value); // DateType
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = castToPeriod(value); // Period
        } else if (name.equals("resourceTrigger")) {
          this.resourceTrigger = (TopicResourceTriggerComponent) value; // TopicResourceTriggerComponent
        } else if (name.equals("canFilterBy")) {
          this.getCanFilterBy().add((TopicCanFilterByComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case 110371416:  return getTitleElement();
        case -978133683:  return addDerivedFromCanonicalElement();
        case -1076333435:  return addDerivedFromUriElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisher();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case -424927798:  return getResourceTrigger();
        case -1299519009:  return addCanFilterBy(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -978133683: /*derivedFromCanonical*/ return new String[] {"canonical"};
        case -1076333435: /*derivedFromUri*/ return new String[] {"uri"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"Reference"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case -424927798: /*resourceTrigger*/ return new String[] {};
        case -1299519009: /*canFilterBy*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.version");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.title");
        }
        else if (name.equals("derivedFromCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.derivedFromCanonical");
        }
        else if (name.equals("derivedFromUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.derivedFromUri");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.date");
        }
        else if (name.equals("publisher")) {
          this.publisher = new Reference();
          return this.publisher;
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.copyright");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Topic.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("resourceTrigger")) {
          this.resourceTrigger = new TopicResourceTriggerComponent();
          return this.resourceTrigger;
        }
        else if (name.equals("canFilterBy")) {
          return addCanFilterBy();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Topic";

  }

      public Topic copy() {
        Topic dst = new Topic();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Topic dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.title = title == null ? null : title.copy();
        if (derivedFromCanonical != null) {
          dst.derivedFromCanonical = new ArrayList<CanonicalType>();
          for (CanonicalType i : derivedFromCanonical)
            dst.derivedFromCanonical.add(i.copy());
        };
        if (derivedFromUri != null) {
          dst.derivedFromUri = new ArrayList<UriType>();
          for (UriType i : derivedFromUri)
            dst.derivedFromUri.add(i.copy());
        };
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
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        dst.resourceTrigger = resourceTrigger == null ? null : resourceTrigger.copy();
        if (canFilterBy != null) {
          dst.canFilterBy = new ArrayList<TopicCanFilterByComponent>();
          for (TopicCanFilterByComponent i : canFilterBy)
            dst.canFilterBy.add(i.copy());
        };
      }

      protected Topic typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Topic))
          return false;
        Topic o = (Topic) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(title, o.title, true) && compareDeep(derivedFromCanonical, o.derivedFromCanonical, true)
           && compareDeep(derivedFromUri, o.derivedFromUri, true) && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true)
           && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true)
           && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(approvalDate, o.approvalDate, true) && compareDeep(lastReviewDate, o.lastReviewDate, true)
           && compareDeep(effectivePeriod, o.effectivePeriod, true) && compareDeep(resourceTrigger, o.resourceTrigger, true)
           && compareDeep(canFilterBy, o.canFilterBy, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Topic))
          return false;
        Topic o = (Topic) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(title, o.title, true)
           && compareValues(derivedFromUri, o.derivedFromUri, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(description, o.description, true) && compareValues(purpose, o.purpose, true)
           && compareValues(copyright, o.copyright, true) && compareValues(approvalDate, o.approvalDate, true)
           && compareValues(lastReviewDate, o.lastReviewDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , title, derivedFromCanonical, derivedFromUri, status, experimental, date, publisher
          , contact, description, useContext, jurisdiction, purpose, copyright, approvalDate
          , lastReviewDate, effectivePeriod, resourceTrigger, canFilterBy);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Topic;
   }

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Date status first applied</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Topic.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="Topic.date", description="Date status first applied", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Date status first applied</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Topic.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business Identifier for Topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Topic.identifier", description="Business Identifier for Topic", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business Identifier for Topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>The name of the individual or organization that published the Topic</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Topic.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="Topic.publisher", description="The name of the individual or organization that published the Topic", type="reference", target={Organization.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>The name of the individual or organization that published the Topic</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Topic.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PUBLISHER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Topic:publisher</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PUBLISHER = new ca.uhn.fhir.model.api.Include("Topic:publisher").toLocked();

 /**
   * Search parameter: <b>resource-type</b>
   * <p>
   * Description: <b>Candidate types for this topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.resourceTrigger.resourceType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="resource-type", path="Topic.resourceTrigger.resourceType", description="Candidate types for this topic", type="token" )
  public static final String SP_RESOURCE_TYPE = "resource-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>resource-type</b>
   * <p>
   * Description: <b>Candidate types for this topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.resourceTrigger.resourceType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam RESOURCE_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_RESOURCE_TYPE);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>Name for this Topic (Human friendly)</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Topic.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="Topic.title", description="Name for this Topic (Human friendly)", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>Name for this Topic (Human friendly)</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Topic.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>Business version of the Topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="Topic.version", description="Business version of the Topic", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>Business version of the Topic</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>Logical canonical URL to reference this Topic (globally unique)</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Topic.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="Topic.url", description="Logical canonical URL to reference this Topic (globally unique)", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>Logical canonical URL to reference this Topic (globally unique)</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Topic.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>draft | active | retired | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Topic.status", description="draft | active | retired | unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>draft | active | retired | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Topic.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>trigger-description</b>
   * <p>
   * Description: <b>Text representation of the trigger</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Topic.resourceTrigger.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="trigger-description", path="Topic.resourceTrigger.description", description="Text representation of the trigger", type="string" )
  public static final String SP_TRIGGER_DESCRIPTION = "trigger-description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>trigger-description</b>
   * <p>
   * Description: <b>Text representation of the trigger</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Topic.resourceTrigger.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TRIGGER_DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TRIGGER_DESCRIPTION);


}


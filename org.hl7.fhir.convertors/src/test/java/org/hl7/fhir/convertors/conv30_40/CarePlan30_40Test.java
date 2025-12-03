package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.resources30_40.CarePlan30_40;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarePlan30_40Test {

  @BeforeEach
  public void setUp() {
    ConversionContext30_40.INSTANCE.init(new VersionConvertor_30_40(new BaseAdvisor_30_40()), "");
  }

  @Test
  public void convertCarePlanActivityDetailComponentR4toDstu3() {
    org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent input = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent();
    input.addExtension(new  org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_CARE_PLAN_ACTIVITY_DETAIL_COMPONENT_EXTENSION,
      new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding("system", "code", "category / detail component"))));
    input.setCode(new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding("system", "code", "code value or whatever")));
    input.addReasonCode(new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding("system", "code", "reasoncode")));
    input.addReasonReference(new org.hl7.fhir.r4.model.Reference("reason Reference"));
    input.addGoal(new org.hl7.fhir.r4.model.Reference("goal"));
    input.setStatus(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
    input.setStatusReason(new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding("status reason system", "status reason code", "status reason display")));
    input.setDoNotPerform(true);
    input.setScheduled(new org.hl7.fhir.r4.model.StringType("Scheduled"));
    input.setLocation(new org.hl7.fhir.r4.model.Reference("location Reference"));
    input.addPerformer(new org.hl7.fhir.r4.model.Reference("performer"));
    input.setProduct(new org.hl7.fhir.r4.model.Reference("product"));
    input.setDailyAmount(new org.hl7.fhir.r4.model.Quantity(456));
    input.setQuantity(new org.hl7.fhir.r4.model.Quantity(123));
    input.setDescription("description");

    org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent result = CarePlan30_40.convertCarePlanActivityDetailComponent(input);

    assertThat(result).isNotNull();
    //verify EXT_CARE_PLAN_ACTIVITY_DETAIL_COMPONENT_EXTENSION
    assertTrue(result.getCategory().equalsDeep(new org.hl7.fhir.dstu3.model.CodeableConcept(new org.hl7.fhir.dstu3.model.Coding("system", "code", "category / detail component"))));
    assertThat(result.hasExtension(VersionConvertorConstants.EXT_CARE_PLAN_ACTIVITY_DETAIL_COMPONENT_EXTENSION)).isFalse();
    //code
    assertTrue(result.getCode().equalsDeep(new org.hl7.fhir.dstu3.model.CodeableConcept(new org.hl7.fhir.dstu3.model.Coding("system", "code", "code value or whatever"))));
    //reasoncode
    assertThat(result.getReasonCode()).hasSize(1);
    assertTrue(result.getReasonCode().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.CodeableConcept(new org.hl7.fhir.dstu3.model.Coding("system", "code", "reasoncode"))));
    //reason reference
    assertThat(result.getReasonReference()).hasSize(1);
    assertTrue(result.getReasonReference().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.Reference("reason Reference")));
    //goal
    assertThat(result.getGoal()).hasSize(1);
    assertTrue(result.getGoal().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.Reference("goal")));
    //status
    assertThat(result.getStatus()).isEqualTo(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
    assertThat(result.getStatusReason()).isEqualTo("status reason code");

    assertThat(result.getProhibited()).isTrue();
    assertThat(result.getScheduledStringType().getValue()).isEqualTo("Scheduled");
    assertTrue(result.getLocation().equalsDeep(new org.hl7.fhir.dstu3.model.Reference("location Reference")));

    assertThat(result.getPerformer()).hasSize(1);
    assertTrue(result.getPerformer().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.Reference("performer")));

    assertTrue(result.getProduct().equalsDeep(new org.hl7.fhir.dstu3.model.Reference("product")));
    assertThat(result.getDailyAmount().getValue().intValue()).isEqualTo(456);
    assertThat(result.getQuantity().getValue().intValue()).isEqualTo(123);

    assertThat(result.getDescription()).isEqualTo("description");
  }


  @Test
  public void convertCarePlanActivityDetailComponentDstu3toR4() {
    org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent input = new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent();
    input.addExtension(new org.hl7.fhir.dstu3.model.Extension(VersionConvertorConstants.EXT_CARE_PLAN_ACTIVITY_DETAIL_COMPONENT_EXTENSION,
      new org.hl7.fhir.dstu3.model.CodeableConcept(new org.hl7.fhir.dstu3.model.Coding("system", "code", "category / detail component"))));
    input.setCode(new org.hl7.fhir.dstu3.model.CodeableConcept(new org.hl7.fhir.dstu3.model.Coding("system", "code", "code value or whatever")));
    input.addReasonCode(new org.hl7.fhir.dstu3.model.CodeableConcept(new org.hl7.fhir.dstu3.model.Coding("system", "code", "reasoncode")));
    input.addReasonReference(new org.hl7.fhir.dstu3.model.Reference("reason Reference"));
    input.addGoal(new org.hl7.fhir.dstu3.model.Reference("goal"));
    input.setStatus(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
    input.setStatusReason("status reason");
    input.setProhibited(true);
    input.setScheduled(new org.hl7.fhir.dstu3.model.StringType("Scheduled"));
    input.setLocation(new org.hl7.fhir.dstu3.model.Reference("location Reference"));
    input.addPerformer(new org.hl7.fhir.dstu3.model.Reference("performer"));
    input.setProduct(new org.hl7.fhir.dstu3.model.Reference("product"));
    org.hl7.fhir.dstu3.model.SimpleQuantity dailyAmount = new org.hl7.fhir.dstu3.model.SimpleQuantity();
    dailyAmount.setValue(456);
    input.setDailyAmount(dailyAmount);

    org.hl7.fhir.dstu3.model.SimpleQuantity quantity = new org.hl7.fhir.dstu3.model.SimpleQuantity();
    quantity.setValue(123);
    input.setQuantity(quantity);
    input.setDescription("description");

    org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent result = CarePlan30_40.convertCarePlanActivityDetailComponent(input);

    assertThat(result).isNotNull();
    //verify EXT_CARE_PLAN_ACTIVITY_DETAIL_COMPONENT_EXTENSION
    assertThat(result.hasExtension(VersionConvertorConstants.EXT_CARE_PLAN_ACTIVITY_DETAIL_COMPONENT_EXTENSION)).isTrue();
    assertTrue(result.getExtensionByUrl(VersionConvertorConstants.EXT_CARE_PLAN_ACTIVITY_DETAIL_COMPONENT_EXTENSION).getValue()
      .equalsDeep(new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding("system", "code", "category / detail component"))));
    //code
    assertTrue(result.getCode().equalsDeep(new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding("system", "code", "code value or whatever"))));
    //reasoncode
    assertThat(result.getReasonCode()).hasSize(1);
    assertTrue(result.getReasonCode().get(0).equalsDeep(new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding("system", "code", "reasoncode"))));
    //reason reference
    assertThat(result.getReasonReference()).hasSize(1);
    assertTrue(result.getReasonReference().get(0).equalsDeep(new org.hl7.fhir.r4.model.Reference("reason Reference")));
    //goal
    assertThat(result.getGoal()).hasSize(1);
    assertTrue(result.getGoal().get(0).equalsDeep(new org.hl7.fhir.r4.model.Reference("goal")));
    //status
    assertThat(result.getStatus()).isEqualTo(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
    org.hl7.fhir.r4.model.Coding expectedStatusReason = new org.hl7.fhir.r4.model.Coding();
    expectedStatusReason.setCode("status reason");
    assertTrue(result.getStatusReason().equalsDeep(new org.hl7.fhir.r4.model.CodeableConcept(expectedStatusReason)));

    assertThat(result.getDoNotPerform()).isTrue();
    assertThat(result.getScheduledStringType().getValue()).isEqualTo("Scheduled");
    assertTrue(result.getLocation().equalsDeep(new org.hl7.fhir.r4.model.Reference("location Reference")));

    assertThat(result.getPerformer()).hasSize(1);
    assertTrue(result.getPerformer().get(0).equalsDeep(new org.hl7.fhir.r4.model.Reference("performer")));

    assertTrue(result.getProduct().equalsDeep(new org.hl7.fhir.r4.model.Reference("product")));
    assertThat(result.getDailyAmount().getValue().intValue()).isEqualTo(456);
    assertThat(result.getQuantity().getValue().intValue()).isEqualTo(123);

    assertThat(result.getDescription()).isEqualTo("description");
  }

}

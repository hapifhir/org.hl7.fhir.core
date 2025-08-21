package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.resources30_40.CarePlan30_40;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
    input.setStatusReason(new CodeableConcept(new  org.hl7.fhir.r4.model.Coding("status reason system", "status reason code", "status reason display")));
    input.setDoNotPerform(true);
    input.setScheduled(new org.hl7.fhir.r4.model.StringType("Scheduled"));
    input.setLocation(new org.hl7.fhir.r4.model.Reference("location Reference"));
    input.addPerformer(new org.hl7.fhir.r4.model.Reference("performer"));
    input.setProduct(new org.hl7.fhir.r4.model.Reference("product"));
    input.setDailyAmount(new org.hl7.fhir.r4.model.Quantity(456));
    input.setQuantity(new org.hl7.fhir.r4.model.Quantity(123));
    input.setDescription("description");

    org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent result = CarePlan30_40.convertCarePlanActivityDetailComponent(input);

    assertThat(result, is(not(nullValue())));
    //verify EXT_CARE_PLAN_ACTIVITY_DETAIL_COMPONENT_EXTENSION
    assertTrue(result.getCategory().equalsDeep(new org.hl7.fhir.dstu3.model.CodeableConcept(new org.hl7.fhir.dstu3.model.Coding("system", "code", "category / detail component"))));
    assertThat(result.hasExtension(VersionConvertorConstants.EXT_CARE_PLAN_ACTIVITY_DETAIL_COMPONENT_EXTENSION), is(false));
    //code
    assertTrue(result.getCode().equalsDeep(new org.hl7.fhir.dstu3.model.CodeableConcept(new org.hl7.fhir.dstu3.model.Coding("system", "code", "code value or whatever"))));
    //reasoncode
    assertThat(result.getReasonCode(), hasSize(1));
    assertTrue(result.getReasonCode().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.CodeableConcept(new org.hl7.fhir.dstu3.model.Coding("system", "code", "reasoncode"))));
    //reason reference
    assertThat(result.getReasonReference(), hasSize(1));
    assertTrue(result.getReasonReference().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.Reference("reason Reference")));
    //goal
    assertThat(result.getGoal(), hasSize(1));
    assertTrue(result.getGoal().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.Reference("goal")));
    //status
    assertThat(result.getStatus(), is(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.SCHEDULED));
    assertThat(result.getStatusReason(), is("status reason code"));

    assertThat(result.getProhibited(), is(true));
    assertThat(result.getScheduledStringType().getValue(), is("Scheduled"));
    assertTrue(result.getLocation().equalsDeep(new org.hl7.fhir.dstu3.model.Reference("location Reference")));

    assertThat(result.getPerformer(), hasSize(1));
    assertTrue(result.getPerformer().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.Reference("performer")));

    assertTrue(result.getProduct().equalsDeep(new org.hl7.fhir.dstu3.model.Reference("product")));
    assertThat(result.getDailyAmount().getValue().intValue(), is(456));
    assertThat(result.getQuantity().getValue().intValue(), is(123));

    assertThat(result.getDescription(), is("description"));
  }


}

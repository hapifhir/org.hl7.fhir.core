package org.hl7.fhir.r5.model.codesystems;

/*
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

// Generated on Thu, Oct 17, 2019 09:42+1100 for FHIR v4.1.0


import org.hl7.fhir.exceptions.FHIRException;

public enum StatisticType {

        /**
         * Computed by forming the difference between two medians.
         */
        ABSOLUTEMEDIANDIFF, 
        /**
         * The number or amount of something.
         */
        C25463, 
        /**
         * The strength of correlation between a set (2 or more) of random variables. The covariance is obtained by forming: cov(x,y)=e([x-e(x)][y-e(y)] where e(x), e(y) is the expected value (mean) of variable x and y respectively. Covariance is symmetric so cov(x,y)=cov(y,x). The covariance is usefull when looking at the variance of the sum of the 2 random variables since: var(x+y) = var(x) +var(y) +2cov(x,y) the covariance cov(x,y) is used to obtain the coefficient of correlation cor(x,y) by normalizing (dividing) cov(x,y) but the product of the standard deviations of x and y.
         */
        _0000301, 
        /**
         * A special use case where the proportion is derived from a formula rather than derived from summary evidence.
         */
        PREDICTEDRISK, 
        /**
         * Descriptive measure reported as narrative.
         */
        DESCRIPTIVE, 
        /**
         * A measure of how often a particular event happens in one group compared to how often it happens in another group, over time. In cancer research, hazard ratios are often used in clinical trials to measure survival at any point in time in a group of patients who have been given a specific treatment compared to a control group given another treatment or a placebo. A hazard ratio of one means that there is no difference in survival between the two groups. A hazard ratio of greater than one or less than one means that survival was better in one of the groups.
         */
        C93150, 
        /**
         * The relative frequency of occurrence of something.
         */
        C16726, 
        /**
         * A type of relative effect estimate that compares rates over time (eg events per person-years).
         */
        RATERATIO, 
        /**
         * The largest possible quantity or degree.
         */
        C25564, 
        /**
         * The sum of a set of values divided by the number of values in the set.
         */
        C53319, 
        /**
         * The mean difference, or difference in means, measures the absolute difference between the mean value in two different groups.
         */
        _0000457, 
        /**
         * The value which has an equal number of values greater and less than it.
         */
        C28007, 
        /**
         * The smallest possible quantity.
         */
        C25570, 
        /**
         * The ratio of the odds of an event occurring in one group to the odds of it occurring in another group, or to a sample-based estimate of that ratio.
         */
        C16932, 
        /**
         * A measure of the correlation of two variables X and Y measured on the same object or organism, that is, a measure of the tendency of the variables to increase or decrease together. It is defined as the sum of the products of the standard scores of the two measures divided by the degrees of freedom.
         */
        C65172, 
        /**
         * The ratio (for a given time period) of the number of occurrences of a disease or event to the number of units at risk in the population.
         */
        C17010, 
        /**
         * Quotient of quantities of the same kind for different components within the same system. [Use for univariate outcomes within an individual.].
         */
        C44256, 
        /**
         * Generated by a type of data transformation called a regression, which aims to model a response variable by expression the predictor variables as part of a function where variable terms are modified by a number. A regression coefficient is one such number.
         */
        _0000565, 
        /**
         * A measure of the risk of a certain event happening in one group compared to the risk of the same event happening in another group. In cancer research, risk ratios are used in prospective (forward looking) studies, such as cohort studies and clinical trials. A risk ratio of one means there is no difference between two groups in terms of their risk of cancer, based on whether or not they were exposed to a certain substance or factor, or how they responded to two treatments being compared. A risk ratio of greater than one or of less than one usually means that being exposed to a certain substance or factor either increases (risk ratio greater than one) or decreases (risk ratio less than one) the risk of cancer, or that the treatments being compared do not have the same effects.
         */
        C93152, 
        /**
         * Difference between the observed risks (proportions of individuals with the outcome of interest) in the two groups. The risk difference is straightforward to interpret: it describes the actual difference in the observed risk of events between experimental and control interventions.
         */
        _0000424, 
        /**
         * A distribution-free analog of correlation analysis. Like regression, it can be applied to compare two independent random variables, each at several levels (which may be discrete or continuous). Unlike regression, Spearman's rank correlation works on ranked (relative) data, rather than directly on the data itself.
         */
        C65171, 
        /**
         * Computed by forming the difference between two means, divided by an estimate of the within-group standard deviation. It is used to provide an estimatation of the effect size between two treatments when the predictor (independent variable) is categorical and the response(dependent) variable is continuous.
         */
        _0000100, 
        /**
         * added to help the parsers
         */
        NULL;
        public static StatisticType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("absolute-MedianDiff".equals(codeString))
          return ABSOLUTEMEDIANDIFF;
        if ("C25463".equals(codeString))
          return C25463;
        if ("0000301".equals(codeString))
          return _0000301;
        if ("predictedRisk".equals(codeString))
          return PREDICTEDRISK;
        if ("descriptive".equals(codeString))
          return DESCRIPTIVE;
        if ("C93150".equals(codeString))
          return C93150;
        if ("C16726".equals(codeString))
          return C16726;
        if ("rate-ratio".equals(codeString))
          return RATERATIO;
        if ("C25564".equals(codeString))
          return C25564;
        if ("C53319".equals(codeString))
          return C53319;
        if ("0000457".equals(codeString))
          return _0000457;
        if ("C28007".equals(codeString))
          return C28007;
        if ("C25570".equals(codeString))
          return C25570;
        if ("C16932".equals(codeString))
          return C16932;
        if ("C65172".equals(codeString))
          return C65172;
        if ("C17010".equals(codeString))
          return C17010;
        if ("C44256".equals(codeString))
          return C44256;
        if ("0000565".equals(codeString))
          return _0000565;
        if ("C93152".equals(codeString))
          return C93152;
        if ("0000424".equals(codeString))
          return _0000424;
        if ("C65171".equals(codeString))
          return C65171;
        if ("0000100".equals(codeString))
          return _0000100;
        throw new FHIRException("Unknown StatisticType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ABSOLUTEMEDIANDIFF: return "absolute-MedianDiff";
            case C25463: return "C25463";
            case _0000301: return "0000301";
            case PREDICTEDRISK: return "predictedRisk";
            case DESCRIPTIVE: return "descriptive";
            case C93150: return "C93150";
            case C16726: return "C16726";
            case RATERATIO: return "rate-ratio";
            case C25564: return "C25564";
            case C53319: return "C53319";
            case _0000457: return "0000457";
            case C28007: return "C28007";
            case C25570: return "C25570";
            case C16932: return "C16932";
            case C65172: return "C65172";
            case C17010: return "C17010";
            case C44256: return "C44256";
            case _0000565: return "0000565";
            case C93152: return "C93152";
            case _0000424: return "0000424";
            case C65171: return "C65171";
            case _0000100: return "0000100";
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://terminology.hl7.org/CodeSystem/statistic-type";
        }
        public String getDefinition() {
          switch (this) {
            case ABSOLUTEMEDIANDIFF: return "Computed by forming the difference between two medians.";
            case C25463: return "The number or amount of something.";
            case _0000301: return "The strength of correlation between a set (2 or more) of random variables. The covariance is obtained by forming: cov(x,y)=e([x-e(x)][y-e(y)] where e(x), e(y) is the expected value (mean) of variable x and y respectively. Covariance is symmetric so cov(x,y)=cov(y,x). The covariance is usefull when looking at the variance of the sum of the 2 random variables since: var(x+y) = var(x) +var(y) +2cov(x,y) the covariance cov(x,y) is used to obtain the coefficient of correlation cor(x,y) by normalizing (dividing) cov(x,y) but the product of the standard deviations of x and y.";
            case PREDICTEDRISK: return "A special use case where the proportion is derived from a formula rather than derived from summary evidence.";
            case DESCRIPTIVE: return "Descriptive measure reported as narrative.";
            case C93150: return "A measure of how often a particular event happens in one group compared to how often it happens in another group, over time. In cancer research, hazard ratios are often used in clinical trials to measure survival at any point in time in a group of patients who have been given a specific treatment compared to a control group given another treatment or a placebo. A hazard ratio of one means that there is no difference in survival between the two groups. A hazard ratio of greater than one or less than one means that survival was better in one of the groups.";
            case C16726: return "The relative frequency of occurrence of something.";
            case RATERATIO: return "A type of relative effect estimate that compares rates over time (eg events per person-years).";
            case C25564: return "The largest possible quantity or degree.";
            case C53319: return "The sum of a set of values divided by the number of values in the set.";
            case _0000457: return "The mean difference, or difference in means, measures the absolute difference between the mean value in two different groups.";
            case C28007: return "The value which has an equal number of values greater and less than it.";
            case C25570: return "The smallest possible quantity.";
            case C16932: return "The ratio of the odds of an event occurring in one group to the odds of it occurring in another group, or to a sample-based estimate of that ratio.";
            case C65172: return "A measure of the correlation of two variables X and Y measured on the same object or organism, that is, a measure of the tendency of the variables to increase or decrease together. It is defined as the sum of the products of the standard scores of the two measures divided by the degrees of freedom.";
            case C17010: return "The ratio (for a given time period) of the number of occurrences of a disease or event to the number of units at risk in the population.";
            case C44256: return "Quotient of quantities of the same kind for different components within the same system. [Use for univariate outcomes within an individual.].";
            case _0000565: return "Generated by a type of data transformation called a regression, which aims to model a response variable by expression the predictor variables as part of a function where variable terms are modified by a number. A regression coefficient is one such number.";
            case C93152: return "A measure of the risk of a certain event happening in one group compared to the risk of the same event happening in another group. In cancer research, risk ratios are used in prospective (forward looking) studies, such as cohort studies and clinical trials. A risk ratio of one means there is no difference between two groups in terms of their risk of cancer, based on whether or not they were exposed to a certain substance or factor, or how they responded to two treatments being compared. A risk ratio of greater than one or of less than one usually means that being exposed to a certain substance or factor either increases (risk ratio greater than one) or decreases (risk ratio less than one) the risk of cancer, or that the treatments being compared do not have the same effects.";
            case _0000424: return "Difference between the observed risks (proportions of individuals with the outcome of interest) in the two groups. The risk difference is straightforward to interpret: it describes the actual difference in the observed risk of events between experimental and control interventions.";
            case C65171: return "A distribution-free analog of correlation analysis. Like regression, it can be applied to compare two independent random variables, each at several levels (which may be discrete or continuous). Unlike regression, Spearman's rank correlation works on ranked (relative) data, rather than directly on the data itself.";
            case _0000100: return "Computed by forming the difference between two means, divided by an estimate of the within-group standard deviation. It is used to provide an estimatation of the effect size between two treatments when the predictor (independent variable) is categorical and the response(dependent) variable is continuous.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ABSOLUTEMEDIANDIFF: return "Absolute Median Difference";
            case C25463: return "Count";
            case _0000301: return "Covariance";
            case PREDICTEDRISK: return "Predicted Risk";
            case DESCRIPTIVE: return "Descriptive";
            case C93150: return "Hazard Ratio";
            case C16726: return "Incidence";
            case RATERATIO: return "Incidence Rate Ratio";
            case C25564: return "Maximum";
            case C53319: return "Mean";
            case _0000457: return "Mean Difference";
            case C28007: return "Median";
            case C25570: return "Minimum";
            case C16932: return "Odds Ratio";
            case C65172: return "Pearson Correlation Coefficient";
            case C17010: return "Prevalence";
            case C44256: return "Proportion";
            case _0000565: return "Regression Coefficient";
            case C93152: return "Relative Risk";
            case _0000424: return "Risk Difference";
            case C65171: return "Spearman Rank-Order Correlation ";
            case _0000100: return "Standardized Mean Difference";
            default: return "?";
          }
    }


}


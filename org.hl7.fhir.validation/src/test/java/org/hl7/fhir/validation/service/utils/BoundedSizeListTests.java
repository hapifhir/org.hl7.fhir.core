package org.hl7.fhir.validation.service.utils;

import org.hl7.fhir.validation.instance.utils.BoundedSizeList;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class BoundedSizeListTests {

 @Test
  void addToEmptyList() {
   BoundedSizeList<Integer> list = new BoundedSizeList<>(new ArrayList<>(), 2);
   list.add(1);
   assertThat(list)
     .hasSize(1)
     .contains(1);
   list.add(2);
   assertThat(list)
     .hasSize(2)
     .containsSequence(1, 2);
 }

 @Test
  void initializeOverSizeFails() {
   assertThatExceptionOfType(BoundedSizeList.BoundsExceededException.class)
     .isThrownBy(() -> {
       new BoundedSizeList<>(new ArrayList<>(List.of(1,2)), 1);
     }).withMessageContaining("Attempt to instantiate a list of size 2 when max size is 1");
 }

 @Test
 void addToFullListFails() {
   BoundedSizeList<Integer> list = new BoundedSizeList<>(new ArrayList<>(List.of(1)), 1);
   assertThatExceptionOfType(BoundedSizeList.BoundsExceededException.class)
     .isThrownBy(() -> {
       list.add(2);
     }).withMessageContaining("Attempt to add an entry to list of size 1 when max size is 1");
      assertThat(list)
        .hasSize(1)
        .contains(1);
 }

 @Test
 void indexedAddToFullListFails() {
   BoundedSizeList<Integer> list = new BoundedSizeList<>(new ArrayList<>(List.of(1)), 1);
   assertThatExceptionOfType(BoundedSizeList.BoundsExceededException.class)
     .isThrownBy(() -> {
       list.add(0, 2);
     }).withMessageContaining("Attempt to add an entry to list of size 1 when max size is 1");
   assertThat(list)
     .hasSize(1)
     .contains(1);
 }

 @Test
  void addMultipleElements() {
   BoundedSizeList<Integer> list = new BoundedSizeList<>(new ArrayList<>(List.of(1, 2)), 4);
    list.addAll(List.of(3, 4));
    assertThat(list)
      .hasSize(4)
      .containsSequence(1, 2, 3, 4);
 }

  @Test
  void indexedAddMultipleElements() {
    BoundedSizeList<Integer> list = new BoundedSizeList<>(new ArrayList<>(List.of(1, 2)), 4);
    list.addAll(0,List.of(3, 4));
    assertThat(list)
      .hasSize(4)
      .containsSequence(3, 4, 1, 2);
  }

  @Test
  void addMultipleElementsFails() {
    BoundedSizeList<Integer> list = new BoundedSizeList<>(new ArrayList<>(List.of(1, 2)), 3);
    assertThatExceptionOfType(BoundedSizeList.BoundsExceededException.class)
      .isThrownBy(() -> {
        list.addAll(List.of(3, 4));
      }).withMessageContaining("Attempt to add 2 entries to a list of size 2 when max size is 3");

    assertThat(list)
      .hasSize(3)
      .containsSequence(1, 2, 3);
  }

  @Test
  void indexedAddMultipleElementsFails() {
    BoundedSizeList<Integer> list = new BoundedSizeList<>(new ArrayList<>(List.of(1, 2)), 3);
    assertThatExceptionOfType(BoundedSizeList.BoundsExceededException.class)
      .isThrownBy(() -> {
        list.addAll(0, List.of(3, 4));
      }).withMessageContaining("Attempt to add 2 entries to a list of size 2 when max size is 3");

    assertThat(list)
      .hasSize(3)
      .containsSequence(3, 1, 2);
  }
}

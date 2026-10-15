package org.hl7.fhir.convertors.context;

import org.hl7.fhir.exceptions.FHIRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

/**
 * Holds the version convertor for the conversion running on the current thread. Conversions nest (a Bundle converts
 * its entries, for example), so the context counts how many are open and forgets the convertor when the outermost one
 * closes.
 *
 * @param <T>
 */
public class VersionConvertorContext<T> {

  private final Logger logger = LoggerFactory.getLogger(VersionConvertorContext.class);

  private static class State<T> {
    private final T versionConvertor;
    private int depth;

    private State(T versionConvertor) {
      this.versionConvertor = versionConvertor;
    }
  }

  /**
   * Each conversion thread instantiates it's own instance of a convertor, which is stored in a {@link ThreadLocal} for
   * access, along with the number of conversions open on that thread.
   */
  private final ThreadLocal<State<T>> threadLocalState = new ThreadLocal<>();

  /**
   * Starts a conversion. If a conversion is already running on this thread, this one is nested inside it and the
   * convertor already set is kept.
   *
   * @param versionConvertor Instance of the version convertor context to use.
   */
  public void init(T versionConvertor) {
    if (versionConvertor == null) {
      throw new FHIRException("Null convertor is not allowed!");
    }
    State<T> state = threadLocalState.get();
    if (state == null) {
      state = new State<>(versionConvertor);
      threadLocalState.set(state);
    }
    state.depth++;
  }

  /**
   * Ends the current conversion. When the outermost conversion ends, the convertor is cleared from memory.
   */
  public void close() {
    State<T> state = threadLocalState.get();
    if (state == null) {
      throw new FHIRException("Cannot close conversion. Reached unstable state, no conversion is open.");
    }
    state.depth--;
    if (state.depth == 0) {
      threadLocalState.remove();
    }
  }

  /**
   * Returns the current instance of the version convertor.
   */
  public T getVersionConvertor() {
    State<T> state = threadLocalState.get();
    T result = state == null ? null : state.versionConvertor;
    if (result != null && logger != null) {
//      logger.debug(result.toString());
    }
    return result;
  }
}
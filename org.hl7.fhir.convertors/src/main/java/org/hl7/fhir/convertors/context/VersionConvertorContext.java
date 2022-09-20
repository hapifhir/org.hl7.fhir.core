package org.hl7.fhir.convertors.context;

import java.util.ArrayList;
import java.util.Stack;

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
 * @param <T>
 */
public class VersionConvertorContext<T> {

  private final Logger logger = LoggerFactory.getLogger(VersionConvertorContext.class);

  /**
   * Each conversion thread instantiates it's own instance of a convertor, which is stored in a {@link ThreadLocal} for
   * access.
   */
  private final ThreadLocal<T> threadLocalVersionConverter = new ThreadLocal<>();

  /**
   * We store the current state of the path as a {@link Stack<String>}. Each Fhir type is pushed onto the stack
   * as we progress, and popped off once converted. The conversions are traversed in a depth first manner, which
   * makes this possible.
   */
  private final ThreadLocal<Stack<String>> threadLocalPath = new ThreadLocal<>();

  /**
   * Initializes the conversion context. If a context already exists, this will just add the path to the current tracked
   * path for the conversion context.
   *
   * @param versionConvertor Instance of the version convertor context to use.
   * @param path             Current path (i.e. String label) for the given conversion.
   */
  public void init(T versionConvertor, String path) {
    if (versionConvertor == null) {
      throw new FHIRException("Null convertor is not allowed!");
    }
    if (path == null) {
      throw new FHIRException("Null path type is not allowed!");
    }

    if (threadLocalVersionConverter.get() == null) {
      threadLocalVersionConverter.set(versionConvertor);
    }

    Stack<String> stack = threadLocalPath.get();
    if (stack == null) {
      stack = new Stack<>();
    }
    stack.push(path);
    // logger.debug("Pushing path <" + path + "> onto stack. Current path -> " + String.join(",", stack));
    threadLocalPath.set(stack);
  }

  /**
   * Closes the current path. This removes the label from the current stored path.
   * If there is no remaining path set after this path is removed, the context convertor and path are cleared from
   * memory.
   *
   * @param path {@link String} label path to add.
   */
  public void close(String path) {
    Stack<String> stack = threadLocalPath.get();
    if (stack == null) {
      throw new FHIRException("Cannot close path <" + path + ">. Reached unstable state, no stack path available.");
    }
    String currentPath = stack.pop();
//    logger.debug("Popping path <" + currentPath + "> off stack. Current path -> " + String.join(",", stack));
    if (!path.equals(currentPath)) {
      throw new FHIRException("Reached unstable state, current path doesn't match expected path.");
    }
    if (stack.isEmpty()) {
      threadLocalVersionConverter.remove();
      threadLocalPath.remove();
    } else {
      threadLocalPath.set(stack);
    }
  }

  /**
   * Will return the {@link String} corresponding to the current conversion "path".
   * ex: "Bundle.Appointment"
   *
   * @return {@link ArrayList<String>}
   */
  public String getPath() throws FHIRException {
    if (threadLocalPath.get() == null) {
      throw new FHIRException("No current path is set.");
    }
    return String.join(".", new ArrayList<>(threadLocalPath.get()));
  }

  /**
   * Returns the current instance of the version convertor.
   */
  public T getVersionConvertor() {
    T result = threadLocalVersionConverter.get();
    if (result != null && logger != null) {
//      logger.debug(result.toString());
    }
    return result;
  }
}
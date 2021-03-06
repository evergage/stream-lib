/*
 * Copyright (C) 2011 Clearspring Technologies, Inc. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clearspring.analytics.stream.cardinality;

import java.io.IOException;
import java.io.Serializable;


public interface ICardinality extends Serializable
{
    /**
     * @param o stream element
     * @return false if the value returned by cardinality() is unaffected by the appearance of o in the stream.
     */
    boolean offer(Object o);

    /**
     * @return the number of unique elements in the stream or an estimate thereof
     */
    long cardinality();

    /**
     * @return size in bytes needed for serialization
     */
    int sizeof();

    /**
     * @return
     * @throws IOException
     */
    byte[] getBytes() throws IOException;

    /**
     * Merges estimators to produce an estimator for the combined streams
     * of this estimator and those passed as arguments
     *
     * @param estimators
     * @throws CardinalityMergeException
     */
    ICardinality merge(ICardinality... estimators) throws CardinalityMergeException;
}

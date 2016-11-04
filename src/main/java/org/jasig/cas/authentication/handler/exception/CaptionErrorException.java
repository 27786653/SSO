/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.authentication.handler.exception;

import javax.security.auth.login.AccountException;

public class CaptionErrorException extends AccountException {


    /**
	 * 
	 */
	private static final long serialVersionUID = -7839856672824201248L;

	/**
     * Constructs a AccountNotFoundException with no detail message.
     * A detail message is a String that describes this particular exception.
     */
    public CaptionErrorException() {
        super();
    }

    /**
     * Constructs a AccountNotFoundException with the specified
     * detail message. A detail message is a String that describes
     * this particular exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public CaptionErrorException(String msg) {
        super(msg);
    }
}
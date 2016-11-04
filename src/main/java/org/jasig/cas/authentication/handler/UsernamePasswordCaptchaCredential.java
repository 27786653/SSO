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
package org.jasig.cas.authentication.handler;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jasig.cas.authentication.UsernamePasswordCredential;


public class UsernamePasswordCaptchaCredential extends
UsernamePasswordCredential {

/**
* 
*/
private static final long serialVersionUID = -864735145551932618L;
@NotNull
@Size(min=1,message = "required.captcha")
private String captcha;

private String systemcode;


public String getSystemcode() {
	return systemcode;
}
public void setSystemcode(String systemcode) {
	this.systemcode = systemcode;
}
public String getCaptcha() {
	return captcha;
}
public void setCaptcha(String captcha) {
	this.captcha = captcha;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((captcha == null) ? 0 : captcha.hashCode());
	result = prime * result
			+ ((systemcode == null) ? 0 : systemcode.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	UsernamePasswordCaptchaCredential other = (UsernamePasswordCaptchaCredential) obj;
	if (captcha == null) {
		if (other.captcha != null)
			return false;
	} else if (!captcha.equals(other.captcha))
		return false;
	if (systemcode == null) {
		if (other.systemcode != null)
			return false;
	} else if (!systemcode.equals(other.systemcode))
		return false;
	return true;
}



}
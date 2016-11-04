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

import org.apache.shiro.crypto.hash.Md5Hash;

public class CurStromPasswordEncoder implements PasswordEncoder{

	public String toMD5(String plainText) {
		Md5Hash md5Hash = new Md5Hash(plainText, salt, hashIterations);
		String password_md5 =  md5Hash.toString();
		System.out.println(password_md5);
		return password_md5;
	   }
	
	private int hashIterations = 1;  
	private String salt;
	
	@Override
	public String encode(String arg0) {
		//salt加盐
		String md5=toMD5(arg0);
		System.out.println(md5);
		return md5;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}


	public int getHashIterations() {
		return hashIterations;
	}


	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}
	

}

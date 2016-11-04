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

import java.security.GeneralSecurityException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.CredentialExpiredException;
import javax.security.auth.login.FailedLoginException;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.dao.DataAccessException;
import org.jasig.cas.adaptors.jdbc.AbstractJdbcUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.bean.Users;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;

public class authenticateUsernamePasswordEcoding extends AbstractJdbcUsernamePasswordAuthenticationHandler {

	
	    @NotNull
	    private String sql;

	    /**
	     * @param sql The sql to set.
	     */
	    public void setSql(final String sql) {
	        this.sql = sql;
	    }

	
	@Override
	protected HandlerResult authenticateUsernamePasswordInternal(
			UsernamePasswordCredential credential) throws GeneralSecurityException,
			PreventedException {
		String username = null;
		CurStromPasswordEncoder curStromPasswordEncoder = null;
		if(credential instanceof UsernamePasswordCaptchaCredential||credential instanceof UsernamePasswordCredential){
//UsernamePasswordCaptchaCredential curCredential=(UsernamePasswordCaptchaCredential)credential;
//			final String username = curCredential.getUsername();
//			final CurStromPasswordEncoder curStromPasswordEncoder=
//					this.getPasswordEncoder() instanceof CurStromPasswordEncoder
//						?(CurStromPasswordEncoder)this.getPasswordEncoder():null;
			username = credential.getUsername();
			curStromPasswordEncoder = this.getPasswordEncoder() instanceof CurStromPasswordEncoder
				?(CurStromPasswordEncoder)this.getPasswordEncoder():null;
		}
		if(StringUtils.isEmpty(username)||curStromPasswordEncoder==null)return null;
		try {
            final Users users = getJdbcTemplate().queryForObject(sql, new Object[]{username}, new RowMapper<Users>(){
				@Override
				public Users mapRow(ResultSet resultset, int arg1)
						throws SQLException {
					Users user=new Users();
					user.setPassword(resultset.getString("password"));
					user.setSalt(resultset.getString("salt"));
					return user;
				}
            });
            if(users==null)throw new AccountNotFoundException("no this account");
            curStromPasswordEncoder.setSalt(users.getSalt());
            final String encryptedPassword = this.getPasswordEncoder().encode(credential.getPassword());
            if (!users.getPassword().equals(encryptedPassword)) {
                throw new FailedLoginException("Password does not match value on record.");
            }
        } catch (final IncorrectResultSizeDataAccessException e) {
        	e.printStackTrace();
            if (e.getActualSize() == 0) {
                throw new AccountNotFoundException(username + " not found with SQL query");
            } else {
                throw new FailedLoginException("Multiple records found for " + username);
            }
        } catch (final DataAccessException e) {
        	e.printStackTrace();
            throw new PreventedException("SQL exception while executing query for " + username, e);
        }
        return createHandlerResult(credential, new SimplePrincipal(username), null);
	}

}

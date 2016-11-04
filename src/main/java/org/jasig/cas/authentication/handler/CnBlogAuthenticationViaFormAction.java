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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.ticket.registry.TicketRegistry;
import org.jasig.cas.web.flow.AuthenticationViaFormAction;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class CnBlogAuthenticationViaFormAction extends AuthenticationViaFormAction{

	

	public final Event validateCaptcha(final RequestContext context, final Credential credential,
            final MessageContext messageContext){
        
            final HttpServletRequest request = WebUtils.getHttpServletRequest(context);  
            HttpSession session = request.getSession();  
            String captcha = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
            session.removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
            UsernamePasswordCaptchaCredential upc = (UsernamePasswordCaptchaCredential)credential;  
            String submitAuthcodeCaptcha =upc.getCaptcha(); 
            if(StringUtils.isEmpty(submitAuthcodeCaptcha)){
                messageContext.addMessage(new MessageBuilder().error().code("required.captcha").build()); 
                return new EventFactorySupport().error(ERROR);
            }  
            if(submitAuthcodeCaptcha.equals(captcha)){    
                return new EventFactorySupport().success(SUCCESS);  
            }  
            messageContext.addMessage(new MessageBuilder().error().code("error.authentication.captcha.bad").build()); 
            return new EventFactorySupport().error(ERROR);
     }

	
	
	@Override
	public void setTicketRegistry(TicketRegistry ticketRegistry) {
		// TODO Auto-generated method stub
		super.setTicketRegistry(ticketRegistry);
	}
	
	
}
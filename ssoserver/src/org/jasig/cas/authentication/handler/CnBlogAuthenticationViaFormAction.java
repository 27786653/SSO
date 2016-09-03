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
import org.springframework.webflow.execution.RequestContext;

public class CnBlogAuthenticationViaFormAction extends AuthenticationViaFormAction{

    private String codekey="123";

	public final String validateCaptcha(final RequestContext context, final Credential credential,
            final MessageContext messageContext){
        
            final HttpServletRequest request = WebUtils.getHttpServletRequest(context);  
            HttpSession session = request.getSession();  
//            String captcha = (String)session.getAttribute(codekey);  
//            session.removeAttribute(codekey);  
            String captcha=codekey;
            UsernamePasswordCaptchaCredential upc = (UsernamePasswordCaptchaCredential)credential;  
            String submitAuthcodeCaptcha =upc.getCaptcha(); 
            System.out.println("执行");
            
            if(StringUtils.isEmpty(submitAuthcodeCaptcha)){
                messageContext.addMessage(new MessageBuilder().code("required.captcha").build()); 
                return "error";    
            }  
            if(submitAuthcodeCaptcha.equals(captcha)){    
                return "success";  
            }  
            messageContext.addMessage(new MessageBuilder().code("error.authentication.captcha.bad").build());
            return "error";    
    }

	@Override
	public void setTicketRegistry(TicketRegistry ticketRegistry) {
		// TODO Auto-generated method stub
		super.setTicketRegistry(ticketRegistry);
	}
	
	
}
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

public String getCaptcha() {
	return captcha;
}
public void setCaptcha(String captcha) {
	this.captcha = captcha;
}



}
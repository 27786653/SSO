<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%--

    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License.  You may obtain a
    copy of the License at the following location:

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

--%>
<jsp:directive.include file="includes/top.jsp" />
<%
String service=request.getParameter("service");
if(service==null||service.trim().length()<=0){
%>
<div id="msg" class="errors">
		<h2>警告！</h2>
		<p>元海认证中心提醒你，请勿访问该网站。谢谢配合！</p>
</div>
<%}else{%>

<%-- <c:if test="${not pageContext.request.secure}">
	<div id="msg" class="errors">
		<h2>Non-secure Connection</h2>
		<p>You are currently accessing CAS over a non-secure connection.
			Single Sign On WILL NOT WORK. In order to have single sign on work,
			you MUST log in over HTTPS.</p>
	</div>
</c:if> --%>
<div class="box" id="login"
	style="background: rgb(255, 255, 255); margin: 60px auto 60px; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px;  text-align: center;    border-bottom-right-radius: 4px;
    border-bottom-left-radius: 4px;    box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.1); overflow: auto;">
	<form:form method="post" id="fm1" commandName="${commandName}"
		htmlEscape="true">

		<form:errors path="*" id="msg" cssClass="errors" element="div"
			htmlEscape="false" />

		<h2>
			<spring:message code="screen.welcome.instructions"  />
		</h2>
		<section class="row">
			<label for="username"  ><spring:message
					code="screen.welcome.label.netid" />
			</label>
			<c:choose>
				<c:when test="${not empty sessionScope.openIdLocalId}">
					<strong>${sessionScope.openIdLocalId}</strong>
					<input type="hidden" id="username" name="username"
						value="${sessionScope.openIdLocalId}"  />
				</c:when>
				<c:otherwise>
					<spring:message code="screen.welcome.label.netid.accesskey"
						var="userNameAccessKey" />
					<form:input cssClass="required" cssErrorClass="error" id="username"
						size="25" tabindex="1" accesskey="${userNameAccessKey}"
						path="username" autocomplete="off" htmlEscape="true" />
				</c:otherwise>
			</c:choose>
		</section>

		<section class="row">
			<label for="password"><spring:message
					code="screen.welcome.label.password" />
			</label>
			<%--
      NOTE: Certain browsers will offer the option of caching passwords for a user.  There is a non-standard attribute,
      "autocomplete" that when set to "off" will tell certain browsers not to prompt to cache credentials.  For more
      information, see the following web page:
      http://www.technofundo.com/tech/web/ie_autocomplete.html
      --%>
			<spring:message code="screen.welcome.label.password.accesskey"
				var="passwordAccessKey" />
			<form:password cssClass="required" cssErrorClass="error"
				id="password" size="25" tabindex="2" path="password"
				accesskey="${passwordAccessKey}" htmlEscape="true"
				autocomplete="off" />
		</section>

		<section class="row">
			<label for="captcha"><spring:message
					code="screen.welcome.label.captcha" />
			</label>
			<%--
      NOTE: Certain browsers will offer the option of caching passwords for a user.  There is a non-standard attribute,
      "autocomplete" that when set to "off" will tell certain browsers not to prompt to cache credentials.  For more
      information, see the following web page:
      http://www.technofundo.com/tech/web/ie_autocomplete.html
      --%>
			<spring:message code="screen.welcome.label.password.accesskey"
				var="passwordAccessKey" />
			<div style="height: 30px;float: left;margin-left: 71px;margin-right: 5px;">
			<form:input cssClass="required" cssErrorClass="error" id="captcha"
				size="10" tabindex="3" path="captcha"
				accesskey="${passwordAccessKey}" htmlEscape="true"
				autocomplete="off" />
			</div>
				<div style="height: 30px;float: left;">
			<img onclick="this.src='captcha.jpg?'+Math.random()" width="93"
				height="30" src="captcha.jpg">
				</div>

		</section>

		<section class="row check"  style="clear: both;">
			<input id="warn" name="warn" value="true" tabindex="3"
				accesskey="<spring:message code="screen.welcome.label.warn.accesskey" />"
				type="checkbox" /> <label for="warn"><spring:message
					code="screen.welcome.label.warn" />
			</label>
		</section>

		<section class="row btn-row">
			<input type="hidden" name="lt" value="${loginTicket}" /> <input
				type="hidden" name="execution" value="${flowExecutionKey}" /> <input
				type="hidden" name="_eventId" value="submit" /> <input
				class="btn-submit" name="submit" accesskey="l"
				value="<spring:message code="screen.welcome.button.login" />"
				tabindex="4" type="submit" /> <input class="btn-reset" name="reset"
				accesskey="c"
				value="<spring:message code="screen.welcome.button.clear" />"
				tabindex="5" type="reset" />
		</section>
	</form:form>
</div>
<%} %>

<jsp:directive.include file="includes/bottom.jsp" />

<%@ page pageEncoding="UTF-8"%>  
<%@ page import="java.util.Map"%>  
<%@ page import="java.net.URLDecoder"%>  
<%@ page import="org.jasig.cas.client.util.AssertionHolder"%>  
<%@ page import="org.jasig.cas.client.authentication.AttributePrincipal"%>  
  
<body style="background-color:#CBE0C9;">  
    <span style="color:red; font-size:32px; font-weight:bold;">客户端登录成功</span>  
</body>  
  
<hr size="2">  
  
<%  
    AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();  
    Map<String, Object> attributes = principal.getAttributes();  
    out.print("principal.getName()=" + principal.getName() + "<br/>");  
    out.print("request.getRemoteUser()=" + request.getRemoteUser() + "<br/>");  
    out.print("登录用户：" + attributes.get("userId") + "<br/>");  
    out.print("登录时间：" + AssertionHolder.getAssertion().getValidFromDate() + "<br/>");  
    out.print("-----------------------------------------------------------------------<br/>");  
    for(Map.Entry<String,Object> entry : attributes.entrySet()){  
        //服务端返回中文时需要encode,客户端接收显示中文时需要decode,否则会乱码  
        out.print(entry.getKey() + "=" + URLDecoder.decode(entry.getValue().toString(), "UTF-8") + "<br/>");  
    }  
    out.print("-----------------------------------------------------------------------<br/>");  
    Map<String, Object> attributes22 = AssertionHolder.getAssertion().getAttributes();  
    for(Map.Entry<String,Object> entry : attributes22.entrySet()){  
        out.print(entry.getKey() + "=" + entry.getValue() + "<br/>");  
    }  
    out.print("-----------------------------------------------------------------------<br/>");  
    Map<String, Object> attributes33 = AssertionHolder.getAssertion().getPrincipal().getAttributes();  
    for(Map.Entry<String,Object> entry : attributes33.entrySet()){  
        out.print(entry.getKey() + "=" + entry.getValue() + "<br/>");  
    }  
%>  
<a href="javascript:top.location.href ='http://localhost:8080/webdemo/logout?service=http://localhost:8083/testdemos';">退出</a>
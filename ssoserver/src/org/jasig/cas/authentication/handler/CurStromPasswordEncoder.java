package org.jasig.cas.authentication.handler;

import java.security.MessageDigest;

import javax.enterprise.inject.spi.PassivationCapable;
import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.web.support.WebUtils;

import sun.security.provider.MD5;

public class CurStromPasswordEncoder implements PasswordEncoder{

	public String toMD5(String plainText) {
		
	     try {
	        //生成实现指定摘要算法的 MessageDigest 对象。
	        MessageDigest md = MessageDigest.getInstance("MD5");  
	        //使用指定的字节数组更新摘要。
	        md.update(plainText.getBytes());
	        //通过执行诸如填充之类的最终操作完成哈希计算。
	        byte b[] = md.digest();
	        //生成具体的md5密码到buf数组
	        int i;
	        StringBuffer buf = new StringBuffer("");
	        for (int offset = 0; offset < b.length; offset++) {
	          i = b[offset];
	          if (i < 0)
	            i += 256;
	          if (i < 16)
	            buf.append("0");
	          buf.append(Integer.toHexString(i));
	        }
	        return buf.toString();
	     } 
	     catch (Exception e) {
	       e.printStackTrace();
	     }
		return null;
	   }
	   
	
	@Override
	public String encode(String arg0) {
		String md5=toMD5(arg0);
		System.out.println(md5);
		return md5;
	}

}

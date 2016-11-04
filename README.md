# SSO单点登录
    公司项目需要大量集成，使用单点登录进行统一用户管理（不使用https，因为证书的提示框对于用户来说真是..）  

## maven版本在分支 maven(cas-4.0)
## maven版本说明：
1. 添加验证码
2. 自定义登录页
3. 自定义返回多数据
4. 集成restful  APl适配 C/S端 [查看配置详情(博客)](http://blog.csdn.net/qqqqq210/article/details/53019010)
5. 防止直接访问
6. 完善验证码国际化
7. 基于数据库登录
8. 使用MD5加随机盐加密密码

## 测试配置说明  

  1.建立域名
  
  修改c:\windows\system32\drivers\etc\HOSTS 文件配置三个域名进行单点测试 （保存不了查看下你对文件的权限）,配置如下:  
  
    127.0.0.1 sso.web.com  
    127.0.0.1 my.web.com  
    127.0.0.1 my2.web.com  
  
  2.部署ssoserver服务器端,主要是通行证统一校验发放的地方，把他导入到eclipse中
    
    因为项目采用的是数据库校验的方式,创建一个test数据库users用户表即可（MD5校验哦）  看看这个配置文件：deployerConfigContext.xml
    启动服务器
  
  3.部署ssoclient客户端,主要是测试访问受保护的访问  
  
    导入项目    
    修改config.properties配置(根据你定义的域名而变)
 ```
  #<<CentralAuthenticationService>>
  #where to logout
  casServerLogoutUrl=http://sso.web.com:8080/webdemo/logout
  #wheretologin
  casServerLoginUrl=http://sso.web.com:8080/webdemo/login
  #loginserverroot
  casServerUrlPrefix=http://sso.web.com:8080/webdemo/
  casClientServerName=http://my.web.com:8083/
  ```

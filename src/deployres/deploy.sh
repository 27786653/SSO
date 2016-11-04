#!/bin/bash
#kill tomcat pid
pidlist=`ps -ef|grep tomcat|grep -v "grep"|awk '{print $2}'`
if [ "$pidlist" = "" ]
   then
       echo "no tomcat pid alive!"
else
  echo "tomcat Id list :$pidlist"
  kill -9 $pidlist
  echo "KILL $pidlist:"
  echo "service stop success"
fi
echo "start tomcat"
rm -rf  /usr/soft/sso-tomcat/webapps/ca*
mv /usr/soft/cas.war /usr/soft/sso-tomcat/webapps/yuhi-sso.war
/usr/soft/sso-tomcat/bin/startup.sh
echo "http://localhost:8080/yuhi-sso/login"


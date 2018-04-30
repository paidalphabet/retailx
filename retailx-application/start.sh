### Author mahavir 
#/bin/bash
#D:\Software\apache-tomcat-9.0.7\bin
TOMCAT_WEBAPPS_LOCATION="/d/Software/apache-tomcat-9.0.7/webapps/"
TOMCAT_BIN_LOCATION="/d/Software/apache-tomcat-9.0.7/bin/"
function buildCleanInstall(){
rm -rf  $/TOMCAT_WEBAPPS_LOCATION/*
mvn clean install
cp target/*.war $TOMCAT_WEBAPPS_LOCATION
$TOMCAT_BIN_LOCATION/startup.bat
}


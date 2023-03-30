javac -d framework/src framework/src/*.java
cd framework\src
jar -cf framework.jar .
copy framework.jar "..\..\test_framework\src\WEB-INF\lib"
cd ..\..\
cd test_framework\src
jar -cf test_framework.war .
copy test_framework.war "D:\FIANARANA\Logiciel\apache-tomcat-9.0.64-windows-x64\apache-tomcat-9.0.64\webapps\"

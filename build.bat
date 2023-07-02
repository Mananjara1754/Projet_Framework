@REM Compilation du framework
javac -d framework/src framework/src/*.java

@REM TRansformation du framework en jar
cd framework\src
jar -cf frameworkS4.jar .

@REM Copie dans le lib du test projet
copy frameworkS4.jar "..\..\test_framework\src\WEB-INF\lib"

@REM compilation du projet de test
    cd ..\..\test_framework
    javac -d WEB-INF/classes WEB-INF/classes/*.java


@REM suppression du contenu du repertoire temp
    cd ../temp

    rmdir /S /Q "WEB-INF"

    del /F /Q "."

@REM structuration du repertoire temp
    mkdir WEB-INF

    cd ../

    robocopy test_framework\src\WEB-INF temp\WEB-INF /E

    copy "test_framework\src\*.jsp" "temp"

@REM transformation du repertoire temp en fichier war
    cd temp

    jar -cf testFrameworkOkey.war .

copy testFrameworkOkey.war "E:\FIANARANA\Logiciel\apache-tomcat-9.0.64-windows-x64\apache-tomcat-9.0.64\webapps"

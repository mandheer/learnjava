#Install Oracle Drivers

Here we're using oracle so will be using oracle driver installation steps.
#1. Get ORACLE JDBC Drivers
Oracle database installed folder, for example, "{ORACLE_HOME}\jdbc\lib\ojdbc6.jar“
#2. Install
mvn install:install-file -Dfile={Path/to/your/ojdbc6.jar} -DgroupId=com.oracle
-DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar -DgeneratePom=true

e.g. mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar -DgeneratePom=true
#3 configure pom.xml

\<project ...>

	<dependencies>
		
		<!-- ORACLE database driver -->
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>11.2.0</version>
		</dependency>
		
	</dependencies>
</project>

#4 JTA jar
JTA jar is important else you'll get javax.transaction.SystemException class not found.
This is internally used by hibernate jar.
		<dependency>
			<groupId>javax.transaction</groupId>
			<artifactId>jta</artifactId>
			<version>1.1</version>
		</dependency>
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
		
#5 Some definitions
valueObject is and object which does not have it's own meaning for table/real world. However, it adds meaning to the other object.
entityObject has it's value/ meaning on it's own.
surrogate key is the primary key which is not having any real world significance and still part of table. e.g. ID,creation_TS
natural key is business key for the table.
We can't use the embedded and Id annotations together. Rather we need to use EmbeddedId in such cases and make it sure that all combination comes out to be unique while using embedded Id.

##Lazy Initialization
While retrieving the data from hibernate, it fetches the first level member variables (Object instances are not initialized). Active by default.
When we'll request the object instances, it will make DB call and fetch the data. e.g. calling object->getter.

##Eager Initialization


## To handle not found on @ManytoOne relation.
If business is valid that a @ManytoOne relation can be null or empty. 
We can use hibernate annotation @NotFound(action=NotFoundAction.IGNORE) and it won't throw an exception.

##Hibernate Collections
Bag semantic - List/ArrayList
Bag semantic with ID - List/ArrayList
List semantic - List/ArrayList
Set semantic - Set
Map semantic - Map

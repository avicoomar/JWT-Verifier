A flexible JWT Verifier utility which intercepts all incoming HTTP requests to your spring boot applition and validates their jwt. <br>
Simply add this file to your existing Spring Boot project. <br> <br>

Process of verification:
	1. Extract Header from incoming jwt.
	2. Extract Signature Algorithm used from the header.
	3. Extract Payload from the jwt.
	4. Sign using Extracted Signature Algorithm, Extracted Payload and Secret key and store the calculated Signature.
	5. Compare the calculated Signature with Signature received to validate the jwt.

Assumptions:
	1. iat field should exist in payload.
	2. token expires after 3 minutes. 

Required dependencies apart from spring boot dependencies:
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.9.1</version>
</dependency>

<dependency>
    <groupId>javax.xml.bind</groupId>
     		<artifactId>jaxb-api</artifactId>
    		<version>2.3.0</version>
</dependency>

<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-core</artifactId>
	<version>2.14.2</version>
</dependency>

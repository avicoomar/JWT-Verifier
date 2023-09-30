A flexible JWT Verifier utility which intercepts all incoming HTTP requests to your spring boot applition and validates their jwt. <br>
Simply add this file to your existing Spring Boot project. <br> <br>

Process of verification:<br>
	1. Extract Header from incoming jwt.<br>
	2. Extract Signature Algorithm used from the header.<br>
	3. Extract Payload from the jwt.<br>
	4. Sign using Extracted Signature Algorithm, Extracted Payload and Secret key and store the calculated Signature.<br>
	5. Compare the calculated Signature with Signature received to validate the jwt.<br>
<br><br>
Assumptions:<br>
	1. iat field should exist in payload.<br>
	2. token expires after 3 minutes. <br>
<br><br>
Required dependencies apart from spring boot dependencies:<br>
<dependency><br>
	<groupId>io.jsonwebtoken</groupId><br>
	<artifactId>jjwt</artifactId><br>
	<version>0.9.1</version><br>
</dependency><br>
<br><br>
<dependency><br>
    <groupId>javax.xml.bind</groupId><br>
     		<artifactId>jaxb-api</artifactId><br>
    		<version>2.3.0</version><br>
</dependency><br>
<br><br>
<dependency><br>
	<groupId>com.fasterxml.jackson.core</groupId><br>
	<artifactId>jackson-core</artifactId><br>
	<version>2.14.2</version><br>
</dependency><br>

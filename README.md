A flexible JWT Verifier utility which intercepts all incoming HTTP requests to your spring boot applition and validates their jwt. <br>
Simply add this file to your existing Spring Boot project. <br> <br>

Process of verification:<br>
 . Extract Header from incoming jwt.<br>
 . Extract Signature Algorithm used from the header.<br>
 . Extract Payload from the jwt.<br>
 . Sign using Extracted Signature Algorithm, Extracted Payload and Secret key and store the calculated Signature.<br>
 . Compare the calculated Signature with Signature received to validate the jwt.<br>
<br>
Assumptions:<br>
*iat field should exist in payload.<br>
*token expires after 3 minutes. <br>
<br>
Required dependencies apart from spring boot dependencies:<br>
*io.jsonwebtoken - jjwt - 0.9.1 <br>
*javax.xml.bind - jaxb-api - 2.3.0 <br>
*com.fasterxml.jackson.core - jackson-core - 2.14.2

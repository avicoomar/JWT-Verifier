### A flexible JWT Verifier utility which intercepts all incoming HTTP requests to your spring boot applition and validates their jwt. Simply add this file to your existing Spring Boot project.

Process of verification:

1.  Extract Header from incoming jwt.
2.  Extract the used Signature Algorithm from the header.
3.  Extract Payload from the jwt.
4.  Sign using Extracted Signature Algorithm, Extracted Payload and Secret key. Store the calculated Signature.
5.  Compare the calculated Signature with Signature received to validate the jwt.

Assumptions:

-   iat field should exist in payload.
-   token expires after 3 minutes.

Required dependencies apart from spring boot dependencies:

- io.jsonwebtoken - jjwt - 0.9.1
- javax.xml.bind - jaxb-api - 2.3.0
- com.fasterxml.jackson.core - jackson-core - 2.14.2

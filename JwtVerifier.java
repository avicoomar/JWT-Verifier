/* Simply add this file to your existing Spring Boot project. 
It will intercept all incoming HTTP requests validate their jwt.
Modify the code as per your requirement*/ 

package sampleservice;

import org.springframework.stereotype.Component;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import io.jsonwebtoken.Jwts;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

@Component
public class JwtVerifier implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		
		String secret = "coomar";
		String token = ((HttpServletRequest) request).getHeader("Authorization");
		
		try{		
			String signatureRecieved = token.split("\\.")[2];

			ObjectMapper mapper = new ObjectMapper();
			
			//Header Recieved
			byte[] headerDecoded = Base64.getDecoder().decode(token.split("\\.")[0]);
			String header = new String(headerDecoded,StandardCharsets.UTF_8);
			Map<String,Object> headerMap = mapper.readValue(header, Map.class);
			
			//Payload/Claims Recieved
			byte[] payloadDecoded = Base64.getDecoder().decode(token.split("\\.")[1]);
			String payload = new String(payloadDecoded,StandardCharsets.UTF_8);
			Map<String,Object> payloadMap = mapper.readValue(payload, Map.class);
			
            SignatureAlgorithm sa = SignatureAlgorithm.forName((String)headerMap.get("alg"));
            
			//signatureCalculated (using secret key "coomar")
			String signatureCalculated = (Jwts.builder().addClaims(payloadMap).signWith(sa,secret.getBytes()).compact()).split("\\.")[2];

			if(!signatureRecieved.equals(signatureCalculated) || 
			token.length()==0 || 
			(((System.currentTimeMillis()/1000)) - (Integer)payloadMap.get("iat") > 180)){
                /*
                NOTE:
                1.Assuming that iat field exists in payload
                2.Token expires after 180 seconds (3 minutes), replace 180 with required duration
                */
				((HttpServletResponse)response).sendError(HttpServletResponse.SC_FORBIDDEN);	
			}
		}
		catch(Exception e){
			System.out.println(e);
			((HttpServletResponse)response).sendError(HttpServletResponse.SC_FORBIDDEN);
		}	

		filterchain.doFilter(request, response);
	}

}

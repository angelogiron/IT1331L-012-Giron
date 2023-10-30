package com.uap.it1311l.passwordencryptorapi.webclient;

import com.uap.it1311l.passwordencryptorapi.models.DecryptionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;
@HttpExchange
public interface DecryptionApiClient {

	@GetMapping("/decryptstring?cryptAlgorithm={cryptAlgorithm}&secretKey={secretKey}&encryptedText={encryptedText}")
	DecryptionResponse decrypt(
	        @PathVariable String cryptAlgorithm,
	        @PathVariable String secretKey,
	        @PathVariable String encryptedText
	);

}

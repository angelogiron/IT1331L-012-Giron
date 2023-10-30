package com.uap.it1311l.passwordencryptorapi.service;

import com.uap.it1311l.passwordencryptorapi.models.DecryptionResponse;

import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;

import com.uap.it1311l.passwordencryptorapi.repository.passwordMyBatis;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptDecryptService {

    @Autowired
    EncryptionApiClient api;

    @Autowired
    passwordMyBatis batis;

    public EncryptionResponse encrypt(String password) {
		EncryptionResponse response = api.encrypt("my-secret-key", password, "DES");
		batis.insert(response.getResult());
		return response;
	}

	public DecryptionResponse decrypt(String encryptedPassword){
		String encryptedText = batis.findbyEncryptedPassword(encryptedPassword);
		DecryptionResponse response = api.decrypt("DES", "my-secret-key", encryptedText);
		return response;
	}


}

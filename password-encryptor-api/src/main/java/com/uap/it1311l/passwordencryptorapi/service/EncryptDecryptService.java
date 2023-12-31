package com.uap.it1311l.passwordencryptorapi.service;

import com.uap.it1311l.passwordencryptorapi.models.DecryptionResponse;
import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;
import com.uap.it1311l.passwordencryptorapi.repository.passwordMyBatis;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptDecryptService 
{
    @Autowired
    EncryptionApiClient api;
    
    
    @Autowired
	passwordMyBatis batis;
    
    public EncryptionResponse encrypt(String password)
    {
    	EncryptionResponse response = api.encrypt("my-secret-key", URLEncoder.encode(password, StandardCharsets.UTF_8), "AES");
		batis.insert(response.getResult());
		return response;
    }
    
    public String decrypt(String encryptedText) 
    {
        if (batis.exists(encryptedText) > 0) 
        {
            DecryptionResponse response = api.decrypt("my-secret-key", encryptedText, "AES");
            return response.getResult();
        } 
        else 
        {
            return "Encrypted Password is not available in this table.";
        }
    } 
}
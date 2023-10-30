package com.uap.it1311l.passwordencryptorapi.service;

import com.uap.it1311l.passwordencryptorapi.models.DecryptionResponse;
import com.uap.it1311l.passwordencryptorapi.models.EncryptedPasswordRequest;
import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;
import com.uap.it1311l.passwordencryptorapi.models.password;
import com.uap.it1311l.passwordencryptorapi.repository.passwordMyBatis;
import com.uap.it1311l.passwordencryptorapi.webclient.DecryptionApiClient;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptDecryptService {

    @Autowired
    EncryptionApiClient encryptionApiClient;

    @Autowired
    DecryptionApiClient decryptionApiClient;

    @Autowired
    passwordMyBatis passwordMyBatis;

    public EncryptionResponse encrypt(String password) {
        EncryptionResponse response = encryptionApiClient.encrypt("whateverkeyyouwant", password, "AES");
        passwordMyBatis.savePassword(response.getResult());
        return response;
    }

    public DecryptionResponse decrypt(EncryptedPasswordRequest request) {
        String encryptedText = request.getEncryptedPassword();
        password passwordEntity = passwordMyBatis.findByEncryptedPassword(request.getEncryptedPassword());

        if (passwordEntity == null) {
            return new DecryptionResponse("Encrypted Password does not exist");
        }

        DecryptionResponse decryptionResponse = decryptionApiClient.decrypt("AES", "whateverkeyyouwant", encryptedText);
        return decryptionResponse;
    }

}

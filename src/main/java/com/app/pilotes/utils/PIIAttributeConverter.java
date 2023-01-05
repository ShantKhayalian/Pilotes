package com.app.pilotes.utils;

import com.app.pilotes.exceptions.ApplicationExceptions;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.security.Key;
import java.util.Base64;

@Component
public class PIIAttributeConverter implements AttributeConverter<String, String> {
    private static final String AES = "AES";
    private static final String SECRET = "secret-key-12345";
    private final Key key;


    public PIIAttributeConverter() {
        key = new SecretKeySpec(SECRET.getBytes(), AES);
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            if (attribute == null) return null;
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(attribute.getBytes()));
        } catch (Exception e) {
            throw new ApplicationExceptions("convertToDatabaseColumn " + e.getMessage());
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            if (dbData == null) return null;
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(dbData)));
        } catch (Exception e) {
            throw new ApplicationExceptions("convertToEntityAttribute " + e.getMessage());
        }
    }
}

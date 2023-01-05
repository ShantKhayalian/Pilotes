package com.app.pilotes.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.app.pilotes.exceptions.ApplicationExceptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PIIAttributeConverter.class})
@ExtendWith(SpringExtension.class)
class PIIAttributeConverterTest {
    @Autowired
    private PIIAttributeConverter pIIAttributeConverter;

    @Test
    void testConvertToDatabaseColumn() {
        assertEquals("Jnh/iKxFkhMa/Dy8etiULQ==", pIIAttributeConverter.convertToDatabaseColumn("Attribute"));
        assertNull(pIIAttributeConverter.convertToDatabaseColumn(null));
    }

    @Test
    void testConvertToEntityAttribute() {
        assertThrows(ApplicationExceptions.class, () -> pIIAttributeConverter.convertToEntityAttribute("Db Data"));
        assertThrows(ApplicationExceptions.class, () -> pIIAttributeConverter.convertToEntityAttribute("AES"));
        assertNull(pIIAttributeConverter.convertToEntityAttribute(null));
        assertEquals("", pIIAttributeConverter.convertToEntityAttribute(""));
    }
}


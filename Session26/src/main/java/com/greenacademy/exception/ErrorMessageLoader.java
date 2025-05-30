package com.greenacademy.exception;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

@Component
public class ErrorMessageLoader {
    private static java.util.Properties vnMessages = new java.util.Properties();
    private static java.util.Properties enMessages = new java.util.Properties();

    public ErrorMessageLoader() {
        loadErrorMessages();
    }

    public void loadErrorMessages() {
        loadProperties(vnMessages, "message-vn.properties");
        loadProperties(enMessages, "message-en.properties");
    }

    private void loadProperties(Properties properties, String fileName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IOException("Properties file 'error.properties' not found on the classpath");
            }
            try (InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
                properties.load(reader);
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    public static ErrorMessage getErrorMessage(String errorCode) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(ErrorCode.SYSTEM_ERROR);
        errorMessage.setMessage("System Error");
        for (Map.Entry<Object, Object> entry : vnMessages.entrySet()) {
            if (entry.getKey().equals(errorCode)) {
                errorMessage.setErrorCode(entry.getKey().toString());
                errorMessage.setMessage(entry.getValue().toString());
                return errorMessage;
            }
        }
        return errorMessage;
    }
}

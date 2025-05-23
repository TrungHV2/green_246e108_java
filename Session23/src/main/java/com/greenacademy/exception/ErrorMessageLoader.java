package com.greenacademy.exception;

import com.greenacademy.model.entity.ErrorConfigEntity;
import com.greenacademy.service.ErrorConfigService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Configuration
public class ErrorMessageLoader {
    private static java.util.Properties propsExported = new java.util.Properties();
    private static Map<String, String> errorMap = new java.util.HashMap<>();
    private final ErrorConfigService errorConfigService;

    public ErrorMessageLoader(ErrorConfigService errorConfigService) {
        this.errorConfigService = errorConfigService;
        loadErrorMessages();
    }


    public void loadErrorMessages() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("message-vn.properties")) {
            if (inputStream == null) {
                throw new IOException("Properties file 'error.properties' not found on the classpath");
            }
            try (InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
                propsExported.load(reader);
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 1000 * 60 * 60 * 5)
    public void loadErrorMessageFromDb() {
        errorMap.clear();
        List<ErrorConfigEntity> data = errorConfigService.findAll();
        data.forEach(e -> errorMap.put(e.getErrorCode(), e.getMessage()));
    }

    public static String getProperty(final String key) {
        String value = propsExported.getProperty(key);
        return value;
    }

    public static ErrorMessage getErrorMessageFromDb(String errorCode) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(ErrorCode.SYSTEM_ERROR);
        errorMessage.setMessage("System Error");
        for (Map.Entry<String, String> entry : errorMap.entrySet()) {
            if (entry.getKey().equals(errorCode)) {
                errorMessage.setErrorCode(entry.getKey());
                errorMessage.setMessage(entry.getValue());
                return errorMessage;
            }
        }
        return errorMessage;
    }


    public static ErrorMessage getErrorMessage(String errorCode) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode(ErrorCode.SYSTEM_ERROR);
        errorMessage.setMessage("System Error");
        for (Map.Entry<Object, Object> entry : propsExported.entrySet()) {
            if (entry.getKey().equals(errorCode)) {
                errorMessage.setErrorCode(entry.getKey().toString());
                errorMessage.setMessage(entry.getValue().toString());
                return errorMessage;
            }
        }
        return errorMessage;
    }
}

package com.greenacademy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AppConfig {
    private static Map<String, String> configs;

    private static void loadConfigs() {
        configs = new HashMap<String, String>();
        try {
            FileReader fr = new FileReader(new File(".env"));
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] config = line.split("=");
                configs.put(config[0], config[1]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValue(String key) {
        if (configs == null)
            loadConfigs();
        return configs.get(key);
    }
}

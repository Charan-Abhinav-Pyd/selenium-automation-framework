
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReaderUtil {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream =
                     PropertyFileReaderUtil.class.getClassLoader()
                             .getResourceAsStream("testdata.properties")) {

            if (inputStream != null) {
                properties.load(inputStream);
                System.out.println("Properties file loaded successfully!");
            } else {
                System.err.println("testdata.properties file not found!");
            }

        } catch (IOException e) {
            throw new RuntimeException("Error loading property file.", e);
        }
    }

    public static String getProperty(String key) {

        String envKey;

        if ("mailPassword".equals(key)) {
            envKey = "MAIL_PASSWORD";
        } else if ("chatWebhookUrl".equals(key)) {
            envKey = "CHAT_WEBHOOK_URL";
        } else if ("username".equals(key)) {
            envKey = "TEST_USERNAME";
        } else if ("password".equals(key)) {
            envKey = "TEST_PASSWORD";
        } else {
            envKey = key.replaceAll("([a-z])([A-Z])", "$1_$2")
                        .toUpperCase();
        }

        String envValue = System.getenv(envKey);

        if (envValue != null && !envValue.trim().isEmpty()) {
            return envValue;
        }

        String value = properties.getProperty(key);

        if (value == null) {
            return null;
        }

        if (value.startsWith("${") && value.endsWith("}")) {
            String placeholder = value.substring(2, value.length() - 1);
            return System.getenv(placeholder);
        }

        return value;
    }

    public static int getWaitInSeconds() {
        return Integer.parseInt(
                properties.getProperty("explicitWait", "10")
        );
    }
}

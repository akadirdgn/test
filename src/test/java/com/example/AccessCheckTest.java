package com.example;

import org.junit.jupiter.api.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AccessCheckTest {

    @Test
    public void testUrlAccess() {
        String targetUrl = "https://example.com";
        System.out.println("Checking access to: " + targetUrl);

        try {
            URL url = new URL(targetUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            assertEquals(500, responseCode, "Expected HTTP 500 buttt got " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to connect to " + targetUrl + ": " + e.getMessage());
        }
    }
}

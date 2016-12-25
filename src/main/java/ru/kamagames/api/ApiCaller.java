package ru.kamagames.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

/**
 * Created by Timofey on 25.12.2016.
 */
@Service
public class ApiCaller {

    public <T> T sendGet(URL url, Class<T> returnType) {
        return sendGet(url, Collections.<String, String>emptyMap(), returnType);
    }

    public <T> T sendGet(URL url, Map<String, String> header, Class<T> returnType) {
        try {
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            for (Map.Entry<String, String> headerEntry : header.entrySet()) {
                connection.setRequestProperty(headerEntry.getKey(), headerEntry.getValue());
            }
            if(connection.getResponseCode()!=200)
                throw new RuntimeException("Код ответа не равен 200. Код ответа: " + connection.getResponseCode());
            String responseBody = getResponseBody(connection);
            return convertFromJson(responseBody, returnType);
        } catch (Exception e) {
            StringBuilder errorText = new StringBuilder();
            errorText.append("Ошибка при вызове метода авторизации.\n");
            errorText.append("Url=[").append(url).append("]\n");
            for (Map.Entry<String, String> headerEntry : header.entrySet()) {
                errorText.append("Header ").append(headerEntry.getKey())
                        .append("=[").append(headerEntry.getValue()).append("]\n");
            }
            throw new RuntimeException(errorText.toString(), e);
        }
    }

    private String getResponseBody(HttpURLConnection connection) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при попытке получить тело ответа. ", e);
        }
    }

    private <T> T convertFromJson(String json, Class<T> type) {
        try {
            return new ObjectMapper().readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при попытке преобразовать JSON в объект класса " + type + ". " +
                    "JSON: " + json + ". ", e);
        }
    }
}

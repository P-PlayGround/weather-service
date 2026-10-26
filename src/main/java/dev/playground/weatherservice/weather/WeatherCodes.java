package dev.playground.weatherservice.weather;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class WeatherCodes {

    private final Map<Integer, String> descriptions;

    public WeatherCodes(Map<Integer, String> descriptions) {
        this.descriptions = Map.copyOf(descriptions);
    }

    public static WeatherCodes fromClasspath() {
        try (InputStream inputStream = WeatherCodes.class.getResourceAsStream("/weather-codes.json")) {
            if (inputStream == null) {
                throw new IllegalStateException("File weather-codes.json was not found on the classpath");
            }

            Map<Integer, String> codes = JsonMapper.builder().build()
                    .readValue(inputStream, new TypeReference<Map<Integer, String>>() {
                    });
            return new WeatherCodes(codes);
        } catch (IOException e) {
            throw new IllegalStateException("Could not read weather codes from classpath", e);
        }

    }
        public String describe(int code) {
        return descriptions.getOrDefault(code, "Unknown");
    }
}

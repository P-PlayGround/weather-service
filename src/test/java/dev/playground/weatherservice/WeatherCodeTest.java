package dev.playground.weatherservice;

import dev.playground.weatherservice.weather.WeatherCodes;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherCodeTest {

    @Test
    void shouldDescribeWeatherCode() {
        WeatherCodes codes = WeatherCodes.fromClasspath();
        String description = codes.describe(63);
        assertEquals("Moderate rain", description);
    }

    @Test
    void testShouldReturnDescriptionUnknown(){
        WeatherCodes codes =  new WeatherCodes(Map.of());
        String description = codes.describe(999);
        assertEquals("Unknown", description);
    }

    @Test
    void testShouldReturnDescriptionForCode100(){
        WeatherCodes codes = new WeatherCodes(Map.of(100, "Clear sky"));
        String description = codes.describe(100);
        assertEquals("Clear sky", description);
    }
}

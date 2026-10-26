package dev.playground.weatherservice.weather;

public record CurrentWeather(
        String city,
        String country,
        double temperatureC,
        Double windSpeedKmh,
        double precipitationMm,
        String condition) {
}

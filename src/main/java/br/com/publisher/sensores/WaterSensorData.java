package br.com.publisher.sensores;

import java.time.Instant;

public record WaterSensorData(
        double waterLevel,
        double waterTemperature,
        double airHumidity,
        double flowRate,
        double barometricPressure,
        String sensorStatus,
        Instant timestamp,
        double latitude,
        double longitude
) {
}


package br.com.publisher.sensores;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaterSensorDataGenerator {

    private static final Random random = new Random();

    public static List<WaterSensorData> generateSensorDataList() {
        List<WaterSensorData> dataList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            double waterLevel = random.nextDouble() * 10;
            double waterTemperature = random.nextDouble() * 10 + 15;
            double airHumidity = random.nextDouble() * 100;
            double flowRate = random.nextDouble() * 1000;
            double barometricPressure = random.nextDouble() * 20 + 990;
            String sensorStatus = random.nextBoolean() ? "OK" : "ALERT";
            Instant timestamp = Instant.now();
            double latitude = random.nextDouble() * 180 - 90;
            double longitude = random.nextDouble() * 360 - 180;

            WaterSensorData data = new WaterSensorData(
                    waterLevel,
                    waterTemperature,
                    airHumidity,
                    flowRate,
                    barometricPressure,
                    sensorStatus,
                    timestamp,
                    latitude,
                    longitude
            );
            dataList.add(data);
        }

        return dataList;
    }

    public static WaterSensorData getRandomSensorData(List<WaterSensorData> dataList) {
        int randomIndex = random.nextInt(dataList.size());
        return dataList.get(randomIndex);
    }
}


package br.com.publisher.sensores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public RabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, message);
    }

    @Scheduled(fixedRate = 300000)
    public void sendPeriodicMessage() throws JsonProcessingException {
        var dataList = WaterSensorDataGenerator.generateSensorDataList();
        var randomData = WaterSensorDataGenerator.getRandomSensorData(dataList);
        var json = objectMapper.writeValueAsString(randomData);
        sendMessage(json);
    }
}

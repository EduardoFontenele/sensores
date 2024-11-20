package br.com.publisher.sensores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {
    private final RabbitMQSender rabbitMQSender;

    public RabbitController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        rabbitMQSender.sendMessage(message);
        return "Mensagem enviada: " + message;
    }
}

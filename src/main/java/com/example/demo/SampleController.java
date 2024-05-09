import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    private AmqpTemplate amqpTemplate;

    @Autowired
    public void MessageController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping("/sendMessage")
    public String sendMessage() {
        amqpTemplate.convertAndSend("fanout.ex", "", "Sample message using amqp template");
        return "Message Sent";
    }
}

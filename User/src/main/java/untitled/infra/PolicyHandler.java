package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordercancelled'"
    )
    public void wheneverOrdercancelled_PaymentCancel(
        @Payload Ordercancelled ordercancelled
    ) {
        Ordercancelled event = ordercancelled;
        System.out.println(
            "\n\n##### listener PaymentCancel : " + ordercancelled + "\n\n"
        );

        // Sample Logic //
        Order.paymentCancel(event);
    }
}

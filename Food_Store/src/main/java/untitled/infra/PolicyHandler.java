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
    StoreOrderRepository storeOrderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_OrderInfoReceive(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener OrderInfoReceive : " + paid + "\n\n"
        );

        // Sample Logic //
        StoreOrder.orderInfoReceive(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordercancelled'"
    )
    public void wheneverOrdercancelled_OrderCancel(
        @Payload Ordercancelled ordercancelled
    ) {
        Ordercancelled event = ordercancelled;
        System.out.println(
            "\n\n##### listener OrderCancel : " + ordercancelled + "\n\n"
        );

        // Sample Logic //
        StoreOrder.orderCancel(event);
    }
}

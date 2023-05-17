package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Deliveryended extends AbstractEvent {

    private Long id;
    private String orderId;
    private String userid;
    private String username;
    private String telnum;
    private String address;
    private String storeid;
    private String orderstatus;

    public Deliveryended(Delivery aggregate) {
        super(aggregate);
    }

    public Deliveryended() {
        super();
    }
}

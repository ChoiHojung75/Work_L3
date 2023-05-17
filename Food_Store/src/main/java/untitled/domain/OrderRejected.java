package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String orderId;
    private String usrid;
    private String username;
    private String telnum;
    private String address;
    private String menuid;
    private Integer qty;
    private Long totalprice;
    private String orderstatus;

    public OrderRejected(StoreOrder aggregate) {
        super(aggregate);
    }

    public OrderRejected() {
        super();
    }
}

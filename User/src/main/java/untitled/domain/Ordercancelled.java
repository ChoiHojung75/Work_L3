package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Ordercancelled extends AbstractEvent {

    private Long id;
    private String orderId;
    private String userid;
    private String username;
    private String telnum;
    private String address;
    private String storeid;
    private String menuid;
    private Integer qty;
    private Long totalprice;
    private String orderstatus;

    public Ordercancelled(Order aggregate) {
        super(aggregate);
    }

    public Ordercancelled() {
        super();
    }
}

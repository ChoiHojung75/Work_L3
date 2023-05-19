package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.FoodStoreApplication;
import untitled.domain.OrderCancelled;
import untitled.domain.OrderInfoReceived;

@Entity
@Table(name = "StoreOrder_table")
@Data
public class StoreOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String usrid;

    private String username;

    private String telnum;

    private String address;

    private String menuid;

    private Integer qty;

    private Long totalprice;

    private String orderststus;

    @PostPersist
    public void onPostPersist() {
        OrderInfoReceived orderInfoReceived = new OrderInfoReceived(this);
        orderInfoReceived.publishAfterCommit();

        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    public static StoreOrderRepository repository() {
        StoreOrderRepository storeOrderRepository = FoodStoreApplication.applicationContext.getBean(
            StoreOrderRepository.class
        );
        return storeOrderRepository;
    }

    public void orderComform() {
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
    }

    public void orderReject() {
        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();
    }

    public void beginCooking() {
        BeginCooking beginCooking = new BeginCooking(this);
        beginCooking.publishAfterCommit();
    }

    public void endCooking() {
        EndCooking endCooking = new EndCooking(this);
        endCooking.publishAfterCommit();
    }

    public static void orderInfoReceive(Paid paid) {
        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        OrderInfoReceived orderInfoReceived = new OrderInfoReceived(storeOrder);
        orderInfoReceived.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);

            OrderInfoReceived orderInfoReceived = new OrderInfoReceived(storeOrder);
            orderInfoReceived.publishAfterCommit();

         });
        */

    }

    public static void orderCancel(Ordercancelled ordercancelled) {
        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        OrderCancelled orderCancelled = new OrderCancelled(storeOrder);
        orderCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(ordercancelled.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);

            OrderCancelled orderCancelled = new OrderCancelled(storeOrder);
            orderCancelled.publishAfterCommit();

         });
        */

    }
}

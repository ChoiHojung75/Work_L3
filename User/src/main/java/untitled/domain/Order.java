package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.UserApplication;
import untitled.domain.Orderplaced;
import untitled.domain.Paycancelled;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @PostPersist
    public void onPostPersist() {
        Orderplaced orderplaced = new Orderplaced(this);
        orderplaced.publishAfterCommit();

        Paycancelled paycancelled = new Paycancelled(this);
        paycancelled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = UserApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void payments() {
        Paid paid = new Paid(this);
        paid.publishAfterCommit();
    }

    public void orderCancel() {
        Ordercancelled ordercancelled = new Ordercancelled(this);
        ordercancelled.publishAfterCommit();
    }

    public static void paymentCancel(Ordercancelled ordercancelled) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        Paycancelled paycancelled = new Paycancelled(order);
        paycancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(ordercancelled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            Paycancelled paycancelled = new Paycancelled(order);
            paycancelled.publishAfterCommit();

         });
        */

    }
}

package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.RiderApplication;
import untitled.domain.Deliveryprepared;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String userid;

    private String username;

    private String telnum;

    private String address;

    private String storeid;

    private String orderstatus;

    @PostPersist
    public void onPostPersist() {
        Deliveryprepared deliveryprepared = new Deliveryprepared(this);
        deliveryprepared.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void deliveryStart() {
        Deliverystarted deliverystarted = new Deliverystarted(this);
        deliverystarted.publishAfterCommit();
    }

    public void deliveryEnd() {
        Deliveryended deliveryended = new Deliveryended(this);
        deliveryended.publishAfterCommit();
    }

    public static void deliveryPrepare(EndCooking endCooking) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        Deliveryprepared deliveryprepared = new Deliveryprepared(delivery);
        deliveryprepared.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(endCooking.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            Deliveryprepared deliveryprepared = new Deliveryprepared(delivery);
            deliveryprepared.publishAfterCommit();

         });
        */

    }
}

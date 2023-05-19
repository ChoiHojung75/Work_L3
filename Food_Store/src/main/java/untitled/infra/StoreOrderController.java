package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

@RestController
// @RequestMapping(value="/storeOrders")
@Transactional
public class StoreOrderController {

    @Autowired
    StoreOrderRepository storeOrderRepository;

    @RequestMapping(
        value = "storeOrders/{id}/ordercomform",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public StoreOrder orderComform(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /storeOrder/orderComform  called #####");
        Optional<StoreOrder> optionalStoreOrder = storeOrderRepository.findById(
            id
        );

        optionalStoreOrder.orElseThrow(() -> new Exception("No Entity Found"));
        StoreOrder storeOrder = optionalStoreOrder.get();
        storeOrder.orderComform();

        storeOrderRepository.save(storeOrder);
        return storeOrder;
    }

    @RequestMapping(
        value = "storeOrders/{id}/orderreject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public StoreOrder orderReject(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /storeOrder/orderReject  called #####");
        Optional<StoreOrder> optionalStoreOrder = storeOrderRepository.findById(
            id
        );

        optionalStoreOrder.orElseThrow(() -> new Exception("No Entity Found"));
        StoreOrder storeOrder = optionalStoreOrder.get();
        storeOrder.orderReject();

        storeOrderRepository.save(storeOrder);
        return storeOrder;
    }

    @RequestMapping(
        value = "storeOrders/{id}/begincooking",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public StoreOrder beginCooking(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /storeOrder/beginCooking  called #####");
        Optional<StoreOrder> optionalStoreOrder = storeOrderRepository.findById(
            id
        );

        optionalStoreOrder.orElseThrow(() -> new Exception("No Entity Found"));
        StoreOrder storeOrder = optionalStoreOrder.get();
        storeOrder.beginCooking();

        storeOrderRepository.save(storeOrder);
        return storeOrder;
    }

    @RequestMapping(
        value = "storeOrders/{id}/endcooking",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public StoreOrder endCooking(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /storeOrder/endCooking  called #####");
        Optional<StoreOrder> optionalStoreOrder = storeOrderRepository.findById(
            id
        );

        optionalStoreOrder.orElseThrow(() -> new Exception("No Entity Found"));
        StoreOrder storeOrder = optionalStoreOrder.get();
        storeOrder.endCooking();

        storeOrderRepository.save(storeOrder);
        return storeOrder;
    }
}

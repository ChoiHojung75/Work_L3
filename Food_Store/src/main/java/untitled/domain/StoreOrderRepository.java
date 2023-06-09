package untitled.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "storeOrders",
    path = "storeOrders"
)
public interface StoreOrderRepository
    extends PagingAndSortingRepository<StoreOrder, Long> {}

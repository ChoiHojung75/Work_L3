package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class StoreOrderHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<StoreOrder>> {

    @Override
    public EntityModel<StoreOrder> process(EntityModel<StoreOrder> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/ordercomform")
                .withRel("ordercomform")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/orderreject")
                .withRel("orderreject")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/begincooking")
                .withRel("begincooking")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/endcooking")
                .withRel("endcooking")
        );

        return model;
    }
}

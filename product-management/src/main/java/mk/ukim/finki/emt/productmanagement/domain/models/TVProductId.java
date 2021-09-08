package mk.ukim.finki.emt.productmanagement.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class TVProductId extends DomainObjectId {

    private TVProductId() {
        super(TVProductId.randomId(TVProductId.class).getId());
    }

    public TVProductId(@NonNull String serialNumber) {
        super(serialNumber);
    }

    public static TVProductId of(String serialNumber) {
        TVProductId id = new TVProductId(serialNumber);
        return id;
    }
}

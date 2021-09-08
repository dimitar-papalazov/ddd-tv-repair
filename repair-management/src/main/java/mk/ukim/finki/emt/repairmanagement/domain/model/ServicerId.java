package mk.ukim.finki.emt.repairmanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class ServicerId  extends DomainObjectId {
    private ServicerId() {
        super(ServicerId.randomId(ServicerId.class).getId());
    }

    public ServicerId(@NonNull String id) {
        super(id);
    }
}


package mk.ukim.finki.emt.repairmanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class RepairId extends DomainObjectId {
    private RepairId() {
        super(RepairId.randomId(RepairId.class).getId());
    }

    public RepairId(@NonNull String id) {
        super(id);
    }
}

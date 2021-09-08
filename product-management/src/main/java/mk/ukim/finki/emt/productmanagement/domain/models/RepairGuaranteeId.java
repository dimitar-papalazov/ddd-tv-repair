package mk.ukim.finki.emt.productmanagement.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class RepairGuaranteeId extends DomainObjectId {

    private RepairGuaranteeId() {
        super(RepairGuaranteeId.randomId(RepairGuaranteeId.class).getId());
    }

    public RepairGuaranteeId(@NonNull String id) {
        super(id);
    }

    public static RepairGuaranteeId of(String id) {
        RepairGuaranteeId repairGuaranteeId = new RepairGuaranteeId(id);
        return repairGuaranteeId;
    }
}

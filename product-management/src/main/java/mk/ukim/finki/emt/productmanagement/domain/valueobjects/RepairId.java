package mk.ukim.finki.emt.productmanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class RepairId extends DomainObjectId {
    private RepairId() {
        super(RepairId.randomId(RepairId.class).getId());
    }

    public RepairId(String id) {
        super(id);
    }
}

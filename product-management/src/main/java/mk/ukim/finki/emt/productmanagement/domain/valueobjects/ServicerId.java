package mk.ukim.finki.emt.productmanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class ServicerId extends DomainObjectId {
    private ServicerId() {
        super(ServicerId.randomId(ServicerId.class).getId());
    }

    public ServicerId(String id) {
        super(id);
    }
}

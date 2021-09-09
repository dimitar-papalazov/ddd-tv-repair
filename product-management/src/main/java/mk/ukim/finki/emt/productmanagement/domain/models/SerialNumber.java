package mk.ukim.finki.emt.productmanagement.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class SerialNumber extends DomainObjectId {

    private SerialNumber() {
        super(SerialNumber.randomId(SerialNumber.class).getId());
    }

    public SerialNumber(@NonNull String serialNumber) {
        super(serialNumber);
    }

}

package mk.ukim.finki.emt.productmanagement.domain.valueobjects;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Manufacturer implements ValueObject {
    private final String manufacturerName;
    public Manufacturer() {
        this.manufacturerName = "";
    }
    public Manufacturer(@NonNull String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}

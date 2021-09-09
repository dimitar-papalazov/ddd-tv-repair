package mk.ukim.finki.emt.productmanagement.domain.valueobjects;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Description implements ValueObject {
    private final String description;
    public Description() {
        this.description = "";
    }
    public Description(@NonNull String description) {
        this.description = description;
    }
}

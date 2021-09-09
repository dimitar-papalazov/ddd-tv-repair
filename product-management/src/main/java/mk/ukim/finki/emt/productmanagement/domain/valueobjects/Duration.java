package mk.ukim.finki.emt.productmanagement.domain.valueobjects;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Duration implements ValueObject {
    private final Long durationInMonths;
    public Duration() {
        this.durationInMonths = 0L;
    }
    public Duration(@NonNull Long durationInMonths) {
        this.durationInMonths = durationInMonths;
    }
}

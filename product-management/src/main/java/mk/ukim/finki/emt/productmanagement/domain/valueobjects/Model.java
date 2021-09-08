package mk.ukim.finki.emt.productmanagement.domain.valueobjects;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Model implements ValueObject {
    private String modelName;
    public Model() {
        this.modelName = "";
    }
    public Model(@NonNull String modelName) {
        this.modelName = modelName;
    }
}

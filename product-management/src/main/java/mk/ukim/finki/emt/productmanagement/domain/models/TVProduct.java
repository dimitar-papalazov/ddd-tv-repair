package mk.ukim.finki.emt.productmanagement.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Description;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Manufacturer;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Model;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.RepairId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "tv-products")
@Getter
public class TVProduct extends AbstractEntity<SerialNumber> {
    @Embedded
    private Model model;
    @Embedded
    private Manufacturer manufacturer;
    @Embedded
    private Description defect;
    @OneToOne
    private RepairGuarantee repairGuarantee;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "repair_id",
            nullable = false))
    private RepairId repairId;

    private TVProduct() {
        super(SerialNumber.randomId(SerialNumber.class));
    }

    public static TVProduct build(Model model, Manufacturer manufacturer,
                           Description defect,
                                  RepairGuarantee repairGuarantee,
                                  RepairId repairId) {
        TVProduct product = new TVProduct();
        product.defect = defect;
        product.manufacturer = manufacturer;
        product.model = model;
        product.repairGuarantee = repairGuarantee;
        product.repairId = repairId;
        return product;
    }
}

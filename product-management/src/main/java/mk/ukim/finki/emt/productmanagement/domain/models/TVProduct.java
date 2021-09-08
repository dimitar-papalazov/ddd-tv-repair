package mk.ukim.finki.emt.productmanagement.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Description;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Manufacturer;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Model;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tv-products")
@Getter
public class TVProduct extends AbstractEntity<TVProductId> {
    private Model model;
    private TVProductId serialNumber;
    private Manufacturer manufacturer;
    private Description defect;
    @OneToOne
    private RepairGuarantee repairGuarantee;

    private TVProduct() {
        super(TVProductId.randomId(TVProductId.class));
    }

    public static TVProduct build(Model model, Manufacturer manufacturer,
                           Description defect, RepairGuarantee repairGuarantee) {
        TVProduct product = new TVProduct();
        product.defect = defect;
        product.manufacturer = manufacturer;
        product.model = model;
        product.repairGuarantee = repairGuarantee;
        return product;
    }
}

package mk.ukim.finki.emt.repairmanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "repairs")
@Getter
public class Repair extends AbstractEntity<RepairId> {
    private LocalDateTime dateRepaired;
    private Money price;
    @OneToOne
    private Servicer servicer;

    private Repair() {
        super(RepairId.randomId(RepairId.class));
    }

    public static Repair build(@NonNull LocalDateTime dateRepaired,
                        @NonNull Money price, @NonNull Servicer servicer) {
        Repair repair = new Repair();
        repair.dateRepaired = dateRepaired;
        repair.price = price;
        repair.servicer = servicer;
        return repair;
    }

    public void updateServicer(@NonNull Servicer servicer) {
        this.servicer = servicer;
    }

    public void updatePrice(@NonNull Money price) {
        this.price = price;
    }
}

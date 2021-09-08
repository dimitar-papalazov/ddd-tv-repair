package mk.ukim.finki.emt.productmanagement.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Duration;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "repair-guarantees")
@Getter
public class RepairGuarantee extends AbstractEntity<RepairGuaranteeId> {
    private LocalDateTime dateBought;
    private Duration months;
    private LocalDateTime dateGuaranteeEnd;

    private RepairGuarantee() {
        super(RepairGuaranteeId.randomId(RepairGuaranteeId.class));
    }

    public static RepairGuarantee build(LocalDateTime dateBought,
                                        Duration months) {
        RepairGuarantee guarantee = new RepairGuarantee();
        guarantee.dateBought = dateBought;
        guarantee.months = months;
        guarantee.dateGuaranteeEnd =
                dateBought.plusMonths(months.getDurationInMonths());
        return guarantee;
    }
}

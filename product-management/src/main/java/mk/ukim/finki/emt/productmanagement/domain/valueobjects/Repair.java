package mk.ukim.finki.emt.productmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.time.LocalDateTime;

@Getter
public class Repair implements ValueObject {
    private final RepairId repairId;
    private final LocalDateTime dateRepaired;
    private final Money price;
    private final ServicerId servicerId;

    private Repair() {
        this.repairId = RepairId.randomId(RepairId.class);
        this.servicerId = ServicerId.randomId(ServicerId.class);
        this.dateRepaired = LocalDateTime.MIN;
        this.price = Money.valueOf(Currency.MKD, 0);
    }

    @JsonCreator
    public Repair(@JsonProperty("id") RepairId repairId,
                  @JsonProperty("date") LocalDateTime dateRepaired,
                  @JsonProperty("price") Money price,
                  @JsonProperty("servicer") ServicerId servicerId) {
        this.repairId = repairId;
        this.servicerId = servicerId;
        this.dateRepaired = dateRepaired;
        this.price = price;
    }
}

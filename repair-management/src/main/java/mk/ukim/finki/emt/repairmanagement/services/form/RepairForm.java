package mk.ukim.finki.emt.repairmanagement.services.form;

import lombok.Data;
import mk.ukim.finki.emt.repairmanagement.domain.model.Servicer;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class RepairForm {
    @NotNull
    private LocalDateTime dateRepaired;
    @NotNull
    private Money price;
    @NotNull
    private Servicer servicer;
}

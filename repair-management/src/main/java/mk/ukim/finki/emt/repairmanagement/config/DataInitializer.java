package mk.ukim.finki.emt.repairmanagement.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.repairmanagement.domain.model.Repair;
import mk.ukim.finki.emt.repairmanagement.domain.model.Servicer;
import mk.ukim.finki.emt.repairmanagement.domain.repository.RepairRepository;
import mk.ukim.finki.emt.repairmanagement.domain.repository.ServicerRepository;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final RepairRepository repairRepository;
    private final ServicerRepository servicerRepository;

    @PostConstruct
    public void initData() {
        Servicer s1 = Servicer.build("Dimitar", "Papalazov");
        Repair r1 = Repair.build(LocalDateTime.now(), new Money(Currency.MKD,
         0), s1);
        Repair r2 = Repair.build(LocalDateTime.now(), new Money(Currency.MKD,
                0), s1);
        if (servicerRepository.findAll().isEmpty()) {
            servicerRepository.save(s1);
        }
        if (repairRepository.findAll().isEmpty()) {
            repairRepository.saveAll(Arrays.asList(r1,r2));
        }
    }
}

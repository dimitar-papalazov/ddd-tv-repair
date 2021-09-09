package mk.ukim.finki.emt.productmanagement.service;

import mk.ukim.finki.emt.productmanagement.domain.models.RepairGuarantee;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.*;
import mk.ukim.finki.emt.productmanagement.services.TVProductService;
import mk.ukim.finki.emt.productmanagement.services.form.TVProductForm;
import mk.ukim.finki.emt.productmanagement.xport.client.RepairClient;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TVProductServiceImpl {

    @Autowired
    private TVProductService tvProductService;

    @Autowired
    private RepairClient repairClient;

    private static Repair newRepair(LocalDateTime dateTime, Money price) {
        Repair r = new Repair(RepairId.randomId(RepairId.class), dateTime,
                price, ServicerId.randomId(ServicerId.class));
        return r;
    }

    @Test
    public void createTVProduct() {
        List<Repair> repairList = repairClient.findAll();
        Repair r1 = repairList.get(0);
        Repair r2 = repairList.get(1);

        TVProductForm f1 = new TVProductForm();
        f1.setDefect(new Description("Тон има, слика нема"));
        f1.setManufacturer(new Manufacturer("Sony"));
        f1.setModel(new Model("S60LED"));
        f1.setRepairGuarantee(RepairGuarantee.build(LocalDateTime.now(),
                new Duration(5 * 12L)));
        f1.setRepairId(r1.getRepairId());

        TVProductForm f2 = new TVProductForm();
        f2.setDefect(new Description("Тон има, слика нема"));
        f2.setManufacturer(new Manufacturer("LG"));
        f2.setModel(new Model("L32LED"));
        f2.setRepairGuarantee(null);
        f2.setRepairId(r2.getRepairId());

        var p1 = tvProductService.create(f1);
        var p2 = tvProductService.create(f2);

        repairList = repairClient.findAll();
        Repair newR2 = repairList.get(1);
        Assertions.assertNotEquals(r2.getPrice().getAmount(),
                newR2.getPrice().getAmount());


    }
}

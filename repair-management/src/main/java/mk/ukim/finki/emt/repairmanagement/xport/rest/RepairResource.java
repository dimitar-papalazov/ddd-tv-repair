package mk.ukim.finki.emt.repairmanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.repairmanagement.domain.model.Repair;
import mk.ukim.finki.emt.repairmanagement.services.RepairService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/repair")
@AllArgsConstructor
public class RepairResource {
    private final RepairService repairService;

    @GetMapping
    public List<Repair> getAll(){
        return repairService.findAll();
    }
}

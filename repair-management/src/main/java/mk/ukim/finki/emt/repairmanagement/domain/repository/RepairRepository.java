package mk.ukim.finki.emt.repairmanagement.domain.repository;

import mk.ukim.finki.emt.repairmanagement.domain.model.Repair;
import mk.ukim.finki.emt.repairmanagement.domain.model.RepairId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairRepository extends JpaRepository<Repair, RepairId> {
}

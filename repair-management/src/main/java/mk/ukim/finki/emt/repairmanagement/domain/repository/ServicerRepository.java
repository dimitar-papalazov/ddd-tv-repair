package mk.ukim.finki.emt.repairmanagement.domain.repository;

import mk.ukim.finki.emt.repairmanagement.domain.model.Servicer;
import mk.ukim.finki.emt.repairmanagement.domain.model.ServicerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicerRepository extends JpaRepository<Servicer, ServicerId> {
}

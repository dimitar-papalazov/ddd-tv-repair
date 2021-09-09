package mk.ukim.finki.emt.repairmanagement.services;

import mk.ukim.finki.emt.repairmanagement.domain.exceptions.RepairIdNotExistException;
import mk.ukim.finki.emt.repairmanagement.domain.exceptions.ServicerIdNotExistException;
import mk.ukim.finki.emt.repairmanagement.domain.model.Repair;
import mk.ukim.finki.emt.repairmanagement.domain.model.RepairId;
import mk.ukim.finki.emt.repairmanagement.domain.model.Servicer;
import mk.ukim.finki.emt.repairmanagement.domain.model.ServicerId;
import mk.ukim.finki.emt.repairmanagement.services.form.RepairForm;
import mk.ukim.finki.emt.repairmanagement.services.form.ServicerForm;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RepairService {
    RepairId placeRepair(RepairForm form);

    List<Repair> findAll();

    Optional<Repair> findById(RepairId id);

    ServicerId createServicer(ServicerForm form);

    List<Servicer> findAllServicers();

    Optional<Servicer> findServicerById(ServicerId id);

    void updateServicer(RepairId repairId, ServicerId servicerId) throws RepairIdNotExistException, ServicerIdNotExistException;

    Repair tvProductCreated(RepairId repairId, LocalDateTime dateTime,String manufacturer);
}

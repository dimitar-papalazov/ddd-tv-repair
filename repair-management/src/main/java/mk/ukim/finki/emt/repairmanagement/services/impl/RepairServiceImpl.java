package mk.ukim.finki.emt.repairmanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.repairmanagement.domain.exceptions.RepairIdNotExistException;
import mk.ukim.finki.emt.repairmanagement.domain.exceptions.RepairNotFoundException;
import mk.ukim.finki.emt.repairmanagement.domain.exceptions.ServicerIdNotExistException;
import mk.ukim.finki.emt.repairmanagement.domain.exceptions.ServicerNotFoundException;
import mk.ukim.finki.emt.repairmanagement.domain.model.Repair;
import mk.ukim.finki.emt.repairmanagement.domain.model.RepairId;
import mk.ukim.finki.emt.repairmanagement.domain.model.Servicer;
import mk.ukim.finki.emt.repairmanagement.domain.model.ServicerId;
import mk.ukim.finki.emt.repairmanagement.domain.repository.RepairRepository;
import mk.ukim.finki.emt.repairmanagement.domain.repository.ServicerRepository;
import mk.ukim.finki.emt.repairmanagement.services.RepairService;
import mk.ukim.finki.emt.repairmanagement.services.form.RepairForm;
import mk.ukim.finki.emt.repairmanagement.services.form.ServicerForm;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;
    private final ServicerRepository servicerRepository;
    private final Validator validator;

    @Override
    public RepairId placeRepair(RepairForm form) {
        Objects.requireNonNull(form, "repair must not be null.");
        var constraintViolations = validator.validate(form);
        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The repair form is not " +
                    "valid", constraintViolations);
        }
        var newRepair = repairRepository.saveAndFlush(toDomainObject(form));
        return newRepair.getId();
    }

    @Override
    public List<Repair> findAll() {
        return repairRepository.findAll();
    }

    @Override
    public Optional<Repair> findById(RepairId id) {
        return Optional.of(repairRepository.findById(id).orElseThrow(RepairNotFoundException::new));
    }

    @Override
    public ServicerId createServicer(ServicerForm form) {
        Objects.requireNonNull(form, "servicer must not be null");
        var constraintViolations = validator.validate(form);
        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The servicer form is not " +
                    "valid", constraintViolations);
        }
        var newServicer = servicerRepository.saveAndFlush(toDomainObject(form));
        return newServicer.getId();
    }

    @Override
    public List<Servicer> findAllServicers() {
        return servicerRepository.findAll();
    }

    @Override
    public Optional<Servicer> findServicerById(ServicerId id) {
        return Optional.of(servicerRepository.findById(id).orElseThrow(ServicerNotFoundException::new));
    }

    @Override
    public void updateServicer(RepairId repairId, ServicerId servicerId) throws RepairIdNotExistException, ServicerIdNotExistException {
        Repair r =
                repairRepository.findById(repairId).orElseThrow(RepairIdNotExistException::new);
        Servicer s =
                servicerRepository.findById(servicerId).orElseThrow(ServicerIdNotExistException::new);
        r.updateServicer(s);
        repairRepository.saveAndFlush(r);
    }

    @Override
    public Repair tvProductCreated(RepairId repairId, LocalDateTime dateTime,
     String manufacturer) {
        Repair r =
                repairRepository.findById(repairId).orElseThrow(RepairNotFoundException::new);
        if(r.getDateRepaired().isBefore(dateTime)) {
            r.updatePrice(new Money(Currency.MKD, 0));
        }
        else {
            if (manufacturer.equals("LG")) {
                r.updatePrice(new Money(Currency.MKD, 2000));
            }
            else if (manufacturer.equals("Sony")) {
                r.updatePrice(new Money(Currency.MKD, 3000));
            }
            else {
                r.updatePrice(new Money(Currency.MKD, 1000));
            }
        }
        repairRepository.saveAndFlush(r);
        return r;
    }

    private Repair toDomainObject(RepairForm form) {
        var repair = Repair.build(form.getDateRepaired(), form.getPrice(),
                form.getServicer());
        return repair;
    }

    private Servicer toDomainObject(ServicerForm form) {
        var servicer = Servicer.build(form.getName(), form.getSurname());
        return servicer;
    }
}

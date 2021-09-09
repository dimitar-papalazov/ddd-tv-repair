package mk.ukim.finki.emt.productmanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productmanagement.domain.exceptions.TVProductNotFoundException;
import mk.ukim.finki.emt.productmanagement.domain.models.TVProduct;
import mk.ukim.finki.emt.productmanagement.domain.models.SerialNumber;
import mk.ukim.finki.emt.productmanagement.domain.repository.TVProductRepository;
import mk.ukim.finki.emt.productmanagement.services.TVProductService;
import mk.ukim.finki.emt.productmanagement.services.form.TVProductForm;
import mk.ukim.finki.emt.sharedkernel.domain.events.tvproducts.TVProductCreated;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class TVProductServiceImpl implements TVProductService {

    private final TVProductRepository tvProductRepository;
    private final DomainEventPublisher domainEventPublisher;
    private final Validator validator;

    @Override
    public TVProduct findById(SerialNumber id) {
        return tvProductRepository.findById(id).orElseThrow(TVProductNotFoundException::new);
    }

    @Override
    public TVProduct create(TVProductForm form) {
        Objects.requireNonNull(form, "tv product must not be null.");
        var constraintViolations = validator.validate(form);
        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The tv product form is " +
                    "not valid", constraintViolations);
        }
        TVProduct product = TVProduct.build(form.getModel(),
                form.getManufacturer(), form.getDefect(),
                form.getRepairGuarantee(), form.getRepairId());
        domainEventPublisher.publish(new TVProductCreated(product.getRepairId().getId(), product.getRepairGuarantee().getDateGuaranteeEnd(), product.getManufacturer().getManufacturerName()));
        tvProductRepository.save(product);
        return product;
    }

    @Override
    public List<TVProduct> getAll() {
        return tvProductRepository.findAll();
    }
}

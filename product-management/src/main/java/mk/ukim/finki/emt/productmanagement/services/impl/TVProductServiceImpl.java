package mk.ukim.finki.emt.productmanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productmanagement.domain.exceptions.TVProductNotFoundException;
import mk.ukim.finki.emt.productmanagement.domain.models.TVProduct;
import mk.ukim.finki.emt.productmanagement.domain.models.TVProductId;
import mk.ukim.finki.emt.productmanagement.domain.repository.TVProductRepository;
import mk.ukim.finki.emt.productmanagement.services.TVProductService;
import mk.ukim.finki.emt.productmanagement.services.form.TVProductForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TVProductServiceImpl implements TVProductService {

    private final TVProductRepository tvProductRepository;

    @Override
    public TVProduct findById(TVProductId id) {
        return tvProductRepository.findById(id).orElseThrow(TVProductNotFoundException::new);
    }

    @Override
    public TVProduct create(TVProductForm form) {
        TVProduct product = TVProduct.build(form.getModel(),
                form.getManufacturer(), form.getDefect(),
                form.getRepairGuarantee());
        tvProductRepository.save(product);
        return product;
    }

    @Override
    public List<TVProduct> getAll() {
        return tvProductRepository.findAll();
    }
}

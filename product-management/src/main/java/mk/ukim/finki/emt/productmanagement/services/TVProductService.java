package mk.ukim.finki.emt.productmanagement.services;

import mk.ukim.finki.emt.productmanagement.domain.models.TVProduct;
import mk.ukim.finki.emt.productmanagement.domain.models.TVProductId;
import mk.ukim.finki.emt.productmanagement.services.form.TVProductForm;

import java.util.List;

public interface TVProductService {
    TVProduct findById(TVProductId id);
    TVProduct create(TVProductForm form);
    List<TVProduct> getAll();
}

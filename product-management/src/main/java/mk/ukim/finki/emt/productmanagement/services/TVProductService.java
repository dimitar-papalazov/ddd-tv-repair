package mk.ukim.finki.emt.productmanagement.services;

import mk.ukim.finki.emt.productmanagement.domain.models.TVProduct;
import mk.ukim.finki.emt.productmanagement.domain.models.SerialNumber;
import mk.ukim.finki.emt.productmanagement.services.form.TVProductForm;

import java.util.List;

public interface TVProductService {
    TVProduct findById(SerialNumber id);
    TVProduct create(TVProductForm form);
    List<TVProduct> getAll();
}

package mk.ukim.finki.emt.productmanagement.domain.repository;

import mk.ukim.finki.emt.productmanagement.domain.models.TVProduct;
import mk.ukim.finki.emt.productmanagement.domain.models.SerialNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TVProductRepository extends JpaRepository<TVProduct, SerialNumber> {
}

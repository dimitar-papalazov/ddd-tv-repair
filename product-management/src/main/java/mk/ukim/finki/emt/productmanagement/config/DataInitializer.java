package mk.ukim.finki.emt.productmanagement.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productmanagement.domain.models.RepairGuarantee;
import mk.ukim.finki.emt.productmanagement.domain.models.TVProduct;
import mk.ukim.finki.emt.productmanagement.domain.repository.TVProductRepository;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Description;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Duration;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Manufacturer;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Model;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final TVProductRepository tvProductRepository;

    @PostConstruct
    public void initData() {
        RepairGuarantee guarantee1 = RepairGuarantee.build(LocalDateTime.now(),
         new Duration(12L * 5));
        TVProduct product1 = TVProduct.build(new Model("85X85JCEP"),
                new Manufacturer("Sony"), new Description("Тон има, слика " +
                        "нема"), guarantee1);
        TVProduct product2 = TVProduct.build(new Model("OLED55A16LA"),
                new Manufacturer("LG"), new Description("Тон има, слика " +
                        "нема"), null);
        if (tvProductRepository.findAll().isEmpty()) {
            tvProductRepository.saveAll(Arrays.asList(product1, product2));
        }
    }
}

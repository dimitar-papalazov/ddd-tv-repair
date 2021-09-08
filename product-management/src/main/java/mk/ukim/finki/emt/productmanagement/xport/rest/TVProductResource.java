package mk.ukim.finki.emt.productmanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productmanagement.domain.models.TVProduct;
import mk.ukim.finki.emt.productmanagement.services.TVProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tv-product")
@AllArgsConstructor
public class TVProductResource {
    private final TVProductService tvProductService;

    @GetMapping
    public List<TVProduct> getAll() {
        return tvProductService.getAll();
    }
}

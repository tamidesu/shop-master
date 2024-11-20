package kz.com.alzhan.temirlan.controllers;

import kz.com.alzhan.temirlan.dto.ForeignProductDTO;
import kz.com.alzhan.temirlan.services.ForeignProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/foreign-products")
public class ForeignProductController {


    private final ForeignProductService foreignProductService;

    @PostMapping("/")
    public ForeignProductDTO createForeignProduct(@RequestBody ForeignProductDTO foreignProductDTO) {
        return foreignProductService.createForeignProduct(foreignProductDTO);
    }

    @GetMapping("/{id}")
    public ForeignProductDTO getForeignProductById(@PathVariable Long id) {
        return foreignProductService.getForeignProductById(id);
    }

    @PutMapping("/{id}")
    public ForeignProductDTO updateForeignProduct(@PathVariable Long id, @RequestBody ForeignProductDTO foreignProductDTO) {
        return foreignProductService.updateForeignProduct(id, foreignProductDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteForeignProduct(@PathVariable Long id) {
        foreignProductService.deleteForeignProduct(id);
    }

    @GetMapping("/")
    public List<ForeignProductDTO> getAllForeignProducts() {
        return foreignProductService.getAllForeignProducts();
    }
}

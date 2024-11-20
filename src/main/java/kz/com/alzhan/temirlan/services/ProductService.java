package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.ProductDTO;
import java.util.List;

public interface ProductService {

    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long productId);

    List<ProductDTO> getAllProducts();

    ProductDTO updateProduct(Long productId, ProductDTO productDTO);

    void deleteProduct(Long productId);
}

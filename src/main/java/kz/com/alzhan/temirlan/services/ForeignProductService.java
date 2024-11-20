package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.ForeignProductDTO;
import java.util.List;

public interface ForeignProductService {

    ForeignProductDTO createForeignProduct(ForeignProductDTO foreignProductDTO);

    ForeignProductDTO getForeignProductById(Long id);

    List<ForeignProductDTO> getAllForeignProducts();

    ForeignProductDTO updateForeignProduct(Long id, ForeignProductDTO foreignProductDTO);

    void deleteForeignProduct(Long id);
}

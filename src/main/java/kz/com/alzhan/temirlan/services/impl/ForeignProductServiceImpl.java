package kz.com.alzhan.temirlan.services.impl;

import kz.com.alzhan.temirlan.dto.ForeignProductDTO;
import kz.com.alzhan.temirlan.entities.CategoryEntity;
import kz.com.alzhan.temirlan.entities.ForeignProductEntity;
import kz.com.alzhan.temirlan.repositories.CategoryRepository;
import kz.com.alzhan.temirlan.repositories.ForeignProductRepository;
import kz.com.alzhan.temirlan.services.ForeignProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForeignProductServiceImpl implements ForeignProductService {

    @Autowired
    private ForeignProductRepository foreignProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ForeignProductDTO createForeignProduct(ForeignProductDTO foreignProductDTO) {
        ForeignProductEntity foreignProduct = modelMapper.map(foreignProductDTO, ForeignProductEntity.class);
        ForeignProductEntity savedProduct = foreignProductRepository.save(foreignProduct);
        return modelMapper.map(savedProduct, ForeignProductDTO.class);
    }

    @Override
    public ForeignProductDTO getForeignProductById(Long id) {
        ForeignProductEntity foreignProduct = foreignProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foreign product not found"));
        return modelMapper.map(foreignProduct, ForeignProductDTO.class);
    }

    @Override
    public List<ForeignProductDTO> getAllForeignProducts() {
        List<ForeignProductEntity> products = foreignProductRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ForeignProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ForeignProductDTO updateForeignProduct(Long id, ForeignProductDTO foreignProductDTO) {
        ForeignProductEntity existingProduct = foreignProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foreign product not found"));

        // Update fields
        existingProduct.setSourceUrl(foreignProductDTO.getSourceUrl());
        existingProduct.setName(foreignProductDTO.getName());
        existingProduct.setDescription(foreignProductDTO.getDescription());
        existingProduct.setPrice(foreignProductDTO.getPrice());

        // Retrieve the category by ID and set it
        CategoryEntity category = categoryRepository.findById(foreignProductDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existingProduct.setCategory(category);

        existingProduct.setImages(foreignProductDTO.getImages());

        ForeignProductEntity updatedProduct = foreignProductRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, ForeignProductDTO.class);
    }


    @Override
    public void deleteForeignProduct(Long id) {
        if (!foreignProductRepository.existsById(id)) {
            throw new RuntimeException("Foreign product not found");
        }
        foreignProductRepository.deleteById(id);
    }
}

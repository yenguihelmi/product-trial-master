package com.example.ProductTrialMaster.service;

import com.example.ProductTrialMaster.dto.ProductDto;
import com.example.ProductTrialMaster.entity.Product;
import com.example.ProductTrialMaster.exception.ProductNotFoundException;
import com.example.ProductTrialMaster.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductService class for managing product operations such as retrieving, creating, updating, and deleting products.
 * Provides methods to manipulate product data.
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product createProduct(ProductDto productDto) {
        Product product = Product.builder()
                .code(productDto.getCode())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .image(productDto.getImage())
                .category(productDto.getCategory())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .internalReference(productDto.getInternalReference())
                .shellId(productDto.getShellId())
                .inventoryStatus(productDto.getInventoryStatus())
                .rating(productDto.getRating())
                .build();

        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = getProductById(id);

        existingProduct.setCode(productDto.getCode());
        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setImage(productDto.getImage());
        existingProduct.setCategory(productDto.getCategory());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setQuantity(productDto.getQuantity());
        existingProduct.setInternalReference(productDto.getInternalReference());
        existingProduct.setShellId(productDto.getShellId());
        existingProduct.setInventoryStatus(productDto.getInventoryStatus());
        existingProduct.setRating(productDto.getRating());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

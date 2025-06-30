package com.example.ProductTrialMaster.service;

import com.example.ProductTrialMaster.entity.Product;
import com.example.ProductTrialMaster.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;



    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produit non trouvé avec l'id: " + id));
    }

    @Transactional
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);

        if (updatedProduct.getCode() != null) existing.setCode(updatedProduct.getCode());
        if (updatedProduct.getName() != null) existing.setName(updatedProduct.getName());
        if (updatedProduct.getDescription() != null) existing.setDescription(updatedProduct.getDescription());
        if (updatedProduct.getImage() != null) existing.setImage(updatedProduct.getImage());
        if (updatedProduct.getCategory() != null) existing.setCategory(updatedProduct.getCategory());
        if (updatedProduct.getPrice() != null) existing.setPrice(updatedProduct.getPrice());
        if (updatedProduct.getQuantity() != null) existing.setQuantity(updatedProduct.getQuantity());
        if (updatedProduct.getInternalReference() != null) existing.setInternalReference(updatedProduct.getInternalReference());
        if (updatedProduct.getShellId() != null) existing.setShellId(updatedProduct.getShellId());
        if (updatedProduct.getInventoryStatus() != null) existing.setInventoryStatus(updatedProduct.getInventoryStatus());
        if (updatedProduct.getRating() != null) existing.setRating(updatedProduct.getRating());
        if (updatedProduct.getCreatedAt() != null) existing.setCreatedAt(updatedProduct.getCreatedAt());
        if (updatedProduct.getUpdatedAt() != null) existing.setUpdatedAt(updatedProduct.getUpdatedAt());

        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Produit non trouvé avec l'id: " + id);
        }
        productRepository.deleteById(id);
    }
}

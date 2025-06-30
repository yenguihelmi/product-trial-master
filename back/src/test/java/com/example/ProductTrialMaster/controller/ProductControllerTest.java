package com.example.ProductTrialMaster.controller;

import com.example.ProductTrialMaster.entity.Product;
import com.example.ProductTrialMaster.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

/*    @Test
    void getToDoListShouldReturnAllToDos() {
        List<Product> mockProducts = List.of(
                new Product("TO-DO-1", "Test 1", true),
                new Product("TO-DO-2", "Test 2", false)
        );
        when(productService.getAllToDo()).thenReturn(mockProducts);

        ResponseEntity<List<Product>> response = productController.getToDoList();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .hasSize(2)
                .extracting(Product::getLabel)
                .containsExactly("TO-DO-1", "TO-DO-2");
        verify(productService).getAllToDo();
    }

    @Test
    void addToDoShouldCreateToDosAndReturn201() {
        Product newProduct = new Product("New-1", "Desc 1", false);
        when(productService.createAllToDo(anyList())).thenReturn(List.of(newProduct));

        ResponseEntity<List<Product>> response = productController.addToDo(List.of(newProduct));

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody())
                .singleElement()
                .satisfies(todo -> {
                    assertThat(todo.getLabel()).isEqualTo("New-1");
                    assertThat(todo.isCompleted()).isFalse();
                });
        verify(productService).createAllToDo(anyList());
    }

    @Test
    void getToDoByIdShouldReturnToDoWhenExists() {
        Product mockProduct = new Product("TO-DO-1", "Test", true);
        when(productService.getToDoById(1L)).thenReturn(mockProduct);

        Product result = productController.getToDoById(1L);

        assertThat(result)
                .isNotNull()
                .extracting(Product::getLabel, Product::isCompleted)
                .containsExactly("TO-DO-1", true);
    }

    @Test
    void getCompletedToDosShouldReturnOnlyCompleted() {
        Product completedProduct = new Product("Done-1", "Completed", true);
        when(productService.getTasksByStatus(true)).thenReturn(List.of(completedProduct));

        List<Product> result = productController.getCompletedToDos();

        assertThat(result)
                .hasSize(1)
                .allSatisfy(todo -> assertThat(todo.isCompleted()).isTrue());
    }

    @Test
    void updateToDoStatusShouldUpdateAndReturnToDo() {
        Product updatedProduct = new Product("Updated", "Desc", true);
        when(productService.updateTaskStatus(1L, true)).thenReturn(updatedProduct);

        Product result = productController.updateToDoStatus(1L, true);

        assertThat(result)
                .extracting(Product::isCompleted)
                .isEqualTo(true);
    }*/
}
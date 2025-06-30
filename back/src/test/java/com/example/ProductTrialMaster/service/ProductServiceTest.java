package com.example.ProductTrialMaster.service;

import com.example.ProductTrialMaster.entity.Product;
import com.example.ProductTrialMaster.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product todo1;
    private Product todo2;
/*
    @BeforeEach
    void setUp() {
        todo1 = new Product();
        todo1.setId(1L);
        todo1.setCompleted(false);

        todo2 = new Product();
        todo2.setId(2L);
        todo2.setCompleted(true);
    }

    @Test
    void getAllToDoShouldReturnAllTodos() {
        List<Product> expectedTodos = Arrays.asList(todo1, todo2);
        when(productRepository.findAll()).thenReturn(expectedTodos);

        List<Product> actualTodos = productService.getAllToDo();

        assertEquals(2, actualTodos.size());
        assertEquals(expectedTodos, actualTodos);
        verify(productRepository).findAll();
    }

    @Test
    void getToDoByIdWhenTodoExistsShouldReturnTodo() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(todo1));

        Product foundTodo = productService.getToDoById(1L);

        assertNotNull(foundTodo);
        assertEquals(todo1.getId(), foundTodo.getId());
        verify(productRepository).findById(1L);
    }

    @Test
    void getToDoByIdWhenTodoNotExistsShouldThrowException() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> productService.getToDoById(anyLong()));
        verify(productRepository).findById(anyLong());
    }

    @Test
    void createAllToDoWithValidListShouldSaveAllTodos() {
        List<Product> todosToSave = Arrays.asList(todo1, todo2);
        when(productRepository.saveAll(todosToSave)).thenReturn(todosToSave);

        List<Product> savedTodos = productService.createAllToDo(todosToSave);

        assertEquals(2, savedTodos.size());
        verify(productRepository).saveAll(todosToSave);
    }

    @Test
    void createAllToDoWithNullListShouldThrowException() {
        assertThrows(NullPointerException.class, () -> productService.createAllToDo(null));
        verifyNoInteractions(productRepository);
    }

    @Test
    void createAllToDoWithEmptyListShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> productService.createAllToDo(Collections.emptyList()));
        verifyNoInteractions(productRepository);
    }

    @Test
    void updateTaskStatusWhenTodoExistsShouldUpdateStatus() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(todo1));
        when(productRepository.save(todo1)).thenReturn(todo1);

        Product updatedTodo = productService.updateTaskStatus(1L, true);

        assertTrue(updatedTodo.isCompleted());
        verify(productRepository).findById(1L);
        verify(productRepository).save(todo1);
    }

    @Test
    void updateTaskStatusWhenTodoNotExistsShouldThrowException() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> productService.updateTaskStatus(anyLong(), true));
        verify(productRepository).findById(anyLong());
        verify(productRepository, never()).save(any());
    }

    @Test
    void getTasksByStatusShouldReturnFilteredTodos() {
        List<Product> completedTodos = Collections.singletonList(todo2);
        when(productRepository.findByCompleted(true)).thenReturn(completedTodos);

        List<Product> result = productService.getTasksByStatus(true);

        assertEquals(1, result.size());
        assertTrue(result.get(0).isCompleted());
        verify(productRepository).findByCompleted(true);
    }*/
}
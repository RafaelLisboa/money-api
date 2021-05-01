package br.com.rafael.moneyapi.service;

import br.com.rafael.moneyapi.model.Category;
import br.com.rafael.moneyapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

}

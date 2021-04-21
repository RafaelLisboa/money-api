package br.com.rafael.moneyapi.resource;

import br.com.rafael.moneyapi.event.CreatedResourceEvent;
import br.com.rafael.moneyapi.model.Category;
import br.com.rafael.moneyapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryResource {


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody Category category, HttpServletResponse response) {
        Category categoryPersisted = categoryRepository.save(category);
        eventPublisher.publishEvent(new CreatedResourceEvent(this, response, categoryPersisted.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryPersisted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        return categoryOptional.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(categoryOptional.get());
    }


}

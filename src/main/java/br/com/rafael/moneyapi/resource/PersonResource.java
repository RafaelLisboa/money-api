package br.com.rafael.moneyapi.resource;

import br.com.rafael.moneyapi.event.CreatedResourceEvent;
import br.com.rafael.moneyapi.model.Person;
import br.com.rafael.moneyapi.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @GetMapping
    public List<Person> list() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findByID(@PathVariable Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(personOptional.get());
    }

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response) {
        Person personPersisted = personRepository.save(person);
        eventPublisher.publishEvent(new CreatedResourceEvent(this, response, personPersisted.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(personPersisted);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @Valid @RequestBody Person person) {
        Optional<Person> savedPerson = personRepository.findById(id);
        if (savedPerson.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(person, savedPerson.get(), "id");
        personRepository.save(savedPerson.get());
        return ResponseEntity.ok(savedPerson.get());
    }

}

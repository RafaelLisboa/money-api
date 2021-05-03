package br.com.rafael.moneyapi.resource;

import br.com.rafael.moneyapi.event.CreatedResourceEvent;
import br.com.rafael.moneyapi.exception.MoneyApiExceptionHandler;
import br.com.rafael.moneyapi.model.Launch;
import br.com.rafael.moneyapi.repository.filter.LaunchFilter;
import br.com.rafael.moneyapi.service.LaunchService;
import br.com.rafael.moneyapi.service.exception.PersonNonexistentOrInactiveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/launch")
public class LaunchResource {

    @Autowired
    private LaunchService launchService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public List<Launch> getAll(LaunchFilter launchFilter) {
        return launchService.getAll(launchFilter);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Launch> getById(@PathVariable Long id) {
        Optional<Launch> launch = launchService.getById(id);
        return launch.isEmpty() ?
                ResponseEntity.notFound().build() : ResponseEntity.ok(launch.get());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        launchService.delete(id);
    }


    @PostMapping
    public ResponseEntity<Launch> save(@Valid @RequestBody Launch launch, HttpServletResponse response) {
        Launch launchPersisted = launchService.save(launch);
        eventPublisher.publishEvent(new CreatedResourceEvent(this, response, launchPersisted.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(launchPersisted);
    }

    @ExceptionHandler({PersonNonexistentOrInactiveException.class})
    public ResponseEntity<Object> handlePersonNonexistentOrInactiveException(PersonNonexistentOrInactiveException ex) {
        String messageReturnedForUser = messageSource.getMessage("person.nonexistent-or-inactive", null,
                LocaleContextHolder.getLocale());
        String messageReturnedForDeveloper = ex.toString();

        List<MoneyApiExceptionHandler.Error> errorList = List.of(new MoneyApiExceptionHandler.Error(messageReturnedForUser, messageReturnedForDeveloper));
        return ResponseEntity.badRequest().body(errorList);
    }


}

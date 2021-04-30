package br.com.rafael.moneyapi.resource;

import br.com.rafael.moneyapi.model.Launch;
import br.com.rafael.moneyapi.service.LaunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/launch")
public class LaunchResource {

    @Autowired
    LaunchService launchService;

    @GetMapping
    public List<Launch> getAll() {
        return launchService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Launch> getById(@PathVariable Long id) {
        Optional<Launch> launch = launchService.getById(id);
        return launch.isEmpty() ?
                ResponseEntity.notFound().build() : ResponseEntity.ok(launch.get());

    }
}

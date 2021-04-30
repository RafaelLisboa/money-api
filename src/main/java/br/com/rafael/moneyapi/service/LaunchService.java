package br.com.rafael.moneyapi.service;

import br.com.rafael.moneyapi.model.Launch;
import br.com.rafael.moneyapi.repository.LaunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaunchService {

    @Autowired
    LaunchRepository launchRepository;

    public List<Launch> getAll() {
        return launchRepository.findAll();
    }

    public Optional<Launch> getById(Long id) {
        Optional<Launch> launch = launchRepository.findById(id);
        return launch;
    }

}

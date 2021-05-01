package br.com.rafael.moneyapi.service;

import br.com.rafael.moneyapi.model.Launch;
import br.com.rafael.moneyapi.repository.LaunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void delete(Long id) {
        launchRepository.deleteById(id);
    }

    public Launch save(Launch launch) {
        Launch launchPersisted = launchRepository.save(launch);
        return launchPersisted;
    }

}

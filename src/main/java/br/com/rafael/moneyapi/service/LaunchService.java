package br.com.rafael.moneyapi.service;

import br.com.rafael.moneyapi.model.Launch;
import br.com.rafael.moneyapi.model.Person;
import br.com.rafael.moneyapi.repository.LaunchRepository;
import br.com.rafael.moneyapi.repository.PersonRepository;
import br.com.rafael.moneyapi.repository.filter.LaunchFilter;
import br.com.rafael.moneyapi.service.exception.PersonNonexistentOrInactiveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaunchService {

    @Autowired
    private LaunchRepository launchRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Launch> getAll(LaunchFilter launchFilter) {
        return launchRepository.filter(launchFilter);
    }

    public Optional<Launch> getById(Long id) {
        Optional<Launch> launch = launchRepository.findById(id);
        return launch;
    }

    public void delete(Long id) {
        launchRepository.deleteById(id);
    }

    public Launch save(Launch launch) {
        Optional<Person> person = personRepository.findById(launch.getPerson().getId());
        if (person.isEmpty()) {
            throw new PersonNonexistentOrInactiveException();
        }
        return launchRepository.save(launch);
    }

}

package br.com.rafael.moneyapi.repository.launch;

import br.com.rafael.moneyapi.model.Launch;
import br.com.rafael.moneyapi.repository.filter.LaunchFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LaunchRepositoryQuery {

    Page<Launch> filter(LaunchFilter launchFilter, Pageable pageable);

}

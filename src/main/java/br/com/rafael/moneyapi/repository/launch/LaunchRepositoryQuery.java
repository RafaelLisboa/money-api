package br.com.rafael.moneyapi.repository.launch;

import br.com.rafael.moneyapi.model.Launch;
import br.com.rafael.moneyapi.repository.filter.LaunchFilter;

import java.util.List;

public interface LaunchRepositoryQuery {

    List<Launch> filter(LaunchFilter launchFilter);

}

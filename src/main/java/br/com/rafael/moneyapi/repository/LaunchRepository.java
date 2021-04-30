package br.com.rafael.moneyapi.repository;

import br.com.rafael.moneyapi.model.Launch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaunchRepository extends JpaRepository<Launch, Long> {

}

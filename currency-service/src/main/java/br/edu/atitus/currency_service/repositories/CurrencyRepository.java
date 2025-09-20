package br.edu.atitus.currency_service.repositories;

import br.edu.atitus.currency_service.entities.CurrencyEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository
		extends JpaRepository<CurrencyEntity, Long>{
	
	Optional<CurrencyEntity> findBySourceAndTarget
	            (String source, String target);

}

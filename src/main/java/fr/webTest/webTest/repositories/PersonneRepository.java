package fr.webTest.webTest.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import fr.webTest.webTest.entities.Personne;


@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

	List<Personne> findAllByOrderByNomAsc();

}
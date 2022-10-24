package fr.webTest.webTest.services;

import java.util.List;

import fr.webTest.webTest.dto.PersonneDto;



public interface PersonneService {

	List<PersonneDto> getAll();
	List<PersonneDto> getAllByAlphaOrder();
	PersonneDto getById(long id);
	PersonneDto saveOrUpdate(PersonneDto pDto) throws Exception;
	void delete(long id);


	}
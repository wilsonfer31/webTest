package fr.webTest.webTest;



import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import fr.webTest.webTest.controllers.PersonneController;
import fr.webTest.webTest.dto.PersonneDto;
import fr.webTest.webTest.services.PersonneService;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonneControllerTest {
	
	@Autowired
	private PersonneController personneController;
	
	@Autowired //objet pour lancer des requêtes MVC
	private MockMvc mockMvc;
	
	@MockBean
	private PersonneService personneService;

	
	
	private final List<PersonneDto> personnes = new ArrayList<>();

	@BeforeEach //réaliser un traitement avant chaque test
	public void beforeEach() throws Exception {

	
		personnes.add(new PersonneDto(1L,"user1","prenom1", LocalDate.parse("2000-10-5"),0 ));
		personnes.add(new PersonneDto(2L,"user2","prenom3", LocalDate.parse("2000-08-5"),0 ));
		personnes.add(new PersonneDto(3L,"user3","prenom3", LocalDate.parse("2000-10-5"),0 ));
	}
	
	@Test
	void contextUserLoads() {
		assertThat(personneController).isNotNull();
	}
	
			//tester le findAll GET : /api/Personnes
			@Test
			void testFindAll() throws Exception {
	
			when(personneService.getAll()).thenReturn(personnes);

			mockMvc.perform(get("/api/personnes"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.size()", is(personnes.size())))
					.andExpect(jsonPath("$[0].nom", is(personnes.get(0).getNom())));
		}

}

package questao.schoolsimulator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import questao.schoolsimulator.repository.ProfessorRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/*
* Resposta da 2, 7
* */

@DisplayName("Testa lógica referente a regra de Professor")
@SpringBootTest
public class ProfessorTests {

    private final String PROFESSOR_NAME = "Marco Antonio Araujo";
    private final String PROFESSOR_CPF = "19541439071";

    Professor professor;

    @Mock
    ProfessorRepository professorRepository;

    @BeforeEach
    void beforeAll(){
        this.professor = new Professor();

    }

    @BeforeEach
    void setupMocks() {
        when(professorRepository.save(any(Professor.class))).thenAnswer(i -> {
            Optional<Professor> returnedProfessor = Optional.of((Professor) i.getArguments()[0]);
            if(returnedProfessor.get().getNome() == null || returnedProfessor.get().getCpf() == null)
                throw new DataIntegrityViolationException("Nome e CPF são Obrigatorios");
            return returnedProfessor.get();
        });
    }

    @Test
    @DisplayName("Deve testar a criação de Professor")
    void ShouldBeCreateProfessorOnlyWithName() {
        this.professor.setNome(this.PROFESSOR_NAME);
        this.professor.setCpf(this.PROFESSOR_CPF);
        Professor professorCriado = this.professorRepository.save(this.professor);
        assertEquals(this.PROFESSOR_NAME,professorCriado.getNome());
    }

    @Test
    @DisplayName("Deve testar obrigatoriedade do campo Nome para criação de Professor")
    void ShouldBeNotCreateProfessorWithoutName(){
        assertThrows(DataIntegrityViolationException.class, () -> {
            this.professorRepository.save(this.professor);
        });
    }

}


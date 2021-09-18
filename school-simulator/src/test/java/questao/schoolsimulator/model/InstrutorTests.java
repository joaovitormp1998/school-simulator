package questao.schoolsimulator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import questao.schoolsimulator.repository.InstrutorRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/*
* Resposta da 2, 7
* */

@DisplayName("Testa lógica referente a regra de Instrutor")
@SpringBootTest
public class InstrutorTests {

    private final String INSTRUTOR_NAME = "Marco Antonio Araujo";
    private final String INSTRUTOR_CPF = "19541439071";

    Instrutor instrutor;

    @Mock
    InstrutorRepository instrutorRepository;

    @BeforeEach
    void beforeAll(){
        this.instrutor = new Instrutor();

    }

    @BeforeEach
    void setupMocks() {
        when(instrutorRepository.save(any(Instrutor.class))).thenAnswer(i -> {
            Optional<Instrutor> returnedInstrutor = Optional.of((Instrutor) i.getArguments()[0]);
            if(returnedInstrutor.get().getNome() == null || returnedInstrutor.get().getCpf() == null)
                throw new DataIntegrityViolationException("Nome e CPF são Obrigatorios");
            return returnedInstrutor.get();
        });
    }

    @Test
    @DisplayName("Deve testar a criação de Instrutor")
    void ShouldBeCreateInstrutorOnlyWithName() {
        this.instrutor.setNome(this.INSTRUTOR_NAME);
        this.instrutor.setCpf(this.INSTRUTOR_CPF);
        Instrutor instrutorCriado = this.instrutorRepository.save(this.instrutor);
        assertEquals(this.INSTRUTOR_NAME, instrutorCriado.getNome());
    }

    @Test
    @DisplayName("Deve testar obrigatoriedade do campo Nome para criação de Instrutor")
    void ShouldBeNotCreateInstrutorWithoutName(){
        assertThrows(DataIntegrityViolationException.class, () -> {
            this.instrutorRepository.save(this.instrutor);
        });
    }

}


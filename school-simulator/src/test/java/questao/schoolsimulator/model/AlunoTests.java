package questao.schoolsimulator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import questao.schoolsimulator.repository.AlunoRepository;

@DisplayName("Testa lógica referente a regra de Aluno")
@SpringBootTest
public class AlunoTests {

    private final String ALUNO_NAME = "João Victor";
    private final String ALUNO_CPF = "19541439071";

    Aluno aluno;

    @Autowired
    private AlunoRepository alunoRepository;

    @BeforeEach
    void beforeAll(){
        this.aluno = new Aluno();
    }




}

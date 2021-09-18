package questao.schoolsimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questao.schoolsimulator.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository< Aluno, Long> {
}

package questao.schoolsimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questao.schoolsimulator.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}

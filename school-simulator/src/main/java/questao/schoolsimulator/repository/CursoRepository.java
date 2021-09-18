package questao.schoolsimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questao.schoolsimulator.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}

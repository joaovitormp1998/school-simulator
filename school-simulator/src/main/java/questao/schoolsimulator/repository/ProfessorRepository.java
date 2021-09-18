package questao.schoolsimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questao.schoolsimulator.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}

package questao.schoolsimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questao.schoolsimulator.model.Instrutor;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
}

package questao.schoolsimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questao.schoolsimulator.model.Aulateorica;

@Repository
public interface AulateoricaRepository extends JpaRepository<Aulateorica, Long> {
}

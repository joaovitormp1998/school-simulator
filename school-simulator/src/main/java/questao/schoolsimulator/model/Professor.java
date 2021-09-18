package questao.schoolsimulator.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "professor")
@Data
public class Professor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "professor")
    private Set<Curso> corderna;
    @ManyToMany
    private Set<Turma> turmas;

}

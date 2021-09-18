package questao.schoolsimulator.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "instrutor")
@Data
public class Instrutor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "instrutor")
    private Set<Aulateorica> corderna;
    @ManyToMany
    private Set<Turma> turmas;

}

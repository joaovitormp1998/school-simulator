package questao.schoolsimulator.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "turma")
@Data
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(
            name = "instrutor_turma",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "instrutor_id")
    )
    private Set<Instrutor> instrutores;

    @OneToMany(mappedBy = "turma")
    private Set<Aluno> alunos;

}

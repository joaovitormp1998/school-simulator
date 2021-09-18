package questao.schoolsimulator.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "curso")
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer duracaoEmMeses;

    @ManyToOne
    @JoinColumn(name = "professor_id",nullable = true)
    private Professor professor;



}

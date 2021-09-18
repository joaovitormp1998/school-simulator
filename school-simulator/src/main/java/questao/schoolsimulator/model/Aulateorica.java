package questao.schoolsimulator.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "aulateorica" +
        "")
@Data
public class Aulateorica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer duracaoEmMeses;

    @ManyToOne
    @JoinColumn(name = "instrutor_id", nullable = true)
    private Instrutor instrutor;



}

package com.itayou.card.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idade;
    private String nome;
    private Double salario;

    @OneToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<CartaoSolicitado> cartoesSolicitados;
}

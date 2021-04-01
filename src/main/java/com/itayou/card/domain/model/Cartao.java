package com.itayou.card.domain.model;

import com.itayou.card.domain.enums.Bandeira;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cartao {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long nome;
    private Double limite;
    private Bandeira bandeira;

    @ManyToOne
    private Usuario usuario;
}

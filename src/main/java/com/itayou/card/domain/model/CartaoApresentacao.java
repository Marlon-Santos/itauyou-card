package com.itayou.card.domain.model;

import com.itayou.card.domain.enums.Bandeira;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CartaoApresentacao {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCartao;
    private Bandeira bandeira;
    private Double limite;

    @ManyToOne
    private PerfilCredito perfilCredito;

}

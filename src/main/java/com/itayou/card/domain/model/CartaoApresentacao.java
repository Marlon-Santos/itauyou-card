package com.itayou.card.domain.model;

import com.itayou.card.domain.enums.Bandeira;
import com.itayou.card.domain.enums.NomeCartao;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
public class CartaoApresentacao {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private NomeCartao nomeCartao;
    private Bandeira bandeira;
    private Double limite;

    @ManyToOne
    private PerfilCredito perfilCredito;

}

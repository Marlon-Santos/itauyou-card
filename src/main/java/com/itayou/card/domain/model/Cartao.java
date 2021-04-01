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
public class Cartao {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private NomeCartao nome;
    private Double limite;
    private Bandeira bandeira;

    @ManyToOne
    private Usuario usuario;
}

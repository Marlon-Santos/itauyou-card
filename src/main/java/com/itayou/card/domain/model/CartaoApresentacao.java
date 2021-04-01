package com.itayou.card.domain.model;

import com.itayou.card.domain.enums.Bandeira;
import com.itayou.card.domain.enums.NomeCartao;
import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
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

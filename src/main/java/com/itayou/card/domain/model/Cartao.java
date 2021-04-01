package com.itayou.card.domain.model;

import com.itayou.card.domain.enums.Bandeira;
import com.itayou.card.domain.enums.NomeCartao;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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

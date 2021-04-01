package com.itayou.card.domain.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Endereco {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numero;
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
}

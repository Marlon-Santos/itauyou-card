package com.itayou.card.domain.model;

import com.itayou.card.domain.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CartaoSolicitado {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSolicitacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrega;

    @ManyToOne
    private Usuario usuario;

    @OneToOne
    private Cartao cartao;
}

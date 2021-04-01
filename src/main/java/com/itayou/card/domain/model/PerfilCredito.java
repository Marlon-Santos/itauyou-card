package com.itayou.card.domain.model;

import com.itayou.card.domain.enums.Perfil;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
public class PerfilCredito {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Perfil nomePerfil;

    @OneToMany(mappedBy = "perfilCredito", cascade = CascadeType.ALL)
    private List<CartaoApresentacao> cartoesApresentacao;
}

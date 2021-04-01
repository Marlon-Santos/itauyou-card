package com.itayou.card.domain.model;

import com.itayou.card.domain.enums.Perfil;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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

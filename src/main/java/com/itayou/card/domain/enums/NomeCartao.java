package com.itayou.card.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum NomeCartao {
    ITAU_BLACK("Itau Black"),
    ITAU_PLATINUM("Itau Platinum"),
    ITAU_OURO("Itau Ouro"),
    ITAU_FREE("Itau Free");

    @NonNull
    private final String nomeCartao;
}

package com.itayou.card.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum Perfil {
    PLATINUM("Mastercard"),
    OURO("Visa");

    @NonNull
    private final String perfil;
}

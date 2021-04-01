package com.itayou.card.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum Status {
    ENVIADO("Enviado"),
    EM_FABRICACAO("Em fabricação");

    @NonNull
    private final String status;
}

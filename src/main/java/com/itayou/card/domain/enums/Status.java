package com.itayou.card.domain.enums;

import lombok.Getter;
import lombok.NonNull;

@Getter

public enum Status {
    ENVIADO("Enviado"),
    EM_FABRICACAO("Em fabricação");

    @NonNull
    private final String status;

    Status(@NonNull String status) {
        this.status = status;
    }
}

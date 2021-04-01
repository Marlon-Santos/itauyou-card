package com.itayou.card.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum Bandeira {
    MASTERCARD("Mastercard"),
    VISA("Visa");

    @NonNull
    private final String bandeira;

}

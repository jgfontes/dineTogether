package br.com.fiap.dine_together.dine_together.model;

public enum ERole {
    CONSUMER(1),
    RESTAURANT_OWNER(2);

    final int code;

    ERole(int code) {
        this.code = code;
    }
}

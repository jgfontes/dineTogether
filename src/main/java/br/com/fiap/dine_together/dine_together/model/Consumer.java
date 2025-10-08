package br.com.fiap.dine_together.dine_together.model;

public class Consumer extends UserAbstract {
    @Override
    void setRole(ERole role) {
        role = ERole.CONSUMER;
    }
}

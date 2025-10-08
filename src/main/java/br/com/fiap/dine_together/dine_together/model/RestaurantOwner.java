package br.com.fiap.dine_together.dine_together.model;

public class RestaurantOwner extends UserAbstract {

    @Override
    void setRole(ERole role) {
        role = ERole.RESTAURANT_OWNER;
    }
}

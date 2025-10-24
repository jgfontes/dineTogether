package br.com.fiap.dine_together.dine_together.model;


import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
public class RestaurantOwner extends UserAbstract {

    @Override
    public void setRole(ERole role) {
        this.role = ERole.RESTAURANT_OWNER;
    }
}

package br.com.fiap.dine_together.dine_together.util;

import br.com.fiap.dine_together.dine_together.dto.CreateUserRequest;
import br.com.fiap.dine_together.dine_together.dto.UserDTO;
import br.com.fiap.dine_together.dine_together.model.Consumer;
import br.com.fiap.dine_together.dine_together.model.ERole;
import br.com.fiap.dine_together.dine_together.model.RestaurantOwner;
import br.com.fiap.dine_together.dine_together.model.UserAbstract;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

@NoArgsConstructor
public class EntityDtoMapper {

    private static final Map<ERole, Supplier<? extends UserAbstract.UserAbstractBuilder<?, ?>>> builderMap = new EnumMap<>(ERole.class);

    static {
        builderMap.put(ERole.CONSUMER, Consumer::builder);
        builderMap.put(ERole.RESTAURANT_OWNER, RestaurantOwner::builder);
    }

    public static UserAbstract mapUserFromCreateRequest(CreateUserRequest req) {
        if (req == null || req.getRole() == null) return null;
        var builderSupplier = builderMap.get(req.getRole());
        if (builderSupplier == null) throw new IllegalArgumentException("Unknown role: " + req.getRole());

        UserAbstract.UserAbstractBuilder<?, ?> builder = builderSupplier.get()
                .id(UUID.randomUUID())
                .name(req.getName())
                .email(req.getEmail())
                .username(req.getUsername())
                .password(req.getPassword())
                .address(req.getAddress())
                .role(req.getRole())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now());

        return builder.build();
    }

    public static UserDTO mapDtoToUser(UserAbstract user) {
        if (user == null) return null;
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .address(user.getAddress())
                .role(user.getRole())
                .build();
    }
}

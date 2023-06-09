package dev.esara.medminder.mapper;

import dev.esara.medminder.config.PasswordEncoder;
import dev.esara.medminder.entity.User;
import dev.esara.medminder.model.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthMapper {
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .gender(request.getGender())
                .password(passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()))
                .build();
    }
}

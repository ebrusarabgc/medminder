package dev.esara.medminder.mapper;

import dev.esara.medminder.entity.User;
import dev.esara.medminder.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .gender(user.getGender())
                .age(user.getAge())
                .build();
    }
}

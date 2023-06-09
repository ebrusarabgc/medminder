package dev.esara.medminder.model.dto;

import dev.esara.medminder.model.enums.Gender;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private Gender gender;
    private int age;
}

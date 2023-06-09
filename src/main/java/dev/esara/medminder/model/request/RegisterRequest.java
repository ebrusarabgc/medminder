package dev.esara.medminder.model.request;

import dev.esara.medminder.model.enums.Gender;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Gender gender;
    private int age;
}

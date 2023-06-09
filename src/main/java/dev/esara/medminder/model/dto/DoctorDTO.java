package dev.esara.medminder.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private Long id;
    private String name;
    private String department;
    private String phoneNumber;
    private int userId;
}

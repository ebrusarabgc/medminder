package dev.esara.medminder.model.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequest {
    private String name;
    private String department;
    private String phoneNumber;
}

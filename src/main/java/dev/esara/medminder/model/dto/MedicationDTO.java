package dev.esara.medminder.model.dto;

import dev.esara.medminder.model.enums.Usage;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDTO {
    private Long id;
    private String name;
    private String description;
    private int stock;
    private int dosage;
    private Usage usage;
    private int userId;
}

package dev.esara.medminder.model.request;

import dev.esara.medminder.model.enums.Usage;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicationRequest {
    private String name;
    private String description;
    private int stock;
    private int dosage;
    private Usage usage;
}

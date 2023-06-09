package dev.esara.medminder.mapper;


import dev.esara.medminder.entity.Medication;
import dev.esara.medminder.model.dto.MedicationDTO;
import dev.esara.medminder.model.request.MedicationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MedicationMapper {
    public MedicationDTO toDTO(Medication medication) {
        return MedicationDTO.builder()
                .id(medication.getId())
                .name(medication.getName())
                .description(medication.getDescription())
                .stock(medication.getStock())
                .dosage(medication.getDosage())
                .usage(medication.getUsage())
                .build();
    }

    public Medication addMedication(MedicationRequest medicationRequest, Long userId) {
        return Medication.builder()
                .name(medicationRequest.getName())
                .description(medicationRequest.getDescription())
                .stock(medicationRequest.getStock())
                .dosage(medicationRequest.getDosage())
                .usage(medicationRequest.getUsage())
                .userId(userId)
                .build();
    }

    public List<MedicationDTO> listToDTO(List<Medication> medications) {
        return medications.stream().map(this::toDTO).collect(Collectors.toList());
    }
}

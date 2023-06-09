package dev.esara.medminder.service;

import dev.esara.medminder.entity.Medication;
import dev.esara.medminder.mapper.MedicationMapper;
import dev.esara.medminder.model.dto.MedicationDTO;
import dev.esara.medminder.model.request.MedicationRequest;
import dev.esara.medminder.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationService {
    private final MedicationRepository medicationRepository;
    private final MedicationMapper medicationMapper;

    public MedicationDTO getById(Long id) {
        Medication medication = medicationRepository.findById(id).orElseThrow();
        return medicationMapper.toDTO(medication);
    }

    public List<MedicationDTO> findByUserId(Long userId) {
        List<Medication> medications = medicationRepository.findByUserId(userId);
        return medicationMapper.listToDTO(medications);
    }

    public void addMedication(MedicationRequest request, Long userId) {
        final Medication medication = medicationMapper.addMedication(request, userId);
        medicationRepository.save(medication);
    }

    public void deleteById(Long id) {
        medicationRepository.deleteById(id);
    }
}

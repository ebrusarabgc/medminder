package dev.esara.medminder.controller;

import dev.esara.medminder.model.dto.MedicationDTO;
import dev.esara.medminder.model.request.MedicationRequest;
import dev.esara.medminder.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dev.esara.medminder.utils.MdcConstant.X_USER_ID;

@RestController
@RequestMapping("/api/medication")
@RequiredArgsConstructor
public class MedicationController {
    private final MedicationService medicationService;

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(medicationService.getById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MedicationDTO>> findByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(medicationService.findByUserId(userId));
    }

    @PostMapping
    public void addMedication(@RequestBody MedicationRequest request) {
        medicationService.addMedication(request, Long.valueOf(MDC.get(X_USER_ID)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        medicationService.deleteById(id);
    }
}

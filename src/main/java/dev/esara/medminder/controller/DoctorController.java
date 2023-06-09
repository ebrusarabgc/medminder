package dev.esara.medminder.controller;

import dev.esara.medminder.model.dto.DoctorDTO;
import dev.esara.medminder.model.request.DoctorRequest;
import dev.esara.medminder.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dev.esara.medminder.utils.MdcConstant.X_USER_ID;

@RestController
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DoctorDTO>> findByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(doctorService.findByUserId(userId));
    }

    @PostMapping
    public void addDoctor(@RequestBody DoctorRequest request) {
        doctorService.addDoctor(request, Long.valueOf(MDC.get(X_USER_ID)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        doctorService.deleteById(id);
    }
}

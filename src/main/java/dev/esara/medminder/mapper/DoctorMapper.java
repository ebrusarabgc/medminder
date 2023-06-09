package dev.esara.medminder.mapper;

import dev.esara.medminder.entity.Doctor;
import dev.esara.medminder.model.dto.DoctorDTO;
import dev.esara.medminder.model.request.DoctorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DoctorMapper {
    public DoctorDTO toDTO(Doctor doctor) {
        return DoctorDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .department(doctor.getDepartment())
                .phoneNumber(doctor.getPhoneNumber())
                .build();
    }

    public Doctor addDoctor(DoctorRequest doctorRequest, Long userId) {
        return Doctor.builder()
                .name(doctorRequest.getName())
                .department(doctorRequest.getDepartment())
                .phoneNumber(doctorRequest.getPhoneNumber())
                .userId(userId)
                .build();
    }

    public List<DoctorDTO> listToDTO(List<Doctor> doctors) {
        return doctors.stream().map(this::toDTO).collect(Collectors.toList());
    }
}

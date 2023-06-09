package dev.esara.medminder.service;

import dev.esara.medminder.entity.Doctor;
import dev.esara.medminder.mapper.DoctorMapper;
import dev.esara.medminder.model.dto.DoctorDTO;
import dev.esara.medminder.model.request.DoctorRequest;
import dev.esara.medminder.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorDTO getById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        return doctorMapper.toDTO(doctor);
    }

    public List<DoctorDTO> findByUserId(Long userId) {
        List<Doctor> doctors = doctorRepository.findByUserId(userId);
        return doctorMapper.listToDTO(doctors);
    }

    public void addDoctor(DoctorRequest request, Long userId) {
        final Doctor doctor = doctorMapper.addDoctor(request, userId);
        doctorRepository.save(doctor);
    }

    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }
}

package dev.esara.medminder.repository;

import dev.esara.medminder.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByUserId(Long userId);
}

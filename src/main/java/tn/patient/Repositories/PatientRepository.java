package tn.patient.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.patient.Entities.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByMaladie(String maladie);
}

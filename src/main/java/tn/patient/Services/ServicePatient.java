package tn.patient.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.patient.Entities.Patient;
import tn.patient.Repositories.PatientRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ServicePatient implements IServicePatient{
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
    @Override
    public Patient saveOrUpdatePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    @Override
    public List<Patient> getPatientsByMaladie(String maladie) {
        return patientRepository.findByMaladie(maladie);
    }
}

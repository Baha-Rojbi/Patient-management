package tn.patient.Services;

import tn.patient.Entities.Patient;

import java.util.List;
import java.util.Optional;

public interface IServicePatient {
    public List<Patient> getAllPatients() ;

    public Optional<Patient> getPatientById(Long id) ;

    public Patient saveOrUpdatePatient(Patient patient) ;
    public void deletePatient(Long id) ;
    public List<Patient> getPatientsByMaladie(String maladie);
}

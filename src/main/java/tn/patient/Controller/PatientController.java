package tn.patient.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.patient.Entities.Patient;
import tn.patient.Services.IServicePatient;
import tn.patient.Services.ServicePatient;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private IServicePatient patientService;

    @GetMapping
    public String getAllPatients(org.springframework.ui.Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @GetMapping("/add")
    public String showPatientForm(org.springframework.ui.Model model) {
        model.addAttribute("patient", new Patient());
        return "patient/add";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientService.saveOrUpdatePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Patient patient = patientService.getPatientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient id: " + id));
        model.addAttribute("patient", patient);
        return "patient/edit";
    }

    @PostMapping("/edit/{id}")
    public String updatePatient(@PathVariable("id") Long id, @ModelAttribute("patient") Patient patient) {
        patient.setIdPatient(id);
        patientService.saveOrUpdatePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
    @GetMapping("/search")
    public String searchPatients(@RequestParam(name = "maladie") String maladie, Model model) {
        List<Patient> patients = patientService.getPatientsByMaladie(maladie);
        model.addAttribute("patients", patients);
        return "patient/list";
    }
}

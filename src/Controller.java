import Modelle.Medikamente;
import Modelle.Patienten;
import Repos.MedikamenteRepo;
import Repos.PatientenRepo;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private PatientenRepo patientenRepo;
    private MedikamenteRepo medikamenteRepo;

    public Controller() {
        patientenRepo = new PatientenRepo();
        medikamenteRepo = new MedikamenteRepo();
    }

    public void addPatient(Patienten patient) {
        patientenRepo.add(patient);
    }
    public void addMedikamente(Medikamente medikamente) {
        medikamenteRepo.add(medikamente);
    }

    public void deletePatient(Integer id) {
        patientenRepo.remove(id);
    }

    public void deleteMedikamente(String name) {
        medikamenteRepo.remove(name);
    }

    public Patienten findPatient(Integer id) {
        return patientenRepo.get(id);
    }

    public Medikamente findMedikamente(String name) {
        return medikamenteRepo.get(name);
    }

    public List<Patienten> findAllPatienten() {
        return patientenRepo.getAll();
    }
    public List<Medikamente> findAllMedikamente() {
        return medikamenteRepo.getAll();
    }

    public void updateMedikament(Integer id,Medikamente medikamente) {
        for(Medikamente m : medikamenteRepo.getAll()) {
            if(m.getName().equals(medikamente.getName())) {
                medikamenteRepo.update(m);
            }
        }
    }
    public void updatePatienten(Integer id,Patienten patienten) {
        for(Patienten p : patientenRepo.getAll()) {
            if(p.getId()==patienten.getId()) {
                patientenRepo.update(p);
            }
        }
    }

    public List<Patienten> filterPatientsbyDiagnosis(String Diagnosis) {
        return patientenRepo.getAll().stream().filter(patient -> patient.getDiagnose().equalsIgnoreCase(Diagnosis)).collect(Collectors.toList());

    }


}

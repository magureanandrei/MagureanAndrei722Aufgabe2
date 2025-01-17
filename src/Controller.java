import Modelle.Medikamente;
import Modelle.Patienten;
import Repos.MedikamenteRepo;
import Repos.PatientenRepo;

import java.util.ArrayList;
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

    public void updateMedikament(String id,Medikamente medikamente) {
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

    public List<Patienten> showPatientsbyKrankheit(String Krankheit) {

        List<Patienten> patienten = new ArrayList<>();
        for(Patienten p : patientenRepo.getAll()) {
            for(Medikamente m : p.getListofMedikamente()) {
                if(m.getKrankheit().equalsIgnoreCase(Krankheit)) {
                    patienten.add(p);
                    break;
                }
            }
        }
        return patienten;
    }

    public List<Medikamente> sortMedikaments2ways(Integer patientID, String wayofsort) {
        List<Medikamente> medikamente = new ArrayList<>();

        for(Patienten p : patientenRepo.getAll()) {
            if(p.getId()==patientID) {
                medikamente.addAll(p.getListofMedikamente());
                if(wayofsort.equalsIgnoreCase("aufsteigend")) {
                    medikamente.sort((p1,p2)->p1.getPreis().compareTo(p2.getPreis()));
                }
                else {
                    medikamente.sort((p1,p2)->p2.getPreis().compareTo(p1.getPreis()));
                }
            }
        }
        return medikamente;
    }

}

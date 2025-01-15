package Repos;

import Modelle.Medikamente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedikamenteRepo {
    Map<String, Medikamente> medikamente= new HashMap<>();

    public void add(Medikamente obj) {
        medikamente.put(obj.getName(), obj);
    }

    public void remove(Integer id) {
        medikamente.remove(id);
    }

    public void update(Medikamente obj) {
        medikamente.replace(obj.getName(), obj);
    }

    public Medikamente get(Integer getId) {
        return medikamente.get(getId);
    }

    public List<Medikamente> getAll(){
        return medikamente.values().stream().toList();
    }
}

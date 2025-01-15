package Repos;

import Modelle.Patienten;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientenRepo {
    Map<Integer, Patienten> patienten=new HashMap<>();

    public void add(Patienten obj) {
        patienten.put(obj.getId(), obj);
    }

    public void remove(Integer id) {
        patienten.remove(id);
    }

    public void update(Patienten obj) {
        patienten.replace(obj.getId(), obj);
    }

    public Patienten get(Integer getId) {
        return patienten.get(getId);
    }

    public List<Patienten> getAll(){
        return patienten.values().stream().toList();
    }

}

import Modelle.Medikamente;
import Modelle.Patienten;
import Repos.MedikamenteRepo;
import Repos.PatientenRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PatientenRepo patientenRepo = new PatientenRepo();
        MedikamenteRepo medikamenteRepo = new MedikamenteRepo();
        Medikamente medikamente= new Medikamente("a",10,"x");
        Medikamente medikamente2= new Medikamente("b",10,"y");
        medikamenteRepo.add(medikamente);
        medikamenteRepo.add(medikamente2);
        patientenRepo.add(new Patienten(1,"a",1,"x",new ArrayList<>(Arrays.asList(medikamente,medikamente2))));
        patientenRepo.add(new Patienten(2,"b",2,"y", List.of(medikamente)));
        Controller controller = new Controller();
        UI ui=new UI(controller);
        ui.run();
    }
}
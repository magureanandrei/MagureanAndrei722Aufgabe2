import Modelle.Medikamente;
import Modelle.Patienten;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private Controller controller;
    public UI(Controller controller) {
        this.controller = controller;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.print("""
                    Select an option:

                    1. Add Patient
                    2. Remove Patient
                    3. Get Patient by Id
                    4. Update Patient
                    5. Get all Patients
                    6. Add Medikament
                    7. Remove Medikament
                    8. Get Medikament by Name
                    9. Update Medikament
                    10. Get all Medikaments
                    11. Filter Patients nach Diagnosis
                    12. Show Patient with specific Krankheit
                    13. Sort Medikament of Patient with specific Krankheit

                    0. Exit
                    """);

            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    continueLoop = false;
                    break;
                case "1":

                    System.out.print("Enter Patient ID: ");
                    String input = scanner.nextLine();
                    Integer kundeid = Integer.parseInt(input);
                    System.out.print("Enter Patient Name: ");
                    String input1 = scanner.nextLine().trim();
                    System.out.println("Enter Patient Age: ");
                    String input2 = scanner.nextLine().trim();
                    Integer age = Integer.parseInt(input2);
                    System.out.println("Enter Patient diagnosis: ");
                    String input3 = scanner.nextLine().trim();
                    Patienten kunde = new Patienten(kundeid, input1, age, input3,new ArrayList<>());
                    controller.addPatient(kunde);
                    break;
                case "2":
                    System.out.print("Enter Patient ID: ");
                    String input4 = scanner.nextLine();
                    Integer kundeid1 = Integer.parseInt(input4);
                    controller.deletePatient(kundeid1);
                    break;
                case "3":
                    System.out.print("Enter Kunde ID: ");
                    String input5 = scanner.nextLine();
                    Integer kundeid2 = Integer.parseInt(input5);
                    controller.findPatient(kundeid2);
                    break;
                case "4":
                    System.out.print("Enter ID for kunde you want to update: ");
                    String input6 = scanner.nextLine();
                    Integer kundeid3 = Integer.parseInt(input6);
                    System.out.print("Enter new Patient Name: ");
                    String input7 = scanner.nextLine().trim();
                    System.out.println("Enter new Patient Age: ");
                    String input8 = scanner.nextLine().trim();
                    Integer kundeid4 = Integer.parseInt(input8);
                    System.out.println("Enter new Patient Diagnosis: ");
                    String input90 = scanner.nextLine().trim();
                    Patienten kunde2= new Patienten(kundeid3, input7, kundeid4,input90, new ArrayList<>());
                    controller.updatePatienten(kundeid3,kunde2);
                    break;
                case "5":
                    controller.findAllPatienten();
                    break;
                case "6":
                    System.out.print("Enter Medikament Name: ");
                    String input9 = scanner.nextLine();
                    System.out.print("Enter Medikament preis: ");
                    String input10 = scanner.nextLine().trim();
                    Integer produktid = Integer.parseInt(input10);
                    System.out.println("Enter Medikament Krankheit: ");
                    String input11 = scanner.nextLine();
                    Medikamente produkt = new Medikamente(input9, produktid, input11);
                    controller.addMedikamente(produkt);
                    break;
                case "7":
                    System.out.print("Enter Medikament Name: ");
                    String input12 = scanner.nextLine();
                    controller.deleteMedikamente(input12);
                    break;
                case "8":
                    System.out.print("Enter Medikament Name: ");
                    String input13 = scanner.nextLine();
                    controller.findMedikamente(input13);
                    break;
                case "9":
                    System.out.print("Enter the name of the Medikament you want to update: ");
                    String input14 = scanner.nextLine();
                    System.out.print("Enter Medikament preis: ");
                    String input15 = scanner.nextLine().trim();
                    Integer produktid1 = Integer.parseInt(input15);
                    System.out.println("Enter Medikament Krankheit: ");
                    String input16 = scanner.nextLine();
                    Medikamente produkt1 = new Medikamente(input14, produktid1, input16);
                    controller.updateMedikament(input14,produkt1);
                    break;
                case "10":
                    controller.findAllMedikamente();
                    break;
                case "11":
                    System.out.print("Enter Diagnosis you want to filter by: ");
                    String input17 = scanner.nextLine();
                    controller.filterPatientsbyDiagnosis(input17);
                    break;
                case "12":
                    System.out.print("Enter Krankheit you want to filter by: ");
                    String input18 = scanner.nextLine();
                    controller.showPatientsbyKrankheit(input18);
                    break;
                case "13":
                    System.out.print("Enter Patient ID: ");
                    String input19 = scanner.nextLine();
                    Integer kundeid5 = Integer.parseInt(input19);
                    System.out.print("Enter Sorter (aufsteigend/absteigend): ");
                    String input20 = scanner.nextLine();
                    controller.sortMedikaments2ways(kundeid5,input20);
                    break;
                default:
            }
        }
    }
}


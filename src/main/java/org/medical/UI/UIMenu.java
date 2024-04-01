package org.medical.UI;

import org.medical.model.Doctor;
import org.medical.model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {
    public static final String[] MONTHS = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO",
                                     "AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    //showPatientMenu();
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }
    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i +". "+MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }
    private static void authUser(int userType){
        //userype = 1 Doctor
        //userype = 2 Patient
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Jaime Moreira","jaime@gmail.com"));
        doctors.add(new Doctor("Mariana Vera","mariana@gmail.com"));
        doctors.add(new Doctor("Pedro Castillo","pedro@gmail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Cristiano Ronaldo","cristiano@gmail.com"));
        patients.add(new Patient("Rodrigo Goes","rodrigo@gmail.com"));
        patients.add(new Patient("Vinicius Jr","vinijr@gmail.com"));

        boolean emailCorrect = false;
        do{
            System.out.println("Inserte your email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if(userType ==1){
                for (Doctor d: doctors ) {
                    if(d.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener el usuario logueado
                        doctorLogged=d;
                        //showDoctorMenu
                        UIDoctorMenu.showDoctorMenu();

                    }
                }
            }
            if(userType ==2){
                for (Patient p: patients ) {
                    if(p.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener el usuario logueado
                        patientLogged=p;
                        //showDoctorMenu
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
        }while (!emailCorrect);
    }
}

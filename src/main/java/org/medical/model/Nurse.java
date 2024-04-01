package org.medical.model;

public class Nurse extends User{
    private String speciality;

    public Nurse(String name, String email, String speciality) {
        super(name, email);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Verde");
        System.out.println("Departamentos: Nutriologia, Pediatria");
    }
}

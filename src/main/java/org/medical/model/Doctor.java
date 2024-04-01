package org.medical.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Doctor extends User {
    //atributos
    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public Doctor(String name, String email) {
        super(name, email);
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: "+speciality+"\nAvaliable "+availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerologia");
    }

    //metodos de las clases anidadas
    // creo arraylist de la clase citaDisponible

    public void addAvailableAppointment(String  date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    //clases anidadas clase citaDisponible
    public static class AvailableAppointment{
        private int id_av;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String  date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }
        public int getId_av() {
            return id_av;
        }
        public void setId_av(int id_av) {
            this.id_av = id_av;
        }
        public Date getDate(String DATE) {
            return date;
        }
        public String getDate() {
            return format.format(date);
        }
        public void setDate(Date date) {
            this.date = date;
        }
        public String getTime() {
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
        return "Available Appointments \nDate: " + date + "\nTime: " + time;
        }

    }

}

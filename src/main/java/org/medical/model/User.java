package org.medical.model;

public abstract class User {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User: "+name+", Email: "+email+"\nAddress: "+address+". Phone: "+phoneNumber;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() > 10){
            System.out.println(" El numero de telefono debe ser 10 digitos");
        } else if (phoneNumber.length()==10) {
            this.phoneNumber = phoneNumber;
        }
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public abstract void showDataUser();
}

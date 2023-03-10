package Entities;

import java.io.Serializable;

public class Teacher implements Serializable {
    private int id_teacher;
    private String firstname;
    private String lastname;
    private String email;
    private int code_department;

    public Teacher(int id_teacher, String firstname, String lastname, String email, int code_department) {
        this.id_teacher = id_teacher;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.code_department = code_department;
    }
    public Teacher() {
    }
    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getCode_department() {
        return code_department;
    }

    public void setCode_department(int code_department) {
        this.code_department = code_department;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id_teacher=" + id_teacher +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", code_department=" + code_department +
                '}';
    }
}
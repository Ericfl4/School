package Entities;

import java.io.Serializable;

public class Department implements Serializable {
    private int code_department;
    private String name;
    private String phone;

    public Department(int code_department, String name, String phone) {
        this.code_department = code_department;
        this.name = name;
        this.phone = phone;
    }

    public Department() {
    }
    public int getCode_department() {
        return code_department;
    }

    public void setCode_department(int code_department) {
        this.code_department = code_department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Department{" +
                "code_department=" + code_department +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
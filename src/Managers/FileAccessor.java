package Managers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.StringTokenizer;
import Entities.*;
public class FileAccessor {
    public FileAccessor() {
    }

    ArrayList<Department> llistaDepartment = new ArrayList();
    ArrayList<Groups> llistaGroup = new ArrayList();
    ArrayList<Session> llistaSession = new ArrayList();
    ArrayList<Subject> llistaSubject = new ArrayList();
    ArrayList<Teacher> llistaTeacher = new ArrayList();

    public void readDepartmentFile(String filename) throws IOException {
        int code_department;
        String name, phone;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            code_department = Integer.parseInt(str.nextToken());
            name = str.nextToken();
            phone = str.nextToken();
            llistaDepartment.add(new Department(code_department, name, phone));
        }
        br.close();
    }
    public void printDepartment() {
        System.out.println("Departamentos leidos del fichero:");
        for (int i = 0; i < llistaDepartment.size(); i++) {
            System.out.println(llistaDepartment.get(i).toString());
        }
        System.out.println();
    }
    public void readGroupFile(String filename) throws IOException {
        String code_group, curriculum, course;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            code_group = str.nextToken();
            curriculum = str.nextToken();
            course = str.nextToken();
            llistaGroup.add(new Groups(code_group, curriculum, course));

        }
        br.close();

    }
    public void printGroup() {
        System.out.println("Grupos leidos del fichero:");
        for (int i = 0; i < llistaGroup.size(); i++) {
            System.out.println(llistaGroup.get(i).toString());
        }
        System.out.println();
    }
    public void readTeacherFile(String filename) throws IOException {
        int id_teacher, department;
        String firstname, lastname, email;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            id_teacher = Integer.parseInt(str.nextToken());
            firstname = str.nextToken();
            lastname = str.nextToken();
            email = str.nextToken();
            department = Integer.parseInt(str.nextToken());
            for (Department department1 : llistaDepartment) {
                if (department1.getCode_department()==department){
                    llistaTeacher.add(new Teacher(id_teacher, firstname, lastname, email, department1.getCode_department()));
                }
            }

        }
        br.close();

    }
    public void printTeacher() {
        System.out.println("Profesores leidos del fichero:");
        for (int i = 0; i < llistaTeacher.size(); i++) {
            System.out.println(llistaTeacher.get(i).toString());
        }
        System.out.println();
    }
    public void readSubjectFile(String filename) throws IOException {
        String code_subject, description;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            code_subject = str.nextToken();
            description = str.nextToken();
            llistaSubject.add(new Subject(code_subject, description));

        }
        br.close();


    }
    public void printSubject() {
        System.out.println("Asignaturas leidas del fichero:");
        for (int i = 0; i < llistaSubject.size(); i++) {
            System.out.println(llistaSubject.get(i).toString());
        }
        System.out.println();
    }
    public void readSessionFile(String filename) throws IOException {
        int teacher;
        String subject, groups, week_day;
        Time starts, finishes;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            teacher = Integer.parseInt(str.nextToken());
            subject = str.nextToken();
            groups = str.nextToken();
            week_day = str.nextToken();
            starts = Time.valueOf(str.nextToken());
            finishes = Time.valueOf(str.nextToken());
            llistaSession.add(new Session(teacher, subject, groups, week_day, starts, finishes));
        }
        br.close();
    }
    public void printSession() {
        System.out.println("Sesiones leidas del fichero:");
        for (int i = 0; i < llistaSession.size(); i++) {
            System.out.println(llistaSession.get(i).toString());
        }
        System.out.println();
    }
}
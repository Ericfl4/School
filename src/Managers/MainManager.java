package Managers;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Entities.*;
public class MainManager {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws IOException {
        try {
            emf = Persistence.createEntityManagerFactory("MagazineJPA");
        } catch (Throwable ex) {
            System.err.println("Failed to create EntityManagerFactory object."
                    + ex);
            throw new ExceptionInInitializerError(ex);
        }
        MainManager mainManager = new MainManager();
        FileAccessor fa;
        fa = new FileAccessor();
        fa.readDepartmentFile("txts/department.txt");
        fa.printDepartment();
        fa.readTeacherFile("txts/teacher.txt");
        fa.printTeacher();
        fa.readGroupFile("txts/groups.txt");
        fa.printGroup();
        fa.readSubjectFile("txts/subject.txt");
        fa.printSubject();
        fa.readSessionFile("txts/session.txt");
        fa.printSession();



        for (Session session: fa.llistaSession) {
            mainManager.deleteSession(new SessionPK(session.getId_teacher(), session.getCode_subject(), session.getCode_group(), session.getWeek_day()));
        }
        for (Subject subject: fa.llistaSubject) {
            mainManager.deleteSubject(subject.getCode_subject());
        }
        for (Groups groups: fa.llistaGroup) {
            mainManager.deleteGroups(groups.getCode_group());
        }
        for (Teacher teacher: fa.llistaTeacher) {
            mainManager.deleteTeacher(teacher.getId_teacher());
        }
        for (Department department: fa.llistaDepartment) {
            mainManager.deleteDepartment(department.getCode_department());
        }


        for (Department department: fa.llistaDepartment) {
            mainManager.addDepartment(department);
        }
        for (Teacher teacher: fa.llistaTeacher) {
            mainManager.addTeacher(teacher);
        }
        for (Groups groups: fa.llistaGroup) {
            mainManager.addGroups(groups);
        }
        for (Subject subject: fa.llistaSubject) {
            mainManager.addSubject(subject);
        }
        for (Session session: fa.llistaSession) {
            mainManager.addSession(session);
        }

        mainManager.listDepartment();
        mainManager.listTeacher();
        mainManager.listSession();
        mainManager.listSubject();
        mainManager.listGroups();

    }
    public void addDepartment(Department department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        em.close();
    }
    public void addTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }
    public void addGroups(Groups groups) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(groups);
        em.getTransaction().commit();
        em.close();
    }
    public void addSubject(Subject subject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(subject);
        em.getTransaction().commit();
        em.close();
    }
    public void addSession(Session session) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(session);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteSession(SessionPK code_subject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Session session = (Session) em.find(Session.class, code_subject);
        em.remove(session);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteSubject(String code_subject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Subject subject = (Subject) em.find(Subject.class, code_subject);
        em.remove(subject);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteGroups(String code_group) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Groups groups = (Groups) em.find(Groups.class, code_group);
        em.remove(groups);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteTeacher(int id_teacher) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = (Teacher) em.find(Teacher.class, id_teacher);
        em.remove(teacher);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteDepartment(int code_department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Department department = (Department) em.find(Department.class, code_department);
        em.remove(department);
        em.getTransaction().commit();
        em.close();
    }

    public void listDepartment() {
        System.out.println("Departamentos de la base de datos:");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Department> result = em.createQuery("from Department", Department.class)
                .getResultList();
        for (Department department : result) {
            System.out.println(department.toString());
        }
        em.getTransaction().commit();
        em.close();
        System.out.println();
    }
    public void listTeacher() {
        System.out.println("Profesores de la base de datos:");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Teacher> result = em.createQuery("from Teacher", Teacher.class)
                .getResultList();
        for (Teacher teacher : result) {
            System.out.println(teacher.toString());
        }
        em.getTransaction().commit();
        em.close();
        System.out.println();
    }
    public void listSession() {
        System.out.println("Sessiones de la base de datos:");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Session> result = em.createQuery("from Session", Session.class)
                .getResultList();
        for (Session session : result) {
            System.out.println(session.toString());
        }
        em.getTransaction().commit();
        em.close();
        System.out.println();
    }
    public void listSubject() {
        System.out.println("Asignaturas de la base de datos:");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Subject> result = em.createQuery("from Subject", Subject.class)
                .getResultList();
        for (Subject subject : result) {
            System.out.println(subject.toString());
        }
        em.getTransaction().commit();
        em.close();
        System.out.println();
    }
    public void listGroups() {
        System.out.println("Grupos de la base de datos:");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Groups> result = em.createQuery("from Groups", Groups.class)
                .getResultList();
        for (Groups groups : result) {
            System.out.println(groups.toString());
        }
        em.getTransaction().commit();
        em.close();
        System.out.println();
    }

}
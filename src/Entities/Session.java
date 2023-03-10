package Entities;

import java.sql.Time;

public class Session {
    private int id_teacher;
    private String code_subject;
    private String code_group;
    private String week_day;
    private Time starts;
    private Time finishes;


    public Session(int id_teacher, String code_subject, String code_group, String week_day, Time starts, Time finishes) {
        this.id_teacher = id_teacher;
        this.code_subject = code_subject;
        this.code_group = code_group;
        this.week_day = week_day;
        this.starts = starts;
        this.finishes = finishes;
    }

    public Session() {
    }

    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public String getCode_subject() {
        return code_subject;
    }

    public void setCode_subject(String code_subject) {
        this.code_subject = code_subject;
    }

    public String getCode_group() {
        return code_group;
    }

    public void setCode_group(String code_group) {
        this.code_group = code_group;
    }

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public Time getStarts() {
        return starts;
    }

    public void setStarts(Time starts) {
        this.starts = starts;
    }

    public Time getFinishes() {
        return finishes;
    }

    public void setFinishes(Time finishes) {
        this.finishes = finishes;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id_teacher=" + id_teacher +
                ", code_subject='" + code_subject + '\'' +
                ", code_group='" + code_group + '\'' +
                ", week_day='" + week_day + '\'' +
                ", starts=" + starts +
                ", finishes=" + finishes +
                '}';
    }
}


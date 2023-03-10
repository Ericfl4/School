package Entities;

import java.io.Serializable;
import java.util.Date;

public class Groups implements Serializable {
    private String code_group;
    private String curriculum;
    private String course;

    public Groups(String code_group, String curriculum, String course) {
        this.code_group = code_group;
        this.curriculum = curriculum;
        this.course = course;
    }
    public Groups() {
    }

    public String getCode_group() {
        return code_group;
    }

    public void setCode_group(String code_group) {
        this.code_group = code_group;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "code_group='" + code_group + '\'' +
                ", curriculum='" + curriculum + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
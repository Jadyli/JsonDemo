package com.jady.jsondemo.thirdparty;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lipingfa on 2017/6/8.
 */
public class ClassInfo {

    @SerializedName("class")
    private String classX;
    @SerializedName("students")
    private List<Student> students;

    public String getClassX() {
        return classX;
    }

    public void setClassX(String classX) {
        this.classX = classX;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classX='" + classX + '\'' +
                ", students=" + students.toString() +
                '}';
    }
}

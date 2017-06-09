package com.jady.jsondemo.thirdparty;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lipingfa on 2017/6/8.
 */
public class StudentInfo {

    @SerializedName("students")
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "students=" + students.toString() +
                '}';
    }
}

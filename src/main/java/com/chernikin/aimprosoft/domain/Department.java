package com.chernikin.aimprosoft.domain;

public class Department {

    private long id;
    private String departmentName;
    private String comments;

    public Department() {
    }

    public Department(String departmentName, String comments) {
        this.departmentName = departmentName;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}

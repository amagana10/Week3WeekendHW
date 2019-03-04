package com.example.navtest;

class Employee {
    private int id;
    private String name;
    private String birthday;
    private String wage;
    private String hiredate;
    private String image;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, String wage, String hiredate, String image) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.wage = wage;
        this.hiredate = hiredate;
        this.image = image;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", wage='" + wage + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

package com.example.lab03;

public class Customer {
    private String ID;
    private String name;
    private boolean sex;
    private int age;

    public Customer(){
        this("", "", "female", 0);
    }

    public Customer(String ID, String n, String s, int a){
        setID(ID);
        setName(n);
        setSex(s);
        setAge(a);
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex.equals("Male") || sex.equals("male") ? true : false;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}

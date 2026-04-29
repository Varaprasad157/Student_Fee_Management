package model;

public class Student {
    private String id;
    private String name;
    private String course;
    private double totalFee;
    private double paidFee;

    public Student(String id, String name, String course, double totalFee, double paidFee) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.totalFee = totalFee;
        this.paidFee = paidFee;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public double getTotalFee() { return totalFee; }
    public double getPaidFee() { return paidFee; }
}
package model;

public class Receipt {
    private int id;
    private String studentId;
    private double amount;
    private String date;

    public Receipt(int id, String studentId, double amount, String date) {
        this.id = id;
        this.studentId = studentId;
        this.amount = amount;
        this.date = date;
    }

    public String getStudentId() { return studentId; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
}
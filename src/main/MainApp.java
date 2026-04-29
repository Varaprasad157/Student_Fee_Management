package main;

import java.util.*;

import dao.ReceiptDAO;
import dao.StudentDAO;
import model.Receipt;
import model.Student;

public class MainApp {
    static Scanner sc = new Scanner(System.in);
    static StudentDAO studentDAO = new StudentDAO();
    static ReceiptDAO receiptDAO = new ReceiptDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add 2.View 3.Pay 4.Receipts 5.Delete 6.List 7.Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    System.out.print("Fee: ");
                    double fee = sc.nextDouble();
                    sc.nextLine();

                    studentDAO.addStudent(new Student(id, name, course, fee, 0));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    String vid = sc.nextLine();

                    Student vs = studentDAO.getStudent(vid);
                    if (vs != null) {
                        System.out.println(vs.getId() + " | " + vs.getName() + " | " + vs.getCourse());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    String sid = sc.nextLine();

                    Student s = studentDAO.getStudent(sid);

                    if (s != null) {
                        double pending = s.getTotalFee() - s.getPaidFee();
                        System.out.println("Pending: " + pending);

                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        sc.nextLine();

                        if (amt > pending) {
                            System.out.println("Cannot pay more than pending!");
                            break;
                        }

                        studentDAO.updateFee(sid, amt);
                        receiptDAO.addReceipt(sid, amt);

                        System.out.println("Payment + Receipt Saved!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    String rid = sc.nextLine();

                    List<Receipt> receipts = receiptDAO.getLast3Receipts(rid);

                    if (receipts.isEmpty()) {
                        System.out.println("No receipts found!");
                    } else {
                        for (Receipt r : receipts) {
                            System.out.println(r.getAmount() + " | " + r.getDate());
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    String did = sc.nextLine();
                    studentDAO.deleteStudent(did);
                    break;

                case 6:
                    List<Student> students = studentDAO.getAllStudents();

                    if (students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        for (Student st : students) {
                            System.out.println(st.getId() + " | " + st.getName() + " | " + st.getCourse());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
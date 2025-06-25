import java.util.*;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n Student Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println(" Exiting...");
                    return;
                }
                default -> System.out.println(" Invalid choice");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        studentList.add(new Student(id, name, marks));
        System.out.println(" Student added successfully.");
    }

    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println(" No records found.");
            return;
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        for (Student s : studentList) {
            if (s.getId() == id) {
                scanner.nextLine(); // clear buffer
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new Marks: ");
                double marks = scanner.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println(" Student updated.");
                return;
            }
        }
        System.out.println(" Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            if (itr.next().getId() == id) {
                itr.remove();
                System.out.println(" Student deleted.");
                return;
            }
        }
        System.out.println(" Student not found.");
    }
}

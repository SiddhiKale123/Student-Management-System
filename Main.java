import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }

    // Add Student
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, marks);
        studentList.add(student);

        System.out.println("Student Added Successfully!");
    }

    // View Students
    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : studentList) {
            s.display();
        }
    }

    // Update Student
    public static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.print("Enter New Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter New Marks: ");
                double newMarks = scanner.nextDouble();

                s.setName(newName);
                s.setMarks(newMarks);

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Delete Student
    public static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = scanner.nextInt();

        for (Student s : studentList) {
            if (s.getId() == id) {
                studentList.remove(s);
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }
}

    

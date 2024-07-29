import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Course{
    String code;
    String title;
    String description;
    int capacity;
    String schedule;
    int registeredStudents;


    public Course(String code, String title, String description, int capacity, String schedule){
        this.code=code;
        this.title=title;
        this.description=description;
        this.capacity=capacity;
        this.schedule=schedule;
        this.registeredStudents=0;
    }

    public boolean registerStudent(){
        if(registeredStudents < capacity){
            registeredStudents++;
            return true;
        }
        return false;
    }

    public boolean dropStudent(){
        if(registeredStudents > 0){
            registeredStudents--;
            return true;
        }
        return false;
    }

    public String toString(){
        return code+":"+title+"-"+description+"(capacity:"+capacity+",Registered:"+registeredStudents+", Schedule:"+schedule+")";
    }
}
    
class Student{
    String id;
    String name;
    ArrayList<Course>
    registeredCourses;

    public Student(String id,String name){
        this.id=id;
        this.name=name;
        this.registeredCourses=new ArrayList<>();
    }

    public void registerCourse(Course course){
        if(course.registerStudent()){
            registeredCourses.add(course);

            System.out.println("Successfully registered for the course "+course.title);
        }
        else{
            System.out.println("Course is full. Cannot register for "+course.title);
        }
    }

    public void dropCourse(Course course){
        if(registeredCourses.remove(course)){
            course.dropStudent();
            System.out.println("Successfully dropped couse "+course.title);
        }
        else{
            System.out.println("You are not registered for "+course.title);
        }
    }

    public String toString(){
        return id+":"+name+"-Registered courses:"+registeredCourses;
    }
}



public class CourseRegistrationSystem {
    static HashMap<String,Course>
    courses = new HashMap<>();
    static HashMap<String, Student>
    students = new HashMap<>();
    static Scanner scanner= new Scanner(System.in);


    public static void main(String args[]){
        courses.put("CS101",new Course("Cs101","Introduction to Computer Science","Basics of Computer Science",30,"MWF 9:00-10:00AM"));

        students.put("S001",new Student("S001","Alice Johnson"));
        students.put("S002",new Student("S002","Bob Smith"));


        while(true){
            System.out.println("1.List Courses");
            System.out.println("2.Register Student for Course");
            System.out.println("3.Drop Student from Course");
            System.out.println("4.List Students");
            System.out.println("5.Exit");
            System.out.println("Choose an option");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch(choice){
                case 1 :
                listCourses();
                break;

                case 2:
                registerStudentForCourse();
                break;

                case 3:
                dropStudentFromCourse();
                break;

                case 4:
                listStudents();
                break;

                case 5:
                System.out.println("Exiting...");
                scanner.close();
                return;

                default:
                System.out.println("Invalid choice please try again");

            }
        }

    }
    public static void listCourses(){
        for(Course course: courses.values()){
            System.out.println(course);
        }
    }

    public static void registerStudentForCourse(){
        System.out.println("Enter Student id: ");
        String studentId = scanner.nextLine();
        Student student = students.get(studentId);
        if(student==null){
            System.out.println("Student not found");
            return;
        }
        System.out.println("Enter course code:");
            String courseCode= scanner.nextLine();
            Course course = courses.get(courseCode);

            if(course==null){
                System.out.println("Course not found");
                return;
            }
            student.registerCourse(course);


    }
    public static void dropStudentFromCourse(){
        System.out.println("Enter StudentId:");

        String studentId= scanner.nextLine();
        Student student = students.get(studentId);

        if(student==null){
            System.out.println("Student not found");
            return;
        }
        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();
        Course course = courses.get(courseCode);

        if(course==null){
            System.out.println("Course not found");
            return;
        }
        student.dropCourse(course);

    }

    public static void listStudents(){
        for(Student student : students.values()){
            System.out.println(student);
        }
    }


    
}

package AlgoUeb2.util;

public class Student {
    private String prename;
    private String surname;
    private int studentID;
    private Course course;


    public Student(String prename, String surname, Course course, int studentID) {
        this.prename = prename;
        this.surname = surname;
        this.studentID = studentID;
        this.course = course;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student [First Name: " + prename + ", Last Name: " + surname + ", Course Number: " + course + ", Matriculation Number: " + studentID + "]";
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /*public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }*/

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}

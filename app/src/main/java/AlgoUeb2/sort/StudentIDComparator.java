package AlgoUeb2.sort;

import AlgoUeb2.util.Student;

public class StudentIDComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getStudentID() - o2.getStudentID();
    }
}

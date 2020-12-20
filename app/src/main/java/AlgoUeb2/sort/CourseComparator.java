package AlgoUeb2.sort;

import AlgoUeb2.util.Student;

public class CourseComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getCourse() == null && o2.getCourse() == null) {
            return 0;
        } else if (o1.getCourse() == null) {
            return 1;
        } else if (o2.getCourse() == null){
            return -1;
        }
        return o1.getCourse().compareTo(o2.getCourse());
    }
}

package AlgoUeb2.sort;

import AlgoUeb2.util.Student;

public class LastnameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getSurname() == null && o2.getSurname() == null) {
            return 0;
        } else if (o1.getSurname() == null) {
            return 1;
        } else if (o2.getSurname() == null){
            return -1;
        }
        return o1.getSurname().compareToIgnoreCase(o2.getSurname());
    }
}

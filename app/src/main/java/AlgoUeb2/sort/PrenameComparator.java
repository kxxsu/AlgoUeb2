package AlgoUeb2.sort;

import AlgoUeb2.util.Student;

public class PrenameComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getPrename() == null && o2.getPrename() == null) {
            return 0;
        } else if (o1.getPrename() == null) {
            return 1;
        } else if (o2.getPrename() == null){
        return -1;
        }
        return o1.getPrename().compareToIgnoreCase(o2.getPrename());
    }
}

package AlgoUeb2;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.lists.SinglyLinkedList;
import AlgoUeb2.search.Search;
import AlgoUeb2.search.Searchable;
import AlgoUeb2.sort.LastnameComparator;
import AlgoUeb2.sort.PrenameComparator;
import AlgoUeb2.sort.StudentIDComparator;
import AlgoUeb2.util.Course;
import AlgoUeb2.util.Student;
import org.junit.Assert;
import org.junit.Test;

public class SearchTest {

    private Searchable<Student> searchObject = new Search<>();

    private static final Student student1 = new Student("Mark", "Something", Course.B1, 7373);
    private static final Student student2 = new Student("Carl", "Something", Course.B2, 3737);
    private static final Student student3 = new Student("Huseyin", "SomethingNew", Course.B3, 2937);
    private static final Student student4 = new Student("Melisa", "Urgh", Course.B2, 2873);
    private static final Student student5 = new Student("Huseyin", "E", Course.B5, 7373);


    private Listable<Student> makeSinglyList() {
        Listable<Student> list = new SinglyLinkedList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        return list;
    }

    @Test
    public void goodPrenameSearchTest(){
        Listable<Student> list = makeSinglyList();
        Student student = new Student();
        student.setPrename("Huseyin");
        Listable<Student> matches = searchObject.search(list, new PrenameComparator(), student);

        Assert.assertEquals(matches.get(0).getPrename(), "Huseyin");
        Assert.assertEquals(matches.get(0).getSurname(), "SomethingNew");
        Assert.assertEquals(matches.get(1).getPrename(), "Huseyin");
        Assert.assertEquals(matches.get(1).getSurname(), "E");

    }
}

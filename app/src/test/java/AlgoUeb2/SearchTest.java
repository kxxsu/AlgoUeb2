package AlgoUeb2;

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
    private static final Student student2 = new Student("Carl", "SomethingElse", Course.B2, 3737);
    private static final Student student3 = new Student("Huseyin", "SomethingNew", Course.B3, 2937);
    private static final Student student4 = new Student("Melisa", "Urgh", Course.B4, 2873);
    private static final Student student5 = new Student("Sibel", "E", Course.B5, 4434);


    private Listable<Student> makeSinglyList() {
        Listable<Student> list = new SinglyLinkedList<>();
        list.add(student2);
        list.add(student1);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        return list;
    }

    @Test
    public void goodSearchStudentIDTest(){
        Listable<Student> list = makeSinglyList();
        int object = searchObject.search(list, new StudentIDComparator(), student4);
        Assert.assertEquals(3, object);
    }

    @Test
    public void goodSearchPrenameTest(){
        Listable<Student> list = makeSinglyList();
        int object = searchObject.search(list, new PrenameComparator(), student1);
        Assert.assertEquals(1, object);
    }

    @Test
    public void goodSearchLastNameTest(){
        Listable<Student> list = makeSinglyList();
        int object = searchObject.search(list, new LastnameComparator(), student2);
        Assert.assertEquals(0, object);
    }

    @Test
    public void goodSearchCourseTest(){
        Listable<Student> list = makeSinglyList();
        int object = searchObject.search(list, new StudentIDComparator(), student5);
        Assert.assertEquals(4, object);
    }
}

package AlgoUeb2;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.lists.SinglyLinkedList;
import AlgoUeb2.sort.*;
import AlgoUeb2.algorithms.MergeSort;
import AlgoUeb2.util.Course;
import AlgoUeb2.util.Student;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

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
    private Listable<Student> makeDoublyList() {
        Listable<Student> list = new DoublyLinkedList<>();
        list.add(student5);
        list.add(student4);
        list.add(student3);
        list.add(student2);
        list.add(student1);
        return list;
    }

    @Test
    public void courseNoSortTest() {
        Listable<Student> list = makeSinglyList();
        Sortable<Student> mergeSort = new MergeSort<>();
        mergeSort.sort(list, new CourseComparator(), 0, list.size() - 1);
        Assert.assertEquals(student1, list.get(0));
        Assert.assertEquals(student2, list.get(1));
        Assert.assertEquals(student3, list.get(2));
        Assert.assertEquals(student4, list.get(3));
        Assert.assertEquals(student5, list.get(4));
    }

    @Test
    public void studentIDSortTest() {
        Listable<Student> list = makeSinglyList();
        Sortable<Student> insertion = new MergeSort<>();
        insertion.sort(list, new StudentIDComparator(), 0, 4);
        Assert.assertEquals(student4, list.get(0));
        Assert.assertEquals(student3, list.get(1));
        Assert.assertEquals(student2, list.get(2));
        Assert.assertEquals(student5, list.get(3));
        Assert.assertEquals(student1, list.get(4));
    }

    @Test
    public void prenameSortTest() {
        Listable<Student> list = makeSinglyList();
        Sortable<Student> insertion = new MergeSort<>();
        insertion.sort(list, new PrenameComparator(), 0, 4);
        Assert.assertEquals(student2, list.get(0));
        Assert.assertEquals(student3, list.get(1));
        Assert.assertEquals(student1, list.get(2));
        Assert.assertEquals(student4, list.get(3));
        Assert.assertEquals(student5, list.get(4));
    }

    @Test
    public void lastnameSortTest() {
        Listable<Student> list = makeSinglyList();
        Sortable<Student> insertion = new MergeSort<>();
        insertion.sort(list, new LastnameComparator(), 0, 4);
        Assert.assertEquals(student1, list.get(1));
        Assert.assertEquals(student5, list.get(0));
        Assert.assertEquals(student2, list.get(2));
        Assert.assertEquals(student3, list.get(3));
        Assert.assertEquals(student4, list.get(4));
    }

    @Test
    public void goodCourseComparatorTestDoubly(){
        Listable<Student> list = makeDoublyList();
        Sortable<Student> mergeSort = new MergeSort<>();
        mergeSort.sort(list, new CourseComparator(), 0, list.size() - 1);

        Assert.assertEquals(student1, list.get(0));
        Assert.assertEquals(student2, list.get(1));
        Assert.assertEquals(student3, list.get(2));
        Assert.assertEquals(student4, list.get(3));
        Assert.assertEquals(student5, list.get(4));

    }
}

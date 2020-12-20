package AlgoUeb2;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.util.Course;
import AlgoUeb2.util.Student;
import org.junit.Assert;
import org.junit.Test;

public class DoublyLinkedTest {

    DoublyLinkedList<Student> test = new DoublyLinkedList<>();

    private static final Student student1 = new Student("Mark", "Something", Course.B1, 7373);
    private static final Student student2 = new Student("Carl", "SomethingElse", Course.B2, 3737);
    private static final Student student3 = new Student("Huseyin", "SomethingNew", Course.B3, 2937);
    private static final Student student4 = new Student("Melisa", "Urgh", Course.B4, 2873);


    @Test
    public void goodTestAddFirstAndGet() {
        test.addFirst(student1);
        Assert.assertEquals(student1, test.get(0));

        test.addFirst(student2);
        Assert.assertEquals(student2, test.get(0));
        Assert.assertEquals(student1, test.get(1));
    }

    @Test
    public void goodAddLast() {
        test.addLast(student1);
        Assert.assertEquals(student1, test.get(0));
        test.addLast(student2);
        Assert.assertEquals(student1, test.get(0));
        Assert.assertEquals(student2, test.get(1));
    }

    @Test
    public void goodSetIndex() {
        test.addFirst(student1);
        test.addLast(student2);
        test.addLast(student4);
        test.set(2, student3);

        Assert.assertEquals(student1, test.get(0));
        Assert.assertEquals(student2, test.get(1));
        Assert.assertEquals(student3, test.get(2));
    }

    @Test
    public void goodRemoveTest() throws Exception {
        test.add(student1);
        test.add(student2);
        test.add(student3);
        test.remove(1);
        Assert.assertEquals(student3, test.get(1));
    }

    @Test
    public void randfallRemoveTest() throws Exception {
        test.add(student1);
        test.add(student2);
        test.remove(0);
        Assert.assertEquals(student2, test.get(0));
    }

    @Test
    public void randfallRemoveTest2() throws Exception {
        test.add(student1);
        test.remove(0);
        Assert.assertTrue(test.isEmpty());
    }

    @Test
    public void goodAddTest(){
        test.add(student1);
        test.add(student2);
        test.add(student3);

        Assert.assertEquals(student1, test.get(0));
        Assert.assertEquals(student2, test.get(1));
        Assert.assertEquals(student3, test.get(2));
    }

    @Test
    public void goodAddAtIndexTest1(){
        test.add(student1);
        test.add(student3);
        test.add(1, student2);

        Assert.assertEquals(student1, test.get(0));
        Assert.assertEquals(student2, test.get(1));
        Assert.assertEquals(student3, test.get(2));
    }

    @Test
    public void goodAddAtIndexTest2(){
        test.add(student1);
        test.add(student4);
        test.add(1, student2);
        test.add(2, student3);

        Assert.assertEquals(student1, test.get(0));
        Assert.assertEquals(student2, test.get(1));
        Assert.assertEquals(student3, test.get(2));
        Assert.assertEquals(student4, test.get(3));
    }
}

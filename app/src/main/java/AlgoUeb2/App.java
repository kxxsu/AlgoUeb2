/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package AlgoUeb2;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.sort.*;
import AlgoUeb2.sort.algorithms.MergeSort;
import AlgoUeb2.util.Course;
import AlgoUeb2.util.Student;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args){
        Student student1 = new Student("Mark", "Something", Course.B1, 7373);
        Student student2 = new Student("Carl", "SomethingElse", Course.B2, 3100);
        Student student3 = new Student("Huseyin", "SomethingNew", Course.B3, 2937);
        Student student4 = new Student("Melisa", "Urgh", Course.B4, 2873);
        Student student5 = new Student("Sibel", "E", Course.B5, 2994);

        Listable<Student> list = new DoublyLinkedList<>();
        list.add(student2);
        list.add(student1);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        printStudents(list, "Unsortiert");
        Sortable<Student> mergeSort = new MergeSort<>();
        mergeSort.sort(list, new LastnameComparator(), 0, list.size() - 1);
        printStudents(list, "Merge");

        /*Listable<Student> list = Arrays.asList(student1, student2, student3, student4);
        printStudents(list, "Unsortiert");
        sort(list, new SelectionSort<Student>(), new StudentIDComparator());
        sort(list, new BubbleSort<Student>(), new CourseComparator());
        sort(list, new SelectionSort<Student>(), new CourseComparator());
        sort(list, new SelectionSort<Student>(), new PrenameComparator());
        sort(list, new BubbleSort<Student>(), new PrenameComparator());*/

    }

    private static void sort(Listable<Student> list, Sortable<Student> algo, Comparator<Student> comp) {
        algo.sort(list, comp);
        printStudents(list, algo.getClass().getSimpleName() + ": " + comp.getClass().getSimpleName());
    }

    private static void printStudents(Listable<Student> list, String headline) {
        System.out.println(headline);
        for(int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i));
        }
        System.out.println();
    }
}

package AlgoUeb2.util;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.sort.LastnameComparator;
import AlgoUeb2.sort.Sortable;
import AlgoUeb2.sort.algorithms.MergeSort;

public class Main
{
    public static void main(String[] args) {
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
    }

    private static void printStudents(Listable<Student> list, String headline) {
        System.out.println(headline);
        for(int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i));
        }
        System.out.println();
    }
}

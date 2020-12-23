package AlgoUeb2.commands;

import AlgoUeb2.algorithms.InsertionSort;
import AlgoUeb2.algorithms.MergeSort;
import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.lists.SinglyLinkedList;
import AlgoUeb2.search.Search;
import AlgoUeb2.search.Searchable;
import AlgoUeb2.sort.*;
import AlgoUeb2.util.Console;
import AlgoUeb2.util.Course;
import AlgoUeb2.util.Student;

import java.security.InvalidParameterException;

public class CommandFactory extends Menu {

    private static Listable<Student> list;

    private static final String SINGLE_MENU = "Use a SinglyLinkedList.";
    private static final String DOUBLE_MENU = "Use a DoublyLinkedList.";
    private static final String CHOSEN_SINGLE = System.lineSeparator() + "You have chosen a SinglyLinkedList.";
    private static final String CHOSEN_DOUBLE = System.lineSeparator() + "You have chosen a DoublyLinkedList.";
    private static final String ADD_MENU = "Add Student to the end of this list.";
    private static final String ADD = "Student added to the end of this list.";
    private static final String INSERT_SPECIFIED = "Inserts the student at the specified position in this list.";
    private static final String INSERT_BEGINNING = "Inserts the student at the beginning of this list.";
    private static final String ADD_LAST2 = "Appends the student to the end of this list";
    private static final String RETURN = "Returns the student at the specified position in this list.";
    private static final String PRINT_ALL = "Prints all students to console from this list.";
    private static final String SIZE = "Returns the number of students in this list.";
    private static final String REMOVE_ONE = "Removes the student at the specified position in this list.";
    private static final String CLEAR = "Removes all of the students from this list.";
    private static final String SEARCH = "Search for student(s) by different characteristics.";
    private static final String SORT = "Sort list by different properties.";
    private static final String EXIT_MENU = "Exit";
    private static final String EXIT = "See you another time!";
    private static final String SEARCH_UNSUCCESSFUL = "There are no students matching this criteria.";

    private static final String ASK_FIRST_NAME = "Please enter a first name: ";
    private static final String ASK_Last_NAME = "Please enter a last name: ";
    private static final String ASK_COURSE = "Please enter a course number (0, 1, 2, 3, 4): ";
    private static final String ASK_ID = "Please enter a studentID: ";
    private static final String ASK_INDEX = "Please enter a number for the index: ";
    private static final String WARNING_INDEX = "Warning: Invalid index. Try again!";


    public static DoublyLinkedList<ICommand> returnsCommandList() {
        DoublyLinkedList<ICommand> list = new DoublyLinkedList<>();
        list.add(exit());
        list.add(addStudent());
        list.add(addSpecified());
        list.add(addStudentFirst());
        list.add(addStudentLast());
        list.add(returnSpecifiedPosition());
        list.add(printAllStudents());
        list.add(printListSize());
        list.add(removeSpecified());
        list.add(clearList());
        list.add(search());
        list.add(sortList());

        return list;
    }

    public static DoublyLinkedList<ICommand> returnsListTypeChoice() {
        DoublyLinkedList<ICommand> list = new DoublyLinkedList<>();
        list.add(exit());
        list.add(chooseSinglyList());
        list.add(chooseDoublyList());
        return list;
    }

    //////////////////////////////////////////// Choosing a list //////////////////////////////////////////////////

    private static ICommand chooseSinglyList() {
        return new ICommand() {
            @Override
            public String execute() {
                list = new SinglyLinkedList<>();
                return CHOSEN_SINGLE;
            }

            @Override
            public String description() {
                return SINGLE_MENU;
            }
        };
    }

    private static ICommand chooseDoublyList() {
        return new ICommand() {
            @Override
            public String execute() {
                list = new DoublyLinkedList<>();
                return CHOSEN_DOUBLE;
            }

            @Override
            public String description() {
                return DOUBLE_MENU;
            }
        };
    }

    /////////////////////////////////////////// Main menu  //////////////////////////////////////////////////////////

    private static ICommand exit() {
        return new ICommand() {
            @Override
            public String execute() {
                System.exit(0);
                return System.lineSeparator() + EXIT;
            }

            @Override
            public String description() {
                return EXIT_MENU;
            }
        };
    }

    private static ICommand addStudent() {
        return new ICommand() {
            @Override
            public String execute() {
                Student student = askStudent();
                list.add(student);
                return System.lineSeparator() + ADD;
            }

            @Override
            public String description() {
                return ADD_MENU;
            }
        };
    }

    private static ICommand addSpecified() {
        return new ICommand() {
            @Override
            public String execute() {
                int indice = Console.readIntegerFromStdin(ASK_INDEX, true);
                if (indice >= list.size()) {
                    return System.lineSeparator() + WARNING_INDEX;
                }
                Student student = askStudent();
                list.add(indice, student);

                return System.lineSeparator() + "Student inserted at specified position.";
            }

            @Override
            public String description() {
                return INSERT_SPECIFIED;
            }
        };
    }

    private static ICommand addStudentFirst() {
        return new ICommand() {
            @Override
            public String execute() {
                Student student = askStudent();
                list.addFirst(student);
                return System.lineSeparator() + "Student inserted at the beginning of this list.";
            }

            @Override
            public String description() {
                return INSERT_BEGINNING;
            }
        };
    }

    private static ICommand addStudentLast() {
        return new ICommand() {
            @Override
            public String execute() {
                Student student = askStudent();
                list.addLast(student);
                return System.lineSeparator() + "Student appended to the end of this list.";
            }

            @Override
            public String description() {
                return ADD_LAST2;
            }
        };
    }

    private static ICommand returnSpecifiedPosition() {
        return new ICommand() {
            @Override
            public String execute() {
                int index = Console.readIntegerFromStdin(ASK_INDEX, true);
                if (list.isEmpty()) {
                    return System.lineSeparator() + "This list is empty.";
                } else if (indexOutOfBounds(index)) {
                    return WARNING_INDEX;
                }

                Student student = list.get(index);
                return System.lineSeparator() + "Student at " + index + ": " + student;

            }

            @Override
            public String description() {
                return RETURN;
            }
        };
    }

    private static ICommand printAllStudents() {
        return new ICommand() {
            @Override
            public String execute() {
                if (list.isEmpty()) {
                    return System.lineSeparator() + "This list is empty.";
                } else {
                    list.printAll();
                    return System.lineSeparator() + "All students printed." + System.lineSeparator();
                }
            }

            @Override
            public String description() {
                return PRINT_ALL;
            }
        };
    }

    private static ICommand printListSize() {
        return new ICommand() {
            @Override
            public String execute() {
                if (list.isEmpty()) {
                    return System.lineSeparator() + "The list is empty.";
                } else {
                    return System.lineSeparator() + "There are " + list.size() + " elements in this list.";
                }
            }

            @Override
            public String description() {
                return SIZE;
            }
        };
    }

    private static ICommand removeSpecified() {
        return new ICommand() {
            @Override
            public String execute() throws Exception {
                int i = Console.readIntegerFromStdin(ASK_INDEX, true);
                if (i > list.size()) {
                    return System.lineSeparator() + "There is no such index. Try again!";
                }
                list.remove(i);
                return "Student has been removed.";
            }

            @Override
            public String description() {
                return REMOVE_ONE;
            }
        };
    }

    private static ICommand clearList() {
        return new ICommand() {
            @Override
            public String execute() {
                list.clear();
                return System.lineSeparator() + "List is cleared.";
            }

            @Override
            public String description() {
                return CLEAR;
            }
        };
    }

    ////////////////////////////////////////////// Search ////////////////////////////////////////////////////////

    private static ICommand search() {
        return new ICommand() {
            @Override
            public String execute() throws Exception {
                if (list.isEmpty()) {
                    return System.lineSeparator() + "This list is empty.";
                } else {
                    DoublyLinkedList<ICommand> searchableList = new DoublyLinkedList<>();
                    searchableList.add(exit());
                    searchableList.add(searchFirstName());
                    searchableList.add(searchLastName());
                    searchableList.add(searchCourse());
                    searchableList.add(searchStudentID());

                    System.out.println(buildMenu(searchableList, "Select a property to search for the student:"));
                    ICommand selectedCmd = selectCommand(searchableList);
                    System.out.println(selectedCmd.execute());

                    return "";
                }
            }

            @Override
            public String description() {
                return SEARCH;
            }
        };
    }

    private static ICommand searchFirstName() {
        return new ICommand() {
            @Override
            public String execute() {
                Listable<Student> foundStudents;
                Searchable<Student> object = new Search<>();

                Student student = new Student();
                String name = Console.readStringFromStdin("Please enter first name for the search: ");
                student.setPrename(name);

                foundStudents = object.search(list, new PrenameComparator(), student);

                if (foundStudents.isEmpty()) {
                    return System.lineSeparator() + SEARCH_UNSUCCESSFUL;
                } else {
                    System.out.println(System.lineSeparator() + "Students found: " + System.lineSeparator());
                    foundStudents.printAll();
                    return System.lineSeparator() + "Matches printed.";
                }
            }

            @Override
            public String description() {
                return "Search by first name?";
            }
        };
    }

    private static ICommand searchLastName() {
        return new ICommand() {
            @Override
            public String execute() {
                Listable<Student> foundStudents;
                Searchable<Student> object = new Search<>();

                Student student = new Student();
                String name = Console.readStringFromStdin("Please enter last name for the search: ");
                student.setSurname(name);

                foundStudents = object.search(list, new LastnameComparator(), student);

                if (foundStudents.isEmpty()) {
                    return System.lineSeparator() + SEARCH_UNSUCCESSFUL;
                } else {
                    System.out.println(System.lineSeparator() + "Students found: " + System.lineSeparator());
                    foundStudents.printAll();
                    return System.lineSeparator() + "Matches printed.";
                }
            }

            @Override
            public String description() {
                return "Search by last name?";
            }
        };
    }

    private static ICommand searchCourse() {
        return new ICommand() {
            @Override
            public String execute() {
                Listable<Student> foundStudents;
                Searchable<Student> object = new Search<>();

                Student student = new Student();
                student.setCourse(askCourse());

                foundStudents = object.search(list, new CourseComparator(), student);

                if (foundStudents.isEmpty()) {
                    return System.lineSeparator() + SEARCH_UNSUCCESSFUL;
                } else {
                    System.out.println(System.lineSeparator() + "Students found: " + System.lineSeparator());
                    foundStudents.printAll();
                    return System.lineSeparator() + "Matches printed.";
                }
            }

            @Override
            public String description() {
                return "Search by course number?";
            }
        };
    }

    private static ICommand searchStudentID() {
        return new ICommand() {
            @Override
            public String execute() {
                Listable<Student> foundStudents;
                Searchable<Student> object = new Search<>();

                Student student = new Student();
                int studentID = Console.readIntegerFromStdin("Please enter last name for the search: ", true);
                student.setStudentID(studentID);

                foundStudents = object.search(list, new StudentIDComparator(), student);

                if (foundStudents.isEmpty()) {
                    return System.lineSeparator() + SEARCH_UNSUCCESSFUL;
                } else {
                    System.out.println(System.lineSeparator() + "Students found: " + System.lineSeparator());
                    foundStudents.printAll();
                    return System.lineSeparator() + "Matches printed.";
                }
            }

            @Override
            public String description() {
                return "Search by matriculation number?";
            }
        };
    }

    //////////////////////////////////////////// Sorting /////////////////////////////////////////////////////////

    private static ICommand sortList() {
        return new ICommand() {
            @Override
            public String execute() throws Exception {
                if (list.isEmpty()) {
                    return "List is empty.";
                } else {
                    DoublyLinkedList<ICommand> sortingList = new DoublyLinkedList<>();
                    sortingList.add(exit());
                    sortingList.add(insertionSort());
                    sortingList.add(mergeSort());

                    System.out.println(buildMenu(sortingList, "Select a sorting method for sorting:"));
                    ICommand selectedCmd = selectCommand(sortingList);
                    System.out.println(selectedCmd.execute());

                    return "";
                }
            }

            @Override
            public String description() {
                return SORT;
            }
        };
    }

    private static ICommand insertionSort() {
        return new ICommand() {
            @Override
            public String execute() throws Exception {
                DoublyLinkedList<ICommand> sortingList = new DoublyLinkedList<>();
                sortingList.add(exit());
                sortingList.add(insertionSortByFirstName());
                sortingList.add(insertionSortByLastName());
                sortingList.add(insertionSortByCourse());
                sortingList.add(insertionSortByStudentID());

                System.out.println(buildMenu(sortingList, "Select a property for sorting with the 'Insertion Sort' algorithm:"));
                ICommand selectedCmd = selectCommand(sortingList);
                System.out.println(selectedCmd.execute());
                return "";
            }

            @Override
            public String description() {
                return "Insertion Sort?";
            }
        };
    }

    private static ICommand insertionSortByFirstName() {
        return new ICommand() {
            @Override
            public String execute() {
                Sortable<Student> sorting = new InsertionSort<>();
                sorting.sort(list, new StudentIDComparator());
                list.printAll();

                return System.lineSeparator() + "List sorted with Insertion Sort.";
            }

            @Override
            public String description() {
                return "Sort by prename?";
            }
        };
    }

    private static ICommand insertionSortByLastName() {
        return new ICommand() {
            @Override
            public String execute() {
                Sortable<Student> sorting = new InsertionSort<>();
                sorting.sort(list, new StudentIDComparator());
                list.printAll();

                return System.lineSeparator() + "List sorted with Insertion Sort.";
            }

            @Override
            public String description() {
                return "Sort by surname?";
            }
        };
    }

    private static ICommand insertionSortByCourse() {
        return new ICommand() {
            @Override
            public String execute() {
                Sortable<Student> sorting = new InsertionSort<>();
                sorting.sort(list, new CourseComparator());
                list.printAll();

                return System.lineSeparator() + "List sorted with Insertion Sort.";
            }

            @Override
            public String description() {
                return "Sort by course?";
            }
        };
    }

    private static ICommand insertionSortByStudentID() {
        return new ICommand() {
            @Override
            public String execute() {
                Sortable<Student> sorting = new InsertionSort<>();
                sorting.sort(list, new StudentIDComparator());
                list.printAll();

                return System.lineSeparator() + "List sorted with Insertion Sort.";
            }

            @Override
            public String description() {
                return "Sort by matriculation number?";
            }
        };
    }


    private static ICommand mergeSort() {
        return new ICommand() {
            @Override
            public String execute() throws Exception {
                DoublyLinkedList<ICommand> sortingList = new DoublyLinkedList<>();
                sortingList.add(exit());
                sortingList.add(mergeSortByFirstName());
                sortingList.add(mergeSortByLastName());
                sortingList.add(mergeSortByCourse());
                sortingList.add(mergeSortByStudentID());

                System.out.println(buildMenu(sortingList, "Select a property for sorting with the 'Merge Sort' algorithm:"));
                ICommand selectedCmd = selectCommand(sortingList);
                System.out.println(selectedCmd.execute());
                return "";
            }

            @Override
            public String description() {
                return "Merge Sort?";
            }
        };
    }

    private static ICommand mergeSortByFirstName() {
        return new ICommand() {
            @Override
            public String execute() {
                Sortable<Student> merge = new MergeSort<>();
                merge.sort(list, new PrenameComparator());
                return System.lineSeparator() + "List sorted with Merge Sort by prename";
            }

            @Override
            public String description() {
                return "Sort by prename?";
            }
        };
    }

    private static ICommand mergeSortByLastName() {
        return new ICommand() {
            @Override
            public String execute() {
                Sortable<Student> merge = new MergeSort<>();
                merge.sort(list, new LastnameComparator());
                return System.lineSeparator() + "List sorted with Merge Sort by surname";
            }

            @Override
            public String description() {
                return "Sort by surname?";
            }
        };
    }

    private static ICommand mergeSortByCourse() {
        return new ICommand() {
            @Override
            public String execute() {
                Sortable<Student> merge = new MergeSort<>();
                merge.sort(list, new CourseComparator());
                return System.lineSeparator() + "List sorted with Merge Sort by course";
            }

            @Override
            public String description() {
                return "Sort by course?";
            }
        };
    }

    private static ICommand mergeSortByStudentID() {
        return new ICommand() {
            @Override
            public String execute() {
                Sortable<Student> merge = new MergeSort<>();
                merge.sort(list, new StudentIDComparator());
                return "List sorted with Merge Sort by matriculation number.";
            }

            @Override
            public String description() {
                return "Sort by matriculation number?";
            }
        };
    }

    //////////////////////////////////////////// Private Methods //////////////////////////////////////////////////

    private static boolean indexOutOfBounds(int i) {
        if (i < 0 || i > list.size() - 1) {
            return true;
        }
        return false;
    }


    private static Student askStudent() {
        String name = Console.readStringFromStdin(ASK_FIRST_NAME);
        String lastName = Console.readStringFromStdin(ASK_Last_NAME);
        Course course = askCourse();
        int studentID = Console.readIntegerFromStdin(ASK_ID, true);

        return new Student(name, lastName, course, studentID);
    }

    private static Course askCourse() {
        Course course;
        int courseNumber = Console.readIntegerFromStdin(ASK_COURSE, true);

        switch (courseNumber) {
            case 0 -> {
                return course = Course.B1;
            }
            case 1 -> {
                return course = Course.B2;
            }
            case 2 -> {
                return course = Course.B3;
            }
            case 3 -> {
                return course = Course.B4;
            }
            case 4 -> {
                return course = Course.B5;
            }
            default -> {
                System.out.println("Invalid index. Select between 0 and 4");
                return askCourse();
            }
        }
    }


}

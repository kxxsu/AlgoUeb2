package AlgoUeb2.commands;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.lists.SinglyLinkedList;
import AlgoUeb2.util.Console;
import AlgoUeb2.util.Course;
import AlgoUeb2.util.Student;

public class CommandFactory {

    private static Listable<Student> list;

    private static final String SINGLE_MENU = "Use a SinglyLinkedList.";
    private static final String DOUBLE_MENU = "Use a DoublyLinkedList.";
    private static final String CHOSEN_SINGLE = "You have chosen a SinglyLinkedList.";
    private static final String CHOSEN_DOUBLE = "You have chosen a DoublyLinkedList.";
    private static final String ADD = "Add Student to the end of this list.";
    private static final String INSERT_SPECIFIED = "Inserts the student at the specified posotion in this list.";
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

    private static final String ASK_FIRST_NAME = "Please enter a first name: ";
    private static final String ASK_Last_NAME = "Please enter a last name: ";
    private static final String ASK_COURSE = "Please enter a course: ";
    private static final String ASK_ID = "Please enter a studentID: ";



    public static DoublyLinkedList<ICommand> returnsCommandList() {
        DoublyLinkedList<ICommand> list = new DoublyLinkedList<>();

        return list;
    }

    private static DoublyLinkedList<ICommand> chooseListType() {
        DoublyLinkedList<ICommand> list = new DoublyLinkedList<>();
        list.add(exit());
        list.add(chooseSinglyList());
        list.add(chooseDoublyList());
        return list;
    }

    private static ICommand exit() {
        return new ICommand() {
            @Override
            public String execute() {
                System.exit(0);
                return EXIT;
            }

            @Override
            public String description() {
                return EXIT_MENU;
            }
        };
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

    /////////////////////////////////////////// Student actions //////////////////////////////////////////////////////////

    private static ICommand addStudent() {
        return new ICommand() {
            @Override
            public String execute() {
                //askStudent();
                return null;
            }

            @Override
            public String description() {
                return null;
            }
        };
    }

//    private static Student askStudent() {
//        String name = Console.readStringFromStdin(ASK_FIRST_NAME);
//        String lastName = Console.readStringFromStdin(ASK_Last_NAME);
//        int course = Console.readIntegerFromStdin(ASK_COURSE, true);
//        int studentID = Console.readIntegerFromStdin(ASK_ID, true);
//
//        return new Student(name, lastName, course, studentID);
//    }
}

package AlgoUeb2.commands;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.lists.SinglyLinkedList;
import AlgoUeb2.util.Student;

public class CommandFactory {

    private static Listable<Student> list;

    private static final String SINGLE_MENU = "Use a SinglyLinkedList.";
    private static final String DOUBLE_MENU = "Use a DoublyLinkedList.";
    private static final String CHOSEN_SINGLE = "You have chosen a SinglyLinkedList.";
    private static final String CHOSEN_DOUBLE = "You have chosen a DoublyLinkedList.";
    private static final String EXIT_MENU = "Exit";
    private static final String EXIT = "See you another time!";



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


}

package AlgoUeb2.commands;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.lists.Listable;
import AlgoUeb2.lists.SinglyLinkedList;
import AlgoUeb2.util.Student;

public class CommandFactory {

    private static Listable<Student> list;

    public static DoublyLinkedList<ICommand> returnsCommandList() {
        DoublyLinkedList<ICommand> list = new DoublyLinkedList<>();

        return list;
    }

    private static ICommand singlyListChosen() {
        return new ICommand() {
            @Override
            public String execute() {
                list = new SinglyLinkedList<>();
                return null;
            }

            @Override
            public String description() {
                return null;
            }
        };
    }

    private static ICommand doublyListChosen() {
        return new ICommand() {
            @Override
            public String execute() {
                list = new DoublyLinkedList<>();
                return null;
            }

            @Override
            public String description() {
                return null;
            }
        };
    }


}

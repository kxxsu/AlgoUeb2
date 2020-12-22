package AlgoUeb2.commands;

import AlgoUeb2.lists.DoublyLinkedList;
import AlgoUeb2.util.Console;

public class Menu {
    protected static String buildMenu(DoublyLinkedList<ICommand> cmdList, String headline) {
        StringBuilder builder = new StringBuilder();
        builder.append(System.lineSeparator());
        builder.append("Console-Application: Exercise-2 \t\tMelisa Fidan 576604" + System.lineSeparator());

        builder.append(System.lineSeparator() + headline + System.lineSeparator());

        builder.append(System.lineSeparator());

        for (int i = 1; i < cmdList.size(); i++) {
            ICommand command = cmdList.get(i);
            builder.append(i + ". " + command.description() + System.lineSeparator());
        }
        builder.append(0 + ". " + cmdList.get(0).description() + System.lineSeparator());
        return builder.toString();
    }

    protected static ICommand selectCommand(DoublyLinkedList<ICommand> cmdList) {
        do {
            int select = Console.readIntegerFromStdin("Please enter a number for an option: ", true);
            if(select >= 0 && select < cmdList.size()) {
                return cmdList.get(select);
            }
            System.out.println("Warning: Invalid option. Please select a number between 0 and " + (cmdList.size() - 1));
        } while (true);
    }
}

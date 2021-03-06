/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package AlgoUeb2;

import AlgoUeb2.commands.CommandFactory;
import AlgoUeb2.commands.ICommand;
import AlgoUeb2.commands.Menu;
import AlgoUeb2.lists.DoublyLinkedList;

public class App extends Menu {

    public static void main(String[] args) throws Exception {
        DoublyLinkedList<ICommand> listType = CommandFactory.returnsListTypeChoice();
        System.out.println(buildMenu(listType, "Select list type before starting main menu:"));
        ICommand selectedCommand = selectCommand(listType);
        System.out.println(selectedCommand.execute());

        DoublyLinkedList<ICommand> commands = CommandFactory.returnsCommandList();
        do {
            System.out.println(buildMenu(commands, "You selected " + CommandFactory.getList().getClass().getSimpleName() + ":"));
            ICommand selectedCmd = selectCommand(commands);
            System.out.println(selectedCmd.execute());
        } while (true);
    }
}

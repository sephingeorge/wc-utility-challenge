package challenge.coding.wc;

import java.util.Scanner;

import challenge.coding.wc.command.Command;
import challenge.coding.wc.command.CommandFactory;
import challenge.coding.wc.display.DisplayMessage;

public class WCApp {

    public static void main(String[] args) {
        DisplayMessage.displayBannerMessage();
        DisplayMessage.displayExitMessage();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">");
            String nextLine = scanner.nextLine();
            if (nextLine.equals("exit")) {
                break;
            }
            if (nextLine.equals("help")) {
                DisplayMessage.displayHelpMessage();
            } else {
                try {
                    Command command = CommandFactory.getCommand(nextLine);
                    while(command != null) {
                        command.execute();
                        command = command.next();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        scanner.close();
    }

}

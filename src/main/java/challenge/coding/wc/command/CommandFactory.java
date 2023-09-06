package challenge.coding.wc.command;

import challenge.coding.wc.exception.InvalidCommandException;
import challenge.coding.wc.exception.NoInputException;
import challenge.coding.wc.exception.UnRecognizedInput;
import challenge.coding.wc.exception.WCUtilityException;

public class CommandFactory {

    private CommandFactory() {
        throw new IllegalStateException("Not supported");
    }

    public static Command getCommand(String userInput) throws WCUtilityException {
        if (userInput == null) {
            throw new NoInputException("Enter valid command");
        }
        String[] words = userInput.split(" ");
        if (words.length < 2 || words.length > 3) {
            throw new UnRecognizedInput("Input not recognized. Type \"help\" to know more info");
        }
        if (!isValidCommand(words[0])) {
            throw new InvalidCommandException("Command not recognized. Type \"help\" to know more info");
        }

        String option = words.length == 2 ? "" : words[1];
        String path = words.length == 2 ? words[1] : words[2];

        if (option.equals("")) {
            return getCommandImpl("", path);
        }
        Command nextCommand = new FileNamePrintCommand(path);
        String[] optionCharacters = option.split("");

        int i = optionCharacters.length - 1;
        while (i > 0) {
            var command = getCommandImpl(optionCharacters[i], path);
            command.setNext(nextCommand);
            nextCommand = command;
            i--;
        }

        return nextCommand;
    }

    private static Command getCommandImpl(String option, String path) {
        return switch (option) {
            case "c" -> new BytesLengthCommand(path);
            case "l" -> new LinesCountCommand(path);
            case "w" -> new WordCountCommand(path);
            case "m" -> new CharacterCountCommand(path);
            default -> new BytesLengthCommand(path, new LinesCountCommand(path,
                    new WordCountCommand(path, new CharacterCountCommand(path, new FileNamePrintCommand(path)))));

        };
    }

    private static boolean isValidCommand(String command) {
        return command.equals("wc");
    }

}
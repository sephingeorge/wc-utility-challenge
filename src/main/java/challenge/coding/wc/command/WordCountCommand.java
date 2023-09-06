package challenge.coding.wc.command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import challenge.coding.wc.display.DisplayMessage;

public class WordCountCommand extends Command {
    private final String inputPath;

    public WordCountCommand(String inputPath, Command nextCommand) {
        super();
        this.next = nextCommand;
        this.inputPath = inputPath;
    }

    public WordCountCommand(String inputPath) {
        super();
        this.inputPath = inputPath;
    }

    @Override
    public void execute() throws Exception {
        Path path = Paths.get(inputPath);
        List<String> lines = Files.readAllLines(path);
        int count = 0;
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (!word.trim().equals("")) {
                    count++;
                }
            }
        }
        DisplayMessage.displayResult(count);
    }
}

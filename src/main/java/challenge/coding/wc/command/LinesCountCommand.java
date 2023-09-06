package challenge.coding.wc.command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import challenge.coding.wc.display.DisplayMessage;

public class LinesCountCommand extends Command {

    private final String inputPath;

    public LinesCountCommand(String inputPath, Command nextCommand) {
        super();
        this.next = nextCommand;
        this.inputPath = inputPath;
    }

    public LinesCountCommand(String inputPath) {
        super();
        this.inputPath = inputPath;
    }

    @Override
    public void execute() throws Exception {
        Path path = Paths.get(inputPath);
        List<String> lines = Files.readAllLines(path);
        DisplayMessage.displayResult(lines.size());
    }

}

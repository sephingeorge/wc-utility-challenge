package challenge.coding.wc.command;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import challenge.coding.wc.display.DisplayMessage;

public class WordCountCommandTest {

    private WordCountCommand wordCountCommand;

    @BeforeEach
    public void setUp() {
        wordCountCommand = new WordCountCommand("test.txt", null);
    }

    @Test
    void testExecute() throws Exception {
        Path testFilePath = Paths.get("test.txt");
        byte[] testData = "Hello, world!\nThis is a test.".getBytes();
        Files.write(testFilePath, testData);

        // Execute the command
        assertDoesNotThrow(() -> wordCountCommand.execute());
        // Clean up the test file
        Files.delete(testFilePath);
    }
}

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.*;

public class BookTest {
    Library library = new Library();

    @Test
    public void createBook() {
        try {
            Path path = Files.createFile(library.directory.resolve("name3.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(Files.exists(Paths.get(String.valueOf(library.directory.resolve("name3.txt")))));
    }
}

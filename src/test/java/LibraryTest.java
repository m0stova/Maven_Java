import org.junit.Test;
import java.nio.file.Files;
import static org.junit.Assert.*;

public class LibraryTest {
    Library library = new Library();

    @Test
    public void readEntireCatalog() {
        library.readCatalog(library.directory);
        assertTrue(Files.exists(library.directory));
    }
}

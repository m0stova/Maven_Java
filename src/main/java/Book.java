import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;

public class Book extends Library {
    String author;
    String nameOfTheBook;

    public void createABook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The book author: ");
        author = scanner.nextLine();
        Path pathToBook = Paths.get(author + "_" + nameOfTheBook + ".txt");
        try {
            Files.createFile(directory.resolve(pathToBook));
            System.out.println("The book has been added");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteABook(String line) {
        if (catalog.containsKey(line)) {
            try {
                Files.delete(Paths.get(String.valueOf(directory.resolve(line + ".txt"))));
                System.out.println("The book has been deleted");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            startTheProcess();
        }

    }

}

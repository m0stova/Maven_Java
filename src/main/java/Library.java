import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.IOException;


public class Library {
    Path directory = Paths.get("src\\main\\resources\\Library\\Books");
    static Map<String, Path> catalog;

    public Map<String, Path> readCatalog(Path path) {
        try {
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            catalog = Files.list(Paths.get(String.valueOf(path)))
                    .collect(Collectors.toMap(p -> p.getFileName()
                                    .toString()
                                    .replace(".txt", ""),
                            p -> p));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public void showTheEntireCatalog() {
        catalog.forEach((k, v) -> System.out.println(k));
    }

    public void startTheProcess() {
        readCatalog(directory);
        System.out.println("""
                To do list:\s
                create a book? -> write "create"\s
                delete a book? -> write "delete"\s
                show the entire catalog? -> write "show"\s
                exit? -> write "exit".""");
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        switch (scanner.nextLine()) {
            case "create":
                book.createABook();
                startTheProcess();
                return;
            case "delete":
                showTheEntireCatalog();
                book.deleteABook(scanner.nextLine());
                startTheProcess();
                return;
            case "exit":
                return;
        }
        scanner.close();
    }
}

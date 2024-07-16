import java.util.ArrayList;
import java.util.Optional;

public class BookStore {
    private final Inventory inventory = new Inventory();

    public void addToInventory(BookIdentity.Title title, BookIdentity.Author author, Stock copies) {
        if (Book.isValidData(title, author, copies)) {
            return;
        }
        inventory.findBook(title, author)
            .ifPresentOrElse(
                book -> book.addCopies(copies),
                () -> inventory.add(new Book(title, author, copies))
            );
    }

    public void sellBook(BookIdentity.Title title, BookIdentity.Author author, Stock copies) {
        inventory.findBook(title, author)
            .ifPresent(book -> book.removeCopies(copies));
    }

    static class Inventory {
        private final ArrayList<Book> inventory = new ArrayList<>();

        public Optional<Book> findBook(BookIdentity.Title title, BookIdentity.Author author) {
            return inventory.stream()
                .filter(book -> book.equals(new BookIdentity(title, author)))
                .findFirst();
        }

        public void add(Book book) {
            inventory.add(book);
        }
    }
}

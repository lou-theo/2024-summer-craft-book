import java.util.ArrayList;

public class BookStore {
    private final Inventory inventory = new Inventory();

    public void addToInventory(BookIdentity.Title title, BookIdentity.Author author, Stock copies) {
        if (Book.isValidData(title, author, copies)) {
            return;
        }
        Book foundBook = inventory.findBook(title, author);
        if (foundBook != null) {
            foundBook.addCopies(copies);
            return;
        }
        inventory.add(new Book(title, author, copies));
    }

    public void sellBook(BookIdentity.Title title, BookIdentity.Author author, Stock copies) {
        Book foundBook = inventory.findBook(title, author);
        if (foundBook == null) {
            return;
        }
        foundBook.removeCopies(copies);
    }

    static class Inventory {
        private final ArrayList<Book> inventory = new ArrayList<>();

        public Book findBook(BookIdentity.Title title, BookIdentity.Author author) {
            return inventory.stream()
                .filter(book -> book.equals(new BookIdentity(title, author)))
                .findFirst().orElse(null);
        }

        public void add(Book book) {
            inventory.add(book);
        }
    }
}

### Exercise 2: Identify the steps

Identify the Object Calisthenics steps in the code below? 

A little reminder:
   1) Only One Level Of Indentation
   2) Don’t Use The ELSE Keyword
   3) Wrap All Primitives And Strings
   4) First Class Collections
   5) One Dot Per Line
   6) Don’t Abbreviate
   7) Keep All Entities Small
   8) No More Than 2 Invariants per class
   9) No Getters/Setters/Properties


>**Write a TODO to where it is in the code that does not respect a step, mark which step it is and the action you would do.**

Feel free to correct the code as you see fit.

Ci-dessous les annotations.
Voir le code pour une version refactorée.

```java
import java.util.ArrayList;

public class BookStore {
    // 6 - Rename property to `inventory`
    // 4 - create inventory class
    private ArrayList<Book> inv = new ArrayList<>();

    public void addBook(Book.Title title, Book.Author author, Book.Stock copies) {
        if (title != null && author != null && copies > 0) {
            Book foundBook = null;
            for (Book book : inv) {
                // 9 - no getter used to make decision => create a method in inventory to find a book using a method on book to test equality
                if (book.getTitle().equals(title)
                    && book.getAuthor().equals(author)) {
                    foundBook = book;
                    break;
                }
            }
            if (foundBook != null) {
                foundBook.addCopies(copies);
                // 2 - return here and remove else
            } else {
                inv.add(new Book(title, author, copies));
            }
        }
    }

    public void sellBook(Book.Title title, Book.Author author, int copies) {
        for (Book book : inv) {
            // 9 - no getter used to make decision => create a method in inventory to find a book using a method on book to test equality
            if (book.getTitle().equals(title)
                && book.getAuthor().equals(author)) {
                book.removeCopies(copies);
                // 1 - invert condition
                if (book.getCopies() <= 0) {
                    inv.remove(book);
                }
                break;
            }
        }
    }
}
```

```java
class Book {
    // 3 - Create class for bookTitle, author and copies
    // 8 - Regroup author and title in a class
    private String title;
    private String author;
    private int copies;

    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public void addCopies(int additionalCopies) {
        if (additionalCopies > 0) {
            this.copies += additionalCopies;
        }
    }

    public void removeCopies(int soldCopies) {
        if (soldCopies > 0 && this.copies >= soldCopies) {
            this.copies -= soldCopies;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }
}
```
public class BookIdentity {
    private final Title title;
    private final Author author;

    public BookIdentity(Title title, Author author) {
        this.title = title;
        this.author = author;
    }

    public static boolean isValidData(BookIdentity.Title title, BookIdentity.Author author) {
        // I don't want to change the behavior of the original code, so I will keep the null check, but I think it could be changed to have null check in BookIdentity.Title and BookIdentity.Author classes. If null, it throws (or whatever) but it's impossible to have invalid data and so no need to check it elsewhere.
        return title.value == null || author.value == null;
    }

    public boolean equals(BookIdentity identity) {
        return title.equals(identity.title) && author.equals(identity.author);
    }

    public static class Title {
        public String value;
    }

    public static class Author {
        public String value;
    }
}

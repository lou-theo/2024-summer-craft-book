class Book {
    private final BookIdentity identity;
    private final Stock stock;

    public Book(BookIdentity.Title title, BookIdentity.Author author, Stock stock) {
        this.identity = new BookIdentity(title, author);
        this.stock = stock;
    }

    public static boolean isValidData(BookIdentity.Title title, BookIdentity.Author author, Stock copies) {
        return BookIdentity.isValidData(title, author) || copies.isPositive();
    }

    public boolean equals(BookIdentity identityToCompare) {
        return identity.equals(identityToCompare);
    }

    public void addCopies(Stock copies) {
        stock.add(copies);
    }

    public void removeCopies(Stock copies) {
        stock.remove(copies);
    }
}

package exercises.books;

public class Book {

    //attributi
    private String title;
    private int numberOfPages;
    private String author;
    private String editor;

    //costruttore


    public Book(String title, int numberOfPages, String author, String editor) throws IllegalArgumentException{
        isStringValid(title, "Titolo");
        isStringValid(author, "Autore");
        isStringValid(editor, "Editore");
        isIntValid(numberOfPages, "Numero di pagine");
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.editor = editor;
    }

    //metodi
    private void isStringValid(String value, String type) throws IllegalArgumentException {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(type + " non valido");
        }
    }

    private void isIntValid(int value, String type) throws IllegalArgumentException {
        if (value <= 0) {
            throw new IllegalArgumentException(type + " non valido");
        }
    }

    public String bookInfo() {
        return String.format("Titolo del libro: %s; Autore: %s, Editore: %s; Numero di pagine %d.", title, author, editor, numberOfPages);
    }

    //setter e getter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException{
        isStringValid(title, "Titolo");
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) throws IllegalArgumentException{
        isIntValid(numberOfPages, "Numero di pagine");
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IllegalArgumentException{
        isStringValid(author, "Autore");
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) throws IllegalArgumentException{
        isStringValid(editor, "Editore");
        this.editor = editor;
    }
}

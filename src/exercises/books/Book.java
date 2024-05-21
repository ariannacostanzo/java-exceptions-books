package exercises.books;

public class Book {

    //attributi
    private String title;
    private int numberOfPages;
    private String author;
    private String editor;

    //costruttore


    public Book(String title, int numberOfPages, String author, String editor) throws IllegalArgumentException{
        isStringValid(title);
        isStringValid(author);
        isStringValid(editor);
        isIntValid(numberOfPages);
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.editor = editor;
    }

    //metodi
    private void isStringValid(String value) throws IllegalArgumentException {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Invalid" + value);
        }
    }

    private void isIntValid(int value) throws IllegalArgumentException {
        if (value <= 0) {
            throw new IllegalArgumentException("Invalid " + value);
        }
    }

    //setter e getter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException{
        isStringValid(title);
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) throws IllegalArgumentException{
        isIntValid(numberOfPages);
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IllegalArgumentException{
        isStringValid(author);
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) throws IllegalArgumentException{
        isStringValid(editor);
        this.editor = editor;
    }
}

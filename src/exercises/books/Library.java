package exercises.books;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        int quantity = 0;


        while (quantity <= 0) {
            try {
                System.out.println("Quanti libri vuoi inserire?");
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity <= 0) {
                    throw new IllegalArgumentException();
                }

            } catch (NumberFormatException e) {
                System.out.println("Inserisci una quantità valida");
            } catch (IllegalArgumentException e ) {
                System.out.println("Inserisci una quantità positiva");
            }
        }

        Book[] books = new Book[quantity];

        for (int i = 0; i < quantity; i++) {
            String title = "";
            String author = "";
            String editor = "";
            int numberOfPages = 0;
            while(title.isEmpty() || author.isEmpty() || editor.isEmpty() || numberOfPages <= 0) {
                int pagination = i +1;
                try {
                    System.out.println("*******************************");
                    System.out.println("INSERIAMO IL LIBRO " + pagination);
                    System.out.println("*******************************");
                    System.out.println("Inserisci il titolo del libro");
                    title = scanner.nextLine();
                    System.out.println("Inserisci l'autore del libro");
                    author = scanner.nextLine();
                    System.out.println("Inserisci l'editore del libro");
                    editor = scanner.nextLine();
                    System.out.println("Inserisci il numero di pagine del libro");
                    numberOfPages = Integer.parseInt(scanner.nextLine());
                    books[i] = new Book(title, numberOfPages, author, editor);
                } catch (NumberFormatException e) {
                    System.out.println("Inserisci un numero di pagine valido");
                } catch (IllegalArgumentException e ) {
                    System.out.println(e.getMessage());
                }
            }


        }


















        scanner.close();


    }
}

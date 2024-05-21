package exercises.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
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

        File file = new File("./resources/books.txt");
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("I libri che hai inserito sono: ");
            for (int i = 0; i < books.length; i++) {
                fileWriter.write(books[i].bookInfo());
            }

        } catch (IOException e) {
            System.out.println("could not retrieve file");
        } finally {
            if (fileWriter !=null) {
                try {
                    //lo chiudo
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }

        }

        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("unable to read file");
        }


        scanner.close();


    }




}

package tawelib;

import java.util.ArrayList;

public class ConnectionExample {

    public static void main(String[] args) {

        //Searching for books (where id = 1)

        ArrayList resources = Conn.searchResource(1);

        for (Object resource: resources) {
            if (resource instanceof Book) {
                System.out.println(((Book) resource).getAuthor());
            }
        }

        //Declaring a new book

        Book newBook = (Book) Conn.searchResource(1).get(0);

        newBook.setID(2);
        newBook.setTitle("The Lord of the Rings");
        newBook.setYear(1954);
        newBook.setimageID("010000000000002000000000000000000001");

        ArrayList copies = new ArrayList();
        copies.add(4);
        copies.add(5);
        copies.add(6);

        newBook.setCopies(copies);

        newBook.setAuthor("J.R.R. Tolkien");
        newBook.setPublisher("Allen & Unwin");
        newBook.setISBN("9780141392066");
        newBook.setLanguage("English");

        //Write new book then print number of affected rows

        System.out.println(Conn.writeObject(newBook));


    }

}

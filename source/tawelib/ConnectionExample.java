package tawelib;

import java.util.ArrayList;

public class ConnectionExample {

    public static void main(String[] args) {

        //Searching for books (where id = 1)
        System.out.println("jje");

        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);
        IDsOfCopies.add(2);
        Book newbook = new Book (12, "helo", 1198, "img",IDsOfCopies, "her",
                "gew", " 13445", "lahn") ;
        //Write new book then print number of affected rows
        System.out.println("hello");
        System.out.println(Conn.writeObject(newbook));


    }

}

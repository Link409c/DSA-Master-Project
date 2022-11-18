package DungeonProject.Model;

import java.util.InputMismatchException;

public class NameFormatException extends InputMismatchException {

    public NameFormatException(){
        super("Enter a First and Last name, with a 16-character limit (excluding spaces.)");
        System.out.println(getMessage());
    }
}

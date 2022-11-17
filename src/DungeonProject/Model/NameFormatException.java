package DungeonProject.Model;

import java.util.InputMismatchException;

public class NameFormatException extends InputMismatchException {

    public NameFormatException(){
        super("Enter a First and Last name, with an 18-character limit (excluding spaces.)");
    }
}

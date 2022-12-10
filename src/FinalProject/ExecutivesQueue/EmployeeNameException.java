package FinalProject.ExecutivesQueue;

import javax.naming.InvalidNameException;

public class EmployeeNameException extends InvalidNameException {

    public EmployeeNameException(){
        super("Input a valid Employee Name.");
    }
}

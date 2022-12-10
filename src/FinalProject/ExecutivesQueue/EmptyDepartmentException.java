package FinalProject.ExecutivesQueue;

public class EmptyDepartmentException extends NullPointerException{

    public EmptyDepartmentException() {

        super("This Department has no Executives.");
    }
}

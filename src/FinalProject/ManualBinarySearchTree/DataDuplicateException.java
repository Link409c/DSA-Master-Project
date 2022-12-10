package FinalProject.ManualBinarySearchTree;

import java.security.InvalidParameterException;

/**
 * Data Duplicate Exception informs the user when they attempt to pass duplicate
 * data to their Binary Search Tree.
 *
 * @author Christian Simpson
 * @version 12/8/22
 */
public class DataDuplicateException extends InvalidParameterException {

    public DataDuplicateException(){
        super("Your data already exists in this Binary Search Tree.");
    }
}

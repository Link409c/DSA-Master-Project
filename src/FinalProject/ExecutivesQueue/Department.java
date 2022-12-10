package FinalProject.ExecutivesQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A Department is a data container which holds a queue of Executives.
 */
public class Department {

    /**
     * Calculate Salaries method traverses the list of executives and updates their salaries
     * based on the number of executives in the department. An Executive's pay is based on their
     * seniority in the department, with each executive recieving a raise of $5000 for each other
     * executive who is junior to them in the Department. The base salary for an executive is $40k.
     */
    public void calculateSalaries(){
        int size = getDeptExecutives().size();
        Queue<Executive> temp = new LinkedList<>();
        if(getDeptExecutives() != null) {
            for (int i = 0; i < size; i++) {
                Executive e = getDeptExecutives().poll();
                if(e != null) {
                    e.setSalary(e.getBASE_SALARY() + (getRAISE() * (size - i)));
                    temp.add(e);
                }
            }
            while(!temp.isEmpty()) {
                getDeptExecutives().add(temp.poll());
            }
        }
        else{
            throw new EmptyDepartmentException();
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Queue<Executive> getDeptExecutives() {
        return deptExecutives;
    }

    public void setDeptExecutives(Queue<Executive> deptExecutives) {
        this.deptExecutives = deptExecutives;
    }

    public int getRAISE() {
        return RAISE;
    }

    public Department(){}

    public Department(String departmentName){
        this.departmentName = departmentName;
        this.deptExecutives = new LinkedList<>();
    }

    /**
     * the name of this department.
     */
    private String departmentName;

    /**
     * the Executives hired in this department.
     */
    private Queue<Executive> deptExecutives;

    private final int RAISE = 5000;
}

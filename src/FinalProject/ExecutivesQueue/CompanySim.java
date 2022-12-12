package FinalProject.ExecutivesQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * CompanySim simulates hiring and shifting of executives in different Departments of a Company.
 */
public class CompanySim {
    /**
     * creates a new Department and adds it to the array.
     */
    public void addDepartment(String deptName){
        //get departments array size
        int size = getDepartments().length;
        //pass array into temp
        Department[] temp = getDepartments();
        //make a larger array to hold the new department
        Department[] increaseDepartments = new Department[size + 1];
        //copy the contents of the old array into the new one
        for(int i = 0; i < size; i++){
            increaseDepartments[i] = temp[i];
        }
        //insert the new department at the end of the new array
        increaseDepartments[increaseDepartments.length - 1] = new Department(deptName);
        //set the new array as the global variable
        setDepartments(increaseDepartments);
    }

    /**
     * finds the index of a specific department in the array of departments.
     * @param departmentName the name of the department to search for.
     * @return return the index of the department.
     */
    public int findDepartmentIndex(String departmentName){
        Department[] theDepartments = getDepartments();
        int theIndex = 0;
        for(int i = 0; i < getDepartments().length; i++){
            if(theDepartments[i].getDepartmentName().equals(departmentName)){
                theIndex = i;
            }
        }
        return theIndex;
    }

    public Executive findExecutive(String executiveName, String departmentName){
        return null;
    }
    /**
     * creates a new Executive.
     * @return returns an executive.
     */
    public Executive hire(String name){
        return new Executive(name);
    }

    /**
     * adds an executive to a department.
     * @param executive the executive to add
     * @param departmentName the name of the department to add the executive to.
     */
    public void join(Executive executive, String departmentName){
        Department[] theDepartments = getDepartments();
        int theIndex = findDepartmentIndex(departmentName);
        theDepartments[theIndex].getDeptExecutives().add(executive);
        theDepartments[theIndex].calculateSalaries();
        setDepartments(theDepartments);
    }

    /**
     * removes an executive from their respective department.
     * @param executiveName the name of the executive to remove
     * @param departmentName the name of the executive's department
     */
    public void quit(String executiveName, String departmentName){
        //find the department
        Department[] theDepartments = getDepartments();
        Department theDepartment = theDepartments[findDepartmentIndex(departmentName)];
        //store removed executives in temp
        Queue<Executive> temp = new LinkedList<>();
        int size = theDepartment.getDeptExecutives().size();
        boolean found = false;
        //find the correct executive to remove
        if(size > 0) {
            while (!found || temp.size() < size) {
                Executive e = theDepartment.getDeptExecutives().peek();
                assert e != null;
                //remove the executive and place them in unemployed queue
                if (e.getName().equals(executiveName)) {
                        found = true;
                        Executive toQuit = theDepartment.getDeptExecutives().poll();
                        theDepartments[findDepartmentIndex("Unemployed")]
                                .getDeptExecutives().add(toQuit);
                        //every poll that doesn't produce the target keeps track of size
                    } else {
                        temp.add(theDepartment.getDeptExecutives().poll());
                    }
            }
            while (!theDepartment.getDeptExecutives().isEmpty()) {
                temp.add(theDepartment.getDeptExecutives().poll());
            }
            theDepartment.setDeptExecutives(temp);
            theDepartment.calculateSalaries();
        }
    }

    /**
     * displays a table of each department's salaries listed in descending order.
     */
    public void payroll(){
        System.out.printf("%-20s %5s %2s %5s %5s\n", "Department", "|", "Executive", "|", "Salary");
        for(Department d : getDepartments()){
            //print department name in first column, first executive in 2nd, salary in 3rd
            System.out.printf("%-20s %5s", d.getDepartmentName(), "|");
            for(Executive e : d.getDeptExecutives()) {
                //print each executive and salary in line with above exec and salary
                System.out.printf("%-2s %5s %s %5s\n", e.getName(), "|", "$", e.getSalary());
            }
        }
    }

    public CompanySim(){
        setDepartments(new Department[1]);
        Department[] d = getDepartments();
        d[0] = new Department("Unemployed");
        setDepartments(d);
    }

    public CompanySim(String departmentName){
        setDepartments(new Department[1]);
        Department[] d = getDepartments();
        d[0] = new Department("Unemployed");
        setDepartments(d);
        addDepartment(departmentName);
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    private Department[] departments;


}

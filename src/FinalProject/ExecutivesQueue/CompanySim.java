package FinalProject.ExecutivesQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * CompanySim simulates hiring and shifting of executives in different Departments of a Company.
 */
public class CompanySim {
    /**
     * creates a new Department and adds it to the array.
     */
    public void addDepartment(String deptName){
        Department department = new Department(deptName);
        int size = getDepartments().length;
        Department[] temp = getDepartments();
        temp[size] = department;
        setDepartments(temp);
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
        for(Department d : getDepartments()){
            System.out.printf("%s", d.getDepartmentName());
            for(Executive e : d.getDeptExecutives()) {
                //print department name in first column, first executive in 2nd, salary in 3rd
                //following lines
                //print each executive and salary in line with above exec and salary
            }
        }
    }

    public CompanySim(){
        Department[] departments = new Department[1];
        departments[0].setDepartmentName("Unemployed");
        setDepartments(departments);
    }

    public CompanySim(String departmentName){
        Department[] departments = new Department[2];
        departments[0].setDepartmentName("Unemployed");
        departments[1].setDepartmentName(departmentName);
        setDepartments(departments);
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    private Department[] departments;


}

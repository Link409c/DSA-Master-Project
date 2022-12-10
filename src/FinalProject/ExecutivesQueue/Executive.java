package FinalProject.ExecutivesQueue;

/**
 * An Executive represents a salaried employee of a department.
 */
public class Executive {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBASE_SALARY() {
        return BASE_SALARY;
    }

    public Executive(){}

    public Executive(String name){
        this.name = name;
    }

    private String name;

    private int salary;

    private final int BASE_SALARY = 40000;

}

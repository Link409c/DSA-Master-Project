package FinalProject.ExecutivesQueue;


/**
 * Test Class for the Company Simulator Program.
 *
 * @author Christian Simpson
 * @version 12/9/22
 *
 */
public class CompanySimTester {

    public static void main(String[] args){

        CompanySim cs = new CompanySim();

        cs.addDepartment("Finance");
        cs.addDepartment("Advertising");
        cs.addDepartment("Sales");
        cs.addDepartment("Human Resources");

        Department[] departments = cs.getDepartments();

        for (Department department : departments) {
            if (department != null) {
                System.out.print(department.getDepartmentName() + " ");
            }
        }
        String names = "Elly Sharma, Tinatini Vang, Na'omi Mac Cnáimhín, Manpreet Ola, Jehu Kalmár, Hiltrud Falk, " +
                "Coleen Hlaváček, Levar Malý, Cormacc Skalický, Ariel Forney, Edi Tehrani, Alkmene Ardelean, Ankarl Zegers, " +
                "Kristapor Ó Cathaláin, Jayden Frost, Steve McDicheal, Bobson Dugnutt, Todd Bonzalez, Karl Dandleton,";

        /*String[] execNames = new String[1];
        int index = 0;
        while(!names.isEmpty()) {
            int end = names.indexOf(',');
            String name = names.substring(0, end+1);
            if(index >= execNames.length){
                String[] temp = new String[execNames.length + 1];
                for(int i = 0; i < execNames.length; i++){
                    temp[i] = execNames[i];
                }
                execNames = temp;
            }
            execNames[index] = name;
            names = names.substring(end+1).trim();
            index++;
        }*/

        String[] execNames = names.split(", ");

        for(String name : execNames){
            departments[0].getDeptExecutives().add(cs.hire(name));
        }

        Department unemployed = departments[0];

        System.out.printf("\n %s \n", unemployed.getDepartmentName());
        for(Executive e : unemployed.getDeptExecutives()){
            System.out.print(e.getName() + " ");
        }

    }


}

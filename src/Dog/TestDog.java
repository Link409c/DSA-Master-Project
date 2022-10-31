package Dog;

import java.util.ArrayList;

public class TestDog {
    public static void main (String args[]){
        //create a new dog object
        Dog myDogOne = new Dog();
        //create local variables
        String dogColor = "Black and White";
        int dogAge = 12;
        ArrayList<String> dogNicknames = new ArrayList() {
            {
                add("Bellbell");
                add("Moose");
                add("Wumpus");
            }
        };
        int[] dogTreats = {2, 4, 10};
        //create a dog object with the populated constructor
        Dog myDogTwo = new Dog(dogColor, dogAge, dogNicknames, dogTreats);
        //pass the variables to the setter methods for dog 1
        myDogOne.setColor(dogColor);
        myDogOne.setAge(dogAge);
        myDogOne.setNicknames(dogNicknames);
        myDogOne.setTreats(dogTreats);
        //check the age of the first dog
        myDogOne.checkAge(myDogOne.getAge());
        //make the first dog bark
        myDogOne.barkingDog();
        //print the first dog's information in the list and array
        myDogOne.printAll(dogNicknames, dogTreats);
        System.out.print("\n");
        //check the age of the second dog
        myDogTwo.checkAge(myDogTwo.getAge());
        //make the second dog bark
        myDogTwo.barkingDog();
        //print the second dog's information from arraylist and array
        myDogTwo.printAll(dogNicknames, dogTreats);
    }
}

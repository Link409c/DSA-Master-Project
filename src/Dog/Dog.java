package Dog;

import java.util.*;

public class Dog {

    public String color;                    //color of the dog
    public int age;                         //age of the dog
    public ArrayList<String> nicknames;     //dog nicknames
    public int[] treats;                    //array of treats

    //default constructor
    public Dog(){}

    //populated constructor
    public Dog(String aColor, int anAge, ArrayList<String> moreNicknames, int[]moreTreats){
        color = aColor;
        age = anAge;
        nicknames = moreNicknames;
        treats = moreTreats;
    }

    //getter methods
    public String getColor(){
        return color;
    }

    public int getAge(){
        return age;
    }

    public ArrayList getNicknames(){
        return nicknames;
    }

    public int[] getTreats(){
        return treats;
    }

    //setter methods
    public void setColor(String aColor){
        color = aColor;
    }

    public void setAge(int anAge){
        age = anAge;
    }

    public void setNicknames(ArrayList<String> moreNicknames){
        nicknames = moreNicknames;
    }

    public void setTreats(int[] moreTreats){
        treats = moreTreats;
    }

    //method to check if the age is higher than 5
    public void checkAge(int anAge){
        if(age > 5){
            System.out.print("The dog is more than 5 years old!\n");
        }
    }
    //loop method using for and while loops to print the dog barking
    public void barkingDog(){
        int i;
        for(i = 0; i < 5; i++){
            System.out.print("Woof! ");
        }
        System.out.print("\n");
        while(i > 0){
            System.out.print("Woof! ");
            i--;
        }
        System.out.print("\n");
    }
    //printAll method to print the contents of the Arraylist and Array
    public void printAll(ArrayList<String> nicknames, int[] treats) {
        //use foreach loop to print AL
        System.out.print("My dog's nicknames are: ");
        for(String nickname : nicknames){
            System.out.print(nickname + " ");
        }
        System.out.print("\n");
        System.out.print("My dog ate this many treats every day: ");
        //use for or while loop to print array
        for(int i = 0; i < treats.length; i++){
            System.out.print(treats[i]);
        }
    }
}

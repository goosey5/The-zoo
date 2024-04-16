import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<Animal> animalsList = new ArrayList<Animal>();

    public static void main(String[] args) {
        int amountOfAnimals = getAmountOfAnimalsFromUser();
        for (int i = 0; i < amountOfAnimals; i++) {
            animalsList.add(createAnimal());
        }
        printer();

        int moreActions = nextAction();
        Scanner asking = new Scanner(System.in);
        int isWhile = 1;

        while (isWhile == 1) {
            if (moreActions == 1) {
                animalsList.add(createAnimal());
                printer();

                System.out.println("Do you want to make more actions? if yes enter 1," +
                        " if you don't want more actions press 0");
                isWhile=asking.nextInt();
                if (isWhile==1)
                {
                    moreActions=nextAction();
                }

            }
            else if (moreActions == 2) {
                String getName = getNameOfAnimalToRemove();
                for (int i = 0; i < getAmountOfAnimals(); i++) {
                    if (animalsList.get(i).name.equals(getName) || animalsList.get(i).nickName.equals(getName)) {
                        animalsList.remove(i);
                        System.out.println(getName + " has been removed.");
                        printer();
                    }
                }
            }
            //stop da program
            else if (moreActions == 3) {
                isWhile = 0;
            }
            else
            {
                nextActionTwo();
            }
        }
    }
    static int getAmountOfAnimalsFromUser()
    {
        Scanner animals = new Scanner(System.in);
        System.out.println("How many animals would you like to add to the zoo?");
        int amountOfAnimals=animals.nextInt();
        return amountOfAnimals;
    }

    static int getAmountOfAnimals()
    {
        return animalsList.size();
    }

    //Getting animals info
    static Animal createAnimal()
    {
        Scanner information = new Scanner(System.in);
        Animal a = new Animal();
        System.out.println("What is the name of the animal?");
        a.name=information.nextLine();
        System.out.println("What is the nick-name of the animal?");
        a.nickName=information.nextLine();
        return a;
    }
    //prints the name+nickname of the animal
    static void printer()
    {
        for(int i=0;i<animalsList.size();i++)
        {
            animalsList.get(i).print();
        }
    }
    //
    static int nextAction()
    {
        Scanner nextAction = new Scanner(System.in);
        System.out.println("If you want to add more animals press 1" +
                ", if you want to delete an animal press 2, if you want to stop the program press 3");
        int check=nextAction.nextInt();
        return check;
    }
    static int nextActionTwo()
    {
        Scanner nextAction = new Scanner(System.in);
        System.out.println("The key you pressed is not an option, try again. \nIf you want to add more animals press 1" +
                ", if you want to delete an animal press 2, if you want to stop the program press 3");
        int check=nextAction.nextInt();
        return check;
    }
    static int addAnimal()
    {
        Scanner adder = new Scanner(System.in);
        System.out.println("Which animal would you like to add to the zoo?");
        int amountOfAnimals=adder.nextInt();
        return amountOfAnimals;
    }
    static String getNameOfAnimalToRemove()
    {
        Scanner deleter = new Scanner(System.in);
        System.out.println("State the name or nickname of the animal that you would like to remove from the zoo:");
        String animalToDelete=deleter.nextLine();
        return animalToDelete;
    }
}
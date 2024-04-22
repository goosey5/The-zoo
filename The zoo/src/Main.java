import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<Animal> animalsList = new ArrayList<Animal>();

    public static void main(String[] args) {
        int amountOfAnimals = getAmountOfAnimalsFromUser();
        for (int i = 0; i < amountOfAnimals; i++) {
            animalsList.add(createAnimal());
        }
        animalPrinter();

        int moreActions = nextAction();
        Scanner asking = new Scanner(System.in);
        int isWhile = 1;

        while (isWhile == 1) {
            if (moreActions == 1) {
                animalsList.add(createAnimal());
                animalPrinter();

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
                        animalPrinter();

                        System.out.println("Do you want to make more actions? if yes enter 1," +
                                " if you don't want more actions press 0");
                        isWhile=asking.nextInt();
                        if (isWhile==1)
                        {
                            moreActions=nextAction();
                        }
                    }
                    else
                    {
                        getName=errorInGettingAnimalsIdentityToDelete();
                    }
                }
            }
            //stop da program
            else if (moreActions == 3) {
                Scanner checkAgain = new Scanner(System.in);
                System.out.println("Are you sure you want to stop the program?");
                String reAssuring=checkAgain.nextLine();
                if(reAssuring.equalsIgnoreCase("yes")||reAssuring.equalsIgnoreCase("im sure")){
                    isWhile = 0;
                }
                else
                {
                    System.out.println("I knew it!");
                    moreActions=nextAction();
                }
            }

            else
            {
                moreActions=nextActionTwo();
            }
        }
    }
    static int getAmountOfAnimalsFromUser()
    {
        Scanner animals = new Scanner(System.in);
        System.out.println("How many animals would you like to add to the zoo?");
        int amountOfAnimals=animals.nextInt();
        int doesWhile=1;

        while(doesWhile==1){
            if(amountOfAnimals>10)
            {
                System.out.println("You cant add more than 10 animals to the zoo.(it'll be too big!)");
                System.out.println("please choose another amount of animals that you would like to add to the zoo.");
                amountOfAnimals=animals.nextInt();
            }
            else if (amountOfAnimals<0)
            {
                System.out.println("You cant create negative amount of animals, choose another number.");
                amountOfAnimals=animals.nextInt();
            }
            else
            {
                doesWhile=0;
            }
        }

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
        int doesWhile=1;

        while(doesWhile==1)
        if(a.name.equals(a.nickName))
        {
            System.out.println("The nick-name of an animal cant be the same as its name. choose another nick-name.");
            a.nickName=information.nextLine();
        }
        else
        {
            doesWhile=0;
        }

        return a;
    }
    //prints the name+nickname of the animal
    static void animalPrinter()
    {
        for(int i=0;i<animalsList.size();i++)
        {
            animalsList.get(i).print();
        }
    }

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
    static String getNameOfAnimalToRemove()
    {
        Scanner deleter = new Scanner(System.in);
        System.out.println("State the name or nickname of the animal that you would like to remove from the zoo:");
        String animalToDelete=deleter.nextLine();
        return animalToDelete;
    }
    static String errorInGettingAnimalsIdentityToDelete()
    {
        Scanner deleter = new Scanner(System.in);
        System.out.println("The name or nickname that you wrote is not in the list," +
                "please state the name or nickname of the animal that you would like to remove from the zoo again:");
        String animalToDelete=deleter.nextLine();
        return animalToDelete;
    }
}
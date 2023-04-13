package org.example;
import java.util.*;

public class Association
{
    static Scanner sc = new Scanner(System.in);
    private static Teams teams = new Teams();
    private Season season;
    public Association()
    {

    }
    public static void main(String[] args)
    {
        Player player1 = new Player("Devin Booker",2500.00,"All Star", 26, "Suns", 1);
        Player player2 = new Player("Chris Paul",1500.00,"Core", 37, "Suns", 3);
        Player player3 = new Player("Deandre Ayton",2000.00,"All Star", 24, "Suns", 22);
        Player player4 = new Player("Kevin Durant",3000.00,"All Star", 34, "Suns", 35);
        Player player5 = new Player("Terrence Ross",1000.00,"Common", 32, "Suns", 8);
        Players sunsPl = new Players();
        sunsPl.addPlayer(player1);
        sunsPl.addPlayer(player2);
        sunsPl.addPlayer(player3);
        sunsPl.addPlayer(player4);
        sunsPl.addPlayer(player5);
        Team suns = new Team("Suns", sunsPl);
        teams.addTeam(suns);
        player1 = new Player("Andre Drummond",1500.00,"Core", 29, "Bulls", 3);
        player2 = new Player("Zach LaVine",3000.00,"All Star", 28, "Bulls", 8);
        player3 = new Player("Dalen Terry",900.00,"Edge", 20, "Bulls", 25);
        player4 = new Player("Terry Taylor",1000.00,"Common", 23, "Bulls", 32);
        player5 = new Player("Carlik Jones",800.00,"Edge", 25, "Bulls", 22);
        Players bullsPl = new Players();
        bullsPl.addPlayer(player1);
        bullsPl.addPlayer(player2);
        bullsPl.addPlayer(player3);
        bullsPl.addPlayer(player4);
        bullsPl.addPlayer(player5);
        Team bulls = new Team("Bulls", bullsPl);
        teams.addTeam(bulls);

        boolean running = true;
        while(running) {
            System.out.print("Welcome to the Association! Please make a selection from the menu:\n" +
                    "1. Explore the teams.\n" +
                    "2. Arrange a new season.\n" +
                    "X. Exit the system.\n" +
                    "Enter a choice: ");
            String choice = sc.nextLine();
            switch(choice){
                case "X":
                    running = false;
                    break;
                case "1":
                    teamsPage();
                    break;
                case "2":
                    break;
            }
        }
    }
    public static void teamsPage(){
        boolean running = true;
        while(running) {
            System.out.print("Welcome to the Teams Page! Please make a selection from the menu:\n" +
                    "1. Display all teams.\n" +
                    "2. Display all players.\n" +
                    "3. Add a new team.\n" +
                    "4. Manage an existing team.\n" +
                    "5. Delete an existing team.\n" +
                    "6. Display all players by an level.\n" +
                    "R. Return to previous menu.\n" +
                    "Enter a choice: ");
            String choice = sc.nextLine();
            switch(choice) {
                case "R":
                    running = false;
                    break;
                case "1":
                    teams.printTeams();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;

            }
        }
    }

}
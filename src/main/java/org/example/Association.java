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
        player1 = new Player("Trae Young", 2200.00, "All Star", 24, "Hawks", 11);
        player2 = new Player("John Collins", 2000.00, "All Star", 25, "Hawks", 20);
        player3 = new Player("Aaron Holiday", 800.00, "Edge", 26, "Hawks", 3);
        player4 = new Player("Jalen Johnson", 1000.00, "Common", 21, "Hawks", 1);
        player5 = new Player("Trent Forrest", 1200.00, "Common", 24, "Hawks", 2);
        Players hawksPl = new Players();
        hawksPl.addPlayer(player1);
        hawksPl.addPlayer(player2);
        hawksPl.addPlayer(player3);
        hawksPl.addPlayer(player4);
        hawksPl.addPlayer(player5);
        Team hawks = new Team("Hawks", hawksPl);
        teams.addTeam(hawks);
        player1 = new Player("Mikal Bridges", 2400.00, "All Star", 26, "Nets", 1);
        player2 = new Player("Ben Simmons", 2000.00, "All Star", 26, "Nets", 10);
        player3 = new Player("Patty Mills", 900.00, "Edge", 34, "Nets", 8);
        player4 = new Player("Joe Harris", 1200.00, "Common", 31, "Nets", 12);
        player5 = new Player("Seth Curry", 1900.00, "Core", 32, "Nets", 30);
        Players netsPl = new Players();
        netsPl.addPlayer(player1);
        netsPl.addPlayer(player2);
        netsPl.addPlayer(player3);
        netsPl.addPlayer(player4);
        netsPl.addPlayer(player5);
        Team nets = new Team("Nets", netsPl);
        teams.addTeam(nets);

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
                    System.out.println("Done");
                    running = false;
                    break;
                case "1":
                    teamsPage();
                    break;
                case "2":
                    seasonPage();
                    break;
                default:
                    System.out.println("Please enter a number 1 or 2, or press X to exit.");
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
            switch (choice) {
                case "R" -> running = false;
                case "1" -> teams.printTeams();
                case "2" -> teams.printTeamPlayers();
                case "3" -> teamAdd();
                case "4" -> teamManage();
                case "5" -> teamRemove();
                case "6" -> printLevel();
            }
        }
    }
    public static void printLevel(){
        System.out.print("Please enter the player's level that you want to view: ");
        boolean running = true;
        while(running){
            String levelName = sc.nextLine();
            running = !teams.printByLevel(levelName);
            if(!running){break;}
            System.out.print("No such level! Please re-enter the level: ");
        }


    }
    public static void teamAdd() {
        System.out.print("Please enter the name of the team: ");
        while (true) {
            String teamName = sc.nextLine();
            if (teams.getTeamIndexbyName(teamName) == -1) {
                Players newPl = new Players();
                Team newTeam = new Team(teamName, newPl);
                teams.addTeam(newTeam);
                System.out.printf("Team %s added!\n", teamName);
                break;
            }
            System.out.printf("Team %s already exist! Please enter a new name: ", teamName);
        }
    }
    public static void teamRemove(){
        System.out.print("Please enter the team's name that you want to delete: ");
        while (true) {
            String teamName = sc.nextLine();
            Integer teamIndex = teams.getTeamIndexbyName(teamName);
            if (teamIndex != -1) {
                teams.removeTeamIndex(teamIndex);
                System.out.printf("The team %s has been deleted.\n", teamName);
                break;
            }
            System.out.println("The team you want to delete does not exist!");
        }
    }
    public static void teamManage() {
        System.out.print("Please enter the team's name that you want to manage: ");
        String teamName = sc.nextLine();
        int teamIndex = teams.getTeamIndexbyName(teamName);
        if (teamIndex == -1) {
            System.out.println("Team does not exist!");
            return;
        }
        Team currentTeam = teams.teams.get(teamIndex);
        boolean looping = true;
        while (looping) {
            System.out.printf("Welcome to the %s 's Page! Please make a selection from the menu:\n" +
                    "1. Display team's players.\n" +
                    "2. Add a new player.\n" +
                    "3. Update an existing player.\n" +
                    "4. Delete an existing player.\n" +
                    "R. Return to previous menu.\n" +
                    "Enter a choice: ", teamName);
            String choice = sc.nextLine();
            String name;
            Double credit;
            Integer age;
            Integer No = -1;
            boolean invalidNo = true;
            switch (choice) {
                case "R":
                    looping = false;
                    break;
                case "1":
                    Utils.playerHeader();
                    currentTeam.printPlayers();
                    Utils.playerTableEnd();
                    break;
                case "2":
                    System.out.print("Please enter the player's name: ");
                    name = sc.nextLine();
                    System.out.print("Please enter the player's credit: ");
                    credit = sc.nextDouble();
                    System.out.print("Please enter the player's age: ");
                    age = sc.nextInt();
                    System.out.print("Please enter the player's No: ");
                    while(invalidNo){
                        No = sc.nextInt();
                        if (!(currentTeam.noOccupiedByWho(No).equals(""))){
                            System.out.printf("This No has been occupied by: %s. Please re-enter the No: ", currentTeam.noOccupiedByWho(No));
                        } else {invalidNo = false;}
                    }
                    String level;
                    if (credit>=2000){
                        level = "All Star";
                    }
                    else if (credit>=1500){
                        level = "Core";
                    }
                    else if (credit>=1000){
                        level = "Common";
                    }
                    else {
                        level = "Edge";
                    }
                    Player player = new Player(name,credit,level,age,teamName,No);
                    System.out.printf("Player %s added!\n", name);
                    currentTeam.addPlayer(player);
                    sc.nextLine();
                    break;
                case "3":
                    System.out.print("Please enter the player's name: ");
                    name = sc.nextLine();
                    if(!(currentTeam.doesPlayerNameExist(name))){
                        System.out.println("Player does not exist.");
                        break;
                    }
                    System.out.print("Please enter the name: ");
                    String newName = sc.nextLine();
                    System.out.print("Please enter the credit: ");
                    credit = sc.nextDouble();
                    System.out.print("Please enter the age: ");
                    age = sc.nextInt();
                    System.out.print("Please enter the No: ");
                    while(invalidNo){
                        No = sc.nextInt();
                        String playerName = currentTeam.noOccupiedByWho(No);
                        if (!(playerName.equals("")) || playerName.equals(name)){
                            System.out.printf("This No has been occupied by: %s. Please re-enter the No: ", currentTeam.noOccupiedByWho(No));
                        } else {invalidNo = false;}
                    }
                    currentTeam.editPlayer(name,newName,credit,age,No,teamName);
                    System.out.println("Player information updated.");
                    sc.nextLine();
                    break;
                case "4":
                    System.out.print("Please enter the player's name: ");
                    name = sc.nextLine();
                    if(!(currentTeam.doesPlayerNameExist(name))){
                        System.out.println("Player does not exist.");
                        break;
                    }
                    currentTeam.removePlayer(name);
                    System.out.println("Player deleted.");
                    break;
                default:
                    break;
            }
        }
    }

    public static void seasonPage(){
        boolean looping = true;
        while(looping) {
            System.out.print("Welcome to the season page! Please make a selection from the menu:\n" +
                    "1. Add a team to the round.\n" +
                    "2. Display the current round.\n" +
                    "3. Play games.\n" +
                    "4. Display the game result records.\n" +
                    "R. Return to previous menu.\n" +
                    "Enter a choice:");
            String choice = sc.nextLine();
            switch (choice) {
                case "R":
                    looping = false;
                    break;
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
            }
        }
    }
}
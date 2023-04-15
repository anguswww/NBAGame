package org.example;

import java.util.ArrayList;
public class Team {
    private String name;
    private Players players;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public double averageAge() {
        ArrayList<Player> playList = players.getPlayersList();
        double total = 0;
        for (Player element: playList){
            total += element.getAge();
        }
        if (playList.size() == 0){
            return 0.0;
        }
        return total / playList.size();
    }
    public double averageCredit() {
        ArrayList<Player> playList = players.getPlayersList();
        double total = 0;
        for (Player element: playList){
            total += element.getCredit();
        }
        if (playList.size() == 0){
            return 0.0;
        }
        return total / playList.size();
    }

    public String noOccupiedByWho(int i){
        ArrayList<Player> playList = players.getPlayersList();
        for (Player element: playList){
            if(element.getNo() == i){
                return element.getName();
            }
        }
        return "";
    }

    public Team(String name, Players players)
    {
        this.name = name;
        this.players = players;
    }
    public void printPlayers(){
        players.printPlayers();
    }
    public void printPlayersForTeamView(){
        players.printPlayersForTeamView();
    }
    public void editPlayer(String name, String newName, Double credit, Integer age, Integer no, String team){
        players.editPlayer(name, newName, credit, age, no, team);
    }
    public void addPlayer(Player player){
        players.addPlayer(player);
    }
    public void removePlayer(String name){
        players.removePlayer(name);
    }
    public boolean isNoUsed(int no){
        return players.isNoUsed(no);
    }
    public String toString()
    {
        return String.format(Utils.teamsFormat, name, players.getLength(), averageCredit(), averageAge());
    }
    public Players getByLevel(String league){
        return players.getByLevel(league);
    }
}
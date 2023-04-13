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
        return total / playList.size();
    }
    public double averageCredit() {
        ArrayList<Player> playList = players.getPlayersList();
        double total = 0;
        for (Player element: playList){
            total += element.getCredit();
        }
        return total / playList.size();
    }

    public Team(String name, Players players)
    {
        this.name = name;
        this.players = players;
    }

    public String toString()
    {
        return String.format(Utils.teamsFormat, name, players.getLength(), averageCredit(), averageAge());
    }

}

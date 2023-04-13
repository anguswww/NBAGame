package org.example;

import java.util.ArrayList;

public class Players {
    public ArrayList<Player> getPlayersList() {
        return Players;
    }

    private ArrayList<Player> Players;
    public Players()
    {
        Players = new ArrayList<Player>();
    }
    public void addPlayer(Player player)
    {
        Players.add(player);
    }
    public int getLength()
    {
        return Players.size();
    }
    public void printPlayers(){
        Utils.playerHeader();
        for (Player element: Players){
            System.out.print(element);
        }
        Utils.playerTableEnd();
    }

}
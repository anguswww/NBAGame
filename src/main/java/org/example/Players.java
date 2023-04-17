package org.example;

import java.util.ArrayList;
import java.util.Objects;

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
    public void editPlayer(String name, String newName, Double credit, Integer age, Integer no, String team){
        for (Player element: Players){
            if (Objects.equals(element.getName(), name)){
                element.setName(newName);
                element.setAge(age);
                element.setCredit(credit);
                element.setNo(no);
                element.setTeam(team);
                if (credit>=2000){
                    element.setLevel("All Star");
                }
                else if (credit>=1500){
                    element.setLevel("Core");
                }
                else if (credit>=1000){
                    element.setLevel("Common");
                }
                else {
                    element.setLevel("Edge");
                }
            }
        }
    }
    public Players getByLevel(String league){
        Players out = new Players();
        for (Player element: Players) {
            if (Objects.equals(element.getLevel(), league)){
                out.addPlayer(element);
            }
        }
        return out;
    }
    public boolean isNoUsed(int no){
        for (Player element: Players){
            if (Objects.equals(element.getNo(), no)){
                return true;
            }
        }
        return false;
    }
    public void removePlayer(String name)
    {
        for (Player element: Players){
            if (Objects.equals(element.getName(), name)){
                Players.remove(element);
                return;
            }
        }
    }
    public boolean doesPlayerNameExist(String name){
        for (Player element: Players){
            if (Objects.equals(element.getName().toLowerCase(), name.toLowerCase())){
                return true;
            }
        }
        return false;
    }
    public int getLength()
    {
        return Players.size();
    }
    public void printPlayers(){
        for (Player element: Players){
            System.out.print(element);
        }
    }
    public void printPlayersForTeamView(){
        for (Player element: Players){
            System.out.print(element.toStringForTeamView());
        }
    }

}
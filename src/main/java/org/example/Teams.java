package org.example;

import java.util.ArrayList;
public class Teams {
    public ArrayList<Team> teams;
    public Teams()
    {
        teams = new ArrayList<Team>();
    }
    public void addTeam(Team team){
        teams.add(team);
    }

    public void printTeams()
    {
        Utils.teamsHeader();
        for (Team element: teams){
            System.out.print(element);
        }
        Utils.teamTableEnd();
    }


}
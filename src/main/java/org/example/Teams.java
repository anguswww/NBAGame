package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Teams {
    public ArrayList<Team> teams;
    public Teams()
    {
        teams = new ArrayList<Team>();
    }
    public void addTeam(Team team){
        teams.add(team);
    }
    public void removeTeamIndex(int i){
        teams.remove(i);
    }

    public void printTeams()
    {
        Utils.teamsHeader();
        for (Team element: teams){
            System.out.print(element);
        }
        Utils.teamTableEnd();
    }
    public void printTeamPlayers()
    {
        Utils.DisplayPlayerFromAllTeamsHeader();
        for (Team element: teams){
            element.printPlayersForTeamView();
            Utils.DisplayPlayerFromAllTeamsEnd();
        }
    }

    public int getTeamIndexbyName(String teamName){
        for (int i=0;i<teams.size();i++){
            if (Objects.equals(teams.get(i).getName(), teamName)){
                return i;
            }
        }
        return -1;
    }

    public boolean printByLevel(String level){
        Players pl = new Players();
        Team levelTeam = new Team(level, pl);
        boolean exists = false;
        for (Team team: teams) {
            Players players = team.getByLevel(level);
            if(players.getLength()>0){
                exists = true;
            }
        }
        if(!exists){
            return false;
        }
        Utils.DisplayPlayerFromAllTeamsHeader();
        for (Team team: teams){
            Players players = team.getByLevel(level);
            levelTeam.setPlayers(players);
            levelTeam.printPlayersForTeamView();

        }
        Utils.DisplayPlayerFromAllTeamsEnd();
        return true;
    }

}
package org.example;
public class Player {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getNo() {
        return No;
    }

    public void setNo(Integer no) {
        No = no;
    }

    private String name;
    private Double credit;
    private String level;
    private Integer age;
    private String team;
    private Integer No;
    public Player(String name, Double credit, String level, Integer age, String team, Integer No)
    {
        this.name = name;
        this.credit = credit;
        this.level = level;
        this.age = age;
        this.team = team;
        this.No = No;
    }
    public String toString(){
        return String.format(Utils.PlayerFormat, name, credit, level, No, age);
    }
    public String toStringForTeamView(){
        return String.format(Utils.DisplayPlayerFromAllTeamsFormat, name, credit, level, age, No, team);
    }
}
package app.models;

public class Constituency{
    private int constituencyId;
    private String name;
    private long population;

    public Constituency(int constituencyId, String name, long population){
        this.constituencyId = constituencyId;
        this.name = name;
        this.population = population;
    }

    public Constituency(String name, long population){
        this.constituencyId = -1;
        this.name = name;
        this.population = population;
    }

    public Constituency(String name){
        this.name = name;
        this.constituencyId = -1;
        this.population = 0;
    }

    public long getPopulation(){
        return population;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return constituencyId;
    }
}

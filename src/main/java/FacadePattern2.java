import java.util.Arrays;
import java.util.List;

public class FacadePattern2 {
    public static void main(String[] args) {
        TeamFacade.footballersNames("Milano");
    }
}

class FootballTeam {
    String name;
    List<FootballPlayer> players;

    public FootballTeam(String name, List<FootballPlayer> players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FootballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<FootballPlayer> players) {
        this.players = players;
    }

    public void printPlayersNames() {
        for (FootballPlayer player : players){
            System.out.println(player.getName());
        }
    }
}

class FootballPlayer {
    private String name;
    private int age;
    private String country;

    public FootballPlayer(String name, String country, int age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void run() {
        System.out.printf("%s runs\n", name);
    }

    public void dribbling() {
        System.out.printf("%s does dribbling\n", name);
    }
}


class CrRonaldo extends FootballPlayer {
    public CrRonaldo() {
        super("Cristiano Ronaldo", "Portugal", 35);
    }

    @Override
    public void run() {
        System.out.println("Im very fast in corners");
    }

    @Override
    public void dribbling() {
        System.out.println("Im very good at dribbling through 2-3 players");
    }
}

class Messi extends FootballPlayer {
    public Messi() {
        super("Messi", "Argentina", 33);
    }

    @Override
    public void run() {
        System.out.println("Im very fast in middle");
    }

    @Override
    public void dribbling() {
        System.out.println("Im very good at dribbling through 5-8 players!");
    }
}

class TeamFacade {
    // creates 3 teams and print All footballers name

    public static void footballersNames(String teamName) {
        List<FootballPlayer> players1 = Arrays.asList(
                new FootballPlayer("Zlatan", "Sweden", 35) { // Anonymous class
                    @Override
                    public void run() {
                        System.out.println("Im very long and can jump to make goal!");
                    }

                    @Override
                    public void dribbling() {
                        System.out.println("I have big legs and can dribble easy!");
                    }
                },
                new CrRonaldo(),
                new Messi()
        );

        List<FootballPlayer> players2 = Arrays.asList(
                new FootballPlayer("Zidan", "France", 43),
                new FootballPlayer("Bartez", "France", 45),
                new FootballPlayer("Baggio", "Italy", 60)
        );

        List<FootballPlayer> players3 = Arrays.asList(
                new FootballPlayer("Sergio", "Spain", 34),
                new FootballPlayer("Bale", "United Kingdom", 30),
                new FootballPlayer("Marcelo", "Brazil", 32)
        );

        FootballTeam footballTeam1 = new FootballTeam("My first team", players1);
        FootballTeam footballTeam2 = new FootballTeam("My second team", players2);
        FootballTeam footballTeam3 = new FootballTeam("My third team", players3);

        if(teamName.equalsIgnoreCase("RealMadrid")){
            footballTeam1.printPlayersNames();
        } else if(teamName.equalsIgnoreCase("Milano")){
            footballTeam2.printPlayersNames();
        } else
            footballTeam3.printPlayersNames();
    }
}


import java.util.Arrays;
import java.util.List;

public class FacadePattern3 {
    public static void main(String[] args) {
        Team team1 = new Team("team1", "", Arrays.asList(
                new LarsFr(),
                new IanThorPed(),
                new Swimmer("Theresa", 42) {
                    @Override
                    public void swimStyle() {
                        System.out.println("im good at backStroke");
                    }
                },
                new Swimmer("Sara", 26) {
                    @Override
                    public void swimStyle() {
                        System.out.println("need to improve all swimstyles!");
                    }
                }));

        Team team2 = new Team("team2", "", Arrays.asList(
                new LarsFr(),
                new IanThorPed(),
                new Swimmer("Stefan", 60) {
                    @Override
                    public void swimStyle() {
                        System.out.println("I was a swim star a while ago!");
                    }
                }));


        TeamFacade3 teamFacade3 = new TeamFacade3(team1, team2);
        teamFacade3.printSwimmersNamesForTeam("team1");
        teamFacade3.printSwimmersNamesForTeam("team2");

        System.out.println(teamFacade3.teams);
    }
}

class Swimmer {
    String name;
    int age;

    public Swimmer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void swimStyle() {
        System.out.println(" ");
    }

    @Override
    public String toString() {
        return "Swimmer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class Team {
    String name;
    String train_place;
    List<Swimmer> swimmers;

    public Team(String name, String train_place, List<Swimmer> swimmers) {
        this.name = name;
        this.train_place = train_place;
        this.swimmers = swimmers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrain_place() {
        return train_place;
    }

    public void setTrain_place(String train_place) {
        this.train_place = train_place;
    }

    public List<Swimmer> getSwimmers() {
        return swimmers;
    }

    public void setSwimmers(List<Swimmer> swimmers) {
        this.swimmers = swimmers;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", train_place='" + train_place + '\'' +
                ", swimmers=" + swimmers +
                '}';
    }

}

class LarsFr extends Swimmer {

    public LarsFr() {
        super("LarsFrolander", 46);
    }

    @Override
    public void swimStyle() {
        System.out.println("Im good at Butterfly!");
    }
}

class IanThorPed extends Swimmer {

    public IanThorPed() {
        super("Ian", 37);
    }

    @Override
    public void swimStyle() {
        System.out.println("good in all styles!");
    }
}


class TeamFacade3 {

    public List<Team> teams;

    // varargs
    // var -> variable
    // args -> argument

    TeamFacade3(Team... teams) {
        this.teams = Arrays.asList(teams);
    }

    public void printSwimmersNamesForTeam(String teamName) {
        Team team = teams.stream().filter(t -> t.getName().equalsIgnoreCase(teamName)).findAny().orElseThrow(() -> new RuntimeException("No team found"));
        System.out.println("-------------------------------------------------------------------");
        for (Swimmer swimmer : team.getSwimmers()) {
            System.out.println(swimmer.getName());
        }
    }

}



















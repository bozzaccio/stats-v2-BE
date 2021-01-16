package stats.dto;

public class DriverDTO {

    private int id;
    private String url;
    private int number;
    private String code;
    private String name;
    private String surname;
    private String nationality;
    private ConstructorDTO team;
    private int raceSeasonWin;
    private int poleSeason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public ConstructorDTO getTeam() {
        return team;
    }

    public void setTeam(ConstructorDTO team) {
        this.team = team;
    }

    public int getRaceSeasonWin() {
        return raceSeasonWin;
    }

    public void setRaceSeasonWin(int raceSeasonWin) {
        this.raceSeasonWin = raceSeasonWin;
    }

    public int getPoleSeason() {
        return poleSeason;
    }

    public void setPoleSeason(int poleSeason) {
        this.poleSeason = poleSeason;
    }
}

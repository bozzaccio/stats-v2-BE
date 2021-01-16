package stats.dto;

public class ConstructorDTO {

    private int id;
    private String url;
    private String name;
    private String nationality;
    private DriverDTO firstDriver;
    private DriverDTO secondDriver;
    private Long raceSeasonWin;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public DriverDTO getFirstDriver() {
        return firstDriver;
    }

    public void setFirstDriver(DriverDTO firstDriver) {
        this.firstDriver = firstDriver;
    }

    public DriverDTO getSecondDriver() {
        return secondDriver;
    }

    public void setSecondDriver(DriverDTO secondDriver) {
        this.secondDriver = secondDriver;
    }

    public Long getRaceSeasonWin() {
        return raceSeasonWin;
    }

    public void setRaceSeasonWin(Long raceSeasonWin) {
        this.raceSeasonWin = raceSeasonWin;
    }
}

package stats.dto;

import java.util.Date;

public class RaceDTO {

    private int id;
    private String url;
    private String name;
    private Date date;
    private DriverDTO poleDriver;
    private DriverDTO winDriver;
    private ConstructorDTO winConstructor;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DriverDTO getPoleDriver() {
        return poleDriver;
    }

    public void setPoleDriver(DriverDTO poleDriver) {
        this.poleDriver = poleDriver;
    }

    public DriverDTO getWinDriver() {
        return winDriver;
    }

    public void setWinDriver(DriverDTO winDriver) {
        this.winDriver = winDriver;
    }

    public ConstructorDTO getWinConstructor() {
        return winConstructor;
    }

    public void setWinConstructor(ConstructorDTO winConstructor) {
        this.winConstructor = winConstructor;
    }
}

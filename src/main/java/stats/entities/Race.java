package stats.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RACES")
public class Race {

    @Id
    private int id;

    @Column(name = "URL")
    private String url;

    @Column(name = "RACE_NAME", nullable = false)
    private String name;

    @Column(name = "RACE_DATE", nullable = false)
    private Date date;

    @Column(name = "POLE_DRIVER_ID")
    private int poleDriverId;

    @Column(name = "WINNER_DRIVER_ID")
    private int winDriverId;

    @Column(name = "WINNER_CONSTRUCTOR_ID")
    private int winConstructorId;

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

    public int getPoleDriverId() {
        return poleDriverId;
    }

    public void setPoleDriverId(int poleDriverId) {
        this.poleDriverId = poleDriverId;
    }

    public int getWinDriverId() {
        return winDriverId;
    }

    public void setWinDriverId(int winDriverId) {
        this.winDriverId = winDriverId;
    }

    public int getWinConstructorId() {
        return winConstructorId;
    }

    public void setWinConstructorId(int winConstructorId) {
        this.winConstructorId = winConstructorId;
    }
}

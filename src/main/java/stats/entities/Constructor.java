package stats.entities;

import javax.persistence.*;

@Entity
@Table(name = "CONSTRUCTORS")
public class Constructor {

    @Id
    private int id;

    @Column(name = "URL")
    private String url;

    @Column(name = "CONSTRUCTOR_NAME", nullable = false)
    private String name;

    @Column(name = "CONSTRUCTOR_NATIONALITY", nullable = false)
    private String nationality;

    @Column(name = "CONSTRUCTOR_FIRST_DRIVER_ID")
    private int firstDriverId;

    @Column(name = "CONSTRUCTOR_SECOND_DRIVER_ID")
    private int secondDriverId;

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

    public int getFirstDriverId() {
        return firstDriverId;
    }

    public void setFirstDriverId(int firstDriverId) {
        this.firstDriverId = firstDriverId;
    }

    public int getSecondDriverId() {
        return secondDriverId;
    }

    public void setSecondDriverId(int secondDriverId) {
        this.secondDriverId = secondDriverId;
    }

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
}

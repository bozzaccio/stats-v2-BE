package stats.entities;

import javax.persistence.*;

@Entity
@Table(name = "DRIVERS")
public class Driver {

    @Id
    private int id;

    @Column(name = "URL")
    private String url;

    @Column(name = "DRIVER_NUMBER", nullable = false)
    private int number;

    @Column(name = "DRIVER_CODE", nullable = false)
    private String code;

    @Column(name = "DRIVER_NAME", nullable = false)
    private String name;

    @Column(name = "DRIVER_SURNAME", nullable = false)
    private String surname;

    @Column(name = "DRIVER_NATIONALITY", nullable = false)
    private String nationality;

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

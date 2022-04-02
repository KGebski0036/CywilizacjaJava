package pl.edu.ezse.Cywilizacja.Model;

import javax.persistence.*;

@Entity
@Table(name = "LevelsOfBuildingForUser")
public class LvlsOfBuildings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private Integer levelOfTownHall = 0;
    private Integer levelOfWell  = 0;
    private Integer levelOfFarm = 0;
    private Integer levelOfQuarry = 0;
    private Integer levelOfForesterHouse = 0;
    private Integer levelOfGoldMine = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLevelOfTownHall() {
        return levelOfTownHall;
    }

    public void setLevelOfTownHall(Integer levelOfTownHall) {
        this.levelOfTownHall = levelOfTownHall;
    }

    public Integer getLevelOfWell() {
        return levelOfWell;
    }

    public void setLevelOfWell(Integer levelOfWell) {
        this.levelOfWell = levelOfWell;
    }

    public Integer getLevelOfFarm() {
        return levelOfFarm;
    }

    public void setLevelOfFarm(Integer levelOfFarm) {
        this.levelOfFarm = levelOfFarm;
    }

    public Integer getLevelOfQuarry() {
        return levelOfQuarry;
    }

    public void setLevelOfQuarry(Integer levelOfQuarry) {
        this.levelOfQuarry = levelOfQuarry;
    }

    public Integer getLevelOfForesterHouse() {
        return levelOfForesterHouse;
    }

    public void setLevelOfForesterHouse(Integer levelOfForesterHouse) {
        this.levelOfForesterHouse = levelOfForesterHouse;
    }

    public Integer getLevelOfGoldMine() {
        return levelOfGoldMine;
    }

    public void setLevelOfGoldMine(Integer levelOfGoldMine) {
        this.levelOfGoldMine = levelOfGoldMine;
    }
}

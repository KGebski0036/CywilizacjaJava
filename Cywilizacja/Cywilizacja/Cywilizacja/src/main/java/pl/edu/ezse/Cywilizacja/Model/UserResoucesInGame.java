package pl.edu.ezse.Cywilizacja.Model;

import javax.persistence.*;

@Entity
@Table(name = "usersResourcesInGame")
public class UserResoucesInGame {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private User user;

    private Long water = 100L;
    private Long food = 100L;
    private Long wood = 0L;
    private Long stone = 0L;
    private Long gold = 0L;
    private Long citizens = 1L;

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

    public Long getWater() {
        return water;
    }

    public void setWater(Long water) {
        this.water = water;
    }

    public Long getFood() {
        return food;
    }

    public void setFood(Long food) {
        this.food = food;
    }

    public Long getWood() {
        return wood;
    }

    public void setWood(Long wood) {
        this.wood = wood;
    }

    public Long getStone() {
        return stone;
    }

    public void setStone(Long stone) {
        this.stone = stone;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public Long getCitizens() {
        return citizens;
    }

    public void setCitizens(Long citizens) {
        this.citizens = citizens;
    }
}

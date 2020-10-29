package com.kulishd.entity;


import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Exposition {
    private Long id;
    private String theme;
    private BigDecimal price;
    private LocalDate date;
    private List<Hall> halls = new ArrayList<>();
    private User author;
    private Integer countOfTickets;

    public Exposition() {
    }

    public Exposition(String theme, BigDecimal price, LocalDate date) {
        this.theme = theme;
        this.price = price;
        this.date = date;
    }

    public Integer getCountOfTickets() {
        return countOfTickets;
    }

    public void setCountOfTickets(Integer countOfTickets) {
        this.countOfTickets = countOfTickets;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setTheme(String text) {
        this.theme = text;
    }

    public String getTheme() {
        return theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }


    public boolean hasHall(Hall hall) {
        for (Hall expositionHall: getHalls()) {
            if (expositionHall.getId().equals(hall.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Exposition{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}

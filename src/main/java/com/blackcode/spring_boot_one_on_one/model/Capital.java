package com.blackcode.spring_boot_one_on_one.model;

import jakarta.persistence.*;

@Entity
@Table(name = "capitals")
public class Capital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long capital_id;

    private String capital_name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public Capital() {
    }

    public Capital(Long capital_id, String capital_name, Country country) {
        this.capital_id = capital_id;
        this.capital_name = capital_name;
        this.country = country;
    }

    public Long getCapital_id() {
        return capital_id;
    }

    public void setCapital_id(Long capital_id) {
        this.capital_id = capital_id;
    }

    public String getCapital_name() {
        return capital_name;
    }

    public void setCapital_name(String capital_name) {
        this.capital_name = capital_name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

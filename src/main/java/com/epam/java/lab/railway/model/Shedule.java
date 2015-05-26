package com.epam.java.lab.railway.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Shedule implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private Train trainId;
    private Station stations;

    public Shedule() {
    }

    public Shedule(Train trainId, Station stations) {
        this.trainId = trainId;
        this.stations = stations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Train getTrainId() {
        return trainId;
    }

    public void setTrainId(Train trainId) {
        this.trainId = trainId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Station getStations() {
        return stations;
    }

    public void setStations(Station stations) {
        this.stations = stations;
    }
}

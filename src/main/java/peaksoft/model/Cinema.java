package peaksoft.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

    @Data
    @Entity
    @Table(name = "cinemas")
    public class Cinema {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String address;
        @OneToMany(cascade = CascadeType.ALL,mappedBy = "cinema",fetch = FetchType.LAZY)
        private List<Room> rooms;

    }

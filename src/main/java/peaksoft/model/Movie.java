package peaksoft.model;

import jakarta.persistence.*;
import lombok.Data;
import peaksoft.enums.Genre;

import java.time.LocalDate;
import java.util.List;
    @Data
    @Entity
    @Table(name = "movies")
    public class Movie {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        @Enumerated(EnumType.STRING)
        private Genre genres;
        @Column(name = "create_date")
        private LocalDate createdDate;
        private String country;
        private String language;
        @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
        private List<Session> sessions;
    }


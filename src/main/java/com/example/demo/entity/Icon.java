package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "icons")
@Getter @Setter
public class Icon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private String id;

    @Column(name = "icon_name")
    private String iconName;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;
}

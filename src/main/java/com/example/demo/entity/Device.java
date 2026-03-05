package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "devices")
@Getter @Setter
public class Device {

    @Id
    private String id; // Itt is töröld a @GeneratedValue-t!

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL) // Egy eszköznek egy saját főmenüje van
    @JoinColumn(name = "menu_id")
    private Menu mainMenu;
}

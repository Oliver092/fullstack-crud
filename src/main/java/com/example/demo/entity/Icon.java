package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Icon {
    @Id
    private String id;
    private String iconName;

    @ManyToOne
    private Application application;
}

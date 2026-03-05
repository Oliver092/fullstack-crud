package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menus")
@Getter @Setter
public class Menu {

    @Id
    private String id;

    private String title;
    private String wallpaperName;
    private String themeName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_menu_id")
    private List<Menu> subMenus = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id")
    private List<Icon> icons = new ArrayList<>();
}

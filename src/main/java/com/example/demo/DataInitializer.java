package com.example.demo;

import com.example.demo.entity.Device;
import com.example.demo.entity.Menu;
import com.example.demo.entity.User;
import com.example.demo.repository.DeviceRepository;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.UserRepository;
import lombok.Getter;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    @Getter
    private final DeviceRepository deviceRepository;
    @Getter
    private final MenuRepository menuRepository;

    @Override
    public void run(String @NonNull ... args) {
        Menu main = new Menu();
        main.setTitle("Kezdőképernyő");
        main.setWallpaperName("Űrhajós háttér");
        main.setThemeName("Sötét mód");

        Menu gamesSubMenu = new Menu();
        gamesSubMenu.setTitle("Játékok");
        main.getSubMenus().add(gamesSubMenu);

        User me = new User();
        me.setName("A Te Neved");

        Device myPhone = new Device();
        myPhone.setName("Saját Mobil");
        myPhone.setUser(me);
        myPhone.setMainMenu(main);

        me.getDevices().add(myPhone);

        userRepository.save(me);

        System.out.println("--- Sikeresen mentve: " + me.getName() + " és a 'Saját Mobil' eszköze. ---");
    }

}
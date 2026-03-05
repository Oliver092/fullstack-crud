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
    public void run(String @NonNull ... args) throws Exception {
        // 1. Főmenü létrehozása
        Menu main = new Menu();
        main.setId("menu-main-01");
        main.setTitle("Kezdőképernyő");
        main.setWallpaperName("Űrhajós háttér");
        main.setThemeName("Sötét mód");

        // 2. Egy almenü (például Játékok)
        Menu gamesSubMenu = new Menu();
        gamesSubMenu.setId("menu-games-01");
        gamesSubMenu.setTitle("Játékok");
        main.getSubMenus().add(gamesSubMenu);

        // 3. Felhasználó (TE) létrehozása
        User me = new User();
        me.setId("user-junior-01");
        me.setName("A Te Neved"); // Írd be a nevedet!

        // 4. Eszköz létrehozása és a menü hozzárendelése
        Device myPhone = new Device();
        myPhone.setId("dev-phone-01");
        myPhone.setName("Saját Mobil");
        myPhone.setUser(me);
        myPhone.setMainMenu(main);

        me.getDevices().add(myPhone);

        // 5. MENTÉS (A CascadeType.ALL miatt a User mentése menti a Device-t és a Menu-t is!)
        userRepository.save(me);

        System.out.println("--- Sikeresen mentve: " + me.getName() + " és a 'Saját Mobil' eszköze. ---");
    }

}
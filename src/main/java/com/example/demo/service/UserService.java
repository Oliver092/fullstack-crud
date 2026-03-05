package com.example.demo.service;

import com.example.demo.entity.Device;
import com.example.demo.entity.Icon;
import com.example.demo.entity.Menu;
import com.example.demo.entity.User;
import com.example.demo.model.UserRegistrationForm;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User registerFullUser(UserRegistrationForm form) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(form.getUserName());

        Menu menu = new Menu();
        menu.setId(UUID.randomUUID().toString());
        menu.setTitle(form.getMenuTitle());
        menu.setWallpaperName(form.getWallpaperName());

        Device device = new Device();
        device.setId(UUID.randomUUID().toString());
        device.setName(form.getDeviceName());
        device.setUser(user);
        device.setMainMenu(menu);

        user.getDevices().add(device);
        return userRepository.save(user);
    }

    public List<User> searchUsers(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return userRepository.findByNameContainingIgnoreCase(keyword);
        }
        return userRepository.findAll();
    }

    @Transactional // Fontos, mert több entitást mentünk egyszerre!
    public void simulateNewUser() {
        User mom = new User();
        mom.setId(UUID.randomUUID().toString());
        mom.setName("Édesanya");

        Menu momMenu = new Menu();
        momMenu.setId(UUID.randomUUID().toString());
        momMenu.setTitle("Anyu Menüje");
        momMenu.setWallpaperName("Családi fotó");

        Device momPhone = new Device();
        momPhone.setId(UUID.randomUUID().toString());
        momPhone.setName("Mom's iPhone");
        momPhone.setUser(mom);
        momPhone.setMainMenu(momMenu);

        Icon snakeIcon = new Icon();
        snakeIcon.setId(UUID.randomUUID().toString());
        snakeIcon.setIconName("Snake Játék");

        momMenu.getIcons().add(snakeIcon);
        mom.getDevices().add(momPhone);

        userRepository.save(mom);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void addIconToDevice(String userId, String iconName) {
        User user = userRepository.findById(userId).orElseThrow();
        // Veszünk egy eszközt a felhasználótól
        if (!user.getDevices().isEmpty()) {
            Icon newIcon = new Icon();
            newIcon.setId(UUID.randomUUID().toString());
            newIcon.setIconName(iconName);
            user.getDevices().get(0).getMainMenu().getIcons().add(newIcon);
            userRepository.save(user);
        }
    }
}
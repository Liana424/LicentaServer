package ubb.licenta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubb.licenta.entity.User;
import ubb.licenta.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Integer insert(User user) {
        User savedUser = userRepository.save(user);

        return savedUser.getId();
    }

    public User findByUsername(String username) {
        // aici folosim query-ul nostru custom
        Optional<User> user = userRepository.findByUsername(username);

        // e bine sa verificam ca exista si sa prindem exceptiile care pot sa apara daca cumva ii empty
        if (user.isEmpty()) {
            throw new EntityNotFoundException("Utilizatorul  cu username-ul = " + username + " nu a fost gasit!");
        }

        // cu .get() returnam obiectul "ascuns" in Optional
        return user.get();
    }

    public User findById(Integer id) {
        // findById returneaza un Optional, de aceea avem Optional aici
        Optional<User> user = userRepository.findById(id);

        // e bine sa verificam ca exista si sa prindem exceptiile care pot sa apara daca cumva ii empty
        if (user.isEmpty()) {
            throw new EntityNotFoundException("Utilizatorul cu id = " + id + " nu a fost gasit!");
        }

        // cu .get() returnam obiectul "ascuns" in Optional
        return user.get();
    }

    public List<User> findAll() {
        // findById returneaza un Optional, de aceea avem Optional aici
        return userRepository.findAll();

    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public User update(User user) {
        Optional<User> oldUser = userRepository.findById(user.getId());

        if (oldUser.isEmpty()) {
            return null;
        }

        return userRepository.save(user);
    }

    @Transactional
    public User loadCurrentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(name).orElseThrow(EntityNotFoundException::new);
    }
}

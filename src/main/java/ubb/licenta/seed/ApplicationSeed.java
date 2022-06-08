 package ubb.licenta.seed;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ubb.licenta.entity.User;
import ubb.licenta.repository.UserRepository;


@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationSeed implements CommandLineRunner {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) {
        if(userRepository.findAll().size() == 0) {
            User user = new User();
            user.setUsername("liana");
            user.setPassword(passwordEncoder.encode("liana"));
            user.setAddress("");
            user.setEmail("");
            user.setSurname("");
            user.setName("");

            userRepository.save(user);
        }
    }

}

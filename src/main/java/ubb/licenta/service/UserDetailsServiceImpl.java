//package ubb.licenta.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import ubb.licenta.entity.User;
//import ubb.licenta.repository.UserRepository;
//import ubb.licenta.util.CustomPasswordEncoder;
//
//import java.util.Optional;
//
//import static jdk.internal.net.http.common.Utils.encode;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<User> userOpt = userRepo.findByUsername(username);
//
//        return userOpt.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
//    }
//}

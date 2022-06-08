//package ubb.licenta.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.method.P;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ubb.licenta.dto.AuthCredentialsRequest;
//import ubb.licenta.entity.User;
//
//@RestController
//@RequestMapping("/api/auth")
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//
//
//    @PostMapping("login")
//    public ResponseEntity<?> login (@RequestBody AuthCredentialsRequest request){
//        try {
//            Authentication authenticate = authenticationManager.authenticate(
//                            new UsernamePasswordAuthenticationToken(
//                                    request.getUsername(), request.getPassword()
//                            )
//                    );
//            User user = (User) authenticate.getPrincipal();
//            user.setPassword(null);
//            return  ResponseEntity.ok()
//                    .header(
//                            HttpHeaders.AUTHORIZATION,
//                            jwtUtil.generateToken(user)
//                    )
//                    .body(user);
//        } catch (BadCredentialsException ex) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//    }
//}

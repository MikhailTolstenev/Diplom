package ru.netology.JavaDiplom.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ru.netology.JavaDiplom.dto.UserDTO;
import ru.netology.JavaDiplom.entity.User;
import ru.netology.JavaDiplom.exeption.AppError;
import ru.netology.JavaDiplom.service.JwtTokenUtils;
import ru.netology.JavaDiplom.service.UserService;

@Controller
@AllArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/login")

    public ResponseEntity<?> createAuthToken (UserDTO user){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(),user.getPassword()));
        } catch (BadCredentialsException e){
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(),
                    "некорретный логин или пароль"),HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(user.getLogin());
        String token = jwtTokenUtils.generateUser(userDetails);

        return ResponseEntity.ok(token);
    }

}

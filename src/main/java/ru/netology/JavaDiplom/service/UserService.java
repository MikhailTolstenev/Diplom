package ru.netology.JavaDiplom.service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.netology.JavaDiplom.entity.User;
import ru.netology.JavaDiplom.repository.UserRepository;

import java.beans.Transient;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private UserRepository userRepository;


    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }


    @Override
    @Transient
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<User> userRes = userRepository.findByLogin(login);

        if (userRes.isEmpty()) {
            throw new UsernameNotFoundException("User with username: " + userRes + " not found");
        }

        User user = userRes.get();
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
        );

    }


}
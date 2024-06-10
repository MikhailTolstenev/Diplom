package ru.netology.JavaDiplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.JavaDiplom.entity.User;

import java.util.Optional;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByLogin(String login);
}

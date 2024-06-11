package ru.netology.JavaDiplom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.netology.JavaDiplom.entity.User;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    Optional<User> findByLogin(String login);
}

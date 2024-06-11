package ru.netology.JavaDiplom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Entity
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "Users")

    public class User {
        @Id
        @GeneratedValue
        private int id;

        @Column(name = "login")
        private String login;

        @Column(name = "password")
        private String password;
        @Column(name = "role")
        private String role;


//        @ManyToOne(optional = false)
//        private List<File> files;


    }


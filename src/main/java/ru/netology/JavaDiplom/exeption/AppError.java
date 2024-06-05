package ru.netology.JavaDiplom.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppError {
    private int status;
    private String message;

}
package ru.netology.JavaDiplom.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppError extends Throwable {
    private int status;
    private String message;

}
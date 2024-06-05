package ru.netology.JavaDiplom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {

    private int id;

    private byte[] data;

    private String fileName;

    private String fileSize;
}
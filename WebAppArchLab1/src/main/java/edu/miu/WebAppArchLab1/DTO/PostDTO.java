package edu.miu.WebAppArchLab1.DTO;

import lombok.Data;

@Data
public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private String author;
}

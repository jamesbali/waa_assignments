package edu.miu.WebAppArchLab.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private String author;
    private List<CommentDTO> comments;
}

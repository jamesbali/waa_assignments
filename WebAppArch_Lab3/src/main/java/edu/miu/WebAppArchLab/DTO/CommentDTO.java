package edu.miu.WebAppArchLab.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private Long id;
    private String name;
   // private PostDTO post;
}

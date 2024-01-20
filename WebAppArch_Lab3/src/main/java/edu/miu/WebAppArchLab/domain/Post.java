package edu.miu.WebAppArchLab.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;


}

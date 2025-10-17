package com.growandshine.SocialMedia.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private String title;

    private String description;

    private long likes=0;
}

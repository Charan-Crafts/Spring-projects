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
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  profileId;

    private String about;

    private long followers=0;

    private long posts=0;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

}

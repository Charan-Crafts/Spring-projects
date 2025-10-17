package com.growandshine.SocialMedia.DTO.PostDTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {

    private String title;

    private String description;
}

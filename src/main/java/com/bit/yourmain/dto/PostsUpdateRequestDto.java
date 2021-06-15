package com.bit.yourmain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

}

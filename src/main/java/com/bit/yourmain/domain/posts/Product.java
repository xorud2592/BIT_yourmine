package com.bit.yourmain.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name = "product_sq",
        sequenceName = "product_sq",
        initialValue = 1,
        allocationSize =1)
public class Product extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 45, nullable = false)
    private String price;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition= "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Product(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
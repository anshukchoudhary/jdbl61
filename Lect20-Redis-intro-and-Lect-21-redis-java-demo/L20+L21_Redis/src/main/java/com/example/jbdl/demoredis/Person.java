package com.example.jbdl.demoredis;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable {

    @Positive
    private int id;

    @NotBlank
    private String name;

    private int age;
    private double creditScore;
}

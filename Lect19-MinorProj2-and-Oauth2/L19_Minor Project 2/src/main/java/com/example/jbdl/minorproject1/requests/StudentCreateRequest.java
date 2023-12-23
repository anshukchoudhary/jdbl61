package com.example.jbdl.minorproject1.requests;

import com.example.jbdl.minorproject1.models.Student;
import com.example.jbdl.minorproject1.security.User;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateRequest {

    @Positive
    private int age;

    @NotBlank
    private String name;

    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 14)
    private String password;

    public Student to(){
        return Student.builder()
                .name(name)
                .age(age)
                .email(email)
                .phoneNumber(phoneNumber)
                .user(
                        User.builder()
                                .username(this.email)
                                .password(this.password)
                                .build()
                )
                .build();
    }
}

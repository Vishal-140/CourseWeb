package com.example.CourseWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer courseId;

    @NotBlank(message = "Course name cannot be blank")
    @Column(nullable = false)
    String courseName;

    @NotBlank(message = "Course Description cannot be blank")
    @Column(nullable = false)
    String courseDescription;

    String tags;

    @Min(1)
    @Max(2000)
    Integer duration;

    @PastOrPresent
    @Column(nullable = false)
    LocalDate listedOn;

    @Min(0)
    @Max(200000)
    @Column(nullable = false)
    Double price;

}

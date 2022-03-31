package io.github.mhmuftee.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long id;

    private String courseNo;
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "education_id")
    private Education education;

}

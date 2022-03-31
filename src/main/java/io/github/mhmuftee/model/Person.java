package io.github.mhmuftee.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    @Column(name = "github")
    private String githubURL;

    @Column(name = "linkedin")
    private String linkedinURL;

    private String profession;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Collection<Education> educations;
}

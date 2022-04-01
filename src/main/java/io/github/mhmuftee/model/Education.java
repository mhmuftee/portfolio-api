package io.github.mhmuftee.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "education")
public class Education {
    @Id
    @Column(name = "education_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String degreeName;
    private String subject;
    private String startTime;
    private String endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(mappedBy = "education", cascade = CascadeType.ALL)
    private Collection<Course> courses;
}

package io.github.mhmuftee.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "experience")
public class Experience {
    @Id
    @Column(name = "experience_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;
    private String details;
    private String startTime;
    private String endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
}

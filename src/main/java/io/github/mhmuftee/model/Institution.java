package io.github.mhmuftee.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@ToString
@Setter
@Getter
@Entity
@Accessors(chain = true)
@Table(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institution_id")
    private Long id;

    private String name;
    private String url;
    private String location;
    private String country;

    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
    private Collection<Education> educations;

}

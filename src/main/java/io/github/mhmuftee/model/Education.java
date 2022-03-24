package io.github.mhmuftee.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Education {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String institutionName;
    private String degreeName;
    private Date startTime;
    private Date endTime;
}

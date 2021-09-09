package spring.bootcamp.week4.model;

/**
 * @author Nejla Sahin
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.bootcamp.week4.model.abstracts.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Represents an App Error inherited from BaseEntity class.
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exception_loggers")
public class ExceptionLogger{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status")
    private int status;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private LocalDate date;
}

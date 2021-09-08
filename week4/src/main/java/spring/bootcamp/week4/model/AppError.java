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

/**
 * Represents an App Error inherited from BaseEntity class.
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_error_response")
public class AppError extends BaseEntity {

    @Column(name = "status")
    private int status;

    @Column(name = "message")
    private String message;

    @Column(name = "timestamp")
    private long timestamp;
}

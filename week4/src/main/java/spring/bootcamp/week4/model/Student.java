package spring.bootcamp.week4.model;

/**
 * @author Nejla Sahin
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.bootcamp.week4.enums.Gender;
import spring.bootcamp.week4.model.abstracts.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Student inherited from BaseEntity class.
 * A Student can be enrolled in many courses.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "age")
    private int age;

    @ManyToMany
    @JoinTable(
            name = "course_students",
            joinColumns = @JoinColumn(name = "course_id"),
            foreignKey = @ForeignKey(name = "fk_course"),
            inverseJoinColumns = @JoinColumn(name = "student_id"),
            inverseForeignKey = @ForeignKey(name = "fk_student")
    )
    private Set<Course> courses = new HashSet<>();
}

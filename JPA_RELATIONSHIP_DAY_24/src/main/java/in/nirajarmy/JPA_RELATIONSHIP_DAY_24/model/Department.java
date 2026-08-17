package in.nirajarmy.JPA_RELATIONSHIP_DAY_24.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany(
//            mappedBy = "department",
//            cascade = CascadeType.REMOVE
//    )
//    private List<Student> students = new ArrayList<>();
}

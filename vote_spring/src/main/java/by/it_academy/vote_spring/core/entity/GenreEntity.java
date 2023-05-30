package by.it_academy.vote_spring.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "genres", schema = "app")
public class GenreEntity {
    @Id
    @GeneratedValue(generator = "genre_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name ="genre_seq",sequenceName = "genres_id_seq",schema = "app",allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;

    public GenreEntity(String name) {
        this.name = name;
    }

    public GenreEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreEntity() {
    }

    public GenreEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreEntity that = (GenreEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

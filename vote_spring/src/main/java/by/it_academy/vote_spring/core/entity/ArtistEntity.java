package by.it_academy.vote_spring.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "artists", schema = "app")
public class ArtistEntity {
    @Id
    @GeneratedValue(generator = "artist_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name ="artist_seq",sequenceName = "artists_id_seq",schema = "app",allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;

    public ArtistEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistEntity(Long id) {
        this.id = id;
    }
    public ArtistEntity(String name) {
        this.name = name;
    }

    public ArtistEntity() {
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
        ArtistEntity that = (ArtistEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

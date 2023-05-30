package by.it_academy.vote_spring.core.dto;

import by.it_academy.vote_spring.core.entity.GenreEntity;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Objects;

public class GenreDTO {
    private long id;
    private String name;

    public GenreDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreDTO(String name) {
        this.name = name;
    }

    public GenreDTO(GenreEntity genreEntity) {
        this.id = genreEntity.getId();
        this.name = genreEntity.getName();
    }

    public GenreDTO() {
    }

    @JsonGetter
    public long getId() {
        return id;
    }

    @JsonSetter
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("genreTitle")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreDTO genreDTO = (GenreDTO) o;
        return Objects.equals(id, genreDTO.id) && Objects.equals(name, genreDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "GenreDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

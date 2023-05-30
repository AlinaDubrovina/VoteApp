package by.it_academy.vote_spring.core.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Objects;

public class ArtistDTO {
    private long id;
    private String name;

    public ArtistDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistDTO(String name) {
        this.name = name;
    }

    public ArtistDTO(){}

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

    @JsonProperty(value = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistDTO artistDTO = (ArtistDTO) o;
        return Objects.equals(id, artistDTO.id) && Objects.equals(name, artistDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ArtistDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

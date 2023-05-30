package by.it_academy.vote_spring.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class VoteDTO {
    private long artistId;
    private List<Long> genreIds;
    private String about;
    private LocalDateTime dtCreate;

    @JsonCreator
    public VoteDTO(@JsonProperty("artistId") long artistId,
                   @JsonProperty("genreIds") List<Long> genreIds,
                   @JsonProperty("about") String about) {
        this.artistId = artistId;
        this.genreIds = genreIds;
        this.about = about;
        this.dtCreate = LocalDateTime.now();
    }

    public VoteDTO() {
    }
    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public void setGenreIds(List<Long> genreIds) {
        this.genreIds = genreIds;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public long getArtistId() {
        return artistId;
    }

    public List<Long> getGenreIds() {
        return Collections.unmodifiableList(genreIds);
    }

    public String getAbout() {
        return about;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    @JsonSerialize
    @JsonSetter
    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                ", artistId=" + artistId +
                ", genreIds=" + genreIds +
                ", about='" + about + '\'' +
                '}';
    }
}

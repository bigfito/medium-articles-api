package cloud.bigfito.mediumarticles.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link cloud.bigfito.mediumarticles.entity.Article}
 */
public class ArticleDTO implements Serializable {
    @NotNull
    @NotEmpty
    @NotBlank
    @URL
    private final String url;
    @NotNull
    @NotEmpty
    @NotBlank
    private final String title;
    @NotNull
    @NotEmpty
    @NotBlank
    private final String subtitle;
    @NotNull
    @NotEmpty
    @NotBlank
    private final String firstPara;
    @NotNull
    @Size(max = 20)
    @NotEmpty
    @NotBlank
    private final String image;
    @NotNull
    @PositiveOrZero
    private final Double claps;
    @NotNull
    @PositiveOrZero
    private final Double responses;
    @NotNull
    @PositiveOrZero
    private final Double readingTime;
    @NotNull
    @Size(max = 150)
    @NotEmpty
    @NotBlank
    private final String publication;
    @NotNull
    private final LocalDate date;



    public ArticleDTO(String url, String title, String subtitle, String firstPara, String image, Double claps, Double responses, Double readingTime, String publication, LocalDate date) {
        this.url = url;
        this.title = title;
        this.subtitle = subtitle;
        this.firstPara = firstPara;
        this.image = image;
        this.claps = claps;
        this.responses = responses;
        this.readingTime = readingTime;
        this.publication = publication;
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getFirstPara() {
        return firstPara;
    }

    public String getImage() {
        return image;
    }

    public Double getClaps() {
        return claps;
    }

    public Double getResponses() {
        return responses;
    }

    public Double getReadingTime() {
        return readingTime;
    }

    public String getPublication() {
        return publication;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleDTO entity = (ArticleDTO) o;
        return Objects.equals(this.url, entity.url) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.subtitle, entity.subtitle) &&
                Objects.equals(this.firstPara, entity.firstPara) &&
                Objects.equals(this.image, entity.image) &&
                Objects.equals(this.claps, entity.claps) &&
                Objects.equals(this.responses, entity.responses) &&
                Objects.equals(this.readingTime, entity.readingTime) &&
                Objects.equals(this.publication, entity.publication) &&
                Objects.equals(this.date, entity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, title, subtitle, firstPara, image, claps, responses, readingTime, publication, date);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "url = " + url + ", " +
                "title = " + title + ", " +
                "subtitle = " + subtitle + ", " +
                "firstPara = " + firstPara + ", " +
                "image = " + image + ", " +
                "claps = " + claps + ", " +
                "responses = " + responses + ", " +
                "readingTime = " + readingTime + ", " +
                "publication = " + publication + ", " +
                "date = " + date + ")";
    }
}
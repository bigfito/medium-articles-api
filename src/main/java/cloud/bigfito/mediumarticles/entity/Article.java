package cloud.bigfito.mediumarticles.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @ColumnDefault("nextval('articles_id_article_seq'")
    @Column(name = "id_article", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive(message = "The ID parameter must be a positive number of type LONG.")
    private Long id;

    @Column(name = "url", length = Integer.MAX_VALUE)
    @NotNull(message = "The URL parameter cannot be NULL.")
    @NotBlank(message = "The URL parameter cannot be BLANK.")
    @NotEmpty(message = "The URL parameter cannot be EMPTY.")
    private String url;

    @Column(name = "title", length = Integer.MAX_VALUE)
    @NotNull(message = "The TITLE parameter cannot be NULL.")
    @NotBlank(message = "The TITLE parameter cannot be BLANK.")
    @NotEmpty(message = "The TITLE parameter cannot be EMPTY.")
    private String title;

    @Column(name = "subtitle", length = Integer.MAX_VALUE)
    @NotNull(message = "The SUBTITLE parameter cannot be NULL.")
    @NotBlank(message = "The SUBTITLE parameter cannot be BLANK.")
    @NotEmpty(message = "The SUBTITLE parameter cannot be EMPTY.")
    private String subtitle;

    @Column(name = "first_para", length = Integer.MAX_VALUE)
    @NotNull(message = "The FIRST PARAGRAPH parameter cannot be NULL.")
    @NotBlank(message = "The FIRST PARAGRAPH parameter cannot be BLANK.")
    @NotEmpty(message = "The FIRST PARAGRAPH parameter cannot be EMPTY.")
    private String firstPara;

    @Size(max = 20)
    @Column(name = "image", length = 20)
    @NotNull(message = "The IMAGE parameter cannot be NULL.")
    @NotBlank(message = "The IMAGE parameter cannot be BLANK.")
    @NotEmpty(message = "The IMAGE parameter cannot be EMPTY.")
    private String image;

    @Column(name = "claps")
    @NotNull(message = "The CLAPS parameter cannot be NULL.")
    @Positive(message = "The CLAPS parameter must be a positive number of type LONG.")
    private Double claps;

    @Column(name = "responses")
    @NotNull(message = "The RESPONSES parameter cannot be NULL.")
    @Positive(message = "The RESPONSES parameter must be a positive number of type LONG.")
    private Double responses;

    @Column(name = "reading_time")
    @NotNull(message = "The READING TIME parameter cannot be NULL.")
    @Positive(message = "The READING TIME parameter must be a positive number of type LONG.")
    private Double readingTime;

    @Size(max = 150)
    @Column(name = "publication", length = 150)
    @NotNull(message = "The PUBLICATION parameter cannot be NULL.")
    @NotBlank(message = "The PUBLICATION parameter cannot be BLANK.")
    @NotEmpty(message = "The PUBLICATION parameter cannot be EMPTY.")
    private String publication;

    @Column(name = "date")
    @NotNull(message = "The DATE parameter cannot be NULL.")
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getFirstPara() {
        return firstPara;
    }

    public void setFirstPara(String firstPara) {
        this.firstPara = firstPara;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getClaps() {
        return claps;
    }

    public void setClaps(Double claps) {
        this.claps = claps;
    }

    public Double getResponses() {
        return responses;
    }

    public void setResponses(Double responses) {
        this.responses = responses;
    }

    public Double getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(Double readingTime) {
        this.readingTime = readingTime;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
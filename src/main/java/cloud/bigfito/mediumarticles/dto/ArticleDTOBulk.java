package cloud.bigfito.mediumarticles.dto;

import java.util.Objects;

public class ArticleDTOBulk {

    private ArticleDTO articleDTO;
    private Integer bulkStatus;

    public ArticleDTOBulk() {
    }

    public ArticleDTOBulk(ArticleDTO articleDTO, Integer bulkStatus) {
        this.articleDTO = articleDTO;
        this.bulkStatus = bulkStatus;
    }

    public ArticleDTO getArticleDTO() {
        return articleDTO;
    }

    public void setArticleDTO(ArticleDTO articleDTO) {
        this.articleDTO = articleDTO;
    }

    public Integer getBulkStatus() {
        return bulkStatus;
    }

    public void setBulkStatus(Integer bulkStatus) {
        this.bulkStatus = bulkStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleDTOBulk that = (ArticleDTOBulk) o;
        return Objects.equals(articleDTO, that.articleDTO) && Objects.equals(bulkStatus, that.bulkStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleDTO, bulkStatus);
    }

    @Override
    public String toString() {
        return "ArticleDTOBulk{" +
                "articleDTO=" + articleDTO +
                ", bulkStatus=" + bulkStatus +
                '}';
    }
}

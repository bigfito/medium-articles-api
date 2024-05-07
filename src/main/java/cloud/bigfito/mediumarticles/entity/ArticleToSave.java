package cloud.bigfito.mediumarticles.entity;

public class ArticleToSave {

    private Article articleToSave;
    private boolean present;

    public ArticleToSave() {
    }

    public ArticleToSave(Article articleToSave, boolean present) {
        this.articleToSave = articleToSave;
        this.present = present;
    }

    public Article getArticleToSave() {
        return articleToSave;
    }

    public void setArticleToSave(Article articleToSave) {
        this.articleToSave = articleToSave;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return "ArticleToSave{" +
                "articleToSave=" + articleToSave +
                ", present=" + present +
                '}';
    }
}

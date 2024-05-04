package cloud.bigfito.mediumarticles.entity;

public class SavedArticle {

    private Article article;
    private boolean saved;

    public SavedArticle() {
    }

    public SavedArticle(Article article, boolean saved) {
        this.article = article;
        this.saved = saved;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    @Override
    public String toString() {
        return "SavedArticle{" +
                "article=" + article +
                ", wasSaved=" + saved +
                '}';
    }
}

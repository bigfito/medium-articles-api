package cloud.bigfito.mediumarticles.exception.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomExceptionEntity {

    private Date timestamp;
    private int status;
    private String path;
    private List<String> description;

    public CustomExceptionEntity(Date timestamp, int status, String path, List<String> description) {

        description = new ArrayList<>();

        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public void addExceptionMessage(String errorMessage){
        this.description.add(errorMessage);
    }
}

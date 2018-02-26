package model;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Rating {
    private Integer rating;
    private String comment;

    public Rating() {
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

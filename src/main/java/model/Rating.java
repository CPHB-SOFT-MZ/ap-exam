package model;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Rating {
    private Double rating;
    private String comment;

    public Rating() {
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

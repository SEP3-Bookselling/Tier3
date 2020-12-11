package Tier3.DataServer.Models;

public class Rating
{
    String username;
    double rating;
    String otherUsername;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getOtherUsername() {
        return otherUsername;
    }

    public void setOtherUsername(String otherUsername) {
        this.otherUsername = otherUsername;
    }

    @Override
    public String toString() {
        return "{"
                + "\"username\":" + "\"" + getUsername() + "\","
                + "\"rating\":" + "\"" + getRating() + "\","
                + "\"otherUsername\":" + "\"" + getOtherUsername() + "\","
                + "}";
    }
}

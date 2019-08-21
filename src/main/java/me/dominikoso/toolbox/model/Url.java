package me.dominikoso.toolbox.model;

import javax.persistence.*;

@Entity
@Table(name="shortened_url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orginalUrl;
    private String shortenedUrl;
    private String owner;

    //region Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrginalUrl() {
        return orginalUrl;
    }

    public void setOrginalUrl(String orginalUrl) {
        this.orginalUrl = orginalUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    //endregion
}

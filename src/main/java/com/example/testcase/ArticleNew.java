package com.example.testcase;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.hateoas.Link;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Produces({MediaType.APPLICATION_HAL_JSON})
@Introspected
public class ArticleNew {

    @JsonProperty("title")
    @NotBlank
    private String articleTitle;

    @JsonProperty("_embedded")
    @NotBlank
    private Map<CharSequence, List<Comment>> embedded;

    @JsonProperty("_links")
    @NotBlank
    private Map<CharSequence, List<Link>> link;

    @NotNull
    private Date publicationDate;

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Map<CharSequence, List<Comment>> getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Map<CharSequence, List<Comment>> embedded) {
        this.embedded = embedded;
    }

    public Map<CharSequence, List<Link>> getLink() {
        return link;
    }

    public void setLink(Map<CharSequence, List<Link>> link) {
        this.link = link;
    }
}

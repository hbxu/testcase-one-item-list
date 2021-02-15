package com.example.testcase;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.runtime.Micronaut;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class Application {

    private static final CharSequence COMMENTS = "comments";

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @Get(uri = "/article/one", produces = MediaType.APPLICATION_HAL_JSON)
    public Article getArticleAndOneComment() {
        Article article = new Article();
        article.setArticleTitle("hello world");
        article.setPublicationDate(new Date());

        Comment commentByJane = new Comment();
        commentByJane.setAuthorFullName("Jane");

        article.embedded(COMMENTS, commentByJane);
        return article;
    }

    @Get(uri = "/articlenew/one", produces = MediaType.APPLICATION_HAL_JSON)
    public ArticleNew getArticleNewAndOneComment() {
        ArticleNew article = new ArticleNew();
        article.setArticleTitle("hello world");
        article.setPublicationDate(new Date());

        Comment commentByJane = new Comment();
        commentByJane.setAuthorFullName("Jane");

        article.setEmbedded(Map.of(COMMENTS, List.of(commentByJane)));
        return article;
    }

    @Get(uri = "article/two", produces = MediaType.APPLICATION_HAL_JSON)
    public Article getArticleAndTwoComments() {
        Article article = new Article();
        article.setArticleTitle("hello world");
        article.setPublicationDate(new Date());

        Comment commentByJane = new Comment();
        commentByJane.setAuthorFullName("Jane");
        Comment commentByJohn = new Comment();
        commentByJohn.setAuthorFullName("john");

        article.embedded(COMMENTS, List.of(commentByJane, commentByJohn));
        return article;
    }
}

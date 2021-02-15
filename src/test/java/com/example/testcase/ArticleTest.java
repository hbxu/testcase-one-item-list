package com.example.testcase;

import com.jayway.jsonpath.JsonPath;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxStreamingHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
class ArticleTest {

    @Inject
    @Client("/")
    RxStreamingHttpClient client;

    @Test
    public void testArticleOneItemListWithAbstractResource() {
        HttpRequest request = HttpRequest.GET("article/one");
        String response = client.toBlocking().retrieve(request);
        Map<String, List<Comment>> comments = JsonPath.read(response, "$._embedded.comments[0]");
        assertNotNull(comments.get("author"));
    }

    @Test
    public void testArticleTwoItemListWithAbstractResource() {
        HttpRequest request = HttpRequest.GET("article/two");
        String response = client.toBlocking().retrieve(request);
        Map<String, List<Comment>> comments = JsonPath.read(response, "$._embedded.comments[0]");
        assertNotNull(comments.get("author"));
    }

    @Test
    public void testArticleOneItemListWithoutAbstractResource() {
        HttpRequest request = HttpRequest.GET("articlenew/one");
        String response = client.toBlocking().retrieve(request);
        Map<String, List<Comment>> comments = JsonPath.read(response, "$._embedded.comments[0]");
        assertNotNull(comments.get("author"));
    }

}

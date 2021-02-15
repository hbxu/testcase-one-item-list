package com.example.testcase;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.hateoas.AbstractResource;

import javax.validation.constraints.NotBlank;

@Produces({MediaType.APPLICATION_HAL_JSON})
@Introspected
public class Comment extends AbstractResource<Comment> {

    @JsonProperty("author")
    @NotBlank
    private String authorFullName;

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
}

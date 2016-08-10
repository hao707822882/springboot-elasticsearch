package com.boom.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by mohsinhusen on 10/04/15.
 */
@Document(indexName = "lolll", type = "pice")
public class OperationDocument {

    @Id
    private Long id;

    @Field(
            type = FieldType.String,
            index = FieldIndex.not_analyzed,
            store = true
    )
    private String name;


    @Field(
            type = FieldType.String,
            index = FieldIndex.analyzed,
            searchAnalyzer = "ik",
            analyzer = "ik",
            store = true
    )
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "OperationDocument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}


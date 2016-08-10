package com.boom.dao;

import com.boom.es.OperationDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public interface OperationDocumentESDao extends ElasticsearchRepository<OperationDocument, Long> {
    List<OperationDocument> findByName(String name);

    List<OperationDocument> findByContentLike(String content);
}

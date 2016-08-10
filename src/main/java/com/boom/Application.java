package com.boom;

import com.boom.dao.OperationDocumentESDao;
import com.boom.es.OperationDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.boom.dao")
public class Application {

    private OperationDocumentESDao operationDocumentESDao;

    @Autowired
    public void setOperationDocumentESDao(OperationDocumentESDao operationDocumentESDao) {
        this.operationDocumentESDao = operationDocumentESDao;
        OperationDocument operationDocument = new OperationDocument();
        operationDocument.setContent("有一个博士分到一家研究所，成为学历最高的一个人。 　　　有一天他到单位后面的小池塘去钓鱼，正好正副所长在他的一左一右，也在钓鱼");
        operationDocument.setName("朱明明");
        operationDocumentESDao.save(operationDocument);
        OperationDocument operationDocument1 = new OperationDocument();
        operationDocument1.setContent("随着互联网和移动互联网的普及，互联网金融也日益进入人们的日常生活。当前互联网金融方兴未艾，各种新颖高效的金融产品层出不穷。随之而来的是日益激烈的竞争。");
        operationDocument1.setName("银行集中式业务系统");
        operationDocumentESDao.save(operationDocument1);
        Iterable<OperationDocument> all = operationDocumentESDao.findAll();
        for (OperationDocument  operation: all) {
            System.out.println(operation);
        }

        System.out.println("----");

        List<OperationDocument> list = operationDocumentESDao.findByName("朱明明");
        for (OperationDocument operation : list) {
            System.out.println(operation);
        }
        System.out.println("----");
        List<OperationDocument> list1 = operationDocumentESDao.findByContentLike("金融");
        for (OperationDocument operation : list1) {
            System.out.println(operation);
        }
    }

    public static void main(String[] args) throws IOException {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setWebEnvironment(false);
        springApplication.run(args);
        System.in.read();
    }
}

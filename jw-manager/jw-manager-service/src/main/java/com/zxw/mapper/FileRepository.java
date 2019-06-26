package com.zxw.mapper;

import document.ImpXls;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<ImpXls, String> {
}

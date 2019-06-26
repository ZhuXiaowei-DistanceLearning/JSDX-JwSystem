package com.zxw.client;

import api.ClassesApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "manager-service")
public interface ClassesClient extends ClassesApi {

}

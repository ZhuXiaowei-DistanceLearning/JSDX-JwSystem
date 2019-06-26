package com.zxw.client;

import api.StudentApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "manager-service")
public interface StudentClient extends StudentApi {
}

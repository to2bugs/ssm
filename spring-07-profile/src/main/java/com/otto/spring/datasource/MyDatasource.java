package com.otto.spring.datasource;

import lombok.Data;

@Data
public class MyDatasource {
    private String url;
    private String username;
    private String password;
    private String type;
}

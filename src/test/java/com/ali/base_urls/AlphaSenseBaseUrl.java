package com.ali.base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class AlphaSenseBaseUrl {
    protected RequestSpecification spec;

    @BeforeSuite
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://rc.alpha-sense.com/services/i/public-document-data/document/PR-386ea743f2a90399fb0e4300ddf37d0697abc743").build();
    }

}

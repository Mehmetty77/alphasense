package com.ali.base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class AdditionalSearchAlphaSenseDocumentPage {
    protected RequestSpecification spec;

    @BeforeClass
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("a").build();
    }

}

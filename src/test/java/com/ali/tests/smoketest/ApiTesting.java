package com.ali.tests.smoketest;

import com.ali.base_urls.AlphaSenseBaseUrl;
import com.ali.pojos.KeywordSearchPojo;
import com.ali.pojos.Statements;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApiTesting{
    Response response;
    //1.Step set the URL
    String endpoint = "https://rc.alpha-sense.com/services/i/public-document-data/document/PR-386ea743f2a90399fb0e4300ddf37d0697abc743/keyword-search/?keyword=AlphaSense&slop=15&positiveOnly=false&negativeOnly=false&released=1633003200000";
//   /keyword-search/?keyword=AlphaSense&slop=15&positiveOnly=false&negativeOnly=false&released=1633003200000
    KeywordSearchPojo actualData;
    List<Statements> statementsList;

    @BeforeClass
    public void setUp(){
//        spec.
//                pathParam("first", "keyword-search").
//                queryParam("keyword", "AlphaSense&slop=15&positiveOnly=false&negativeOnly=false&released=1633003200000");
        response =given()
                .when()
                .get(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract().
                response();

    }

    @Test(priority = 1,suiteName = "api")
    public void getTest(){

        //2. Step set the ecpected data

        //3.Step: Send the request and get the response
//        response =given()
//                .when()
//                .get(endpoint)
//                .then()
//                .contentType(ContentType.JSON)
//                .extract().
//                response();
//        response.prettyPrint();
//        AdditionalKeywordSearchResult actualData;

        //4.Step: Do assertions

//        ObjectMapper objmp = new ObjectMapper();
//        AdditionalKeywordSearchResult actualData = objmp.readValue(response.asString(), AdditionalKeywordSearchResult.class);
//        List<Statements> statementsList = actualData.getSearchResults().getStatements();
//        System.out.println(actualData.getSearchResults().getStatements().size());
        actualData = response.as(KeywordSearchPojo.class);
        System.out.println(actualData);
        statementsList = actualData.getSearchResults().getStatements();
//        System.out.println(actualData.getSearchResults().getStatements().size());

        //status code
        //data içeriği assert
        //Tüm contentlerin alfasense keywordu içerdiğini assert et

        assertEquals(200, response.getStatusCode());
//        statementsList.stream().forEach(t-> t.getContent().toLowerCase().contains("alphasense"));
        for (int i = 1; i < statementsList.size()-1; i++) {
            assertTrue(statementsList.get(i).getContent().toLowerCase().contains("alphasense"),
                    "statement "+i+" does not contain searched keyword");
            System.out.println(i);
        }
//        System.out.println("statementsList.size() = " + statementsList.size());

    }


    @Test(priority = 2,suiteName = "api")
    public void testStatements(){
        for (int i = 1; i < statementsList.size()-1; i++) {
            assertTrue(statementsList.get(i).getContent().toLowerCase().contains("alphasense"),
                    "statement "+i+" does not contain searched keyword");
            System.out.println(i);
        }

    }

    @Test(priority = 3,suiteName = "api")
    public void testLastStatement(){

//        statementsList.get(statementsList.size()-1).getContent().contains("Logo");
        assertEquals(statementsList.get(statementsList.size()-1).getContent(),"Logo - <span class='hl'>https://mma.prnewswire.com/media/947841/AlphaSense_Logo.jpg</span>");
    }
    @Test(priority = 4,suiteName = "api")
    public void dummyTest(){
        assertEquals(2,3);
    }
}

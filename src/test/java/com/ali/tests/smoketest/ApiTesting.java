package com.ali.tests.smoketest;

import com.ali.pojos.AdditionalKeywordSearchResult;
import com.ali.pojos.Statements;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ApiTesting {
    Response response;
    String endpoint = "https://rc.alpha-sense.com/services/i/public-document-data/document/PR-386ea743f2a90399fb0e4300ddf37d0697abc743/keyword-search/?keyword=AlphaSense&slop=15&positiveOnly=false&negativeOnly=false&released=1633003200000";

    @Test
    public void getTest() throws JsonProcessingException {
        response =given()
                .when()
                .get(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract().
                response();
        response.prettyPrint();
        AdditionalKeywordSearchResult actualData;

        ObjectMapper objmp = new ObjectMapper();
        actualData = objmp.readValue(response.asString(), AdditionalKeywordSearchResult.class);
        List<Statements> statementsList = actualData.getSearchResults().getStatements();
        System.out.println("actualData.getSearchResults().getStatements().get(statementsList.size()) = " + actualData.getSearchResults().getStatements().size());
//        AdditionalKeywordSearchResult actualData = response.as(AdditionalKeywordSearchResult.class);
//        System.out.println(actualData);
        //status code
        //data içeriği assert
        //Tüm contentlerin alfasense keywordu içerdiğini assert et

        assertEquals(1,1);
    }

    @Test
    public void dummyTest(){

        assertEquals(2,3);
    }
}

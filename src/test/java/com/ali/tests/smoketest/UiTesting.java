package com.ali.tests.smoketest;

import com.ali.pages.AlphaSenseDocumentPage;
import com.ali.utilities.ConfigReader;
import com.ali.utilities.Driver;
import com.ali.utilities.JSUtils;
import com.ali.utilities.ReusableMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static com.ali.utilities.Driver.js;
import static org.testng.Assert.*;

public class UiTesting {
    AlphaSenseDocumentPage alphaSenseDocumentPage;

    @BeforeClass
    public void setUp() {
        alphaSenseDocumentPage = new AlphaSenseDocumentPage();
        Driver.getDriver().get(ConfigReader.getProperty("alphasense-documentpage"));
//        Driver.getDriver().findElement(By.name("q")).sendKeys("alphasense");
    }

    @Test(priority = 0)
    public void test01() {

        ReusableMethods.waitForClickablility(alphaSenseDocumentPage.codeMirrorLine,5);
        alphaSenseDocumentPage.codeMirrorLine.click();
        JSUtils.highlightElement(alphaSenseDocumentPage.codeMirrorLine);
//        ReusableMethods.waitFor(1);
        assertEquals(alphaSenseDocumentPage.codeMirrorLine.getAttribute("class"),
                "CodeMirror cm-s-default CodeMirror-empty CodeMirror-focused");//"CodeMirror cm-s-default CodeMirror-empty","");
        alphaSenseDocumentPage.textarea.sendKeys("AlphaSense" + Keys.ENTER);
        alphaSenseDocumentPage.snippetItemList.get(0).click();
        JSUtils.highlightElement( alphaSenseDocumentPage.snippetItemList.get(0));
        assertFalse(alphaSenseDocumentPage.codeMirrorLine.getAttribute("class").contains("CodeMirror cm-s-default CodeMirror-empty CodeMirror-focused"));


    }

    @Test(priority = 2)
    public void test02(){
        ReusableMethods.pageDown(5);
        WebElement lastSnippet = alphaSenseDocumentPage.snippetItemList.get(alphaSenseDocumentPage.snippetItemList.size()-1);
        lastSnippet.click();
        JSUtils.highlightElement( lastSnippet);

        Driver.getDriver().switchTo().frame("content-1");
        JSUtils.highlightElement(alphaSenseDocumentPage.iframeContentList.get(alphaSenseDocumentPage.iframeContentList.size()-1));
        assertEquals(alphaSenseDocumentPage.logoStatement.getCssValue("background-color"),"rgba(255, 190, 0, 1)");
        assertEquals(alphaSenseDocumentPage.logoLink.getCssValue("background-color"),"rgba(255, 190, 0, 1)");


    }

    @AfterClass
    public void tearDown(){
        ReusableMethods.waitFor(4);
        Driver.closeDriver();
    }

}


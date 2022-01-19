package com.ali.tests.smoketest;

import com.ali.pages.AlphaSenseDocumentPage;
import com.ali.utilities.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class UiTesting{
    AlphaSenseDocumentPage alphaSenseDocumentPage;

    @BeforeClass
    public void setUp() {
        alphaSenseDocumentPage = new AlphaSenseDocumentPage();
        Driver.getDriver().get(ConfigReader.getProperty("alphasense-documentpage"));
        assertEquals(Driver.getDriver().getTitle(),"AlphaSense");
    }

    @Test(priority = 1)
    public void searchkeywordTest() {

        ReusableMethods.waitForClickablility(alphaSenseDocumentPage.codeMirrorLine,5);
        alphaSenseDocumentPage.codeMirrorLine.click();
        JSUtils.highlightElement(alphaSenseDocumentPage.codeMirrorLine);
        ReusableMethods.waitFor(1);
        assertEquals(alphaSenseDocumentPage.codeMirrorLine.getAttribute("class"),
                "CodeMirror cm-s-default CodeMirror-empty CodeMirror-focused");//"CodeMirror cm-s-default CodeMirror-empty","");
        alphaSenseDocumentPage.textarea.sendKeys("AlphaSense" + Keys.ENTER);
        alphaSenseDocumentPage.snippetItemList.get(0).click();
        JSUtils.highlightElement( alphaSenseDocumentPage.snippetItemList.get(0));
        assertFalse(alphaSenseDocumentPage.codeMirrorLine.getAttribute("class").contains("CodeMirror cm-s-default CodeMirror-empty CodeMirror-focused"));

    }

    @Test(priority = 2)
    public void clickLastSnippetTest(){
        ReusableMethods.pageDown(5);
        WebElement lastSnippet = alphaSenseDocumentPage.snippetItemList.get(alphaSenseDocumentPage.snippetItemList.size()-1);
        lastSnippet.click();
        JSUtils.highlightElement( lastSnippet);
        System.out.println("lastSnippet.getText() = " + lastSnippet.getText());
    }

    @Test(priority = 3)
    public void verifyTheBackgroundColor(){


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


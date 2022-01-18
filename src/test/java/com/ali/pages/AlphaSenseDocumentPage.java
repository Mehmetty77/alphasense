package com.ali.pages;

import com.ali.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlphaSenseDocumentPage {
    public AlphaSenseDocumentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = ".react-codemirror2")
    public WebElement codeMirror;

    @FindBy(xpath = "//*[contains(@class,'CodeMirror')][1]")
    public WebElement codeMirrorLine;

    @FindBy(tagName = "textarea")
    public WebElement textarea;

    @FindBy(css = ".snippetItem__content")
    public List<WebElement> snippetItemList;

    @FindBy(tagName = "p")
    public List<WebElement> iframeContentList;

    @FindBy(id = "fse6357_0")
    public WebElement logoStatement;

    @FindBy(id = "fse6357_7")
    public WebElement logoLink;

}

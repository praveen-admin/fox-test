package com.au.foxsports.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * POM class covers UI locators and functions for Article Page feature
 *
 * @author  Praveen R
 * @version 1.0
 * @since   2021-02-13
 */
public class ArticlePage extends BasePage {

    @FindBy(css = ".fnhmt__tbm")
    WebElement hamburgerMnu;

    @FindBy(xpath = "//*[@id='\uD83C\uDF54\uD83D\uDCD1']//*[@for='\uD83C\uDF540\uD83D\uDCCB2\uD83D\uDCCB\uD83D\uDE2E']")
    WebElement footballLnk;

    @FindBy(xpath = "//*[@id='\uD83C\uDF540\uD83D\uDCCB2\uD83D\uDCCB\uD83D\uDCD1']/div[2]/div/ul/li[2]/a/span")
    WebElement latestNewLnk;

    @FindBy(xpath = "(//article)[1]//a[@class='article-snippet__header-link']")
    WebElement articleLnk;

    @FindBy(css = ".fiso-article-story__page-title")
    WebElement articleTitle;

    @FindBy(xpath = "(.//*[@class='fiso-article-captioned-figure__image'])[1]")
    WebElement articleImg;

    @FindBy(xpath = "//*[@id=\"fiso-article-page-1\"]//div[@class='fiso-article-body']/p[1]")

    WebElement articleContent;

    boolean flag;
    String content;

    public ArticlePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnHamburgerMenu(){
        click(hamburgerMnu);
    }

    public void clickOnFootBallLnk(){
        click(footballLnk);
    }

    public void clickOnLatestNewsLnk(){
        click(latestNewLnk);
    }

    public void clickOnArticleLnk(){
        click(articleLnk);
    }

    public void scrollToHeroImage() {
        scrollIntoView("arguments[0].scrollIntoView()",articleTitle);
    }
    public boolean validateArticleTitleIsPresent() {
        content = getText(articleTitle);
        flag = validateContentIsPresent(content);
        return flag;
    }

    public boolean validateArticleImageIsPresent() {
        flag = isElementDisplayed(articleImg);
        return flag;
    }

    public boolean validateArticleContentIsPresent() {
        content = getText(articleContent);
        flag = validateContentIsPresent(content);
        return flag;
    }

    private boolean validateContentIsPresent(String content){
        System.out.println(content);
        return content.length() > 0;
    }
}

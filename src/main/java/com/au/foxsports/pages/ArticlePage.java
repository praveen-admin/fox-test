package com.au.foxsports.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage extends BasePage {
  //  "//*[@id='🍔0📋2📋📑']/div[2]/div/ul/li[2]/a/span"

    @FindBy(css = ".fnhmt__tbm")
    WebElement hamburgerMnu;

    @FindBy(css = ".fnhmbs--r > .fnhmbsi:nth-child(3) > .fnhmbsi__sl") // TODO: check football before click
    WebElement footballLnk;

    @FindBy(xpath = "//*[@id='\uD83C\uDF540\uD83D\uDCCB2\uD83D\uDCCB\uD83D\uDCD1']/div[2]/div/ul/li[2]/a/span") // TODO: check latest news before click
    WebElement latestNewLnk;

    @FindBy(xpath = "//*[@id='foxsports_row_habitual-1638']/div[1]/div/div[1]/article/header/p/a") // TODO: make it dynamic Ray
    WebElement articleLnk;

    @FindBy(css = ".fiso-article-story__page-title")
    WebElement articleTitle;

    @FindBy(xpath = "(.//*[@class='fiso-article-captioned-figure__image'])[1]")
    WebElement articleImg;

    @FindBy(xpath = "//*[@id=\"fiso-article-page-1\"]/article/div/div[1]/p[1]") // TODO: make it dynamic Ray
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

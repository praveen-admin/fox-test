package com.au.foxsports.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VideoPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Video')]")
    WebElement videoLnk;

    @FindBy(css = ".fiso-video-mosaic__main ul li:nth-child(1) button")
    WebElement childVideoBtn;

    @FindBy(css = ".fiso-video-hub__heading")
    WebElement pageHeader;

    @FindBy(css = ".fiso-video-mosaic__main .fiso-videojs-player video.vjs-tech")
    WebElement videoPlayer;

    @FindBy(css = ".fiso-video-player__layer .fiso-videojs-responsive-helper__inner .fiso-videojs-player")
    List<WebElement> videoID;

    @FindBy(css = ".fiso-video-mosaic button[title='Play/Pause Video']")
    WebElement playPauseBtn;

    public VideoPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    String videoName;
    boolean flag;


    public void clickOnVideoLink(){
        click(videoLnk);
    }

    public void clickOnFirstVideo(){
        click(childVideoBtn);
    }

    public void scrollToVideoPlayer() {
        scrollIntoView("arguments[0].scrollIntoView()",pageHeader);
    }

    public boolean verifyIfAdIsDisplayed(){
        List<WebElement> elements = driver.findElements(By.cssSelector(".fiso-video-player__layer .fiso-videojs-responsive-helper__inner .fiso-videojs-player"));
        videoName = elements.get(1).getAttribute("id");
        By adElement = By.xpath("//*[@id='"+videoName+"']/div[5]/div[3]");
        flag = isElementDisplayed(adElement);
        return flag;
    }


    public boolean waitForAdToComplete() {
        By adElement = By.xpath("//*[@id='"+videoName+"']/div[5]/div[3]");
        flag = isElementInvisible(adElement);
        return flag;
    }

    public boolean verifyPauseFunction() throws InterruptedException {
        Thread.sleep(2000);
        click(playPauseBtn);
        flag = executeJSScript("return arguments[0].paused",videoPlayer);
        return flag;
    }

    public boolean verifyPlayFunction() throws InterruptedException {
        Thread.sleep(2000);
        click(playPauseBtn);
        flag = executeJSScript("return arguments[0].paused",videoPlayer);
        return flag;
    }
}

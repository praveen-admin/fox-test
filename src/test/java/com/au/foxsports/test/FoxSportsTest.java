package com.au.foxsports.test;

import com.au.foxsports.pages.ArticlePage;
import com.au.foxsports.pages.VideoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The Fox sports tests implements 2 test cases for Video Play/Pause feature
 * and article page verification
 *
 * @author  Praveen R
 * @version 1.0
 * @since   2021-02-13
 */
public class FoxSportsTest extends Base{

    VideoPage videoPage;
    ArticlePage articlePage;

    @Test(enabled = true)
    public void validatePlayAndPauseFeature() throws InterruptedException {
        test = report.createTest("To verify Play And Pause Feature");

        videoPage = new VideoPage(driver);
        videoPage.clickOnVideoLink();
        videoPage.clickOnFirstVideo();
        videoPage.scrollToVideoPlayer();

        boolean adIsDisplayed = videoPage.verifyIfAdIsDisplayed();

        if(adIsDisplayed) {
            videoPage.waitForAdToComplete();
        }

        boolean verifyPauseFeature =videoPage.verifyPauseFunction();
        boolean verifyPlayFeature =videoPage.verifyPlayFunction();

        Assert.assertTrue(adIsDisplayed, "Ad content is not displayed");
        Assert.assertTrue(verifyPauseFeature, "Video is not paused");
        Assert.assertFalse(verifyPlayFeature, "Video is not played");
    }

    @Test(enabled = true)
    public void validateArticlePage() {
        test = report.createTest("To verify Article Page");

        articlePage = new ArticlePage(driver);
        articlePage.clickOnHamburgerMenu();
        articlePage.clickOnFootBallLnk();
        articlePage.clickOnLatestNewsLnk();
        articlePage.clickOnArticleLnk();
        articlePage.scrollToHeroImage();

        boolean validateArticleTitle = articlePage.validateArticleTitleIsPresent();
        boolean validateArticleImage = articlePage.validateArticleImageIsPresent();
        boolean validateArticleContent = articlePage.validateArticleContentIsPresent();

        Assert.assertTrue(validateArticleTitle, "Article Title content is empty");
        Assert.assertTrue(validateArticleImage, "Article Image is empty");
        Assert.assertTrue(validateArticleContent, "Article content is empty");

    }


}

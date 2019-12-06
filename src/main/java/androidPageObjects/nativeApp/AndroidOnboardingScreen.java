package androidPageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.io.IOException;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static utils.DriverFactory.driver;

public class AndroidOnboardingScreen extends DriverFactory {

	@AndroidFindBy(id="com.fdbr.android.debug:id/imageAds")
	public AndroidElement SplashScreenImage;

	@AndroidFindBy(id="com.fdbr.android.debug:id/buttonGetStarted")
	public AndroidElement GetStartedBtn;


	public AndroidOnboardingScreen(AppiumDriver driver) throws IOException {

		this.driver = driver;
		//Initialize Elements of a Page class without having to use ‘FindElement‘ or ‘FindElements‘
		PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
	}

	//intro screen
	public void swipeAfterSplashScreen() throws IOException {

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//		this.horizontalSwipeByPercentage(SplashScreenImage,0.9,0.01,0.5,500);
//		this.horizontalSwipeByPercentage(SplashScreenImage, 0.9,0.01,0.5,500);

		Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * 0.5);
        int startPoint = (int) (size.width * 0.9);
        int endPoint = (int) (size.width * 0.1);

        new TouchAction(driver)
                .tap(tapOptions().withElement(element(SplashScreenImage)))
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endPoint, anchor))
                .release().perform();

        new TouchAction(driver)
				.tap(tapOptions().withElement(element(SplashScreenImage)))
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endPoint, anchor))
                .release().perform();

	}

	public void clickGetStartedBtn() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(GetStartedBtn));
		GetStartedBtn.click();
	}


}

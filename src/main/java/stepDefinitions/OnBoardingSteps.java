package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class OnBoardingSteps extends DriverFactory {

    @Given("^User navigates to onboarding screen by swipe$")
    public void user_navigates_to_onboarding_screen_by_swipe() throws Throwable {

        onBoardingScreen.swipeAfterSplashScreen();
        onBoardingScreen.clickGetStartedBtn();
    }

    @Given("^User navigates to onboarding screen by click next$")
    public void user_navigates_to_onboarding_screen_by_click_next() throws Throwable {

        onBoardingScreen.clickNextIntroBtn();
        onBoardingScreen.clickGetStartedBtn();
    }

    @When("^User click login button on onboarding screen$")
    public void user_click_login_button_on_onboarding_screen() throws Throwable {

        onBoardingScreen.clickLoginBtn();
    }
}

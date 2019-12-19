package utils;

import pageObjects.HomeScreen;
import pageObjects.LoginScreen;
import pageObjects.OnboardingScreen;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;

public class DriverFactory {

    //grid
    public static AppiumDriver driver;

    /****************
     Android & IOS Screen
     ****************/
    public static OnboardingScreen onBoardingScreen;
    public static LoginScreen loginScreen;
    public static HomeScreen homeScreen;

    //set configuration
    public static String loadPropertyFile = "android.properties";

    public AppiumDriver getDriver() throws IOException {

        try {
            if (driver == null) {

                AppiumServer.stop();
                AppiumServer.start();

                if (loadPropertyFile.contains("ios")) {
                    CommonUtils.loadIosConfigProp("ios.properties");
                    CommonUtils.setIOSCapabilities();
                    driver = CommonUtils.getIOSDriver();
                } else if (loadPropertyFile.contains("android")) {
                    CommonUtils.loadAndroidConfigProp("android.properties");
                    CommonUtils.setAndroidCapabilities();
                    driver = CommonUtils.getAndroidDriver();
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to load apps: " + e.getMessage());
        } finally {
            // This is to Instantiate class
            onBoardingScreen = new OnboardingScreen(driver);
            loginScreen = new LoginScreen(driver);
            homeScreen = new HomeScreen(driver);
        }
        return driver;
    }

}

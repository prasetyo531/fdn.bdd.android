package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomeScreen extends ActionBase {

    //@AndroidFindBy(xpath="//class[contains(@resource-id, '') and @text='FD Flash Sale']")

    /**********
     tab bar
     **********/
    @AndroidFindBy(accessibility="Home")
    public MobileElement homeTab;

    @AndroidFindBy(accessibility="Feed")
    public MobileElement feedTab;

    @AndroidFindBy(accessibility="Discover")
    public MobileElement discoverTab;

    @AndroidFindBy(accessibility="com.fdbr.android.debug:id/")
    public MobileElement plusTab;

    @AndroidFindBy(accessibility="com.fdbr.android.debug:id/")
    public MobileElement profileTab;

    /*
    home screen
     */
    @AndroidFindBy(id="com.fdbr.android.debug:id/labelHello")
    public MobileElement greetingText;

    @AndroidFindBy(xpath="//android.view.View[contains(@resource-id,'aw0') and @text='goc-shop']")
    public MobileElement adsBanner;

    @AndroidFindBy(id="com.fdbr.android.debug:id/buttonMenuToolbar")
    public MobileElement notifBtn;

    @AndroidFindBy(id="com.fdbr.android.debug:id/inputSearch")
    public MobileElement searchBar;

    @AndroidFindBy(id="com.fdbr.android.debug:id/id_addreview")
    public MobileElement addReview;

    @AndroidFindBy(id="com.fdbr.android.debug:id/id_addpost")
    public MobileElement addPost;

    @AndroidFindBy(id="com.fdbr.android.debug:id/id_addproduct")
    public MobileElement addProduct;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.fdbr.android.debug:id/buttonCancel') and @text='Cancel']")
    public MobileElement cancel;

    @AndroidFindBy(xpath ="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[4]")
    public MobileElement firstindextproductmatches;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.fdbr.android.debug:id/textMatch') and @text='Match: Skin Type, Skin Undertone']")
    public MobileElement productMatchesSkinTypeAndSkinUndertone;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.fdbr.android.debug:id/textMatch') and @text='Match: Skin Type, Skin Tone']")
    public MobileElement productMatchesSkinTypeAndSkinTone;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.fdbr.android.debug:id/textMatch') and @text='Match: Skin Tone']")
    public MobileElement productMatchesSkinTone;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.fdbr.android.debug:id/textMatch') and @text='Match: Skin Type']")
    public MobileElement productMatchesSkinType;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.fdbr.android.debug:id/textMatch') and @text='Match: Hair Type']")
    public MobileElement productMatchesHairType;

    // This is a constructor, as every page need a base driver to find android elements
    public HomeScreen(AppiumDriver driver) throws IOException {

        this.driver = driver;
        //Initialize Elements of a Page class without having to use ‘FindElement‘ or ‘FindElements‘
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

    public boolean verifyHomescreen() {

        boolean boolElem1= isElementPresent(greetingText);
        boolean boolElem2= isElementPresent(adsBanner);
        boolean boolElem3= isElementPresent(notifBtn);
        boolean boolElem4= isElementPresent(searchBar);
        //boolean boolElem5= isElementPresent(firstindextproductmatches);

        return (boolElem1 && boolElem2 && boolElem3 && boolElem4);
    }

    public void verifyProductMatches() {

        isElementPresent(firstindextproductmatches);
        System.out.println("product matches is present");
    }



}

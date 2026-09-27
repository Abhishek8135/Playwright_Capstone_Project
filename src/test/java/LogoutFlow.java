import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.asserts.SoftAssert;

public class LogoutFlow {

    public static void execute(Page page, SoftAssert softAssert) {
        page.locator("#react-burger-menu-btn").click();
        page.locator("#logout_sidebar_link").click();

        // Soft assertion on login screen visibility
        boolean isLoginBtnVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).isVisible();
        softAssert.assertTrue(isLoginBtnVisible, "Logout failed: Login button not visible after logout");
    }
}
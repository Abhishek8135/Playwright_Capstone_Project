import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.asserts.SoftAssert;

public class LoginFlow {

    public static void execute(Page page, SoftAssert softAssert, String username, String password) {
        page.navigate("https://www.saucedemo.com/");

        page.getByPlaceholder("Username").fill(username);
        page.getByPlaceholder("Password").fill(password);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        // Soft assertion on URL
        softAssert.assertTrue(page.url().contains("inventory.html"),
                "Login failed: URL does not contain 'inventory.html'");
    }
}
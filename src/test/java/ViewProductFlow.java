import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.asserts.SoftAssert;

public class ViewProductFlow {

    public static void execute(Page page, SoftAssert softAssert, String productName) {
        page.getByText(productName).click();

        // Soft assertion on product details screen
        boolean isBackBtnVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back to products")).isVisible();
        softAssert.assertTrue(isBackBtnVisible, "View product failed: 'Back to products' button not visible");
    }
}
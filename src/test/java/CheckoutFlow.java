import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.asserts.SoftAssert;

public class CheckoutFlow {

    public static void execute(Page page, SoftAssert softAssert, String firstName, String lastName, String postalCode) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Checkout")).click();

        page.getByPlaceholder("First Name").fill(firstName);
        page.getByPlaceholder("Last Name").fill(lastName);
        page.getByPlaceholder("Zip/Postal Code").fill(postalCode);

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Finish")).click();

        // Soft assertion on order completion heading
        boolean isSuccessMsgVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Thank you for your order!")).isVisible();
        softAssert.assertTrue(isSuccessMsgVisible, "Checkout failed: 'Thank you for your order!' message not displayed");
    }
}

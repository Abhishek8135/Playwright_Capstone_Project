import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.asserts.SoftAssert;

public class AddToCartFlow {

    public static void execute(Page page, SoftAssert softAssert) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).click();
        page.locator(".shopping_cart_link").click();

        // Soft assertion on cart item count
        int itemCount = page.locator(".cart_item").count();
        softAssert.assertEquals(itemCount, 1, "Add to cart failed: Cart item count is not 1");
    }
}
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SauceDemoTest extends BaseTest {

    @Test(dataProvider = "csvCheckoutData", dataProviderClass = TestData.class)
    public void testOrderFlowWithSoftAssert(
            String username,
            String password,
            String product,
            String firstName,
            String lastName,
            String zipCode
    ) {
        SoftAssert softAssert = new SoftAssert();

        // 1. Login Flow
        LoginFlow.execute(page, softAssert, username, password);

        // 2. View Product Flow
        ViewProductFlow.execute(page, softAssert, product);

        // 3. Add to Cart Flow
        AddToCartFlow.execute(page, softAssert);

        // 4. Checkout Flow
        CheckoutFlow.execute(page, softAssert, firstName, lastName, zipCode);

        // 5. Logout Flow
        LogoutFlow.execute(page, softAssert);

        // Collate and report all collected assertion errors
        softAssert.assertAll();
    }
}
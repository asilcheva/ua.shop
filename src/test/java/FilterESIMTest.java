import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FilteredESIM;
import pages.SmartphoneFromHeaderPageObject;

public class FilterESIMTest extends BaseTest {
    @DisplayName("Check that 'eSIM Support' checkbox is checked with Yes")
    @Test
    public void eSIMSupportedIsCheckedTest() {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByEsimFromHeader(FilteredESIM.yes.name());
        smartphoneFromHeaderPageObject.assertThatESIMCheckboxChecked();
    }
    @DisplayName("Check that eSIM Support badge is displayed inside smartphone block")
    @Test
    public void eSIMSupportedBadgeDisplayedTest() {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByEsimFromHeader(FilteredESIM.yes.name());
        smartphoneFromHeaderPageObject.assertESIMFilteredPhoneShown(true);
    }

    @DisplayName("Check that 'eSIM Support' checkbox is checked with No")
    @Test
    public void eSIMNotSupportedIsCheckedTest() {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByEsimFromHeader(FilteredESIM.no.name());
        smartphoneFromHeaderPageObject.assertThatESIMCheckboxChecked();
    }
    @DisplayName("Check that eSIM Support badge isn't displayed inside smartphone block")
    @Test
    public void eSIMSupportedBadgeNotDisplayedTest() {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByEsimFromHeader(FilteredESIM.no.name());
        smartphoneFromHeaderPageObject.assertESIMFilteredPhoneShown(false);
    }
}

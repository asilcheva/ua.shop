import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.jupiter.api.Test;
import pages.FilterBrand;
import pages.SmartphoneFromHeaderPageObject;

import java.sql.SQLException;

public class FilterBrandTest extends BaseTest {

    //public ScreenShooter makeScreenOnFailure= ScreenShooter.failedTests() ;
    @Test
    public void filteredGeneralMobileBrandIsCheckedAndTest() {
        String brand = FilterBrand.GENERAL_MOBILE.getValue();
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByBrandFromHeader(brand);
        smartphoneFromHeaderPageObject.assertCorrectFilteredBrandIsChecked();
        smartphoneFromHeaderPageObject.assertFilteredBrandPhonesDisplayed(brand);
    }

    @Test
    public void filteredDoogeeBrandIsCheckedTest() {
        String brand = FilterBrand.DOOGEE.getValue();
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByBrandFromHeader(brand);
        smartphoneFromHeaderPageObject.assertCorrectFilteredBrandIsChecked();
        smartphoneFromHeaderPageObject.assertFilteredBrandPhonesDisplayed(brand);
    }

    @Test
    public void filteredHuaweiBrandIsCheckedTest() {
        String brand = FilterBrand.HUAWEI.getValue();
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByBrandFromHeader(brand);
        smartphoneFromHeaderPageObject.assertCorrectFilteredBrandIsChecked();
        smartphoneFromHeaderPageObject.assertFilteredBrandPhonesDisplayed(brand);
    }

    @Test
    public void filteredSamsungBrandIsCheckedTest() {
        String brand = FilterBrand.SAMSUNG.getValue();
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByBrandFromHeader(brand);
        smartphoneFromHeaderPageObject.assertCorrectFilteredBrandIsChecked();
        smartphoneFromHeaderPageObject.assertFilteredBrandPhonesDisplayed(brand);
    }

    @Test
    public void filteredXiaomiBrandIsCheckedTest() {
        String brand = FilterBrand.XIAOMI.getValue();
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByBrandFromHeader(brand);
        smartphoneFromHeaderPageObject.assertCorrectFilteredBrandIsChecked();
        smartphoneFromHeaderPageObject.assertFilteredBrandPhonesDisplayed(brand);
    }

    @Test
    public void filteredMeizuBrandIsCheckedTest() {
        String brand = FilterBrand.MEIZU.getValue();
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByBrandFromHeader(brand);
        smartphoneFromHeaderPageObject.assertCorrectFilteredBrandIsChecked();
        smartphoneFromHeaderPageObject.assertFilteredBrandPhonesDisplayed(brand);
    }

    @Test
    public void allPhonesFromDBDisplayedTest() throws SQLException {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getAllPhonesFromHeader();
        smartphoneFromHeaderPageObject.assertAllPhonesDisplayed();
    }
    @Test
    public void allPhonesSortedByNameIncr(){
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getSortedByNameIncreasingPhones();
        smartphoneFromHeaderPageObject.assertSortingByNameIncreasing();
    }
}

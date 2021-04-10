import org.junit.jupiter.api.Test;
import pages.FilterPrices;
import pages.SmartphoneFromHeaderPageObject;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FilterPriceTest extends BaseTest {
    @Test
    public void filteredPriceLess3000Test() {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByPriceFromHeader(FilterPrices.FIRST.getLowPrice(), FilterPrices.FIRST.getHighPrice());
        smartphoneFromHeaderPageObject.assertThatPricesInFilterCorrect();
        smartphoneFromHeaderPageObject.assertFilteredPhonePricesLessThanHigh();
        smartphoneFromHeaderPageObject.assertFilteredPhonePricesMoreThanLow();
    }

    @Test
    public void filteredPriceLess5000Test() {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByPriceFromHeader(FilterPrices.SECOND.getLowPrice(), FilterPrices.SECOND.getHighPrice());
        smartphoneFromHeaderPageObject.assertThatPricesInFilterCorrect();
        smartphoneFromHeaderPageObject.assertFilteredPhonePricesLessThanHigh();
        smartphoneFromHeaderPageObject.assertFilteredPhonePricesMoreThanLow();

    }

    @Test
    public void filteredPriceLess8000Test() {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByPriceFromHeader(FilterPrices.THIRD.getLowPrice(), FilterPrices.THIRD.getHighPrice());
        smartphoneFromHeaderPageObject.assertThatPricesInFilterCorrect();
        smartphoneFromHeaderPageObject.assertFilteredPhonePricesLessThanHigh();
        smartphoneFromHeaderPageObject.assertFilteredPhonePricesMoreThanLow();
    }

    @Test
    public void filteredPriceLess15000Test() {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByPriceFromHeader(FilterPrices.FOURTH.getLowPrice(), FilterPrices.FOURTH.getHighPrice());
        smartphoneFromHeaderPageObject.assertThatPricesInFilterCorrect();
        smartphoneFromHeaderPageObject.assertFilteredPhonePricesLessThanHigh();
        smartphoneFromHeaderPageObject.assertFilteredPhonePricesMoreThanLow();
    }

    @Test
    public void filteredPriceLess100000Test() {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getPhonesFilteredByPriceFromHeader(FilterPrices.FIFTH.getLowPrice(), FilterPrices.FIFTH.getHighPrice());
        smartphoneFromHeaderPageObject.assertThatPricesInFilterCorrect();
        smartphoneFromHeaderPageObject.assertFilteredPhonePricesLessThanHigh();
        smartphoneFromHeaderPageObject.assertFilteredPhonePricesMoreThanLow();
    }
    @Test
    public void filteredPriceLowToHighTest() throws SQLException {
        SmartphoneFromHeaderPageObject smartphoneFromHeaderPageObject = new SmartphoneFromHeaderPageObject();
        smartphoneFromHeaderPageObject.getSortedLowToHighPhones();
        smartphoneFromHeaderPageObject.assertMinPriceIsCorrect();
    }
}

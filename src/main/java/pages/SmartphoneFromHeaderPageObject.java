package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import db.DBConnection;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Data
public class SmartphoneFromHeaderPageObject {
    private String lowPrice;
    private String highPrice;
    private String isESIMsupported;
    private String brand;
    private String checkedCheckBox = "M19 3H5c-1.11 0-2 .9-2 2v14c0 1.1.89 2 2 2h14c1.11 0 2-.9 2-2V5c0-1.1-.89-2-2-2zm-9 14l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z";
    private DBConnection connection;

    public SmartphoneFromHeaderPageObject() {
        open("/");
        this.connection = new DBConnection();
    }


    public SmartphoneFromHeaderPageObject getPhonesFilteredByPriceFromHeader(String lowPrice, String highPrice) {
        $("[role='navigation']").find("[href='/en/catalog/smartfony/76']").hover();
        $("[href*='priceGte=" + lowPrice + "&priceLte=" + highPrice + "']").click();
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        return this;
    }

    public SmartphoneFromHeaderPageObject getPhonesFilteredByEsimFromHeader(String isESIMsupported) {
        $("[role='navigation']").find("[href='/en/catalog/smartfony/76']").hover();
        $("._1MeapHQ [href*='eSIM=" + isESIMsupported + "']").click();
        this.isESIMsupported = isESIMsupported;
        return this;
    }

    public SmartphoneFromHeaderPageObject getPhonesFilteredByBrandFromHeader(String brand) {
        $("[role='navigation']").find("[href='/en/catalog/smartfony/76']").hover();
        $(By.xpath("//*[@class = '_2CDsQuR']//a[contains(text(), '" + brand + "')]")).click();
        this.brand = brand;
        return this;
    }

    public SmartphoneFromHeaderPageObject getAllPhonesFromHeader() {
        $("[role='navigation']").find("[href='/en/catalog/smartfony/76']").hover();
        $(By.xpath("//*[@class='_2GAkKFB']/a[contains(text(), 'All brands')]")).click();
        $(".trm-mbR h4 a").shouldBe(Condition.visible);
        clickShowMoreButton();
        return this;
    }

    public List<String> getAllPhoneNames() {
        $(".trm-mbR h4 a").shouldBe(Condition.visible);
        return $$(".trm-mbR h4 a").texts();
    }

    public SmartphoneFromHeaderPageObject getSortedLowToHighPhones() {
        getAllPhonesFromHeader();
        $(By.xpath("//button[contains(text(), 'Price Low-High')]")).click();
        return this;
    }

    public SmartphoneFromHeaderPageObject getSortedHighToLowPhones() {
        getAllPhonesFromHeader();
        $(By.xpath("//button[contains(text(), 'Price High-Low')]")).click();
        return this;
    }
    public SmartphoneFromHeaderPageObject getSortedByNameIncreasingPhones() {
        getAllPhonesFromHeader();
        $(By.xpath("//button[contains(text(), 'Name Increasing')]")).click();
        isProductLoaded();
        return this;
    }

    public void clickShowMoreButton() {
        var el = $("[class='gQdovH3 CAQfJfU XRUEcAI'] [type='button']");
        while (el.exists()) {
            try {
                el.click();
            } catch (ElementNotFound e) {
            }
            isProductLoaded();
            el = $("[class='gQdovH3 CAQfJfU XRUEcAI'] [type='button']");
        }
    }
    public void isProductLoaded(){
        $("_2BZ0nUb").shouldNot(Condition.exist);
    }

    public List<String> getPrices() {
        $(".H06Tihr span").shouldBe(Condition.visible);
        clickShowMoreButton();
        return $$(".H06Tihr span").texts();
    }

    public ElementsCollection getSmartphones() {
        $(".trm-mbR").shouldBe(Condition.visible);
        clickShowMoreButton();
        return $$(".trm-mbR");
    }

    public SelenideElement getFilterPanel() {
        $(".uh7SjPk").shouldBe(Condition.visible);
        return $(".uh7SjPk");
    }

    public void assertThatPricesInFilterCorrect() {
        assertEquals($("._2WmtVW1 [name = 'from']").getValue(), getLowPrice());
        assertEquals($("._2WmtVW1 [name = 'to']").getValue(), getHighPrice());
    }

    public void assertThatESIMCheckboxChecked() {
        assertEquals(checkedCheckBox,
                $("[name='eSIM'][value='" + getIsESIMsupported() + "'] ~ svg path").getAttribute("d"));
    }

    public void assertFilteredPhonePricesLessThanHigh() {
        assertTrue(
                getPrices().stream()
                        .map(Integer::parseInt)
                        .allMatch(el -> el <= Integer.parseInt(getHighPrice())));
    }

    public void assertFilteredPhonePricesMoreThanLow() {
        assertTrue(
                getPrices().stream()
                        .map(Integer::parseInt)
                        .allMatch(el -> el >= Integer.parseInt(getLowPrice())));
    }

    public void assertESIMFilteredPhoneShown(boolean isExists) {
        assertEquals(isExists,
                getSmartphones()
                        .stream()
                        .map(e -> e.find("[src*='esim']"))
                        .allMatch(SelenideElement::exists));
    }

    public void assertCorrectFilteredBrandIsChecked() {
        getFilterPanel();
        assertTrue($(By.xpath("//*[@class='_4MluHVb' and text()='" + getBrand() + "']/../../input[@checked]"))
                .exists());
    }

    public void assertFilteredBrandPhonesDisplayed(String brand) {
        assertTrue(getSmartphones()
                .stream()
                .map(e -> e.find(".trm-mbR h4 a"))
                .map(SelenideElement::getText)
                .allMatch(s -> s.contains(brand))
        );
    }

    public void assertAllPhonesDisplayed() throws SQLException {
        List<String> phonesNameFromHeader = getAllPhoneNames();
        List<String> phonesNameFromDB = connection.getSmartphonesfromDB();
        assertTrue(CollectionUtils.containsAll(phonesNameFromDB, phonesNameFromHeader));
    }

    public void assertMinPriceIsCorrect() throws SQLException {
        List<Integer> prices = getPrices()
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        assertEquals(Collections.min(prices), Integer.parseInt($(".H06Tihr span").getText()));
    }
    public void assertSortingByNameIncreasing(){
        List<String> actualList = getAllPhoneNames();
        List<String> sortedList = actualList.stream().sorted((o1, o2) -> o2.compareTo(o1)*-1)
                .collect(Collectors.toList());
        Assertions.assertEquals(sortedList, actualList);

    }
}

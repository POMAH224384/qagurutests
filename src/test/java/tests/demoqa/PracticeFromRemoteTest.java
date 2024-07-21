package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Tag("ui_test_remote")
public class PracticeFromRemoteTest {

    protected RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUpBeforeClass() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:8080/wd/hub";
    }

    @Test
    void testPracticeFromTestCssSelector(){

        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                currentAddress = faker.address().streetAddress(),
                email = faker.internet().emailAddress();

//        String firstName = RandomUtils.getRandomString(10),
//                lastName = RandomUtils.getRandomString(10),
//                currentAddress = RandomUtils.getRandomString(30),
//                email = RandomUtils.getRandomEmail();


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber("1234567890")
                .setGender("Male")
                .setDateOfBirth("30", "July", "2000")
                .setSubject("Math")
                .setHobbies("Sports")
                .uploadPicture("img/1.png")
                .setAddress(currentAddress)
                .setStateAndCity("NCR", "Delhi")
                .submitRegistration();

        registrationPage.verifyResultsModalAppears()
                        .verifyResults("Student Name", firstName + " " + lastName)
                        .verifyResults("Student Email", email)
                        .verifyResults("Gender", "Male")
                        .verifyResults("Mobile", "1234567890")
                        .verifyResults("Date of Birth", "30 July,2000")
                        .verifyResults("Subjects", "Maths")
                        .verifyResults("Hobbies", "Sports")
                        .verifyResults("Picture", "1.png")
                        .verifyResults("Address", currentAddress)
                        .verifyResults("State and City", "NCR Delhi");

    }
}

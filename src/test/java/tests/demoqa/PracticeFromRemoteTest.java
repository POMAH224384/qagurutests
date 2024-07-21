package tests.demoqa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Tag("ui_test_remote")
public class PracticeFromRemoteTest extends TestBaseExtended{


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

    @Test
    @Disabled("Test is not ready")
    void testPracticeFromTestXpathSelector(){

        open("/automation-practice-form");

        $x("//*[@id='firstName']").setValue("FirstName");
        $x("//*[@id='lastName']").setValue("Last Name");
        $x("//*[@id='userEmail']").setValue("test@email.com");
        $x("//*[@id='userNumber']").setValue("1234567890");
        $x("//*[@id='gender-ration-3']").parent().click();
        $x("//*[@id='dateOfBirthInput']").click();
        $x("//*[@class='react-datepicker__month-select']").selectOption("July");
        $x("//*[@class='react-datepicker__year-select']").selectOption("2009");
        $x("//*[@class='react-datepicker__day--030']" +
                "[not(contains(@class, 'react-datepicker__day--outside-month'))]").click();
    }
}

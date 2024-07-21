package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private CalendarComponent calendar = new CalendarComponent();
    private RegistrationResultsModal registrationResults = new RegistrationResultsModal();

    private SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            emailInput = $("#userEmail"),
                            phoneNumberInput = $("#userNumber"),
                            genderInput = $("#genterWrapper"),
                            subjectInput = $("#subjectsInput"),
                            hobbiesInput = $("#hobbiesWrapper"),
                            pictureInput = $("#uploadPicture"),
                            addressInput = $("#currentAddress"),
                            stateCityInput = $("#stateCity-wrapper");

    public RegistrationPage openPage(){
        String titleText = "Student Registration Form";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titleText));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstName){
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName){
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail(String email){
        emailInput.setValue(email);

        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber){
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }

    public RegistrationPage setGender(String gender){
        genderInput.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject){
        subjectInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String hobby){
        hobbiesInput.$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String classPath){
        pictureInput.uploadFromClasspath(classPath);

        return this;
    }

    public RegistrationPage setAddress(String address){
        addressInput.setValue(address);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city){
        $("#state").click();
        stateCityInput.$(byText(state)).click();
        $("#city").click();
        stateCityInput.$(byText(city)).click();

        return this;
    }

    public void submitRegistration(){
        $("#submit").click();
    }

    public RegistrationPage verifyResultsModalAppears(){
        registrationResults.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResults(String key, String value){
        registrationResults.verifyResult(key, value);

        return this;
    }
}

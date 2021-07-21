package constans;

public interface ITestConstants {
    String ERROR_MESSAGE = "There is 1 error";
    String ERROR_EMAIL_MESSAGE = ERROR_MESSAGE + "\nAn email address required.";
    String ERROR_PASSWORD_MESSAGE = ERROR_MESSAGE + "\nPassword is required.";
    String AUTOMATION_PRACTICE_ACCOUNT_URL = "http://automationpractice.com/index.php?controller=my-account";
    String AUTOMATION_PRACTICE_BASE_URL = "http://automationpractice.com/";
    String AUTOMATION_PRACTICE_LOGIN_URL = AUTOMATION_PRACTICE_BASE_URL + "index.php?controller=authentication&back=my-account";
}

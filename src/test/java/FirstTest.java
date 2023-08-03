import framework.models.login.LoginRequestModel;
import framework.models.login.LoginResponseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import static framework.services.ShopServices.logIn;

public class FirstTest extends BaseTest{

    @Test
    public void loginTest() {
        LoginRequestModel requestModel = new LoginRequestModel("hbingley1","CQutx25i8r");
        LoginResponseModel loginResponseModel = logIn(requestModel);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginResponseModel.getId())
                .as("[id] not as expected")
                .isEqualTo(2);
        softAssertions.assertThat(loginResponseModel.getUsername())
                .as("[user not as expected]")
                .isEqualTo("hbingley1");
        softAssertions.assertThat(loginResponseModel.getImage())
                .as("[image] not as expected")
                .startsWith("https://")
                .endsWith(".png");
        softAssertions.assertThat(loginResponseModel.getToken())
                .as("[token] not as expected")
                .isEqualTo(loginResponseModel.getToken());
        softAssertions.assertAll();
    }
}




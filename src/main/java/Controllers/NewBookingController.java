package Controllers;

import io.restassured.response.Response;
import services.constant.EndPoints;
import services.context.TestContext;
import services.helper.NewBookingHelper;
import services.logger.Log;
import services.util.RestAssuredBase;

public class NewBookingController extends NewBookingHelper {


    RestAssuredBase restAssuredBase;
    TestContext testContext;

    public NewBookingController(TestContext context) {
        testContext = context;
        restAssuredBase = new RestAssuredBase();
    }

    public String postBookingStatusAPI(String expectedResponseCode) {
        String reqBody = generateBookingAPIRequestBody();
        Response id = restAssuredBase.postCall(EndPoints.HOST_NAME,reqBody, EndPoints.BOOKING_ENDPOINT,expectedResponseCode);
        Log.info(id.getBody().prettyPrint());
        return id.jsonPath().get("bookingid").toString();
    }

    public String getBookingStatusAPI(String bookingId, String expectedResponseCode) {

        Response responseBody = restAssuredBase.getCall(EndPoints.HOST_NAME, EndPoints.BOOKING_ENDPOINT + "/" + bookingId,expectedResponseCode);
        return responseBody.jsonPath().prettyPrint().toString();
    }
}
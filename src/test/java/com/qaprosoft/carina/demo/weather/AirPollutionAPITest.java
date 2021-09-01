package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.weather.GetAirPollution;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.annotations.Test;

public class AirPollutionAPITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirPollutionAPITest.class);

    @Test
    @MethodOwner(owner ="Aleksandra")
    public void createAirPollutionTest() {
        GetAirPollution getAirPollution = new GetAirPollution();
        getAirPollution.addParameter("appId", "c3907a866b93765001c0c0f7b923a7e8");
        getAirPollution.addParameter("lat", "53.902284");
        getAirPollution.addParameter("lon", "27.561831");
        getAirPollution.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAirPollution.callAPI();
        getAirPollution.validateResponseAgainstSchema("airPollution/_get/rs.schema");
    }
}

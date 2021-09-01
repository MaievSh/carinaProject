package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.weather.GetAirPollution;
import com.qaprosoft.carina.demo.api.weather.GetForecastMethod;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.annotations.Test;

public class ForecastMethodAPITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ForecastMethodAPITest.class);

    @Test
    @MethodOwner(owner ="Aleksandra")
    public void createForecastTest() {
        GetForecastMethod getForecastMethod = new GetForecastMethod();
        getForecastMethod.addParameter("appId", "c3907a866b93765001c0c0f7b923a7e8");
        getForecastMethod.addParameter("q", "Moscow");
        getForecastMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getForecastMethod.callAPI();
        getForecastMethod.validateResponseAgainstSchema("forecast/_get/rs.schema");
    }
}

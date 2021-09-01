package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.weather.GetForecastMethod;
import com.qaprosoft.carina.demo.api.weather.GetGeocodingMethod;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.annotations.Test;

public class GeocodingAPITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeocodingAPITest.class);

    @Test
    @MethodOwner(owner ="Aleksandra")
    public void createGeocodingTest() {
       GetGeocodingMethod getGeocodingMethod = new GetGeocodingMethod();
        getGeocodingMethod.addParameter("appId", "c3907a866b93765001c0c0f7b923a7e8");
        getGeocodingMethod.addParameter("q", "Minsk");
        getGeocodingMethod.addParameter("limit", "5");
        getGeocodingMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getGeocodingMethod.callAPI();
        getGeocodingMethod.validateResponseAgainstSchema("geocoding/_get/rs.schema");
    }
}

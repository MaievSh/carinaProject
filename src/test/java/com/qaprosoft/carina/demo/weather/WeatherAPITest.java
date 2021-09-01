package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.weather.GetWeatherMethod;
import com.qaprosoft.carina.demo.onliner.AddToCartTest;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.annotations.Test;

public class WeatherAPITest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherAPITest.class);

    @Test
    @MethodOwner(owner ="Aleksandra")
    public void createWeatherTest(){
        GetWeatherMethod getWeatherMethod = new GetWeatherMethod();
        getWeatherMethod.addParameter("appId", "c3907a866b93765001c0c0f7b923a7e8");
        getWeatherMethod.addParameter("q", "Minsk");
        getWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethod.callAPI();
          getWeatherMethod.validateResponse();
        getWeatherMethod.validateResponseAgainstSchema("weather/_get/rs.schema");
    }
}

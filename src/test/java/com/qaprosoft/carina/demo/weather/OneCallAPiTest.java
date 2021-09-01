package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.weather.GetOneCallMethod;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.testng.annotations.Test;

public class OneCallAPiTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OneCallAPiTest.class);

    @Test
    @MethodOwner(owner ="Aleksandra")
    public void createOneCall() {
      GetOneCallMethod getOneCallMethod = new GetOneCallMethod ();
        getOneCallMethod.addParameter("appId", "c3907a866b93765001c0c0f7b923a7e8");
        getOneCallMethod.addParameter("lat", "30");
        getOneCallMethod.addParameter("lon", "25");
        getOneCallMethod.addParameter("exclude", "alerts");
        getOneCallMethod.addParameter("exclude", "current");
        getOneCallMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getOneCallMethod.callAPI();
        getOneCallMethod.validateResponseAgainstSchema("oneCall/_get/rs.schema");
    }
}

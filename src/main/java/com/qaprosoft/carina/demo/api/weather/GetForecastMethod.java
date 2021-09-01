package com.qaprosoft.carina.demo.api.weather;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetForecastMethod extends AbstractApiMethodV2 {
    public GetForecastMethod() {
        super(null, "forecast/_get/rs.json",new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}

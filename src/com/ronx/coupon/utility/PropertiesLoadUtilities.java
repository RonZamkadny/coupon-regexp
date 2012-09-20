package com.ronx.coupon.utility;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

import java.io.File;

public final class PropertiesLoadUtilities {
    private PropertiesConfiguration config;

    public PropertiesLoadUtilities(PropertiesConfiguration config) {
        this.config = config;

    }

    public boolean reloadProperties()  {
        return config.reload(true);
    }
}

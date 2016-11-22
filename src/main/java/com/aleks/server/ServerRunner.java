package com.aleks.server;

import com.aleks.server.service.CalculatorWebServiceImpl;
import com.aleks.utils.PropertyUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.ws.Endpoint;

/**
 * Created by Oleksii_Shylo on 11/21/2016.
 */
public class ServerRunner {

    private static final Logger LOG = LogManager.getLogger(ServerRunner.class);

    /**
     * This is main method who run server
     *
     * @param args Unused.
     */
    public static void main(String ... args) {
        String url = PropertyUtils.getUrl("app.properties", "url");
        Endpoint.publish(url, new CalculatorWebServiceImpl());
        LOG.info("Start server");
    }

}

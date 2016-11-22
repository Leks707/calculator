package com.aleks.client;

import com.aleks.server.ServerRunner;
import com.aleks.server.service.CalculatorWebService;
import com.aleks.utils.PropertyUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Oleksii_Shylo on 11/21/2016.
 */
public class ClientRunner {

    private static final Logger LOG = LogManager.getLogger(ServerRunner.class);
    private static final String URL_ERROR_MESSAGE = "Malformed URL error";
    private static final String EMPTY_STATEMENT_ERROR_MESSAGE = "You cann't set the mathematics sequence.";

    /**
     * This is main method who run client.
     *
     * @param args first element of array args must be mathematical string statement with integer numbers.
     */
    public static void main(String... args) {
        String url = PropertyUtils.getUrl("app.properties", "url");
        String namespaceURI = PropertyUtils.getUrl("app.properties", "namespaceURI");
        QName qName = new QName(namespaceURI, "CalculatorWebServiceImplService");
        Service service;
        try {
            service = Service.create(new URL(url), qName);
        } catch (MalformedURLException e) {
            LOG.error(URL_ERROR_MESSAGE);
            throw new RuntimeException(URL_ERROR_MESSAGE, e);
        }
        if (args == null || args.length == 0) {
            throw new RuntimeException(EMPTY_STATEMENT_ERROR_MESSAGE);
        }
        CalculatorWebService calculatorService = service.getPort(CalculatorWebService.class);
        LOG.info("RESULT: " + calculatorService.process(args[0]));
    }
}

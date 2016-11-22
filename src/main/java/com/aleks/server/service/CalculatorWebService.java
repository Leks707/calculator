package com.aleks.server.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;

/**
 * Created by Oleksii_Shylo on 11/21/2016.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CalculatorWebService {

    /**
     * @param mathSequence string mathematical statement who contains integer number,
     *                     brackets, operators and does'n contains whitespace
     * @return BigDecimal number, result mathematical operations who contains in mathSequence.
     */
    @WebMethod
    BigDecimal process(String mathSequence);

}

package com.servico;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author osmar
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MensagemServico {

    /**
     * Operação de Web service
     * @return 
     */
    @WebMethod(operationName = "getMensagem")
    public String getMensagem();

    /**
     * Operação de Web service
     * @param mensagem
     */

    @WebMethod(operationName = "setMensagem")
    public void setMensagem(@WebParam(name = "mensagem") String mensagem);
}

package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ICalculatrice {

    @WebMethod
    double somme(
            @WebParam(name = "a") double a,
            @WebParam(name = "b") double b
    );

    @WebMethod
    double multiplication(
            @WebParam(name = "a") double a,
            @WebParam(name = "b") double b
    );

    @WebMethod
    double soustraction(
            @WebParam(name = "a") double a,
            @WebParam(name = "b") double b
    );

    @WebMethod
    double division(
            @WebParam(name = "a") double a,
            @WebParam(name = "b") double b
    );
}

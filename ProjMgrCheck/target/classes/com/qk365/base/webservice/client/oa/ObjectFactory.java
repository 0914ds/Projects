
package com.qk365.base.webservice.client.oa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.qk365.webservice.client.oa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Login_QNAME = new QName("http://inter.Security.WebService.jdnet.com/", "login");
    private final static QName _Login2Response_QNAME = new QName("http://inter.Security.WebService.jdnet.com/", "login2Response");
    private final static QName _Login3Response_QNAME = new QName("http://inter.Security.WebService.jdnet.com/", "login3Response");
    private final static QName _ModifyPasswordResponse_QNAME = new QName("http://inter.Security.WebService.jdnet.com/", "modifyPasswordResponse");
    private final static QName _Login3_QNAME = new QName("http://inter.Security.WebService.jdnet.com/", "login3");
    private final static QName _LoginResponse_QNAME = new QName("http://inter.Security.WebService.jdnet.com/", "loginResponse");
    private final static QName _Login2_QNAME = new QName("http://inter.Security.WebService.jdnet.com/", "login2");
    private final static QName _ModifyPassword_QNAME = new QName("http://inter.Security.WebService.jdnet.com/", "modifyPassword");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.qk365.webservice.client.oa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ModifyPasswordResponse }
     * 
     */
    public ModifyPasswordResponse createModifyPasswordResponse() {
        return new ModifyPasswordResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Login3 }
     * 
     */
    public Login3 createLogin3() {
        return new Login3();
    }

    /**
     * Create an instance of {@link ModifyPassword }
     * 
     */
    public ModifyPassword createModifyPassword() {
        return new ModifyPassword();
    }

    /**
     * Create an instance of {@link Login2 }
     * 
     */
    public Login2 createLogin2() {
        return new Login2();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link Login2Response }
     * 
     */
    public Login2Response createLogin2Response() {
        return new Login2Response();
    }

    /**
     * Create an instance of {@link Login3Response }
     * 
     */
    public Login3Response createLogin3Response() {
        return new Login3Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.Security.WebService.jdnet.com/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.Security.WebService.jdnet.com/", name = "login2Response")
    public JAXBElement<Login2Response> createLogin2Response(Login2Response value) {
        return new JAXBElement<Login2Response>(_Login2Response_QNAME, Login2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login3Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.Security.WebService.jdnet.com/", name = "login3Response")
    public JAXBElement<Login3Response> createLogin3Response(Login3Response value) {
        return new JAXBElement<Login3Response>(_Login3Response_QNAME, Login3Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.Security.WebService.jdnet.com/", name = "modifyPasswordResponse")
    public JAXBElement<ModifyPasswordResponse> createModifyPasswordResponse(ModifyPasswordResponse value) {
        return new JAXBElement<ModifyPasswordResponse>(_ModifyPasswordResponse_QNAME, ModifyPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.Security.WebService.jdnet.com/", name = "login3")
    public JAXBElement<Login3> createLogin3(Login3 value) {
        return new JAXBElement<Login3>(_Login3_QNAME, Login3 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.Security.WebService.jdnet.com/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.Security.WebService.jdnet.com/", name = "login2")
    public JAXBElement<Login2> createLogin2(Login2 value) {
        return new JAXBElement<Login2>(_Login2_QNAME, Login2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.Security.WebService.jdnet.com/", name = "modifyPassword")
    public JAXBElement<ModifyPassword> createModifyPassword(ModifyPassword value) {
        return new JAXBElement<ModifyPassword>(_ModifyPassword_QNAME, ModifyPassword.class, null, value);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localBean;


import java.util.List;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author student
 */
@Stateless
public class ControllerBean implements ControllerBeanLocal {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebServicesSOAP/WebServicesSOAP.wsdl")
    private WebServicesSOAP_Service service;


    @Override
    public String defaultName() {
        return defaultName_1();
    }
    
    @Override
    public List<String> getNoteList() {
        return getNoteList_1();
    }
    
    @Override
    public void uploadNote(String filename, byte[] bytesFile) {
        uploadNote_1(filename,bytesFile);
    }
    
    @Override
    public byte[] getNote(String filename) {
        return getNote_1(filename);
    }

    @Override
    public boolean deleteNote(String filename) {
        return deleteNote_1(filename);
    }
    
    @Override
    public List<String> getNameList() {
        return getNameList_1();
    }

    @Override
    public String getName(String ID) {
        return getName_1(ID);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
    private String defaultName_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        localBean.WebServicesSOAP port = service.getWebServicesSOAPPort();
        return port.defaultName();
    }

    private void uploadNote_1(java.lang.String filename, byte[] bytesFile) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        localBean.WebServicesSOAP port = service.getWebServicesSOAPPort();
        port.uploadNote(filename, bytesFile);
    }

    private java.util.List<java.lang.String> getNoteList_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        localBean.WebServicesSOAP port = service.getWebServicesSOAPPort();
        return port.getNoteList();
    }
    

    private byte[] getNote_1(java.lang.String filename) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        localBean.WebServicesSOAP port = service.getWebServicesSOAPPort();
        return port.getNote(filename);
    }

    private boolean deleteNote_1(java.lang.String filename) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        localBean.WebServicesSOAP port = service.getWebServicesSOAPPort();
        return port.deleteNote(filename);
    }

    private java.util.List<java.lang.String> getNameList_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        localBean.WebServicesSOAP port = service.getWebServicesSOAPPort();
        return port.getNameList();
    }

    private String getName_1(java.lang.String id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        localBean.WebServicesSOAP port = service.getWebServicesSOAPPort();
        return port.getName(id);
    }

    

   
   

    

    

    
    
}

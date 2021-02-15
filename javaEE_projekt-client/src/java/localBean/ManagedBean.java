/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localBean;


import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author student
 */
@RequestScoped
public class ManagedBean {
    private Part file;
    
    private String notename;
    private String note;

    
    
    
    
    

    @EJB
    private ControllerBeanLocal controllerBean;
    
    /**
     * Creates a new instance of ManagedBean
     */
    public ManagedBean() {
        
        
    }

   
    
    

    
    public void setNotename(String notename) {
        this.notename = notename;
    }

    public void setNote(String note) {
        this.note = note;
    }
    

    public String getNotename() {
        return notename;
    }

    public String getNote() {
        return note;
    }
    
    public String prepareNote() {
        //notename = filename;
        
        note = new String(controllerBean.getNote(notename), StandardCharsets.UTF_8);
        notename= controllerBean.getName(notename);
        return "view";
    }
    
    public void download() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
        response.reset();
        response.setContentType("text/plain");
        byte[] file = controllerBean.getNote(notename);
        response.setContentLength(file.length);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + controllerBean.getName(notename) + "\"");
        OutputStream output = response.getOutputStream();
        output.write(file);
        fc.responseComplete();
    }
    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        System.out.println();
        System.out.println("XDXDXDXDXDXSiekiera");
        System.out.println();
        this.file = file;
    }
    public void test() {
        controllerBean.getNoteList();
    }
    
    public List<String> getNotebook() {
        return controllerBean.getNoteList();
    }
    
    public List<String> getNamebook() {
        return controllerBean.getNameList();
    }
    
    public void defName()
    {
        
        
        notename = controllerBean.defaultName();
    }  
    
    public String saveNew() {
        //System.out.println("Nazwa : " +notename + "\n Treść : "+note+ "\n\n\n\n" );
        
        controllerBean.uploadNote(notename, note.getBytes(StandardCharsets.UTF_8) );
        return "list";
        
    }
    
    public void save() {
        if (file != null){
        String fileName = file.getSubmittedFileName();
        
        if(file.getSize() > 0) {
            byte[] byteFile = new byte[(int)file.getSize()];
            try {
                file.getInputStream().read(byteFile);
            } catch (IOException ex) {
                Logger.getLogger(ManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            controllerBean.uploadNote(fileName, byteFile);
        }}
    }
    
    public void addname(ActionEvent event) {
        //String filenamesd = ((HttpServletRequest)  FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("filename");
        notename = (String) event.getComponent().getId();
        notename = notename.substring(1);
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        //notename= request.getParameter("nazwa_pliku");
         System.out.println(" Nazwa Pliku : "+notename);
    }
    
    public void deleteFile() {
        controllerBean.deleteNote(notename);
    }

    
    
    
}

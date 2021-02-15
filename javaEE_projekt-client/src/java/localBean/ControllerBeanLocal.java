/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localBean;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author student
 */
@Local
public interface ControllerBeanLocal {

    String defaultName();

    void uploadNote(String filename, byte[] bytesFile);

    List<String> getNoteList();

    byte[] getNote(String filename);

    boolean deleteNote(String filename);

    List<String> getNameList();

    String getName(String ID);
    
}

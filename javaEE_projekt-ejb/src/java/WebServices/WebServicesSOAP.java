/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;


import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
//import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import org.bson.types.ObjectId;

/**
 *
 * @author student
 */
@WebService(serviceName = "WebServicesSOAP")
@Stateless()
public class WebServicesSOAP {
    private final String connString = "mongodb://student:student-TJEE@172.16.65.2:27017/studenci_2020";
    //private final String connString = "mongodb://127.0.0.1:27017/studenci_2020";
    private final String colection = "WCY18II1S1_Dabrowski_Notesbase";

    /**
     * Web service operation
     */
    @WebMethod(operationName = "DefaultName")
    public String DefaultName() {
        
        //TODO write your implementation code here:
        SimpleDateFormat ft = new SimpleDateFormat("HH-mm-ss");
        Date date = new Date();
        
        return "NewNote_"+ft.format(date);
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "uploadNote")
    @Oneway
    public void uploadNote(@WebParam(name = "filename") String filename, @WebParam(name = "bytesFile") byte[] bytesFile) {
        System.out.println();
        System.out.println("dlugosc: " + bytesFile.length);
        System.out.println();
        MongoClient mongo = new MongoClient(new MongoClientURI(connString));
        DB db = mongo.getDB("studenci_2020");
        GridFS gNote = new GridFS(db,colection);
        GridFSInputFile gFile =  gNote.createFile(bytesFile);
        gFile.setFilename(filename);
        gFile.save();
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNoteList")
    public List<String> getNoteList() {
        MongoClient mongo = new MongoClient(new MongoClientURI(connString));
        DB db = mongo.getDB("studenci_2020");
        GridFS gNote = new GridFS(db,colection);
        DBCursor i = gNote.getFileList();
        List<String> Notebook = new ArrayList<String>();
        
        while(i.hasNext()) {
            DBObject curr = i.next();
            if(curr.containsField("filename")) {
                if (!((String) curr.get("filename")).equals("")) {
                    Notebook.add(((ObjectId)curr.get("_id")).toString());
                }
            }
        }
        System.out.println("xd");
        System.out.println("xd");
        for(int g=0;g<Notebook.size();g++) {
            System.out.println(g+ " : " +Notebook.get(g));
            
        }
        System.out.println("xd");
        System.out.println("xd");
        
        return Notebook;
    }
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNote")
    public byte[] getNote(@WebParam(name = "filename") String filename) {
       MongoClient mongo = new MongoClient(new MongoClientURI(connString));
       DB db = mongo.getDB("studenci_2020");
       GridFS gNote = new GridFS(db,colection);
       GridFSDBFile note = gNote.findOne(new ObjectId(filename));
       try (ByteArrayOutputStream out = new ByteArrayOutputStream((int) note.getLength());) {
            note.writeTo(out);
            return out.toByteArray();
       } catch (IOException e) {
            return null;
       }

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteNote")
    public boolean deleteNote(@WebParam(name = "filename") String filename) {
      /* MongoClient mongo = new MongoClient(new MongoClientURI(connString));
       DB db = mongo.getDB("studenci_2020");
       GridFS gNote = new GridFS(db,colection);
       
       gNote.remove(gNote.findOne(new ObjectId(filename)));
       return gNote.findOne(new ObjectId(filename)) == null;*/
      
       MongoClient mongo = new MongoClient(new MongoClientURI(connString));
       MongoDatabase db = mongo.getDatabase("studenci_2020");
       //DB dbs = mongo.getDB("studenci_2020");
       //GridFS gNote = new GridFS(db,colection);
       GridFSBucket bucket = GridFSBuckets.create(db,colection);
       //GridFSDBFile note = gNote.find(new ObjectId(filename));
       //note.
       bucket.rename(new ObjectId(filename),"");
       return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNameList")
    public List<String> getNameList() {
         MongoClient mongo = new MongoClient(new MongoClientURI(connString));
        DB db = mongo.getDB("studenci_2020");
        GridFS gNote = new GridFS(db,colection);
        DBCursor i = gNote.getFileList();
        List<String> Notebook = new ArrayList<String>();
        
        while(i.hasNext()) {
            DBObject curr = i.next();
            if(curr.containsField("filename")) {
                if (!((String) curr.get("filename")).equals("")) {
                    Notebook.add((String) curr.get("filename"));
                }
            }
        }
        System.out.println("namebook");
        System.out.println("namebook");
        for(int g=0;g<Notebook.size();g++) {
            System.out.println(g+ " : " +Notebook.get(g));
            
        }
        System.out.println("namebook");
        System.out.println("namebook");
        
        return Notebook;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getName")
    public String getName(@WebParam(name = "ID") String ID) {
       MongoClient mongo = new MongoClient(new MongoClientURI(connString));
       DB db = mongo.getDB("studenci_2020");
       GridFS gNote = new GridFS(db,colection);
       GridFSDBFile note = gNote.findOne(new ObjectId(ID));
       return note.getFilename();
    }
    
    
    
    

    
}

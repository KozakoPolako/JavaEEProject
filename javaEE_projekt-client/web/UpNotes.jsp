<%-- 
    Document   : UpNotes
    Created on : 2021-02-09, 15:31:49
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Notepad UpNote Page</title>
            <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
        </head>
        <style>
            .navbar-my {
                background-color: #F8F8F8;
                border-color: #E7E7E7;
            }
        </style>
        <body>
            <h:form enctype="multipart/form-data">
            <nav class="navbar navbar-dark bg-dark navbar-my">  
                <div class="container">  
                    
                    <ul class="nav navbar-nav">
                        
                        <li><h:commandLink action="home">HOME</h:commandLink></li>
                        <li><h:commandLink action="list">LIST</h:commandLink></li>  
                        <li><h:commandLink action="new">NEW</h:commandLink></li>  
                        <li class="active"><h:commandLink action="upload">UPLOAD</h:commandLink></li>  
                        
                    </ul>
                    <ul class="nav navbar-nav navbar-right">  
                        <li><h:commandLink action="#{managedBean.save()}">UPLOAD</h:commandLink></li>  
                    <li><h:commandLink action="#{managedBean.test()}">EXIT</h:commandLink></li>  
                    </ul>  
                </div>  
            </nav>  
            
    
        <div class="container">
            
                <h:inputFile value="#{managedBean.file}"> 
                   
                </h:inputFile>
            
                        
           
        </div>
            </h:form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
        
        </body>
    </html>
</f:view>
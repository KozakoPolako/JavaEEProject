<%-- 
    Document   : NotesList
    Created on : 2021-02-13, 02:48:08
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>







<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<f:view>
    <html>
        <style>
            .center {
                margin: auto;
                text-align: center;
            }
            .navbar-my {
                background-color: #F8F8F8;
                border-color: #E7E7E7;
            }
            .note-input {
                width:100%;

            }
            .note-name {
                width:30%;
                min-width: 50px;

            }
            .icon {
                width: 30px;
                height: 30px;
            }
            .lista {
                list-style-type: none;
                max-width: 500px;
                margin: auto;
                padding-left: 0; 
                
            }
            .record {
                padding: 5px;
                display: flex;
                align-items: center;
                border: 1px solid black;
                margin-bottom: 3px;
                border-radius: 4px;
                
            }
            .filename {
                flex-grow: 1;
                padding: 0 10px 0 10px;
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
            }
            .margin {
                margin-right: 10px;
            }
            .note {
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
                flex-grow: 1;
            }
        </style>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Notepad List Page</title>
            <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
        </head>
        <body>
            <h:form >
            <nav class="navbar navbar-dark bg-dark navbar-my">  
                <div class="container">  
                    
                    <ul class="nav navbar-nav">
                        
                        <li><h:commandLink action="home">HOME</h:commandLink></li>
                        <li class="active"><h:commandLink action="list">LIST</h:commandLink></li>  
                        <li><h:commandLink action="new">NEW</h:commandLink></li>  
                        <li><h:commandLink action="upload">UPLOAD</h:commandLink></li>  
                        
                    </ul>  
                </div>  
            </nav>  
    
        <div class="container">
            
           <div class="note-input">
                <h3>Lista plików</h3> 
                <ul class ="lista">
                    <%int i = 0;%>
                    <%String name;
                      String named;
                      String namer;%>
                    
                    
                    <%--  <jsp:useBean  id="bean" class="localBean.ManagedBean" scope="request"/>
                    <jsp:setProperty name="bean" property="siekiera" value="dd"/> --%>
                    
                  
                    <c:set   var="nameboo" value="${managedBean.namebook}"/>
                    <c:forEach items="${managedBean.notebook}" var="plik" varStatus="status">
                        <%name= (String)pageContext.getAttribute("plik");
                        //name = name.replace('.', '_');
                        //name = name.replace(' ','_');nn
                        named= "d"+name;
                        namer= "r"+name;
                        name = "a"+name;
                        
                        %>
                        
                            <li class="record">
                                <img class="icon" src="static/plik.png"/>
                                
                                 <%--<c:set property="name" value="${plik}"/>--%>
                                <h:commandLink id="<%= name%>" actionListener="#{managedBean.addname}" action="#{managedBean.prepareNote()}" styleClass="note">
                                    <span  class="filename" > ${nameboo[status.index]}  </span></a>
                                </h:commandLink> 
                                <h:commandLink id="<%= named%>" actionListener="#{managedBean.addname}" action="#{managedBean.download}">
                                    <img class="icon margin" src="static/pobieranie.png"/>
                                </h:commandLink>
                                <h:commandLink id="<%= namer%>" actionListener="#{managedBean.addname}" action="#{managedBean.deleteFile}">
                                    <img class="icon" src="static/kosz.png"/>
                                </h:commandLink>
                            </li>
                        <%i++;%>
                        
                    </c:forEach>
                </ul>
            </div>   
            
              
          
        </div>  
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
        </h:form>
        </body>
    </html>
</f:view>

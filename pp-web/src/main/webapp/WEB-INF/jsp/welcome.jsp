<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval
	expression="@propertyConfigurer.getProperty('pp.showScrollerInJsp')"
	var="imgPath" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <!--banner starts here -->
<section class="jumbotron clearfix">
   <section class="banner-slider">
  
   <div id="slider">
    <ul id="banner">
    <%--  <c:forEach var="listValue" items="${allImages}"> --%>
   <li>
        <div class="banner-slide two">
         <%--  <img src="${imgPath}${listValue.imageId}.png" /> --%>
        </div>
      </li>
        <li>
         <div class="banner-slide one">
         <%--  <img src="${imgPath}${listValue.imageId}.png" /> --%>
          <div class="container">
            <div class="lead-txt">
              <h3>Over <b>300+</b> Students placed in various<br>
                companies in last year.</h3>
            </div>
          </div>
        </div>
      </li>
      <li>
        <div class="banner-slide three">
           <%--  <img src="${imgPath}${listValue.imageId}.png" /> --%>
        </div>
      </li>
          <%-- </c:forEach> --%>
    </ul>
    <a href="javascript:;" class="prev control_prev"></a> 
    <a href="javascript:;" class="next control_next"></a>
    </div>
 
  </section>
 
</section>
  <!--banner ends here -->

  <!--courses section begins here  -->
  <section class="offered-courses">
  <div class="container">
    <div class="lead-text">
      <h4 class="featurette-heading">Courses We Offer</h4>
      <p>Mostly Practical Sessions for every course in our institute.</p>
    </div>
    <div class="course-slider">
      <ul class="clearfix">
        <li>
          <div class="course-logo">
            <img src="img/java.png" alt="Java" />
          </div>
          <h3 class="course-name">JAVA</h3>
          <p class="course-description">Complete conceptual development in Core & Advanced java. Advanced
            infrastructure frameworks viz. Springs & Hibernate also covered.</p></li>
        <li>
          <div class="course-logo">
            <img src="img/ios.png" alt="Dot Net" />
          </div>
          <h3 class="course-name">iOS and Android</h3>
          <p class="course-description">Complete core concepts covered and an extra emphasis is laid to build up
            real-time scenarios through rigorous practical trainings.</p></li>
        <li>
          <div class="course-logo">
            <img src="img/oracle.png" alt="Oracle" />
          </div>
          <h3 class="course-name">ORACLE</h3>
          <p class="course-description">Core PL\SQL concepts covered in full length along with specialized oracle
            concepts like architecture and warehousing.</p></li>
        <li>
          <div class="course-logo">
            <img src="img/php.png" alt="PHP" />
          </div>
          <h3 class="course-name">PHP</h3>
          <p class="course-description">Training imparted through real-time scenario implementation through
            web-pages. Core concepts clarity provided in detail.</p></li>
      </ul>
    </div>
  </div>
  </section>
  <!--library section starts here  -->
 <!--  <section class="library-section">
  <div class="container clearfix">
    <h3>Our Library</h3>
    <div class="col-point margin-leftRemove">
      <h4>Java Technologies</h4>
      <ul>
        <li><a href="javascript:;">Learn Core Java</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Objectives</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Declaring Java Technology Classes</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Declaring Methods, Attributes</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Encapsulation</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Information Hiding</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Advanced Java</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">CGI Programs</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Java EE 5 SDK</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Servlets</a>
            </li>
            <li><a href="innerpage.html" target="_blank">JSP</a>
            </li>
            <li><a href="innerpage.html" target="_blank">MVC</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn J2EE</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Java Designing Goal</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Flavors of Java</a>
            </li>
            <li><a href="innerpage.html" target="_blank">JVM ÃÂÃÂÃÂÃÂ¢ÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂThe heart of Java</a>
            </li>
            <li><a href="innerpage.html" target="_blank">JavaÃÂÃÂÃÂÃÂ¢ÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂs Magic Bytecode</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Language Fundamentals</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Eclipse</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn EJB</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn JOGL</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Hibernate</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn iBATIS</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn JasperReports</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Java</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Java.io Package</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Java Interview Questions</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Java.lang Package</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Java.math Package</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
      </ul>
      <h4>DATABASE</h4>
      <ul>
        <li><a href="javascript:;">Learn DB2</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn MongoDB</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn MySQL</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn PL/SQL</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn PostgreSQL</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Redis</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn SQL</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn SQLite</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
      </ul>
    </div>
    <div class="col-point">
      <h4>WEB DEVELOPMENT</h4>
      <ul>
        <li><a href="javascript:;">Learn Adobe Flex</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn GWT</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn JSF</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn ASP.Net</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn DTD</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn HTML</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn HTML5</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn HTTP</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn XHTML</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn CSS</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn JavaScript</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn VBScript</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn jQuery</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn jQueryUI</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
      </ul>
      <h4>ACADEMIC</h4>
      <ul>
        <li><a href="javascript:;">Software Engineering</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Computer Programming</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Computer Networking</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">S/W Development Life Cycle</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Mgmt Information System</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
      </ul>
    </div>
    <div class="col-point">
      <h4>PROGRAMMING</h4>
      <ul>
        <li><a href="javascript:;">Learn Assembly</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn C</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn C++</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn C#</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn COBOL</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Objective C</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn D</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Euphoria</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn JCL</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn LISP</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn MATLAB</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Pascal</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Scala</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn VBA</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
      </ul>
      <h4>SCRIPTS</h4>
      <ul>
        <li><a href="javascript:;">Learn Python</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Ruby</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Perl</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn PHP</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Tcl/Tk</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
        <li><a href="javascript:;">Learn Lua</a>
          <ul>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
            <li><a href="innerpage.html" target="_blank">Sub Heading</a>
            </li>
          </ul></li>
      </ul>
    </div>
    <div class="col-point">
      <h4>Mobile Development</h4>
      <ul>
        <li><a href="javascript:;">Learn Android</a>
        </li>
        <li><a href="javascript:;">Learn iOS</a>
        </li>
        <li><a href="javascript:;">Learn PhoneGap</a>
        </li>
      </ul>
      <h4>Telecom</h4>
      <ul>
        <li><a href="javascript:;">Learn LTE</a>
        </li>
        <li><a href="javascript:;">Learn i-Mode</a>
        </li>
        <li><a href="javascript:;">Learn GPRS</a>
        </li>
        <li><a href="javascript:;">Learn GSM</a>
        </li>
        <li><a href="javascript:;">Learn WAP</a>
        </li>
        <li><a href="javascript:;">Learn WML</a>
        </li>
        <li><a href="javascript:;">Learn Wi-Fi</a>
        </li>
        <li><a href="javascript:;">Learn WiMAX</a>
        </li>
        <li><a href="javascript:;">Learn Telecom Billing</a>
        </li>
      </ul>
      <h4>Software Quality</h4>
      <ul>
        <li><a href="javascript:;">Learn QC</a>
        </li>
        <li><a href="javascript:;">Learn QTP</a>
        </li>
        <li><a href="javascript:;">Learn SEI CMMI</a>
        </li>
        <li><a href="javascript:;">Learn Six Sigma</a>
        </li>
        <li><a href="javascript:;">Learn Selenium</a>
        </li>
        <li><a href="javascript:;">Learn Software Testing</a>
        </li>
        <li><a href="javascript:;">Software Testing Dictionary</a>
        </li>
      </ul>
    </div>
    <div class="col-point">
      <h4>Management</h4>
      <ul>
        <li><a href="javascript:;">Learn EVM</a>
        </li>
        <li><a href="javascript:;">Management Concepts</a>
        </li>
        <li><a href="javascript:;">PMP Examination</a>
        </li>
      </ul>
      <h4>Selected Reading</h4>
      <ul>
        <li><a href="javascript:;">Computer Glossary</a>
        </li>
        <li><a href="javascript:;">Developer's Best Practices</a>
        </li>
        <li><a href="javascript:;">Download Free Graphics</a>
        </li>
        <li><a href="javascript:;">Effective Resume Writing</a>
        </li>
        <li><a href="javascript:;">Who is Who</a>
        </li>
      </ul>
      <h4>Misc</h4>
      <ul>
        <li><a href="javascript:;">Learn AJAX</a>
        </li>
        <li><a href="javascript:;">Learn DLL</a>
        </li>
        <li><a href="javascript:;">Learn ebXML</a>
        </li>
        <li><a href="javascript:;">Learn Git</a>
        </li>
        <li><a href="javascript:;">Learn GDB Debugger</a>
        </li>
        <li><a href="javascript:;">Learn Makefile</a>
        </li>
        <li><a href="javascript:;">Learn Excel 2010</a>
        </li>
        <li><a href="javascript:;">Learn Word 2010</a>
        </li>
        <li><a href="javascript:;">Learn Powerpoint 2010</a>
        </li>
        <li><a href="javascript:;">Learn Parrot</a>
        </li>
        <li><a href="javascript:;">Learn CGI with PERL</a>
        </li>
        <li><a href="javascript:;">Learn RADIUS</a>
        </li>
        <li><a href="javascript:;">Learn RSS</a>
        </li>
        <li><a href="javascript:;">Learn SOAP</a>
        </li>
        <li><a href="javascript:;">Learn SVN</a>
        </li>
      </ul>
    </div>
  </div>
  </section>
  library section ends here  -->
</body>
<script type="text/javascript" src="js/accordion.js"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script type="text/javascript" src="js/page-js/welcome.js"></script>

</html>
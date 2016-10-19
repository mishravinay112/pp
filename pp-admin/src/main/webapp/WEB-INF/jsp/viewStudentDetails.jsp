<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval expression="@propertyConfigurer.getProperty('pp.jspImagePath')" var="imgPath" />
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Add Courses</title>
<script type="text/javascript" src="js/page-js/viewStudentDetails.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script src="js/jquery.autocomplete.js"></script>	
	<script>
	jQuery(function(){
		$("#registration").autocomplete("list.jsp");
	});
   </script>
<style>
.basic-table {
  width: 158%;
}
</style>
</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
 <form:form method="POST" action="getStudentDetailsByName.do" modelAttribute="Registration" autocomplete="off">
      	<table width="40%" align="right">
      	<tr>
      	<td colspan="2"><font face="verdana" size="2">
      		Select Name : <small class="required"></small><input type="text" id="registration" name="registration" class="input_text" required="autofocus"/></font>  <input type="submit" value="Go"/></td>
      	</tr>
      	</table>
      </form:form>
      
      <form:form method="POST" action="getStudentDetails.do" modelAttribute="Registration" autocomplete="off">
        <table width="100%" border="0">
          <tr>
            <td><div class="form-control">
                <label>
                  <p>
                  <h3 style="color: #873d80;">Please select atleast one for student details</h3> <small class="required"></small>
                  </p> </label> <label>
                  <p>
                    <small class="required"></small>
                  </p> ALL&nbsp;&nbsp;&nbsp;<form:checkbox path="searchType" value="all" id="all" onclick="callAll()" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <label>
                  <p>
                    Course Wise<small class="required"></small>
                  </p> <form:select path="course.courseId" class="inputControl1" id="courseId" onchange="callCourse()">
                    <form:option value="0" label="Select" />
                    <c:forEach items="${course}" var="refCourse">
                      <form:option value="${refCourse.courseId}" label="${refCourse.courseName}" />
                    </c:forEach>
                  </form:select> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <label>
                  <p>
                    Batch Wise<small class="required"></small>
                  </p> <form:select path="batch.batchId" class="inputControl1" id="batchId" onchange="callBatch()">
                    <form:option value="0" label="Select" />
                    <c:forEach items="${batch}" var="refBatch">
                      <form:option value="${refBatch.batchId}" label="${refBatch.batchName}" />
                    </c:forEach>
                  </form:select> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit" value="Submit" class="btn lg-btn" /></td>
          </tr>
        </table>
      </form:form>
      <c:set var="count" value="0" scope="page" />
      <display:table name="studentDetails" pagesize="8" class="basic-table" uid="cat" requestURI="getStudentDetails.do">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" class="showHeading" style="width:1%;">
     ${count}
    </display:column>
    	<display:column title="NAME">${cat.firstName} ${cat.lastName}</display:column>
        <display:column property="contact" title="CONTACT NO" />
        <display:column property="emailId" title="EMAIL ID" />
        <display:column property="totalFee" title="Total Fee" />
        <display:column property="submittedFee" title="SUBMITTED FEE" />
         
        <display:column title="Image">
          <img src="${imgPath}${cat.registrationId}.png"  onerror="this.src='${imgPath}image.jpg'"  style="width: 50px; height: 50px">
        </display:column>
        
        <display:column title="Current Status" >${cat.currentStatus.currentStatus}</display:column>
        <c:choose>
          <c:when test="${cat.status!='free'}">
            <display:column>
              <a href="viewDetails.do?registrationId=${cat.registrationId}">FEE DETAILS</a>
            </display:column>
          </c:when>
          <c:otherwise>
            <display:column>
              <a href="setStudentDetails.do?registrationId=${cat.registrationId}">MAKE STUDENT</a>
            </display:column>
          </c:otherwise>
        </c:choose>
        <display:column>
          <a href="getEmailId.do?emailId=${cat.emailId}">Send Mail</a>
        </display:column>
          <c:if test="${sessionScope.login.adminType!=4}">
           <display:column title="Edit">
          <a href="getStudentDetails.do?registrationId=${cat.registrationId}">Edit</a>
        </display:column>
        
         <display:column title="Delete">
          <a href="deleteStudentDetails.do?registrationId=${cat.registrationId}" onclick="return confirm('Please confirm if you want to delete this Details!');">Delete</a>
        </display:column>
            </c:if>
      </display:table>
    </div>
  </div>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
</body>
</html>
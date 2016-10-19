<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Add Courses</title>
<style>
.basic-table {
  width: 150%;
}
</style>
</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
      <c:set var="count" value="0" scope="page" />
      <p>&nbsp;</p>
      <display:table name="enquiryList" pagesize="10" class="basic-table" uid="cat" requestURI="viewEnquiryDetails.do">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" class="showHeading" style=" width:1%;">
     ${count}
    </display:column>
        <display:column property="name" title="NAME" />
        <display:column property="emailId" title="EMAIL_ID" />
        <display:column property="mobileNo" title="MOBILE No." />
        <display:column property="comment" title="COMMENT" />
        <display:column property="date" title="DATE" />
        <display:column property="subject" title="SUBJECT" />
      </display:table>
    </div>
  </div>
</body>
</html>
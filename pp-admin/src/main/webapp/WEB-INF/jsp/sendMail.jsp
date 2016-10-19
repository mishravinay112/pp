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
  width: 100%;
}
</style>
<script type="text/javascript">
  $(document).ready(function() {
    var email = "${emailId}";
    document.getElementById("emailId").value = email;
  });
function emailCheck(){
var emailId = document.getElementById('emailId').value;
var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(emailId!=null && emailId!='')
if (!pattern.test(emailId)) {
	alert("please enter valid email");
	return false;
}
}
</script>

</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
      <form:form method="POST" action="sendEmail.do" modelAttribute="Registration" enctype="multipart/form-data">
        <table width="100%" border="0">
          <tr>
            <td><div class="form-control">
                <label>

                  <h3 style="color: #873d80;">Send e-mail with attachments</h3> <small class="required"></small> </label> <label>
                  <form:checkbox path="allStudent" value="allstudent" id="student" /> All Student<small
                  class="required"></small> </label>&nbsp; &nbsp; <label> <form:checkbox path="allEnquiry"
                    value="allenquiry" id="enquiry" /> All Enquiry<small class="required"></small> </label>
              </div></td>
          </tr>
          <tr>
            <td><div class="form-control">
            <form:errors path="emailId" class="label error-label"></form:errors>
                <label>
                  <p>
                    Email To:<small class="required"></small>
                  </p> <form:input path="emailId" class="inputControl1" placeholder="Email Address" maxlength="80"
                    id="emailId" /> </label>
              </div></td>
          </tr>
          <tr>
            <td><div class="form-control">
                <label>
                  <p>
                    Subject<small class="required"></small>
                  </p> <form:input path="subject" class="inputControl1" placeholder="Subject" required="autofocus"
                    maxlength="50" /> </label>
              </div></td>
          </tr>
          <tr>
            <td><div class="form-control">
                <label>
                  <p>
                    Message<small class="required"></small>
                  </p> <form:textarea path="message" cols="50" rows="10" /> </label>
              </div></td>
          </tr>
          <tr>
            <td><div class="form-control">
                <label>
                  <p>
                    Attach file:<small class="required"></small>
                  </p> <input type="file" name="attachFile" size="60" />
                   </label>
              </div></td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit" value="Submit" class="btn lg-btn" onclick=" return emailCheck();" />
            </td>
          </tr>
        </table>
      </form:form>
    </div>
  </div>
</body>
</html>
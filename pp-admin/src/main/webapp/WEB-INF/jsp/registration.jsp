<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval
	expression="@propertyConfigurer.getProperty('pp.jspImagePath')"
	var="imgPath" />
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script type="text/javascript" src="js/page-js/registration.js"></script>
<title>Student Registration</title>
<script type="text/javascript" src="js/page-js/registration.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery.datetimepicker.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui-1.9.1.custom.min.css" />
<script type="text/javascript">
	function imgvalue() {
		var src = $("#preview").attr("src");
		$('#imagePath').attr("value", src);
	}
	$(document)
			.ready(
					function() {
						if ("${Registration.registrationId}" != "") {
							document.getElementById("preview").src = "${imgPath}${Registration.registrationId}.png";
						} else {
							document.getElementById("preview").src = "${imgPath}default.jpg";
						}
					});
</script>
</head>
<body>
	<div class="container clearfix">
		<div class="conact-form">
			<h3 style="color: red;">${message}</h3>
			<p>&nbsp;</p>
			<form:form method="POST" action="registerStudent.do"
				modelAttribute="Registration" autocomplete="off">
				<h4>
					<b>Please browse student image</b>
				</h4>
				<div id="fileinfo">
					<div id="filename"></div>
					<div id="filesize"></div>
					<div id="filetype"></div>
					<div id="filedim"></div>
				</div>
				<div id="error">You should select valid image files only!</div>
				<div id="error2">An error occurred while uploading the file</div>
				<div id="abort">The upload has been canceled by the user or
					the browser dropped the connection</div>
				<div id="warnsize">Your file is very big. We can't accept it.
					Please select more small file</div>
				<div id="progress_info">
					<div id="upload_response"></div>
				</div>
				<img id="preview" src="" onerror="this.src='${imgPath}image.jpg'" />
				<div>
					<div>
						<input type="file" name="image_file" id="image_file"
							onchange="fileSelected();" />
					</div>
				</div>
				<form:hidden path="imgPath" id="imagePath" />
				<table width="100%" border="0">
					<tr>
						<td><div class="form-control">
								<form:errors path="firstName" class="label error-label"></form:errors>
								<label>
									<p>
										First Name<small class="required">*</small>
									</p> <form:input path="firstName" class="inputControl"
										placeholder="First Name" required="autofocus" maxlength="30"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
						<form:hidden path="registrationId" />
						<td><div class="form-control">
								<form:errors path="lastName" class="label error-label"></form:errors>
								<label>
									<p>
										Last Name<small class="required"></small>
									</p> <form:input path="lastName" class="inputControl"
										placeholder="Last Name" required="autofocus" maxlength="30"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
					</tr>

					<tr>
						<td><div class="form-control">
								<form:errors path="state" class="label error-label"></form:errors>
								<label>
									<p>
										State<small class="required">*</small>
									</p> <form:input path="state" class="inputControl"
										placeholder="State" required="autofocus" maxlength="50"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
						<td><div class="form-control">
								<form:errors path="city" class="label error-label"></form:errors>
								<label>
									<p>
										City<small class="required">*</small>
									</p> <form:input path="city" class="inputControl"
										placeholder="City" required="autofocus" maxlength="50"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
					</tr>

					<tr>
						<td><div class="form-control">
								<form:errors path="emailId" class="label error-label"></form:errors>
								<label>
									<p>
										Email Id<small class="required">*</small>
									</p> <form:input path="emailId" class="inputControl"
										placeholder="Email Id" required="autofocus" maxlength="100" />
								</label>
							</div></td>
						<td><div class="form-control">
								<form:errors path="dateOfBirth" class="label error-label"></form:errors>
								<label>
									<p>
										Date Of Birth<small class="required">*</small>
									</p> <form:input path="dateOfBirth" id="datepick"
										class="inputControl" placeholder="Date Of Birth"
										required="autofocus" maxlength="30" readonly="true" />
								</label>
							</div></td>
					</tr>
					<tr>
						
							<td><div class="form-control">
								<form:errors path="qualification" class="label error-label"></form:errors>
								<label>
									<p>
									Qualification<small class="required"></small>
									</p> <form:input path="qualification" class="inputControl"
										placeholder="Qualification" required="autofocus" maxlength="30"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
							<td><div class="form-control">
								<form:errors path="year.yearId" class="label error-label"></form:errors>
								<label>
									<p>
										Passout Year<small class="required">*</small>
									</p> <form:select path="year.yearId" class="inputControl">
										<form:option value="0" label="Select" />
										<c:forEach items="${year}" var="refYear">
											<form:option value="${refYear.yearId}"
												label="${refYear.year}" />
										</c:forEach>
									</form:select>
								</label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">
								<form:errors path="course.courseId" class="label error-label"></form:errors>
								<label>
									<p>
										Course<small class="required">*</small>
									</p> <form:select path="course.courseId" class="inputControl"
										id="courseId">
										<form:option value="0" label="Select" />
										<c:forEach items="${course}" var="refCourse">
											<form:option value="${refCourse.courseId}"
												label="${refCourse.courseName}" />
										</c:forEach>
									</form:select>
								</label>
							</div></td>
							<td><div class="form-control">
								<form:errors path="contact" class="label error-label"></form:errors>
								<label>
									<p>
										Contact<small class="required">*</small>
									</p> <form:input path="contact" class="inputControl"
										placeholder="Contact" required="autofocus" maxlength="10" onkeypress="return onlyNos(event,this);" />
								</label>
							</div></td>
							
							
					</tr>
					
					<tr>
					<!-- 26/11 -->
							<td><div class="form-control">
							<form:errors path="currentStatus.current_status_Id" class="label error-label"></form:errors>
								<label>
									<p>
										Current Status<small class="required">*</small>
									</p> <form:select path="currentStatus.current_status_Id" class="inputControl">
										<form:option value="0" label="Select" />
										<c:forEach items="${currentStatus}" var="refcurrentStatus">
											<form:option value="${refcurrentStatus.current_status_Id}"
												label="${refcurrentStatus.currentStatus}" />
										</c:forEach>
									</form:select>
								</label>
							</div></td>
					
					
					
						<td><div class="form-control">
								<form:errors path="courseFee" class="label error-label"></form:errors>
								<label>
									<p>
										Course Fee<small class="required"></small>
									</p> <form:input path="courseFee" class="inputControl"
										id="courseFee" readonly="true" maxlength="6" required="autofocus" />
								</label>
							</div></td>
					</tr>
					<!--reference text field  -->
					<td><div class="form-control">
								<form:errors path="reference" class="label error-label"></form:errors>
								<label>
									<p>
										Reference<small class="required">*</small>
									</p> <form:input path="reference" class="inputControl"
										placeholder="reference" required="autofocus" maxlength="50"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
							<!--handled by text field  -->
						<td><div class="form-control">
								<form:errors path="handledBy" class="label error-label"></form:errors>
								<label>
									<p>
										Handled By<small class="required">*</small>
									</p> <form:input path="handledBy" class="inputControl"
										placeholder="HandledBy" required="autofocus" maxlength="50"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
						<%-- 	<!--remark TextArea -->
							<td><div class="form-control">
								<form:errors path="remark" class="label error-label"></form:errors>
								<label>
									<p>
										Remark<small class="required"></small>
									</p> <form:textarea path="remark" class="inputControl"
										placeholder="Remark Max 100 Words" required="autofocus" maxlength="100"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td> --%>
							
					<tr>
					
						<td><div class="form-control">
								<label>
									<p>
										Discount in Percentage or RS.<small class="required"></small>
									</p> <input type="radio" name="dis" value="percentage"
									checked="checked">&nbsp;Percentage
								</label> <label><input type="radio" name="dis" value="rs">&nbsp;RS
								</label>
							</div></td>
						<td><div class="form-control">
								<form:errors path="discount"  class="label error-label"></form:errors>
								<label>
									<p>
										Discount<small class="required"></small>
									</p> <form:input path="discount" class="inputControl" id="discount"
										placeholder="Discount" onblur="return discountAmount() "
										onkeypress="return onlyNos(event,this);" maxlength="6" />
								</label>
							</div></td>
					</tr>
					
					<tr>
						<td><div class="form-control">
								<form:errors path="totalFee" class="label error-label"></form:errors>
								<label>
									<p>
										Total Fee<small class="required"></small>
									</p> <form:input path="totalFee" class="inputControl"
										placeholder="Total Fee" id="totalFee" readonly="true" />
								</label>
							</div></td>
						<td><div class="form-control">
								<form:errors path="submittedFee" class="label error-label"></form:errors>
								<label>
									<p>
										Submitted Fee<small class="required">*</small>
									</p> <form:input path="submittedFee" class="inputControl"
										placeholder="Submitted Fee" required="autofocus"
										onfocus="return discountAmount()"
										onkeypress="return onlyNos(event,this);" maxlength="6" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">
								<form:errors path="batch.batchId" class="label error-label"></form:errors>
								<label>
									<p>
										Batch<small class="required">*</small>
									</p> <form:select path="batch.batchId" class="inputControl">
										<form:option value="0" label="Select" />
										<c:forEach items="${batch}" var="refBatch">
											<form:option value="${refBatch.batchId}"
												label="${refBatch.batchName}" />
										</c:forEach>
									</form:select>
								</label>
							</div></td>
						<td><div class="form-control">
								<form:errors path="parentContact" class="label error-label"></form:errors>
								<label>
									<p>
										Parent Contact<small class="required"></small>
									</p> <form:input path="parentContact" class="inputControl"
										placeholder="Contact Number" required="autofocus"
										maxlength="11" onkeypress="return onlyNos(event,this);" />
								</label>
							</div></td>
							
					</tr>
					<!--remark TextArea -->
							<td><div class="form-control">
								<form:errors path="remark" class="label error-label"></form:errors>
								<label>
									<p>
										Remark<small ></small>
									</p> <form:textarea path="remark" class="inputControl"
										placeholder="Remark Max 100 Words" required="autofocus" maxlength="100"
										 />
								</label>
							</div></td>
					<tr>
						<td colspan="2"><input type="submit" value="Submit"
							class="btn lg-btn" onclick="imgvalue()" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js"
		charset="utf-8"></script>
	<script type="text/javascript" src="js/page-js/commonDate.js"
		charset="utf-8"></script>
</body>
</html>
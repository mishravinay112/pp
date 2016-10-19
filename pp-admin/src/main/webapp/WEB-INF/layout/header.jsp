<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home</title>
<!--stylesheet begins here -->
<link rel="stylesheet" type="text/css" href="css/reset.css" media="all">
<link rel="stylesheet" type="text/css" href="fonts/font-class.css" media="all">
<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<!--javascript libraries begins here -->
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<!--javascript libraries ends here -->
<!-- <script type="text/javascript">
    function preventBack(){window.history.forward();}
     setTimeout("preventBack()", 0);
     window.onunload=function(){null};
</script> -->
</head>
<body>
  <!--header starts here-->
  <header> <section class="top-header">
  <div class="container clearfix">
    <ul class="contact-info">
      <li><i class="icon icon-email"></i><a href="mailto:hrd@prestigepoint.in">hrd@prestigepoint.in</a>
      </li>
      <li><i class="icon  icon-call"></i> 91-731-3087869</li>
    </ul>
    <div class="registration-alert">
      <font color="#873d80">WELCOME TO ADMIN PANEL</font>
    </div>
  </div>
  </section> <section class="main-header">
  <div class="container clearfix bottom-border">
    <nav>
    <ul>
      <c:if test="${sessionScope.login!=null}">
        <li><font color="#873d80"><c:out value="Welcome, ${sessionScope.login.emailId}" /> </font>
        </li>
        </li>
      </c:if>
    </ul>
    <br />
    <p>&nbsp;</p>
    <ul>
      <li><a href="welcome.do">Home</a></li>
      <li><c:if test="${sessionScope.login.adminType==1||sessionScope.login.adminType==2}">
			Add Master
				<ul>
            <li><a href="addCourse.do">Add Courses</a>
            </li>
            <li><a href="addBatch.do">Add Batch</a>
            </li>

            <c:if test="${sessionScope.login.adminType==1}">
              <li><a href="signup.do">Add User</a>
              </li>
            </c:if>

            <li><a href="addFooterPhoto.do">Footer View</a>
            </li>
            <li><a href="scrollerView.do">Banner Image</a>
            </li>
            <li><a href="currentBatch.do">Current Batch</a>
            </li>
            <li><a href="addAdminEnquiry.do">Admin Enquiry</a>
           <!--  </li>
            <li><a href="addPlacedStudent.do">AddPlacedStudent</a>
            </li> -->
            <li><a href="addChallenge.do">AddChallenge</a>
            </li>

          </ul>
        </c:if>
      </li>
      <li><a href="registration.do">Registration</a></li>
      <li>View Master
        <ul>
          <li><a href="viewStudentDetails.do">View Student Details</a></li>
          <li><a href="viewEnquiryDetails.do">View Enquiry</a></li>
          <li><a href="viewPlacedStudent.do">ViewPlacedStudent</a>
          </li>

        </ul>
      </li>
      <li><a href="sendMail.do">Send Mail</a>
      </li>
      
      <li><a href="javascript:;">Reports</a>
        <ul>
          <li><a href="javascript:;">Enquiry Report</a>
            <ul>
              <li><a href="viewEnquiryByMonth.do">By Month</a></li>
            </ul>
          </li>
           
        </ul>
       </li>
      <li><a href="javascript:;">More Options</a>
        <ul>
          <!--  <li><a href="uploadBanner.do">Upload Banner Image</a></li>	 -->
          <li><a href="upload.do">Upload Jar</a>
          </li>
          <li><a href="javascript:;">Question & Answer</a>
            <ul>
              <li><a href="questionAndAnswer.do">Simple Question</a></li>
              <li><a href="differenceQuestion.do">Difference Question</a>
              </li>
            </ul>
          </li>
        </ul>
      </li>
      <c:if test="${sessionScope.login!=null}">
        <li><font color="#873d80"><a href="logout.do">Logout</a> </font></li>
      </c:if>

    </ul>
    </nav>
    <div class="brand-logo">
      <a href="welcome.do"><img src="img/logo-prestige-point.png" alt="Brand Logo"> </a>
    </div>
  </div>
  </section> </header>
  <!--header ends here-->

</body>
</html>
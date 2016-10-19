function validate() {
    var e = document.getElementById("password").value,
        d = document.getElementById("confirmPassword").value;
    return e != d ? (alert("Password and Confirm Password Should be Same"), !1) : !0
}

/**
 * 
 */
function enableChallengeStatus(challengeDetails) {
	var challengeId = challengeDetails.id;
	var challengeValue = challengeDetails.value;
	var challengeIdValue = document.getElementById(challengeId).checked;
	
	$.ajax({
		url : "changeActiveStatusAction.do?challengeValue=" + challengeValue
				+ "&challengeIdValue=" + challengeIdValue,
		type : "GET",
		contentType : "application/json; charset=utf-8",
		success : function(call) {
		},
		error : function() {
		}
	})
}

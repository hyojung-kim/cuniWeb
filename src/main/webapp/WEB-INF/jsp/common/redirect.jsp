<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
var alertMsg = '${alertMsg}'.trim();
var historyBack = '${historyBack}' == 'true';
var locationReplaceUrl = '${locationReplace}'.trim();

if ( alertMsg ) {
	alert(alertMsg);
}

if (historyBack) {
	history.back();
}

if ( locationReplaceUrl ) {
	location.replace(locationReplaceUrl);
}
</script> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>

	<div
		style="float: left; width: 50%; height: 20%; background-Color: #F2FFFF">
		<table id="resultTeble" border="1">
		<tr>
			<td>enroll_scan_beaconㅏ</td>
			<td>enroll_scan_beacon2ㅏ</td>
		</tr>
	</table>
	</div>

	<div
		style="clear: right; float: right; width: 50%; height: 20%; background-Color: #FFF2FF">
	</div>

	<div
		style="float: left; width: 50%; height: 60%; background-Color: #FFFFF2">
	</div>

	<div
		style="clear: right; float: right; width:50%; height: 60%; background-Color: #EFEFEF">
	</div>

	<input type="text" value="2109059_01" id="center_code">
	<input type="button" value="테스트" onclick="Delbtt_click()">

	


	<script>
		function Delbtt_click() {

			$.ajax({
				url : 'enroll_list',
				dataType : 'json',
				type : 'POST',
				data : {
					"center_code" : $("#center_code").val()
				},
				success : function(result) {
					console.log("성동");
					var size_data = result.list;
					console.log(result);
					for (var i = 0; i < size_data.length; i++) {
						// console.log(result.list[i].beacon_mac);
						//$("#resultTeble").append("<tr><td>"+result.list[i].beacon_mac+"</td><td>"+result.list[i].beacon_uuid+"</td></tr>");

					}
				},
				error : function(request, status, error) {

					console.log("안댄다마");
				}

			});
		}
	</script>
	<!-- 삭제 버튼 클릭시 ajax비동기 삭제  -->
</body>
</html>

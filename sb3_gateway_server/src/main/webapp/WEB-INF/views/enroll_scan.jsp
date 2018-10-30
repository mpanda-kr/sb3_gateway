<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
	
	<input type="text" value="2109059_01" id="center_code">
	<input type="button" value="테스트" onclick="Delbtt_click()">
	
	<table id="resultTeble">
		<tr>
			<td>으아아앙아ㅏ</td><td>으아아앙아2ㅏ</td>
		</tr>	
	</table>


   <script>       
   function Delbtt_click() {   
     
         $.ajax({  
               url : 'check',
               dataType : 'json',
               type:'POST',
               data : { "center_code" : $("#center_code").val()},              
               success: function(result) {                   
            	   var size_data=result.list;
                   
                   for(var i=0; i <size_data.length; i ++){
                	  console.log(result.list[i].beacon_mac);
                	   $("#resultTeble").append("<tr><td>"+result.list[i].beacon_mac+"</td><td>"+result.list[i].beacon_uuid+"</td></tr>");

                   }
               },
               error:function(request,status,error){                 
                 
               }
            
           });    
     }
   
   </script> <!-- 삭제 버튼 클릭시 ajax비동기 삭제  -->   
</body>
</html>

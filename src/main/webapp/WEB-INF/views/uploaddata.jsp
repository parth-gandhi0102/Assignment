   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Customer List</h1>  <a href="dashBoardData.htm">Dashboard</a>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>AGE</th><th>DOB</th><th>Month</th></tr>  
   <c:forEach var="custList" items="${custList}">   
   <tr>  
   <td>${custList.custId}</td>  
   <td>${custList.name}</td>  
   <td>${custList.age}</td>  
   <td>${custList.date}</td>  
   <td>${custList.month}</td>
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
     
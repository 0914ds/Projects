<%@ page contentType="text/html;charset=UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

	
<div class="tree">
	<ul>

		<c:forEach var="node" items="${sessionScope.LOGIN_INFO.menu}">
		 
			<c:if test="${node.lvNum== 1}">
				<li id="id${node.functionCode}">
				   <%int i=0;%>
						<c:forEach var="node3" items="${sessionScope.LOGIN_INFO.menu}">
						  <c:if test="${fn:split(node3.functionCode,'.')[0]==node.functionCode&&node3.functionCode!= node.functionCode}">
						    <%i=1;%>
						  </c:if>
						</c:forEach>
						<!--   有二级菜单的  -->
						 <%if(i==1){ %>
						    <div id="tree_li_${node.functionCode}" class="parent_li_title">
						       <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
						       <span class="parent_li_has">${node.functionCode} ${node.functionName}</span>
						       <span class="glyphicon glyphicon-triangle-bottom glyphicon_arrow" aria-hidden="true"></span>
						    </div>
			   			<ul>
						   <c:forEach var="node2" items="${sessionScope.LOGIN_INFO.menu}">
							  <c:if test="${fn:split(node2.functionCode,'.')[0]==node.functionCode&&node2.functionCode!= node.functionCode}">
								<li>
							
							<%--	<c:if test="${node2.path==''}">
								 <a href="#"> 
								</c:if>
								<c:if test="${node2.path!=''}">
								   <a href="${ctx}/${node2.path}">   
								 <a href="#" onclick="asyncLoad('${ctx}/${node2.path}');return false;"> 
								</c:if>
								${node2.functionCode} ${node2.functionName}</a></li>
							</c:if>
						</c:forEach>
					</ul> --%> 
								    <c:if test="${node2.path==''}"><a href="#"><span> </c:if>
								    <c:if test="${node2.path!=''}"><a href="${ctx}/${node2.path}"> <span></c:if>
								    ${node2.functionCode} ${node2.functionName}</span></a>
								</li>
							  </c:if>
						   </c:forEach>
				    	</ul> 
						 <%}else{%>
						<a href="${ctx}/${node.path}">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						<span class="parent_li_none">${node.functionCode} ${node.functionName} </span>
						</a><%}%>
				</li>
			</c:if>
			 
		</c:forEach> 
		
	</ul>
</div>

<div class="col-sm-3 col-md-2 sidebar">
	<a href="create" class="btn btn-danger btn-sm btn-block" role="button">Create New Task</a><hr/>
	<ul class="nav nav-sidebar navnav-pills">
		<li><a href="<%=request.getContextPath()%>/TodolistServlet/"><span class="badge pull-right"><%=application.getAttribute("num_of_items") %></span> Tasks <span class="sr-only">(current)</span></a></li>
		<li><a href="<%=request.getContextPath()%>/TodolistServlet/completed"><span class="badge pull-right"><%=application.getAttribute("num_of_completed") %></span> Completed</a></li>
		<li><a href="<%=request.getContextPath()%>/TodolistServlet/pending"><span class="badge pull-right"><%=application.getAttribute("num_of_pending") %></span> Pending</a></li>
	</ul>
	
	<%
	if(session.getAttribute("username").equals("admin")) {
	%>
	<ul class="nav nav-pills nav-stacked">
		<li><a href="<%=request.getContextPath()%>/TodolistServlet/admin">Admin</a></li>
	</ul>
	<%
	}
	%>
	<h4>Last login:</h4>
	<p><%=session.getAttribute("lastlogin") %></p>
	
</div>



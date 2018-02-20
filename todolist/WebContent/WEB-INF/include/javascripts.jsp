<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%=request.getContextPath()%>/libs/js/jquery-3.2.1.min.js"></script>
<script src="<%=request.getContextPath()%>/libs/js/moment.js"></script>
<script src="<%=request.getContextPath()%>/libs/bootstrap/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="<%=request.getContextPath()%>/libs/bootstrap/ie10-viewport-bug-workaround.js"></script>



<script>

	// get current URL path and assign 'active' class
	var pathname = window.location.pathname;
	$('.nav > li > a[href="'+pathname+'"]').parent().addClass('active');

</script>
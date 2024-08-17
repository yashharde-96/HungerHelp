<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid">
<h5 class="p-2">Agent Profile</h5>
<div class="container">
	<div class="row">
		<div class="col-sm-8">
			<table class="table table-bordered">
				<tr>
					<th>Name</th>
					<th>${p.name }</th>
				</tr>
				<tr>
					<th>Age</th>
					<th>${p.age } years</th>
				</tr>
				<tr>
					<th>Gender</th>
					<th>${p.gender }</th>
				</tr>
				<tr>
					<th>Email Id</th>
					<th>${p.email }</th>
				</tr>
				<tr>
					<th>Phone</th>
					<th>${p.phone }</th>
				</tr>
				<tr>
					<th>Address</th>
					<th>${p.address }</th>
				</tr>
			</table>
		
		</div>
	</div>
</div>
</div>
</body>
</html>
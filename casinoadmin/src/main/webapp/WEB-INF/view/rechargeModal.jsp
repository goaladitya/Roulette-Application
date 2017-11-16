<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="modal fade" id="rechargeModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Recharge Balance</h4>
			</div>
			<div class="modal-body">
				<spring:url value="/recharge" var="action" />
				<form:form action="${action}" method="POST"
					modelAttribute="rechargeBalance">
					<div class="form-group row">
						<label for="id" class="col-sm-2 col-form-label">User Id</label>
						<div class="col-sm-10">
							<form:input type="number" class="form-control" id="id" path="id" readonly="true"></form:input>
						</div>
					</div>
					<div class="form-group row">
						<label for="balance" class="col-sm-2 col-form-label">Amount</label>
						<div class="col-sm-10">
							<form:input type="number" class="form-control" id="balance"
								path="balance" value="500"></form:input>
						</div>
					</div>
					<div class="d-flex justify-content-center">
						<button type="submit" class="btn" style="background-color:#ff1493">Recharge</button>
					</div>
				</form:form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>
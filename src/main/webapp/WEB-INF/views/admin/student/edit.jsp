<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/student" />
<c:url var="redirectUrl" value="quan-tri/list" />
<html>

<head>
<title>Chỉnh sửa bài viết</title>
</head>

<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Chỉnh sửa thông tin</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">${messageResponse}</div>
						</c:if>
						<form id="formSubmit">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tên
									học sinh</label>
								<div class="col-sm-9">
									<c:if test="${not empty model.id}">
										<input type="text" class="form-control" id="fullName"
											name="fullName" value="${model.fullName}" />
									</c:if>
									<c:if test="${empty model.id}">
										<input type="text" class="form-control" id="fullName"
											name="fullName" value="" />
									</c:if>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Địa
									chỉ</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="address"
										name="address" value="${model.address}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tuổi</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="age" name="age"
										value="${model.age}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Giới
									tính</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="gender"
										name="gender" value="${model.gender}" />
								</div>
							</div>
							<c:if test="${model.code=='teacher'}">
								<br />
								<br />
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Mức lương</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="salary"
											name="salary" value="${teacher.salary}" />
									</div>
								</div>
								<br />
								<br />
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Kinh nghiệm</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="experience"
											name="experience" value="${teacher.experience}" />
									</div>
								</div>
								<br />
								<br />
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Môn dạy</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="subject"
											name="subject" value="${teacher.subject}" />
									</div>
								</div>

							</c:if>
							<br /> <br /> <br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.id}">
										<c:if test="${model.code=='teacher'}">
											<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật giáo viên" id="btnAddOrUpdateNew" />
										</c:if>
										<c:if test="${model.code=='student'}">
											<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật học sinh" id="btnAddOrUpdateNew" />
										</c:if>
									</c:if>
									<c:if test="${empty model.id}">
									<c:if test="${model.code=='teacher'}">
											<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật giáo viên" id="btnAddOrUpdateNew" />
										</c:if>
										<c:if test="${model.code=='student'}">
											<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật học sinh" id="btnAddOrUpdateNew" />
										</c:if>
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Thêm người dùng" id="btnAddOrUpdateNew" />
									</c:if>
								</div>
							</div>
							<input type="hidden" value="${model.id}" id="id" name="id" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<script>
		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			var id = $('#id').val();
			if (id == "") {
				addStudent(data);
			} else {
				updateStudent(data);
			}
		});

		function addStudent(data) {
			$
					.ajax({
						url : '${APIurl}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${redirectUrl}?type=student&messageResponse=Insert_Success&alert=success";
						},
						error : function(error) {
							window.location.href = "${redirectUrl}?type=student&messageResponse=Insert_Failed&alert=danger";
						}
					});
		}
		function updateStudent(data) {
			$
					.ajax({
						url : '${APIurl}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${redirectUrl}?type=student&messageResponse=Update_Success&alert=success";
						},
						error : function(error) {
							window.location.href = "${redirectUrl}?type=student&messageResponse=Update_Failed&alert=danger";
						}
					});
		}
	</script>
</body>

</html>
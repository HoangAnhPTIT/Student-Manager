<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<div class="main-content">
		<form action="<c:url value='/admin-new'/>" id="formSubmit"
			method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${param.messageResponse!=null}">
								<div class="alert alert-${param.alert}">${param.messageResponse}</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm người dùng'
												href='<c:url value="/student-admin?type=edit&id"/>'> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
											<button id="btnDelete" type="button"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa người dùng'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th><input type="checkbox" id="checkAll"></th>
													<th>Tên học sinh</th>
													<th>Địa chỉ</th>
													<th>Tuổi</th>
													<th>Giới tính</th>
													<c:if test="${param.type=='teacher'}">
														<th>Môn dạy</th>
														<th>Kinh nghiệm</th>
														<th>Mức lương</th>
													</c:if>
													<th>Thao tác</th>
													
												</tr>
											</thead>
											<tbody>
												<c:if test="${param.type=='student'}">
													<c:set var="user" value="${model.listStudent}"/>
												</c:if>
												<c:if test="${param.type=='teacher'}">
													<c:set var="user" value="${model.listTeacher}"/>
												</c:if>
												<c:forEach var="item" items="${user}">
													<tr>
														<td><input type="checkbox" id="checkbox_${item.id}"
															value="${item.id}"></td>
														<td>${item.fullName}</td>
														<td>${item.address}</td>
														<td>${item.age}</td>
														<td>${item.gender}</td>
														<c:if test="${param.type=='teacher'}">
															<td>${item.subject}</td>
															<td>${item.experience}</td>
															<td>${item.salary}</td>
														</c:if>
														<td><c:url var="editURL" value="/student-admin">
																<c:param name="type" value="edit" />
																<c:param name="id" value="${item.id}" />
															</c:url> <a class="btn btn-sm btn-primary btn-edit"
															data-toggle="tooltip" title="Cập nhật bài viết"
															href='${editURL}'><i class="fa fa-pencil-square-o"
																aria-hidden="true"></i> </a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
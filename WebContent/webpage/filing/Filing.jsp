<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/common/lable.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>案件归档</title>
<link rel="shortcut icon" href="${ctxStatic}/frame/H+/favicon.ico">
<link href="${ctxStatic}/frame/H+/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="${ctxStatic}/frame/H+/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<!-- Data Tables -->
<link href="${ctxStatic}/frame/H+/css/plugins/dataTables/dataTables.bootstrap.css"rel="stylesheet">
<link href="${ctxStatic}/frame/H+/css/animate.min.css" rel="stylesheet">
<link href="${ctxStatic}/frame/H+/css/style.min.css?v=4.0.0" rel="stylesheet">
<base target="_blank">

<script>
	$(function(){
		$("#getFiling").click(function(){
			alert("good");
			$.ajax({
				url:"${ctx}/filing/getFiling",
				type:"post",
				dataType:"json",
				success:function(result){
					alert(result);
					window.location.reload();
				}
			});
		});
	});
	
	function getFiling(){
		alert("good+1");
		$.ajax({
			url:"${ctx}/filing/getFiling",
			type:"post",
			dataType:"text",
			scriptCharset:'utf-8',
			success:function(result){
				alert(result);
				window.location.replace("${ctx}/filing/goFiling");
			}
		});
	}
</script>

</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>
							基本 <small>分类，查找</small>
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="table_data_tables.html#">
							</a>
							<a class="close-link"> <i class="fa fa-times"></i></a>
						</div>
					</div>
					<div class="ibox-content">
						<a href="javascript:void(0)" onclick="getFiling()">拉取案件</a>  
						<table
							class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>序号</th>
									<th>案件号</th>
									<th>当事人</th>
									<th>登记时间</th>
									<th>立案时间</th>
									<th>结案时间</th>
									<th>案件分类</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${zfLawCaseInfoList}" var="zfLawCaseInfo">
									<tr class="gradeX">
										<td>${zfLawCaseInfo.sid}</td>
										<td>${zfLawCaseInfo.seqnum}</td>
										<td>${zfLawCaseInfo.people}</td>
										<td class="center"><fmt:formatDate type="time" value="${zfLawCaseInfo.regisdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
										<td class="center"><fmt:formatDate type="time" value="${zfLawCaseInfo.setupdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
										<td class="center"><fmt:formatDate type="time" value="${zfLawCaseInfo.endcasedate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
										<td class="center">${zfLawCaseInfo.eventid}</td>
										<td class="center"><a href="">详情</a>&nbsp;<a href="">归档</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${ctxStatic}/frame/H+/js/jquery.min.js?v=2.1.4"></script>
	<script src="${ctxStatic}/frame/H+/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="${ctxStatic}/frame/H+/js/plugins/jeditable/jquery.jeditable.js"></script>
	<script src="${ctxStatic}/frame/H+/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="${ctxStatic}/frame/H+/js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script src="${ctxStatic}/frame/H+/js/content.min.js?v=1.0.0"></script>
	<script>
		$(document).ready(function() {
			$(".dataTables-example").dataTable();
			
		});
	</script>
	<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>
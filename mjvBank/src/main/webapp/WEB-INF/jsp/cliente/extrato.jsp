<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Meus Dados</title>
		
		<!-- JQUERY -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script type="text/javascript" src="/js/jquery.mask.min.js"></script>
		
		<!-- BOOTSTRAP -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		
	</head>
	<body>
	
		<header>
			<nav class="navbar navbar-light bg-light">
			  <span class="navbar-brand mb-0 h1">MJV Bank</span>
			</nav>
		</header>
		
		<div class="container" style="width :70%; padding-bottom: 30px;">
		
			<nav aria-label="breadcrumb">
			  <ol class="breadcrumb" style="background-color: white; padding-left: 0px;">
			     <li class="breadcrumb-item" aria-current="page"><a href='/cliente/<c:out value="${id}" />'>Home</a></li>
			     <li class="breadcrumb-item active" aria-current="page">Extrato</li>
			  </ol>
			</nav>
			
			<form action='/cliente/<c:out value="${id}" />/extrato' method="get">
			  	<div class="form-row" style="width: 40%">
			    	<div class="form-group col-md-5">
			      		<label for="dataInicio">Data Início</label>
			      		<input type="text" class="form-control filtrodata" id="dataInicio" name="dataInicio" value='<c:out value="${dataInicio}" />' />
			    	</div>
			    	<div class="form-group col-md-5">
			      		<label for="dataFim">Data Fim</label>
			      		<input type="text" class="form-control filtrodata" id="dataFim" name="dataFim" value='<c:out value="${dataFim}" />' />
			    	</div>
			    	<div class="form-group col-md-2" style="padding-top: 32px">
			      		<button type="submit" class="btn btn-primary">Filtrar</button>
			    	</div>
			    	
			  	</div>
			</form>
			<div style="padding-top: 20px">
				<table class="table table-hover">
					<thead>
					  	<tr>
					    	<th scope="col">Data</th>
					     	<th scope="col">Descrição</th>
					      	<th scope="col">Valor</th>
					  	</tr>
				  	</thead>
				  	<c:if test="${empty operacoes}">
					  	<tbody>
					    	<tr>
						     	<td colspan="3" class="alert alert-info text-center" role="alert">
						     		<span>Não existem registros no período informado</span>
						     	</td>
					    	</tr>
					  	</tbody>
				  	</c:if>
				  	<c:if test="${not empty operacoes}">
					  	<tbody>
					  		<c:forEach var="op" items="${operacoes}">
						  		<tr>
							     	<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value = "${op.data}" /></td>
							      	<td><c:out value="${op.descricao}" /></td>
							      	
							      	<fmt:setLocale value = "pt_BR"/>
							      	<c:if test="${op.idTipoOperacao == 1}">
							      		<td><span style="color: green;"><fmt:formatNumber value="${op.valor}" type = "currency"/></span></td>
							      	</c:if>
							      	<c:if test="${op.idTipoOperacao != 1}">
							      		<td><span style="color: red;"><fmt:formatNumber value="${op.valor}" type = "currency"/></span></td>
							      	</c:if>
						    	</tr>
					  		</c:forEach>
					  	</tbody>
					</c:if>
				</table>
			</div>
		</div>
	</body>
	
	<script type="text/javascript">
		$(document).ready(function(){
			//$('.filtrodata').mask("00/00/0000", {placeholder: "__/__/____"});
			$('.filtrodata').mask("00/00/0000");
		});
	
	</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Transferência</title>
		
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
			     <li class="breadcrumb-item" aria-current="page"><a href='/cliente/<c:out value="${id}" />/operacao/transferencia'>Transferência</a></li>
			     <li class="breadcrumb-item active" aria-current="page">Confirmação</li>
			  </ol>
			</nav>
		
			<h1>Transferência Realizada</h1>
			
			<br />
			
			<h4>Dados da Transferência</h4>
			
			<div class="row">
				<div class="col-md-1">Data:</div>
				<div class="col-md text-muted"><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value = "${operacao.data}" /></div>
			</div>
			<div class="row">
				<div class="col-md-1">Para:</div>
				<div class="col-md text-muted"><c:out value="${operacao.cliente.nome}" /></div>
			</div>
			<div class="row">
				<div class="col-md-1">Agência:</div>
				<div class="col-md text-muted"><c:out value="${operacao.cliente.agencia}" /></div>
			</div>
			<div class="row">
				<div class="col-md-1">Conta:</div>
				<div class="col-md text-muted cc"><c:out value="${operacao.cliente.conta}" /></div>
			</div>
			<div class="row">
				<div class="col-md-1">Valor:</div>
				<fmt:setLocale value = "pt_BR"/>
				<div class="col-md text-muted"><fmt:formatNumber value="${operacao.valor}" type = "currency"/></div>
			</div>						
		</div>
	
	</body>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('.cc').mask("####0-0");
		});
	</script>
</html>
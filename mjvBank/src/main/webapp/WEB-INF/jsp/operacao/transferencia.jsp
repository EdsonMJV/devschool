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
		
		<div class="container" style="width :70%;">
		
			<nav aria-label="breadcrumb">
			  <ol class="breadcrumb" style="background-color: white; padding-left: 0px;">
			     <li class="breadcrumb-item" aria-current="page"><a href='/cliente/<c:out value="${cliente.id}" />'>Home</a></li>
			     <li class="breadcrumb-item active" aria-current="page">Transferência</li>
			  </ol>
			</nav>
			
			<form action='/cliente/<c:out value="${id}" />/operacao/transferencia' method="post">
				<input type="hidden" name="cliente.id" id="hdId" />
			
				<c:if test='${not empty mensagem}'>
					<div class="alert alert-danger alert-dismissible" style="padding-bottom: 30px;" role="alert">
						<c:out value="${mensagem}" />
					</div>
				</c:if>
				
			
			  	<h4>De:</h4>
			  	<div class="form-row">
			  		<div class="form-group col-md-2">
					    <label for="txtAgenciaDe">Agência</label>
					    <input type="text" class="form-control" value='<c:out value="${cliente.agencia}" />' id="txtAgenciaDe" readonly />
					</div>
					<div class="form-group col-md-3">
					    <label for="txtContaDe">Conta Corrente</label>
					    <input type="text" class="form-control cc" value='<c:out value="${cliente.conta}" />' id="txtContaDe" readonly />
					</div>
			  	</div>
			  	
			  	<br />
			  	
				<h4>Para:</h4>
				<div class="form-row">
					<div class="form-group col-md-2">
					    <input type="text" class="form-control" name="agenciaString" id="txtAgenciaPara" placeholder="Agência" onblur="buscarCliente();">
					</div>
					<div class="form-group col-md-3">
					    <input type="text" class="form-control cc" name="contaString" id="txtContaPara" placeholder="Conta Corrente" onblur="buscarCliente();">
					</div>
					<div class="form-group col-md-3">
					    <input type="text" class="form-control valor" name="valorString" id="txtValor" placeholder="Valor" onblur="habilitarSubmit()">
					</div>
				</div>
				
				<div class="form-row">
					<div class="form-group col-md-8 ">
						 <small class="form-text text-muted"><span id=nomeCliente></span></small>
					</div>
				</div>
				
				<br />
				
				<div class="form-row">
					<button type="submit" id="btnTransferir" class="btn btn-primary" disabled="disabled">Transferir</button>
				</div>
			</form>
		
		</div>
	</body>
	
	<style>
		.textovermelho {
			color: red;
		}
	</style>
	
	<script>
	$(document).ready(function(){
		$('.cc').mask("#0-0", {reverse: true});
		$('.valor').mask("#.##0,00", {reverse: true});
	});

	function habilitarSubmit() {
		if($('#hdId').val() == '' || $('#txtValor').val() == '') {
			$('#btnTransferir').attr('disabled', true);
		}
		else {
			$('#btnTransferir').attr('disabled', false);
		}
	}


	function buscarCliente() {
		
		$('#nomeCliente').html('');
		$('#hdId').val('');
		
		if($('#txtContaPara').val() == '' || $('#txtAgenciaPara').val() == '') {
			return;
		}
		
		$.ajax({
			method: "POST",
			url: '/cliente/buscarcliente',
			contentType: 'application/json',
			data: JSON.stringify({
				"cliente" : {
					"agencia" : $('#txtAgenciaPara').val().replace(/[^0-9]/g, ""),
					"conta" : $('#txtContaPara').val().replace(/[^0-9]/g, "")
				}
			}),
			success: function(data, textStatus, xhr) {
		        console.log(xhr.status);
		        console.log(data);
		        
		        $('#nomeCliente').html('<strong>' + data.nome + '</strong>');
		        $('#hdId').val(data.id);
		    	$('#nomeCliente').removeClass('textovermelho');
		    },
		    error: function (jqXhr, textStatus, errorMessage) {
		    	$('#nomeCliente').html("<i>Não foi encontrado nenhum cliente com essa agência/ conta</i>");
		    	$('#nomeCliente').addClass('textovermelho');
		    },
		    complete: function (jqXhr, textStatus, errorMessage) {
		    	habilitarSubmit();
		    }
		});
	}

	</script>
	
	
	
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		
		<!-- BOOTSTRAP -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		
		<style type="text/css">
			IMG.displayed {
			    display: block;
			    margin-left: auto;
			    margin-right: auto;
			    width: 50%; 
			    padding-top: 5px;
			}
		</style>
	</head>
	
	<body>
		<header>
			<nav class="navbar navbar-light bg-light">
			  <span class="navbar-brand mb-0 h1">MJV Bank</span>
			</nav>
		</header>
		
		<div class="container-fluid" style="width :70%; padding-bottom: 30px;">
			<nav aria-label="breadcrumb">
			  <ol class="breadcrumb" style="background-color: white; padding-left: 0px;">
				<li class="breadcrumb-item active" aria-current="page">Home</li>
			  </ol>
			</nav>
		
			<div class="row">
	    		<div class="col-sm" style="margin-bottom: 10px">
	    			<div class="card" style="width: 12rem;">
		    			<a href="/cliente/<c:out value="${cliente.id}" />/meusdados">
							<img class="card-img-top displayed" src="/img/dados.png" alt="Meus dados">
						  	<div class="card-body">
						    	<h5 class="card-title text-center">Meus Dados</h5>
							</div>
						</a>
					</div>
	    		</div>
	    		
	    		<div class="col-sm" style="margin-bottom: 10px">
	    			<div class="card" style="width: 12rem;">
		    			<a href="/cliente/<c:out value="${cliente.id}" />/extrato">
							<img class="card-img-top displayed" src="/img/nota.png" alt="Extrato">
						  	<div class="card-body">
						    	<h5 class="card-title text-center">Extrato</h5>
							</div>
						</a>
					</div>
	    		</div>
	    		
	    		<div class="col-sm" style="margin-bottom: 10px">
	    			<div class="card" style="width: 12rem;">
	    				<a href="/cliente/<c:out value="${cliente.id}" />/operacao/transferencia">
							<img class="card-img-top displayed" src="/img/transfer.png" alt="Transferencia">
						  	<div class="card-body">
						    	<h5 class="card-title text-center">Transferência</h5>
							</div>
						</a>
					</div>
	    		</div>
	    		
	    	</div>
		
		</div>
		
	</body>
</html>
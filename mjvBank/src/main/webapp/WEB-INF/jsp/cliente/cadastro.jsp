<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastro</title>
		
		<style type="text/css"  ></style>
		
		<!-- CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
		<!-- jQuery and JS bundle w/ Popper.js -->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
		
		<link rel="stylesheet" href="/css/bank.css">
	</head>

	<body>

		<h1 class="text-center" style="padding-top: 40px;">MJV Bank</h1>

		<div class="container" style="width: 40%; padding-top: 40px">
		    
		    <ul>
			    <c:forEach items="${mensagem}" var="msg">
					<li class="msgErro">${msg}</li>	    
			    </c:forEach>
		    </ul>
		    
			<form action="/cliente/cadastrar" method="post">
				<div class="form-group">
			    	<label for="formGroupExampleInput">Nome</label>
			    	<input type="text" name="nome" class="form-control" id="formGroupExampleInput" placeholder="Nome Completo">
			  	</div>
			  	<div class="form-group">
			    	<label for="formGroupExampleInput">Usuário</label>
			    	<input type="text" name="usuario" class="form-control" id="formGroupExampleInput" placeholder="Usuário para acesso">
			  	</div>
			  	<div class="form-group">
			    	<label for="formGroupExampleInput2">CPF</label>
			    	<input type="text" name="cpf" class="form-control" id="formGroupExampleInput2" placeholder="Número do CPF">
			  	</div>
			  	<div class="form-group">
			    <button type="submit" class="btn btn-primary">Cadastrar</button>
			  	</div>
			  	
			</form>
		</div>
	</body>
</html>
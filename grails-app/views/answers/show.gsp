
<%@ page import="com.example.Answers" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'answers.label', default: 'Answers')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-answers" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-answers" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list answers">
			
				<g:if test="${answersInstance?.optionsInstance}">
				<li class="fieldcontain">
					<span id="optionsInstance-label" class="property-label"><g:message code="answers.optionsInstance.label" default="Options Instance" /></span>
					
						<span class="property-value" aria-labelledby="optionsInstance-label"><g:link controller="options" action="show" id="${answersInstance?.optionsInstance?.id}">${answersInstance?.optionsInstance?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${answersInstance?.questionInstance}">
				<li class="fieldcontain">
					<span id="questionInstance-label" class="property-label"><g:message code="answers.questionInstance.label" default="Question Instance" /></span>
					
						<span class="property-value" aria-labelledby="questionInstance-label"><g:link controller="question" action="show" id="${answersInstance?.questionInstance?.id}">${answersInstance?.questionInstance?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:answersInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${answersInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

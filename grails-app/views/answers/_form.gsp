<%@ page import="com.example.Answers" %>



<div class="fieldcontain ${hasErrors(bean: answersInstance, field: 'optionsInstance', 'error')} required">
	<label for="optionsInstance">
		<g:message code="answers.optionsInstance.label" default="Options Instance" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="optionsInstance" name="optionsInstance.id" from="${com.example.Options.list()}" optionKey="id" required="" value="${answersInstance?.optionsInstance?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: answersInstance, field: 'questionInstance', 'error')} required">
	<label for="questionInstance">
		<g:message code="answers.questionInstance.label" default="Question Instance" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="questionInstance" name="questionInstance.id" from="${com.example.Question.list()}" optionKey="id" required="" value="${answersInstance?.questionInstance?.id}" class="many-to-one"/>

</div>


<%@ page import="com.example.Options" %>



<div class="fieldcontain ${hasErrors(bean: optionsInstance, field: 'optionName', 'error')} ">
	<label for="optionName">
		<g:message code="options.optionName.label" default="Option Name" />
		
	</label>
	<g:textField name="optionName" value="${optionsInstance?.optionName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: optionsInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="options.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="question" name="question.id" from="${com.example.Question.list()}" optionKey="id" required="" value="${optionsInstance?.question?.id}" class="many-to-one"/>

</div>


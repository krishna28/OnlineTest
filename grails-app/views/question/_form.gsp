<%@ page import="com.example.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'options', 'error')} ">
	<label for="options">
		<g:message code="question.options.label" default="Options" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${questionInstance?.options?}" var="o">
    <li><g:link controller="options" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="options" action="create" params="['question.id': questionInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'options.label', default: 'Options')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'questionName', 'error')} ">
	<label for="questionName">
		<g:message code="question.questionName.label" default="Question Name" />
		
	</label>
	<g:textField name="questionName" value="${questionInstance?.questionName}"/>

</div>


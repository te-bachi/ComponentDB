<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>

<s:form theme="simple" action="category" validate="false" method="post">
    <s:iterator value="check" var="c">
        <s:checkbox name="%{'check[\\'' + key +'\\']'}" value="%{#c.value}"/>
    </s:iterator>
    <s:submit theme="simple" id="searchbutton" value="Suchen"/>
</s:form>


<s:iterator value="componentList" var="component">
    <s:property value="name" />
    <s:property value="manufacturer.name" />
</s:iterator>
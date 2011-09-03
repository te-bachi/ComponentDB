<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>

<s:form theme="simple" action="category" validate="false" method="post">
    <s:iterator value="check" var="c">
        <s:checkbox name="%{'check[\\'' + key +'\\']'}" value="%{#c.value}"/>
    </s:iterator>
    <s:submit theme="simple" id="searchbutton" value="Suchen"/>
</s:form>


<br/>
<br/>
<s:iterator value="categories" var="category">
    <div>
        <s:property value="key.name" /> - "<s:property value="value.size" />"
    </div>
</s:iterator>

    
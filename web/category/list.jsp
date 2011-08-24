<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Simple jsp page</title>
    </head>
    <body>
        <s:a value="Add">Add</s:a>

        <table border="1">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Parent</td>
            </tr>
            <s:iterator value="categories">
                <tr>
                    <td><s:property value="id" /></td>
                    <td><s:property value="name" /></td>
                    <td><s:property value="parentCategory.name" /></td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
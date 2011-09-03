<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>

<div id="result">
    <table>
        <tr>
            <th>Abb.</th>
            <th>Best.Nr.</th>
            <th>Name / Hersteller</th>
            <th>Beschreibung</th>
            <th>Datenblätter</th>
            <th>Ort</th>
            <th>Menge</th>
        </tr>
        <s:iterator value="components" var="component" status="rowstatus">
            <tr>
            <s:if test="#rowstatus.odd == true">
                <td class="odd">&nbsp;</td>
                <td class="odd"><s:property value="partNumber" /></td>
                <td class="odd"><span<s:property value="name" /><br/><s:property value="manufacturer.name" /></td>
                <td class="odd"><s:property value="description" /></td>
                <td class="odd">&nbsp;</td>
                <td class="odd"><s:property value="place" /></td>
                <td class="odd"><s:property value="quantity" /></td>
            </s:if>
            <s:else>
                <td>&nbsp;</td>
                <td><s:property value="partNumber" /></td>
                <td><s:property value="name" /><br/><s:property value="manufacturer.name" /></td>
                <td><s:property value="description" /></td>
                <td>&nbsp;</td>
                <td><s:property value="place" /></td>
                <td><s:property value="quantity" /></td>
            </s:else>
            </tr>
        </s:iterator>
    </table>
</div>
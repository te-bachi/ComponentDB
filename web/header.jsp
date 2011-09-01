<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<div id="header">
    <div id="logo">
        <h1>Component DB</h1>
        <h2>Andreas Bachmann</h2>
    </div>
    <div id="searchbar">
        <s:form theme="simple" action="search" validate="false" method="post">
            <s:textfield theme="simple" id="searchtext" name="searchText"/>
            <s:submit theme="simple" id="searchbutton" value="Suchen"/>
            <div>
                <a href="#">Erweiterte Einstellungen</a>
                <div>
                    <div><s:radio theme="simple" cssClass="radio" id="radioMatch" name="match" list="#{'exact':'Exakt'}" value="matchDefault"/></div>
                    <div><s:radio theme="simple" cssClass="radio" id="radioMatch" name="match" list="#{'wildcard':'Wildcard'}"/></div>
                    <div class="spacer"></div>
                    <div><label class="check"for="checkBestellNr"><s:checkbox theme="simple" cssClass="check" id="checkBestellNr" name="check['bestellNr']" />Bestell Nr.</label></div>
                    <div><label class="check" for="checkName"><s:checkbox theme="simple" cssClass="check" id="checkName" name="check['name']" />Name</label></div>
                    <div><label class="check" for="checkBeschreibung"><s:checkbox theme="simple" cssClass="check" id="checkBeschreibung" name="check['beschreibung']" />Beschreibung</label></div>
                    <div><label class="check" for="checkHersteller"><s:checkbox theme="simple" cssClass="check" id="checkHersteller" name="check['hersteller']" />Hersteller</label></div>
                    <div><label class="check" for="checkAttribute"><s:checkbox theme="simple" cssClass="check" id="checkAttribute" name="check['attribute']" />Attribute</label></div>
                </div>
            </div>
        </s:form>
    </div>
</div>
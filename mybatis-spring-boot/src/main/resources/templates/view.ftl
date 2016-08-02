<html>
<head>
    <title> 信息</title>
    <link href="${request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body style="margin-top:50px;overflow: hidden;">
<form action="${request.contextPath}/countries/save" method="post">
    <input type="hidden" name="id" value="<#if country.id??>${country.id}</#if>"/>
    <table class="gridtable" style="width:800px;">
        <tr>
            <th colspan="5"> 信息 - [<a href="${request.contextPath}/countries">返回</a>]</th>
        </tr>
        <tr>
            <th> 名称：</th>
            <td><input type="text" name="countryname" value="<#if country.countryname??>${country.countryname}</#if>"/>
            </td>
            <th> 代码：</th>
            <td><input type="text" name="countrycode" value="<#if country.countrycode??>${country.countrycode}</#if>"/>
            </td>
            <td><input type="submit" value="保存"/></td>
        </tr>
    <#if msg??>
        <tr style="color:#00ba00;">
            <th colspan="5">${msg}</th>
        </tr>
    </#if>
    </table>
</form>
</body>
</html>

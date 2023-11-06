<%@ page import="com.main.lab2_2.model.ResultBean" %>
<%@ page import="jakarta.servlet.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/style.css" />
    <title>Table</title>
</head>

<body>
    <div id="results">
        <button type="button" id="back">Back</button>
        <table id="tableResult" style="margin: auto">
            <%  ResultBean result = (ResultBean) request.getSession().getAttribute("resultBean");
                String error = (String) request.getSession().getAttribute("error");
                String dotsList = (String) request.getSession().getAttribute("dots");
                if ( error == "Wrong data") { %>
                    <h1><%= error%></h1>
            <%  } else { %>
                    <tr>
                        <th width="150">x</th>
                        <th width="150">y</th>
                        <th width="150">r</th>
                        <th width="150">Попадание точки в график</th>
                        <th width="150">Время выполнения (в милисекундах)</th>
                        <th width="150">Время</th>
                    </tr>
                    <%= result.toString()%>
            <%  } %>
        </table>
    </div>
    
    <template id="allDots" data-value='<%= dotsList %>'></template>

    <script>
        document.getElementById("back").addEventListener("click", () => {
            location = "index.jsp";
        });
        let dotsList = document.getElementById("allDots").getAttribute("data-value");
        window.sessionStorage.setItem("allDots", dotsList);
    </script>
</body>

</html>

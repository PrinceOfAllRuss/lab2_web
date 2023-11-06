<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="resources/css/style.css" />
    <title>lab2</title>
</head>

<body>
<table>
    <tr>
        <th colspan="2" id="table_head">
            Филатов Фёдор Романович, группа P3222, вариант 66057
        </th>
    </tr>
    <tr>
        <td width="20%">
            <canvas id="graph" width="500" height="500"></canvas>
            <div id="btnsForGraph">
                <button type="button" id="submitDotOnGraph" class="btnForDotOnGraph hidden" value="false">
                    Отправить точку
                </button>
                <button type="button" id="removeDotOnGraph" class="btnForDotOnGraph hidden">
                    Убрать точку
                </button>
            </div>
        </td>
        <td width="80%">
            <form id="myForm" action="#">
                <div>
                    <label>Выберете координату X (число от -5 до 5) :</label>
                    <input type="text" name="x" id="x" />
                </div>
                <br />
                <div id="errorX"></div>
                <br />
                <div>
                    <label>Выберете координату Y :</label>
                    <input type="checkbox" id="y1" value="-2" class="checkbox"> -2
                    <input type="checkbox" id="y2" value="-1.5" class="checkbox"> -1.5
                    <input type="checkbox" id="y3" value="-1" class="checkbox"> -1
                    <input type="checkbox" id="y4" value="-0.5" class="checkbox"> -0.5
                    <input type="checkbox" id="y5" value="0" class="checkbox"> 0
                    <input type="checkbox" id="y6" value="0.5" class="checkbox"> 0.5
                    <input type="checkbox" id="y7" value="1" class="checkbox"> 1
                    <input type="checkbox" id="y8" value="1.5" class="checkbox"> 1.5
                    <input type="checkbox" id="y9" value="2" class="checkbox"> 2
                </div>
                <br />
                <div id="errorY"></div>
                <br />
                <div>
                    Выберете радиус R :
                    <input
                            type="radio"
                            class="radio"
                            id="radius1"
                            name="radius"
                            value="1"
                    />
                    <label for="radius1">1</label>

                    <input
                            type="radio"
                            class="radio"
                            id="radius2"
                            name="radius"
                            value="1.5"
                    />
                    <label for="radius2">1.5</label>

                    <input
                            type="radio"
                            class="radio"
                            id="radius3"
                            name="radius"
                            value="2"
                    />
                    <label for="radius3">2</label>

                    <input
                            type="radio"
                            class="radio"
                            id="radius4"
                            name="radius"
                            value="2.5"
                    />
                    <label for="radius4">2.5</label>

                    <input
                            type="radio"
                            class="radio"
                            id="radius5"
                            name="radius"
                            value="3"
                            checked
                    />
                    <label for="radius5">3</label>
                </div>
                <div>
                    <br />
                    <button type="button" id="submitBtn" class="submit">
                        Отправить форму
                    </button>
                </div>
            </form>
        </td>
    </tr>
</table>

<script async src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script async src="resources/js/Renderer.js"></script>
<script async src="resources/js/ClientData.js"></script>
<script async src="resources/js/Sender.js"></script>
<script async src="resources/js/EventAdder.js"></script>
<script async src="resources/js/Main.js"></script>
<script async src="resources/js/Dot.js"></script>
<script async src="resources/js/Graph.js"></script>
</body>
</html>


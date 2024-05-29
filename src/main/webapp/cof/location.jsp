<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grid Selection</title>
    <style>
        .grid {
            display: grid;
            grid-template-columns: repeat(10, 1fr);
            grid-template-rows: repeat(10, 1fr);
            width: 500px;
            height: 500px;
            border: 1px solid black;
        }
        .cell {
            border: 1px solid black;
            text-align: center;
            line-height: 50px;
        }
        .selected {
            background-color: yellow;
        }
    </style>
</head>
<body>
    <h1>Select a Point</h1>
    <div class="grid">
        <% for (int i = 0; i < 10; i++) { %>
            <% for (int j = 0; j < 10; j++) { %>
                <div class="cell" onclick="selectPoint(<%= i %>, <%= j %>)"><%= i %>, <%= j %></div>
            <% } %>
        <% } %>
    </div>
    <p id="selectedPoint"></p>

    <script>
    function selectPoint(x, y) {
        // Create a new XMLHttpRequest object
        var xhr = new XMLHttpRequest();
        
        // Configure it: POST-request for the URL /servlet_url
        xhr.open('POST', '/servlet_url', true);
        
        // Set the Content-Type header to application/x-www-form-urlencoded
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

        // Set up a function to be called when the request is complete
        xhr.onload = function () {
            if (xhr.status >= 200 && xhr.status < 300) {
                // Request was successful, do something with the response
                document.getElementById("selectedPoint").innerText = "Selected Point: (" + x + ", " + y + ")";
            } else {
                // Request failed
                console.log('The request failed!');
            }
        };

        // Prepare the data to send in the request body
        var data = 'x=' + x + '&y=' + y + '&customerid=' + ${loginCus.customerid};

        // Send the request with the data
        xhr.send(data);
    }
    </script>
</body>
</html>
    
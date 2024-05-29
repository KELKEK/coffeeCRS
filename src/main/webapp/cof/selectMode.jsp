<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.container {
    display: flex;
    justify-content: space-between;
}

  *, *::after, *::before {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        margin: 0;
        padding: 0;
        background-color: #DFBBAE;
        background-image: url('selectMode.png');
        background-blend-mode: multiply;
        background-size: cover; /* 배경 이미지를 커버하도록 설정 */
    	background-position: center; /* 배경 이미지를 가운데 정렬 */
   	 	background-repeat: no-repeat;
    }
    /* 작은 해상도에 대한 스타일 */
@media (max-width: 768px) {
    body {
        background-size: contain; /* 배경 이미지를 화면에 맞게 조정 */
    }
}

    .main{
        width: 100vw;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        position: relative;
    }

    li {
        list-style: none;
        margin: 0 15px;
    }

    a {
        background-color: #96523A;
        width: 250px;
        height: 250px;
        border-radius: 50%;
        border: 2px solid #0ebac5;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 1em 8em;
        transition: all 500ms ease;
    }

    ion-icon {
        color: #fff;
        font-size: 7.5em;
        border: none;
    }

    a:hover {
        box-shadow: 0 0 20px #0ebac5;
    }

    a:hover ion-icon{
        color: #0ebac5;
        box-shadow: 0 0 12px #0ebac5;
    }

    @media screen and (min-width: 500px) {
        ul {
            display: flex;
        }
    }
    
    h1{ 
    	font-size: 4em;
    }
    
.material-symbols-outlined {
  font-variation-settings:
  'FILL' 0,
  'wght' 400,
  'GRAD' 0,
  'opsz' 24;
}
</style>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</head>
<body>
<main class="main">
        <ul>
            <li>
                <a href="corplogin.do">
                    <ion-icon name="color-fill-outline"></ion-icon>
                </a>
                <h1 style="text-align:center; color:white">Corporation</h1>
            </li>
            <li>
                <a href="customerlogin.do">
                    <ion-icon name="logo-laravel"></ion-icon>
                </a>
                <h1 style="text-align:center; color:white">Client</h1>
            </li>

        </ul>
    </main>

</body>
</html>
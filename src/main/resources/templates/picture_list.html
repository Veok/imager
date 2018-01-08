<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:tal="http://www.w3.org/1999/xhtml">
<head>
    <title>Dodawarka zdjęć</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="../style.css" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<div id="container">

    <div id="naglowek">
    </div>

        <div id="menuPoziome">
            <ul class="ukladPoziomy">
            <li><a href="../index.php?page=addPicture">Dodaj zdjęcia</a></li>
            <li><a href="../index.php?page=picture_list">Lista zdjęć</a></li>
            <li><a href="../controllers/logout.php"">Wyloguj się</a></li>
            </ul>
        </div>


    <div id="tresc" tal:condition="exists: tresc" tal:content="tresc">
        <?php
        /**
         * Created by IntelliJ IDEA.
         * User: trebb
         * Date: 18.12.2017
         * Time: 13:09
         */

        session_start();
        $userId = $_SESSION['userId'];
        include("../connection_config.php");

        $connectionString = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_DATABASE);
        if ($connectionString->connect_errno != 0) {
            throw new Exception(mysqli_connect_errno());
        } else {
            $sqlString = "SELECT * FROM picture where User_Id = '$userId'";
            $result = mysqli_query($connectionString, $sqlString);
            $row = mysqli_fetch_array($result);
            $i = 0;
            while ($row = mysqli_fetch_array($result)) {
                $imgData = ($row['Image_Data']);
                $id = $row['Id'];
                $img = '<img src="data:image/jpeg;base64,' . base64_encode($imgData) . '" style="width:256px;height:144px;"/>';

                echo '<form id="deleteform" method="post" onsubmit="if(!confirm(\'Jesteś pewien że chcesz usunąć ten obraz?\')){return false;}" action="../controllers/deletePicture.php" >';
                echo '<table><td>';
                echo $img;
                echo '</td><td>';
                echo '<input type="hidden" name="id" value="' . $id . '"/>';
                echo '<button class ="fa fa-close"type="submit" class="button" name="delete" style="display: inline-block; height: 146px; border-color: black; background-color: #f44336;"  /></button>';
                echo '</td></table>';
                echo '</form>';

                $i++;
                if ($i == 4) {
                    echo '</br>';
                    $i = 0;
                }
            }
        }
        ?>

    </div>


    <div id="stopka" >
        By @Paweł Lelental

    </div>
</div>
</html>

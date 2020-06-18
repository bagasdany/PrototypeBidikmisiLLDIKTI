<?php

header("Content-Type: application/json; charset=UTF-8");

require_once 'connect.php';
$key = $_POST['key'];
if ( $key == "update_love" ){

    $id    = $_POST['id'];
    $love  = $_POST['love'];

    $query = "UPDATE bidikmisi SET love='$love' WHERE id='$id' ";

        if ( mysqli_query($db, $query) ){
            $result["value"] = "1";
            $result["message"] = "Aktifkan Pembinaan jika IPK < 3 ";

            echo json_encode($result);
            mysqli_close($db);

        } 
        else {
            $response["value"] = "0";
            $response["message"] = "Error! ".mysqli_error($db);
            echo json_encode($response);

            mysqli_close($db);
        }

} else {
    $response["value"] = "0";
    $response["message"] = "Error! ".mysqli_error($db);
    echo json_encode($response);

    mysqli_close($db);
}

?>
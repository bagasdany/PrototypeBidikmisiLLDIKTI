<?php 
header("Content-Type: application/json; charset=UTF-8");

require_once 'connect.php';

$query = "SELECT * FROM pets";

$result = mysqli_query($db, $query);
$response = array();
$server_name = $_SERVER['SERVER_ADDR']; 

while( $row = mysqli_fetch_assoc($result) ){

    array_push($response, 
    array(
        'id'                =>$row['id'], 
        'name'              =>$row['name'], 
        'species'           =>$row['species'],
        'breed'             =>$row['breed'],
        'gender'            =>$row['gender'],
        'kategoriip'        =>$row['kategoriip'],
        'semester1'         =>$row['semester1'],
        'semester2'         =>$row['semester2'],
        'birth'             =>date('d M Y', strtotime($row['birth'])),
        'picture'           =>"http://$server_name" . $row['picture'],
        'love'              =>$row['love']) 
    );
}
echo json_encode($response);
mysqli_close($db);
?>
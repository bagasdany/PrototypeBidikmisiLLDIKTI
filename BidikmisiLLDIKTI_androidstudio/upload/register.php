<?php
require "connect.php";
$kampus = $_GET["kampus"];
$user_name = $_GET["user_name"];
$user_password = $_GET["user_password"];

// $sql ="SELECT * FROM pets ";
// $querryadmin = mysqli_query("SELECT post.*,login_info.* FROM pets");

$sql = "SELECT * FROM logins WHERE user_name = '$user_name'";

$result = mysqli_query($conn,$sql);

if(mysqli_num_rows($result)>0)
{
$status = "exist";
}
else
{
$sql = "insert into logins(kampus,user_name,user_password) values('$kampus','$user_name','$user_password');";

if(mysqli_query($conn,$sql))
{
$status = "ok" ;
}
else
{
    $status="error";
    }
}
echo json_encode(array("response"=>$status));
mysqli_close($conn);
?>

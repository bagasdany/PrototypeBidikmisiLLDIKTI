<?php
session_start();
require "connect.php";
    if($_SERVER['REQUEST_METHOD'] == 'POST')
    {
        $username = $_POST['username'];
        $password = $_POST['password'];

        $query = $db->query("SELECT * FROM loginupgris WHERE username = '$username' AND password = '$password'");

        if($query->num_rows >0 )
        {
            while ($row = $query->fetch_object()) {
                $_SESSION["username"]=$username;
                // header('location:get_pets.php');
                $data =array("kode" =>1,"pesan" =>"data ditemukan", "result" => array(
                    array("iduser" => $row->iduser, "kampus"=>$row->kampus,"username"=>$row->username)
                ));
                echo json_encode($data);
                // header('location:get_pets.php');
            }
        }else{
            echo json_encode(array("kode"=>0,"pesan"=>"Data username tidak terdaftar"));
        }
    }

?>

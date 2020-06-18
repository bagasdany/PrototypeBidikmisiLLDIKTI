<?php 
session_start();

header("Content-Type: application/json; charset=UTF-8");
// session_start();
require_once 'connect.php';
// $tampil = mysql_query("SELECT * FROM orders, kustomer 
//                       WHERE orders.id_kustomer=kustomer.id_kustomer
//                       AND kustomer.email='$_SESSION[email]' // <--- ini yang ditambahkan
//                       ORDER BY orders.id_orders DESC LIMIT 6");
// $query = "SELECT * FROM bidikmisi ORDER BY universitas ASC";
$query = "SELECT * FROM bidikmisi JOIN loginadmin WHERE bidikmisi.universitas=loginadmin.iduser 
        ORDER BY bidikmisi.universitas ASC";
$result = mysqli_query($db, $query);
$response = array();
$server_name = $_SERVER['SERVER_ADDR']; 

while( $row = mysqli_fetch_assoc($result) ){

    array_push($response, 
    array(
        'id'                 =>$row['id'], 
        'name'               => $row['name'],
        'nim'                => $row['nim'],
        'angkatan'           => $row['angkatan'],
        'jenjang'            => $row['jenjang'],
        'fakultas'           => $row['fakultas'],
        'tempatlahir'        => $row['tempatlahir'],
        'totalipk'           => $row['totalipk'],
        'semestertempuh'     => $row['semestertempuh'],
        'gender'             => $row['gender'],
        'statusbidikmisi'    => $row['statusbidikmisi'],
        'tahunmundur'        => $row['tahunmundur'],
        'alasanmundur'       => $row['alasanmundur'],
        'statusdana'         => $row['statusdana'],
        'jumlahdana'         => $row['jumlahdana'],
        'universitas'        => $row['universitas'],
        'semester1'          => $row['semester1'],
        'semester2'          => $row['semester2'],
        'semester3'          => $row['semester3'],
        'semester4'          => $row['semester4'],
        'semester5'          => $row['semester5'],
        'semester6'          => $row['semester6'],
        'semester7'          => $row['semester7'],
        'semester8'          => $row['semester8'],
        'jumlahprestasi'     => $row['jumlahprestasi'],
        'namaprestasi'       => $row['namaprestasi'],
        'juaraprestasi'      => $row['juaraprestasi'],
        'bidangprestasi'     => $row['bidangprestasi'],
        'tingkatprestasi'    => $row['tingkatprestasi'],
        'jumlahorganisasi'   => $row['jumlahorganisasi'],
        'namaorganisasi'     => $row['namaorganisasi'],
        'jabatanorganisasi'  => $row['jabatanorganisasi'],
        'statusorganisasi'   => $row['statusorganisasi'],
        'periodeorganisasi'  => $row['periodeorganisasi'],
        'birth'             =>date('d M Y', strtotime($row['birth'])),
        'picture'           =>"http://$server_name" . $row['picture'],
        'love'              =>$row['love']) 
    );
}
echo json_encode($response);
mysqli_close($db);
?>
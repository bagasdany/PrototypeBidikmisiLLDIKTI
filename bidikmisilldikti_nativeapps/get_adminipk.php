<?php 
header("Content-Type: application/json; charset=UTF-8");

require_once 'connect.php';

$query = "SELECT * FROM bidikmisi WHERE totalipk BETWEEN '0' AND '2.99' ORDER BY universitas ASC";

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
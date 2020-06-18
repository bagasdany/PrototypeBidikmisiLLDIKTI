<?php 

header("Content-Type: application/json; charset=UTF-8");

require_once 'connect.php';

$key = $_POST['key'];

if ( $key == "update"){

    $id                 = $_POST['id'];
    $name               = $_POST['name'];
    $nim                = $_POST['nim'];
    $angkatan           = $_POST['angkatan'];
    $jenjang            = $_POST['jenjang'];
    $fakultas           = $_POST['fakultas'];
    $tempatlahir        = $_POST['tempatlahir'];
    $totalipk           = $_POST['totalipk'];
    $semestertempuh     = $_POST['semestertempuh'];
    $gender             = $_POST['gender'];
    $statusbidikmisi    = $_POST['statusbidikmisi'];
    $tahunmundur        = $_POST['tahunmundur'];
    $alasanmundur       = $_POST['alasanmundur'];
    $statusdana         = $_POST['statusdana'];
    $jumlahdana         = $_POST['jumlahdana'];
    $universitas        = $_POST['universitas'];
    $semester1          = $_POST['semester1'];
    $semester2          = $_POST['semester2'];
    $semester3          = $_POST['semester3'];
    $semester4          = $_POST['semester4'];
    $semester5          = $_POST['semester5'];
    $semester6          = $_POST['semester6'];
    $semester7          = $_POST['semester7'];
    $semester8          = $_POST['semester8'];
    $jumlahprestasi     = $_POST['jumlahprestasi'];
    $namaprestasi       = $_POST['namaprestasi'];
    $juaraprestasi      = $_POST['juaraprestasi'];
    $bidangprestasi     = $_POST['bidangprestasi'];
    $tingkatprestasi    = $_POST['tingkatprestasi'];
    $jumlahorganisasi   = $_POST['jumlahorganisasi'];
    $namaorganisasi     = $_POST['namaorganisasi'];
    $jabatanorganisasi  = $_POST['jabatanorganisasi'];
    $statusorganisasi   = $_POST['statusorganisasi'];
    $periodeorganisasi  = $_POST['periodeorganisasi'];
    $birth              = $_POST['birth'];
    $picture            = $_POST['picture'];
    $birth              =  date('Y-m-d', strtotime($birth));
    
    $query = "UPDATE bidikmisi SET 
    name                    ='$name', 
    nim                     ='$nim', 
    angkatan                ='$angkatan', 
    jenjang                 ='$jenjang', 
    fakultas                ='$fakultas', 
    tempatlahir             ='$tempatlahir', 
    totalipk                ='$totalipk', 
    semestertempuh          ='$semestertempuh',
    gender                  ='$gender',
    statusbidikmisi         ='$statusbidikmisi',
    tahunmundur             ='$tahunmundur', 
    alasanmundur            ='$alasanmundur', 
    statusdana              ='$statusdana', 
    jumlahdana              ='$jumlahdana', 
    universitas             ='$universitas',
    semester1               ='$semester1',
    semester2               ='$semester2',
    semester3               ='$semester3',
    semester4               ='$semester4',
    semester5               ='$semester5',
    semester6               ='$semester6',
    semester7               ='$semester7',
    semester8               ='$semester8',
    jumlahprestasi          ='$jumlahprestasi', 
    namaprestasi            ='$namaprestasi', 
    juaraprestasi           ='$juaraprestasi', 
    bidangprestasi          ='$bidangprestasi', 
    tingkatprestasi         ='$tingkatprestasi', 
    jumlahorganisasi        ='$jumlahorganisasi', 
    namaorganisasi          ='$namaorganisasi', 
    jabatanorganisasi       ='$jabatanorganisasi', 
    statusorganisasi        ='$statusorganisasi', 
    periodeorganisasi       ='$periodeorganisasi', 
    birth                   ='$birth'
    WHERE id='$id' ";

        if ( mysqli_query($db, $query) ){

            if ($picture == null) {

                $result["value"] = "1";
                $result["message"] = "Success";
    
                echo json_encode($result);
                mysqli_close($db);

            } else {

                $path = "mhs_picture/$id.jpeg";
                $finalPath = "/bidikmisilldikti/".$path;

                $insert_picture = "UPDATE bidikmisi SET picture='$finalPath' WHERE id='$id' ";
            
                if (mysqli_query($db, $insert_picture)) {
            
                    if ( file_put_contents( $path, base64_decode($picture) ) ) {
                        
                        $result["value"] = "1";
                        $result["message"] = "Success!";
            
                        echo json_encode($result);
                        mysqli_close($db);
            
                    } else {
                        
                        $response["value"] = "0";
                        $response["message"] = "Error! ".mysqli_error($db);
                        echo json_encode($response);

                        mysqli_close($db);
                    }

                }
            }

        }
        
        
        


        else {
            $response["value"] = "0";
            $response["message"] = "Error! ".mysqli_error($db);
            echo json_encode($response);

            mysqli_close($db);
        }
        

}

?>
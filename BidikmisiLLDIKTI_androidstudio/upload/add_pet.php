<?php 

require_once 'connect.php';

$key = $_POST['key'];
$name               = $_POST['name'];
$species            = $_POST['species'];
$breed              = $_POST['breed'];
$gender             = $_POST['gender'];
$kategoriip         = $_POST['kategoriip'];
$semester1          = $_POST['semester1'];
$semester2          = $_POST['semester2'];
$birth              = $_POST['birth'];
$picture            = $_POST['picture'];


if ( $key == "insert" ){

    $birth_newformat = date('Y-m-d', strtotime($birth));

    $query = "INSERT INTO pets (name,species,breed,gender,kategoriip,semester1,semester2,birth)
    VALUES ('$name', '$species', '$breed', '$gender','$kategoriip','$semester1','$semester2','$birth_newformat') ";
    
        if ( mysqli_query($db, $query) ){

            if ($picture == null) {

                $finalPath = "/demo_pets/pet_logo.png"; 
                $result["value"] = "1";
                $result["message"] = "Success";
    
                echo json_encode($result);
                mysqli_close($db);

            } else {

                $id = mysqli_insert_id($db);
                $path = "pets_picture/$id.jpeg";
                $finalPath = "/demo_pets/".$path;

                $insert_picture = "UPDATE pets SET picture='$finalPath' WHERE id='$id' ";
            
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
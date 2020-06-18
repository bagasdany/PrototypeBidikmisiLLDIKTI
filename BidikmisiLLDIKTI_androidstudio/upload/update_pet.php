<?php 

header("Content-Type: application/json; charset=UTF-8");

require_once 'connect.php';

$key = $_POST['key'];

if ( $key == "update"){

    $id         = $_POST['id'];
    $name       = $_POST['name'];
    $species    = $_POST['species'];
    $breed      = $_POST['breed'];
    $gender     = $_POST['gender'];
    $kategoriip = $_POST['kategoriip'];
    $semester1  = $_POST['semester1'];
    $semester2  = $_POST['semester2'];
    $birth      = $_POST['birth'];
    $picture    = $_POST['picture'];
    $birth      =  date('Y-m-d', strtotime($birth));
    
    $query = "UPDATE pets SET 
    name='$name', 
    species='$species', 
    breed='$breed',
    gender='$gender',
    kategoriip ='$kategoriip',
    semester1 = '$semester1',
    semester2= '$semester2',
    birth='$birth'
    WHERE id='$id' ";

        if ( mysqli_query($db, $query) ){

            if ($picture == null) {

                $result["value"] = "1";
                $result["message"] = "Success";
    
                echo json_encode($result);
                mysqli_close($db);

            } else {

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
            $response["message"] = "Error! ".mysqli_error($conn);
            echo json_encode($response);

            mysqli_close($conn);
        }
        

}

?>
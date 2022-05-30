<?php
// var_dump($_POST);

if(!empty($_POST)) {
// if (isset($_POST['submit'])) {
    if (isset($_POST['nome']) && isset($_POST['email']) &&
        isset($_POST['oggetto']) && isset($_POST['messaggio'])) {

        $nome = $_POST['nome'];
        $email = $_POST['email'];
        $oggetto = $_POST['oggetto'];
        $messaggio = $_POST['messaggio'];

        $host = "localhost";
        $dbUsername = "mydynamicgym";
        $dbPassword = "";
        $dbName = "my_mydynamicgym";

        $conn = mysqli_connect($host, $dbUsername, $dbPassword, $dbName);

        if ($conn->connect_error) {
            die('Could not connect to the database.');
        }
        else {
            // $Select = "SELECT email FROM register WHERE email = ? LIMIT 1";
            $Insert = "INSERT INTO formcontatto(nome, email, oggetto, descrizione) values(?, ?, ?, ?)";

            //  $stmt = $conn->prepare($Select);
            //  $stmt->bind_param("s", $email);
            //  $stmt->execute();
            //  $stmt->bind_result($resultEmail);
            //  $stmt->store_result();
            //  $stmt->fetch();
            //  $rnum = $stmt->num_rows;

            // if ($rnum == 0) {
            //     $stmt->close();

                $stmt = $conn->prepare($Insert);
                $stmt->bind_param("ssss",$nome, $email, $oggetto, $messaggio);
                if ($stmt->execute()) {
                    echo "Invio effettuato con successo";
                }
                else {
                    
                    echo $stmt->error;
                }
            } 
            // else {
            //     echo "Someone already registers using this email.";
            // }
            $stmt->close();
            $conn->close();
            
        }
    else {
        echo "All field are required.";
        die();
    }
}
else {
    echo "Submit button is not set";
}
?>
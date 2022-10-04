<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

   

    
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>LIBRARY MANAGEMENT SYSTEM</title>

    <link rel="shortcut icon" href="favicon-32x32.png" type="image/x-icon">
    <style>
        body {
            background-image: url('new.jpg');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
        .topright
         {
             position: absolute;
            top: 80px;
            right: 30px;
             font-size: 18px;
        }
    </style>


</head>
<body>


    
  <%  
     
     
     
     
    if(request.getSession().getAttribute("username") != null)
    {
        
  %>

  


    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="Dashboard.html">LIBRARY MANAGEMENT SYSTEM</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <form class="d-flex" action="Home" method="post">
                            <input name="search" class="form-control me-2" action="Home" id="searchTxt" type="hidden" autocomplete="off" placeholder="Search"
                                aria-label="Search">
                            <button style="margin-right:20px ;" class="btn btn-outline-light" type="submit">Home</button>
                        </form>
                        <!--<a class="nav-link active" aria-current="page" href="#">Home</a>-->

                </ul>
                <form class="d-flex" action="Search" method="post">
                    <input name="search" class="form-control me-2" required   type="search" autocomplete="off" placeholder="Search Book"
                        aria-label="Search">
                    <button style="margin-right:20px ; " class="btn btn-outline-warning" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

    
    <div class="topright">
    <form action="Logout" method="POST">

        <input type="submit" value="Logout" class="btn btn-outline-light">
    </form>
    </div>

    <%
        String uppercase = (String)request.getSession().getAttribute("username");

        uppercase=uppercase.toUpperCase();
        %>
    <h2 style="color:white ;" > Welcome "<%out.println(uppercase);%> "</h2>

      
    <div style="margin-top:25px; align-items: center;justify-content: center; display: flex;">
    <a href="AddBook.jsp"> <button style="margin-right:12px ; width:200px ; " type="button" class="btn btn-warning">Add Book</button></a>
    
    

    <!--<a href=""> <button type="button" class="btn btn-warning">Update Book</button></a> -->
</div>

<!--
<div  style="margin-top:60px ; "> <div  class="container my-3"> <b>
<table class="table" style="color: white;"><thead ><tr><th scope="col">#</th><th scope="col">Book Name</th><th scope="col">Book Description</th><th scope="col">Author</th></tr></thead>
    <tbody >
      <tr><th scope="row">1</th><td>Mark</td><td>Otto</td><td>@mdo</td></tr>
      <tr>
        <th scope="row">2</th>
        <td>Jacob</td>
        <td>Thornton</td>
        <td>@fat</td>
      </tr>
      <tr>
        <th scope="row">3</th>
        <td colspan="2">Larry the Bird</td>
        <td>@twitter</td>
      </tr>
    </tbody>
  </table></b></div></div>
  -->
  

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>


<%}
else{
    %>
        <h2 style="color: white;">Your session was expired login again</h2>
        <jsp:include page='Login.html'/>
       <% 
    }
   
%>
        
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ADD BOOK</title>

    <!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


<link rel="shortcut icon" href="favicon-32x32.png" type="image/x-icon">
<style>
  body {
      background-image: url('bg3.jpg');
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: cover;
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


    <%
        String uppercase = (String)request.getSession().getAttribute("username");

        uppercase=uppercase.toUpperCase();
    
    
    %>
    <h2 style="color:white ;" > <%out.println(uppercase);%> Please Add a Book You want:</h2>
   <!-- <form action="AddBook" method="POST">

        

        Enter Book Name: <input type="text" name="bookname" autocomplete="off" required><br><br>

        Enter Book Description: <input type="text" name="description" autocomplete="off" required><br><br>

        Enter Author Name: <input type="text" name="author" autocomplete="off" required><br><br>

        <input type="submit" value="Add Book">

        </form> -->


        <div style="margin-top: 130px;">
            <div  class="container my-3"  >
                <div style="margin-left: 200px;">
            <form  action="AddBook" method="post">
                    <div class="row mb-3">
                      <label  for="bookName" style=" font-size: 15px;color: white;" class="col-sm-2 col-form-label"><b>Enter Book Name:</b></label>
                      <div class="col-sm-10">
                        <input  type="text" style="width: 50%;" name="bookname" autocomplete="off" required  class="form-control"  placeholder="Book Name">
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label for="Author" style="color: white; font-size: 15px" class="col-sm-2 col-form-label"><b>Enter Book Description: </b></label>
                      <div class="col-sm-10">
                        <input style="width: 50%;" type="text"  name="description" autocomplete="off" required class="form-control"   placeholder="Book Description">
                      </div>
                    </div>
                    <div class="row mb-3">
                        <label for="Author" style="color: white; font-size: 15px" class="col-sm-2 col-form-label"><b>Enter Author Name: </b></label>
                        <div class="col-sm-10">
                          <input  style="width: 50%;" type="text"  name="author" class="form-control" required autocomplete="off"   placeholder="Book Author">
                        </div>
                      </div>
                    </div>
                    <div  style=" width: 100%;  height: 100px ; display: flex; align-items: center; justify-content: center;">
                    <button type="submit" style="width:11%"    class="btn btn-warning"  >Add Book</button>
                    </div>
            </form>
            </div>
          </div>
          <b><hr style="color: white; border: 2px solid white; margin-top: 70px;"></b>
        <b><footer style="text-align: center; color: rgb(255, 255, 255);">&copy; Copyright 2022 Malik Basiq</footer></b>
           
    
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
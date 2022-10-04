<html>
<head>
<title>Update Book</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

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

<div style="margin-top: 50px;">
        <div  class="container my-3"  >
          <div style="margin-left: 200px;">
        <form id="libraryForm" action="Update2" method="post">
                <div class="row mb-3">
                  <label  for="bookName" style=" font-size: 15px;color: white;" class="col-sm-2 col-form-label"><b>Enter Updated Book Name:</b></label>
                  <div class="col-sm-10">
                    <input  type="text" style="width: 50%;" name="Bookname" autocomplete="off"  class="form-control"  placeholder="Updated Book Name">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="Author" style="color: white; font-size: 15px" class="col-sm-2 col-form-label"><b>Enter Updated Book Description: </b></label>
                  <div class="col-sm-10">
                    <input type="text" style="width: 50%;"  name="Bookdescription" autocomplete="off" class="form-control"   placeholder="Updated Book Description">
                  </div>
                </div>
                <div class="row mb-3">
                    <label for="Author" style="color: white; font-size: 15px" class="col-sm-2 col-form-label"><b>Enter Updated Book Author: </b></label>
                    <div class="col-sm-10">
                      <input type="text" style="width: 50%;"  name="author" class="form-control" autocomplete="off"   placeholder="Updated Book Author">
                    </div>
                  </div>
                </div>
                <div  style=" width: 100%;  height: 100px ; display: flex; align-items: center; justify-content: center;">
                <button type="submit" style="width:11%"    class="btn btn-warning"  >Update Book</button>
                </div>
        </form>
        </div>
      </div>
      <b><hr style="color: white; border: 2px solid white; margin-top: 10px;"></b>
    <b><footer style="text-align: center; color: rgb(255, 255, 255);">&copy; Copyright 2021 Malik Basiq</footer></b>
       

              <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->

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
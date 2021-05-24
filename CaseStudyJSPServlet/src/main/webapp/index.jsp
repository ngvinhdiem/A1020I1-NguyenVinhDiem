<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 5/21/2021
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Layout</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid" style = "height: auto">
  <div class="header">
    <div class="logo-row">
      <img src="images/logo.png" alt="logo" class="logo">
      <div class="header-right" style="text-align: center">
        <br>Nguyen Vinh Diem
      </div>
    </div>

  </div>


  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
      <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
    </svg>  Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#">Employee</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Service</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contract</a>
        </li>

      </ul>

    </div>
    <input type="text" placeholder="Search.." class="round">
  </nav>
  <div class = "row">
    <aside class="col-sm-3">
      <div class="poly-cart">
        <div class="card-header">
          <span class="glyphicon glyphicon-th-list"></span>
          <strong>Items</strong>
        </div>
        <div class="list-group">
          <a href="#" class="list-group-item">Item 1</a>
          <a href="#" class="list-group-item">Item 2</a>
          <a href="#" class="list-group-item">Item 3</a>
          <a href="#" class="list-group-item">Item 4</a>
          <a href="#" class="list-group-item">Item 5</a>
        </div>
      </div>
    </aside>
    <article class="col-sm-9">
      <div style="float:left;" class="col-sm-4 poly-prod">
        <div class="card card-default">
          <div class="card-header">
            <h4 class="card-title">
              Nokia
            </h4>
          </div>
          <div class="card-body">
            <img src="images/computer.jpg" width="152" /></div>
          <div class="card-footer">
            $ 100.25
          </div>
        </div>
      </div>
      <div style="float:left;" class="col-sm-4 poly-prod">
        <div class="card card-default">
          <div class="card-header">
            <h4 class="card-title">
              Nokia
            </h4>
          </div>
          <div class="card-body">
            <img src="images/computer.jpg" width="152" /></div>
          <div class="card-footer">
            $ 100.25
          </div>
        </div>
      </div>
      <div style="float:left;" class="col-sm-4  poly-prod">
        <div class="card card-default">
          <div class="card-header">
            <h4 class="card-title">
              Nokia
            </h4>
          </div>
          <div class="card-body">
            <img src="images/computer.jpg" width="152" /></div>
          <div class="card-footer">
            $ 100.25
          </div>
        </div>
      </div>
      <div style="float:left;" class="col-sm-4 poly-prod">
        <div class="card card-default">
          <div class="card-header">
            <h4 class="card-title">
              Nokia
            </h4>
          </div>
          <div class="card-body">
            <img src="images/computer.jpg" width="152" /></div>
          <div class="card-footer">
            $ 100.25
          </div>
        </div>
      </div>
      <div style="float:left;" class="col-sm-4 poly-prod">
        <div class="card card-default">
          <div class="card-header">
            <h4 class="card-title">
              Nokia
            </h4>
          </div>
          <div class="card-body">
            <img src="images/computer.jpg" width="152" /></div>
          <div class="card-footer">
            $ 100.25
          </div>
        </div>
      </div>
      <div style="float:left;" class="col-sm-4 poly-prod">
        <div class="card card-default">
          <div class="card-header">
            <h4 class="card-title">
              Nokia
            </h4>
          </div>
          <div class="card-body">
            <img src="images/computer.jpg" width="152" /></div>
          <div class="card-footer">
            $ 100.25
          </div>
        </div>
      </div>

    </article>

  </div>




  <div class="footer">
    <div class="card-heading text-center">
      <p>Case study Diem</p>
    </div>
  </div>


</div>
</body>
</html>

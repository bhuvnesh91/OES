<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
   <title>Try Bootstrap Online</title>
   <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
   <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
   <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

   <div class="row" >
      <div class="col-lg-4" 
         style="background-color: #dedef8;
         box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
           <button type="button" class="btn btn-default">Default</button>
			<button type="button" class="btn btn-primary">Primary</button>
      </div>
      <div class="col-lg-2" 
         style="background-color: #dedef8;box-shadow: 
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
		<button type="button" class="btn btn-success btn-xs">Success</button>
		<button type="button" class="btn btn-info btn-lg btn-block active">Info</button>
      </div>

      <div class="clearfix visible-xs"></div>

      <div class="col-lg-2" 
         style="background-color: #dedef8;
         box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
         <button type="button" class="btn btn-warning btn-sm ">Warning</button>
		<button type="button" class="btn btn-danger btn-md">Danger</button>
      </div>
      <div class="col-lg-4" 
         style="background-color: #dedef8;box-shadow: 
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
        <img src="images/add-button.png" class="img-responsive img-circle" alt="Responsive image">
      </div>
   </div>
   
   <ul class="nav nav-pills nav-stacked">
  <li class="active">
    <a href="#">
      <span class="badge pull-right">42</span>
      Home
    </a>
  </li>
</ul>

   <ul class="pagination">
  <li><a href="#">&laquo;</a></li>
  <li><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#">&raquo;</a></li>
</ul>

<div class="alert alert-success">SUCCESS</div>
<div class="alert alert-info">INFO</div>
<div class="alert alert-warning">WARNING</div>
<div class="alert alert-danger">DANGER</div>
</div>

</body>
</html>

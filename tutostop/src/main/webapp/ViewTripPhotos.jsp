<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="common/css_codes/modalimage.css" />
<link rel="stylesheet" type="text/css" href="common/css_codes/ViewTripPhotoThumbnail.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common/css_codes/slideshow.css" />
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">
<title>PhotoMoments</title>
</head>
<!--position:relative; margin: auto; max-height:850px; -->
<body>
	<h3 class="p-3 container">PHOMOMENTS</h3>
	<div class="container">
		<ul class="nav nav-tabs container">
	    			<li class="active"><a data-toggle="tab" href="#home">Slide</a></li>
	   		 		<li><a data-toggle="tab" href="#menu1">Thumbnail</a></li>
	    			<li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
				    <li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
				  </ul>
		
		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<div class="container">
					<div class="row">
					</div>
					${tripuid}
					<div align="center" style="height:500px; ">
								<!-- Slideshow container -->
						<div class="slideshow-container">	
							<c:forEach items="${photoList}" var="photoAllList" varStatus="loop">				
							  <!-- Full-width images with number and caption text -->
								<div class="mySlides center">
										<img src="data:image/jpg;base64,${photoAllList.base64Image}" style="max-width:850px; max-height:850px;" /><br><br><br>
										<div class="text" style="padding-bottom: 2px; color: #F4A460;">${loop.count}/${fn:length(photoList)}</div>
								</div>
							</c:forEach>
						</div><br>
					</div>
				</div>
				<!-- Next and previous buttons -->
  					<a style="margin-left:0px;" class="prev" onclick="plusSlides(-1)"><big><big><big><big><big><big><big><big>&#10094;</big></big></big></big></big></big></big></big></a>
  					<a style="margin-right:290px;" class="next" onclick="plusSlides(1)"><big><big><big><big><big><big><big><big>&#10095;</big></big></big></big></big></big></big></big></a>
			</div>
		
			<div id="menu1" class="tab-pane fade">
					<div  align="center">
						<c:forEach items="${photoList}" var="photoAllList" varStatus="loop">
						    <img class="myImg" src="data:image/jpg;base64,${photoAllList.base64Image}" width=20% height=20% style=" padding: 15px 5px 5px 5px;"/>
						</c:forEach>
						
					  <!-- The Modal -->
							<div id="myModal" class="modal">
							
					  		  <!-- The Close Button -->
							  <span class="close" style="font-color:#E22121; color:#ffffff;"><big><big><big><big><big><big>&times;</big></big></big></big></big></big></span>
							
							  <!-- Modal Content (The Image) -->
							  <img class="modal-content" id="img01">
							
							  <!-- Modal Caption (Image Text) -->
							  <div id="caption"></div>
							</div>
							
					</div>
			</div>
		</div>
	</div>
	
  
	<%@ include file="../common/footer.jspf"%>
	
</body>
<script src="common/javascript_codes/modalimage.js"></script>
<script src="common/javascript_codes/slideshow.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>
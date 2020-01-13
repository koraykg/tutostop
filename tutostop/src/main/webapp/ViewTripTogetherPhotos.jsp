<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<!DOCTYPE html>
<html>
<head>
<!--  <link rel="stylesheet" type="text/css" href="common/css_codes/modalimage.css" /> -->
<link rel="stylesheet" type="text/css" href="common/css_codes/slideshow.css" />
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">
<title>PhotoMoments</title>
</head>
<!--position:relative; margin: auto; max-height:850px; -->
<body>
	<div class="container">
		<div class="row">
			<h3 class="p-3">PHOMOMENTS</h3>
		</div>
		${tripuid}
		<div align="center" style="background-color: #FFFAFA; height:500px; ">
				
					<!-- Slideshow container -->
					<div class="slideshow-container">	
					<c:forEach items="${photoList}" var="photoAllList" varStatus="loop">				
					  <!-- Full-width images with number and caption text -->
						<div class="mySlides center">
								<img src="data:image/jpg;base64,${photoAllList.base64Image}" style="max-width:850px; max-height:850px;" /><br><br><br>
								<div class="text" style="color: #F4A460;">${loop.count}/${fn:length(photoList)}</div>
						</div>
						</c:forEach>
					</div>
					<br>
				
		</div>
		
	</div>

	<!-- Next and previous buttons -->
  		<a style="margin-left:200px;" class="prev" onclick="plusSlides(-1)"><big><big><big><big><big><big><big><big>&#10094;</big></big></big></big></big></big></big></big></a>
  		<a style="margin-right:204px;" class="next" onclick="plusSlides(1)"><big><big><big><big><big><big><big><big>&#10095;</big></big></big></big></big></big></big></big></a>
  
	<%@ include file="../common/footer.jspf"%>

</body>
<!-- <script src="common/javascript_codes/modalimage.js"></script> -->
<script src="common/javascript_codes/slideshow.js"></script>
</html>
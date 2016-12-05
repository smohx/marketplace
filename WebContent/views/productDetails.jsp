<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){

$.get("fetchProductDetails",{ productCode: $('#code').val() }, function(data, status){

				
				$('#fillname').html(data.name);
				$('#fillcode').html(data.code);
				$('#fillprice').html('&#8377;'+data.price);
				$('#fillsku').html(data.productSKU);
				$('#defaultimage').attr("src","images/"+data.defaultImageURL);
				$.each( data.productMediaList, function( key, value ) {
					var htmldata="";
					htmldata += '<li>';
					htmldata += '<a data-toggle="tab">';
					htmldata += '<div class="preview-container">';
					htmldata += '<img class ="product-preview" src="images/'+value.mediaURL+'" />';
					htmldata += '</div></a></li>';
					$('#productimagesall').append(htmldata);	
							
				});
				$.each( data.categoryList, function( key, value ) {
						$('#allcat').append('<h5><li>'+value.name+'</li></h5>')	;			
				});
				$('#pdp-comp').show();
				
			
		});
});
$(document).on("click",".product-preview",function(e){
    var src = $(this).attr('src');
    $('#defaultimage').attr('src',src);
});
		
</script>
<style>

/*****************globals*************/
body {
  font-family: 'open sans';
  overflow-x: hidden; }

img {
  max-width: 100%;
  max-height: 252px; }

.preview {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  -webkit-flex-direction: column;
      -ms-flex-direction: column;
          flex-direction: column; }
  @media screen and (max-width: 996px) {
    .preview {
      margin-bottom: 20px; } }

.preview-pic {
  -webkit-box-flex: 1;
  -webkit-flex-grow: 1;
      -ms-flex-positive: 1;
          flex-grow: 1; }

.preview-thumbnail.nav-tabs {
  border: none;
  margin-top: 15px; }
  .preview-thumbnail.nav-tabs li {
    width: 18%;
    margin-right: 2.5%; }
    .preview-thumbnail.nav-tabs li img {
      max-width: 100%;
      display: block; }
    .preview-thumbnail.nav-tabs li a {
      padding: 0;
      margin: 0; }
    .preview-thumbnail.nav-tabs li:last-of-type {
      margin-right: 0; }

.tab-content {
  overflow: hidden; }
  .tab-content img {
    width: 100%;
    -webkit-animation-name: opacity;
            animation-name: opacity;
    -webkit-animation-duration: .3s;
            animation-duration: .3s; }

.card {
  padding: 3em;
  line-height: 1.5em; }

@media screen and (min-width: 997px) {
  .wrapper {
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex; } }

.details {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  -webkit-flex-direction: column;
      -ms-flex-direction: column;
          flex-direction: column; }

.colors {
  -webkit-box-flex: 1;
  -webkit-flex-grow: 1;
      -ms-flex-positive: 1;
          flex-grow: 1; }

.product-title, .price, .sizes, .colors {
  text-transform: UPPERCASE;
  font-weight: bold; }

.checked, .price span {
  color: #3c8dbc; }

.product-title, .rating, .product-description, .price, .vote, .sizes {
  margin-bottom: 15px; }

.product-title {
  margin-top: 0; }

.size {
  margin-right: 10px; }
  .size:first-of-type {
    margin-left: 40px; }

.color {
  display: inline-block;
  vertical-align: middle;
  margin-right: 10px;
  height: 2em;
  width: 2em;
  border-radius: 2px; }
  .color:first-of-type {
    margin-left: 20px; }

.add-to-cart, .like {
  background: #ff9f1a;
  padding: 1.2em 1.5em;
  border: none;
  text-transform: UPPERCASE;
  font-weight: bold;
  color: #fff;
  -webkit-transition: background .3s ease;
          transition: background .3s ease; }
  .add-to-cart:hover, .like:hover {
    background: #b36800;
    color: #fff; }

.not-available {
  text-align: center;
  line-height: 2em; }
  .not-available:before {
    font-family: fontawesome;
    content: "\f00d";
    color: #fff; }

.orange {
  background: #ff9f1a; }

.green {
  background: #85ad00; }

.blue {
  background: #0076ad; }

.tooltip-inner {
  padding: 1.3em; }

@-webkit-keyframes opacity {
  0% {
    opacity: 0;
    -webkit-transform: scale(3);
            transform: scale(3); }
  100% {
    opacity: 1;
    -webkit-transform: scale(1);
            transform: scale(1); } }

@keyframes opacity {
  0% {
    opacity: 0;
    -webkit-transform: scale(3);
            transform: scale(3); }
  100% {
    opacity: 1;
    -webkit-transform: scale(1);
            transform: scale(1); } }

/*# sourceMappingURL=style.css.map */
</style>
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
</head>
<body>
	<input type=hidden id="code" value="${code}"/>
	<div class="container" id="pdp-comp" style="display:none">
		<div class="card">
			<div class="container-fliud">
				<div class="row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content ">
						  <div class="tab-pane active display-image-wrap" id="pic-1"><img id="defaultimage" class="display-image"  /></div>
						
						</div>
						<ul class="preview-thumbnail nav nav-tabs" id="productimagesall">
						  
						</ul>
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title" id="fillname"></h3>
						<p class="product-description" id="filldescription"></p>
						<h4 class="price">CODE: <span id="fillcode"></span></h4>
						
						<h4 class="price">Price: <span id="fillprice"></span></h4>
						<h4 class="price">SKU: <span id="fillsku"></span></h4>
						<h4 class="price">CATEGORIES:<span class="size"  title="small"><div id="allcat">
						
						</div></span>
							
						</h4>
						
						<div class="row">
            				<div class="col-md-2 ">
							<a href="editProduct?code=${code}" class="btn btn-primary" type="button"><i class="fa fa-pencil-square"></i>&nbsp;EDIT</a>
							</div>
							<div class="col-md-2 ">
							<a class="btn btn-primary" type="button"><i class="fa fa-trash-o" ></i>&nbsp;DELETE</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<html>
<head>

  <script type="text/javascript">
  $( document ).ready(function(){
		 

			$.get("fetchAllProducts", function(data, status){

				var htmldata='';
				$.each( data, function( key, value ) {
					htmldata += '<div class="col-sm-4">';
					htmldata += '<div class="product-image-wrapper">';
					htmldata += '<div class="single-products">';
					htmldata += '<div class="productinfo text-center">';
					htmldata += '<h3>'+'CODE: '+value.code+'</h3>';
					htmldata += '<div class="listimg-container">';
					htmldata += '<img class="listimg" src="images/'+value.defaultImageURL+'" alt="" />';
					htmldata += '</div>';
					htmldata += '<h2>'+'&#8377;'+value.price+'</h2>';
					htmldata += '<p>'+value.name+'</p>';
					htmldata += '<a href="productDetails?code='+value.code+'" class="btn btn-default add-to-cart"><i class="fa fa-cube"></i>View Details</a>';
					htmldata += '</div>';
					htmldata += '</div>';
					htmldata +=	'<div class="choose">';
					htmldata += '<ul class="nav nav-pills nav-justified">';
					htmldata += '<li><a href="editProduct?code='+value.code+'"><i class="fa fa-pencil-square"></i>Edit Product</a></li>';
					htmldata += '<li><a href="#"><i class="fa fa-trash-o"></i>Delete Product</a></li>';
					htmldata += '</ul>';
					htmldata += '</div>';
					htmldata += '</div>';
					htmldata += '</div>';						
					htmldata += '</div>';
					
				


				});
				$('#products').html(htmldata);
				$('#listsection').show();
			});
		});
  

  </script>

</head>
<body>

<div id="listsection" class="row listrow" style="display:none">
			
			
							
				<div class="col-sm-9 padding-right">
					<div class="features_items">
					
								
						<h2 class="title text-center">All Products</h2>
					</div>
				     <div id="products">
				     </div>
												
					</div>
			
					
				</div>

</body>
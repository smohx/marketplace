<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
var imgID=100;
$(document).ready(function(){

	$.get("fetchProductDetails",{ productCode:$('#code').val() }, function(data, status){

				$('#code').val(data.code);
				$('#name').val(data.name);
				$('#description').val(data.description);
				$('#productSKU').val(data.productSKU);
				$('#price').val(data.price);
				var dvPreview = $("#dvPreview");
				$.each( data.productMediaList, function( key, value ) {
					var imgdiv= $("<div />");
					imgdiv.attr("id","imgdiv"+imgID);
					imgdiv.addClass("img-wrap");
					dvPreview.append(imgdiv);
					var closeSpan=$("<span />");
					closeSpan.addClass("close");
					closeSpan.addClass("removeImage");
					closeSpan.html("&times");;
					$('#imgdiv'+imgID).append(closeSpan);
                    var img = $("<img />");
                    img.attr("style", "height:100px;width: 100px");
                    img.attr("src", "images/"+value.mediaURL);
                    img.addClass("allImage");
                    img.attr("id", imgID);
                    img.attr("img-id", value.mediaURL);
                    $('#imgdiv'+imgID).append(img);			
					});
				$.each( data.categoryList, function( key, value ) {
					var wrapdiv= $("<div />");
					wrapdiv.addClass("cat-wrap")
					wrapdiv.attr("id","id-wrap-"+value.code);
					$("#selectedcatdiv").append(wrapdiv);
					var closeSpan=$("<span />");
					closeSpan.addClass("close");
					closeSpan.addClass("removeSelCat");
					closeSpan.html("&times");
					$('#id-wrap-'+value.code).append(closeSpan);
					var spansize=$("<h4>");
					var selcat= $("<span>");
					selcat.addClass("form-control");
					selcat.addClass("label");
					selcat.addClass("label-primary");
					selcat.attr("cat-id",value.code);
					selcat.attr("id","sel"+value.code);
					selcat.addClass("selectedCat");
					selcat.html(value.name);
					spansize.append(selcat);
					$('#id-wrap-'+value.code).append(spansize);		
					});
				
					$('#edit-content').show();
					
				
			});
	});
$(document).ready(function(){


		var addCategory = $("#addCategory");
		$.get("fetchTopCategories", function(data, status){
			
			var l1Categories = $("#l1Categories");
			$.each( data, function( key, value ) {
				var opt = $("<option>");
				opt.attr("cat-id",value.code);
				opt.html(value.name);
				l1Categories.append(opt);
				//bootbox.alert("hahaha");
			});
		
		});
		
			
		  
		$('select[name="l1Categories"]').change(function() {
			
			var id = $(this).children(":selected").attr("cat-id");
			$('.btn-add-cat').remove();
			$("#l2Categories").remove();
			var l2Select= $("<select>");
			l2Select.addClass("form-control")
			l2Select.attr("id","l2Categories");
			l2Select.attr("name","l2Categories");
			var l2catdiv = $("#l2catdiv");
			l2catdiv.append(l2Select);
            var l2Categories = $("#l2Categories");
            l2Categories.append('<option selected="selected">Select Category</option>');
			
			$.get("fetchSubCategories",{ categoryCode: id }, function(data, status){

				
				$.each( data, function( key, value ) {
					
					var opt = $("<option>");
					opt.addClass("l2-cat");
					opt.attr("l2-cat-id",value.code);
					opt.html(value.name);
					l2Categories.append(opt);
					
										
				});
			});
			$('select[name="l2Categories"]').change(function() {
				var addCategory = $("#addCategory");
				var but = $("<a>");
				but.addClass("btn");
				but.addClass("btn-add-cat");
				but.addClass("btn-default");
				but.addClass("form-control");
				$('.btn-add-cat').remove();
				but.html("Add");
				var butdiv = $("#butdiv");
				butdiv.append(but);	
				
				
			});
			
		});
		
		$(document).on("click",".btn-add-cat",function(){
		        var l2catid = $("#l2Categories").children(":selected").attr("l2-cat-id");
				var l2catval = $("#l2Categories").children(":selected").val();
				var check = $("#sel"+l2catid).val();
				if (check===undefined){
					
					var wrapdiv= $("<div />");
					wrapdiv.addClass("cat-wrap")
					wrapdiv.attr("id","id-wrap-"+l2catid);
					$("#selectedcatdiv").append(wrapdiv);
					var closeSpan=$("<span />");
					closeSpan.addClass("close");
					closeSpan.addClass("removeSelCat");
					closeSpan.html("&times");
					$('#id-wrap-'+l2catid).append(closeSpan);
					var spansize=$("<h4>");
					var selcat= $("<span>");
					selcat.addClass("form-control");
					selcat.addClass("label");
					selcat.addClass("label-primary");
					selcat.attr("cat-id",l2catid);
					selcat.attr("id","sel"+l2catid);
					selcat.addClass("selectedCat");
					selcat.html(l2catval);
					spansize.append(selcat);
					$('#id-wrap-'+l2catid).append(spansize);
					}
					
	
	});
		$(document).on("click",".cat-wrap .removeSelCat",function(e){
		    var id = $(this).closest('.cat-wrap').attr('id');
		    $('#'+id).remove();
		});
				$(document).on("click", ".saveproduct", function() {
					
					var categoryList = [];
					$('.selectedCat').each(function(){
						categoryList.push( $(this).attr("cat-id"));
					});
					
					var productMediaList = [];
					$('.allImage').each(function(){
						productMediaList.push( $(this).attr("img-id"));
					});
					
					var data = {
								code: $('#code').val(),
								name: $('#name').val(), 
								productSKU: $('#productSKU').val(), 
								price: $('#price').val(), 
								description: $('#description').val(),
								productMediaList: productMediaList,
								categoryList : categoryList
							    };
					$.ajax({
						type : "POST",
						
						contentType : "application/json",
						url : "modifyProduct",
						data : JSON.stringify(data),
						dataType : 'text',
						timeout : 100000,
						success : function(data) {

							window.location = "productDetails?code="+data;

						}
					});

				});

			});
$(function () {
    $("#fileupload").change(function () {
        if (typeof (FileReader) != "undefined") {
            var dvPreview = $("#dvPreview");
            
            var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.jpg|.jpeg|.gif|.png|.bmp)$/;
            $($(this)[0].files).each(function () {
                var file = $(this);
                if (regex.test(file[0].name.toLowerCase())) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                    	
                    	
                    	$.post("addMedia",{ imageData:e.target.result }, function(data, status){

                    		var imgdiv= $("<div />");
    						imgdiv.attr("id","imgdiv"+imgID);
    						imgdiv.addClass("img-wrap");
    						dvPreview.append(imgdiv);
    						var closeSpan=$("<span />");
    						closeSpan.addClass("close");
    						closeSpan.addClass("removeImage");
    						closeSpan.html("&times");;
    						$('#imgdiv'+imgID).append(closeSpan);
                            var img = $("<img />");
                            img.attr("style", "height:100px;width: 100px");
                            img.attr("src", "images/"+data);
                            img.addClass("allImage");
                            img.attr("id", imgID);
                            img.attr("img-id", data);
                            $('#imgdiv'+imgID).append(img);
                            imgID++;
            			});
						
                    }
                    reader.readAsDataURL(file[0]);
                } else {
                    alert(file[0].name + " is not a valid image file.");
                    dvPreview.html("");
                    return false;
                }
            });
        } else {
            alert("This browser does not support HTML5 FileReader.");
        }
    });
});
$(document).on("click",".img-wrap .removeImage",function(e){
    var id = $(this).closest('.img-wrap').find('img').attr('id');
    $('#imgdiv'+id).remove();
});
</script>
</head>
<body>
        <div class="row" id="edit-content">  
            <div class="box-header with-border">
              <h3 class="box-title">Add New Product</h3>
            </div>
            <form role="form" class="col-xs-6">
              <div class="box-body">
              	<div class="form-group">
                  <label for="code">Product Code</label>
                  <input type="text" class="form-control" id="code" placeholder="Product Code" value = "${code}" disabled>
                </div>
                <div class="form-group">
                  <label for="name">Product Name</label>
                  <input type="text" class="form-control" id="name" placeholder="Product Name">
                </div>
                <div class="form-group">
                  <label for="productSKU">Product SKU</label>
                  <input type="text" class="form-control" id="productSKU" placeholder="Product SKU">
                </div>
				<div class="form-group">
                  <label for="description">Description</label>
                  <input type="text" class="form-control" id="description" placeholder="Description">
                </div>
                <div class="form-group">
                  <label for="price">Price</label>
                  <input type="text" class="form-control" id="price" placeholder="Price">
                </div>
                <div class="form-group" >
                  <label for="fileupload">Product Images</label>
                  </br>
                  
                  <label class="btn btn-default">
   				   Browse <input id="fileupload" type="file" style="display: none;">
					</label>
				
                  <p class="help-block">Select Images From Local Directory</p>
                </div>
              
        		
       				 <div id="dvPreview">
       				 </div>
				<div class="form-group" id="addCategory">

					<label for="l1Categories">Categories</label>
					
            		<div class="row">
            				<div class="col-md-4 ">
							<select class="form-control" id="l1Categories"
								name="l1Categories" >
								<option>Select Category</option>
							</select>
							</div>
								<div id="l2catdiv" class="col-md-4" >
								
								</div>
							
								<div id="butdiv" class="col-md-3"></div>
					</div>
						

								<div id="selectedcatdiv" class="col-md-4"></div>
					
				</div>

              </div>
              <div class="box-body">
              <div class="form-group">
                <a class="btn btn-primary saveproduct">Save Product</a>
              </div>
              </div>
            </form>
          </div>



          
</body>
</html>	
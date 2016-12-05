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

	$('#level').change(function() {
		var slvl = $('select[name="level"]').val();
		if(slvl === 'L2'){
			$.get("fetchTopCategories", function(data, status){
				
				var l1Categories = $("#supercategory");
				$.each( data, function( key, value ) {
					var opt = $("<option>");
					opt.val(value.code);
					opt.html(value.name);
					
					l1Categories.append(opt);
				});
		
	    	$('#l1div').show();
	    	
	    	});
			
		}
		else{
			$("#supercategory").html("");
			$('#l1div').hide();
		}
	});
	});
$(document).ready(function(){
		  
		$('select[name="l1Categories"]').change(function() {
			
			var lvl = $(this).children(":selected").val();
			if(lvl === 'L2'){
			$('.btn-add-cat').remove();
			$("#l2Categories").remove();
			var l2Select= $("<select>");
			l2Select.addClass("form-control")
			l2Select.attr("id","l2Categories");
			l2Select.attr("name","l2Categories");
			var l2catdiv = $("#l2catdiv");
			l2catdiv.append(l2Select);
            var l2Categories = $("#l2Categories");
            l2Categories.html("");
			
			$.get("fetchTopCategories", function(data, status){
				l2Categories.append('<option value="none" selected="selected">Select Category</option>');
				
				$.each( data, function( key, value ) {
					
					var opt = $("<option>");
					opt.addClass("l2-cat");
					opt.attr("l2-cat-id",value.code);
					opt.html(value.name);
					l2Categories.append(opt);
					
										
				});
			});
			}
			
		});
		
				$(document).on("click", ".saveCategory", function() {
					
				
					
					var data = {
								name: $('#name').val(), 
								level: $('#level').val(),
								description: $('#description').val(),
								superCategory: $('#supercategory').val(),
								iconURL : $('.catIcon').attr("img-id")
							    };
					$.ajax({
						type : "POST",
						
						contentType : "application/json",
						url : "addNewCategory",
						data : JSON.stringify(data),
						dataType : 'text',
						timeout : 100000,
						success : function(data) {

							window.location = "categoryDetails?code="+data;

						}
					});

				});

			});
$(function () {
    $("#fileupload").change(function () {
        if (typeof (FileReader) != "undefined") {
            var dvPreview = $("#dvPreview");
            
            var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.png)$/;
            $($(this)[0].files).each(function () {
                var file = $(this);
                if (regex.test(file[0].name.toLowerCase())) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                    	
                    	
                    	$.post("addIcon",{ iconData:e.target.result }, function(data, status){
                    		dvPreview.html("");
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
                            img.addClass("catIcon");
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
<!-- general form elements -->
        <div class="row" id="edit-content">  
            <div class="box-header with-border">
              <h3 class="box-title">Add New Product</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" class="col-xs-6">
              <div class="box-body">
                <div class="form-group">
                  <label for="name">Category Name</label>
                  <input type="text" class="form-control" id="name" placeholder="Category Name">
                </div>
				<div class="form-group">
                  <label for="description">Description</label>
                  <input type="text" class="form-control" id="description" placeholder="Description">
                </div>
                <div class="form-group">
                  <label for="level">Level</label>
                  	<select class="form-control" id="level"name="level" >
								<option value="none">Select Category</option>
								<option value="L1">L1</option>
								<option value="L2">L2</option>
				  	</select>
                </div>
                <div class="form-group" style="display:none" id="l1div">
                  <label for="supercategory">Super Category</label>
                  	<select class="form-control" id="supercategory"name="supercategory" >
								<option value="none">Select Category</option>
								
				  	</select>
                </div>
                <div class="form-group" >
                  <label for="fileupload">Category Icon</label>
                  </br>
                  
                  <label class="btn btn-default">
   				   Browse <input id="fileupload" type="file" style="display: none;">
					</label>
				
                  <p class="help-block">Select Images From Local Directory</p>
                </div>
              
        		
       				 <div id="dvPreview">
       				 </div>

              </div>
              <div class="box-body">
              <div class="form-group">
                <a class="btn btn-primary saveCategory">Save Category</a>
              </div>
              </div>
            </form>
          </div>
  
</body>
</html>	
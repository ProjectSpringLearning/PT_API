<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>LOGIN</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/font-awesome/css/font-awesome.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/jquery.js"></script>
</head>
<body>
		<div class="container-fluid">
				<div class="row">
							<div class="col-xs-*">
										<div class="jumbotron">
											<div class="doCenter">
													<div class="text text-header">
																<h2 class="text">WS LOGIN</h2>
														</div>
															<div class="col-md-*">
																	 <form id="frmLogin" method="POST">
																	    <div>
																	      <input type="email"  id="email" name="email">
																	    </div>
																	    <div class="form-group">
																	      <input type="password"  id="pwd" name="password">
																	    </div>
																	    <button type="submit" class="btn btn-success">Submit</button>
																	  </form>
															</div>
										</div>
								</div>
					</div>
			</div>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
			/*FUNCTION*/
        $(function() 
        {
        	/*FROM*/
        	$("#frmLogin").submit(function(e)
        	{
       					e.preventDefault();
       				$.ajax(
       					{
  	            		url: "${pageContext.request.contextPath}/",
  	            		type: "POST",
  	            		data: $("#frmLogin").serialize(),
   	            		beforeSend: function (xhr) 
   	            		{
   	                		xhr.setRequestHeader("X-Ajax-call", "true");
   	            		},
  	            		success: function(data)
  	            		{
  	            				if(data == "User account is locked")
  	            				{
  	            							alert(data);
  	            				}
  	            				else if(data == "User is disabled")
  	            				{
  	            								alert(data);
  	            					}
  	            				 else if(data == "Bad credentials")
  	            				 {
  	            									alert(data);
  	            					}
  	            					else
  	            					{
  	            												alert("Logined success." + data);
  																			location.href = "${pageContext.request.contextPath}/"+data;
  	      									}	
  	            },
  	         		error: function(data)
  	         		{
  	         				console.log(data);
  							}
  	        });
      });
       /*END FROM*/
       
       /*USER*/
        	$.ajax(
        	{ 
								    url: "http://localhost:8080/api/user", 
								    type: 'GET', 
			    					beforeSend: function(xhr) 
			    					{
			                    xhr.setRequestHeader("Accept", "application/json");
			                    xhr.setRequestHeader("Content-Type", "application/json");
			                    xhr.setRequestHeader("Authorization" , "Basic a3NsOmtzbGFwaQ==");
                		},
                			success: function(data) 
                		{ 
													console.log(data);
			    					},
			    						error:function(data,status,er)
			    					{ 
			        					console.log("error: "+data+" status: "+status+" er:"+er);
			    					}
						});
        	/*END USER*/
        });
    /*END FUNCTION*/ 
        </script>
</body>
</html>
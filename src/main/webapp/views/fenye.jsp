<%@ include file="../common/include_tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script type="text/javascript" src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/bootstrap-paginator.js'/>"></script>
<script>
  $(function () {
    var carId = 1;
    $.ajax({
      url: 'listUser2',
      contentType : 'application/json',
      datatype: "text",
      type: 'post',
      data: "page=" + carId,
      success: function (data) {
        if (data != null) {
          createTable(data);
          var pageCount = eval(data).totalCount; //取到pageCount的值(把返回数据转成object类型)
          var currentPage = eval(data).currentPage; //得到currentPage
          var options = {
        	numberOfPages:6,//页数
            bootstrapMajorVersion: 3, //版本
            currentPage: currentPage, //当前页数
            totalPages: pageCount, //总页数
            //点击事件，用于通过Ajax来刷新整个list列表
            onPageClicked: function (event, originalEvent, type, page) {
              $.ajax({
                  url: 'listUser2',
                  contentType : 'application/json',
                  datatype: "text",
                  type: 'post',
                  data: "page=" + (currentPage+1),
                  success: function (data) {
                  if (data != null) {
                	  createTable(data);
                  }
                }
              });
            }
          };
          $('#example').bootstrapPaginator(options);
        }
      }
    });
  });
  
  function createTable(data)  
  { 
	 $("#data_table").remove();
     var table=$('<table id="data_table" class="table table-striped">');  
     table.appendTo($("#list")); 
     table.append('<thead><tr> <th>#</th><th>First Name</th><th>Last Name</th><th>Username</th></tr></thead>');
     $.each(eval( data ).items, function (index, item) { //遍历返回的json
    	 var tr=$("<tr></tr>");  
         tr.appendTo(table);  
         var th=$('<th scope="row">'+(index+1)+'</th>');
         var td1=$("<td>"+item.id +"</td>"); 
         var td2=$("<td>"+item.title +"</td>"); 
         var td3=$("<td>"+item.author +"</td>"); 
         th.appendTo(tr);
         td1.appendTo(tr); 
         td2.appendTo(tr); 
         td3.appendTo(tr); 
       }); 
     $("#list").append("</table>");  
  }  
</script>
</head>
<body>
<div>
<div id="list"></div>
<nav><ul id="example"></ul></nav>
</div>

    <table class="table table-striped">
      <thead>
        <tr>
          <th>#</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </table>


<!-- 分页开始 -->
<div class="left">共${userNum}条记录</div>
<nav>
<ul class="pagination pagination-centered">
<c:if test="${currentPage == 1}">
	<li><span aria-hidden="true">&laquo;</span></li>
</c:if> 
<c:if test="${currentPage != 1}">
		<li><a href="<c:url value='/user/listUser'/>?page=${currentPage-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a></li>
</c:if> 
<%
 	int pageTimes = (Integer) request.getAttribute("pageTimes");
 	for (int i = 1; i < pageTimes+1; i++) {
 		request.setAttribute("page", i );
 %> 
 <c:if test="${currentPage == page}">
 	<li class="active"><a href="#"><%=i%><span class="sr-only">(current)</span></a></li>
</c:if> 
<c:if test="${currentPage != page}">
	<li ><a href="<c:url value='/user/listUser'/>?page=<%=i%>"><%=i%><span class="sr-only"></span></a></li>
</c:if> <%
 	}
 %> 
 <c:if test="${currentPage == pageTimes}">
 	<li><span aria-hidden="true">&raquo;</span></li>
</c:if> 
<c:if test="${currentPage != pageTimes}">
	<li><a href="<c:url value='/user/listUser'/>?page=${currentPage+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a></li>
</c:if>
</ul>
</nav>
</div>
<!-- 分页结束-->
<%@ include file="../common/footer.jsp"%>
</body>
</html>
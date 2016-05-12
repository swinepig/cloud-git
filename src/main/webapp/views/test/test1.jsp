<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script type="text/javascript"
	src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript"
	src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<ul class="thumbnails">
						<li class="span4">
							<div class="thumbnail">
								<img alt="300x200" src="http://www.bootcss.com/p/layoutit/img/people.jpg" />
								<div class="caption">
									<h3>冯诺尔曼结构</h3>
									<p>
										也称普林斯顿结构，是一种将程序指令存储器和数据存储器合并在一起的存储器结构。程序指令存储地址和数据存储地址指向同一个存储器的不同物理位置。
									</p>
									<p>
										<a class="btn btn-primary" href="#">浏览</a> <a class="btn"
											href="#">分享</a>
									</p>
								</div>
							</div></li>
						<li class="span4">
							<div class="thumbnail">
								<img alt="300x200" src="http://www.bootcss.com/p/layoutit/img/people.jpg" />
								<div class="caption">
									<h3>哈佛结构</h3>
									<p>
										哈佛结构是一种将程序指令存储和数据存储分开的存储器结构，它的主要特点是将程序和数据存储在不同的存储空间中，进行独立编址。</p>
									<p>
										<a class="btn btn-primary" href="#">浏览</a> <a class="btn"
											href="#">分享</a>
									</p>
								</div>
							</div></li>
						<li class="span4">
							<div class="thumbnail">
								<img alt="300x200" src="http://www.bootcss.com/p/layoutit/img/people.jpg" />
								<div class="caption">
									<h3>改进型哈佛结构</h3>
									<p>
										改进型的哈佛结构具有一条独立的地址总线和一条独立的数据总线，两条总线由程序存储器和数据存储器分时复用，使结构更紧凑。</p>
									<p>
										<a class="btn btn-primary" href="#">浏览</a> <a class="btn"
											href="#">分享</a>
									</p>
								</div>
							</div></li>
					</ul>
					<table class="table">
						<thead>
							<tr>
								<th>编号</th>
								<th>产品</th>
								<th>交付时间</th>
								<th>状态</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>TB - Monthly</td>
								<td>01/04/2012</td>
								<td>Default</td>
							</tr>
							<tr class="success">
								<td>1</td>
								<td>TB - Monthly</td>
								<td>01/04/2012</td>
								<td>Approved</td>
							</tr>
							<tr class="error">
								<td>2</td>
								<td>TB - Monthly</td>
								<td>02/04/2012</td>
								<td>Declined</td>
							</tr>
							<tr class="warning">
								<td>3</td>
								<td>TB - Monthly</td>
								<td>03/04/2012</td>
								<td>Pending</td>
							</tr>
							<tr class="info">
								<td>4</td>
								<td>TB - Monthly</td>
								<td>04/04/2012</td>
								<td>Call in to confirm</td>
							</tr>
						</tbody>
					</table>
					<nav>
						<ul class="pagination pagination-centered">
							<li><a href="#">上一页</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">下一页</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp"%>
</body>
</html>
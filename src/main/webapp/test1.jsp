<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Test1</title>
	<link rel="stylesheet" href="css/test.css">
</head>
<body>
	<div class="button-group">
	  	<button class="button active" onclick="redirectToPage('test1.jsp')">Tiểu học</button>
	 	<button class="button" onclick="redirectToPage('test2.jsp')">THCS</button>
	  	<button class="button" onclick="redirectToPage('test3.jsp')">THPT</button>
	  	<script src="js/test.js"></script>
	</div>
	<div>
		<h3>Tiểu học</h3>
		<ul>
			<li>
		  		<a href="#" onclick="toggleContent('content1')">Lớp 1</a>
			</li>
			<li>
		  		<a href="#" onclick="toggleContent('content2')">Lớp 2</a>
		 	</li>
		 	<li>
		   		<a href="#" onclick="toggleContent('content3')">Lớp 3</a>
		 	</li>
		 	<li>
		   		<a href="#" onclick="toggleContent('content4')">Lớp 4</a>
		 	</li>
		 	<li>
		   		<a href="#" onclick="toggleContent('content5')">Lớp 5</a>
		 	</li>
		</ul>
	</div>
	<div>
		<div id="content1" class="class-content">
	      <h3>Môn học:</h3>
	      <ul>
	        <li><a href="#" onclick="showCourse('course11')">Môn học 11</a></li>
	        <li><a href="#" onclick="showCourse('course12')">Môn học 12</a></li>
	        <li><a href="#" onclick="showCourse('course13')">Môn học 13</a></li>
	      </ul>
	      <div id="course11" class="course-content">
	        Nội dung khóa học cho Môn học 11
	      </div>
	      <div id="course12" class="course-content">
	        Nội dung khóa học cho Môn học 12
	      </div>
	      <div id="course13" class="course-content">
	        Nội dung khóa học cho Môn học 13
	      </div>
	    </div>
	    <div id="content2" class="class-content">
	      <h3>Môn học:</h3>
	      <ul>
	        <li><a href="#" onclick="showCourse('course21')">Môn học 21</a></li>
	        <li><a href="#" onclick="showCourse('course22')">Môn học 22</a></li>
	        <li><a href="#" onclick="showCourse('course23')">Môn học 23</a></li>
	      </ul>
	      <div id="course21" class="course-content">
	        Nội dung khóa học cho Môn học 21
	      </div>
	      <div id="course22" class="course-content">
	        Nội dung khóa học cho Môn học 22
	      </div>
	      <div id="course23" class="course-content">
	        Nội dung khóa học cho Môn học 23
	      </div>
	    </div>
	    <div id="content3" class="class-content">
	      <h3>Môn học:</h3>
	      <ul>
	        <li><a href="#" onclick="showCourse('course31')">Môn học 31</a></li>
	        <li><a href="#" onclick="showCourse('course32')">Môn học 32</a></li>
	        <li><a href="#" onclick="showCourse('course33')">Môn học 33</a></li>
	      </ul>
	      <div id="course31" class="course-content">
	        Nội dung khóa học cho Môn học 31
	      </div>
	      <div id="course32" class="course-content">
	        Nội dung khóa học cho Môn học 32
	      </div>
	      <div id="course33" class="course-content">
	        Nội dung khóa học cho Môn học 33
	      </div>
	    </div>
	    <div id="content4" class="class-content">
	      <h3>Môn học:</h3>
	      <ul>
	        <li><a href="#" onclick="showCourse('course41')">Môn học 41</a></li>
	        <li><a href="#" onclick="showCourse('course42')">Môn học 42</a></li>
	        <li><a href="#" onclick="showCourse('course43')">Môn học 43</a></li>
	      </ul>
	      <div id="course41" class="course-content">
	        Nội dung khóa học cho Môn học 41
	      </div>
	      <div id="course42" class="course-content">
	        Nội dung khóa học cho Môn học 42
	      </div>
	      <div id="course43" class="course-content">
	        Nội dung khóa học cho Môn học 43
	      </div>
	    </div>
	    <div id="content5" class="class-content">
	      <h3>Môn học:</h3>
	      <ul>
	        <li><a href="#" onclick="showCourse('course51')">Môn học 51</a></li>
	        <li><a href="#" onclick="showCourse('course52')">Môn học 52</a></li>
	        <li><a href="#" onclick="showCourse('course53')">Môn học 53</a></li>
	      </ul>
	      <div id="course51" class="course-content">
	        Nội dung khóa học cho Môn học 51
	      </div>
	      <div id="course52" class="course-content">
	        Nội dung khóa học cho Môn học 52
	      </div>
	      <div id="course53" class="course-content">
	        Nội dung khóa học cho Môn học 53
	      </div>
	    </div>
	</div>
</body>
</html>
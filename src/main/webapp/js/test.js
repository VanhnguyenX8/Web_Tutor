// Lấy tất cả các nút bằng cách sử dụng querySelectorAll
const buttons = document.querySelectorAll('.button');

// Lặp qua từng nút và gắn sự kiện nhấp chuột
buttons.forEach(button => {
  button.addEventListener('click', () => {
    // Xóa lớp .active khỏi tất cả các nút
    buttons.forEach(btn => btn.classList.remove('active'));

    // Thêm lớp .active vào nút được nhấp
    button.classList.add('active');
  });
});

function redirectToPage(pageUrl) {
  window.location.href = pageUrl;
}

function showContent(contentId) {
  var contents = document.getElementsByClassName('class-content');
  for (var i = 0; i < contents.length; i++) {
    contents[i].classList.remove('active');
  }
  var contentToShow = document.getElementById(contentId);
  contentToShow.classList.add('active');
}

function toggleContent(contentId) {
  var contents = document.getElementsByClassName('class-content');
  for (var i = 0; i < contents.length; i++) {
    contents[i].classList.remove('active');
  }
  var contentToShow = document.getElementById(contentId);
  contentToShow.classList.add('active');
}

function showCourse(courseId) {
  var courses = document.getElementsByClassName('course-content');
  for (var i = 0; i < courses.length; i++) {
    courses[i].classList.remove('active');
  }
  var courseToShow = document.getElementById(courseId);
  courseToShow.classList.add('active');
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2023-06-09 15:49:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Service.LopHocService;
import Model.UserGS;
import Controller.HomeServlet;

public final class trangchu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("Service.LopHocService");
    _jspx_imports_classes.add("Model.UserGS");
    _jspx_imports_classes.add("Controller.HomeServlet");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"ISO-8859-1\" />\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("    <title>Trang chủ</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/trangchu.css\" />\r\n");
      out.write("    <script\r\n");
      out.write("      src=\"https://kit.fontawesome.com/b7bb3a4b72.js\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("    ></script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <!-- Phần đầu -->\r\n");
      out.write("    <div id=\"toanbotrang\">\r\n");
      out.write("      <div id=\"phandau\">\r\n");
      out.write("        <div class=\"baobocitemphandau\">\r\n");
      out.write("          <div class=\"menucackhoahoc\">\r\n");
      out.write("            <div class=\"vungkichhoatmenu\">\r\n");
      out.write("              <i class=\"fa-solid fa-bars\"></i>\r\n");
      out.write("              <span class=\"motabieutuong\" style=\"padding-right: 5px; color: white\">Các khóa học</span>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div id=\"timkiem\">\r\n");
      out.write("            <input type=\"text\" class=\"input\" placeholder=\"Tìm kiếm khóa học\" />\r\n");
      out.write("            <button type=\"submit\" class=\"nuttimkiem\">\r\n");
      out.write("              <i class=\"fa fa-search\"></i>\r\n");
      out.write("            </button>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <img class=\"anhiconlogo\" src=\"logo.\" alt=\"\" />\r\n");
      out.write("          <div class=\"nguoidung\">\r\n");
      out.write("          ");

		    // Lấy thông tin từ session
		    Object value = session.getAttribute("acc");
		    String position = (String) request.getAttribute("position");
		  
      out.write("\r\n");
      out.write("		  ");
 if ("admin".equals(position)) { 
      out.write("\r\n");
      out.write("		  	<li class=\"thongtin-nguoidung\">\r\n");
      out.write("              <a href=\"\" class=\"avt items\">\r\n");
      out.write("                <div class=\"avt-box\"></div>\r\n");
      out.write("              </a>\r\n");
      out.write("              <div class=\"danhsach sub\">\r\n");
      out.write("                <ul class=\"danhsachcon\">\r\n");
      out.write("                  <li class=\"taikhoan\">\r\n");
      out.write("                    <div class=\"avatar\"></div>\r\n");
      out.write("                    <div class=\"thongtin\">\r\n");
      out.write("                    ");

    					String Name = (String) request.getAttribute("Name");
                    	String email = (String) request.getAttribute("email");
					
      out.write("\r\n");
      out.write("                      <p class=\"ten\">Admin</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li>\r\n");
      out.write("                    <a href=\"#\" class=\"link\">\r\n");
      out.write("                      <span>DashBoard</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li>\r\n");
      out.write("                    <a href=\"HomeServlet?logout=true\" class=\"link\">\r\n");
      out.write("                      <span>Đăng xuất</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("		  ");
} 
      out.write("\r\n");
      out.write("          ");
 if (position.equals("hocsinh") || "giasu".equals(position)) { 
      out.write("\r\n");
      out.write("			<li class=\"thongtin-nguoidung\">\r\n");
      out.write("              <a href=\"\" class=\"avt items\">\r\n");
      out.write("                <div class=\"avt-box\"></div>\r\n");
      out.write("              </a>\r\n");
      out.write("              <div class=\"danhsach sub\">\r\n");
      out.write("                <ul class=\"danhsachcon\">\r\n");
      out.write("                  <li class=\"taikhoan\">\r\n");
      out.write("                    <div class=\"avatar\"></div>\r\n");
      out.write("                    <div class=\"thongtin\">\r\n");
      out.write("                    ");

    					String Name = (String) request.getAttribute("Name");
                    	String email = (String) request.getAttribute("email");
					
      out.write("\r\n");
      out.write("                      <p class=\"ten\">");
      out.print( Name );
      out.write("</p>\r\n");
      out.write("                      <p class=\"email\">");
      out.print( email );
      out.write("</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li>\r\n");
      out.write("                    <a href=\"/Web_Tutor/profileGS\" class=\"link\">\r\n");
      out.write("                      <span>Thông tin cá nhân</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li>\r\n");
      out.write("                    <a href=\"\" class=\"link\">\r\n");
      out.write("                      <span>Đổi mật khẩu</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li>\r\n");
      out.write("                    <a href=\"HomeServlet?logout=true\" class=\"link\">\r\n");
      out.write("                      <span>Đăng xuất</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                  </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>			        \r\n");
      out.write("			");
 } 
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div id=\"khoahoc-content\">\r\n");
      out.write("        <div class=\"wrapper-khoahoc\">\r\n");
      out.write("          <div class=\"duongdan\"></div>\r\n");
      out.write("          <div class=\"conten-wrapper\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"container_border_banner\">\r\n");
      out.write("        <div class=\"stack container_border_cac_khoa_hoc\">\r\n");
      out.write("          <ul class=\"menu_khoa_hoc\">\r\n");
      out.write("            <p>Các khóa học</p>\r\n");
      out.write("            <li class=\"has_submenu\">\r\n");
      out.write("              Đại học - Cao đẳng\r\n");
      out.write("              <div class=\"container_menu_child\">\r\n");
      out.write("                <ul class=\"menu_khoa_hoc_child\">\r\n");
      out.write("                  <li>Toán Cao Cấp</li>\r\n");
      out.write("                  <li>Lý cao cấp</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"has_submenu\">\r\n");
      out.write("              Khóa học bổ trợ\r\n");
      out.write("              <div class=\"container_menu_child\">\r\n");
      out.write("                <ul class=\"menu_khoa_hoc_child\">\r\n");
      out.write("                  <li>Ngữ Văn</li>\r\n");
      out.write("                  <li>Tiếng Anh</li>\r\n");
      out.write("                  <li>Toán</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"has_submenu\">\r\n");
      out.write("              Bồi dưỡng học sinh giỏi\r\n");
      out.write("              <div class=\"container_menu_child\">\r\n");
      out.write("                <ul class=\"menu_khoa_hoc_child\">\r\n");
      out.write("                  <li>Toán</li>\r\n");
      out.write("                  <li>Ngữ văn</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"has_submenu\">\r\n");
      out.write("              Luyện thi đại học\r\n");
      out.write("              <div class=\"container_menu_child\">\r\n");
      out.write("                <ul class=\"menu_khoa_hoc_child\">\r\n");
      out.write("                  <li>Toán</li>\r\n");
      out.write("                  <li>Ngữ văn</li>\r\n");
      out.write("                  <li>Tiếng Anh</li>\r\n");
      out.write("                  <li>Vật lý</li>\r\n");
      out.write("                  <li>Hóa học</li>\r\n");
      out.write("                  <li>Sinh học</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"has_submenu\">\r\n");
      out.write("              Lớp 10 - Lớp 11 - Lớp 12\r\n");
      out.write("              <div class=\"container_menu_child\">\r\n");
      out.write("                <ul class=\"menu_khoa_hoc_child\">\r\n");
      out.write("                  <li>Toán</li>\r\n");
      out.write("                  <li>Ngữ văn</li>\r\n");
      out.write("                  <li>Tiếng Anh</li>\r\n");
      out.write("                  <li>Vật lý</li>\r\n");
      out.write("                  <li>Hóa học</li>\r\n");
      out.write("                  <li>Sinh học</li>\r\n");
      out.write("                  <li>Lịch sử</li>\r\n");
      out.write("                  <li>Địa lý</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"has_submenu\">\r\n");
      out.write("              Luyện thi vào 10\r\n");
      out.write("              <div class=\"container_menu_child\">\r\n");
      out.write("                <ul class=\"menu_khoa_hoc_child\">\r\n");
      out.write("                  <li>Toán</li>\r\n");
      out.write("                  <li>Ngữ văn</li>\r\n");
      out.write("                  <li>Tiếng Anh</li>\r\n");
      out.write("                  <li>Vật lý</li>\r\n");
      out.write("                  <li>Hóa học</li>\r\n");
      out.write("                  <li>Sinh học</li>\r\n");
      out.write("                  <li>Lịch sử</li>\r\n");
      out.write("                  <li>Địa lý</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"has_submenu\">\r\n");
      out.write("              Lớp 6 - Lớp 7 - Lớp 8 - Lớp 9\r\n");
      out.write("              <div class=\"container_menu_child\">\r\n");
      out.write("                <ul class=\"menu_khoa_hoc_child\">\r\n");
      out.write("                  <li>Toán</li>\r\n");
      out.write("                  <li>Ngữ văn</li>\r\n");
      out.write("                  <li>Tiếng Anh</li>\r\n");
      out.write("                  <li>Vật lý</li>\r\n");
      out.write("                  <li>Hóa học</li>\r\n");
      out.write("                  <li>Sinh học</li>\r\n");
      out.write("                  <li>Lịch sử</li>\r\n");
      out.write("                  <li>Địa lý</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"has_submenu\">\r\n");
      out.write("              Luyện thi vào 6\r\n");
      out.write("              <div class=\"container_menu_child\">\r\n");
      out.write("                <ul class=\"menu_khoa_hoc_child\">\r\n");
      out.write("                  <li>Toán</li>\r\n");
      out.write("                  <li>Ngữ văn</li>\r\n");
      out.write("                  <li>Tiếng Anh</li>\r\n");
      out.write("                  <li>Vật lý</li>\r\n");
      out.write("                  <li>Hóa học</li>\r\n");
      out.write("                  <li>Sinh học</li>\r\n");
      out.write("                  <li>Lịch sử</li>\r\n");
      out.write("                  <li>Địa lý</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"has_submenu\">\r\n");
      out.write("              Lớp 1 - Lớp 2 - Lớp 3 - Lớp 4 - Lớp 5\r\n");
      out.write("              <div class=\"container_menu_child\">\r\n");
      out.write("                <ul class=\"menu_khoa_hoc_child\">\r\n");
      out.write("                  <li>Tiếng Viêt</li>\r\n");
      out.write("                  <li>Toán</li>\r\n");
      out.write("                  <li>Tiếng Anh</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- phần các khóa học-->\r\n");
      out.write("        <div\r\n");
      out.write("          class=\"stack banner_top\"\r\n");
      out.write("          style=\"background-color: #b2b2b2; overflow: hidden\"\r\n");
      out.write("        >\r\n");
      out.write("          <p style=\"text-align: center\">\r\n");
      out.write("            Ưu đã lên tới 35%! Cùng con lớp 4-10 chinh phục 9,10 Toán Văn tại\r\n");
      out.write("            HOCMAI.VN\r\n");
      out.write("          </p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div\r\n");
      out.write("          class=\"stack banner_img\"\r\n");
      out.write("          style=\"background-color: #b2b2b2; overflow: hidden\"\r\n");
      out.write("        >\r\n");
      out.write("          <img src=\"../assets/images/clone_banner.png\" alt=\"\" />\r\n");
      out.write("        </div>\r\n");
      out.write("        <div\r\n");
      out.write("          class=\"stack banner_img_bottom\"\r\n");
      out.write("          style=\"background-color: #b2b2b2; overflow: hidden\"\r\n");
      out.write("        >\r\n");
      out.write("          <img width=\"100%\" src=\"../assets/images/banner_bottom.png\" alt=\"\" />\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div style=\"height: 70px\"></div>\r\n");
      out.write("      <!-- Trung học phổ thông -->\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("	    <h1 style=\"padding-left: 60px\">Trung học phổ thông</h1>\r\n");
      out.write("	    <hr>\r\n");
      out.write("	    <br>\r\n");
      out.write("	    <div class=\"row\">\r\n");
      out.write("	        <div colspan=\"6\">\r\n");
      out.write("	            <div><img class=\"images_thpt\"\r\n");
      out.write("	                      src=\"https://r73troypb4obj.vcdn.cloud/website02/uploads/images/62318bba1a1b854d4e90223a/danh-gia-truong-thpt-a-phu-ly-ha-nam-co-tot-khong.jpg\"\r\n");
      out.write("	                      alt=\"\"\r\n");
      out.write("	                      width=\"400\"\r\n");
      out.write("	                      height=\"400\"></div>\r\n");
      out.write("	        </div>\r\n");
      out.write("	        	");
 List<UserGS> list3lv3 = (List<UserGS>) request.getAttribute("list3lv3");
				   if (list3lv3 != null) {
				       for (UserGS gs : list3lv3) { 
      out.write("\r\n");
      out.write("				           <div class=\"col 2 table_thpt_item\" align=\"center\">\r\n");
      out.write("				               <img src=\"");
      out.print( gs.getImg() );
      out.write("\" alt=\"\" width=\"200\" height=\"200\">\r\n");
      out.write("				               <p><a href=\"profileGS?id=");
      out.print( gs.getIdGS() );
      out.write("\">Giáo Viên: ");
      out.print( gs.getTenGS() );
      out.write("</a></p>\r\n");
      out.write("				               <p1>");
      out.print( gs.getMonHoc().getTenMH() );
      out.write("</p1>\r\n");
      out.write("				               <p1>Số lớp học: ");
      out.print( gs.getCountLH() );
      out.write("</p1>\r\n");
      out.write("				           </div>\r\n");
      out.write("				    ");
 }
				   } 
      out.write("\r\n");
      out.write("		    </div>\r\n");
      out.write("	    <br>\r\n");
      out.write("    	<br>\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("		    ");
 List<UserGS> list4lv3 = (List<UserGS>) request.getAttribute("list4lv3");
		       if (list4lv3 != null) {
		           for (UserGS gs : list4lv3) { 
      out.write("\r\n");
      out.write("		               ");
 int count = 5; 
      out.write("\r\n");
      out.write("		               <div class=\"col 3 table_thpt_item\" align=\"center\">\r\n");
      out.write("		                   <img src=\"");
      out.print( gs.getImg() );
      out.write("\" alt=\"\" width=\"200\" height=\"200\">\r\n");
      out.write("		                   <p><a href=\"profileGS?id=");
      out.print( gs.getIdGS() );
      out.write("\">Giáo Viên: ");
      out.print( gs.getTenGS() );
      out.write("</a></p>\r\n");
      out.write("		                   <p>");
      out.print( gs.getMonHoc().getTenMH() );
      out.write("</p>\r\n");
      out.write("		                   <p>Số lớp học: ");
      out.print( gs.getCountLH() );
      out.write("</p>\r\n");
      out.write("		               </div>\r\n");
      out.write("		       ");
 }
		       } 
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("    <!-- Trung học cơ sở -->\r\n");
      out.write("	<div style=\"height: 60px;\"></div>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("	    <h1 style=\"padding-left: 60px\">Trung học cơ sở</h1>\r\n");
      out.write("	    <hr>\r\n");
      out.write("	    <br>\r\n");
      out.write("	    <div class=\"row\">\r\n");
      out.write("	        <div colspan=\"6\">\r\n");
      out.write("	            <div><img class=\"images_thpt\"\r\n");
      out.write("	                      src=\"https://r73troypb4obj.vcdn.cloud/website02/uploads/images/62318bba1a1b854d4e90223a/danh-gia-truong-thpt-a-phu-ly-ha-nam-co-tot-khong.jpg\"\r\n");
      out.write("	                      alt=\"\"\r\n");
      out.write("	                      width=\"400\"\r\n");
      out.write("	                      height=\"400\"></div>\r\n");
      out.write("	        </div>\r\n");
      out.write("	        	");
 List<UserGS> list3lv2 = (List<UserGS>) request.getAttribute("list3lv2");
				   if (list3lv3 != null) {
				       for (UserGS gs : list3lv3) { 
      out.write("\r\n");
      out.write("				           <div class=\"col 2 table_thpt_item\" align=\"center\">\r\n");
      out.write("				               <img src=\"");
      out.print( gs.getImg() );
      out.write("\" alt=\"\" width=\"200\" height=\"200\">\r\n");
      out.write("				               <p><a href=\"profileGS?id=");
      out.print( gs.getIdGS() );
      out.write("\">Giáo Viên: ");
      out.print( gs.getTenGS() );
      out.write("</a></p>\r\n");
      out.write("				               <p1>");
      out.print( gs.getMonHoc().getTenMH() );
      out.write("</p1>\r\n");
      out.write("				               <p1>Số lớp học: ");
      out.print( gs.getCountLH() );
      out.write("</p1>\r\n");
      out.write("				           </div>\r\n");
      out.write("				    ");
 }
				   } 
      out.write("\r\n");
      out.write("		    </div>\r\n");
      out.write("	    <br>\r\n");
      out.write("    	<br>\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("		    ");
 List<UserGS> list4lv2 = (List<UserGS>) request.getAttribute("list4lv2");
		       if (list4lv3 != null) {
		           for (UserGS gs : list4lv3) { 
      out.write("\r\n");
      out.write("		               ");
 int count = 5; 
      out.write("\r\n");
      out.write("		               <div class=\"col 3 table_thpt_item\" align=\"center\">\r\n");
      out.write("		                   <img src=\"");
      out.print( gs.getImg() );
      out.write("\" alt=\"\" width=\"200\" height=\"200\">\r\n");
      out.write("		                   <p><a href=\"profileGS?id=");
      out.print( gs.getIdGS() );
      out.write("\">Giáo Viên: ");
      out.print( gs.getTenGS() );
      out.write("</a></p>\r\n");
      out.write("		                   <p>");
      out.print( gs.getMonHoc().getTenMH() );
      out.write("</p>\r\n");
      out.write("		                   <p>Số lớp học: ");
      out.print( gs.getCountLH() );
      out.write("</p>\r\n");
      out.write("		               </div>\r\n");
      out.write("		       ");
 }
		       } 
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("    <!-- tiểu học -->\r\n");
      out.write("	<div style=\"height: 60px;\"></div>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("	    <h1 style=\"padding-left: 60px\">Tiểu học</h1>\r\n");
      out.write("	    <hr>\r\n");
      out.write("	    <br>\r\n");
      out.write("	    <div class=\"row\">\r\n");
      out.write("	        <div colspan=\"6\">\r\n");
      out.write("	            <div><img class=\"images_thpt\"\r\n");
      out.write("	                      src=\"https://r73troypb4obj.vcdn.cloud/website02/uploads/images/62318bba1a1b854d4e90223a/danh-gia-truong-thpt-a-phu-ly-ha-nam-co-tot-khong.jpg\"\r\n");
      out.write("	                      alt=\"\"\r\n");
      out.write("	                      width=\"400\"\r\n");
      out.write("	                      height=\"400\"></div>\r\n");
      out.write("	        </div>\r\n");
      out.write("	        	");
 List<UserGS> list3lv1 = (List<UserGS>) request.getAttribute("list3lv3");
				   if (list3lv3 != null) {
				       for (UserGS gs : list3lv3) { 
      out.write("\r\n");
      out.write("				           <div class=\"col 2 table_thpt_item\" align=\"center\">\r\n");
      out.write("				               <img src=\"");
      out.print( gs.getImg() );
      out.write("\" alt=\"\" width=\"200\" height=\"200\">\r\n");
      out.write("				               <p><a href=\"profileGS?id=");
      out.print( gs.getIdGS() );
      out.write("\">Giáo Viên: ");
      out.print( gs.getTenGS() );
      out.write("</a></p>\r\n");
      out.write("				               <p1>");
      out.print( gs.getMonHoc().getTenMH() );
      out.write("</p1>\r\n");
      out.write("				               <p1>Số lớp học: ");
      out.print( gs.getCountLH() );
      out.write("</p1>\r\n");
      out.write("				           </div>\r\n");
      out.write("				    ");
 }
				   } 
      out.write("\r\n");
      out.write("		    </div>\r\n");
      out.write("	    <br>\r\n");
      out.write("    	<br>\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("		    ");
 List<UserGS> list4lv1 = (List<UserGS>) request.getAttribute("list4lv3");
		       if (list4lv3 != null) {
		           for (UserGS gs : list4lv3) { 
      out.write("\r\n");
      out.write("		               ");
 int count = 5; 
      out.write("\r\n");
      out.write("		               <div class=\"col 3 table_thpt_item\" align=\"center\">\r\n");
      out.write("		                   <img src=\"");
      out.print( gs.getImg() );
      out.write("\" alt=\"\" width=\"200\" height=\"200\">\r\n");
      out.write("		                   <p><a href=\"profileGS?id=");
      out.print( gs.getIdGS() );
      out.write("\">Giáo Viên: ");
      out.print( gs.getTenGS() );
      out.write("</a></p>\r\n");
      out.write("		                   <p>");
      out.print( gs.getMonHoc().getTenMH() );
      out.write("</p>\r\n");
      out.write("		                   <p>Số lớp học: ");
      out.print( gs.getCountLH() );
      out.write("</p>\r\n");
      out.write("		               </div>\r\n");
      out.write("		       ");
 }
		       } 
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("    <div class=\"wrapper-ft \">\r\n");
      out.write("        <div class=\"content-top\">\r\n");
      out.write("            <div class=\"footer-block\">\r\n");
      out.write("                <h3>VỀ HOCMAI</h3>\r\n");
      out.write("                <ul class=\"footer-block-list\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Giới thiệu</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Giáo viên nổi tiếng</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Hệ thống trung tâm HOCMAI</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Học sinh tiêu biểu</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Điều khoản chính sách</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Quy chế hoạt động</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Chính sách bảo mật thông tin</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Giải quyết khiếu nại, tranh chấp</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Tuyển dụng</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer-block\">\r\n");
      out.write("                <h3>DỊCH VỤ</h3>\r\n");
      out.write("                <ul class=\"footer-block-list\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Thư viện</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Ôn luyện</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Diễn đàn HOCMAI</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Speakup - Tiếng Anh 1 kèm 1 Online</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">ICANTECH - Đào tạo Công nghệ & Lập trình</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer-block\">\r\n");
      out.write("                <h3>HỖ TRỢ KHÁCH HÀNG</h3>\r\n");
      out.write("                <ul class=\"footer-block-list\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\">Trung tâm hỗ trợ</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a>Email: hotro@hocmai.vn</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a>Đường dây nóng: 1900 6933</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer-block\">\r\n");
      out.write("                <h3>DÀNH CHO ĐỐI TÁC</h3>\r\n");
      out.write("                <ul class=\"footer-block-list\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a>Email: info@hocmai.vn</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a>Tel: +84 (24) 3519-0591</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a>Fax: +84 (24) 3519-0587</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer-block\">\r\n");
      out.write("                <h3>TẢI ỨNG DỤNG HOCMAI</h3>\r\n");
      out.write("                <a href=\"\"><img class=\"footer-img-app\" src=\"../assets/images/footer-google-app.png\"></a>\r\n");
      out.write("                <a href=\"\"><img class=\"footer-img-app\" src=\"../assets/images/footer-store-app.png\"></a>\r\n");
      out.write("                <a href=\"\"><img class=\"footer-img-app\" src=\"../assets/images/congthuong.png\"></a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"wrapper-ft\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"row-left\">\r\n");
      out.write("                <p>\r\n");
      out.write("                    Cơ quan chủ quản: Công ty Cổ phần Đầu tư và Dịch vụ Giáo dục <br> MST: 0102183602 do Sở kế\r\n");
      out.write("                    hoạch và Đầu tư thành phố Hà Nội cấp ngày 13 tháng 03 năm 2007 <br> Địa chỉ: <br> - Văn\r\n");
      out.write("                    phòng Hà Nội: Tầng 4, Tòa nhà 25T2, Đường Nguyễn Thị Thập, Phường Trung Hoà, Quận Cầu Giấy,\r\n");
      out.write("                    Hà Nội. <br> - Văn phòng TP.HCM: 13M đường số 14 khu đô thị Miếu Nổi, Phường 3, Quận Bình\r\n");
      out.write("                    Thạnh, TP. Hồ Chí Minh <br> Hotline: 19006933 – Email: hotro@hocmai.vn <br> Chịu trách nhiệm\r\n");
      out.write("                    nội dung: Phạm Giang Linh\r\n");
      out.write("                </p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row-right\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

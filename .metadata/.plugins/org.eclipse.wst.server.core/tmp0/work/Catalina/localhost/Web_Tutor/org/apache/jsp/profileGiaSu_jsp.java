/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2023-06-09 15:49:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profileGiaSu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Thông tin cá nhân</title>\r\n");
      out.write("    <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\r\n");
      out.write("    <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background: -webkit-linear-gradient(left, #3931af, #00c6ff);\r\n");
      out.write("        }\r\n");
      out.write("        .emp-profile {\r\n");
      out.write("            padding: 3%;\r\n");
      out.write("            margin-top: 3%;\r\n");
      out.write("            margin-bottom: 3%;\r\n");
      out.write("            border-radius: 0.5rem;\r\n");
      out.write("            background: #fff;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-img {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-img img {\r\n");
      out.write("            width: 70%;\r\n");
      out.write("            height: 100%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-img .file {\r\n");
      out.write("            position: relative;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("            margin-top: -20%;\r\n");
      out.write("            width: 70%;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 0;\r\n");
      out.write("            font-size: 15px;\r\n");
      out.write("            background: #212529b8;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-img .file input {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            opacity: 0;\r\n");
      out.write("            right: 0;\r\n");
      out.write("            top: 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-head h5 {\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-head h6 {\r\n");
      out.write("            color: #0062cc;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-edit-btn {\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 1.5rem;\r\n");
      out.write("            width: 70%;\r\n");
      out.write("            padding: 2%;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            color: #6c757d;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .proile-rating {\r\n");
      out.write("            font-size: 12px;\r\n");
      out.write("            color: #818182;\r\n");
      out.write("            margin-top: 5%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .proile-rating span {\r\n");
      out.write("            color: #495057;\r\n");
      out.write("            font-size: 15px;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-head .nav-tabs {\r\n");
      out.write("            margin-bottom: 5%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-head .nav-tabs .nav-link {\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            border: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-head .nav-tabs .nav-link.active {\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-bottom: 2px solid #0062cc;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-work {\r\n");
      out.write("            padding: 14%;\r\n");
      out.write("            margin-top: -15%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-work p {\r\n");
      out.write("            font-size: 12px;\r\n");
      out.write("            color: #818182;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            margin-top: 10%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-work a {\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            color: #495057;\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            font-size: 14px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-work ul {\r\n");
      out.write("            list-style: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-tab label {\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .profile-tab p {\r\n");
      out.write("            font-weight: 600;\r\n");
      out.write("            color: #0062cc;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container emp-profile\">\r\n");
      out.write("    <form method=\"post\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-4\">\r\n");
      out.write("                <div class=\"profile-img\">\r\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${giaSu.img}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" alt=\"\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-6\">\r\n");
      out.write("                <div class=\"profile-head\">\r\n");
      out.write("                    <h5>\r\n");
      out.write("                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${giaSu.tenGS}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                    </h5>\r\n");
      out.write("                    <h6>\r\n");
      out.write("                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${giaSu.getMonHoc().getTenMH()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                    </h6>\r\n");
      out.write("                    <p class=\"proile-rating\">RANKINGS : <span>8/10</span></p>\r\n");
      out.write("                    <ul class=\"nav nav-tabs\" id=\"myTab\" role=\"tablist\">\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a class=\"nav-link active\" id=\"home-tab\" data-toggle=\"tab\" href=\"#home\" role=\"tab\"\r\n");
      out.write("                               aria-controls=\"home\" aria-selected=\"true\">About</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a class=\"nav-link\" id=\"profile-tab\" data-toggle=\"tab\" href=\"#profile\" role=\"tab\"\r\n");
      out.write("                               aria-controls=\"profile\" aria-selected=\"false\">Timeline</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-2\">\r\n");
      out.write("                <a type=\"submit\" class=\"btn btn-primary\" name=\"btnAddMore\" href=\"/Web_Tutor1/HomeServlet\">Home</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-4\">\r\n");
      out.write("                <div class=\"profile-work\">\r\n");
      out.write("                    <p>SKILLS</p>\r\n");
      out.write("                    <a href=\"\">Web Designer</a><br/>\r\n");
      out.write("                    <a href=\"\">Web Developer</a><br/>\r\n");
      out.write("                    <a href=\"\">PHP, .Net</a><br/>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-8\">\r\n");
      out.write("                <div class=\"tab-content profile-tab\" id=\"myTabContent\">\r\n");
      out.write("                    <div class=\"tab-pane fade show active\" id=\"home\" role=\"tabpanel\" aria-labelledby=\"home-tab\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <label>User Id</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${giaSu.idGS}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <label>Name</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${giaSu.tenGS}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <label>Email</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${giaSu.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <label>Phone</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${giaSu.sdt}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <label>Profession</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${giaSu.monHoc.tenMH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"profile\" role=\"tabpanel\" aria-labelledby=\"profile-tab\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <label>Experience</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <p>Expert</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <label>Hourly Rate</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <p>10$/hr</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <label>Total Projects</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <p>230</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <label>English Level</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <p>Expert</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <label>Availability</label>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <p>6 months</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-12\">\r\n");
      out.write("                                <label>Your Bio</label><br/>\r\n");
      out.write("                                <p>Your detail description</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    <hr>\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <c:forEach var=\"lh\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lopHocs}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("            <div class=\"col 3 table_thpt_item\" align=\"center\">\r\n");
      out.write("                <img src=\"https://img6.thuthuatphanmem.vn/uploads/2022/02/13/hinh-anh-lop-hoc-dep-nhat_011959587.jpg\"\r\n");
      out.write("                     alt=\"\" width=\"200\" height=\"160\">\r\n");
      out.write("                <br>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <button class=\"btn btn-success\" onclick=\"dangky(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lh.idLH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(')');
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lh.tenLH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</button>\r\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lh.lichhoc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lh.hocphi}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("$</p>\r\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lh.mota}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("                <hr>\r\n");
      out.write("            </div>\r\n");
      out.write("        </c:forEach>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("<script>\r\n");
      out.write("    function dangky(idLH) {\r\n");
      out.write("        let check = confirm('Đăng ký lớp học!')\r\n");
      out.write("        if (check) {\r\n");
      out.write("            location.href = \"/dangKy?id=\" + idLH;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>");
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.90
 * Generated at: 2023-10-31 05:24:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class calendarUI_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1695608593250L));
    _jspx_dependants.put("jar:file:/D:/00.tools/eGovFrameDev-4.0.0-64bit/works/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ddit-api-test/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/packages/core/main.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/packages/daygrid/main.css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/packages/core/main.js\" ></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/packages/interaction/main.min.js\" ></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/packages/daygrid/main.js\" ></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>제이쿼리 없이 테스트</h1>\r\n");
      out.write("	\r\n");
      out.write("	<button id=\"makeCalendar\">달력 생성</button>\r\n");
      out.write("<button id=\"refreshCalendar\">달력 새로고침</button>\r\n");
      out.write("\r\n");
      out.write("<div id=\"exampleCalendar\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("	const cDiv = document.querySelector('#exampleCalendar');\r\n");
      out.write("	let calendar = null;\r\n");
      out.write("	// 기본 캘린더 세팅 객체\r\n");
      out.write("	let calendarSettings = {\r\n");
      out.write("		headerToolbar: {\r\n");
      out.write("			left: 'prev,next today',\r\n");
      out.write("			center: 'title',\r\n");
      out.write("			right: 'dayGridMonth,timeGridWeek,timeGridDay'\r\n");
      out.write("		},\r\n");
      out.write("        initialDate: '2023-01-12',\r\n");
      out.write("        navLinks: true, // can click day/week names to navigate views\r\n");
      out.write("        selectable: true,\r\n");
      out.write("        selectMirror: true,\r\n");
      out.write("        select: function(arg) {\r\n");
      out.write("          var title = prompt('Event Title:');\r\n");
      out.write("          if (title) {\r\n");
      out.write("            calendar.addEvent({\r\n");
      out.write("              title: title,\r\n");
      out.write("              start: arg.start,\r\n");
      out.write("              end: arg.end,\r\n");
      out.write("              allDay: arg.allDay\r\n");
      out.write("            })\r\n");
      out.write("          }\r\n");
      out.write("          calendar.unselect()\r\n");
      out.write("        },\r\n");
      out.write("        eventClick: function(arg) {\r\n");
      out.write("			if (confirm('Are you sure you want to delete this event?')) {\r\n");
      out.write("				arg.event.remove()\r\n");
      out.write("			}\r\n");
      out.write("        },\r\n");
      out.write("        editable: true,\r\n");
      out.write("        dayMaxEvents: true, // allow \"more\" link when too many events\r\n");
      out.write("        events: [\r\n");
      out.write("					{\r\n");
      out.write("					  title: 'All Day Event',\r\n");
      out.write("					  start: '2023-01-01'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  title: 'Long Event',\r\n");
      out.write("					  start: '2023-01-07',\r\n");
      out.write("					  end: '2023-01-10'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  groupId: 999,\r\n");
      out.write("					  title: 'Repeating Event',\r\n");
      out.write("					  start: '2023-01-09T16:00:00'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  groupId: 999,\r\n");
      out.write("					  title: 'Repeating Event',\r\n");
      out.write("					  start: '2023-01-16T16:00:00'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  title: 'Conference',\r\n");
      out.write("					  start: '2023-01-11',\r\n");
      out.write("					  end: '2023-01-13'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  title: 'Meeting',\r\n");
      out.write("					  start: '2023-01-12T10:30:00',\r\n");
      out.write("					  end: '2023-01-12T12:30:00'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  title: 'Lunch',\r\n");
      out.write("					  start: '2023-01-12T12:00:00'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  title: 'Meeting',\r\n");
      out.write("					  start: '2023-01-12T14:30:00'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  title: 'Happy Hour',\r\n");
      out.write("					  start: '2023-01-12T17:30:00'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  title: 'Dinner',\r\n");
      out.write("					  start: '2023-01-12T20:00:00'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  title: 'Birthday Party',\r\n");
      out.write("					  start: '2023-01-13T07:00:00'\r\n");
      out.write("					},\r\n");
      out.write("					{\r\n");
      out.write("					  title: 'Click for Google',\r\n");
      out.write("					  url: 'http://google.com/',\r\n");
      out.write("					  start: '2023-01-28'\r\n");
      out.write("					}\r\n");
      out.write("				]\r\n");
      out.write("		};\r\n");
      out.write("	\r\n");
      out.write("		document.querySelector('#makeCalendar').addEventListener('click',function(){\r\n");
      out.write("			console.log(cDiv);\r\n");
      out.write("			console.log(\"여기 들어옴\");\r\n");
      out.write("			calendar = new FullCalendar.Calendar(cDiv, calendarSettings);\r\n");
      out.write("			console.log(calendar);\r\n");
      out.write("// 			calendar.render();\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("</script>\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/calendarUI.jsp(9,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/calendarUI.jsp(9,0) '${pageContext.request.contextPath }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/calendarUI.jsp(9,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("cPath");
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }
}

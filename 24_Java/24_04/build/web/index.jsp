<%@page import="java.util.Enumeration"%>
<%@page import="curso.ej24_02.Library"%>
<%@page import="curso.ej24_02.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<% request.setAttribute("title", "Library - Book List"); %>
<jsp:include page="layout/_header.jsp" />
    <h2>Book List</h2>
    <table>
        <thead>
            <tr>
              <th>Title</th>
              <th>Author</th>
            </tr>
        </thead>
        <tbody>
            <jsp:useBean id="library" scope="request" type="curso.ej24_02.Library"/>
            <% for (Book book : library.list()) { %>
            <%   request.setAttribute("book", book); %>
            <tr>
                <td>
                    <%-- TODO: add link to "detail.jsp" with the param "isbn" --%>
                    <a href="detail.jsp?isbn=${book.isbn}">${book.title}</a>
                </td>
                <td>${book.author}</td>
            </tr>
          <% } %>
      </tbody>
    </table>
<jsp:include page="layout/_footer.jsp" />

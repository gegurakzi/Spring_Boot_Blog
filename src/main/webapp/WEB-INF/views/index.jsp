<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <%@ include file="layout/header.jsp"%>


<div class="card py-5 text-center text-white border-0">
  <img class="card-img opacity-75" src="/image/blog-banner.jpg" alt="Card image">
  <div class="row py-lg-5 card-img-overlay align-items-center">
  <div class="col-lg-6 py-lg-5 col-md-8 mx-auto">
    <h1 class="text-light card-title">With slight of caffein</h1>
    <p class="text-light card-text"></p>
    <p class="text-light card-text">It is the business of the very few to be independent;</p>
    <p class="text-light card-text">it is a previlege of the strong</p>
    </div>
  </div>
</div>



  <div class="row row-cols-1 row-cols-md-3 g-4">
    <c:forEach var="board" items="${boards.content}">
      <div class="col p-2">
        <a href="/board/${board.id}" class="text-dark" style="text-decoration:none">
          <div class="card" style="height:200px;">
            <div class="card-body">
              <h4 class="card-title">${board.title}</h4>
              <p class="card-text text-truncate w-100"><c:out value='${board.content.replaceAll("\\\<.*?\\\>","")}' /></p>
            </div>
            <div class="card-footer">
              <small class="text-muted">${board.count} views</small>
            </div>
          </div>
        </a>
      </div>
    </c:forEach>
  </div>


  <nav aria-label="Page navigation">
    <ul class="pagination justify-content-center">
      <c:choose>
        <c:when test="${boards.first}">
          <li class="page-item disabled">
        </c:when>
        <c:otherwise>
          <li class="page-item">
        </c:otherwise>
      </c:choose>
        <a class="page-link" href="?page=${boards.number-1}" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
          <span class="sr-only">Prev</span>
        </a>
      </li>
      <c:choose>
        <c:when test="${boards.last}">
          <li class="page-item disabled">
        </c:when>
        <c:otherwise>
          <li class="page-item">
        </c:otherwise>
      </c:choose>
        <a class="page-link" href="?page=${boards.number+1}" aria-label="Next">
          <span class="sr-only">Next</span>
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>


  <%@ include file="layout/footer.jsp"%>
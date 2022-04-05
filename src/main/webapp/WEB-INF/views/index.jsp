<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <%@ include file="layout/header.jsp"%>

  <section class="py-5 text-center container">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">Album example</h1>
        <p class="lead text-muted">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don’t simply skip over it entirely.</p>
        <p>
          <a href="#" class="btn btn-primary my-2">Main call to action</a>
          <a href="#" class="btn btn-secondary my-2">Secondary action</a>
        </p>
      </div>
    </div>
  </section>

  <div class="row row-cols-1 row-cols-md-3 g-4">
    <c:forEach var="board" items="${boards.content}">
      <div class="col p-2">
        <a href="/board/${board.id}" class="text-dark" style="text-decoration:none">
          <div class="card h-100">
            <div class="card-body">
              <h5 class="card-title">${board.title}</h5>
              <p class="card-text">${board.content}</p>
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
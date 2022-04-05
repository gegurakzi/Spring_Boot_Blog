<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

  <section class="py-5 text-center container mt-5">
  </section>

  <article class="blog-post">
    <div class="container" novalidate>
      <div class="container p-2">
        <p id="board-id" class="blog-post-meta text-mute" value="${board.id}">#${board.id}</p>
        <h2 class="blog-post-title">${board.title}</h2>
        <p class="blog-post-meta text-muted m-1 float-start"><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${board.createDate}" /> by <a href="#" class="text-muted" >${board.user.username}</a></p>
          <div class="d-flex justify-content-end">
            <c:if test="${board.user.id == principal.user.id}">
              <a href="/board/${board.id}/updateForm" class="text-muted" id="link-update">수정</a>
              <p class="text-muted">&nbsp;|&nbsp;</p>
              <a href="#" class="text-muted" id="link-delete">삭제</a>
            </c:if>
          </div>
      </div>
      <br/>
      <hr>
      <div class="container p-3">
        ${board.content}
      </div>
      <div class="blog-post-footer p-3">
        <p class="blog-post-meta text-muted">${board.count} views</p>
      </div>
    </div>
    <div class="p-2 row">

    </div>
  </div>
  <script src="/js/board.js"></script>




















<%@ include file="../layout/footer.jsp"%>
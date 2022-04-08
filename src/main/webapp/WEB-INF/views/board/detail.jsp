<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

  <section class="py-5 text-center container mt-5">
  </section>

  <article class="blog-post">
    <div class="container">
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



    <div class="m-4 pt-4 row border-top">

      <c:forEach var="reply" items="${board.replys}">
        <div class="container p-3 d-flex">
          <div class="col" style="min-width:100px">
            <p class="text-break"><small>${reply.user.username}</small></p>
          </div>
          <div class="container border-start">
            <p class="text-break">${reply.content}</p>
          </div>
          <div class="col" style="min-width:90px">
            <small><small><small><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${board.createDate}" /></small></small></small>
            <c:if test="${reply.user.id == principal.user.id}">
              <div class="d-flex justify-content-end">
                <small><a id="reply-delete" href="#" onClick="index.deleteReply(${board.id}, ${reply.id})" class="text-muted">삭제</a></small>
              </div>
            </c:if>
          </div>
        </div>
      </c:forEach>

      <form id="comment--save" class="container p-3 d-flex">
        <div class="col" style="min-width:100px">
          <input id="user-id" type="hidden" value="${principal.user.id}"/>
          <p>${principal.user.username}</p>
        </div>
        <div class="container">
          <textarea id="reply-content" class="form-control w-100" placeholder="Leave a comment..." required></textarea>
        </div>
        <div class="col">
          <button type="submit" id="btn-reply-save" class="btn btn-dark h-100" style="min-width:100px">댓글 쓰기</button>
        </div>
      </form>
    </div>
  </article>
  <script src="/js/board.js"></script>




















<%@ include file="../layout/footer.jsp"%>
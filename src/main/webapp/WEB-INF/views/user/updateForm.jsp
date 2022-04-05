<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <%@ include file="../layout/header.jsp"%>

  <section class="w-50 py-5 mt-5 container bg-light">
    <form class="needs-validation" novalidate>
      <div class="container pt-5 text-center">
        <h1>My profile</h1>
      </div>
      <input type="hidden" id="user-id" value="${principal.user.id}"/>
      <div class="container pt-5">
        <label for="username" class="form-label">User name</label>
        <input type="text" class="form-control" id="username" value="${principal.user.username}" placeholder="Name" readonly>
        <div class="invalid-feedback">
          Please enter a username.
        </div>
      </div>
      <div class="container pt-5">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" required>
        <div class="invalid-feedback">
            Please enter a pasword.
        </div>
      </div>
      <div class="container pt-5 pb-3">
        <label for="email" class="form-label">E-mail</label>
        <input type="email" class="form-control" id="email" placeholder="example@gmail.com" value="${principal.user.email}" required>
        <div class="invalid-feedback">
          Please provide a valid email address.
        </div>
      </div>
    </form>
    <div class="float-end">
      <button id="btn-update" class="btn btn-primary confirm">수정 완료</button>
    </div>
  </section>

  <script src="/js/user.js"></script>

  <%@ include file="../layout/footer.jsp"%>
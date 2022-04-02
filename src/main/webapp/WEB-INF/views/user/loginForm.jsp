<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <%@ include file="../layout/header.jsp"%>

  <section class="w-50 py-5 mt-5 container bg-light">
    <div>
      <div class="container pt-5 text-center">
        <h1>Sign in</h1>
      </div>
      <form class="needs-validation" novalidate>
        <div class="form-group p-3">
          <label for="username" class="form-label">User name</label>
          <input type="text" class="form-control" id="username" placeholder="Name" required>
          <div class="invalid-feedback">
            Please enter a username.
          </div>
        </div>
        <div class="form-group p-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" required>
          <div class="invalid-feedback">
             Please enter a password.
          </div>
        </div>
      </form>
      <div class="col-12">
        <div class="form-group form-check">
          <input class="check-input" type="checkbox" value="" id="check-remember">
          <label class="check-label" for="check-remember">Remember me</label>
        </div>
      </div>
    </div>
    <div class="float-end">
      <button id="btn-login" class="btn btn-primary">로그인</button>
    </div>
  </section>

  <script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp"%>
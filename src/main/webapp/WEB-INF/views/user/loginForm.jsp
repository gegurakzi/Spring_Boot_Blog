<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <%@ include file="../layout/header.jsp"%>
  <div class="w-50 py-5 mt-5 container bg-light">
    <div class="container pt-5 text-center">
      <h1>Sign in</h1>
    </div>

    <form action="#" method="post" class="needs-validation" novalidate>

      <div class="form-group p-3">
        <label for="username" class="form-label">User name</label>
        <input type="text" name="username" id="username" class="form-control" placeholder="Name" required>
        <div class="invalid-feedback">
          Please enter a username.
        </div>
      </div>

      <div class="form-group p-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" name="password" id="password" class="form-control" required>
        <div class="invalid-feedback">
           Please enter a password.
        </div>
      </div>

      <div class="col-12">
        <div class="form-group form-check">
          <input name="remember" id="remember" class="check-input" type="checkbox" value="">
          <label class="check-label" for="remember">Remember me</label>
        </div>
      </div>

      <div class="float-end">
        <button id="btn-login" type="submit" class="btn btn-primary">로그인</button>
      </div>

    </form>
  </div>

<%@ include file="../layout/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <%@ include file="../layout/header.jsp"%>

  <div class="container w-50 py-5 mt-5 bg-light" style="min-width:350px">

    <div class="container pt-5 text-center">
      <h1>Sign in</h1>
    </div>

    <form action="/auth/loginProc" method="post" class="needs-validation" novalidate>

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

      <div class="form-group form-check">
        <input name="remember" id="remember" class="check-input" type="checkbox" value="">
        <label class="check-label" for="remember">Remember me</label>
      </div>

      <br/>

      <div class="d-flex justify-content-center">
        <button id="btn-login" type="submit" class="btn btn-primary" style="width:300px; height:40px">
        로그인
        </button>
      </div>

      <div class="d-flex justify-content-center">
          <a class="btn w-100" href="https://kauth.kakao.com/oauth/authorize?client_id=32b1781743eb300c70ecd60df026d769&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code">
            <img src="/image/kakao_login_medium_wide.png"/>
          </a>
      </div>
    </form>
  </div>

<%@ include file="../layout/footer.jsp"%>
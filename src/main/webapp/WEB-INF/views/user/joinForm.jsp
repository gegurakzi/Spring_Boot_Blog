<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <%@ include file="../layout/header.jsp"%>

  <section class="w-50 py-5 mt-5 container bg-light">
    <form class="needs-validation" novalidate>
      <div class="container pt-5 text-center">
        <h1>Sign up</h1>
      </div>
      <div class="container pt-5">
        <label for="username" class="form-label">User name</label>
        <input type="text" class="form-control" id="username" placeholder="Name" required>
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
        <input type="email" class="form-control" id="email" placeholder="example@gmail.com" required>
        <div class="invalid-feedback">
          Please provide a valid email address.
        </div>
      </div>
    </form>
    <div class="float-end">
      <button id="btn-save" class="btn btn-primary confirm">회원가입</button>
    </div>
  </section>

  <script src="/blog/js/user.js"></script>

  <%@ include file="../layout/footer.jsp"%>
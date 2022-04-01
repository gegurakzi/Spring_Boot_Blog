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
      <div class="float-end">
          <button class="btn btn-primary" type="submit">회원가입</button>
      </div>
    </form>
  </section>

  <script> (function () {
             'use strict'
             // Fetch all the forms we want to apply custom Bootstrap validation styles to
             var forms = document.querySelectorAll('.needs-validation')
             // Loop over them and prevent submission
             Array.prototype.slice.call(forms)
               .forEach(function (form) {
                 form.addEventListener('submit', function (event) {
                   if (!form.checkValidity()) {
                     event.preventDefault()
                     event.stopPropagation()
                   }
                   form.classList.add('was-validated')
                 }, false)
               })
           })()
  </script>

  <%@ include file="../layout/footer.jsp"%>
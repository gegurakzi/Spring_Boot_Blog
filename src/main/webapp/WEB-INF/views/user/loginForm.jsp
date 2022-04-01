<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <%@ include file="../layout/header.jsp"%>

  <section class="w-50 py-5 mt-5 container bg-light">
    <form class="needs-validation" novalidate>
      <div class="container pt-5 text-center">
        <h1>Sign in</h1>
      </div>
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
           Please enter a pasword.
        </div>
      </div>
      <div class="col-12">
        <div class="form-group form-check">
          <input class="form-check-input" type="checkbox" value="" id="check-remember">
          <label class="form-check-label" for="heck-remember">Remember me</label>
        </div>
      </div>
      <div class="float-end">
        <button class="btn btn-primary" type="submit">로그인</button>
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
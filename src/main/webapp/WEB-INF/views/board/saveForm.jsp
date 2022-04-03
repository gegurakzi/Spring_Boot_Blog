<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

  <section class="py-5 text-center container">
    글쓰기 화면
  </section>

  <div class="container">
    <form class="needs-validation" novalidate>
      <div class="form-group p-2">
        <label for="title"  class="form-label">제목</label>
        <input type="text" class="form-control" id="title" placeholder="" required>
      </div>
      <div class="form-group p-2">
        <label for="summernote" class="form-label">내용</label>
        <textarea class="form-control summernote" id="content" required>
        </textarea>
      </div>
    </form>
    <div class="p-2 row">
      <div class="col-9">
      </div>
      <div class="col-3">
        <button id="btn-save" class="btn btn-primary btn-block" style="width:155px">저장</button>
      </div>
    </div>
  </div>
  <script>
     $('.summernote').summernote({
            tabsize: 2,
            height: 400,
            toolbar: [
              ['style', ['style']],
              ['font', ['bold', 'underline', 'clear']],
              ['color', ['color']],
              ['para', ['ul', 'ol', 'paragraph']],
              ['table', ['table']],
              ['insert', ['link', 'picture', 'video']],
              ['view', ['fullscreen', 'codeview', 'help']]
            ]
          });
  </script>
  <script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp"%>
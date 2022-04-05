let index = {
    init: function(){
        $("#btn-save").on("click", ()=>{
            forms=$(".needs-validation");
            invalid=false;
            Array.prototype.slice.call(forms).forEach(function (form) {
                if (!form.checkValidity()) {
                  event.preventDefault();
                  event.stopPropagation();
                  invalid = true;
                }
                form.classList.add('was-validated');
            })
            if(!invalid) this.save();
        });
        $("#link-update").on("click", ()=>{

        });
        $("#link-delete").on("click", ()=>{
            this.deleteById();
        });
    },

    save: function(){
        let data={
           title : $("#title").val(),
           content : $("#content").val()
        }

        // ajax 호출 시 default: 비동기 호출
        // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 INSERT 요청
        $.ajax({
            type : "POST",
            url : "/api/board",
            data : JSON.stringify(data),
            contentType : "application/json; charset=utf-8",
            dataType : "json"
        }).done(function(response){
            alert("글 저장 완료!");
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

   deleteById: function(){
            var id = $("#board-id").attr("value");
            $.ajax({
                type : "DELETE",
                url : "/api/board/"+id,
                dataType : "json"
            }).done(function(response){
                alert("글 삭제 완료!");
                location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
        }
}

index.init();
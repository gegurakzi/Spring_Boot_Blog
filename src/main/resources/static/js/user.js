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
        $("#btn-login").on("click", ()=>{
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
                    if(!invalid) this.login();
                });
    },

    save: function(){
        let data={
           username : $("#username").val(),
           password : $("#password").val(),
           email : $("#email").val()
        }

        // ajax 호출 시 default: 비동기 호출
        // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 INSERT 요청
        $.ajax({
            type : "POST",       //INSERT 할꺼고
            url : "/api/user",   // user 테이블 사용할꺼
            data : JSON.stringify(data),  // http body 데이터
            contentType : "application/json; charset=utf-8", // body 데이터가 어떤 타입인지
            dataType : "json" // "요청을 서버로 해서" 응답데이터가 왔을때 기본적으로 모든것이 문자열. 만약 생긴게 JSON이라면 Javascript로 변환, 파라미터로 전달해줌
        }).done(function(response){
            alert("회원가입 완료!");
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    login: function(){
            let data={
               username : $("#username").val(),
               password : $("#password").val()
            }

            // ajax 호출 시 default: 비동기 호출
            // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 INSERT 요청
            $.ajax({
                type : "POST",       //INSERT 할꺼고
                url : "/api/user/login",   // user 테이블 사용할꺼
                data : JSON.stringify(data),  // http body 데이터
                contentType : "application/json; charset=utf-8", // body 데이터가 어떤 타입인지
                dataType : "json" // "요청을 서버로 해서" 응답데이터가 왔을때 기본적으로 모든것이 문자열. 만약 생긴게 JSON이라면 Javascript로 변환, 파라미터로 전달해줌
            }).done(function(response){
                alert("로그인 완료!");
                location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
        }
}

index.init();
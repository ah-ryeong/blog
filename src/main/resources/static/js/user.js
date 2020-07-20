let index = {
	// 리스너
	init: function(){

		$("#btn-save").on("click", ()=>{
			// 콜백스택
			this.save();
		});
		
		// 2 리스너
		$("#btn-login").on("click", ()=>{
			// 콜백스택
			this.login();
		});
	},
	
	save: function(){
		let data = {
				username: $("#username").val(),
				password: $("#password").val(),
				email: $("#email").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), // JSON으로 바껴서 날아감, get방식은 body 데이터 없음
			contentType: "application/json; charset=utf-8",
			// 서버로부터 응답받을 때의 데이터타입
			dataType: "json"
		}).done(function(resp){
			if(resp.statusCode == 1) {
				alert("회원가입 성공")
				location.href="/";
			}
			console.log(resp);
		}).fail(function(error){
			alert("회원가입 실패");
			console.log(error);
		})
	},
	
	login: function(){
		let data = {
				username: $("#username").val(),
				password: $("#password").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/auth/loginProc",
			data: JSON.stringify(data), // JSON으로 바껴서 날아감, get방식은 body 데이터 없음
			contentType: "application/json; charset=utf-8",
			// 서버로부터 응답받을 때의 데이터타입
			dataType: "json"
		}).done(function(resp){
			alert("로그인 성공");
			location.href="/";
		}).fail(function(error){
			alert("로그인 실패");
			console.log(error);
		})
	},
	
}

index.init();

let index = {
	// 리스너
	init: function(){

		$("#btn-save").on("click", ()=>{
			// 콜백스택
			this.save();
		});
	},
	
	save: function(){
		let data = {
				title: $("#title").val(),
				content: $("#content").val(),
				userId: $("#userId").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/post",
			data: JSON.stringify(data), // JSON으로 바껴서 날아감, get방식은 body 데이터 없음
			contentType: "application/json; charset=utf-8",
			// 서버로부터 응답받을 때의 데이터타입
			dataType: "json"
		}).done(function(resp){
			if(resp.statusCode == 1) {
				alert("글쓰기 성공")
				location.href="/";
			}
			console.log(resp);
		}).fail(function(error){
			alert("글쓰기 실패");
			console.log(error);
		})
	}
}

index.init();

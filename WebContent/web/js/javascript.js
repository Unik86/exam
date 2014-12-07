$(function(){  
	
	var divTimer = $("#timer");
	var divQuestion = $("#question");
	var divAnswers = $("#answers");
	
	var arrQuestions = new Array();
	var userAnswers = new Array();
	var count = 0;
	
	var setTime = 30;
	var time = setTime;
	var startTime;
	
	$(window).load(function () {
		$.ajax({
			type: 'GET',
			url: 'loadquestins.html',	
			success: function(data){		
				arrQuestions = JSON.parse(data);
				startTime = setInterval(funTime, 1000);
				divTimer.text(setTime);
				writeQuestion();
			 },
			error:function( jqXHR, textStatus, errorThrown){
				alert("Ошибка");  
		}});
	});
	
	function writeQuestion() {
		divQuestion.text(arrQuestions[count].textQuestion);
		var arrAnswer = arrQuestions[count].allAnswer;
		var codeAnsewr = "";
		for(var i=0; i < arrAnswer.length ; i++){
			var mod = i%2;
			var color = "white";
			if(mod!=0) color = "#efefef";
			codeAnsewr = codeAnsewr + "<div class='answer' type='" + arrAnswer[i].idAnswer + "' style='background-color: " + color + ";'>" + arrAnswer[i].textAnswer + "</div>";
		}
		divAnswers.html(codeAnsewr);
		count++;
		
	}
	
	divAnswers.on("click", "div.answer", function(){		
		userAnswers[count-1] = $(this).attr("type");	
		if(count < 5) {
			time = setTime;
			clearInterval(startTime);
			startTime = setInterval(funTime, 1000);
			divTimer.text(setTime);
			writeQuestion();
		}
		else {
			time = setTime;
			clearInterval(startTime);
			divTimer.text("");
			sendAnswer();	
		}
	
	});
		
	function sendAnswer(){
		$.ajax({
			type: 'POST',
			url: 'sendanswers.html',
			data: {arrAnswers : userAnswers.toString()},
			success: function(data){		
				divTimer.html("");
				divQuestion.text("Вы правильно ответили на " + data + " из 5 вопросов");
				divAnswers.html("");
			 },
			error:function( jqXHR, textStatus, errorThrown){
				alert("Ошибка");  
		}});
	}

	function funTime() {
		if(time < 0){
			userAnswers[count-1] = 0;	
			if(count < 5) {
				time = setTime;
				clearInterval(startTime);
				startTime = setInterval(funTime, 1000);
				divTimer.text(setTime);
				writeQuestion();
			}
			else {
				time = setTime;
				clearInterval(startTime);
				divTimer.text("");
				sendAnswer();	
			}
		}
		else
			divTimer.text(time--);
	}
});



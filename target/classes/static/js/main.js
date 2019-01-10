$(document).ready(function() {

	var pane = $('.scroll-pane').jScrollPane();
	var api = pane.data('jsp');

	$('#bth-search').on('click', formHandle);
	$('#question').on('keydown', function(e) {
		if (e.keyCode == 13) {
			formHandle();
		}
	});

	function formHandle() {
		axios.post('/api/search', {
			question : document.getElementById("question").value
		}).then(function(res) {
			createQustion(document.getElementById("question").value);
			createAnswer(res.data.result);
			document.getElementById("question").value = "";
			api.reinitialise();
			$(".jspContainer").animate({
				scrollTop : $(".jspPane").height()
			}, 300);
		}, function(err) {
			console.log(err);
		});
	}

	function createQustion(value) {
		var html = '';

		html += '<p class="question">';
		html += '<span class="you">You: </span>';
		html += '<span>' + value + '</span>';
		html += '</p>';

		api.getContentPane().append(html);
	}

	function createAnswer(value) {
		var html = '';

		html += '<p class="answer">';
		html += '<span class="bot">LTC Bot: </span>';
		html += '<span>' + value + '</span>';
		html += '</p>';

		api.getContentPane().append(html);
	}

});
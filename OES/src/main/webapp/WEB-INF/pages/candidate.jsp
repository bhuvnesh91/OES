<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>OES-Candidate Login</title>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.1.1/css/bootstrap.min.css">
</head>
<body>


	<div class="container">
		<h1>Candidate Login</h1>
		<hr />
		<div class="page"></div>
	</div>


	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.2/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.4.2/underscore-min.js"
		type="text/javascript"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/backbone.js/0.9.2/backbone-min.js"></script>


	<script type="text/template" id="question-view-template">
    <table class="table striped">
       <tbody>
			<tr><th>Question<th></tr>
			<tr>
  				<td><\%=htmlEncode(question.get('questionDesc'))%> </td>
			</tr>
			<tr>
				<th>Options</th>
				  <\% _.each(question.get('optionList'),function(option){%>
					<tr>
						<td><input type="checkbox" name ="<\%=htmlEncode(option.id)%>" value="<\%=htmlEncode(option.name)%>">
						<td><\%=htmlEncode(option.name)%></td>
					</tr>
  				<\% }); %> 
			</tr>
      </tbody>
    </table>
  </script>

	<script type="text/template" id="candidate-login-page">
  	  <table class="table striped">
  	     <tbody>
			<tr><td>Instruction Page</td></tr>
  	    </tbody>
 	   </table>
 		<a href="#/start" class="btn btn-primary">Start Exam</a>
 	 </script>

	<script>
		function htmlEncode(value) {
			return $('<div/>').text(value).html();
		}

		$.fn.serializeObject = function() {
			var o = {};
			var a = this.serializeArray();
			$.each(a, function() {
				if (o[this.name] !== undefined) {
					if (!o[this.name].push) {
						o[this.name] = [ o[this.name] ];
					}
					o[this.name].push(this.value || '');
				} else {
					o[this.name] = this.value || '';
				}
			});
			return o;
		};

		$.ajaxPrefilter(function(options, originalOptions, jqXHR) {
			options.url = '.' + options.url;
		});

		var Questions = Backbone.Collection.extend({
			url : '/questionsCandidate'
		});

		var Question = Backbone.Model.extend({
			urlRoot : '/questionsCandidate'
		});

		var CandidateLoginView = Backbone.View.extend({
			el : '.page',
			render : function() {
				var template = _.template($('#candidate-login-page').html());
				this.$el.html(template);
			}
		});

		var QuestionPageView = Backbone.View.extend({
			el : '.page',
			render : function() {
				this.question = new Question();
				var that = this;
				this.question.fetch({
					success : function(question) {
						var template = _.template($('#question-view-template')
								.html(), {
							question : question
						});
						that.$el.html(template);
					}
				})
			}
		});

		var candidateLoginView = new CandidateLoginView();

		var Router = Backbone.Router.extend({
			routes : {
				"" : "home",
				"start" : "enter",
			}
		});

		var router = new Router;
		router.on('route:home', function() {
			// render candidate list
			candidateLoginView.render();
		})
		router.on('route:enter', function() {
			newQuestionView.render();
		})
		Backbone.history.start();
	</script>


</body>
</html>

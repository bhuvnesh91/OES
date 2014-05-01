<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>OES</title>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.1.1/css/bootstrap.min.css">
</head>
<body>


	<div class="container">
		<h1>Question Manager</h1>
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


	<script type="text/template" id="question-list-template">
    <a href="#/newQ" class="btn btn-primary">New Question</a>
    <a href="#/newUploadF" class="btn btn-primary">Upload File</a>
    <hr />
    <table class="table striped">
       <tbody>
		  <\% _.each(questions, function(question){ %> 
			<tr> <td></td> </tr>			
			<tr><th>Question<th></tr>
			<tr>
  				<td><\%=htmlEncode(question.get('questionDesc'))%> </td>
			</tr>
			<tr>
				<th>Options</th>
				  <\% _.each(question.get('optionList'),function(option){%>
					<tr><td><\%=htmlEncode(option.name)%></td></tr>
  				<\% }); %> 
			</tr>
       	<\% }); %> 
      </tbody>
    </table>
  </script>

	<script type="text/template" id="new-question-template">
    <form class="new-question-form">
      <legend>New Question</legend>
        <label>Question Desc</label>
        <input name="questionDesc" type="text">
		<select name = "dept">
 				<\% _.each(departments, function(department){ %> 
					<option value="<\%=htmlEncode(department.get('name'))%>"><\%=htmlEncode(department.get('name'))%></option>
			<\% }); %> 
		</select>
        <label>Option 1</label>
		<input name="value1" id ="option1Status" type="checkbox" value = true>
        <input name="name1" id="option1" type="text">
		<label>Option 2</label>
		<input name="value2" id ="option2Status" type="checkbox" value = true>        
		<input name="name2" id="option2" type="text">
		<label>Option 3</label>
		<input name="value3" id ="option3Status" type="checkbox" value = true>
        <input name="name3" id="option3" type="text">
		<label>Option 4</label>
		<input name="value4" id ="option4Status" type="checkbox" value = true>
        <input name="name4" id="option4" type="text">
        <hr />
       <button type="submit" class="btn">Create</button>
    </form>
  </script>

	<script type="text/template" id="new-question-file-template">
    <form class="new-question-file-form" action ="questionfile" enctype="multipart/form-data" method="POST" modelAttribute = "questionFile" name="questionFile">
      <legend>Upload File for questions</legend>
		<select name = "dept" path ="dept">
 				<\% _.each(departments, function(department){ %> 
					<option value="<\%=htmlEncode(department.get('name'))%>"><\%=htmlEncode(department.get('name'))%></option>
			<\% }); %> 
		</select>
        <label>File</label>
		<input type="file" name="file" path = "file"/>
        <hr />
       <button type="submit" class="btn">Upload</button>
    </form>
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
			url : '/questions'
		});

		var Question = Backbone.Model.extend({
			urlRoot : '/questions'
		});

		var Departments = Backbone.Collection.extend({
			url : '/departments'
		});

		var QuestionFile = Backbone.Model.extend({
			url : '/questionfile',
		});

	
		var QuestionListView = Backbone.View.extend({
			el : '.page',
			render : function() {
				var that = this;
				var questions = new Questions();
				questions.fetch({
					success : function(questions) {
						var template = _.template($('#question-list-template')
								.html(), {
							questions : questions.models
						});
						that.$el.html(template);
					}
				});
			}
		});

		var questionListView = new QuestionListView();

		var NewQuestionFileView = Backbone.View.extend({
			el : '.page',
			render : function() {
				var that = this;
				var departments = new Departments();
				departments.fetch({
					success : function(departments) {
						new1 = departments;
						var template = _.template($(
								'#new-question-file-template').html(), {
							questionFile : null,
							departments : departments.models
						});
						that.$el.html(template);
					}
				});
			}
		});

		var newQuestionFileView = new NewQuestionFileView();

		var NewQuestionView = Backbone.View.extend({
			el : '.page',
			events : {
				'submit .new-question-form' : 'saveQuestion'
			},
			saveQuestion : function(ev) {
				var input = $(ev.currentTarget).context;
				$.each(input, function(i, item) {
					if (item.attributes[0].value == "checkbox") {
						if (item.checked == true)
							item.value = true;
						else {
							item.checked = true;
							item.value = false;
						}
					}
				});
				var questionDetails = $(ev.currentTarget).serializeObject();
				var question = new Question();
				question.save(questionDetails, {
					success : function(question) {
						router.navigate('', {
							trigger : true
						});
					}
				});
				return false;
			},
			render : function() {
				var that = this;
				var new1;
				var departments = new Departments();
				departments.fetch({
					success : function(departments) {
						new1 = departments;
						var template = _.template($('#new-question-template')
								.html(), {
							question : null,
							departments : departments.models
						});
						that.$el.html(template);
					}
				});
			}
		});

		var newQuestionView = new NewQuestionView();

		var Router = Backbone.Router.extend({
			routes : {
				"" : "home",
				"edit/:id" : "edit",
				"new" : "edit",
				"newQ" : "enter",
				"newUploadF" : "upload",
			}
		});

		var router = new Router;
		router.on('route:home', function() {
			// render candidate list
			questionListView.render();
		})
		router.on('route:edit', function(id) {
			candidateEditView.render({
				id : id
			});
		})
		router.on('route:enter', function() {
			newQuestionView.render();
		})
		router.on('route:upload', function() {
			newQuestionFileView.render();
		})
		Backbone.history.start();
	</script>


</body>
</html>

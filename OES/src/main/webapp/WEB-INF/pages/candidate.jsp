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

	<script type="text/template" id="candidate-instruction-page">
    <pre>
Instructions :
	1. There are 5 question.
	2. All questions are necessary.
</pre>
<a href="#start/<\%=voucher%>" class="btn btn-primary">Start Exam</a>
  </script>

	<script type="text/template" id="candidate-login-page">
  	  <h3>Create Account</h3>
		<form name="cAccount" class="new-candidate-form">
		<div class="control-group firstName">
			<label for="firstName">Name</label><input type="text" name="firstName"
				required="required"><span class="help-inline"></span>
		</div>
		<div class="control-group phoneNumber">
			<label for="phoneNumber">Contact Number</label><input type="tel"
				name="phoneNumber" required="required"><span class="help-inline"></span>
		</div>
		<div class="control-group emailId">
			<label for="emailId">Email Id</label><input type="email" name="emailId"
				required="required"><span class="help-inline"></span>
		</div>
		<div class="control-group dob">
			<label for="dob">DOB</label><input type="date" name="dob"
				required="required"><span class="help-inline"></span>
		</div>
		<div class="control-group fName">
			<label for="fName">Father's Name</label><input type="text"
				name="fName" required="required"><span class="help-inline"></span>
		</div>
		<div class="control-group voucher">
			<label for="voucher">Voucher</label><input type="text"
				name="voucher" required="required"><span class="help-inline"></span>
		</div>
		<button type="submit" class="btn">Save Details</button>
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
			url : '/questionsCandidate'
		});

		var Question = Backbone.Model.extend({
			urlRoot : '/questionsCandidate'
		});

		var Candidate = Backbone.Model.extend({
			urlRoot : '/saveCandidate',
			validate : function(attributes) {
				var errors = [];
				if (!attributes.firstName) {
					errors.push({
						name : 'firstName',
						message : 'Please fill Name field.'
					});
				}

				if (!attributes.phoneNumber) {
					errors.push({
						name : 'phoneNumber',
						message : 'Please fill Contact Number field.'
					});
				}
				if (!attributes.emailId) {
					errors.push({
						name : 'emailId',
						message : 'Please fill email id field.'
					});
				}
				if (!attributes.dob) {
					errors.push({
						name : 'dob',
						message : 'Please fill dob field.'
					});
				}
				if (!attributes.fName) {
					errors.push({
						name : 'fName',
						message : 'Please fill Father Name field.'
					});
				}
				if (!attributes.voucher) {
					errors.push({
						name : 'voucher',
						message : 'Please fill voucher number field.'
					});
				}
				return errors.length > 0 ? errors : false;
			}

		});

		var CandidateLoginView = Backbone.View.extend({
			el : '.page',
			events : {
				'submit .new-candidate-form' : 'saveDetails'
			},
			render : function() {
				var template = _.template($('#candidate-login-page').html());
				this.$el.html(template);
			},
			saveDetails : function(ev) {
				var candDetails = $(ev.currentTarget).serializeObject();
				var candidate = new Candidate();
				var that = this;
				candidate.save(candDetails, {
					success : function(voucher) {
						that.hideErrors();
						that.voucher = voucher;
						var template = _.template($(
								'#candidate-instruction-page').html({
							voucher : voucher
						}));
						that.$el.html(template);
					},
					error : function(model, errors) {
						that.hideErrors();
						that.showErrors(errors);
					}
				});
				return false;
			},
			showErrors : function(errors) {
				_.each(errors, function(error) {
					var controlGroup = this.$('.' + error.name);
					controlGroup.addClass('error');
					controlGroup.find('.help-inline').text(error.message);
				}, this);
			},
			hideErrors : function() {
				this.$('.control-group').removeClass('error');
				this.$('.help-inline').text('');
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
				"start/:id" : "enter",
			}
		});

		var router = new Router;
		router.on('route:home', function() {
			// render candidate list
			candidateLoginView.render();
		})
		router.on('route:enter', function(voucher) {
			newQuestionView.render({
				voucher : voucher
			});
		})
		Backbone.history.start();
	</script>


</body>
</html>

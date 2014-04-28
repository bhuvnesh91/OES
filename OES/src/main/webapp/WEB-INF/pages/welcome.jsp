<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>BackboneTutorials.com Beginner Video</title>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.1.1/css/bootstrap.min.css">
</head>
<body>


	<div class="container">
		<h1>Candidate Manager</h1>
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


	<script type="text/template" id="candidate-list-template">
    <a href="#/new" class="btn btn-primary">New</a>
    <hr />
    <table class="table striped">
      <thead>
        <tr>
          <th>First Name</th><th>Phone Number</th><th>EmailId</th><th></th>
        </tr>
      </thead>
      <tbody>
		  <\% _.each(candidates, function(candidate){ %> 
			<tr>
  				<td><\%=htmlEncode(candidate.get('firstName'))%> </td>
            	<td><\%=htmlEncode(candidate.get('phoneNumber'))%></td>
            	<td><\%=htmlEncode(candidate.get('emailId'))%></td>
            	<td><a class="btn" href="#/edit/<\%= candidate.get('id')%> ">Edit</a></td>
          </tr>
       	<\% }); %> 
      </tbody>
    </table>
  </script>

	<script type="text/template" id="edit-candidate-template">
    <form class="edit-candidate-form" name = "candidate" id ="candidate">
      <legend><\%= candidate ? 'Edit' : 'New' %> Candidate</legend>
        <label>First Name</label>
        <input name="firstName" type="text" value="<\%= candidate ? candidate.get('firstName') : '' %>">
        <label>Phone Number</label>
        <input name="phoneNumber" type="text" value="<\%= candidate ? candidate.get('phoneNumber') : '' %>">
        <label>EmailId</label>
        <input name="emailId" type="text" value="<\%= candidate ? candidate.get('emailId') : '' %>">
        <hr />
       <button type="submit" class="btn"><\%= candidate ? 'Update' : 'Create' %></button>
       <\% if(candidate) { %>
        <input type="hidden" name="id" value="<\%= candidate.get('id') %>" />
       <button data-candidate-id="<\%= candidate.id %>" class="btn btn-danger delete">Delete</button>
       <\%};%>
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

		var Candidates = Backbone.Collection.extend({
			url : '/candidates'
		});

		var Candidate = Backbone.Model.extend({
			urlRoot : '/candidates'
		});

		var CandidateListView = Backbone.View.extend({
			el : '.page',
			render : function() {
				var that = this;
				var candidates = new Candidates();
				candidates.fetch({
					success : function(candidates) {
						var template = _.template($('#candidate-list-template')
								.html(), {
							candidates : candidates.models
						});
						that.$el.html(template);
					}
				})
			}
		});

		var candidateListView = new CandidateListView();

		var CandidateEditView = Backbone.View.extend({
			el : '.page',
			events : {
				'submit .edit-candidate-form' : 'saveCandidate',
				'click .delete' : 'deleteCandidate'
			},
			saveCandidate : function(ev) {
				var candidateDetails = $(ev.currentTarget).serializeObject();
				var candidate = new Candidate();
				candidate.save(candidateDetails, {
					success : function(candidate) {
						router.navigate('', {
							trigger : true
						});
					}
				});
				return false;
			},
			deleteCandidate : function(ev) {
				this.candidate.destroy({
					success : function() {
						console.log('destroyed');
						router.navigate('', {
							trigger : true
						});
					}
				});
				return false;
			},
			render : function(options) {
				var that = this;
				if (options.id) {
					that.candidate = new Candidate({
						id : options.id
					});
					that.candidate.fetch({
						success : function(candidate) {
							var template = _.template($('#edit-candidate-template')
									.html(), {
								candidate : candidate
							});
							that.$el.html(template);
						}
					})
				} else {
					var template = _.template($('#edit-candidate-template').html(),
							{
								candidate : null
							});
					that.$el.html(template);
				}
			}
		});

		var candidateEditView = new CandidateEditView();

		var Router = Backbone.Router.extend({
			routes : {
				"" : "home",
				"edit/:id" : "edit",
				"new" : "edit",
			}
		});

		var router = new Router;
		router.on('route:home', function() {
			// render candidate list
			candidateListView.render();
		})
		router.on('route:edit', function(id) {
			candidateEditView.render({
				id : id
			});
		})
		Backbone.history.start();
	</script>


</body>
</html>

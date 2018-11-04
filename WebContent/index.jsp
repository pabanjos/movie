<!DOCTYPE html>
<html data-ng-app="movie">
<head>
	<title>Movie</title>
	<meta charset="utf-8">
	<link rel="icon" href="Imagens/play.png" type="image/x-icon">
	<link rel="stylesheet" href="font-awesome-4.6.1/css/font-awesome.min.css" />
	<link rel="stylesheet" href="CSS/css.css" />
	<script src="JS/angular.min.js"></script>
	<script src="JS/control.js"></script>
</head>
<body data-ng-controller="control" data-ng-init="listar()">
	<header>
		<nav id="left">
			<a href="" data-ng-click="search.what='TvShow';search.genre=''">TvShows <i class="fa fa-tv"></i></a>
			<a href="" data-ng-click="search.what='Game';search.genre=''">Games <i class="fa fa-gamepad"></i></a>
		</nav>
		<nav id="right">
			<a href="" data-ng-click="order='released';direction=!direction">Released <i class="fa fa-sort"></i></a>
			<a href="" data-ng-click="order='rating';direction=!direction">Rating <i class="fa fa-sort"></i></a>
		</nav>
		<nav id="center">
			<a href="" data-ng-click="search.what='Movie';search.genre='Animation'">Animation</a>
			<a href="" data-ng-click="search.what='Movie';search.genre='Children'">Children</a>
			<a href="" data-ng-click="search.what='Movie';search.genre='Adventure'">Adventure</a>
			<a href="" data-ng-click="search.what='Movie';search.genre='Comedy'">Comedy</a>
			<a href="" data-ng-click="search.what='Movie';search.genre='BasedOnHQ'">Based on HQ</a>
			<a href="" data-ng-click="search.what='Movie';search.genre='Action'">Action</a>
			<a href="" data-ng-click="search.what='Movie';search.genre='FeelGood'">Feel Good</a>
			<a href="" data-ng-click="search.what='Movie';search.genre='Drama'">Drama</a>
			<a href="" data-ng-click="search.what='Movie';search.genre='Sci-Fi'">Sci-Fi</a>
			<a href="" data-ng-click="search.what='Movie';search.genre='Terror'">Terror</a> <br />
			<input type="search" data-ng-click="search=''" data-ng-model="search.title" placeholder="Title..">
			<input type="search" data-ng-click="search=''" data-ng-model="search.director" placeholder="Director..">
			<input type="search" data-ng-click="search=''" data-ng-model="search.protagonist" placeholder="Protagonist..">
		</nav>
	</header>
	<section>
		<h2 data-ng-show="search.genre=='Animation'">Disney, Pixar, Dreamworks</h2>
		<figure data-ng-repeat="item in list | filter:search | orderBy:order:direction" class="{{item.what}}" data-ng-show="item.extra==''">
			<img data-ng-src="{{item.caminhoPoster}}" />
			<figcaption>
				<b>{{item.title}}</b>
				<p>{{item.released}}</p>
				<p data-ng-show="item.rating>1.0">{{item.rating}}</p>
			</figcaption>
		</figure>
		<h2 data-ng-show="search.genre=='Animation'">Animes</h2>
		<h2 data-ng-show="search.genre=='Terror'">Found Footage</h2>
		<h2 data-ng-show="search.genre=='BasedOnHQ'">Marvel</h2>
		<figure data-ng-repeat="item in list | filter:search | orderBy:order:direction" class="{{item.what}}" data-ng-show="item.extra!=''">
			<img data-ng-src="{{item.caminhoPoster}}" />
			<figcaption>
				<b>{{item.title}}</b>
				<p>{{item.released}}</p>
				<p data-ng-show="item.rating>1.0">{{item.rating}}</p>
			</figcaption>
		</figure>
		<aside>
			<form>
				<input type="text" data-ng-model="title" placeholder="title"> <br />
				<input type="text" data-ng-model="genre" placeholder="genre"> <br />
				<input type="text" data-ng-model="protagonist" placeholder="protagonist"> <br />
				<input type="text" data-ng-model="director" placeholder="director"> <br />
				<input type="text" data-ng-model="what" placeholder="what"> <br />
				<input type="text" data-ng-model="extra" placeholder="extra"> <br />
				<input type="text" data-ng-model="released" placeholder="released"> <br />
				<input type="text" data-ng-model="rating" placeholder="rating"> <br /> <br />
				<input type="button" data-ng-click="cadastrar()" value="Cadastrar" style="width:300px;">
			</form>
		</aside>
	</section>
</body>
</html>
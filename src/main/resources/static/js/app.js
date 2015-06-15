angular.module('shoppinglist', [ 'ui.router', 'ngResource',
		'shoppinglist.controllers', 'shoppinglist.services' ]);

angular.module('shoppinglist').config(function($stateProvider) {
	$stateProvider.state('items', { // state for showing all items
		url : '/items',
		templateUrl : 'partials/items.html',
		controller : 'ItemListController'
	}).state('viewItem', { // state for showing single item
		url : '/items/:id/view',
		templateUrl : 'partials/item-view.html',
		controller : 'ItemViewController'
	}).state('newItem', { // state for adding a new item
		url : '/items/new',
		templateUrl : 'partials/item-add.html',
		controller : 'ItemCreateController'
	}).state('editItem', { // state for updating a item
		url : '/items/:id/edit',
		templateUrl : 'partials/item-edit.html',
		controller : 'ItemEditController'
	});
}).run(function($state) {
	$state.go('items'); // make a transition to items state when app starts
});

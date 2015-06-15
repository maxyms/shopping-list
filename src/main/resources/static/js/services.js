angular.module('shoppinglist.services', []).factory('Item', function($resource) {
  return $resource('/api/items/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
});
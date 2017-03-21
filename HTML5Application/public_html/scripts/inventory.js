/* global angular */

// create the module, and load the ngResource (REST stubs) module
var module = angular.module('InventoryApp', ['ngResource']);

// create the controller and inject the Angular features that we need
module.controller('InventoryController', function ($scope, $resource) {
	//resource stub to work with inventory and summaries 
	/* The extra slashes are necessary because AngularJS uses colons as 
	 * placeholders for path variables. We need to escape the colon in front 
	 * of the port to stop AngularJS from trying 
	 * to use the port as a variable. 
	 */
	var inventoryResource = $resource('http://localhost\\:8081/products');
	
	//gets the summaries from the service using the resource stub
	$scope.summaries = inventoryResource.get();

   
  
   $scope.displaySelectedProduct = function() {
		//is there a valid summary selected?
		if($scope.selected !== null) {
			//gets the URI of the selected summary
			var uri = $scope.selected.uri;
		
		  //uses URI to GET the product and put it in the model
		  $scope.product = $resource(uri).get();
		} else {
			//if not, clear the existing product
			$scope.product = null;
		}

   };

   $scope.createProduct = function() {

   };

   $scope.deleteSelectedProduct = function() {

   };
  
   $scope.updateSelectedProduct = function() {
       
   };

});

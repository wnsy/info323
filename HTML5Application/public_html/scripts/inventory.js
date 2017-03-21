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
		
		  //use URI to GET the product stub from the service & put it in the model
		  //This adds the $update method to the stub and tells it to use the
		  //PUT method when it sends the request
		  $scope.product = $resource(uri, null, {update: {method: 'PUT'}}).get();
		} else {
			//if not, clear the existing product
			$scope.product = null;
		}

   };

   $scope.createProduct = function() {
		//Code will marshal he details in the product model ino JSON and POST
		//it to he service
	//inventoryResource.save($scope.product);
		
		/**
		 * We need to ensure that the POST has completed before we GET the new
		 * summaries. This means that we need to perform the GET inside the 
		 * response callback for the POST since this is the only place that 
		 * we can be certain that the POST has completed.
		 * This code also adds a message to the page using the 
		 * $scope.messages template.
		 */
		inventoryResource.save($scope.product,
		//response callback
		function() {
			//GET the latest summaries from service
			$scope.summaries.$get();
			
			//notify the user
			$scope.messages = "New product '" + $scope.product.name
			+ "' was successfully created.";
		}
		);
   };

   $scope.deleteSelectedProduct = function() {
		// do nothing if there is no valid product selected
		if($scope.product === null) return;
		
		$scope.product.$remove(
				  //response callback
				  function() {
					  //update the summaries
					  $scope.summaries.$get();
					  
					  //notify the user
					  $scope.messages = "Product '" + $scope.product.name
					  + "' was successfully deleted.";
			        
					  //clear the models since we just deleted the product from
					  //the service
					  $scope.product = null;
					  $scope.selected = null;
				  }
				  );
   };
  
   $scope.updateSelectedProduct = function() {
		//do nothing if there is no valid product selected
		if($scope.product === null) return;
		
		$scope.product.$update(
				  //response callback
				  function() {
					  //update the summaries
					  $scope.summaries.$get();
					  
					  //notify the user
					  $scope.messages = "Product '" + $scope.product.name 
					  + "' was successfully updated.";
				  },
				  
				  //error callback
				  function(response) {
					  var message = response.data; //msg will contain the error msg
					  
					  //error code goes here
					  $scope.messages = message;
					  
					  //force a refresh since we probably have outdated data
					  $scope.summaries.$get();
				  }
				  );
	
   };

});

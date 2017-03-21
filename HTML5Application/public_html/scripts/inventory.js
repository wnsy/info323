/* global angular */

// create the module, and load the ngResource (REST stubs) module
var module = angular.module('InventoryApp', ['ngResource']);

// create the controller and inject the Angular features that we need
module.controller('InventoryController', function ($scope, $resource) {
	$scope.summaries = {
  "product_summary" : [
    {
      "id" : "FD1234",
      "name" : "Freckled Doohicky",
      "uri" : "http://localhost:8081/products/FD1234"
    },
    {
      "id" : "WF3412",
      "name" : "Wuzzy Fidget",
      "uri" : "http://localhost:8081/products/WF3412"
    },
    {
      "id" : "FW4321",
      "name" : "Fuzzy Widget",
      "uri" : "http://localhost:8081/products/FW4321"
    }
  ]
}
			  

   
  
   $scope.displaySelectedProduct = function() {

   };

   $scope.createProduct = function() {

   };

   $scope.deleteSelectedProduct = function() {

   };
  
   $scope.updateSelectedProduct = function() {
       
   };

});

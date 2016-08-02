<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html ng-app="myApp">
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0-rc.3/angular.js"></script>
</head>
<body>

  <h1>Wrong Way</h1>
  <img src="{{imgSrc}}" />

  <h1>Right way</h1>
  <img ng-src="{{imgSrc}}" />


  <script>
    angular.module('myApp', [])
    .run(function($rootScope, $timeout) {

      $timeout(function() {
        $rootScope.imgSrc = 'https://www.google.com/images/srpr/logo11w.png';
      }, 2000);

    });
  </script>

</body>
</html>
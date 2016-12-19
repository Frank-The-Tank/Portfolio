angular.module("desktop", [])

    // First Page You See on Enter
    .controller("MainScreen", function($scope) {

    })

    .directive("display", function() {
        return {
            restrict: "E",
            templateUrl: "desktop-main.html"
        };
    })

    .directive("textDisplay", function() {
        return {
            restrict: "E",
            templateUrl: "main-text.html"
        }
    })


angular.module("mainPageDesktop", [])

    .controller("MainPage", function($scope) {

        $scope.view = "default";
        $scope.text= "default";
        $scope.product="default";
        $scope.background="default";
    })

        .directive("backgroundPic", function() {
            return {
                restrict: "E",
                templateUrl: "background-pic.html"
            };
        })

        .directive("secondBarDisplay", function() {
            return {
                restrict: "E",
                templateUrl: "second-bar-display.html"
            };
         })

        .directive("topBarDisplay", function() {
            return {
                restrict: "E",
                templateUrl: "top-bar-display.html"
            };
        })

        .directive("bottomBarDisplay", function() {
            return {
                restrict: "E",
                templateUrl: "bottom-bar-display.html"
            };
        })

        .directive("productGallery", function() {
            return {
                restrict: "E",
                templateUrl: "product-gallery.html"
            };
        })

        .directive("productPopup", function() {
            return {
                restrict: "E",
                templateUrl: "product-popup.html"
            };
        })


$(document).ready(function() {

    $(window).scroll(function() {
        if($(window).scrollTop() + $(window).height() == $(document).height()) {
            $(".nextArrow").css("display", "inline").fadeIn("slow");
        } else {
            $(".nextArrow").css("display", "inline").fadeOut("slow");
        }
    });
});
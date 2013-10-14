/*global angular*/
(function() {
"use strict";
angular.module("todosApp-directives").directive('focusOn', function ($timeout) {
    return function (scope, elem, attrs) {
        scope.$watch(attrs.focusOn, function (newVal) {
            if (newVal) {
                $timeout(function () {
                    elem[0].focus();
                }, 0, false);
            }
        });
    };
});
angular.module("todosApp-directives").directive('onBlur', function () {
    return function (scope, elem, attrs) {
        elem.bind('blur', function () {
            scope.$apply(attrs.onBlur);
        });
    };
});
}());

var myApp = angular.module('myApp', []);

myApp.controller("appController", ['$scope', '$http', function ($scope, $http,  $window) {
    $scope.getCurrencyData = function() {
        $scope.loading = true;
        $scope.refreshButton = false;
        $http.get('/currencydata').then(successCallback, errorCallback);
        function successCallback(response) {
            $scope.Currencies = response.data.Currencies;
            $scope.time = response.data.time;
            $scope.loading = false;
            $scope.refreshButton = true;
            $scope.fromCurrency = $scope.Currencies[0];
            $scope.fromChecked = true;
            $scope.setSelect2();
        }
        function errorCallback(error) {
            $scope.error = error;
            $scope.loading = false;
        }
    }
    $scope.setSelect2 = function() {
        $("#fromCurrency").select2().select2('val','AUD');
        $("#jaja").select2();
    }
    $scope.convertCurrency = function() {
        if(this.fromCurrency.rate != null && this.amount != null) {
            if (Number(this.amount) > 0) {
                if (this.fromEuro) {
                   var converterValue = (Number(this.amount) * Number(this.fromCurrency.rate)).toFixed(2);
                   $scope.result = this.amount + " EUR = " + converterValue + " " + this.fromCurrency.currency;
                } else {
                    var converterValue = (Number(this.amount) / Number(this.fromCurrency.rate)).toFixed(2);
                    $scope.result = this.amount + " " + this.fromCurrency.currency + " = " + converterValue + " EUR";
                }
            }
        }
    }
    $scope.checkUncheck = function(val) {
        if(val == '1'){
            $scope.fromEuro=true;
            $scope.toEuro=false;
        }
        if(val == '2'){
            $scope.toEuro=true;
            $scope.fromEuro=false;
        }
    }
    $scope.getCurrencyData();
    $scope.fromEuro=true;
    $scope.toEuro=false;
}]);



var app = angular.module('app', []);
app.controller('Postcontroller', function($scope, $http, $location) {
	$scope.submitProfessionForm = function(){
        var mainUrl = $location.protocol() + "://"+
              $location.host()+":"+$location.port();
        var url = mainUrl+"/professions";

		var data = {
            professionName: $scope.professionName
        };

        var successCallBack = function(response){
            $scope.postResultMessage = response.data;
            window.location.assign(mainUrl);
        };
        var errorCallBack = function(response){
            $scope.postResultMessage = "Error with status: " +  response.statusText;
        };

		$http.post(url, data).then(successCallBack, errorCallBack);
		$scope.professionName = "";
	}

	$scope.data = {
	    selectedProfessionId:null
	};

	$scope.submitClientForm = function(){
	        var mainUrl = $location.protocol() + "://"+
                $location.host()+":"+$location.port();
	        var url = mainUrl+"/clients";

    		var data = {
                name: $scope.name,
                age: $scope.age,
                professionId: $scope.data.selectedProfessionId
            };

            var successCallBack = function(response){
                $scope.postResultMessage = response.data;
                window.location.assign(mainUrl);
            };
            var errorCallBack = function(response){
                $scope.postResultMessage = "Error with status: " +  response.statusText;
            };

    		$http.post(url, data).then(successCallBack, errorCallBack);
    		$scope.professionName = "";
    	}

    	$scope.getProfessions = function(){
            var mainUrl = $location.protocol() + "://"+
                $location.host()+":"+$location.port();
            var url = mainUrl+"/professions";

            $http.get(url).then(function (response){
                $scope.professions = response.data;
            }, function error(response){
                $scope.postResultMessage = "Error with status: " +  response.statusText;
            });

        }
});

app.controller('DataController', function($scope, $http, $location) {
	$scope.deleteClient = function(clientId){
            var url = $location.absUrl() + "clients/"+clientId;

            var successCallBack = function(response){
                $scope.getClients();
            };
            var errorCallBack = function(response){
                $scope.postResultMessage = "Error with status: " +  response.statusText;
            };
            $http.delete(url).then(successCallBack, errorCallBack);
    };

	$scope.getClients = function(){
            var url = $location.absUrl() + "clientsInfo";

            var successCallBack = function(response){
                $scope.clients = response.data;
                console.log($scope.clients);
            };
            var errorCallBack = function(response){
                $scope.postResultMessage = "Error with status: " +  response.statusText;
            };
    	    $http.get(url).then(successCallBack, errorCallBack);
    };

    $scope.getStyleFromTelephonesCount = function(telephonesCount){
        switch(telephonesCount)
        {
            case 0: return "red";
            case 1: return "yellow";
            case 2: return "green";
            default: return "blue";
        }
    }

    $scope.getTelephonesClient = function(client){
         var mainUrl = $location.protocol() + "://"+
            $location.host()+":"+$location.port();
         var url = mainUrl+"/clients/"+client.id+"/clients_telephones";

         $http.get(url).then(function (response){
                $scope.clientTelephones = response.data;
         }, function error(response){
                $scope.postResultMessage = "Error with status: " +  response.statusText;
         });
    };

    $scope.submitAdditionalClientTelephone = function(){
        var mainUrl = $location.protocol() + "://"+
            $location.host()+":"+$location.port();
        var url = mainUrl+"/clients_telephones";

        var data = {
            number: $scope.number,
            clientId: $scope.selectedClient.id
        };

        console.log($scope.number);

        var successCallBack = function(response){
            if(response.data != ""){
                $scope.postResultMessage = "Pomyślnie dodano numer.";
            }
            else{
                $scope.postResultMessage = "Istnieje już taki numer w bazie.";
            }
        };
        var errorCallBack = function(response){
            $scope.postResultMessage = "Error with status: " +  response.statusText;
        };

        $http.post(url, data).then(successCallBack, errorCallBack);
        $scope.number = "";
    };

    $scope.isClientSelected = function(client){
        return $scope.selectedClient == client;
    };

    $scope.selectClient = function(client){
        $scope.selectedClient = client;
    };
});
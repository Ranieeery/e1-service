(function() {

    'use strict';

    var ReceiptService = function ($resource, BASE_REST_URL_REPORT) {
        return $resource(BASE_REST_URL_REPORT + 'receipt-list',{},
            {
                query: {
                    isArray: false
                },
                headers:{
                    'Access-Control-Allow-Origin' : '*'
                }
            });
    };


    angular.module('reportApp')
        .service('ReceiptService', ReceiptService);
})();

